import java.io.File;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Scanner;

public class Main{
    static int incrementoTiempo = 0;
    static Mascota mascota;
    static Inventario inventary;

    //main
    public static void main(String[] args) throws IOException{

        // Carga de archivo config.csv
        if (args.length != 1) {
            System.out.println("Usage: java Stage1 <config.csv>");
            System.exit(-1);
        }

        //llama a scanner y le pasa config.csv
        Scanner in = new Scanner(new File(args[0]));
        Main stage1 = new Main();

        // Lectura de archivo config.csv
        stage1.readConfiguration(in);
        System.out.println("Configuración leída correctamente\n");
        stage1.mostrarEstadisticas();
        
        //Bucle principal de la simulación, se ejecutará hasta la muerte de la mascota.
        while(mascota.getEstado() != Estado.Muerto){
            stage1.menuGeneral();
        }

        mascota.mostrarDatos();
        System.out.println(">> La mascota ha muerto :c"); 
    };

    public void mostrarEstadisticas(){
        System.out.println("\nEstádisticas de " + mascota.getnombre_mascota() + ":");
        System.out.println("--------------------");
        mascota.mostrarDatos();
        System.out.println("--------------------\n");
    };

    public void menuGeneral(){
        //Scanner para leer la entrada del usuario.
        Scanner entrada =new Scanner(System.in);

        System.out.println("tiempo simulado: " + incrementoTiempo * 0.5 + " unidades");
        System.out.println(">> Presione (1) para dormir");
        System.out.println(">> Presione (2) para mostrar inventario");
        System.out.println(">> Presione (3) para ejecutar accion");
        System.out.println(">> Presione (C) para continuar la simulacion");
        System.out.println(">> Presione (x) para salir");

        char comando = entrada.next().charAt(0);

        switch(comando){
            case '1':
                mascota.dormir();
                incrementoTiempo++;
                mascota.setEstado();
                mostrarEstadisticas();
                break;

            case '2':
                mostrarEstadisticas();
                System.out.println("--inventario--");
                inventary.obtenerItem();
                System.out.println();
                break;

            case '3':
                subMenu();
                mostrarEstadisticas();
                break;

            case 'C':
                mascota.aumentarEdad();
                incrementoTiempo++;        
                mascota.disminucionFelicidad(incrementoTiempo);
                mascota.setEstado();  
                System.out.println("Avanzando en el tiempo...\n");
                mostrarEstadisticas();
                break;

            case 'x':
                System.out.println("Hasta la próxima!");
                System.exit(0);
                break;

            default:
                System.out.println("Comando no valido");
                break;
        };

        //mostrarEstadisticas(pet);
    }

    public void subMenu(){
        //Mostrando inventario
        System.out.println("--Menu de Acciones--");
        System.out.println("\t>> Ingrese el id del item a usar");
        System.out.println("\t>> Presione (x) para volver al menu principal");
        
        Scanner entrada = new Scanner(System.in);
        String comando = entrada.nextLine();

        if(comando.equals("x") == false){
           int valor = Integer.parseInt(comando);
            inventary.usarItem(valor);
            mostrarEstadisticas();
        }
    };

    public void readConfiguration(Scanner in) {
        // Creación de mascota
        String nombre_mascota = in.nextLine();
        mascota = new Mascota(nombre_mascota);

        // Creación de inventario vacío
        inventary = new Inventario();
        
        // Llenando inventario
        while (in.hasNextLine()) {
            String linea = in.nextLine();
            String[] item_csv = linea.split(";");
            String tipoItem = item_csv[1];
            String nombreItem = item_csv[2];
            int cantidad = Integer.parseInt(item_csv[3]);
            inventary.agregarItem(tipoItem, nombreItem, cantidad, mascota);
        }
    }
}
