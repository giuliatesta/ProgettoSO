package unipv.so.server;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

/**
 * Classe thread per la gestione delle richieste arrivate al Server
 */
public class ServerThread extends Thread{

    private final Socket socket;

    /**
     * Costruttore privato
     * @param socket socket di riferimento
     */
    private ServerThread(Socket socket) {
        this.socket = socket;
    }

    /**
     * Crea una nuova istanza del ServerThread
     * @param socket socket a cui fare riferimento
     * @return nuova istanza
     */
    public static ServerThread create(Socket socket) {
        return new ServerThread(socket);
    }

    @Override
    public void start() {
        try {
            // Legge il numero inviato dal Client
            int number = read(socket.getInputStream());

            // Calcola il fattoriale
            long result = calculate(number);

            // Stampa il risultato sulla socket
            writeResult(result, socket);

            // Chiude la connessione
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    /**
     * Scrive sulla socket il risultato
     * @param result numero da scrivere
     * @param socket socket su cui scrivere
     * @throws IOException per eccezioni legate alla scrittura sullo stream di output della socket
     */
    private void writeResult(long result, Socket socket) throws IOException {
        PrintWriter printWriter = new PrintWriter(socket.getOutputStream(), true);
        printWriter.println(result);
    }

    /**
     * Calcola il fattoriale
     * @param number numero di cui calcolare il fattoriale
     * @return fattoriale di number
     */
    private long calculate(int number) {
        FactorialCalculator calculator = FactorialCalculator.create();
        return calculator.calculate(number);
    }

    /**
     * Legge dalla socket il numero inserito dal Client. Se non è stato inserito nulla restituisce zero
     * @param inputStream stream da cui leggere
     * @return numero letto
     */
    private int read(InputStream inputStream) {
        Scanner scanner = new Scanner(inputStream);
        if(scanner.hasNext()) {
            return Integer.parseInt(scanner.next());
        } else {
            return 0;
        }
    }


}
