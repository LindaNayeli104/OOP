public class Cuadrado extends Rectangulo{ // todos los cuadrado son rectangulos 
    public Cuadrado( double lado){ //protected 
        super(lado,lado); // super llama al constructor de rectangulo 
    }

    public Cuadrado(){ // Reutalizar código
        this(2.0);
    }

    public String toString(){
        return "El cuadrado de lado" + this.largo;
    }







}