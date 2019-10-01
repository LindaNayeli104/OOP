public class Habitacion{
    private int numero,
                adultos,
                infantes;

    private double credito,
                    cargo;

    private String nombre;

    private boolean disponible;

    public Habitacion(int n){
        numero = n;
        disponible = true;
    }

    public int getNumero(){
        return numero;
    }

    public boolean getDisponible(){
        return disponible;
    }

    public void checkIn(String nombre, int adultos, int infantes, int credito){
        this.nombre = nombre;
        this.adultos = adultos;
        this.infantes = infantes;
        this.credito = credito;
    }

    public boolean checkOut(){
        if (disponible == true){
            return true;
        }
        else{
            nombre ="";
            numero = 0;
            adultos = 0;
            infantes = 0;
            credito = 0.0;
            cargo = 0.0;
            disponible = true;
            return false;
        }
    }

    public int getTarifa(){
        return this.adultos* 350 + this.infantes*100;
    }

    public boolean realizarCargo(double cantidad){
        if (cantidad < credito) {
            cargo += cantidad;
            return true;
        }
        else{
            return false;
        }   
    }

    public void imprimir(){
        System.out.print("Nombre: " + nombre );
        System.out.print("      Adultos: " + adultos );
        System.out.print("      Infante: " + infantes );
        System.out.print("      Crédito: " + credito );
        System.out.print("      Cargo: " + cargo );
        System.out.println("    Disponible: " + disponible );
    }   

    public static void main(String [] args ){
        Habitacion uno = new Habitacion(100);

        uno.checkIn("Yeomans", 2, 1, 1000);
        uno.checkOut();
        uno.getTarifa();
        uno.realizarCargo(100.00);
        uno.imprimir();





    }




    }

