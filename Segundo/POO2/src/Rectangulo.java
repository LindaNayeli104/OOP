public class Rectangulo implements Figura{ // agregar todos los métodos //! puedes agregae más interfaces
    protected double largo,
                    ancho;

    public Rectangulo(double largo, double ancho){
        this.largo = largo;
        this.ancho = ancho;
    }

    public Rectangulo(){
        this(5.0, 2.0);
    }

    public double perimetro(){
        return (this.ancho* 2) + (this.largo*2);
    }

    public double area(){
        return this.largo*this.ancho;
    }

    public double volumen(){
        return 0.0;
    }

    public String toString(){ // this.lado ERROR busca en todas las clases un atributo que se llame de esa manera
        return "Rectangulo largo" + this.largo + " y ancho " + this.ancho;

    }

    public static void main (String args[]){
        Figura [] figuras = {new Rectangulo(), new Cuadrado(), new Caja()};
        for (int i = 0; i <figuras.length; i++){
            System.out.println(figuras[i]); // LLama a to String 
            System.out.println("El perimetro es " + figuras[i].perimetro());
            System.out.println("El area es " + figuras[i].area());
            System.out.println("El volumen es " + figuras[i].volumen());
            if (figuras[i] instanceof Caja){ // pregunta si es una instancia de una clase //! solo de una caja
                //Caja tmp = (Caja)figuras[i];
                ((Caja)figuras[i]).saluda(); // método directo
            }

        }

        /*
        Figura a = new Figura();
        System.out.println(a); // LLama a to String 
        System.out.println("El perimetro es " + a.perimetro());
        System.out.println("El area es " + a.area());
        System.out.println("El volumen es " + a.volumen());
        


        Figura b = new Rectangulo(); //Estamos haciendolo con la clase Rectangulo
        System.out.println(b);
        System.out.println("El perimetro es " + b.perimetro());
        System.out.println("El area es " + b.area());
        System.out.println("El volumen es " + b.volumen());


        Figura c = new Cuadrado(); //Estamos haciendolo con la clase Cuadrado
        System.out.println(c);
        System.out.println("El perimetro es " + c.perimetro());
        System.out.println("El area es " + c.area());
        System.out.println("El volumen es " + c.volumen());

        Figura d = new Caja(); //Estamos haciendolo con la clase Caja
        System.out.println(d);
        System.out.println("El perimetro es " + d.perimetro());
        System.out.println("El area es " + d.area());
        System.out.println("El volumen es " + d.volumen());*/

    }
}