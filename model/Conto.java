/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.sistema_bancario_criptovalute.model;

/**
 *
 * @author david
 */
public abstract class Conto {

    private String iban;
    private double saldo;

    public Conto(String iban, double saldoIniziale) {
        this.iban = iban;
        this.saldo = saldoIniziale;
    }

    public String getIban() {
        return iban;
    }

    public void setIban(String iban) {
        this.iban = iban;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public abstract void deposita(double importo);

    public abstract void preleva(double importo);

    @Override
    public String toString() {
        return "Conto{"
                + "IBAN='" + iban + '\''
                + ", saldo=" + saldo
                + '}';
    }

}
