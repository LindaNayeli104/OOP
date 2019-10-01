import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.StringTokenizer;

import javax.swing.JOptionPane;

public class Numerote {
	
//OSCAR FERNÁNDEZ MORENO A07013362
//DIEGO ARMANDO VÁZQUEZ CALDERÓN 	A00226803
//PROYECTO: NUMEROTE
//CLASE: Numerote.java
//10/04/2019
	
	//ATRIBUTOS
	boolean signo;
    byte[] numerote; 
    

    //CONSTRUCTOR SIN PARÁMETROS 
    public Numerote() {
        numerote = new byte[] {0};
        signo = true;
    }

    //CONSTRUCTOR CON PARÁMETROS
    public Numerote(String n) throws NumberFormatException, StringIndexOutOfBoundsException{
        //ARRAY CON CEROS Y CHECA SI ES NEGATIVO O POSITIVO  
    	try {
    		 String nada = "";
    	    	byte[] newByte;
    	    	
    	    	if(n.charAt(0) == '-') {
    	    		this.signo = false;
    	    		n = n.substring(1);
    	    	}else {
    	    		this.signo = true;
    	    	}
    	    	
    	    	for(int i=0;i<n.length();i++) {
    	    		nada += n.charAt((n.length()-1)-i);
    	    	}
    	    	newByte = new byte[nada.length()];
    	    	
    	    	for(int i=0;i<nada.length();i++) {
    	    		newByte[i] = Byte.parseByte(nada.substring(i,i+1));
    	    	}
    	    	this.numerote = newByte;
    	        
    	}catch (NumberFormatException ex){
    		throw ex;
    	}catch (StringIndexOutOfBoundsException ex) {
    		throw ex;
    	}
        
        
    }

    //COMBINACIONES
     	//DOS POSITIVOS
    	//UNO DE LOS NEGATIVOS

    //SUMA
    public Numerote suma(Numerote b) {
    	//CHECA SI ES CERO
    	if (this.toString().equals("0") && b.toString().equals("0")) {
            return new Numerote("0");
        }
    	
    	Numerote c = new Numerote();
    	Numerote a = this.ceros();
    	b = b.ceros();
    	
    	Numerote mayorNumerote, menorNumerote;
        //TAMAÑO DE LOS ARREGLOS
        if (a.mayorIgual(b)) {					
            mayorNumerote = a;
            menorNumerote = b;
        } else {
            mayorNumerote = b;
            menorNumerote = a;
        }
     
        // SE CREA UN ARREGLO NUEVO CON UN ESPACIO DE MÁS POR LO DEL CARRY
        c.numerote = new byte[mayorNumerote.numerote.length + 1];

        
        if (!a.signo && !b.signo) { 				//LOS DOS SON NEGATIVOS
            c.signo = false; 
        }  else if (a.signo && !b.signo) {		//SI SOLO B ES NEGATIVO
            b.signo = false;
        	return a.resta(b);
        }else if (!a.signo && b.signo) {		//SI SOLO A ES NEGATIVO
            a.signo = true;
        	return b.resta(a);
        }
       
        //SUMA
        int aux = 0;
        for (int i = 0; i < menorNumerote.numerote.length; i++){
        	 byte res = (byte) (this.numerote[i] + b.numerote[i] + c.numerote[i]);
             c.numerote[i] = (byte) (res % 10);
             if (res >= 10)
                 c.numerote[i + 1]++;
             aux ++;
        }
        
        
        for (int i = aux; i < mayorNumerote.numerote.length; i++){
        		c.numerote[i] += mayorNumerote.numerote[i];
        }
        
        if (c.ceros().toString().equals("")) {
            return new Numerote("0");
        }
        
        return c.ceros();
    }

    
    //RESTA
    public Numerote resta(Numerote b) {
    	
    		//COMBINACIONES
			//DOS POSITIVOS
 			//UNO DE LOS NEGATIVOS
    		//LLAMAMOS PARA VER SI HAY CEROS
    	
    	//CUANDO ES CERO
    	if (this.toString().equals("0") && b.toString().equals("0")) {
            return new Numerote("0");
        }
    	
    	Numerote a = this.ceros();
        b = b.ceros();

        Numerote z = new Numerote();

        if (!a.signo && !b.signo) {				//DOS NEGATIVOS
            b.signo = true;
            a.signo = true;
            z = b.resta(a);
            if (z.ceros().toString().equals("")) {
                return new Numerote("0");
            }
            return z.ceros();
            
        } else if (!a.signo && b.signo) {		//SOLO A NEGATIVO
            b.signo = true;
            a.signo = true;
            z = a.suma(b);
            z.signo = false;
            if (z.ceros().toString().equals("")) {
                return new Numerote("0");
            }
            return z.ceros();
            
        } else if (a.signo && !b.signo) {		//SOLO B NEGATIVO
            b.signo = true;
            a.signo = true;
            z = a.suma(b);
            z.signo = true;
            if (z.ceros().toString().equals("")) {
                return new Numerote("0");
            }
            return z.ceros();
        }

        Numerote mayorNumerote, menorNumerote;
        //TAMAÑO DE LOS ARREGLOS
        if (a.mayorIgual(b)) {					
            mayorNumerote = a;
            menorNumerote = b;
            z.signo = true;
            
        } else {
            mayorNumerote = b;
            menorNumerote = a;
            z.signo = false;
        }
        
        //LA SUMA PARA LA RESTA
        z.numerote = new byte[mayorNumerote.numerote.length + 1];  //CARRY OUT    
        int aux = 0;
        
        for (int i = 0; i < menorNumerote.numerote.length; i++){
        	byte res = (byte) ((mayorNumerote.numerote[i] - menorNumerote.numerote[i]) + 	z.numerote[i]);
            z.numerote[i] = (byte) ((10 + res) % 10);
            if (res < 0)
                z.numerote[i + 1]--;
             aux++;
             
        }

        for (int i = aux; i < mayorNumerote.numerote.length; i++){
        		z.numerote[i] += mayorNumerote.numerote[i];
        }
        
        if (z.ceros().toString().equals("")) {
            return new Numerote("0");
        }

        
        return z.ceros();
    }

    
    
    
  //CUAL DE LOS DOS ES EL MÁS GRANDE
    public boolean mayorIgual(Numerote b) {
    	Numerote a = this.ceros();
        b = b.ceros();

        if (a.numerote.length > b.numerote.length) {			//A MAS GRANDE QUE B
        	
            return true;
            
        } else if (a.numerote.length < b.numerote.length) {		//B ES MAS GRANDE QUE A
        	
            return false;
            
        } else if (a.numerote.length == b.numerote.length) {	// A == B
        	//CHECA CADA ELEMENTO DE LOS ARREGLO
            for (int i = a.numerote.length - 1; i >= 0; i--) {	
            	
                if (a.numerote[i] >= b.numerote[i]) {
                	
                    return true;
                    
                } else {
                	
                    return false;
                }
                
            }
            // SI SON IGUALES
            return false;
            
        }
        
        return false;
    }
    
    
    //CHECA CEROS
    public Numerote ceros() {
    	//CUENTA CEROS INT
        int contarCeros = 0;
        
        //ENCUENTRA CUANTOS CEROS CUENTA
        for (int j = this.numerote.length - 1; j >= 0; j--) {
            if (this.numerote[j] == 0) {
                contarCeros++;
            } else {
                break;
            }
        }

        Numerote c = new Numerote();
        c.signo = this.signo;
        
        //Nuevo
        c.numerote = new byte[this.numerote.length - contarCeros];
        
        for (int i = this.numerote.length - contarCeros - 1; i >= 0; i--) {
            c.numerote[i] = this.numerote[i];
        }
        return c;
    }

    

    
    //MULTIPLICACION
    public Numerote multiplica(Numerote b) {
    	
    	//CASO CUANDO ES CERO
    	if (this.toString().equals("0") && b.toString().equals("0")) {
            return new Numerote("0");
        }
    	
    	//CREANDO NUEVOS NUMEROTES
    	Numerote a = this.ceros();
        b = b.ceros();     
        Numerote t = new Numerote();
        
        t.numerote = new byte[a.numerote.length + b.numerote.length];
        
        //STRING AUXILIAR
        String stringMultiplica = "";
        
        //NUEVO NUMEROTE PARA LA SUMA 
        Numerote z = new Numerote();
        
        //CARRY
        int res;

        //MULTIPLICA
        for (int i = 0; i < a.numerote.length; i++) {
        	// TAMAÑO DEL NUEVO NUMEROTE
            z.numerote = new byte[a.numerote.length + b.numerote.length];
            
            //FOR DE LA MULTIPLICACION
            for (int j = 0; j < b.numerote.length; j++) {
            	//RESULTADO DE LA MULTIPLICACIÓN MÁS EL CARRY
                res = ((a.numerote[i] * b.numerote[j] + z.numerote[j]));
                
                //CARRY
                z.numerote[j] = (byte) ((a.numerote[i] * b.numerote[j] + z.numerote[j]) % 10);
                
                //ACTUALIZACION DEL CARRY
                z.numerote[j + 1] = (byte) (res / 10);
            }
            
            //HACER UN NUEVO NUMEROTE CON LOS RESULTADOS
            Numerote numerotel = new Numerote(z.toString() + stringMultiplica);
            
            //SUMA EL NUEVO NUMEROTE Y EL NUMEROTE ACTUAL DEL FOR
            t = t.suma(numerotel);
            
            //AÑADE A MULTIPLICA
            stringMultiplica += "0";
        }

        //CHECA EL SIGNO
        if (a.signo ^ b.signo)
            t.signo = false;
        else
            t.signo = true;

        //CHECA SI UNO DE LOS NUMEROTES ES UN CERO
        if (t.ceros().toString().equals("")) {
            return new Numerote("0");
        }
        
        //RETORNA EL NUEVO NUMEROTE
        return t.ceros();
    }
    
    
    
    

    //TO STRING
    public String toString() {
        String vacio = " ";

        if (this.signo == false) {//CHECA SI ES NEGATIVO
            vacio += "-";
        }
        
        for (int i = 0; i < this.numerote.length; i++) {		
        	//INSERTA VALORES DE DERECHA A IZQUIERDA
        	if(vacio.charAt(i) == '-' && i != 0) {
        		vacio += "";
        	}else {
        		vacio += this.numerote[this.numerote.length - i - 1];  
        	}   
        }
        vacio = vacio.substring(1);
        if (this.signo == false)
        		vacio += vacio.charAt(this.numerote.length-1);

        return vacio;
    }
    
    public static void ejecutaArchivo(String entrada, String salida)throws Exception{
    	StringTokenizer st ;
		String linea,
				numero1,
				numero2;
		Numerote resultado;
	
	    try {
		    PrintWriter pw = new PrintWriter(new FileWriter("salida.txt"));
		    
			st = new StringTokenizer(entrada, ",");
			numero1 = st.nextToken();
			numero2 = st.nextToken();
			
			      if (salida.equals("s")){
			    	  Numerote operando1 = new Numerote(numero1);
			    	  Numerote operando2 = new Numerote(numero2);
			    	  resultado = operando1.suma(operando2);
			    	  pw.println(resultado);
	  
			      }else if (salida.equals("r")){
			    	  Numerote operando1 = new Numerote(numero1);
			    	  Numerote operando2 = new Numerote(numero2);
			    	  resultado = operando1.resta(operando2);
			    	  pw.println(resultado);
			    	  
			      }else if(salida.equals("m")){
			    	  Numerote operando1 = new Numerote(numero1);
			    	  Numerote operando2 = new Numerote(numero2);
			    	  resultado = operando1.multiplica(operando2);
			    	  pw.println(resultado); 
			      }else {
			    	  pw.close();
			    	  throw new Exception("El archivo contiene operaciones invalidas");
			      }  
			pw.close();
			
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null,"Un error ha interrumpido el proceso");
		}
    }
    	
    	
    

    public static void main(String[] args) {
     //PRUEBAS
    	 System.out.println(new Numerote("10").resta(new Numerote("11")));

    }
}
