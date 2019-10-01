
public class EjemploMetodoGenerico {

	public static <E>E imprimeArreglo(E[] a){
		for (int i = 0; i < a.length; i++){
			if (i == a.length - 1)
				System.out.println(a[i]); 
			else
				System.out.print(a[i] + ","); 
		}
		return a[0];
		
	}
	public static void main(String args[]){
		Integer [] a = {1,2,4,5,6,7};
		Double [] b = {1.0,2.0,3.0,4.0};
		String [] c = {"Hola", "Mundo"};
		//Llama al funcion
		int res1 =  imprimeArreglo(a);
		double res2 = imprimeArreglo(b);
		String res3 = imprimeArreglo(c);
		
	}
}

