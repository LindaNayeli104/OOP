public class Libro{
    //Oscar Fernandez Moreno
    //A07013362
    //Libro.java
    //25/01/2019
    String titulo;
    String autor;
    String editorial;
    String isbn;

    public Libro(){
        titulo = "Empty";
        autor = "Empty";
        editorial = "Empty";
        isbn = "Empty";
    }

    public void datos(String a, String b, String c, String d){
        titulo = a;
        autor = b;
        editorial = c;
        isbn = d;
    }

    //!Setters
    public void setTitulo(String a){
        titulo = a;
    }

    public void setAutor(String b){
        autor = b;
    }

    public void setEditorial(String c){
        editorial = c;
    }

    public void setIsbn(String d){
        isbn = d;
    }

    //!Getters
    public String getTitulo(){
        return titulo;
    }

    public String getAutor(){
        return autor;
    }

    public String getEditorial(){
        return editorial;
    }

    public String getIsbn(){
        return isbn;
    }

    public static void main(String args[]){
    Libro miLibro = new Libro();
    miLibro.setTitulo("Don Quijote de la Mancha");
    miLibro.setAutor("Miguel de Cervantes Saavedra");
    miLibro.setEditorial("Francisco Robles");
    miLibro.setIsbn("9788493806125");
    
    System.out.println("Titulo: " + miLibro.getTitulo());
    System.out.println("Autor: " + miLibro.getAutor());
    System.out.println("Editorial: " + miLibro.getEditorial());
    System.out.println("Isbn: " + miLibro.getIsbn());

    }
}