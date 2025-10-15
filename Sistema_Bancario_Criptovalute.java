/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */


import com.mycompany.sistema_bancario_criptovalute.DAO.BancaGestionale;
import com.mycompany.sistema_bancario_criptovalute.model.Cliente;
import com.mycompany.sistema_bancario_criptovalute.model.Conto;
import com.mycompany.sistema_bancario_criptovalute.model.contoCorrente;
import com.mycompany.sistema_bancario_criptovalute.model.walletCripto;
import java.util.Scanner;

/**
 *
 * @author david
 */
public class Sistema_Bancario_Criptovalute {
    
    

    public static void main(String[] args) {
        
        
        System.out.println("Hello World!");

        BancaGestionale Banca = new BancaGestionale();
        Cliente cliente = new Cliente();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n===== MENU BANCA =====");
            System.out.println("1. Aggiungi cliente");
            System.out.println("2. Aggiungi conto a cliente");
            System.out.println("3. Visualizza clienti e conti");
            System.out.println("4. Deposita denaro/Preleva denaro");
            System.out.println("5. Aggiorna cliente");
            System.out.println("6. Elimina cliente");
            System.out.println("7. Calcola patrimonio totale di un cliente");
            System.out.println("8. Esci");
            System.out.print("Scelta: ");

            int scelta = scanner.nextInt();
            scanner.nextLine();

            switch (scelta) {
                case 1:
                    cliente.setNome(scanner.nextLine());
                    cliente.setCognome(scanner.nextLine());
                    cliente.setCodiceFiscale(scanner.nextLine());

                    Banca.addCliente(cliente);
                    break;
                case 2:
                    System.out.println("Inserisci il codice fiscale del cliente: ");
                    String cf = scanner.nextLine();

                    if (cliente == null) {
                        System.out.println("Cliente non trovato");
                    }

                    System.out.println("Che tipo di conto vuoi aggiungere?");
                    System.out.println("1. Conto Corrente");
                    System.out.println("2. Wallet Cripto");
                    int tipo = scanner.nextInt();
                    scanner.nextLine(); // consuma newline

                    System.out.println("Inserisci l'IBAN");
                    String iban = scanner.nextLine();

                    System.out.println("Inserisci il saldo iniziale");
                    double saldo = scanner.nextDouble();
                    scanner.nextLine();

                    Conto nuovoConto = null;

                    if (tipo == 1) {
                        System.out.println("Inserisci tasso di interesse: ");
                        double tasso = scanner.nextDouble();
                        scanner.nextLine();
                        nuovoConto = new contoCorrente(iban, saldo);
                    } else if (tipo == 2) {
                        System.out.println("Inserisci tipo di criptovaluta (es. BTC, ETH): ");
                        String cripto = scanner.nextLine();
                        nuovoConto = new walletCripto(iban, saldo);
                    } else {
                        System.out.println("Scelta non valida!");
                        break;
                    }

                    cliente.aggiungiConto();
                    System.out.println(" Conto aggiunto al cliente " + cliente.getNome());
                    break;
                case 3:
                    Banca.visualClient();
                    break;
                case 4:
                    System.out.println("Inserisci il codice fiscale del cliente: ");
                    String cfOperazione = scanner.nextLine();

                    Cliente clienteOperazione = Banca.ricercaCliente(cfOperazione);

                    if (clienteOperazione == null) {
                        System.out.println("Cliente non trovato!");
                        break;
                    }

                    // Mostra i conti del cliente
                    System.out.println("Conti disponibili:");
                    int index = 1;
                    for (Conto conto : clienteOperazione.getConti()) {
                        System.out.println(index + ". " + conto.toString());
                        index++;
                    }

                    System.out.println("Scegli il numero del conto su cui operare: ");
                    int sceltaConto = scanner.nextInt();
                    scanner.nextLine();

                    Conto contoSelezionato = clienteOperazione.getConti().get(sceltaConto - 1);

                    System.out.println("Vuoi:");
                    System.out.println("1. Depositare");
                    System.out.println("2. Prelevare");
                    int sceltaOp = scanner.nextInt();
                    scanner.nextLine();

                    System.out.println("Inserisci importo: ");
                    double importo = scanner.nextDouble();
                    scanner.nextLine();

                    if (sceltaOp == 1) {
                        contoSelezionato.deposita(importo);
                        System.out.println(" Deposito effettuato con successo!");
                    } else if (sceltaOp == 2) {
                        contoSelezionato.preleva(importo);
                        System.out.println(" Prelievo effettuato con successo!");
                    } else {
                        System.out.println(" Operazione non valida!");
                    }
                    break;
                case 5:
                    System.out.println("Aggiorna cliente");

                    String codiceFiscale = scanner.nextLine();
                    Banca.updateClient(codiceFiscale, cliente);
                    break;
                case 6:
                    System.out.println("Elimina cliente con codiceFiscale");

                    String CodiceFiscale = scanner.nextLine();
                    Banca.deleteClient(CodiceFiscale);
                    break;
                case 7:
                    System.out.println("Calcola il patrimonio totale");
                    cliente.calcoloPatrimonioTot();
               default:
                   System.out.println("nessuna selezione");

            }

        }

    }
}
