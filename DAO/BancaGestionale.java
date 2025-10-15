/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.sistema_bancario_criptovalute.DAO;

import com.mycompany.sistema_bancario_criptovalute.model.Cliente;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author david
 */

/*
Classe BancaGestionale (DAO semplificato)
    - aggiungiCliente(Cliente c)
    - visualizzaClienti()
    - aggiornaCliente(String codiceFiscale, Cliente nuovoCliente)
    - eliminaCliente(String codiceFiscale)
    - ricercaCliente(String codiceFiscale)
 */
public class BancaGestionale {

    private List<Cliente> clienti = new ArrayList<>();

    public Cliente addCliente(Cliente c) {
        for (Cliente cliente : clienti) {
            clienti.add(c);
            return cliente;
        }
        return null;
    }

    public void visualClient() {
        for (Cliente cliente : clienti) {
            System.out.println(cliente);            
        }
    }

    public boolean updateClient(String codiceFiscale, Cliente nuovoCliente) {
        for (Cliente cliente : clienti) {
            if (cliente.getCodiceFiscale().equals(codiceFiscale)) {
                cliente.setNome(nuovoCliente.getNome());
                cliente.setCognome(nuovoCliente.getCodiceFiscale());
                cliente.setCodiceFiscale(nuovoCliente.getCodiceFiscale());
                System.out.println("Cliente aggiornato");
                return true;
            }
        }
        System.err.println("Errore nel aggiornare il cliente");
        return false;
    }
    
    
    public void deleteClient(String codiceFiscale) {
        for (Cliente cliente : clienti) {
            if(cliente.getCodiceFiscale().equals(codiceFiscale)) {
                clienti.remove(cliente);
            }
        }
    }
    
    public Cliente ricercaCliente(String codiceFiscale){
        for (Cliente cliente : clienti) {
            if(cliente.getCodiceFiscale().equals(codiceFiscale)){
                return cliente;
            }
        }
        return null;
    }
    
    
    
    
}
