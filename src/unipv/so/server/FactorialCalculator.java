package unipv.so.server;

/**
 * Classe che si occupa di calcolare il fattoriale di un numero
 */
public class FactorialCalculator {

    /**
     * Crea una nuova istanza di FactorialCalculator
     * @return nuova istanza
     */
    static FactorialCalculator create() {
        return new FactorialCalculator();
    }

    /**
     * Calcola in maniera ricorsiva il fattoriale
     * @param number numero su cui calcolare il fattoriale
     * @return fattoriale calcolato
     */
    public long calculate(int number) {
        long result = 0;
        if(validation(number)) {
            // Se il numero inserito è valido
            if (number == 0) {
                // Se il numero inserito è zero il suo fattoriale è 1
                result = 1;
            } else {
                // Se il numero inserito è valido
                // System.out.println("RESULT 1 : " + result + "\n NUMBER: " + number);
                result = number * calculate(number - 1);
                System.out.println("RESULT 2 : " + result + "\t NUMBER: " + number);
            }
        }
        return result;
    }

    /**
     * Controlla la validità del numero inserito
     * @param number numero inserito
     * @return true se il numero è valido
     */
    public boolean validation(int number) {
        return number >= 0;
    }
}
