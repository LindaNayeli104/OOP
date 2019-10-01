public class Caja extends Rectangulo{
    protected double alto;
    
    public Caja (double alto, double largo, double ancho){
        super(largo, ancho); //primer linea de código para pasar parámetros
        this.alto = alto;
    }

    public Caja(){
        this(3.0,7.0,9.0);
    }

    public double perimetro(){ //!TAREA
        return (this.largo*4.0) + (this.ancho* 2.0) + (this.alto*8.0);
    }

    public double area(){
        return 2.0*((this.ancho * this.alto) + (this.largo*this.ancho) + (this.alto*this.largo));
    }

    public double volumen(){
        return this.alto * this.ancho * this.largo; // super.area() obtener el ara de rectángulo
    }

    public String toString(){ // this.lado ERROR busca en todas las clases un atributo que se llame de esa manera
        return "\n" +"Caja largo " + this.largo + ", ancho " + this.ancho + " y alto" + this.alto;
    }

    public void saluda(){
        System.out.println("Hola soy una caja");
    }




}