
import java.time.LocalDateTime;
import java.util.LinkedList;
import java.util.Set;
import java.util.Map;
import java.util.TreeMap;



public class Campeonato {
    
    private LinkedList<Carrera> carrerasPrevias = new LinkedList<>();
    private TreeMap<Integer, Carrera> clavesCarreras;
    private TreeMap<Carrera, LocalDateTime> calendario;

    //Constructor
    public Campeonato(){
        //Pendiente
    }

    public Campeonato(TreeMap clavesCarreras, TreeMap calendario){
        this.clavesCarreras = clavesCarreras;
        this.calendario = calendario;
    }

    public void aniadirCarrera(Carrera carrera, LocalDateTime fecha){
        clavesCarreras.put(carrera.getClave(), carrera);
        calendario.put(carrera, fecha);
    }

    public void listarCarreras(){
        Set<Map.Entry<Integer, Carrera> > elementos = clavesCarreras.entrySet();
        for (Map.Entry<Integer, Carrera> elemento: elementos){
            System.out.println(elemento.getValue().toString());
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

    public void finalizarCampeonato(){
        this.listarCarreras();
        this.mostrarPodio();
    }

    public void mostrarPodio(){
        //tengo que pensar en este metodo
    }


}