package com.paymaster.service;

import com.paymaster.factory.MetodoPago;
import com.paymaster.factory.PaymentFactory;
import com.paymaster.repository.IPaymentRepository;

public class PaymentService {

    private IPaymentRepository repository;

    public PaymentService(IPaymentRepository repository) {
        this.repository = repository;
    }
    public void checkout(double amount, String type) {
        MetodoPago payment = PaymentFactory.createPayment(type);
        payment.realizarPago(amount);
        repository.saveTransaction(
                "Monto: " + amount + ", Tipo: " + type
        );
    }
}