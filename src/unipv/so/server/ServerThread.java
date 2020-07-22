package unipv.so.server;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class ServerThread extends Thread{

    private final Socket socket;

    private ServerThread(Socket socket) {
        this.socket = socket;
    }

    public static ServerThread create(Socket socket) {
        return new ServerThread(socket);
    }

    @Override
    public void start(){
        try {
            // Legge il numero inviato dal Client
            int number = read(socket.getInputStream());

            // Calcola il fattoriale
            int result = calculate(number);

            // Stampa il risultato sulla socket
            PrintWriter printWriter = new PrintWriter(socket.getOutputStream(), true);
            printWriter.println(result);

            // Chiude la connessione
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
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
