package unipv.so.server;


import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import static unipv.so.Constants.SERVER_PORT;

/**
 * Classe del Server
 */
public class Server {
    private final ServerSocket serverSocket;

    /**
     * Costruttore privato
     * @throws IOException per eccezioni legate alla socket
     */
    private Server() throws IOException {
        this.serverSocket = new ServerSocket(SERVER_PORT);
    }

    /**
     * Crea una nuova istanza del Server
     * @return nuova istanza
     * @throws IOException per eccezioni legate alla socket
     */
    static Server create() throws IOException {
        return new Server();
    }

    /**
     * Fa partire il Server. Fa in modo che rimanga in ascolto delle connessioni e le gestisca
     * @throws IOException per eccezioni legate alla socket
     */
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
