public class Complejo{
    //Oscar Fernandez Moreno
    //A07013362
    //Complejo.java
    //7 / Feb / 2019
    double real,
           imaginario;
    
    public Complejo(){
        real = 0;
        imaginario = 0;
    }
    
    public Complejo(double real, double imaginario){
        this.real = real;
        this.imaginario = imaginario;
    }

    public void establecer(double real, double imaginario){
        this.real = real;
        this.imaginario = imaginario;
    }

    public void imprimir(){
        if (this.imaginario >= 0){
            System.out.println(this.real + " +" + this.imaginario + "i");
        }else{
            System.out.println(this.real + " " + this.imaginario + "i");
        }
    }

    public void agregar(double real, double imaginario ){
        this.real += real;
        this.imaginario += imaginario;
    }

    public void agregar(Complejo numero){
        this.real += numero.real;
        this.imaginario += numero.imaginario;
    }

    public Complejo suma(Complejo numero){
        return new Complejo( this.real + numero.real, this.imaginario + numero.imaginario);
    }

    public Complejo resta(Complejo numero){
        return new Complejo( this.real - numero.real, this.imaginario - numero.imaginario);
    }

    public Complejo multiplicacion(Complejo numero){
        return new Complejo( this.real * numero.real, this.imaginario * numero.imaginario);
    }

    public Complejo multiplicacion(double numero){
        return new Complejo( this.real * numero, this.imaginario * numero);
    }

    public Complejo conjugado(){
        return new Complejo( this.real * -1, this.imaginario * -1);
    }


    public static void main(String args []){
        Complejo uno = new Complejo();
        uno.agregar(1,2);
        uno.imprimir();

        Complejo dos = new Complejo();
        dos.agregar(3,4);
        uno.agregar(dos);
        uno.imprimir();


        Complejo tres = uno.suma(dos);
        tres.imprimir();

        Complejo cuatro = uno.resta(dos);
        cuatro.imprimir();

        Complejo cinco = uno.multiplicacion(dos);
        cinco.imprimir();

        Complejo seis = uno.multiplicacion(2);  
        seis.imprimir();

        Complejo siete = uno.conjugado();
        siete.imprimir();
    }

    
}