public class EjemploArreglos {
    //Oscar Fernández Moreno
    //A07013362
    //11/02/2019
    //EjemploArreglos.java
    public int suma (int [] arreglo){
        int res = 0;
        for (int i = 0; i < arreglo.length; i++){
            res+=arreglo[i];
        }
        return res;
    }

    public int maximo(int[] arreglo){
        int mayor = arreglo[0];
        for (int i = 0; i < arreglo.length; i++){
            if (mayor < arreglo[i]){
                mayor = arreglo[i];
            }
        }
        return mayor;
    }

    public void imprime(String [][] palabras){
        for (int i = 0 ; i < palabras.length; i++){
            for (int j = 0 ; j < palabras[i].length; j++){
                System.out.println(palabras[i][j]);
            }
        }
    }

    public int minimo(int[] arreglo){
        int menor = arreglo[0];
        for (int i = 0; i < arreglo.length; i++){
            if (menor > arreglo[i]){
                menor = arreglo[i];
            }
        }
        return menor;
    }

    public double promedio(int[] arreglo){
        double res = 0;
        for (int i = 0; i < arreglo.length; i++){
            res+=arreglo[i];
        }
        return res/arreglo.length;
    }

    public static void main(String args[]){
        int columna = Integer.parseInt(args[0]);
        int fila = Integer.parseInt(args[1]);
        
        int auxiliar = 0;
        String[][] letras = new String [fila][columna];
        for (int i = 0; i < fila; i++){
            for (int j = 0; j < columna; j++ ){
                letras[i][j] = args[2+auxiliar];
                auxiliar++;
            }
        }

        for (int i = 0; i < letras.length; i++) {
            for (int j = 0; j < letras[i].length; j++) {
                System.out.print(letras[i][j] + " ");
            }
            System.out.println();
        }






        EjemploArreglos ea = new EjemploArreglos();
        int [] numeros = {4,5,6,7,5,3};
        System.out.println("Suma: "+ea.suma(numeros));
        System.out.println("Maximo: "+ea.maximo(numeros));
        System.out.println("Minimo: "+ea.minimo(numeros));
        System.out.println("Promedio: " + ea.promedio(numeros));

        String[][] nombres = {{"JA", "Hector", "JM", "Guiterrez"}, {"Eduardo", "a", "b"}, {"c", "d", "e"}};

    }
}