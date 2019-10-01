public class Excepciones{
    //cuando se habla acerca de excepciones siempre que se habla de un archivo se tiene que hacer un try catch
    public static void main(String arg[]){
        int [] array = new int[20];
        try
        {
//			array[-3] = 24;
/*			int b = 0;
            int a = 23/b;
*/
            String s = null;
            s.equals("QQQQ");
        }
        catch(ArrayIndexOutOfBoundsException excepcion)
        {
            System.out.println(" Error de índice en un array");
        }
        catch(ArithmeticException excepcion)
        {
            System.out.println(" Error de índice en un array");
        }
        catch(Exception excepcion)
        {
            System.out.println("Se ha generado un error que no es de índices, ni Aritmético");
            System.out.println("El objeto error es de tipo " + excepcion);
        }
    }
}