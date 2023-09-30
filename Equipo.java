import java.util.LinkedList;

import java.util.TreeSet;

public class Equipo {
    private String nombre;
    private String pais;
    private String coche;
    private LinkedList<String> crew = new LinkedList<>();
    static int numEquipos = 0;

    public Equipo(String nombre, String pais, TreeSet<Piloto> pilotos, String coche) {
        this.nombre = nombre;
        this.pais = pais;
        this.coche = coche;
        numEquipos++;
    }

    public void aniadirCrew(String miembroCrew){
        this.crew.add(miembroCrew);
    }

    public String toString(){
        String imprimir;
        imprimir =  "nombre: " + nombre +
                    ", pais: " + pais +
                    ", coche: " + coche;

        return imprimir;
    }


    

}
