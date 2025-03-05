package service;

import org.springframework.stereotype.Service;

@Service
public class DeliveryService {

    public void processDelivery() {
        try {
            Thread.sleep(1753);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Заказ доставлен");
    }
}
