public class Clock implements Comparable{
    //!datos privados para usar el set y el get
    private int hr,
                min,
                sec;

    private String cd;

    public Clock(){ //! Reloj por default
        this(12,0,0, "CLN"); //!Asi se manda a llamar a un constructor, tiene que se la primer línea
    }

    public Clock(int hr, int min, int sec, String cd){ //! Valores de un reloj nuevo
        this.setTime(hr, min, sec);
        this.cd = cd;
    }

    public void setTime(int a, int b, int c){//! Se usa el setter para pones valores nuevos y llamarlos
        if (a>=0 && a<24 ){
            this.hr = a;
        }else{
            this.hr = 12;
        }

        if (b>=0 && b<60 ){
            this.min = b;
        }else{
            this.min = 0;
        }

        if (c>=0 && c<60 ){
            this.sec = c;
        }else{
            this.sec = 0;
        }


    }

    public int getHours(){//!Obtiene cada uno de los valores
        return hr;
    }

    public int getMinutes(){
        return min;
    }

    public int getSeconds(){
        return sec;
    }

    public String getCiudad(){ //! Get de la ciudad 
        return this.cd;
    }

    public void setCiudad(String cd){ //! set de la ciudad
        this.cd = cd;
    }

    public void printTime(){
        System.out.println("La hora actual en "+ this.cd + " es: " + this.hr + ":" + this.min+ ":" + this.sec);
    }

    public String toString(){ //! sobre escribir 
        return "La hora actual en "+ this.cd + " es: " + this.hr + ":" + this.min+ ":" + this.sec;
    }

    public void incrementHours(){//!Aumenta horas
        this.hr = (++this.hr)%24;
    }

    public void incrementMinutes(){
        this.min = (++this.min)%24;
    }

    public void incrementSeconds(){
        this.sec = (++this.sec)%24;        
    }

    public boolean equals(Clock rolex ){ //! recibe un reloj objeto, y recibe otro reloj
        //!Muy interesante todo
        return this.hr == rolex.hr && this.min == rolex.min && this.sec == rolex.sec;

    }

    public void makeCopy(Clock rolex){//! Hace una copia de un reloj
        this.hr = rolex.hr;
        this.min = rolex.min;
        this.sec = rolex.sec;
    }

    public Clock getCopy(){//!Hace una copia de tipo de dato reloj
        return new Clock(this.hr,this.min, this.sec, this.cd);
    }

    public String compareTo (Object h){ //Dice que recibe el objeto
        Clock reloj = (Clock)h; //CAST lo convierto al temp
        int hora = this.h - reloj.h;
        int min = this.min - reloj.min;
        int sec = this.sec - reloj.sec;
        return "La diferencia de hora es: "+ ParseString.str(hora) + ":" + ParseString.str(min) + ":" + ParseString.str(sec);
    }

    

   

    





}