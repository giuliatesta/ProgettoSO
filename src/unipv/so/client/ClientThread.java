package unipv.so.client;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

/**
 * Classe thread per inviare le richieste al Server
 */
public class ClientThread extends Thread{
    private final Socket socket;
    private final int  number;

    /**
     * Costruttore privato
     * @param socket socket a cui fare riferimento
     * @param number numero inserito nella socket
     */
    private ClientThread(Socket socket, int number) {
        this.socket = socket;
        this.number = number;
    }

    /**
     * Crea una nuova istanza di ClientThread
     * @param socket socket di riferimento
     * @param number numero inserito nella socket
     * @return nuova istanza
     */
    public static ClientThread create(Socket socket, int number) {
        return new ClientThread(socket, number);
    }

    @Override
    public void start() {
        try {
            // Scrive sulla socket il numero per il Server
            PrintWriter printWriter = new PrintWriter(socket.getOutputStream(), true);
            printWriter.println(number);

            // Legge dalla socket il risultato
            long result = read(socket.getInputStream());

            // Stampa il risultato
            System.out.println(result);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    /**
     * Legge dalla socket il risultato scritto e calcolato dal Server
     * @param inputStream stream dove leggere il numero scritto dal Server
     * @return numero inserito
     */
    private long read(InputStream inputStream) {
        Scanner scanner = new Scanner(inputStream);
        if(scanner.hasNext()) {
            return Long.parseLong(scanner.next());
        } else {
            return 0;
        }
    }
}

