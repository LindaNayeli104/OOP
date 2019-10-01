import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class EjemploLector{
  public static void main(String args[]){
    try{
    BufferedReader bf = new BufferedReader(new FileReader("/Users/Oscar/desktop/nuevo.txt"));
    String linea;

    while ((linea = bf.readLine()) != null){
      System.out.println(linea);
    }

    System.out.println(linea);
    System.out.println(bf.readLine());
    System.out.println("Fin");
    
    }
    catch (FileNotFoundException ex){
      System.out.println("NO se pudo encontrar");
    }
    catch(IOException ex ){
      System.out.println("NO se pudo leer el archivo");
    }
  }

}
