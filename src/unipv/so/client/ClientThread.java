package unipv.so.client;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class ClientThread extends Thread{
    private final Socket socket;
    private int  number;

    private ClientThread(Socket socket, int number) {
        this.socket = socket;
        this.number = number;
    }
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
            int result = read(socket.getInputStream());

            // Stampa il risultato
            System.out.println(result);
        } catch (IOException e) {
            e.printStackTrace();
        }

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

