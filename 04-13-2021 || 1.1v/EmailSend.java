/**
 * This class is made based from an online source referenced from the link:
 * https://www.javatpoint.com/example-of-sending-email-using-java-mail-api
 *
 * This class is used to compose an email and send it to an email address.
**/

import java.util.Properties;
import java.util.Scanner;
import javax.mail.*;
import javax.mail.internet.*;

// Class that edits the settings for sending the details of the
// email like the recipient, subject, contents, account of the sender,
// and the password of the said account.
class Email{
    public static void send(String from,String password,String to,String sub,String msg){
        Properties props = new Properties();
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.socketFactory.port", "465");
        props.put("mail.smtp.socketFactory.class",
                "javax.net.ssl.SSLSocketFactory");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.port", "465");

        Session session = Session.getDefaultInstance(props,
                new javax.mail.Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(from,password);
                    }
                });
        try {
            MimeMessage message = new MimeMessage(session);
            message.addRecipient(Message.RecipientType.TO,new InternetAddress(to));
            message.setSubject(sub);
            message.setText(msg);
            Transport.send(message);
            System.out.println("Message was successfully sent to "+to);
        } catch (MessagingException e) {throw new RuntimeException(e);}
    }
}

public class EmailSend{
    public static void main(String[] args) {
        // Create a Scanner variable for getting the input of the
        // user.
        Scanner scan = new Scanner(System.in);
        // Use the Scanner variable to store the input into string
        // and later use the strings to the send() method in the
        // Email class.
        System.out.print(">Enter your email address: ");
        String fromEmail = scan.nextLine();
        System.out.print(">Enter your password: ");
        String password = scan.nextLine();
        System.out.print(">Enter email of recipient: ");
        String toEmail = scan.nextLine();
        System.out.print(">Enter subject of email: ");
        String emailSubject = scan.nextLine();
        System.out.println(">Enter message: ");
        String msg = scan.nextLine();
        System.out.println("\nProcessing...\n");
        Email.send(fromEmail,password,toEmail,emailSubject,msg);
    }
}