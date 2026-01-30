package com.paymaster.factory;
public class PagoEfectivo implements MetodoPago {

    @Override
    public void realizarPago(double amount) {
        System.out.println("Pago en EFECTIVO por $" + amount);
    }
}