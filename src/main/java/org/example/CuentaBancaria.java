package org.example;

public class CuentaBancaria {
    private String titular;
    private double saldo;
    private String numeroCuenta;


    public CuentaBancaria(String titular, double saldo, String numeroCuenta) {
        this.titular = titular;
        this.saldo = saldo;
        this.numeroCuenta = numeroCuenta;
    }


    public void depositar(double cantidad) {
        if (cantidad > 0) {
            saldo += cantidad;
            System.out.println("Depósito exitoso. Nuevo saldo: " + saldo);
        } else {
            System.out.println("La cantidad a depositar debe ser positiva.");
        }
    }


    public void retirar(double cantidad) {
        if (cantidad > 0 && cantidad <= saldo) {
            saldo -= cantidad;
            System.out.println("Retiro exitoso . Nuevo saldo: " + saldo);
        } else if (cantidad <= 0) {
            System.out.println("La cantidad a retirar debe ser positiva.");
        } else {
            System.out.println("Saldo insuficiente para realizar el retiro.");
        }
    }


    public void mostrarInformacion() {
        System.out.println("Titular: " + titular);
        System.out.println("Número de cuenta: " + numeroCuenta);
        System.out.println("Saldo: " + saldo);
    }

    public String getNumeroCuenta() {
        return numeroCuenta;
    }

    public void setNumeroCuenta(String numeroCuenta) {
        this.numeroCuenta = numeroCuenta;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public String getTitular() {
        return titular;
    }

    public void setTitular(String titular) {
        this.titular = titular;
    }
}
