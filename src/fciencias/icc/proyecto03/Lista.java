package fciencias.icc.proyecto03;

import java.util.NoSuchElementException;


public class Lista {

    /* El nodo inicial */
    private Nodo cabeza;

    /* longitud de la lista */
    private int lista;

    /**
     * Mustra en pantalla los elementos de la lista.
     */
    public void listar(){
        // Verifica si la lista contiene elementos
        if (!esVacia()) {
            // Crea una copia de la lista.
            Nodo puntero = cabeza;
            // Posicion de los elementos de la lista
            int i = 0;
            // Recorre la lista hasta el final
            while(puntero != null){
                // Imprime en pantalla el valor del nodo
                System.out.println(i + 1 + ".[ " + puntero.getElemento() + " ]");
                // Avanza al siguiente nodo
                puntero = puntero.getSiguiente();
                // Incrementa el contador de la posicion
                i++;
            }
        }
    }

    /**
     * Indica si la lista es vacia
     * @return true si la lista es vacia, false en otro caso
     */
    
    public boolean esVacia(){
        //Si es igual a null, retorna true. Por otra parte, si es diferente es false
        return cabeza == null;
    }

    /**
     * Regresa la longitud de la lista
     * @return la longitud de la lista
     */
    
    public int getLongitud(){
        return lista;
    }

    /**
     * Agrega el animador (si es que no existe) a la ultima posicion de la lista
     * @param elemento el animador a agregar
     */
    
    public void agregarAnimador(Animador elemento) {
        // Definimos el nuevo nodo
        Nodo nuevoNodo = new Nodo(elemento);
        // Verifica si la lista está vacía
        if (esVacia()) {
            cabeza = nuevoNodo;
        } else {
            // Insertar al final de la lista
            Nodo puntero = cabeza;
            while (puntero.getSiguiente() != null) {
                puntero = puntero.getSiguiente();
            }
            // El nodo nuevo se agrega al final de la lista
            puntero.setSiguiente(nuevoNodo);
        }
        lista++;
    }


    /**
     * Agrega la cantidad de animadores que se contrataron al mismo rol
     * @param posicion la posicion del animador existente
     * @cantidad la cantidad de animadores del mismo rol a agregar
     */
    
    public void agregarCantidadDelMismoRol(int posicion, int cantidad){
        posicion = posicion -1;
        if (esVacia()){
            throw new NoSuchElementException("La lista esta vacia");
        } else if (posicion < 0 || posicion >= getLongitud()) {
            throw new IndexOutOfBoundsException("Indice de animador no encontrado");
        } else if (cantidad < 0){
            throw new IndexOutOfBoundsException("Cantidad de personas negativa (no valida)");
        } else {
            // Verifica si el nodo a cambiar es el primero
            if (posicion == 0) {
                // Actualiza el valor del primer nodo.
                cabeza.getElemento().setCantidad(cabeza.getElemento().getCantidad() + cantidad);
            } else {
                // Creamos un nodo de posición
                Nodo puntero = cabeza;
                // Recorre la lista hasta llegar al nodo en la posición deseada
                for (int i = 0; i < posicion; i++) {
                    puntero = puntero.getSiguiente();
                }
                // Actualiza el valor del nodo
                puntero.getElemento().setCantidad(puntero.getElemento().getCantidad() + cantidad);
            }
        }
    }

    /**
     * Actualiza el pago del animador
     * @param posicion la posicion del animador existente
     * @param pago el pago que se actualizara al animador
     */

    public void actualizarPago(int posicion, int pago){
        posicion = posicion - 1;
        // Verifica si la lista esta vacia o si el pago es negativo
        if (esVacia()) {
            throw new NoSuchElementException("La lista esta vacia");
        } else if (posicion < 0 || posicion >= getLongitud()) {
            throw new IndexOutOfBoundsException("Indice de animador no encontrado");
        } else if (pago < 0){
            throw new IndexOutOfBoundsException("Cantidad de dinero negativa (no valida)");
        } else {
                // Verifica si el nodo a cambiar es el primero
                if (posicion == 0) {
                    // Actualiza el valor del primer nodo.
                    cabeza.getElemento().setPagoPorHora(pago);
                } else {
                    // Creamos un nodo de posición
                    Nodo puntero = cabeza;
                    // Recorre la lista hasta llegar al nodo en la posicion deseada
                    for (int i = 0; i < posicion; i++) {
                        puntero = puntero.getSiguiente();
                    }
                    // Actualiza el valor del nodo
                    puntero.getElemento().setPagoPorHora(pago);
            }
        }
    }


    /**
     * Cambia el nombre de animador que hay en la lista por uno nuevo (manteniendo la cantidad y el pago)
     * @param elemento el nuevo elemento
     * @param posicion la posicion donde se va cambiar el elemento
     */
    public void actualizarRol(int posicion, String nuevoNombre) {
        posicion = posicion - 1;
    
        // Verifica si la lista esta vacia
        if (esVacia()) {
            throw new NoSuchElementException("La lista esta vacia");
        } else if (posicion < 0 || posicion >= getLongitud()) {
            throw new IndexOutOfBoundsException("Indice de animador no encontrado");
        } else {
                // Verifica si el nodo a cambiar es el primero
                if (posicion == 0) {
                    // Actualiza el valor del primer nodo.
                    cabeza.getElemento().setAnimador(nuevoNombre);
                } else {
                    // Creamos un nodo de posición
                    Nodo puntero = cabeza;
                    // Recorre la lista hasta llegar al nodo en la posicion deseada
                    for (int i = 0; i < posicion; i++) {
                        puntero = puntero.getSiguiente();
                    }
                    // Actualiza el valor del nodo
                    puntero.getElemento().setAnimador(nuevoNombre);
                }
        }
    }


    /**
     * Despide (elimina) personas del mismo rol
     */
    
     public void eliminarCantidadDelMismoRol(int posicion, int cantidad) {
        posicion = posicion - 1;
    
        if (esVacia()) {
            throw new NoSuchElementException("La lista esta vacia");
        } else if (posicion < 0 || posicion >= getLongitud()) {
            throw new IndexOutOfBoundsException("Indice de animador no encontrado");
        } else if (cantidad < 0) {
            throw new IndexOutOfBoundsException("Cantidad de personas negativa (no valida)");
        } else {
            // Verifica si el nodo a cambiar es el primero
            if (posicion == 0) {
                // Verifica si la cantidad es mayor a la actual
                if (cabeza.getElemento().getCantidad() < cantidad) {
                    throw new IndexOutOfBoundsException("La cantidad es mayor a la actual");
                }
                
                // Verifica si la cantidad es igual a la actual
                if (cabeza.getElemento().getCantidad() == cantidad) {
                    eliminar(posicion);
                } else {
                    // Resta la cantidad al valor del primer nodo
                    cabeza.getElemento().setCantidad(cabeza.getElemento().getCantidad() - cantidad);
                }
            } else {
                // Creamos un nodo de posicion
                Nodo puntero = cabeza;
                // Recorre la lista hasta llegar al nodo en la posicion deseada
                for (int i = 0; i < posicion; i++) {
                    puntero = puntero.getSiguiente();
                }
    
                // Verifica si la cantidad es mayor a la actual
                if (puntero.getElemento().getCantidad() < cantidad) {
                    throw new IndexOutOfBoundsException("La cantidad es mayor a la actual");
                }
                
                // Verifica si la cantidad es igual a la actual
                if (puntero.getElemento().getCantidad() == cantidad) {
                    eliminar(posicion);
                } else {
                    // Resta la cantidad al valor del nodo.
                    puntero.getElemento().setCantidad(puntero.getElemento().getCantidad() - cantidad);
                }
            }
        }
    }
    


    /**
     * Elimina el animador deseado por el usuario por indice (despide a todos)
     * @param posicion la posicion donde se va eliminar el elemento
     */

    public void eliminar(int posicion){
        
        //Verifica si es vacia
        if (esVacia()){  
            throw new NoSuchElementException("La lista esta vacia");
        } else if (posicion < 0 || posicion >= getLongitud()) {
            throw new IndexOutOfBoundsException("Indice de animador no encontrado");
        } else {   
            if(posicion>=0 && posicion < getLongitud()){
                // Verifica si el nodo a eliminar es el primero
                if(posicion == 0){
                    // Almacena el valor del nodo antes de eliminarlo
                    // Elimina el primer nodo apuntando al siguinte
                    cabeza = cabeza.getSiguiente();
                }
                // En caso que el nodo a eliminar este por el medio 
                // o sea el ultimo
                else{
                    // Creamos un nodo de posicion
                    Nodo puntero = cabeza;
                    // Recorre la lista hasta llegar al nodo anterior al eliminar
                    for (int i = 0; i < posicion-1; i++) {
                        puntero = puntero.getSiguiente();
                    }
                    // Guarda el nodo siguiente al nodo a eliminar
                    Nodo siguiente = puntero.getSiguiente();
                    // Elimina la referencia del nodo apuntando al nodo siguiente
                    puntero.setSiguiente(siguiente.getSiguiente());
                }
                // Disminuye el tamaño de la lista
                lista--;     
            } 
        }
    }


 // ----------------------------------- De la practica 5 ----------------------------------------------

    public Animador getElemento(int posicion){
        // Si la posicion es menor o mayor a la longitud de la lista arroja el caso
        if (posicion < 0 || posicion >= getLongitud())  {
            throw new IndexOutOfBoundsException("Posicion invalida (fuera de rango).");
        }
        // Creamos un nodo de posicion
        Nodo puntero = cabeza;
        // Con un bucle, iteramos hasta la posicion dada como parametro
        for (int i = 0; i < posicion; i++) {
            puntero = puntero.getSiguiente();
        } 
        
        // Retorna el elemento del nodo
        return puntero.getElemento();
        
    }


    public void agregar(Animador elemento, int posicion){
        //Definimos el nuevo nodo
        Nodo nuevoNodo = new Nodo(elemento);
        
        //Verifica si es vacia
        if (esVacia()){  
            cabeza = nuevoNodo;
        } else {
            // Si la posicion es la inicial
            if (posicion == 0) {
                // Nodo siguiente sera el de la cabeza
                nuevoNodo.setSiguiente(cabeza);
                //Le asignamos la cabeza al nuevo nodo
                cabeza = nuevoNodo;
            } else {
                // Insertar en una posición intermedia o al final de la lista
                Nodo puntero = cabeza;
                for (int i = 0; i < posicion - 1; i++) {
                    puntero = puntero.getSiguiente();
                }
                // El nodo nuevo apunta al nodo siguiente del puntero
                nuevoNodo.setSiguiente(puntero.getSiguiente());
                // El puntero apunta al nuevo nodo 
                puntero.setSiguiente(nuevoNodo);
            }
        }
        lista++;  
    }

    public Lista copia(){
        // Hacemos una lista vacia
        Lista copia = new Lista();
        if (esVacia()){
            //Si es vacia la lista, que retorne null
            return null;
        } else{
            // Creamos un nodo de posicion
            Nodo puntero = cabeza;
            // Inicializamos una variable para la posicion
            int pos = 0;
            while (puntero != null){
                // Obtenemos el elemento del nodo
                Animador elem = puntero.getElemento();
                // Agregamos el elemento de la posicion del nodo
                copia.agregar(elem, pos);
                // Que el puntero apunte al siguiente nodo
                puntero = puntero.getSiguiente();
                //Aumentamos la posicion
                pos++;
            }
            return copia;
        }

    }
    
}
