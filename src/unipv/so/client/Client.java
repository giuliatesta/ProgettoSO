package unipv.so.client;

import unipv.so.Constants;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

import static unipv.so.Constants.SERVER_HOST;
import static unipv.so.Constants.SERVER_PORT;

public class Client {

    public static Client create() {
        return new Client();
    }

    public void start() throws IOException {
        // Crea la connessione tra Server e Client
        Socket socket = new Socket(SERVER_HOST, SERVER_PORT);
        // Scrive sulla socket il numero per il Server
        PrintWriter printWriter = new PrintWriter(socket.getOutputStream(), true);
        printWriter.println("5");

        // Legge dalla socket il risultato
        int result = read(socket.getInputStream());

        // Stampa il risultato
        System.out.println(result);
    }

    // Legge dalla socket il risultato scritto e calcolato dal Server
    private int read(InputStream inputStream) {
        Scanner scanner = new Scanner(inputStream);
        if(scanner.hasNext()) {
            return Integer.parseInt(scanner.next());
        } else {
            return 0;
        }
    }
}
