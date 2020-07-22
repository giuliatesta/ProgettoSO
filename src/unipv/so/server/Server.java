package unipv.so.server;

import unipv.so.Constants;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server {
    private final ServerSocket serverSocket;

    private Server() throws IOException {
        this.serverSocket = new ServerSocket(Constants.SERVER_PORT);
    }

    static Server create() throws IOException {
        return new Server();
    }


    public void start() throws IOException {
        // Ciclo infinito per rimanere in ascolto per delle nuove connessioni
        while (true) {

            // Accetta le connessioni in ingresso
            Socket socket = serverSocket.accept();

            // Legge il numero inviato dal Client
            int number = read(socket.getInputStream());

            // Calcola il fattoriale
            int result = calculate(number);

            // Stampa il risultato sulla socket
            PrintWriter printWriter = new PrintWriter(socket.getOutputStream(), true);
            printWriter.println(result);

            // Chiude la connessione
            socket.close();
        }

    }

    // Calcola il fattoriale
    private int calculate(int number) {
        return number;
    }

    // Restituisce il numero scritto sulla socket dal Client
    private int read(InputStream inputStream) {
        Scanner scanner = new Scanner(inputStream);
        if(scanner.hasNext()) {
            return Integer.parseInt(scanner.next());
        } else {
            return 0;
        }
    }
}
