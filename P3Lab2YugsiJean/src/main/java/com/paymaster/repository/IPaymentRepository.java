package com.paymaster.repository;

public interface IPaymentRepository {
    void saveTransaction(String details);
}