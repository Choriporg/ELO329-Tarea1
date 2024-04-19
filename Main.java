import java.io.File;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Scanner;

public class Main{

    //tiempo
    double tiempo = 0.0;    

    //main
    public static void main(String[] args) {

        //tests
        Main testStage= new Main();
        Mascota pow = new Mascota("pow");
        Inventario inv = new Inventario();
        inv.agregarItem("Comida","Hueso",5,pow);
        inv.agregarItem("Juguete","Pelota",3,pow);
        inv.agregarItem("Medicina","Vacuna",2,pow);


        while(pow.estado != Estado.Muerto){
            testStage.menuGeneral(inv, pow);
        }
    };

    public void menuGeneral(Inventario storage, Mascota testMascota){

        Scanner entrada =new Scanner(System.in);

        System.out.println("--------------------");
        System.out.println("tiempo simulado: "+tiempo+" unidades");
        System.out.println("Presione (1) para dormir");
        System.out.println("Presione (2) para mostrar Inventario");
        System.out.println("Presione (3) para ejecutar accion");
        System.out.println("Presione (C) para continuar la simulacion");
        System.out.println("Presione (x) para salir");

        char comando = entrada.next().charAt(0);

        switch(comando){
            case '1':
                //testMascota.dormir();
                tiempo += 0.5;
                break;
            case '2':
                storage.obtenerItem();
                break;
            case '3':
                subMenu(storage, testMascota);
                break;
            case 'C':
                testMascota.mostrarDatos();
                tiempo += 0.5;            
                break;
            case 'x':
                System.exit(0);
                break;
            default:
                System.out.println("Comando no valido");
                break;
        };


    }


    public void subMenu(Inventario storage, Mascota testMascota){

        System.out.println("--Menu de Acciones--");
        System.out.println("Ingrese el id del item a usar");
        System.out.println("Presione (x) para volver al menu principal");
        
        Scanner entrada = new Scanner(System.in);
        String comando = entrada.nextLine();

        if(comando.equals("x")){
            return;
        }
        int valor = Integer.parseInt(comando);
        storage.usarItem(valor);
    };




}
