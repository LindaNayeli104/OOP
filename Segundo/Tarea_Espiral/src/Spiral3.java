import java.awt.Container;
import java.awt.Graphics;
import java.awt.Polygon;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Spiral3 extends JPanel {
  public void paintComponent(Graphics g) {
    super.paintComponent(g);
    int vertices = 5;
    int radio = 10;
    int centro = 200;

    Polygon p = new Polygon();
    for (int i = 0; i < vertices; i++){
    	p.addPoint((int) (centro + radio * Math.cos(i * 2 * Math.PI / vertices)),
    	          (int) (centro + radio * Math.sin(i * 2 * Math.PI / vertices)));
    	radio = radio + (10*i);
    	
    }
      

    g.drawPolygon(p);

  }
  public static void main(String[] args) {
    JFrame frame = new JFrame();
    frame.setTitle("DrawPoly");
    frame.setSize(800, 500);
    frame.addWindowListener(new WindowAdapter() {
      public void windowClosing(WindowEvent e) {
        System.exit(0);
      }
    });
    Container contentPane = frame.getContentPane();
    contentPane.add(new Spiral3());

    frame.show();
  }
}
           
         