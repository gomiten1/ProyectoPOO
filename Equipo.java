import java.util.LinkedList;//Lista doblemente enlazada

import java.util.TreeSet; //Conjunto ordenado en un árbol binario de búsqueda

public class Equipo {
    private String nombre;
    private String pais;
    private String coche;
    private LinkedList<String> crew = new LinkedList<>(); //Lista    
    static int numEquipos = 0;

    public Equipo(String nombre, String pais, String coche) {
        this.nombre = nombre;
        this.pais = pais;
        this.coche = coche;
        numEquipos++;
    }

    public void aniadirCrew(String miembroCrew){
        this.crew.add(miembroCrew);
    }

    public String getNombre() {
        return nombre;
    }

    public String toString(){
        String imprimir;
        imprimir =  "nombre: " + nombre +
                    ", pais: " + pais +
                    ", coche: " + coche;

        return imprimir;
    }


    

}
