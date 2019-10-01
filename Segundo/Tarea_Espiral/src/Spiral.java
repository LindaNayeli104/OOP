import java.awt.Point;
import java.awt.event.ActionListener;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import javax.swing.Timer;
import javax.swing.JApplet;
import java.awt.*;
import java.awt.Dimension;

public class Spiral extends JPanel implements ActionListener {
	Timer tiempo = new Timer(15, this);
	private int distancia = 0;
	private int angulo = 0;
	private Point antes = new Point(getWidth(), getHeight());
	private Point despues = new Point(getWidth(), getHeight());
	
	public Spiral(){
		tiempo.start();
	}
	
	public void doDrawing(Graphics g){
		Graphics2D g2d = (Graphics2D) g;
		despues.x = (int) (getWidth()/2 + distancia * Math.cos(Math.toRadians(angulo)));
		despues.y = (int) (getWidth()/2 + distancia * Math.sin(Math.toRadians(angulo)));
		
		g2d.setColor(Color.BLACK);
		g2d.drawLine(antes.x, antes.y, despues.x, despues.y);
		
		angulo += 10;
		distancia ++;
		
		despues.x = antes.x;
		despues.y = antes.y;
		
		if (angulo > 359){
			angulo = angulo % 360;
		}
		
		if (distancia> getHeight() / 2){
			tiempo.stop();
		}
			
	}
	
	public Timer getTiempo(){
		return tiempo;
	}
	
	public void paintComponents(Graphics g){
		doDrawing(g);
	}
	
	public void actionPerformed(ActionEvent e){
		this.repaint();
	}
	
	public static void main(String args){
		
	}

	
}











/*public void actionPerformed(ActionEvent e) {
		this.pd.setLado(Integer.parseInt(this.tfLados.getText()));
		this.pd.setRadio(Integer.parseInt(this.tfRadio.getText()));
		this.pd.setLineas(Integer.parseInt(this.tfLineas.getText()));
		repaint();
	}*/
