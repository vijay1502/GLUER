import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-chatters',
  templateUrl: './chatters.component.html',
  styleUrls: ['./chatters.component.css']
})
export class ChattersComponent implements OnInit {

  usernamePage = document.querySelector('#username-page');
  chatPage = document.querySelector('#chat-page');
  usernameForm = document.querySelector('#usernameForm');
  messageForm = document.querySelector('#messageForm');
  messageInput = document.querySelector('#message');
  messageArea = document.querySelector('#messageArea');
  connectingElement = document.querySelector('.connecting');

  stompClient=null;
  username=null;
  constructor() { }

  ngOnInit(): void {
  }

}
