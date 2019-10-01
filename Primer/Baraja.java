import java.util.Random;

public class Baraja{
    private Naipe [] cartas;


    public Baraja(){
        this.cartas = new Naipe[52];
        int auxiliar = 0;
        for (int i = 0; i < 4; i++){
            for(int j = 0; j < 13; j ++ ){
                cartas[auxiliar++] = new Naipe(j, i);
            }
        }
    }


    public String toString(){
        String res = "";
        for(int i = 0; i < cartas.length; i++){
            res += this.cartas[i] + "\n";
        }
        return res;
    }

    public void mezcla(){
        Random ran = new Random();
        int posA;
        Naipe auxiliar;
        for (int i = 0; i<this.cartas.length; i++){
            posA= ran.nextInt(52);
            auxiliar = this.cartas[posA];
            this.cartas[posA] = cartas[i];
            this.cartas[i] = auxiliar;
        }
    }


    public static void main(String[] args){
        Baraja baraja = new Baraja();
        System.out.println(baraja);
        /*for (int i = 0; i < baraja.cartas.length; i++){
            System.out.println(baraja.cartas[i]);
        }*/
        baraja.mezcla();
        System.out.println(baraja);




    }




}