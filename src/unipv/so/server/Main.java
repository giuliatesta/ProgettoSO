package unipv.so.server;

import java.io.IOException;

public class Main {


    public static void main(String[] args) throws IOException {
        Server server = Server.create();
        server.start();
    }
}
