package com.paymaster.main;

import com.paymaster.service.PaymentService;
import com.paymaster.singleton.CloudPaymentRepository;

public class Main {

    public static void main(String[] args) {

        PaymentService service =
                new PaymentService(new CloudPaymentRepository());
        System.out.println("SISTEMA DE PAGOS YUGSI ");
        System.out.println("-------------------------------------------");
        service.checkout(1050.0, "EFECTIVO");
        service.checkout(250.0, "TARJETA");
        System.out.println("-------------------------------------------");
    }
}