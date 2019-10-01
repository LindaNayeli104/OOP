import javax.swing.*; //!Función de librería

public class IntroJava{
  public static void statusCalificacion(){
    String strCalif = JOptionPane.showInputDialog("Dame un número");
    int calif = Integer.parseInt(strCalif);
    if (calif < 70 ){//!Caso de menor a mayor
      System.out.println("Reprobado");
    }
    else{
      System.out.println("Aprobado");
    }
  }
  public static void numerosDel1al100(){
    for(int i = 0; i < 100; i++){
      System.out.println(i);
    }
  }
  public static void serie(int a){
    for (int i = 0; i < 50; i ++){
      System.out.println(a * i);
    }
  }
  public static int comidas(){
    int comidas = Integer.parseInt(JOptionPane.showInputDialog("¿Cuantas comidas fueron?: "));
    int suma = 0;
    /*int contador = 1;
    while (contador <= comidas){
      int calorías = Integer.parseInt(JOptionPane.showInputDialog("¿Cuantas calorias fueron en la comida " + contador + "?:"));
      suma = calorías + suma;
      contador ++;
    }*/
    for(int i = 0; i<comidas;i++){
      int calorías = Integer.parseInt(JOptionPane.showInputDialog("¿Cuantas calorias fueron en la comida " + (i+1) + "?:"));
      suma = calorías + suma;
    }
    return suma;
  }




  

  
  public static void main(String args[]){
    //statusCalificacion();
    //numerosDel1al100();
    //serie(5);
    System.out.println(comidas());
  }
}
