package unipv.so.client;

import java.io.IOException;
import java.net.Socket;
import java.util.List;

import static unipv.so.Constants.SERVER_HOST;
import static unipv.so.Constants.SERVER_PORT;

public class Client {

    private final List<Integer> numbers;

    public Client(List<Integer> numbers) {
        this.numbers = numbers;
    }

    public static Client create(List<Integer> numbers) {
        return new Client(numbers);
    }

    public void start() throws IOException {
        for(Integer i : numbers) {
            // Crea la connessione tra Server e Client
            Socket socket = new Socket(SERVER_HOST, SERVER_PORT);
            // Crea il thread per la comunicazione sulla socket
            ClientThread thread = ClientThread.create(socket, i);
            thread.start();
        }

    }
}
