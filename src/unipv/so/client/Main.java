package unipv.so.client;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        Client client = Client.create();
        client.start();
    }
}
