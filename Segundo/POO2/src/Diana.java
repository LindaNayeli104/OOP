import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
public class Diana {
	//Oscar Fernández Moreno
	//A07013362
	//Diana
	//05/04/2019
	protected int xPos,
	  				yPos,
	  					ancho;
	protected int circulos; 							//Cambia el número de circulos
	protected Color colorCentro;			
	
	public Diana(int xPos, int yPos){
		this.ancho = 200;									//Ancho por default
		this.xPos = xPos;									//X por default
		this.yPos = yPos;									//Y por default
		this.colorCentro = Color.RED;						//Color default
		this.circulos = 6;
	}
	
//Setters 
	
		//Set Ancho
		public void setAncho(int ancho){
			this.ancho = ancho;
		}
			
		//Set Color
		public void setColor(Color colorCentro){
			this.colorCentro = colorCentro;
		}
		
		//Set Posicion
		public void setPosicion(int xPos, int yPos){
			this.xPos = xPos;
			this.yPos = yPos;
		}
		
		//Set Circulos
		public void setCirculos(int x){
			this.circulos = x;
		}
		
//Getters
		//Get Ancho
		public int getAncho(){
			return this.ancho;
		}
			
			
		//Get Color
		public Color getColor(){
			return this.colorCentro;
		}
		
//HACE DIANA
		public void pintaFigura(Graphics g){
			boolean white = false; 								//Bandera que nos sirve para cambiar entre negro y blanco
            int radio = ancho/2;								//No tenemos un radio entonces lo generamos
            
            for (int i = this.circulos; i > 0; i--){
            	
            	int xPos = ((ancho / 2) - radio) + this.xPos;			 
            	int yPos = ((ancho / 2) - radio) + this.yPos;
        		
                System.out.println(i);
                System.out.println("Ancho: " + ancho/2 + "	Radio: " + radio);
                System.out.println("X: " + xPos + "	Y: " + yPos);
                
                if (white)									//Bandera de color
                        g.setColor (Color.WHITE);
                else
                        g.setColor (Color.BLACK);
                
                if (i == 1){ 								//Ulitma iteracion cambia el color a rojo
                	g.setColor(colorCentro);
                }
                
                g.fillOval (xPos, yPos, 2*radio, 2*radio);	//Dibujamos el círculo 
                g.drawOval(xPos, yPos, 2*radio, 2*radio);
                
                radio -= (radio/i); 						//al radio se le resta el mayor entre cuantos circulos son
                
                white = !white;     						//como ya fue blanco cambiaría a negro
                
            }	

		}
}

	
	
	

