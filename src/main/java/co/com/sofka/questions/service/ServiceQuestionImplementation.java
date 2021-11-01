package co.com.sofka.questions.service;

import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public class ServiceQuestionImplementation implements ServiceQuestion{

    private final JavaMailSender javaMailSender;


    public ServiceQuestionImplementation(JavaMailSender javaMailSender) {
        this.javaMailSender = javaMailSender;
    }

    @Override
    public Mono<String> enviarCorreo(String correoDestino, String asunto, String cuerpo) {
        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        simpleMailMessage.setFrom("aquestion362@gmail.com");
        simpleMailMessage.setTo(correoDestino);
        simpleMailMessage.setSubject(asunto);
        simpleMailMessage.setText(cuerpo);
        javaMailSender.send(simpleMailMessage);
        return Mono.just("El mesaje ha sido enviado");

         }
}
