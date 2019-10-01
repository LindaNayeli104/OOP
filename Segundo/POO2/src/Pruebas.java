import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.JTextField;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;


//FRAME CLASS________________________________________________________________________________________________________________________________________________
public class Pruebas extends JFrame {
	
	public Pruebas() {
		super("Diana 0.0.1"); 									//Titulo
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);			//Cerrar y para el programa
		DianaPrueba d = new DianaPrueba();						//Creamos una nuevo Panel
		this.add(new DianaControles(d), BorderLayout.WEST);
		this.add(d);											//Lo agregamos al Panel
		this.pack();											//Actualiza el tamaño
		this.setVisible(true);									//Visualiza el programa
	}
	
	public static void main(String args[]){
		Pruebas p = new Pruebas();								//Creamos el Frame
	}
}

//PANEL CLASS________________________________________________________________________________________________________________________________________
class DianaPrueba extends JPanel{
	private Diana d;
	private int x,
				y;
	private DianaNumerada dn;
	
	//Constructor con parámetros
	public DianaPrueba(){ 
		super();											//Funcion del padre
		this.setPreferredSize(new Dimension(1000, 1000));   //Dimension del Frame
		this.x = 400;
		this.y = 250;
		this.d = new Diana(this.x,this.y);					//Llamo a la clase de Diana
		this.dn = new DianaNumerada(this.x, this.y);
	}
	
	//Pinta componentes 
	public void paintComponent(Graphics g){ 				//El paintComponents para dibujar las funciones
		super.paintComponent(g);							//Llamar el paintComponent del padre(super)											
		this.d.setPosicion(this.x, this.y);					//Setter posicion
		this.dn.setPosicion(this.x, this.y);
		this.diana(g);
	}
	
	//Funciones
	public void diana(Graphics g){
		this.d.pintaFigura(g);
		this.dn.pintaFigura(g);
	}
	
	
	
	//Setters
	public void setX(int x){
		this.x = x;
		repaint();
	}
	
	public void setY(int y){
		this.y = y;
		repaint();
	}
	
	public void setAncho(int ancho){
		this.d.setAncho(ancho);
		this.dn.setAncho(ancho);
		repaint();
	}
	
	public void setCirculos(int x){
		this.d.setCirculos(x);
		this.dn.setCirculos(x);
		repaint();
	}
	
	public void setColor(Color x){
		this.d.setColor(x);
		this.dn.setColor(x);
		repaint();
	}
	
}

//PANEL CONTROLES CLASS______________________________________________________________________________________________________________________________
class DianaControles extends JPanel implements ActionListener, ChangeListener, MouseListener{
	private DianaPrueba dp = new DianaPrueba();
	
	private JTextField tfx,
						tfy,
						tfancho;
	
	private JButton btncambiar;
	
	private JSlider scirculos;
	
	private JLabel lx,
				   ly,
				   lcirculo,
				   lancho;
	
	private JPanel panelColor;
	
	public DianaControles(DianaPrueba dp){
		super ();
		this.dp = dp;
		this.setPreferredSize(new Dimension(200,1000));
		this.setBackground(Color.GRAY);
		
//NEW 
		//Text Field
		this.tfx = new JTextField(15);
		this.tfy = new JTextField(15);
		this.tfancho = new JTextField(15);
		
		//Button
		this.btncambiar = new JButton("Realizar Cambios");
		this.btncambiar.addActionListener(this);
		
		//Slider
		this.scirculos = new JSlider(JSlider.VERTICAL, 6, 210, 50);
		this.scirculos.setMinorTickSpacing(10);
        this.scirculos.setMajorTickSpacing(20);
        this.scirculos.setPaintTicks(true);
        this.scirculos.setPaintLabels(true);
		this.scirculos.addChangeListener(this);
		
		//Label
		this.lx = new JLabel("X");
		lx.setForeground(Color.white);
		this.ly = new JLabel("Y");
		ly.setForeground(Color.white);
		this.lcirculo = new JLabel("Número de Circulos");
		lcirculo.setForeground(Color.white);
		this.lancho = new JLabel("Ancho del Circulo");
		lancho.setForeground(Color.white);
		
		//Panel
		this.panelColor = new JPanel();
		this.panelColor.setPreferredSize(new Dimension(70, 70));
		this.panelColor.addMouseListener(this);
		this.panelColor.setBackground(Color.RED);
		
		
		
//ADD
		this.add(lcirculo);
		this.add(scirculos);
		
		this.add(lancho);
		this.add(tfancho);
		
		this.add(lx);
		this.add(tfx);
		
		this.add(ly);
		this.add(tfy);
		
		this.add(btncambiar);
		
		this.add(panelColor);
	}
	
	
	
//ACTION LISTENER / CHANGE LISTENER
	@Override
	public void actionPerformed(ActionEvent e) {
		this.dp.setX(Integer.parseInt(this.tfx.getText()));
		this.dp.setY(Integer.parseInt(this.tfy.getText()));
		this.dp.setAncho(Integer.parseInt(this.tfancho.getText()));
		repaint();
	}
	
	@Override
	public void stateChanged(ChangeEvent e) {
		this.dp.setCirculos(this.scirculos.getValue());
	}


//MOUSE LISTENER
	@Override
	public void mouseClicked(MouseEvent e) {
		Color ventana = JColorChooser.showDialog(this.dp, "Selecciona el color del Centro", this.panelColor.getBackground());
		this.panelColor.setBackground(ventana);
		this.dp.setColor(ventana);
	}



	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}



	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}



	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}



	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	
	
	
}
