/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.sistema_bancario_criptovalute.model;

/**
 *
 * @author david
 */
public class contoCorrente extends Conto {

    private int tassoDiInteresse;

    public contoCorrente(String iban, double saldoIniziale) {
        super(iban, saldoIniziale);
    }

    @Override
    public void deposita(double importo) {
        if (importo > 0) {
            setSaldo(getSaldo() + importo);
            System.out.println("Depositati " + importo + "€. Nuovo saldo: " + getSaldo() + "€");
        } else {
            System.out.println("Errore");
        }
    }

    @Override
    public void preleva(double importo) {
        if(importo <= 0) {
            System.out.println("Saldo insufficiente");
        } else {
            setSaldo(getSaldo() - importo);
            System.out.println("Prelevati " + importo + "€. Nuovo saldo: " + getSaldo());
        }
    }

}
