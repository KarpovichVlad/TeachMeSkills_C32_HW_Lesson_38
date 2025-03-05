package service;

import login.TrackTime;
import org.springframework.stereotype.Service;

@Service
public class PaymentService {

    @TrackTime
    public void processPayment() {
        try {
            Thread.sleep(537);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Оплата получена");
    }
}
