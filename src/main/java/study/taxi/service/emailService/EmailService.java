package study.taxi.service.emailService;

public interface EmailService {

    void sendTextMessage(String to, String subject, String text);
}
