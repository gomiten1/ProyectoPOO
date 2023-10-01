public class Piloto {
    private String nombre;
    private String nacionalidad;
    private Equipo equipo;
    private int puntos;
    private int posicion;
    static int numPilotos;


    public Piloto(String nombre, String nacionalidad, Equipo equipo) {
        this.nombre = nombre;
        this.nacionalidad = nacionalidad;
        this.equipo = equipo;
    }


    public void setPuntos(int puntos) {
        this.puntos = puntos;
    }


    public void setPosicion(int posicion) {
        this.posicion = posicion;
    }

    public String toString(){ //toString()= convierte un objeto en cadena de texto
        String imprimir;
        imprimir = "Nombre: " + nombre +
                    ", nacionalidad: " + nacionalidad +
                    ", puntos: " + puntos +
                    ", posicion: " + posicion +
                    ", equipo: " + equipo.toString();
        return imprimir;
    }

    
}
