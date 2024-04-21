import java.util.*;
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

class Comida extends Item{

    public Comida(String nombre, int cantidad,Mascota mascota){
        super("comida",nombre,cantidad,mascota);

    }
    public void darComida(){
        if(cantidad>0)
            mascota.aplicarComida();
            cantidad--;
    }
    public void printItemAplicado(){System.out.println("Dando de comer "+nombre);}

}
class Medicina extends Item{

    public Medicina(String nombre, int cantidad,Mascota mascota){ //constructor de medicina.
        super("medicina",nombre,cantidad,mascota);}

    public void darMedicina(){
        if(cantidad >0)//si la cantidad de este item no satisface, no se podra aplicar la funcion que aumente los valores de la mascota, en este casson salud.
            mascota.aplicarMedicina();//se usa el metodo definido en mascota para modificar atributos del mismo.
            cantidad--;//se disminuye la cantidad de medicina.
        }
    public void printItemAplicado(){System.out.println("Dando la medicina "+nombre);}
}
class Juguete extends Item{

    public Juguete(String nombre, int cantidad,Mascota mascota){
        super("juguete",nombre,cantidad,mascota);
    }

    public void darJuguete(){
        if(cantidad > 0)
            mascota.aplicarJuguete();
            cantidad--;
    }
    public void printItemAplicado(){System.out.println("Usando Juguete" + nombre);}
}
