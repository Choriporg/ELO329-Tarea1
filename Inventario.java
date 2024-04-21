import java.util.ArrayList;

public class Inventario{

    private ArrayList<Item> items;
    public Inventario(){
        items = new ArrayList<>();
        
    }
    public void agregarItem(String tipo,String nombre, int cantidad,Mascota mascota){

        if(tipo.equals("Comida")){
            items.add(new Comida(nombre,cantidad,mascota));
        }
        if(tipo.equals("Juguete")){
            items.add(new Juguete(nombre, cantidad, mascota));
        }
        if(tipo.equals("Medicina")){
            items.add(new Medicina(nombre, cantidad, mascota));
        }
    }
    public void usarItem(int valor){

        for(Item elementos:items){

            if(elementos.obtenerId() == valor){
                //System.out.println(elemento.obtenerId()+" "+elemento.obtenerNombre()+" "+elemento.obtenerCantidad());
                if (elementos instanceof Medicina) {
                    Medicina medicina = (Medicina) elementos;
                    medicina.darMedicina();
                    
                    
                }
                else if(elementos instanceof Comida){
                    Comida comida = (Comida) elementos;
                    comida.darComida();
                    
                }
                else if(elementos instanceof Juguete){
                    Juguete juguete = (Juguete) elementos;
                    juguete.darJuguete();
                    
                }
            }
        }
    }
    public void obtenerItem() {
        for (int i = 0; i < items.size(); i++) {
            if(items.get(i).obtenerCantidad() == 0){
                items.remove(i);
                i--;
            }
            else
                System.out.println("\t>> #" + items.get(i).obtenerId() + " : " + items.get(i).obtenerNombre() + ", cantidad : " + items.get(i).obtenerCantidad());
        }
    }

}
