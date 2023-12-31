
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Set;
import java.util.Map;
import java.util.TreeMap;



public class Campeonato {
    
    private LinkedList<Carrera> carrerasPrevias = new LinkedList<>();
    private TreeMap<Integer, Carrera> clavesCarreras;
    private LinkedHashMap<Carrera, LocalDateTime> calendario;
    private LinkedList<Piloto> pilotosCampeonato;

    //Constructor
    public Campeonato(){
        
    }

    public Campeonato(TreeMap clavesCarreras, LinkedHashMap calendario){
        this.clavesCarreras = clavesCarreras;
        this.calendario = calendario;
    }

    public void aniadirCarrera(Carrera carrera, LocalDateTime fecha){
        clavesCarreras.put(carrera.getClave(), carrera);
        calendario.put(carrera, fecha);
    }

    public void listarCarreras(){
        LocalDateTime fecha;
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        Set<Map.Entry<Integer, Carrera> > elementos = clavesCarreras.entrySet();
        for (Map.Entry<Integer, Carrera> elemento: elementos){
            System.out.println(elemento.getValue().toString());
            System.out.println("Fecha: ");
            fecha = calendario.get(elemento.getValue());
            System.out.println(fecha.format(formatter));
        }
    }

    public void avanzarCampeonato(int clave){
        Carrera carreraActual = clavesCarreras.get(clave);
        carreraActual.finalizarCarrera();
        carreraActual.listarFinalizada();
        carrerasPrevias.addLast(carreraActual);
    }

    public void consultarCampeonato(){
        for( Carrera carreraPrevia : carrerasPrevias){
            carreraPrevia.listarFinalizada();
        }
        
    }

    public void setDatos(LinkedHashMap<Carrera, LocalDateTime> calendario, TreeMap<Integer,Carrera> clavesCarreras){
        this.calendario = calendario;
        this.clavesCarreras = clavesCarreras;
    }




    public void mostrarPodio(LinkedList<Piloto> pilotos){
        this.pilotosCampeonato = pilotos;
        Piloto auxPiloto = new Piloto();
        int aux;
        for(int i = 1; i<= 3; i++){
            aux = 0;
            for(Piloto piloto : pilotosCampeonato){
                if(piloto.getPuntos() > aux){
                   auxPiloto = piloto; 
                }
            }

            System.out.println("\nLugar " + i + " :");
            System.out.println(auxPiloto.toString());

            pilotosCampeonato.remove(auxPiloto);
            
        }

        for (Carrera previa : carrerasPrevias){
            System.out.println(previa.toString());
        }
    }


}