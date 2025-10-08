/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.cajeromvc.modelo;

/**
 *
 * @author Sergio Aboytia
 */
public class Cuenta {
    private String nombre;
    private String numeroCuenta;
    private double saldo;

    public Cuenta(String nombre, String numeroCuenta, double saldo) {
        this.nombre = nombre;
        this.numeroCuenta = numeroCuenta;
        this.saldo = saldo;
    }

    public String getNombre() {
        return nombre;
    }

    public String getNumeroCuenta() {
        return numeroCuenta;
    }

    public double getSaldo() {
        return saldo;
    }

    public void retirar(double monto, double comision) {
        this.saldo -= (monto + comision);
    }
}
