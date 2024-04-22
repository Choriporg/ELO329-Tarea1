import javax.xml.stream.events.EntityReference;

/**
 * La clase Mascota representa a una mascota virtual con atributos como nombre, edad, salud, energía y felicidad.
 * También tiene un estado que indica el estado emocional y físico de la mascota.
 * La clase proporciona métodos para interactuar con la mascota, como aplicar medicina, jugar, alimentar, etc.
 * Además, la clase tiene métodos para obtener y establecer los atributos de la mascota, así como para calcular su estado y emoji correspondiente.
 * También tiene métodos para aumentar la edad de la mascota y para dormir.
 * La clase Mascota se utiliza para crear y gestionar mascotas virtuales.
 */
public class Mascota {
 

    private String nombre_mascota;
    private double Edad;
    private int Salud;
    private int Energia;
    private int Felicidad;
    private Estado estado;
   
    //setters de items

    public void aplicarMedicina(){
        Salud = ((Salud+40)>100)? 100 : Salud+40;
    }
    public void aplicarJuguete(){
        Felicidad = ((Felicidad+30)>100)? 100 : Felicidad+30;
    }
    public void aplicarComida(){
        Salud = ((Salud+20)>100)? 100 : Salud+20;
        Energia = ((Energia+20)>100)? 100 : Energia+20;
    }
    
    /* getters */

    public Mascota(String nombre_mascota) {
        this.nombre_mascota = nombre_mascota;
        this.Edad = 0;
        this.Salud = 100;
        this.Energia = 70;
        this.Felicidad = 90;
        setEstado();

    }



    public String getnombre_mascota() {
        return nombre_mascota;
    }

    public double getEdad() {
        return Edad;
    }

    public int getSalud() {
        return Salud;
    }

    public int getEnergia() {
        return Energia;
    }

    public int getFelicidad() {
        return Felicidad;
    }

    public Estado getEstado() {
        return estado;
    }

    /* condicionales */

    public void disminucionFelicidad() {
        
        if (Edad <= 5 && Salud <= 10){
            Felicidad -= 20;
            if (Felicidad < 0) {
                Felicidad = 0;
            }

        } else if (Edad > 5 && Edad <= 10 && Salud <= 50){
            Felicidad -= 20;
            if(Felicidad < 0){
                Felicidad = 0;
            }

            Energia -= 10;

            if(Energia < 0){
                Energia = 0;
            }

        } else if (Edad > 10 && Salud <= 50){
            Felicidad -= 30;
            
            if(Felicidad < 0){
                Felicidad = 0;
            }
            Energia -= 20;

            if(Energia < 0){
                Energia = 0;
            }
        }
        }
        
    

    public void  setEstado() {

        if (Salud == 0 || Energia == 0 || Edad >= 15) {
            this.estado = Estado.Muerto;
        }

        else if (Energia <= 15) {
            this.estado = Estado.Cansado;
        }

        else if (Edad > 5 && Salud <= 30 && Energia <= 30) {
            this.estado = Estado.Enojado;
        }

        else if ((Salud <= 20 && Edad <= 5) || (Salud <= 50 && Edad > 5 && Edad <= 10)) {
            this.estado = Estado.Hambriento;
        }

        else if (Felicidad <= 20) {
            this.estado = Estado.Triste;
        }

        else if (Felicidad >= 60) {
            this.estado = Estado.Feliz;
        }

        else {
            this.estado = Estado.Neutro;
        }

    }


    public String setEmoji(){
        if (estado == Estado.Neutro) {
            return "(-_-) Meh...";
        } else if (estado == Estado.Feliz) {
            return "\\(^_^)/ Weeeeeh!";
        } else if (estado == Estado.Triste) {
            return "(._.) snif...";
        } else if (estado == Estado.Hambriento) {
            return "(0o0) hambre hambre!";
        } else if (estado == Estado.Enojado) {
            return "(ôwô) grrrr....";
        } else if (estado == Estado.Cansado) {
            return "(=_=) zzzz....";
        } else {
            return "(x_x) fin del juego";
        }
    }

    public void aumentarEdad(){
        Edad = ((Edad+0.5)>15)? 15 : Edad+0.5;
        Salud -= 5;
        Energia = ((Energia-5)<=0)? 0 : Energia-5;
        Felicidad = ((Felicidad-5)<=0)? 0 : Felicidad-5;
    }


    public void dormir(){
        Energia = ((Energia+30)>100)? 100 : Energia+30;
        Felicidad = ((Felicidad+15)>100)? 100 : Felicidad+15;
        setEstado();
        System.out.println(">>" + nombre_mascota + " ha dormido como un tronco!!! ^-^\n\n");
    }
    public void mostrarDatos() {
        System.out.println("Atributos");
        System.out.println("\t>> Edad: " + this.Edad);
        System.out.println("\t>> Salud: " + this.Salud);
        System.out.println("\t>> Energía: " + this.Energia);
        System.out.println("\t>> Felicidad: " + this.Felicidad);
        System.out.println("\t>> Estado: " + setEmoji());
    }
}
