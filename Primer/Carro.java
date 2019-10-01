class Carro{
    //Atributos
    double tamano;
    String marca;
    int puertas;

    //Métodos
    void camina(){

    }
    public static void main(String args[]){
        Carro miCarro = new Carro(); //!Se guarda la direccion en memoria
        miCarro.tamano = 3.00; 
        miCarro.marca = "VW";
        miCarro.puertas = 4;

        miCarro.camina();
    }
}