// Hecho por: Agustin Salvador Quintanar de la Mora
  //A01636142
  //ClaseEspiral.java
  //20/Marzo/2019
import java.awt.Graphics;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class ClaseEspiral extends JPanel { 
	public void paint(Graphics g) {
		int cX, //Coordenada "x" del centro
			cY, //Coordena "y" del centro
			radio; //Radio del octagono inscrito respectivo
		cX = cY = 350;
		radio = 5;
		int[] xs = new int[50];
		int[] ys = new int[50];
		for(int i=0; i<xs.length; i++) {
			xs[i] = cX + (int) ((i+1)*radio*Math.sin(Math.toRadians(i*45)));
			ys[i] = cY + (int) ((i+1)*radio*Math.cos(Math.toRadians(i*45)));
			}
			
			g.drawPolyline(xs, ys, 50);
			
		}
		
	public static void main(String[] args) { 
		JFrame frame = new JFrame(); 
	frame.getContentPane().add(new ClaseEspiral());
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); frame.setSize(1200,800);
	frame.setVisible(true); 
	}
}