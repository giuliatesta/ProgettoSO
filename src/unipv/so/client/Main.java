package unipv.so.client;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static unipv.so.client.Client.create;

/**
 * Classe main per i Client
 */
public class Main {

    public static void main(String[] args) throws IOException {
        // Se non viene inserito nessun parametro
        if (args.length == 0) {
            System.out.println("Inserisci parametri!");
        }
        // Lettura dei parametri inseriti
        List<Integer> numbers = getNumbers(args);

        // Creazione del client
        Client client = create(numbers);
        client.start();
    }

    /**
     * Legge i numeri inseriti come parametri
     * @param args vettore degli argomenti
     * @return lista dei numeri inseriti
     */
    private static List<Integer> getNumbers(String[] args) {
        List<Integer> numbers = new ArrayList<>();
        for (String arg : args) {
            numbers.add(Integer.valueOf(arg));
        }
        return numbers;
    }
}
