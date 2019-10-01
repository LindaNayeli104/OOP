public class Hotel{
    private Habitacion [] habitacion;
    int numero = 100;

    public Hotel(String nombreHotel, int habitacionesTotales){
        this.habitacion = new Habitacion[habitacionesTotales];
    }


    public void checkIn(String nombre, int adultos, int niños, int credito, int pos){
        if (this.habitacion[pos] == null){
            this.habitacion[pos] = new Habitacion(pos + numero);
        }else{
            this.habitacion[pos].checkIn(nombre, adultos, niños, credito);
            
        }
    }

    public boolean checkOut(int numero){
        if (this.habitacion[numero - 100] == null || (this.habitacion[numero - 100] != null)) {
            return true;
        }else{
            return false;
        }
    }

    public int getTarifaTotalBase(){
        int total = 0;
        for (int i = 0; i < this.habitacion.length; i++){
            if(this.habitacion[i] != null){
                total += this.habitacion[i].getTarifa();
            }
        }
        return total; 
    }

    public void realizarCargo(int numero, int cargo){
        if (this.habitacion[numero - 100] != null && this.habitacion[numero - 100].realizarCargo(cargo)){
            System.out.println("Si se pudo");
        }
    }


    public String toString(){
        String res = "";
        for(int i = 0; i < habitacion.length; i++){
            if (this.habitacion[i] != null){
                res += this.habitacion[i] + "\n";
            }
        }
        return res;
    }

    public static void main(String args[]){
        Hotel one = new Hotel("OSCAR HOTEL", 10);
        System.out.println(one);


    }

}
