package com.paymaster.factory;

public class PaymentFactory {

    public static MetodoPago createPayment(String type) {
        switch (type.toUpperCase()) {
            case "EFECTIVO":
                return new PagoEfectivo();
            case "TARJETA":
                return new PagoTarjeta();
            default:
                throw new IllegalArgumentException("Tipo de pago inválido");
        }
    }
}