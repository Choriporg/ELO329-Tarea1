import java.util.*;
/**
 * Esta clase abstracta representa un ítem genérico.
 * Los atributos de la clase son protegidos para que las clases Comida, Juguete y Medicina puedan acceder a ellos.
 */
public abstract class Item {
    // Los atributos serán protected para que las clases Comida, Juguete y Medicina puedan acceder a ellos.

    protected static int counter = 0;//aqui estableci un id que va aumentando segun objetos que se vayan agregando.
    protected int id_siguiente;
    protected int id;
    protected String tipo;
    protected String nombre;
    protected int cantidad;
    protected Mascota mascota;

    //public Item() {}

    public Item(String tipo,String nombre,int cantidad,Mascota mascota) {
        this.tipo = tipo;
        this.nombre = nombre;
        this.cantidad = cantidad;
        this.mascota = mascota;
        this.id = ++counter;
        id_siguiente = id;        
    }

    //aqui estan los getters, nombrados por obtener en cada caso ..
    public String obtenerNombre(){return nombre;}
    public int obtenerCantidad(){return cantidad;}
    public int obtenerId(){return id;}

    public abstract void printItemAplicado();
}

/**
 * Esta clase representa un objeto de tipo Comida que hereda de la clase Item.
 * La clase Comida se utiliza para crear objetos de comida que se pueden dar a una mascota.
 * Cada objeto de Comida tiene un nombre, una cantidad y una mascota asociada.
 * La clase Comida tiene un método darComida() que aplica la comida a la mascota y reduce la cantidad de comida disponible.
 * También tiene un método printItemAplicado() que imprime un mensaje indicando que se está dando de comer a la mascota.
 */
class Comida extends Item{

    public Comida(String nombre, int cantidad,Mascota mascota){
        super("comida",nombre,cantidad,mascota);

    }
    public void darComida(){
        if(cantidad>0)
            mascota.aplicarComida();
            cantidad--;
            printItemAplicado();
    }
    public void printItemAplicado(){System.out.println("\n\t>> Dando de comer "+nombre);}

}
/**
 * Esta clase representa un objeto de tipo Medicina que se puede utilizar para tratar a una mascota.
 * Extiende la clase Item y tiene métodos para dar medicina a una mascota y mostrar un mensaje cuando se aplica la medicina.
 */
class Medicina extends Item{

    public Medicina(String nombre, int cantidad,Mascota mascota){ //constructor de medicina.
        super("medicina",nombre,cantidad,mascota);}

    public void darMedicina(){
        if(cantidad >0)//si la cantidad de este item no satisface, no se podra aplicar la funcion que aumente los valores de la mascota, en este casson salud.
            mascota.aplicarMedicina();//se usa el metodo definido en mascota para modificar atributos del mismo.
            cantidad--;//se disminuye la cantidad de medicina.
            printItemAplicado();
        }
    public void printItemAplicado(){System.out.println("\n\t>> Dando la medicina "+nombre);}
}
/**
 * Esta clase representa un Juguete, que es un tipo de Item.
 * Los juguetes se utilizan para interactuar con una Mascota.
 * Cada juguete tiene un nombre, una cantidad y una mascota asociada.
 */
class Juguete extends Item{

    public Juguete(String nombre, int cantidad,Mascota mascota){
        super("juguete",nombre,cantidad,mascota);
    }

    public void darJuguete(){
        if(cantidad > 0)
            mascota.aplicarJuguete();
            cantidad--;
            printItemAplicado();
    }
    public void printItemAplicado(){System.out.println("\n\t>> Usando Juguete" + nombre);}
}
