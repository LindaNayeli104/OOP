
public class EjemploClaseGenerica<E extends Comparable<E>> { //Leer porque se pone la E
	private E[] arreglo;
	
	public EjemploClaseGenerica(E[] arreglo){
		this.arreglo = arreglo;
	}
	
	public E min(){
		E menor = this.arreglo[0];
		for(int i = 0; i < this.arreglo.length; i++ ){
			if (menor.compareTo( this.arreglo[i]) >0 ){
				menor = this.arreglo[i];
			}
		}
		return menor;
	}
	public static void main(String args[]){
		Integer [] a = {1,2,4,5,6,7};
		Double [] b = {1.0,2.0,3.0,4.0};
		String [] c = {"Hola", "Mundo"};
		EjemploClaseGenerica<Integer> obj1 = new EjemploClaseGenerica<>(a);
		EjemploClaseGenerica<Double> obj2 = new EjemploClaseGenerica<>(b);
		EjemploClaseGenerica<String> obj3 = new EjemploClaseGenerica<>(c);
		System.out.println(obj1.min());
		System.out.println(obj2.min());
		System.out.println(obj3.min());
	

	}
}
