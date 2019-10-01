import java.awt.Color;
import java.awt.Graphics;

public class DianaNumerada extends Diana {
	//Oscar Fernández Moreno
	//A07013362
	//DianaNumerada
	//05/04/2019
	public DianaNumerada(int xPos, int yPos) {
		super(xPos, yPos);
	}
	

	public void pintaFigura(Graphics g){
		boolean white = true; 								
        int radio = super.ancho/2;	
        int numeros = this.circulos - 1;
        //(int i = super.circulos - 1; i <= super.circulos + 4; i ++ )
		for (int i = this.circulos; i > 0; i--){					
            int xPos = ((ancho / 2) - radio) + super.xPos;			 
            int yPos = ((ancho / 2) - radio) + super.yPos;
            
           
            
            if (white)									
            	g.setColor (Color.WHITE);
            else
                g.setColor (Color.BLACK);
                        
           /*g.setColor (Color.RED);
           g.drawString("*", xPos , yPos);*/
            if (i!=1){
            	g.drawString(numeros+"", xPos + 2, yPos + radio + 4); //izquierda a derecha
           
            	g.drawString(numeros+"", xPos + radio - 5, yPos + 12); // arriba a abajo
           
            	g.drawString(numeros+"", xPos + (radio*2) - 13 , yPos + radio + 5); // derecha a izquierda
           
            	g.drawString(numeros+"", xPos + radio - 4, yPos + (radio*2)- 4); //abajo a arriba
            }else{
            	g.drawString(numeros+"", xPos + radio - 6 , yPos + radio + 5 ); //	CENTRO
            }
           
           numeros++;
           
           radio -= (radio/i);
                
           white = !white;     						
                
            }	

		}
	
	}
	

