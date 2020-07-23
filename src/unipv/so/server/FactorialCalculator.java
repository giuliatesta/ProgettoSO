package unipv.so.server;

/**
 * Classe che si occupa di calcolare il fattoriale di un numero
 */
public class FactorialCalculator {

    /**
     * Calcola in maniera ricorsiva il fattoriale
     *
     * @param number numero su cui calcolare il fattoriale
     * @return fattoriale calcolato
     */
    public static long calculate(int number) {
        // Controlla se il numero è valido
        if (number < 0) {
            throw new IllegalArgumentException("Il numero deve essere positivo");
        }
        long result;
        // Se il numero inserito è valido
        if (number == 0) {
            // Se il numero inserito è zero il suo fattoriale è 1
            result = 1;
        } else {
            // Se il numero inserito è valido
            // System.out.println("RESULT 1 : " + result + "\n NUMBER: " + number);
            result = number * calculate(number - 1);
        }
        return result;
    }
}
