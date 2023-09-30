public class Pista {
    String localizacion;
    int kilometraje;
    int numVueltas;
    static int numPistas = 0;
    
    public Pista(String localizacion, int kilometraje, int numVueltas) {
        this.localizacion = localizacion;
        this.kilometraje = kilometraje;
        this.numVueltas = numVueltas;
        numPistas++;
    }

    public String toString(){
        String string = "Localizacion: " + localizacion + ", kilometraje: " + kilometraje + ", #vueltas: " + numVueltas;
        return string;
         
    }



    
}
