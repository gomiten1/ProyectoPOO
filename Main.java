import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

public class Main {
    public static void main(String[] args) {
        int opcion;
        Scanner input = new Scanner(System.in);
        ArrayList<Equipo> equipos = new ArrayList<>();
        HashSet<Piloto> pilotos = new HashSet<>();
        LinkedList<Pista> pistas = new LinkedList<>();
        TreeMap<Integer, Carrera> carreras = new TreeMap<>();
        LinkedHashMap<Carrera, LocalDateTime> calendario = new LinkedHashMap<>();
        LinkedList<Piloto> pilotosFinalizar = new LinkedList<>();

        Campeonato campeonato= new Campeonato();
        System.out.println("Bienvenido al sistema de Formula 1");
        do {
            System.out.println("\nMENU");
            System.out.println("1. Crear un campeonato");
            System.out.println("Calendario de carreras");
            System.out.println("2. Iniciar una carrera ");
            System.out.println("3. Iniciar y finalizar un campeonato");
            System.out.println("4. Consultar carreras anteriores");
            System.out.println("5. Informacion sobre los elementos");
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
                            pilotosFinalizar.add(piloto);
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
                    System.out.print("\nIngrese el numero de pistas: "); //Pensado que cada carrera tiene una pista diferencte
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
                    int carrerasIngresar;
                    Pista pistaSeleccionada;
                    int randomIndex;
                    Carrera carrera;
                    int claveCarrera;
                    int puntosCarrera;
                    String pasarFecha;
                    LocalDateTime fechaCarrera;
                    DateTimeFormatter formato = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
                    System.out.println("\nIngrese la cantidad de carreras a iniciar:");
                    carrerasIngresar = input.nextInt();
                    for (int i = 0; i<carrerasIngresar; i++){
                        if (equipos.isEmpty() || pilotos.isEmpty() || pistas.isEmpty()) {
                            System.out.println("\nDebes registrar equipos, pilotos y pistas antes de iniciar una carrera.");
                        } else {
                            
                            input.nextLine();
                            System.out.print("Nombre de la carrera: ");
                            String nombreCarrera = input.nextLine();
                            System.out.print("Pais de la carrera: ");
                            String paisCarrera = input.nextLine();
                            System.out.print("Clave de la carrera: ");
                            claveCarrera = input.nextInt();
                            System.out.print("Puntos: ");
                            puntosCarrera = input.nextInt();
                            System.out.println("Ingresa la fecha de la carrera con el formato (yyyy-MM-dd HH:mm): ");
                            input.nextLine();
                            pasarFecha = input.nextLine();
                            fechaCarrera = LocalDateTime.parse(pasarFecha, formato);

                            //if(carreras.isEmpty()){
                               carrera = new Carrera(nombreCarrera, paisCarrera, claveCarrera, puntosCarrera); 
                            //} else {
                                //carrera.setDatos(nombreCarrera, paisCarrera, claveCarrera, puntosCarrera);
                            //}

                
                            // Agregar todos los pilotos al conjunto de pilotos de la carrera
                            for (Piloto piloto : pilotos) {
                                carrera.aniadirPilotos(piloto);
                            }
                
                            // Seleccionar aleatoriamente una pista de la lista de pistas y agregarla a la carrera
                            randomIndex = ThreadLocalRandom.current().nextInt(0, pistas.size());
                            pistaSeleccionada = pistas.get(randomIndex);
                            carrera.aniadirPistas(pistaSeleccionada);
                
                            System.out.println("\nCarrera iniciada con exito.");

                            String cadena= carrera.toString();
                            System.out.println(cadena);
                            
                            carreras.put(carrera.getClave(), carrera);
                            calendario.put(carrera, fechaCarrera);
                            
                        
                        }

                        
                    }

                    campeonato.setDatos(calendario, carreras);

                break;

                case 3:
                    int claveRealizar;
                    for (int b = 0; b< Carrera.numCarreras; b++){
                        System.out.print("\nClave de la carrera a realizar: \n");
                        claveRealizar = input.nextInt();
                        campeonato.avanzarCampeonato(claveRealizar);
                    }
                    System.out.println("\nEl campeonato finalizo con exito");
                    
                break;

                case 4:
                    System.out.println("\nCarreras anteriores:\n");
                    campeonato.listarCarreras();
                    System.out.println();
                break;

                case 5:

                    System.out.println("\nInformacion completa de los pilotos:");
                    for (Piloto piloto : pilotos) {
                        String cadena= piloto.toString(); 
                        System.out.println(cadena);
                    }

                    System.out.println("\nResultado de las carreras");
                    System.out.println("PODIO:");
                    campeonato.mostrarPodio(pilotosFinalizar);

                    System.out.println("\nPosiciones del campeonato:\n");
                    for (Map.Entry<Integer, Carrera> entry : carreras.entrySet()) {
                        Carrera carrera1 = entry.getValue(); // Obtener la carrera del TreeMap
                        carrera1.listarFinalizada();
                    }

                break;

                case 6:
                    System.out.println("\nSaliendo...");
                break;

                default:
                    System.out.println("\nIngresa una opcion valida");

            }
        } while (opcion != 6);
        input.close();
    }
}
