import javax.management.RuntimeErrorException;

public class EjemploExceptions{

    public void metodoD() throws Exception{
        throw new Exception("Ocurrión en el metodo D");
    }

    public void metodoC() throws Exception{
        this.metodoD();
    }
    public void metodoB() throws Exception{
        this.metodoC();
    }

    public void metodoA() throws Exception{
        this.metodoB();
    }

    public static void main(String[] args){
        try {
            EjemploExceptions ee = new EjemploExceptions();
            ee.metodoA();
        }catch(Exception ex){
            System.out.println("Error" + ex);
        }
        

    }

}