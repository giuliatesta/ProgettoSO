package unipv.so.server;

import unipv.so.Constants;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

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

            // crea il thread per la richiesta
            ServerThread thread = ServerThread.create(socket);

            // Lascia gestire la richiesta al thread
            thread.start();
        }

    }


}
