package service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderService {

    private final DeliveryService deliveryService;
    private final PaymentService paymentService;

    @Autowired
    public OrderService(DeliveryService deliveryService, PaymentService paymentService) {
        this.deliveryService = deliveryService;
        this.paymentService = paymentService;
    }

    public void createOrder(String product) {
        System.out.println("Заказ создан: " + product);

        deliveryService.processDelivery();
        paymentService.processPayment();
    }
}
