import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int opcion;
        Scanner input = new Scanner(System.in);
        System.out.println("Bienvenido al sistema de Formula 1");
        do {
            System.out.println("Por favor, ingresa la opcion elegida");
            opcion = input.nextInt();

        } while (opcion == 0);
        input.close();
    }
}
