import java.util.LinkedList;

import java.util.TreeSet;

public class Carrera {
    String nombre;
    private TreeSet<Piloto> pilotos = new TreeSet<>();
    private LinkedList<Pista> pistas = new LinkedList<>();
    private String pais;
    private int puntos;
    private int clave;
    static int numCarreras = 0;


    public Carrera(String nombre, String pais, int clave, int puntos) {
        this.nombre = nombre;
        this.pais = pais;
        this.clave = clave;
        this.puntos = puntos;
        numCarreras++;
    }

    public void aniadirPilotos(Piloto piloto){
        this.pilotos.add(piloto);
    }
    
    public void aniadirPistas(Pista pista){
        this.pistas.addLast(pista);
    }



    


    


}
