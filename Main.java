import java.util. *;

public class Main {
    public static void main(String[] args) {
        int opcion;
        int opcion2;
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
                    //Lista de equipos
                    LinkedList<Equipo> equipos = new LinkedList<>();

                    do {
                        System.out.println("Seleccione el numero 0 cuando ya no quiera agregar mas equipos");
                        opcion2 = input.nextInt();
                        
                        
                    } while (opcion2 != 0);
                    
                break;


                case 2: 
                break;



            }


        } while (opcion != 6);
        input.close();
    }
}
