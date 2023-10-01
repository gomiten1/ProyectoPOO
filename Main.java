import java.util.*;
//Soloo problemas
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

            System.out.print("Por favor, ingresa la opcion elegida: ");
            opcion = input.nextInt();

            switch (opcion){
                case 1: //Crear un campeonato
                System.out.print("\nIngrese la cantidad de equipos: ");
                int numEquipos = input.nextInt();
                input.nextLine(); 
        
                ArrayList<Equipo> equipos = new ArrayList<>();
                ArrayList<Piloto> pilotos = new ArrayList<>();

                for (int i = 0; i < numEquipos; i++) {
                    System.out.println("\nEquipo #" + (i + 1));
                    System.out.print("Nombre del equipo: ");
                    String nombreEquipo = input.nextLine();
                    System.out.print("Pais del equipo: ");
                    String paisEquipo = input.nextLine();
                    System.out.print("Coche del equipo: ");
                    String cocheEquipo = input.nextLine();
        
                    Equipo equipo = new Equipo(nombreEquipo, paisEquipo, cocheEquipo);
                    equipos.add(equipo);
        
                    for (int j = 0; j < 2; j++) {
                        System.out.println("\nPiloto #" + (j + 1) + " del Equipo #" + (i + 1));
                        System.out.print("Nombre del piloto: ");
                        String nombrePiloto = input.nextLine();
                        System.out.print("Nacionalidad del piloto: ");
                        String nacionalidadPiloto = input.nextLine();
        
                        Piloto piloto = new Piloto(nombrePiloto, nacionalidadPiloto, equipo);
                        pilotos.add(piloto);
                    }
                    
                }
                
                System.out.println("\nRegistro de pilotos: ");
                for (Piloto piloto : pilotos) {
                    
                    System.out.println("Nombre del piloto: " + piloto.getNombre());
                    System.out.println("Nacionalidad del piloto: " + piloto.getNacionalidad());
                    System.out.println("Equipo del piloto: " + piloto.getEquipo().getNombre());
                    System.out.println(); 
                
                }
                break;


            }


        } while (opcion != 6);
        input.close();
    }
}
