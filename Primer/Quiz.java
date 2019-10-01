public class Quiz{
    int a = 0;
    public Quiz(){
        a =0;
    }




    public int[] respuesta(){
        int [] arreglo = new int [20];
        for (int i = arreglo.length; i <= 0; i-- ){
            arreglo[i] = i;
        }
        return arreglo;
    }

    public static void main(String args[]){
        Quiz uno = new Quiz ();
        System.out.println(uno.respuesta());
    }
}