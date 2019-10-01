import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.NoSuchElementException;
import java.util.StringTokenizer;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class PanelNumerote extends JPanel implements ActionListener {
	
	//OSCAR FERNÁNDEZ MORENO 			A07013362
	//DIEGO ARMANDO VÁZQUEZ CALDERÓN 	A00226803
	//PROYECTO: NUMEROTE
	//CLASE: PanelNumerote.java
	//10/04/2019
	private JTextField tfOperando1,
					   tfOperando2,
					   tfResultado;
	private JRadioButton rbSuma,
						 rbResta,
						 rbMultiplicacion;
	private JButton btnCalcular,
					btnAbrir;
	
	private JFileChooser fc;
	
	private Image fondo;
	
	public PanelNumerote() {
		super();
		
		//NEW
		this.setPreferredSize(new Dimension (1000, 800));
		this.fc = new JFileChooser();
		this.fondo = new ImageIcon("fondo.jpg").getImage();
		
		
		//TEXT
		this.tfOperando1 = new JTextField(10);
		this.tfOperando2 = new JTextField(10);
		this.tfResultado = new JTextField(10);
		
		//RADIO BUTTON
		this.rbSuma = new JRadioButton("+" , true);
		this.rbResta = new JRadioButton("-");
		this.rbMultiplicacion = new JRadioButton("*");
		
		//BUTTON
		this.btnAbrir = new JButton("Abrir");
		this.btnAbrir.addActionListener(this);
		this.btnCalcular=new JButton("Calcular");
		this.btnCalcular.addActionListener(this);
		ButtonGroup bg=new ButtonGroup();
		bg.add(rbSuma);
		bg.add(rbResta);
		bg.add(rbMultiplicacion);
		
		
		//ADD
		this.add(this.tfOperando1);
		this.add(this.tfOperando2);
		this.add(this.tfResultado);
		this.add(this.rbSuma);
		this.add(this.rbResta);
		this.add(this.rbMultiplicacion);
		this.add(this.btnAbrir);
		this.add(this.btnCalcular);
	}
	
	
	//PAINT COMPONENTS
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(this.fondo, 0, 0, this.getWidth(), this.getHeight(), this);
		
		//Título
		g.setFont(new Font("Impact",Font.PLAIN,20));
		g.drawString("Operaciones de Numerotes",(this.getWidth() / 2) - 130, (this.getHeight()/5) - 30);
		
		
		//Letras
		g.setFont(new Font("Imprint MT Shadow",Font.PLAIN,15));
		g.drawString("Numerote 1", (this.getWidth()/2) - 100, (this.getHeight()/5));
		this.tfOperando1.setLocation((this.getWidth()/2) - 100, (this.getHeight()/5)+10);
		
		g.drawString("Numerote 2",(this.getWidth()/2) - 100, (this.getHeight()/5)+50);
		this.tfOperando2.setLocation((this.getWidth()/2) - 100, (this.getHeight()/5)+60);
		
		g.drawString("Resultado",(this.getWidth()/2)- 100, (this.getHeight()/5)+100);
		this.tfResultado.setLocation((this.getWidth()/2)- 100, (this.getHeight()/5)+110);
		
		g.drawString("Elige el operador",(this.getWidth()/2)- 100,(this.getHeight()/5)+150);
		
		this.rbSuma.setLocation((this.getWidth()/2) - 100, (this.getHeight()/5)+160);
		this.rbResta.setLocation((this.getWidth()/2) - 60,(this.getHeight()/5)+160);
		this.rbMultiplicacion.setLocation((this.getWidth()/2)- 20,(this.getHeight()/5)+160);
		
		this.btnCalcular.setLocation((this.getWidth()/2) - 120, (this.getHeight()/5)+220);
		this.btnAbrir.setLocation((this.getWidth()/2) - 20, (this.getHeight()/5)+220);
	}
	
	
	
	//ACTION LISTENER
	public void actionPerformed(ActionEvent e) {
		if (e.getSource()==this.btnCalcular) {
			try {
				Numerote operando1 = new Numerote(this.tfOperando1.getText());
				Numerote operando2 = new Numerote(this.tfOperando2.getText());

				if (this.rbSuma.isSelected()) {
					Numerote resultado = operando1.suma(operando2);
					this.tfResultado.setText(resultado.toString());

				}else if(this.rbResta.isSelected()) {
					Numerote resultado = operando1.resta(operando2);
					this.tfResultado.setText(resultado.toString());

				}else if (this.rbMultiplicacion.isSelected()){
					Numerote resultado = operando1.multiplica(operando2);
					this.tfResultado.setText(resultado.toString());
				}
			}catch (NumberFormatException ex) {
				JOptionPane.showMessageDialog(this,"Los datos introducidos son incorrectos");
				
			}catch(StringIndexOutOfBoundsException ex) {
				JOptionPane.showMessageDialog(this,"No se han introducido uno o mas numeros");
			}
			
		}else{

			//Variable auxiliares
			StringTokenizer st ;
			String linea,
			operacion,
			numero1,
			numero2;

			fc.showOpenDialog(this);
			int respArchivo = this.fc.showOpenDialog(this);

			if(respArchivo == JFileChooser.APPROVE_OPTION){
				File archivo = fc.getSelectedFile();
				try{
					BufferedReader br = new BufferedReader(new FileReader(archivo.getAbsolutePath()));

					while ((linea = br.readLine()) != null){
						
						st = new StringTokenizer(linea, ",");
						numero1 = st.nextToken();
						numero2 = st.nextToken();
						linea = numero1 +","+ numero2;
						operacion = st.nextToken();
						Numerote.ejecutaArchivo(linea, operacion);    
					}
					
					br.close();
				}catch (FileNotFoundException ex){
					JOptionPane.showMessageDialog(this, "No se ha encontrado el archivo");
				}catch(IOException ex){
					JOptionPane.showMessageDialog(this, "Ha ocurrido un error que ha interrumpido el proceso");
				}catch(NoSuchElementException ex){
					JOptionPane.showMessageDialog(this,"El archivo no está en el formato correcto");
				}catch(NumberFormatException ex) {
					JOptionPane.showMessageDialog(this, "El archivo contiene datos incorrectos");
				}catch (Exception ex) {
					JOptionPane.showMessageDialog(null, "El archivo contiene operaciones invalidas");
				}
			}
		}
	}
}