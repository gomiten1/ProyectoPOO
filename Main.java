import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int opcion;
        Scanner input = new Scanner(System.in);

        System.out.println("Bienvenido al sistema de Formula 1");
        do {
            System.out.println("MENU");
            System.out.println("1. Crear un campeonato");
            System.out.println("Calendario de carreras");
            System.out.println("2. Iniciar una carrera ");
            System.out.println("3. Consultar carreras anteriores");
            System.out.println("4. Finalizar campeonato");
            System.out.println("5. Opciones para mostrar elementos");
            System.out.println("6. Salir");

            System.out.println("Por favor, ingresa la opcion elegida");
            opcion = input.nextInt();

            switch (opcion){
                case 1: //Crear un campeonato 
                    //Registrar pilotos
                    System.out.println("Ingrese el nombre del piloto");
                    String nombrePiloto = input.nextLine();
                    System.out.println("Ingrese la nacionalidad del piloto");
                    String nacionacilidadPilota = input.nextLine();

                    //Equipo
                    System.out.println("Ingrese el nombre del equipo");
                    String nombreEquipo = input.nextLine();

                    System.out.println("Ingrese el pais del equipo");
                    String paisEquipo = input.nextLine();

                    System.out.println("Ingrese el coche del equipo");
                    String cocheEquipo = input.nextLine();


                    




                break;

                case 2: 
                break;



            }


        } while (opcion != 6);
        input.close();
    }
}
