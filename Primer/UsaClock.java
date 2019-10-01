public class UsaClock{
    public static void main(String [] args){
    Clock rolex = new Clock();
    rolex.setTime(23, 61 , 61);

    Clock gda = new Clock();
    gda.setTime(23, 61 , 61);


    System.out.println(rolex.getHours());
    System.out.println(rolex.getHours());
    gda.printTime();
    rolex.printTime();
    System.out.println(gda.equals(rolex)); //!equals compara dos relojes
   
    //! Lo más importante es tener una validación y para eso se ocupa el getter para tener valores 
    //! predeterminados
    }
}