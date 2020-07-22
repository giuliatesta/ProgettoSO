package unipv.so.client;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {
        List<Integer> numbers = getNumbers(args);
        Client client = Client.create(numbers);
        client.start();
    }

    private static List<Integer> getNumbers(String[] args) {
        List<Integer> numbers = new ArrayList<>();
        for(int i = 0; i < args.length; i++) {
            numbers.add(Integer.valueOf(args[i]));
        }
        return numbers;
    }
}
