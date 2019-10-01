public class ZonasHorarias{
    private Clock[] horas; //!Arreglo de objetos de horas

    //Constructor default
    public ZonasHorarias(){ //! Constructor: no regresa nada y se llama igual que la clase
        this.horas = new Clock[20];
    }

    //ponerHora
    public void ponerHora(int hr, int min, int seg, String cd, int pos){ //!Guardar datos en la posición de la lista
        if (this.horas[pos] == null){
            this.horas[pos] = new Clock(hr, min, seg, cd); //! se le pasan todos los atributos de la clase en la posicion del arreglo(nuevo objeto)
        }else{ //si ya tengo una ciudad entonces solo uso los setter para cambiar los atributos
            this.horas[pos].setTime(hr,min,seg);
            this.horas[pos].setCiudad(cd);
        }
        
        
    }

    //cambiarHorarioInvierno
    public void cambiarHorarioInvierno(){ //! Le agrega una hora a todos los relojes
        for(int i = 0; i < this.horas.length; i++){ //!Cuidado: Se tienen que tener las posiciones llenas de objetos java.lang.NullPointerException
            if (this.horas[i] != null){
            this.horas[i].incrementHours();
            }
        }
    }

    //Imprimir le listas de zonas horarias
    public String toString(){ //! regresa la representacion del objeto, con todas las zonas horarias
        String res = "";
        for (int i = 0; i < this.horas.length;i++){ //imprime cada unos de los clocks en el array
            if (this.horas[i] != null){
                res += this.horas[i] + "\n";//Se manda a llamar el toString
            }
        }
        return res;
    }

    public static void main( String args[]){
        ZonasHorarias zh = new ZonasHorarias();
        // hr, min, sec, ciudad
        zh.ponerHora(10, 36, 40, "GDA", 0); 
        zh.horas[0].printTime(); //objeto.atributoHoras(arreglo)[relojes].metodo

        zh.ponerHora(8,36,40,"LAX", 1);
        zh.horas[1].printTime();

        zh.ponerHora(20,36,40,"DUB",2);
        zh.horas[2].printTime();

        zh.ponerHora(20,36,40,"TKB",3);


        //imprime directamente con toString
        Clock a = new Clock(10 , 36, 30, "GDA");
        System.out.println(a); 
        
        System.out.println(zh.horas[0]); //println + objeto = toString (Clock.java)
        System.out.println(zh.horas[1]);
        System.out.println(zh.horas[2]);

        zh.cambiarHorarioInvierno(); 

        System.out.println(zh.horas[0]); //println + objeto = toString (Clock.java) + incrementando una hora
        System.out.println(zh.horas[1]);
        System.out.println(zh.horas[2]);

        zh.ponerHora(11,41,30,"Gda", 0); //Crea un nuevo objeto MAL queremos cambiar

        //Cambiar los valores de un objeto en la lista en ponerHora

        //toString de zonashorarias
        System.out.println("toString" + "\n");
        System.out.println(zh); //imprime todo
        







    }

}