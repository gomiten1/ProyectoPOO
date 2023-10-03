public class Piloto {
    private String nombre;
    private String nacionalidad;
    private Equipo equipo;
    private int puntos = 0;
    private int posicion;
    static int numPilotos;

    public Piloto(){

    }

    
    public Piloto(String nombre, String nacionalidad, Equipo equipo) {
        this.nombre = nombre;
        this.nacionalidad = nacionalidad;
        this.equipo = equipo;
    }


    public void setPuntos(int puntos) {
        this.puntos += puntos;
    }

    public int getPuntos() {
        return puntos;
    }


    public void setPosicion(int posicion) {
        this.posicion = posicion;
    }

    public int getPosicion(){
        return posicion;
    }

    public String getNombre() {
        return nombre;
    }

    public String getNacionalidad() {
        return nacionalidad;
    }

    public Equipo getEquipo() {
        return equipo;
    }


    public String toString(){ //toString()= convierte un objeto en cadena de texto
        String imprimir;
        imprimir = "Nombre: " + nombre +
                    ", nacionalidad: " + nacionalidad +
                    ", puntos: " + puntos +
                    ", equipo: " + equipo.toString();
        return imprimir;
    }

    
}
