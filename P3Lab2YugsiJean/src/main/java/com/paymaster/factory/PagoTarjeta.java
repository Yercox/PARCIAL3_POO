package com.paymaster.factory;
public class PagoTarjeta implements MetodoPago {

    @Override
    public void realizarPago(double amount) {
        System.out.println("Pago con TARJETA por $" + amount);
    }
}
