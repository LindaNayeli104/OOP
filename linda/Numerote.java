import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class Numerote {

	private byte[] numerote;
	private boolean signo;

	
//CONSTRUCTOR DEFAULT
	public Numerote() {
		numerote = new byte[] {0};      
		signo = true;
	}
	
//CONSTRUCTOR PARAMETRO	
public Numerote(String numero) throws NumberFormatException, StringIndexOutOfBoundsException{
		try {
			byte [] numerote;
			if(numero.contains("-")) {
				signo = false;	
				numerote = new byte[numero.length()-1];
				numero = numero.substring(1,numero.length());            //Quitar el signo menos del numero
				//System.out.println("Numero sin - =" + numero);
			}else {
				signo = true;
				numerote = new byte[numero.length()];
			}
			for(int i = numero.length()-1; i>=0; i--) {

				byte b= (byte)(numero.charAt(i)-'0');   
				int a = numero.length()-i-1;
				//System.out.println("Numero "+ b + " en posicion= " + a);
				numerote[a] = b; 
			}
			this.numerote = numerote;

		}catch (NumberFormatException ex){
			throw ex;
		}catch (StringIndexOutOfBoundsException ex) {
			throw ex;
		}
	}
	
	
//COMPLETAR CON 0´s	
	public byte[] completar(byte[] numerote,int numCeros, int num){            //**
		byte[] nObject2 = new byte[numCeros];
		for(int i=0; i<numCeros;i++) {
			nObject2[i] = 0;
		}
		for(int i=0; i<num;i++) {
			nObject2[i] = numerote[i];
		}
		return nObject2;
	}

	
//SUMA GENERAL	
	public Numerote suma(Numerote nObject) {
		Numerote resultado = new Numerote();                      //?????????????????????????***
//Numeros con signo igual y positivo
		if (nObject.signo == this.signo && this.signo) {
			resultado.numerote = sumaProceso(nObject);
			resultado.signo = true;
			return resultado;
		}
		
//Numeros con signo igual y negativo			                      
		else if (nObject.signo == this.signo && this.signo == false) {
			resultado.numerote = sumaProceso(nObject);
			resultado.signo = false;
			return resultado;
			
		}
		
//1er no. negativo		
		else if(this.signo == false && nObject.signo) {
			resultado = restaProceso(nObject); 
			return resultado;
			
		}
		
//2do numero negativo		
		else if(this.signo && nObject.signo == false) {
			resultado = restaProceso(nObject); 
			return resultado;
			
			
		}
		return resultado;
	}

//SUMA PROCESO
	public byte[] sumaProceso(Numerote nObject) {
		int n1 = this.numerote.length;
		int n2 = nObject.numerote.length;
		int acarreo = 0;
		int suma = 0;    
		byte[] resultado;
		
		
		if(n1 != n2) {
			if(n1 > n2) {
				resultado = new byte[n1+1];
				byte[] nObject2 = completar(nObject.numerote,n1,n2);     //Completa el menor numero con 0's
				
				
				for(int i=0; i<n1;i++) {
					suma = this.numerote[i] + nObject2[i] + acarreo;
					acarreo = 0;
					if(suma>9) {
						acarreo = 1;
						resultado[i] = (byte) (suma - 10);
						resultado[i+1]=(byte) acarreo;
					}else {
						resultado[i] = (byte) (suma); 
						
					}
					
				}
				if(resultado[n1]==0) {
					byte[] temp=new byte[resultado.length-1];
					for(int i=0;i<resultado.length-1;i++) {
						temp[i]=resultado[i];	
					}
					resultado=temp;					
					}
					
			}else {
				resultado = new byte[n2+1];
				byte[] nObject2 = completar(this.numerote,n2,n1);
				for(int i=0; i<n2;i++) {
					suma = nObject.numerote[i] + nObject2[i] + acarreo;
					acarreo = 0;
					if(suma>9) {
						acarreo = 1;
						resultado[i] = (byte) (suma - 10); 
						resultado[i+1]=(byte) acarreo;
					}else {
						resultado[i] = (byte) (suma); 
						
					}
				}
				if(resultado[n2]==0) {
					byte[] temp=new byte[resultado.length-1];
					for(int i=0;i<resultado.length-1;i++) {
						temp[i]=resultado[i];	
					}
					resultado=temp;					
					}
			}
		}else {
			resultado = new byte[n1+1];
			for(int i=0; i<n1;i++) {
				suma = this.numerote[i] + nObject.numerote[i] + acarreo;
				acarreo = 0;
				if(suma>9) {
					acarreo = 1;
					resultado[i] = (byte) (suma - 10); 
					resultado[i+1]=(byte) acarreo;
					}
				else {
					resultado[i] = (byte) (suma); 
						
				}
			}
			if(resultado[n1]==0) {
				byte[] temp=new byte[resultado.length-1];
				for(int i=0;i<resultado.length-1;i++) {
					temp[i]=resultado[i];	
				}
				resultado=temp;					
				}
		}
		return resultado;
	}
	
	

//RESTA GENERAL	
	public Numerote resta(Numerote nObject) {
		
//Numeros con signo igual y positivo
		Numerote resultado = new Numerote();                      //?????????????????????????
		if (nObject.signo == this.signo && this.signo) {
			resultado = restaProceso(nObject);
			
		}
		
//Numeros con signo igual y negativo
		else if (nObject.signo == this.signo && this.signo == false) {
			resultado = restaProceso(nObject);
			
		}
		
//1er no. negativo		
		else if(this.signo == false && nObject.signo) {
			resultado.numerote = sumaProceso(nObject); 
			resultado.signo = false;
		}
		
//2do numero negativo		
		else if(this.signo && nObject.signo == false) {
			resultado.numerote = sumaProceso(nObject); 
			resultado.signo = true;
			
			
		}
		return resultado;
	}
	
	
	
//RESTA PROCESO
	public Numerote restaProceso(Numerote nObject) {
		Numerote resultado = new Numerote(); 
		int n1 = this.numerote.length;
		int n2 = nObject.numerote.length;
		int acarreo = 0;
		int resta = 0;
		
	
		
		if(n1 != n2) {
			if(n1 > n2) {                                        //signo = true;
				resultado.numerote = new byte[n1];
				byte[] nObject2 = completar(nObject.numerote,n1,n2);
					for(int i=0; i<n1;i++) {
						resta = this.numerote[i] + acarreo - nObject2[i];
						acarreo = 0;
						if(resta<0) {
							acarreo = -1;
							resultado.numerote[i] = (byte) (resta + 10); 
						}else {
							acarreo = 0;
							resultado.numerote[i] = (byte) (resta);	
					}
					if(this.signo == false) {
						resultado.signo = false;
					}else {
						resultado.signo = true;
					}
							
			}
		}
			else {                                                                   //signo = false;
				resultado.numerote = new byte[n2];
				byte[] nObject2 = completar(this.numerote,n2,n1);
					for(int i=0; i<n2;i++) {
						resta = nObject.numerote[i] + acarreo - nObject2[i];
						acarreo = 0;
						if(resta<0) {
							acarreo = -1;
							resultado.numerote[i] = (byte) (resta + 10); 
						}else {
							acarreo = 0;
							resultado.numerote[i] = (byte) (resta);
						}
					}
					if(resultado.numerote[n2-1]==0) {
						byte[] temp=new byte[resultado.numerote.length-1];
						for(int i=0;i<resultado.numerote.length-1;i++) {
							temp[i]=resultado.numerote[i];	
						}
						resultado.numerote=temp;					
						}
					if(this.signo == false) {
						resultado.signo = true;
					}else {
						resultado.signo = false;
					}
			}
		}
				
//***					
			else {                                                                                   
				resultado.numerote = new byte[n1];
				byte[] mayorNum = new byte[n1];
				mayorNum = mayor(this.numerote, nObject.numerote);
				if (mayorNum == this.numerote) {                                            // signo = true
					for(int i=0; i<n1;i++) {
						resta = this.numerote[i] + acarreo - nObject.numerote[i];
						acarreo = 0;
						if(resta<0) {
							acarreo = -1;
							resultado.numerote[i] = (byte) (resta + 10); 
						}
						else {
							acarreo = 0;
							resultado.numerote[i] = (byte) (resta);
						}
					}
					if(resultado.numerote[n1-1]==0) {
						byte[] temp=new byte[resultado.numerote.length-1];
						for(int i=0;i<resultado.numerote.length-1;i++) {
							temp[i]=resultado.numerote[i];	
						}
						resultado.numerote=temp;					
						}
					if(this.signo == false) {
						resultado.signo = false;
					}else {
						resultado.signo = true;
					}	
				}
				else {                                                        //signo = false
					for(int i=0; i<n1;i++) {
						resta = nObject.numerote[i] + acarreo - this.numerote[i];
						acarreo = 0;
						if(nObject.numerote[i]!=0 && this.numerote[i]==0 && this.numerote[i+1]!=0) {
							resta=nObject.numerote[i]-10;
							resta=resta*-1;
							this.numerote[i+1]=(byte) (this.numerote[i+1]-1);
							this.signo=false;
						}
						if (resta<0) {
							resta=resta*-1;
						}
						if(resta>9) {
							acarreo = 1;
							resultado.numerote[i] = (byte) (resta - 10); 
							}
						
						else {
							acarreo = 0;
							resultado.numerote[i] = (byte) (resta);
							}
					}
					if(resultado.numerote[n1-1]==0) {
						byte[] temp=new byte[resultado.numerote.length-1];
						for(int i=0;i<resultado.numerote.length-1;i++) {
							temp[i]=resultado.numerote[i];	
						}
						resultado.numerote=temp;					
						}
					if(this.signo == false) {
						resultado.signo = true;
					}else {
						resultado.signo = false;
					}
				}
		}
			return resultado;
	}	
	
			
	
		
		
//ENCONTRAR NUM MAYOR
	public byte[] mayor(byte[] num1, byte[] num2) {
		
		if(num1.length > num2.length) {
			return num1;	
		}
		else if(num2.length > num1.length) {
			return num2;
		}
		else{
			for(int i=num1.length-1; i>=0; i--) {
				if(num1[i] >num2[i]) {
					return num1;
				}else {
					return num2;
				}
			}
		}
		return num1;                                       //No afecta, cierto? Se ignora
	}
			
	
/*MULTIPLICACION
	public Numerote multiplica(Numerote nObject) {
		int n1 = this.numerote.length;
		int n2 = nObject.numerote.length;
		int acarreo = 0;
		int multiplicacion = 0;     
		
		int min;
		int max;
		
		if(n1>n2) {
			min = n2;
			max = n1;
		}
		else {
			min = n1;
			max = n2;
		}
		
		
		
		for(int i=0; i<min;i++) {
			byte[] digitos+Integer.tosString(i) = new byte[7];
		}
		for(int i=0; i<num;i++) {
			nObject2[i] = numerote[i];
		}
		return nObject2;
	}
		
		
	}*/
		
	
	
	
	
//TO STRING
    public String toString() {
        String str = "";

        if (this.signo == false) {
            str += "-";
        }

        for (int i = 0; i < this.numerote.length; i++) {		
            str += this.numerote[this.numerote.length -i -1];
        }
        return str;
    }
	
    
    public static void ejecutaArchivo(String entrada, String salida) {
    	try {
			String linea,
					numero1,
					numero2,
					operacion;
			double tabulador;
			Numerote n1,n2,res;
			StringTokenizer st;
			BufferedReader bf=new BufferedReader(new FileReader(entrada));
			PrintWriter pw=new PrintWriter(new FileWriter(salida));
			pw.println("Resultado");
			while((linea=bf.readLine())!=null ) {
				st=new StringTokenizer(linea);
					numero1=st.nextToken(",");
					numero2=st.nextToken(",");
					operacion=st.nextToken();
					if(operacion.equals("s")) {
						n1=new Numerote(numero1);
						n2=new Numerote(numero2);
						res= n1.suma(n2);
						pw.println(res.toString());
					}
					else if(operacion.equals("r")){
						n1=new Numerote(numero1);
						n2=new Numerote(numero2);
						res= n1.resta(n2);
						pw.println(res.toString());
					}
					else if(operacion.equals("m")){
						n1=new Numerote(numero1);
						n2=new Numerote(numero2);
						res= n1.resta(n2);
						pw.println(res.toString());
					}
			}
			pw.close();
			bf.close();
		}catch(FileNotFoundException e) {
			System.out.println("No se pudo encontrar el archivo");
			
		} catch (IOException e) {
			System.out.println("No se pudo leer el archivo");
		}
    }
	
//MAIN
	public static void main(String[] args) {
		String numero = "1020";
		String numero2 = "-1001";
		

		
		Numerote n2 = new Numerote(numero2);
		Numerote n = new Numerote(numero);
		System.out.println("Numero 2 = " + n2.toString());
		System.out.println("Numero 1 = " + n.toString());
		
		Numerote n3 = n.suma(n2);
		System.out.println("suma= " + n3.toString());
		//Numerote n4 =  n.resta(n2);
		//ejecutaArchivo("entrada.txt", "salida.txt");
		//Numerote n5 = n.multiplica(n2);
		//System.out.println("resta= " + n4.toString());
		//System.out.println("multiplicacion= " + n5.toString());
		
	
	
	}
}