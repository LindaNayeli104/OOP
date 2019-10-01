import java.util.Scanner;

public class Arreglos{
    public static void main(String args []){
        /*int [] numeros = new int [100];

        numeros[5] = 6;
        int suma = 0;
        double media = 0;

        System.out.println(numeros[5]);
        
        for (int i = 0; i<numeros.length; i++){
            numeros[i] = i+1;
            suma += numeros[i];
        }

        System.out.println(suma);
        media = suma/numeros.length;
        System.out.println(media);*/
        
        /*
        Scanner sn = new Scanner(System.in);
        System.out.println("Ingrese una longitud");
        int longitud = sn.nextInt();
        int numeros [] = new int [longitud];
        int num;

        for(int i = 0; i < numeros.length; i++){
            System.out.println("Inserte un número en la posición " + i);
            do{ 
                num = sn.nextInt();
                if (!(num > 0 && num<10)){
                    System.out.println("Error. Solo números de 1 al 10 "
                                        + "Inserte un número en la posición " + i);
                }
            }while(!(num > 0 && num<10));
            
            numeros[i] = num;
        }

        System.out.println("Estos son los números elegido por el usuario");
        for(int i =0;i < numeros.length;i++){
            System.out.println(numeros[i]);
        }*/

        /*
        Scanner sn = new Scanner(System.in);
        System.out.println("Ingrese una longitud");
        int longitud = sn.nextInt();
        int numeros [] = new int [longitud];
        int num;

        for(int i = 0; i < numeros.length; i++){
            numeros[i] = numeroAleatorio(0, 10);
            System.out.println("En la posicion " + i + " es " + numeros[i]);
        }


    }
    public static int numeroAleatorio(int minimo, int maximo){
        return (int)Math.floor(Math.random()) * (minimo-(maximo+1)+ (maximo+1));
    }*/





    }
}
