public class Termometro implements Comparable{
    private int temp;
    public Termometro(){ //! Constructor default no usan void
        temp = 25;
    }
    
    public Termometro(int t){
        temp = t;
    }
    
    public void setTemp(int t){
        temp = t;
    }

    public int getTemp(){
        return temp;
    }

    
    public int compareTo (Object t){ //Dice que recibe el objeto
        Termometro term = (Termometro)t; //CAST lo convierto al temp
        return this.temp - term.temp;
        //es igual a:
        /*
        if (this.temp == term.temp){
            return 0;
        }else if (this.temp > term.temp){
            return 1;
        }else{
            return -1;
        }*/
    }


}