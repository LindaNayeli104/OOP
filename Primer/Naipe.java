public class Naipe{
    private int valor, // 0 ->As., 1->2, ..., 10->J, 11 -> Q, 12 ->K]
                palo; //0 -> Espadas, 1 -> Corazones, 2 -> Tréboles, 3 ->Diamantes

    private static String [] strValores = {"As", "Dos", "Tres", "Cuatro", "Cinco", "Seis", "Siete" , "Ocho", "Nueve", "Diez", "Jack", "Reyna", "Rey"},
                    strPalos = {"Espadas", "Corazones", "Tréboles", "Diamantes"};


    public Naipe(int valor, int palo){
        this.valor = valor;
        this.palo = palo;
    }

    public String toString(){
        return Naipe.strValores[this.valor] + " de " + Naipe.strPalos[this.palo];  
    }


    public static void main(String args []){
        Naipe asEspada = new Naipe (0,0);
        Naipe reinaCorazones = new Naipe (11,1);
        System.out.println(asEspada);

    }





}