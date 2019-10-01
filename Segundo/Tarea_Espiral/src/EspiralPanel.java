import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.JTextField;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
public class EspiralPanel extends JFrame {
	//Oscar Fernández Moreno
	//A07013362
	//EspiralPanel.java
	//20/03/2019
	//Constructor del FRAME
	public EspiralPanel(){
		super("Espiral 0.0.1");
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		PanelExtra pe = new PanelExtra();
		this.add(pe);
		this.add(new ConfiguracionPanel(pe), BorderLayout.WEST);
		this.pack();
		this.setVisible(true);
	}
	public static void main(String[] args) { 
		 EspiralPanel ep = new EspiralPanel();
	 }
	
	
	
	
//Clase de la Espiral
class PanelExtra extends JPanel {
	private int lados;
	private int radio;
	private int vertices;
	private int centro;

	public PanelExtra(){
		super();
		this.lados = 18;
		this.radio = 200;
		this.vertices = 8;
		this.centro = 400;
		this.setPreferredSize(new Dimension(800, 800));
	}
	
	
//Llama metodos
	public void paint(Graphics g) { // Espiral
		super.paintComponent(g); 
		this.Poligono(g);
	 }
	
//Setters
	public void setLado(int vertices){
		this.vertices = vertices;
		repaint();
	}
	
	public void setRadio(int radio){
		this.radio = radio;
		repaint();
	}
	
	public void setLineas(int lados){
		this.lados = lados;
		repaint();
	}
	
//Poligono
	public void Poligono(Graphics g){
		int[] xs = new int [lados];
		int[] ys = new int [lados];
	 	for (int i = 0; i < lados; i++){
	 		xs[i] = (int) ((int) (Math.cos((i * 2 * Math.PI)/vertices) * (radio - (i*10)) + centro));
	 		ys[i] = (int) ((int) (Math.sin((i * 2 * Math.PI)/vertices) * (radio - (i*10)) + centro));
	 	}
	 	g.setColor(Color.BLACK);
	 	g.drawPolyline(xs, ys, lados);
	}
	

}


//Clase Configuracion
class ConfiguracionPanel extends JPanel implements ChangeListener{
	private PanelExtra pd = new PanelExtra();
	
	private JLabel ladosLabel,
					radioLabel,
					lineasLabel;
	
	
	private JSlider ladosSlider,
					radioSlider,
					lineasSlider;
	
	
	private JButton btconfigurar;
	public ConfiguracionPanel(PanelExtra pd){
		super();
		this.pd = pd;
		this.setPreferredSize(new Dimension(200,800));
		this.setBackground(Color.GRAY);
		
		
		//New
		this.ladosLabel = new JLabel("Configurar Lados   ");
		this.radioLabel= new JLabel("Configurar Radio    ");
		this.lineasLabel = new JLabel("Configurar Lineas ");

		
		//SliderLados
		this.ladosSlider = new JSlider(JSlider.VERTICAL, 3, 15, 8);
        this.ladosSlider.setMinorTickSpacing(0);
        this.ladosSlider.setMajorTickSpacing(1);
        this.ladosSlider.setPaintTicks(true);
        this.ladosSlider.setPaintLabels(true);
        this.ladosSlider.addChangeListener(this);
        
        
        //SliderRadio
        this.radioSlider = new JSlider(JSlider.VERTICAL, 0, 200, 0);
        this.radioSlider.setMinorTickSpacing(10);
        this.radioSlider.setMajorTickSpacing(40);
        this.radioSlider.setPaintTicks(true);
        this.radioSlider.setPaintLabels(true);
        this.radioSlider.addChangeListener(this);
        
        //SliderLineas
        this.lineasSlider = new JSlider(JSlider.VERTICAL, 10, 50, 10);
        this.lineasSlider.setMinorTickSpacing(5);
        this.lineasSlider.setMajorTickSpacing(10);
        this.lineasSlider.setPaintTicks(true);
        this.lineasSlider.setPaintLabels(true);
        this.lineasSlider.addChangeListener(this);
        
		
		//Add		
        
		this.add(ladosLabel);
		this.add(this.ladosSlider);
		
		this.add(radioLabel);
		this.add(this.radioSlider);

		
		this.add(lineasLabel);
		this.add(this.lineasSlider);
				
	}
	
	public void stateChanged(ChangeEvent e) {
		this.pd.setLado(this.ladosSlider.getValue());
		this.pd.setRadio(this.radioSlider.getValue());
		this.pd.setLineas(this.lineasSlider.getValue());
	}
	
}
 
}

