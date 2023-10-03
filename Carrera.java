import java.util.HashSet;
import java.util.LinkedList;//Lista doblemente ligada
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class Carrera {
    private String nombre;
    private HashSet<Piloto> pilotos = new HashSet<>();
    private LinkedList<Piloto> pilotosFinalizada = new LinkedList<>() ;
    private LinkedList<Pista> pistas = new LinkedList<>();
    private String pais;
    private int puntos;
    private int clave;
    boolean finalizada = false;
    static int numCarreras = 0;
    Random random = new Random();


    public Carrera(String nombre, String pais, int clave, int puntos) {
        this.nombre = nombre;
        this.pais = pais;
        this.clave = clave;
        if (puntos < 10){
            puntos = 10;
        }
        this.puntos = puntos;
        numCarreras++;
    }

  
    public void aniadirPilotos(Piloto piloto){
        this.pilotos.add(piloto);
    }
    
    public void aniadirPistas(Pista pista){
        this.pistas.addLast(pista);
    }

    public int getClave() {
        return clave;
    }

    

    public LinkedList<Piloto> getPilotosFinalizada() {
        return pilotosFinalizada;
    }


    public void finalizarCarrera(){
        int aux;
        Piloto auxPiloto= null; //Agregue = null
        for(int i = 0; i < 10; i++){
            int rand = ThreadLocalRandom.current().nextInt(pilotos.size());
            int j = 0;
            for (Piloto piloto : pilotos){
                if(j==rand){
                    piloto.setPuntos(puntos);
                    puntos--;
                }
                j++;
            }
            
        }

        finalizada = true;
        for(int i = 0; i< pilotos.size(); i++){
            aux = 0;
            for(Piloto piloto : pilotos){
                if(piloto.getPuntos() > aux){
                   auxPiloto = piloto; 
                   //Agregue
                   aux = piloto.getPuntos();
                }
            }

            pilotos.remove(auxPiloto);
            pilotosFinalizada.addLast(auxPiloto);
        }
        

    }

    public String toString(){
        String imprimir = "Nombre de la carrera: " + nombre +
                            ", pais: " + pais + 
                            ", clave: " + clave;
        return imprimir;
    }

    public void listarFinalizada(){
        System.out.println("Nombre de la carrera: " + nombre +
                            ", pais: " + pais + 
                            ", clave: " + clave);

        for (Piloto piloto: pilotosFinalizada){
            int numeroAleatorio = random.nextInt(100); // Cambia el rango según tus necesidades
            System.out.println("\nPosicion: " + numeroAleatorio);
            System.out.println(piloto.toString());
        }
        
    }


    public void setDatos(String nombre, String pais, int clave, int puntos) {
        this.nombre = nombre;
        this.pais = pais;
        this.clave = clave;
        this.puntos = puntos;
    }

    

}
