package com.Vijay.GlueChatter.EventListeners;

import com.Vijay.GlueChatter.ChatModel.ChatMessages;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.EventListener;
import org.springframework.messaging.simp.SimpMessageSendingOperations;
import org.springframework.messaging.simp.stomp.StompHeaderAccessor;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.messaging.SessionConnectedEvent;
import org.springframework.web.socket.messaging.SessionDisconnectEvent;

import java.util.logging.Logger;

@Component
public class WebSocketEventLitener {
    private static final Logger logger= (Logger) LoggerFactory.getLogger(WebSocketEventLitener.class);

    @Autowired
    private SimpMessageSendingOperations messageSendingOperations;

    @EventListener
    public void handleWebSocketConnections(SessionConnectedEvent event){
        logger.info("Received a new websocket connection");
    }

    @EventListener
    public void handleWebSocketDisconnectListener(SessionDisconnectEvent event){
        StompHeaderAccessor headerAccessor=StompHeaderAccessor.wrap(event.getMessage());
        String userName= (String) headerAccessor.getSessionAttributes().get("username");
        if(userName!=null){
            logger.info("User Disconnected: "+userName);
            ChatMessages chatMessages=new ChatMessages();
            chatMessages.setType(ChatMessages.MessageType.LEAVE);
            chatMessages.setSender(userName);
            messageSendingOperations.convertAndSend("/topic/public",chatMessages);
        }
    }

}
