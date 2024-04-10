import java.io.File;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        // Carga de archivo config.csv
        if (args.length != 1) {
            System.out.println("Usage: java Stage1 <config.csv>");
            System.exit(-1);
        }

        Scanner in = new Scanner(new File(args[0]));
        Main stage1 = new Main();
        // Lectura de archivo config.csv
        stage1.readConfiguration(in);

        stage1.executeAction(new Scanner(System.in), System.out);
    }

    public void readConfiguration(Scanner in){
        // Creación de mascota
        String nombre_mascota = in.nextLine();
        mascota = new Mascota(nombre_mascota);
        // Creación de inventario vacío
        inventario = new Inventario();
        // Llenando inventario
        while (in.hasNextLine()) {
            String linea = in.nextLine();
            String[] item_csv = linea.split(";");
            int id = Integer.parseInt(item_csv[0]);
            String tipoItem = item_csv[1];
            String nombreItem = item_csv[2];
            int cantidad = Integer.parseInt(item_csv[3]);
            
            /* Completar código para inicialización de inventario en la etapa
            que corresponda */
        }
    }
    
    public void executeAction(Scanner in, PrintStream out){
        /* Completar código con manejo de acciones y menú en las etapas que corresponda
        e incremento del tiempo dependiendo de la etapa */
    
    }

    public void printEstado(float step, PrintStream out){
        /* Completar método que muestra el estado de la Mascota y del inventario
        dependiendo de la etapa */

    }

    private Mascota mascota;
    // private Inventario inventario; // Descomentar cuando se haya creado el inventario
}
