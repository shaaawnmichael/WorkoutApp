package workout.exerciseapp.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import workout.exerciseapp.model.ContactUs;

@Service
public class EmailService {

    private JavaMailSender javaMailSender;

    @Autowired
    public EmailService(JavaMailSender javaMailSender){
        this.javaMailSender = javaMailSender;
    }

    public void sendEmail(ContactUs contactus) throws MailException {
        SimpleMailMessage mail = new SimpleMailMessage();
        mail.setTo(contactus.getEmail());
        mail.setFrom("shawn.wongkj@gmail.com");
        mail.setSubject(contactus.getSubject());
        mail.setText(contactus.getEnquiry());

        javaMailSender.send(mail);
    }

}
