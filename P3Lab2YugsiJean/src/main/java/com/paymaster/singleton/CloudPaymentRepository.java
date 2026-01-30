package com.paymaster.singleton;
import com.paymaster.repository.IPaymentRepository;

public class CloudPaymentRepository implements IPaymentRepository {

    @Override
    public void saveTransaction(String details) {
        TransactionLogger
                .getInstance()
                .log("Guardando en la nube: " + details);
    }
}