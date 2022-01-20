package com.Vijay.Gluer.Service;

import com.Vijay.Gluer.Exceptions.UserRegistrationException;
import com.Vijay.Gluer.Model.UserRegistration;
import com.Vijay.Gluer.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

@Service
public class UserRegistrationServiceImpl implements UserRegistrationService{


    private UserRepository userRepository;
    private EncryptionService encryptionService=new EncryptionService();

    @Autowired
    public UserRegistrationServiceImpl(UserRepository userRepository){
        this.userRepository=userRepository;
    }



    @Override
    public String saveUser(UserRegistration userRegistration) throws UserRegistrationException{
        UserRegistration saved=new UserRegistration();
        String result=new String();
        userRegistration.setValidated("No");
                if (!(userRepository.existsById(userRegistration.getEmail()))) {
                    if((userRegistration.getEmail().substring(userRegistration.getEmail().length() - 4, userRegistration.getEmail().length()).equals(".com")) &&
                            (userRegistration.getConfirmpass().equals(userRegistration.getPassword()))){
                        userRegistration.setEncyptor(encryptionService.encyptedEmail(userRegistration.getEmail()));
                            saved = userRepository.save(userRegistration);
                            sendMail(userRegistration.getEmail());
                    result = "User Saved Successfully";}
                    else {
                        result="Wrong Email or Password Credentials";
                    }
                } else {
                    result = "User Already Exists";
                }


        return result;
    }

    @Override
    public UserRegistration getUser(String Email) {
        UserRegistration allById=userRepository.findById(Email).get();
        return allById;
    }

    @Override
    public String updateUserValidation(String Encrypted) {
        UserRegistration userRegistration=new UserRegistration();
        String email=encryptionService.decrypt(Encrypted);
//        UserRegistration allByEncryptor = userRepository.findAllByEncryptor(Encrypted);
//        System.out.println(allByEncryptor.getEmail());
        UserRegistration validate = userRepository.findById(email).get();
        userRegistration.setValidated("Yes");
        validate.setValidated(userRegistration.getValidated());
        userRepository.save(validate);
        return "User Registered Successfully, Go to Login Page";
    }


    @Override
    public String updateUserValidation2(String Encrypted) {
        UserRegistration userRegistration=new UserRegistration();
        String email=encryptionService.decryptAnother(Encrypted);
//        UserRegistration allByEncryptor = userRepository.findAllByEncryptor(Encrypted);
//        System.out.println(allByEncryptor.getEmail());
        UserRegistration validate = userRepository.findById(email).get();
        userRegistration.setValidated("Yes");
        validate.setValidated(userRegistration.getValidated());
        userRepository.save(validate);
        return "User Registered Successfully, Go to Login Page";
    }




    @Override
    public String updateUserValidation3(String Encrypted) {
        UserRegistration userRegistration=new UserRegistration();
        String email=encryptionService.decryptAnother3(Encrypted);
//        UserRegistration allByEncryptor = userRepository.findAllByEncryptor(Encrypted);
//        System.out.println(allByEncryptor.getEmail());
        UserRegistration validate = userRepository.findById(email).get();
        userRegistration.setValidated("Yes");
        validate.setValidated(userRegistration.getValidated());
        userRepository.save(validate);
        return "User Registered Successfully, Go to Login Page";
    }


    @Override
    public String updateUserOnSlashValidation(String email) {
        UserRegistration userRegistration=new UserRegistration();
//        UserRegistration allByEncryptor = userRepository.findAllByEncryptor(Encrypted);
//        System.out.println(allByEncryptor.getEmail());
        UserRegistration validate = userRepository.findById(email).get();
        userRegistration.setValidated("Yes");
        validate.setValidated(userRegistration.getValidated());
        userRepository.save(validate);
        return "User Registered Successfully, Go to Login Page";

    }

    @Override
    public String updateRegisteredName(String Email, UserRegistration userRegistration) {
        UserRegistration updateNameRegistered=userRepository.findById(Email).get();
        updateNameRegistered.setName(userRegistration.getName());
        userRepository.save(updateNameRegistered);
        return "User Name Updated Successfully";
    }

    @Override
    public String updateRegisteredPassword(String Email, UserRegistration userRegistration) {
        UserRegistration updatePasswordRegistered=userRepository.findById(Email).get();
        String password = updatePasswordRegistered.getPassword();
        updatePasswordRegistered.setPassword(userRegistration.getPassword());
        updatePasswordRegistered.setConfirmpass(userRegistration.getConfirmpass());
        if(updatePasswordRegistered.getPassword().equals(updatePasswordRegistered.getConfirmpass()) &&
                !password.equals(updatePasswordRegistered.getPassword())){
            userRepository.save(updatePasswordRegistered);
            return "Password registered Successfully";
        }
        else if(password.equals(updatePasswordRegistered.getPassword())){
            return "No Changes Made in password, using the same old password";
        }
        else {
            return "Password and its conformation are not same,please check and re-enter";
        }


    }

    @Override
    public String deleteUser(String email) {
        UserRegistration forDeletion = userRepository.findById(email).get();
        userRepository.deleteById(email);
        return "Deleted Successfully";
    }


    public void sendMail(String email){

// Recipient's email ID needs to be mentioned.
        String to = email;

        // Sender's email ID needs to be mentioned
        String from = "pruthvikrishna97@gmail.com";

        // Assuming you are sending email from through gmails smtp
        String host = "smtp.gmail.com";

        // Get system properties
        Properties properties = System.getProperties();

        // Setup mail server
        properties.put("mail.smtp.host", host);
        properties.put("mail.smtp.port", "465");
        properties.put("mail.smtp.ssl.enable", "true");
        properties.put("mail.smtp.auth", "true");

        // Get the Session object.// and pass username and password
        Session session = Session.getInstance(properties, new javax.mail.Authenticator() {

            protected PasswordAuthentication getPasswordAuthentication() {

                return new PasswordAuthentication("pruthvikrishna97@gmail.com", "zilslxquysrpsnlf");

            }

        });

        // Used to debug SMTP issues
        session.setDebug(true);

        try {
            // Create a default MimeMessage object.
            MimeMessage message = new MimeMessage(session);

            // Set From: header field of the header.
            message.setFrom(new InternetAddress(from));

            // Set To: header field of the header.
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));

            // Set Subject: header field
            message.setSubject("Glue User- Welcome and Validate");

            // Now set the actual message
            message.setText("Please Verify using following link:");

            String linkText=new String();

            String encryptedString = encryptionService.encyptedEmail(email);
            String encryptedString2=encryptionService.encryptionEmail2(email);
            String encryptedString3=encryptionService.encryptionEmail3(email);
            if(!encryptedString.contains("/")){
                linkText=("http://localhost:8071/gluser/verify/"+encryptedString);
            }
//            String Original=new String();
//            try {
//                encryptedString=encyptedEmail(email);
//                if(encryptedString.contains("/")){
//                    Original=encryptedString.replaceAll("/","%20");
//                }
//                else {
//                    Original=encyptedEmail(email);
//                }
//            }catch (Exception e){
//                e.printStackTrace();
//            }
//            String encryptedString = encyptedEmail(email);
            else if(!encryptedString2.contains("/")){
                    linkText=("http://localhost:8071/gluser/verify2/" + encryptedString2);
            }
            else if(!encryptedString3.contains("/")){
                linkText=("http://localhost:8071/gluser/verify3/" + encryptedString3);
            }
            else {
                linkText=("http://localhost:8071/gluser/glueme/verify/"+email);
            }
            message.setText(linkText);
            System.out.println("sending...");
            // Send message
            Transport.send(message);
            System.out.println("Sent message successfully....");
        } catch (MessagingException mex) {
            mex.printStackTrace();
        }

    }



//    return emailStringEncrypted;
}


