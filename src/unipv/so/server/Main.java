package unipv.so.server;

import java.io.IOException;

import static unipv.so.server.Server.create;

/**
 * Classe main per il Server
 */
public class Main {


    public static void main(String[] args) throws IOException {
        // Creazione del Server
        Server server = create();
        server.start();
    }
}
