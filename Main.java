import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

public class Main {
    public static void main(String[] args) {
        int opcion;
        Scanner input = new Scanner(System.in);
        ArrayList<Equipo> equipos = new ArrayList<>();
        HashSet<Piloto> pilotos = new HashSet<>();
        LinkedList<Pista> pistas = new LinkedList<>();

        Campeonato campeonato= new Campeonato();
        System.out.println("Bienvenido al sistema de Formula 1");
        do {
            System.out.println("\nMENU");
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
                case 1: //Crear un campeonato (Registar pilotos y pista)
                    System.out.println("\nBienvenido aqui podra registar a los pilotos y las pistas");
                    System.out.println("\nPILOTOS");
                    //Registro pilotos
                    System.out.print("\nIngrese la cantidad de equipos: ");
                    int numEquipos = input.nextInt();
                    input.nextLine(); 

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
                    //Agregar un un print que muestre el numero de piloto
                    System.out.println("--------------------------------");
                    System.out.println("\nRegistro de pilotos: ");
                    for (Piloto piloto : pilotos) {
                        System.out.println("Nombre del piloto: " + piloto.getNombre());
                        System.out.println("Nacionalidad del piloto: " + piloto.getNacionalidad());
                        System.out.println("Equipo del piloto: " + piloto.getEquipo().getNombre());
                        System.out.println(); 
                    
                    }

                    System.out.println("\nPISTAS: ");
                    //Registro pistas
                    System.out.print("\nIngrese el numero de carreras: "); //Pensado que cada carrera tiene una pista diferencte
                    int numCarreras = input.nextInt();
                    input.nextLine(); 


                    for (int a = 0; a < numCarreras; a++){
                        System.out.println("\nPista #" + (a + 1));
                        System.out.print("Localizacion de la pista: ");
                        String localizacion = input.nextLine();
                        System.out.print("Kilometraja: ");
                        int km = input.nextInt();
                        System.out.print("Numero de vueltas: ");
                        int numVueltas = input.nextInt();
                        input.nextLine(); 

                        Pista pista= new Pista(localizacion, km, numVueltas);

                        pistas.add(pista);
                    }

                    System.out.println("--------------------------------");
                    System.out.println("\nRegistro de la pistas: \n");
                    for (Pista pista : pistas){                                                                
                        String cadena= pista.toString();
                        System.out.println(cadena);
                        
                    }
                break;

                case 2: //Asignar una pista, pilotos y una clave a la carrera
                    if (equipos.isEmpty() || pilotos.isEmpty() || pistas.isEmpty()) {
                        System.out.println("Debes registrar equipos, pilotos y pistas antes de iniciar una carrera.");
                    } else {
                        input.nextLine();
                        System.out.print("Nombre de la carrera: ");
                        String nombreCarrera = input.nextLine();
                        System.out.print("Pais de la carrera: ");
                        String paisCarrera = input.nextLine();
                        System.out.print("Clave de la carrera: ");
                        int claveCarrera = input.nextInt();
                        System.out.print("Puntos: ");
                        int puntosCarrera = input.nextInt();
                         

                        Carrera carrera = new Carrera(nombreCarrera, paisCarrera, claveCarrera, puntosCarrera); 
            
                        // Agregar todos los pilotos al conjunto de pilotos de la carrera
                        for (Piloto piloto : pilotos) {
                            carrera.aniadirPilotos(piloto);
                        }
            
                        // Seleccionar aleatoriamente una pista de la lista de pistas y agregarla a la carrera
                        int randomIndex = ThreadLocalRandom.current().nextInt(0, pistas.size());
                        Pista pistaSeleccionada = pistas.get(randomIndex);
                        carrera.aniadirPistas(pistaSeleccionada);
            
                        System.out.println("\nCarrera iniciada con exito.");

                        String cadena= carrera.toString();
                        System.out.println(cadena);
                    
                    }

                break;

                case 3:
                    System.out.println("Carreras anteriores:");
                    campeonato.consultarCampeonato();
                break;

                case 4:
                    System.out.println("El campeonato finalizo:");
                    campeonato.finalizarCampeonato();//Muestra la lista de carreras y el podio
                break;

                case 5:

                    System.out.println("Informacion completa de los pilotos:");
                    for (Piloto piloto : pilotos) {
                        String cadena= piloto.toString(); 
                        System.out.println(cadena);
                    
                    }

                    System.out.println("Resultado de las carreras:");

                    System.out.println("Posiciones del campeonato:");
                    //Mostrar podio
                break;

                case 6:
                    System.out.println("Saliendo...");
                break;

                default:
                    System.out.println("Ingresa una opcion valida");

            }
        } while (opcion != 6);
        input.close();
    }
}
