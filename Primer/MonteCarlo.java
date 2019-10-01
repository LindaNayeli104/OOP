public class MonteCarlo{
    //Oscar Fernandez Moreno_A07013362
    //MonteCarlo.java
    //23/Ene/2019
    //valor más aproximado que me imprimió 3.1415939141593916
    //valor real de pi = 3.14159265358979323846
    public static double aproximarPi(int veces){
        double aciertos = 0;
        for (int a = 0; a <veces; a++){
            double i = Math.random( );
            double j = Math.random( );
            double x = -1 + 2 * i;
            double y = -1 + 2 * j;
            double dardo = (Math.pow(x,2)) + (Math.pow(y,2));
            if (dardo <= 1){
                aciertos +=1;
            }
        }
        double pi= (4*aciertos)/veces;
        return(pi) ;

    }
    public static void main(String args[]){
        System.out.println(aproximarPi(9999999));
        

        
        
        
        
    }
}