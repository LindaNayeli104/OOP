import java.util.ArrayList;

public class EjemploWildCard {
	
	//DOBLE
	public static double doble(Number a){
		return a.doubleValue()*2.0;
	}
	
	
	//SUMAR ELEMENTOS
	public static double suma(ArrayList<? extends Number > lista){
		double sumar = 0.0;
		for (int i = 0; i < lista.size(); i++){
			sumar += lista.get(i).doubleValue();
		}
		return sumar;		
	}
	
	
// MAIN
	public static void main(String args[]){
		
		//Double
		ArrayList<Number> numeros = new ArrayList<Number>();
		numeros.add(1.0);
		numeros.add(2.0);
		numeros.add(3.0);
		System.out.println(suma(numeros));
		
		//Enteros
		ArrayList<Number> enteros = new ArrayList<Number>();
		numeros.add(1);
		numeros.add(2);
		numeros.add(3);
		System.out.println(suma(enteros));
		
		//Dobles
		Number a = new Integer (10);
		Integer b = new Integer (20);
		System.out.println(doble(a));
		System.out.println(doble(b));
		
		//Caja (OBJETO)
		ArrayList<Caja> listaDeCajas = new ArrayList();
		listaDeCajas.add(new Caja());
		//System.out.println(suma(listaDeCajas));
		
	}
}
