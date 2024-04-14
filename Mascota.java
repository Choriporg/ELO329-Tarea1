import javax.xml.stream.events.EntityReference;

public class Mascota {
    /*Completar con los métodos, atributos y constructor de Mascota
    dependiendo de la etapa*/

    /* 2.1 Mascota virtual */

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

    /* condicionales */

    public void disminucionFelicidad(int tiempo) {
        if (Salud <= 10) {
            Felicidad -= (20 * tiempo);
        } else if (Salud <= 50 && (5 < Edad && Edad <= 10)) {
            Felicidad -= (20 * tiempo);
            Energia -= (10 * tiempo);
        } else if (Salud <= 50 && Edad > 10) {
            Felicidad -= (30 * tiempo);
            Energia -= (20 * tiempo);
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

    public void mostrarDatos() {
        System.out.println("Atributos \n ------------- ");
        System.out.println("Edad: " + this.Edad);
        System.out.println("Salud: " + this.Salud);
        System.out.println("Energía: " + this.Energia);
        System.out.println("Felicidad: " + this.Felicidad);
        System.out.println("Estado: " + setEmoji());
    }
}
