import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class EjemploEscritor{
  public static void main(String args[]){
    try{
    	FileWriter fw = new FileWriter("nuevo.txt");
    	PrintWriter pw = new PrintWriter(fw);  
    	pw.println("Este archivo de texto lo estoy generando desde JAVA");
    	pw.println("Espero que todo funcione correctamente");
    	pw.println("Bueno bye!!!!");
    	for (int i = 0; i <100; i++){
    		pw.println(i);
    	}
      pw.close();
    }
    catch(IOException ex){
      System.out.println("Error" + ex);
    }


  }
}
