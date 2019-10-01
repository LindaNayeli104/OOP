import javax.swing.JOptionPane;

public class Division{
	//Oscar Fernández Moreno
	//A07013362
	//Division.java
	// 01/ 03/ 2019
    public static int divisionEntera(int num, int den){
        return num/den;
    }
    public static void main(String args[]){
    	boolean aux = true;
    	//do
    	
    	do{
	        try {
	        	int n = Integer.parseInt(JOptionPane.showInputDialog("Escribe un número"));
	            int d = Integer.parseInt(JOptionPane.showInputDialog("Escribe otro número"));
	            int res = divisionEntera(n,d);
	            aux = false;
	            JOptionPane.showMessageDialog(null, "El resultado de la división entera es: " + res ); 
	        }catch(ArithmeticException excepcion){
	        	JOptionPane.showMessageDialog(null,"No puede haber divisiones entre cero intente de nuevo" + excepcion);
	        } catch (NumberFormatException nfe) {
	        	JOptionPane.showMessageDialog(null,"ERROR\nIngrese solo numeros!!!");
	        }
    	}while(aux);
    	
    	
      

        
    //! TAREA 
        //!Corregir para que cada vez que ocurra una excepcion volver a pedir todos los datos, e indicar el error
        //! volver a pedir los datos 


        
    }
}