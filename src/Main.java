import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Main {
    static Scanner scanner;
    public static void main(String[] args) {
        scanner = new Scanner(System.in);
        System.out.print("Number of dates: ");
        int j = scanner.nextInt();
        int i = 0;
        /*while (i < j) {

            System.out.print("Ingresa una fecha comprimida: ");
            int day = scanner.nextInt();
            int month = scanner.nextInt();
            int year = scanner.nextInt();
            try {
                System.out.println(new Date(day, month, year));
            } catch (Exception e) {
                System.err.println(e.getMessage());
            }
            i++;
        }*/
        while (i < j) {
            System.out.print("Ingresa una fecha comprimida: ");
            int bits = scanner.nextInt();
            try {
                System.out.println(new Date(bits));
            } catch (Exception e) {
                //System.err.println(e.getMessage());
                Logger.getLogger(Date.class.getName()).log(Level.SEVERE, null, e);
            }
            i++;
        }

    }
}