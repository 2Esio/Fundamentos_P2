package fciencias.icc.proyecto03;

public class Animador {
    // Atributos (variables)
    private String animador;
    private int cantidad;
    private int pagoPorHora;


    /**
     * Contstructor para el animador
     * @param animador el rol del animador
     * @param cantidad la cantidad de animadores del mismo rol
     * @param pagoPorHora es el pago que le dan al animador por hora
     */
     
     public Animador(String animador, int cantidad, int pagoPorHora){
        //Aquí va tu código
        this.animador = animador;
        this.cantidad = cantidad;
        this.pagoPorHora = pagoPorHora;
       
    }

    /**
     * Metodo que ayuda a visualizar los animadores disponibles en forma 
     * de lista en la terminal
     */

    public String toString() {
        return "Animador: " + animador + ", Cantidad: " + cantidad + ", Paga: $" + pagoPorHora;
    }
    
    
    /**
     * Los métodos getters y setters 
     * de todos los atributos de la clase Animador
     * animador, cantidad, pagoPorHora
     */

    /**
	* Modifica el rol del animador
	* @param animador el nuevo nombre del animador
	*/
     public void setAnimador(String animador){
        this.animador = animador;
    }

    /**
	* Regresa el rol del animador
    * @return el rol del animador
	*/
    public String getAnimador(){
        return this.animador;
    }

    /**
	* Modifica la cantidad de animadores con el mismo rol
	* @param cantidad es la nueva cantidad de animadores con el mismo rol
	*/
    public void setCantidad(int cantidad){
        this.cantidad = cantidad;
    }

    /**
	* Regresa la cantidad de animadores con el mismo rol
    * @return la cantidad
	*/

    public int getCantidad(){
        return cantidad;
    }

    /**
     * Modifica el pago de los animadores con el mismo rol 
     * @param pagoPorHora es el nuevo pago de los animadores con el mismo rol
     */

    public void setPagoPorHora(int pagoPorHora){
        this.pagoPorHora = pagoPorHora;
    }

    /**
     * Regresa el pago de los animadores con el mismo rol
     * @return el pago
     */

     public int getPagoPorHora(){
        return this.pagoPorHora;
     }
}
