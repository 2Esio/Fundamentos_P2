package fciencias.icc.proyecto03;

public class Nodo {
    
    //El elemento que queremos guardar en nuestro nodo
    //El objeto en este caso es Animador
    private Animador elemento;

    //El elemento siguiente
    private Nodo siguiente; //null

    public Nodo(Animador elem){
        this.elemento=elem; //Queremos que dentro del nodo tenga un objeto Animador
    }


    //queremos algo como
    //Animador animador = new Animador();
    //Nodo nodoNuevo = new(animador);
    
    //o--o--o--o--o--o--o--o--o--o--o


    /**
     * Modifica/Asigna el elemento del nodo
     * @param elemento
     */
    public void setElemento(Animador elemento) {
        this.elemento = elemento;
    }

    /**
     * Modifica/Asigna el nodo dado como el siguiente nodo del actual
     * @param siguiente
     */
    public void setSiguiente(Nodo siguiente) {
        this.siguiente = siguiente;
    }


    /**
     * Consigue el elemento dentro del nodo
     * @return elemento
     */

    public Animador getElemento() {
        return elemento;
    }

    /**
     * Consigue el nodo siguiente de la lista enlazada
     * @return
     */
    
    public Nodo getSiguiente() {
        return siguiente;
    }
}