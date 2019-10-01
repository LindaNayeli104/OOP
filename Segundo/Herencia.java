// Es un tipo de realcion (es un )permite construir clases a partir de clases que existen
// Tipos de datos de la clase padre
//Herencia simple que solo se hereda de una clase
// [modificadores]class ClaseNueva extends ClaseExistente

//              La clase Shape
// public class Rentangle extends Shape
// public class Square extends Rectangle

// Los miembros privados de ls superclase no pueden ser accedidos de manera directa por la subclase
// La subclase puede adicionar nuevos atributos y metodos
// La subclase puede redefinir los metodos publicos de ls superclase
// Tdoso lso miemvroes y emtodos del a superclase tambien los son para la subclase

// Construtores this. == super(parametros) la llama la clase hija
// Sobrecargar vs sobreescribir
// para sobrescribir es super.metodo() de la clase padre
// cuando ponemos this.metodo() le hablamos al metodo sobreescrito
// protected es publico para las clases hijas pero no funciona con las demás 

//Directamente o indirectamente todas las clases provienen de object
// los métodos públicos del a clase object pueden se rsobreescritos o invocados desde cualquier clase
//EQUALS DICE que si son iguales pero no el mismo

//public String toString()
//public boolean equals(Object obj)
//protected Object clone()
//protected void finalize()
