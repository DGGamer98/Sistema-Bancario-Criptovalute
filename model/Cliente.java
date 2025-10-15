/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.sistema_bancario_criptovalute.model;

import java.util.List;
import java.util.ArrayList;

/**
 *
 * @author david
 */
public class Cliente {

    private String nome;
    private String cognome;
    private String codiceFiscale;
    private List<Conto> conti = new ArrayList<Conto>();

   
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCognome() {
        return cognome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public String getCodiceFiscale() {
        return codiceFiscale;
    }

    public void setCodiceFiscale(String codiceFiscale) {
        this.codiceFiscale = codiceFiscale;
    }

    public List<Conto> getConti() {
        return conti;
    }

    public void setConti(List<Conto> conti) {
        this.conti = conti;
    }

    //TODO Davide: Creare i metodi: Metodi: aggiungi conto, rimuovi conto, calcola patrimonio totale (anche in crypto!).
    public void aggiungiConto() {
        for (Conto conto : conti) {
            conti.add(conto);
        }
    }

    public boolean rimuoviConto(String iban) {
        for (Conto conto : conti) {
            if (conto.getIban().equals(iban)) {
                conti.remove(conto);
                System.out.println("Conto rimosso");
                return true;
            }
        }
        System.err.println("Errore!");
        return false;
    }

    

    public double calcoloPatrimonioTot() {
        double totale = 0.0;
        for (Conto conto : conti) {
            if (conto instanceof walletCripto) {
                walletCripto wallet = (walletCripto) conto; // 4️⃣ facciamo il "cast" da Conto a walletCripto (così possiamo accedere ai metodi specifici del wallet).
                totale += wallet.getSaldo();
            } else {
                totale += conto.getSaldo();
            }
        }
        return totale;
    }

    @Override
    public String toString() {
        return "Cliente{"
                + "nome=" + nome
                + ", cognome=" + cognome
                + ", codiceFiscale=" + codiceFiscale
                + ", conti=" + conti
                + '}';
    }

}
