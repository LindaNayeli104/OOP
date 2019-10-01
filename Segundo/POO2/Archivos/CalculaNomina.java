import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.io.PrintWriter;

public class CalculaNomina{
  public static void main(String arg[]){

    try{
      String linea,
            nombre,
            paterno;

      int hrs;

      double tabulador;

      StringTokenizer st;

    BufferedReader bf = new BufferedReader(new FileReader("horasTrabajadas.txt"));
    bf.readLine();
    PrintWriter pw = new PrintWriter(new FileWriter("/Users/Oscar/desktop/new.csv"));

    while ((linea = bf.readLine()) != null){
      st = new StringTokenizer(linea);
      nombre = st.nextToken();
      paterno = st.nextToken();
      hrs = Integer.parseInt(st.nextToken());
      tabulador = Double.parseDouble(st.nextToken());

      pw.println(nombre + " " + paterno + " " + hrs*tabulador);
      }
      pw.close();
    }
    catch (FileNotFoundException ex){
      System.out.println("NO se pudo encontrar");
    }
    catch(IOException ex ){
      System.out.println("NO se pudo leer el archivo");
    }
  }

  }
