import java.awt.Color;
import java.awt.Graphics;
import java.awt.Polygon;

import javax.swing.JPanel;
import javax.swing.JFrame;

public class Spiral2 extends JPanel {

    public void paintComponent(Graphics g) {
        int x = getSize().width / 2 - 10;
        int y = getSize().height/ 2 - 10;
        int width = 20;
        int height = 20;
        int startAngle = 0;
        int arcAngle = 180;
        int depth = 10;
        for (int i = 0; i < 10; i++) {
            if (i % 2 == 0) {
                //   g.drawArc(x + 10, y + 10, width, height, startAngle + 10, -arcAngle);
                //  x = x - 5;
                y = y - depth;
                width = width + 2 * depth;
                height = height + 2 * depth;
                g.drawArc(x, y, width, height, startAngle, -arcAngle);
            } else {
                //  g.drawArc(x + 10, y + 10, width, height, startAngle + 10, arcAngle);
                x = x - 2 * depth;
                y = y - depth;
                width = width + 2 * depth;
                height = height + 2 * depth;
                g.drawArc(x, y, width, height, startAngle, arcAngle);
            }
        }
    }

    public static void main(String[] args) {
        Spiral2 panel = new Spiral2();
        JFrame application = new JFrame();
        application.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        application.add(panel);
        application.setSize(300, 300);
        application.setVisible(true);
    }
}
class PolygonsPanel extends JPanel {
	protected void paintComponent(Graphics g) {
	       	super.paintComponent(g);
	       	int vertice = 5;
	       	int radius = (int)(Math.min(getWidth(), getHeight()) * 0.4);
			
	   
	        int xCenter = getWidth() / 2;
	        int yCenter = getHeight() / 2;
	       
	        Polygon polygon = new Polygon();

	        g.setColor(Color.RED);
	        polygon.addPoint(xCenter + radius, yCenter);

	        //Aqui vamos agregar 2 puntos mas por lo tanto agregamos otros 2 metodos matematicos
	        for(int i=0; i < vertice; i++){

	        	polygon.addPoint((int)(xCenter + radius * Math.cos(i * 2 * Math.PI / vertice)), 
	            		(int)(yCenter - radius * Math.sin(i * 2 * Math.PI / vertice)));
	            
	        }
	        
	        g.drawPolygon(polygon);
	    }
	}