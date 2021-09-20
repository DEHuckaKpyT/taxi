package study.taxi.service.smsService;

import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;

public class SmsServiceImpl implements SmsService {
    @Override
    public void send(String number, String text) {
        Twilio.init(System.getenv("ACCOUNT_SID"), System.getenv("AUTH_TOKEN"));
        Message message = Message.creator(
                        new PhoneNumber(System.getenv("PHONE_NUMBER")),
                        new PhoneNumber("+18302823260"),
                        "надолго стартовых денег, конечно, не хватит :(")
                .create();
    }
}
