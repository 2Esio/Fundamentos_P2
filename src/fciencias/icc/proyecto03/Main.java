package fciencias.icc.proyecto03;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {    
        Lista lista = new Lista();
        // Creamos instancias de la Animador (hacemos listas) (hacemos elementos)
        Animador Animador1 = new Animador("Malabarista", 5, 800);
        Animador Animador2 = new Animador("Saxofonista", 1, 2000);
        Animador Animador3 = new Animador("Payaso", 2, 900);
        //Agregamos elementos a la lista:
        lista.agregarAnimador(Animador1);
        lista.agregarAnimador(Animador2);
        lista.agregarAnimador(Animador3);    
        
        Scanner scanner = new Scanner(System.in);
        
        int opcionUser;
        
            
        do {
            System.out.println("\n");
            System.out.println("-> Menu <- \n");
            System.out.println("-> [1] <-  Mostrar catalogo");  
            System.out.println("-> [2] <-  Agregar animador");
            System.out.println("-> [3] <-  Agregar empleados a un rol ya existente");
            System.out.println("-> [4] <-  Actualizar pago de un rol ya existente");
            System.out.println("-> [5] <-  Actualizar nombre de un rol ya existente");  
            System.out.println("-> [6] <-  Eliminar empleados a un rol ya existente"); 
            System.out.println("-> [7] <-  Cotizacion para evento"); 
            System.out.println("-> [8] <-  Salir");
            System.out.println("Opcion deseada: ");

        try {
            opcionUser = scanner.nextInt();
            scanner.nextLine(); 
        } catch (InputMismatchException e) {
            System.out.println("Error: Ingrese un numero entero valido.");
            scanner.nextLine(); 
            opcionUser = -1; 
        }

            switch(opcionUser){

                case 1:
                System.out.println(" -> Catalogo <- "); 
                lista.listar();
                System.out.println(" "); 
                break;


                case 2:
                try {
                System.out.println(" -> Agregar animador <- "); 
                System.out.println("Nombre del animador: ");
                String animador = scanner.nextLine();
                System.out.println("Cantidad de gente contratada: ");
                int cantidad = scanner.nextInt();
                scanner.nextLine();
            
                System.out.println("Ingrese el pago por hora: ");
                int pago = scanner.nextInt();
                scanner.nextLine();
            
                Animador Animador4 = new Animador(animador, cantidad, pago);
                lista.agregarAnimador(Animador4);
                lista.listar();
                } catch (InputMismatchException e) {
                        System.out.println("Error: Ingrese valores validos.");
                        scanner.nextLine(); 
                }
                break;   
                

                case 3:
                System.out.println(" -> Agregar empleados a un rol ya existente <- "); 
                System.out.println("Numero del animador: ");
                int posicion = scanner.nextInt();
                scanner.nextLine();
                System.out.println("Cantidad de trabajadores contratados: ");
                int cantidad = scanner.nextInt();
                scanner.nextLine();
                lista.agregarCantidadDelMismoRol(posicion, cantidad);
                lista.listar();
                break;


                case 4:
                System.out.println(" -> Actualizar pago de un rol ya existente <- "); 
                System.out.println("Numero del animador: ");
                int posicion1 = scanner.nextInt();
                scanner.nextLine();
                System.out.println("Cantidad de pago a actualizar: ");
                int pago = scanner.nextInt();
                scanner.nextLine();
                lista.actualizarPago(posicion1, pago);
                lista.listar();
                break;   


                case 5:
                System.out.println(" -> Actualizar nombre de un rol ya existente <- "); 
                System.out.println("Numero del animador: ");
                int posicion2 = scanner.nextInt();
                scanner.nextLine();
                System.out.println("Renombre del animador: ");
                String nuevoNombre = scanner.nextLine();
                lista.actualizarRol(posicion2, nuevoNombre);
                lista.listar();
                break;   


                case 6:
                System.out.println(" -> Eliminar empleados a un rol ya existente <- ");
                System.out.println("Numero del animador: ");
                int posicion3 = scanner.nextInt();
                scanner.nextLine();
                System.out.println("Cantidad de trabajadores a eliminar: ");
                int cantidadEliminada = scanner.nextInt();
                scanner.nextLine();
                lista.eliminarCantidadDelMismoRol(posicion3, cantidadEliminada);
                lista.listar();
                break; 

                case 7:
                System.out.println(" -> Cotizacion para evento <- ");
                Lista lista1 = lista.copia();
                System.out.println("Ingrese el numero de horas que durara el evento: ");
                int duracionEvento = scanner.nextInt();
                scanner.nextLine();
                
                
                int costoTotalEvento = 0;
                
                while (true) {
                    System.out.println("-> Opciones de animadores para el evento <-");
                    lista1.listar();
                    System.out.println("Ingrese el numero del animador que desea (o ingrese 0 para finalizar la cotizacion): ");
                    int opcionAnimador = scanner.nextInt();
                    scanner.nextLine();

                    if (opcionAnimador == 0) {
                        break;
                    }

                    System.out.println("Ingrese la cantidad de trabajadores que desea para este animador: ");
                    int cantidadTrabajadores = scanner.nextInt();
                    scanner.nextLine();
                
                    Animador animadorSeleccionado = lista1.getElemento(opcionAnimador - 1);
                

                    if (cantidadTrabajadores > animadorSeleccionado.getCantidad()) {
                        System.out.println("Error: La cantidad de trabajadores ingresada es mayor a los disponibles");
                        continue; 
                    }
                    
                    lista1.eliminarCantidadDelMismoRol(opcionAnimador, cantidadTrabajadores);
                    int costoTotalAnimador = animadorSeleccionado.getPagoPorHora() * cantidadTrabajadores * duracionEvento;
                    costoTotalEvento += costoTotalAnimador;
                
                    System.out.println("Cotización parcial:");
                    System.out.println("Animador: " + animadorSeleccionado.getAnimador());
                    System.out.println("Cantidad de trabajadores: " + cantidadTrabajadores);
                    System.out.println("Duracion del evento: " + duracionEvento + " horas");
                    System.out.println("Costo total para este animador: $" + costoTotalAnimador);
                    System.out.println();
                }
                
                System.out.println("Costo total del evento: $" + costoTotalEvento); 
                break;
   

                case 8:
                System.out.println("\n");
                System.out.println("<-- El programa a terminado -->");
                System.out.println("\n");
                break;


                default:
                System.out.println("Opcion no valida. Por favor, elija nuevamente.");
                break;

            }

        } while (opcionUser != 8);
            scanner.close();
    }
}
