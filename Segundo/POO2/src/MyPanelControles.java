import java.awt.Button;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.image.ImagingOpException;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JFileChooser;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JSlider;
import javax.swing.JTextField;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class MyPanelControles extends  JPanel implements ActionListener, ChangeListener, MouseListener {
	private JTextField tfNombre;
	private JButton btnNombre,
					btnColor,
					btnGuardar,
					btnAbrir;
	
	private JRadioButton rbRojo,
						rbVerde,
						rbAzul;
	
	
	private JPanel panelColor; //cuadro
	
	private JSlider slider;
	private JFileChooser fc;
	
	private MyPanelDibujo pd; //unir archivos 
	
	
	public MyPanelControles(MyPanelDibujo pd){
		super();
		this.pd = pd;
		this.setPreferredSize(new Dimension(150,600));
		this.tfNombre = new JTextField(10);
		this.btnNombre=new JButton("Saluda");
		this.btnNombre.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				pd.setNombre(tfNombre.getText());
				
			}
			
		}); //ponerle al action
		this.fc = new JFileChooser();
		
		this.rbRojo = new JRadioButton("Color Rojo", true ); //SELECCIONADO
		this.rbVerde = new JRadioButton("Color Verde");
		this.rbAzul = new JRadioButton("Color Azul");
		
		ButtonGroup bg = new ButtonGroup();
		bg.add(this.rbRojo);
		bg.add(this.rbVerde);
		bg.add(this.rbAzul);
		
		this.btnColor = new JButton("Cambiar color");
		this.btnColor.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				Color tmpColor;
					if (rbRojo.isSelected()){
						tmpColor = Color.RED;
					}
					else if (rbVerde.isSelected()){
						tmpColor = Color.GREEN;
					}else{
						tmpColor = Color.BLUE;
					}
					
					setBackground(tmpColor);
					rbRojo.setBackground(tmpColor);
					rbVerde.setBackground(tmpColor);
					rbAzul.setBackground(tmpColor);
				}
				
			
			
		});
		
		this.panelColor = new JPanel();
		this.panelColor.setPreferredSize(new Dimension(70, 70));
		this.panelColor.addMouseListener(this);
		this.panelColor.setBackground(Color.RED);
		
		
		//Slider
		this.slider = new JSlider(JSlider.VERTICAL, 0, 200, 0);
        this.slider.setMinorTickSpacing(10);
        this.slider.setMajorTickSpacing(100);
        this.slider.setPaintTicks(true);
        this.slider.setPaintLabels(true);
        this.slider.addChangeListener(this);
        this.add(this.slider);
       
        this.btnAbrir = new JButton("Abrir");
        this.btnAbrir.addActionListener(new ActionListener(){
        	
        	public void actionPerformed(ActionEvent e) {
				fc.showOpenDialog(pd);
				int respArchivo = fc.showOpenDialog(MyPanelControles.this.pd);
				if(respArchivo == JFileChooser.APPROVE_OPTION){
					File archivo = fc.getSelectedFile();
					try{
						BufferedReader br = new BufferedReader(new FileReader(archivo.getAbsolutePath()));
						tfNombre.setText(br.readLine());
						setBackground(new Color(Integer.parseInt(br.readLine())));
						pd.setXV(Integer.parseInt(br.readLine()));
						pd.setYV(Integer.parseInt(br.readLine()));
						br.close();
					}catch(IOException ex){
						System.out.println("Error" + ex);
					}
				 }
        		}
				
			});
        
        this.btnGuardar = new JButton("Guardar");
        this.btnGuardar.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				int respArchivo = this.fc.showSaveDialog(MyPanelControles.this.pd);
				if (respArchivo == JFileChooser.APPROVE_OPTION){
					File archivo = fc.getSelectedFile();
					try{
						PrintWriter pw = new PrintWriter(archivo.getAbsolutePath());
						pw.println(tfNombre.getText());
						pw.println(getBackground().getRGB());
						pw.println(pd.getXV());
						pw.println(pd.getYV());
						pw.close();
						
					}catch(IOException ex){
						System.out.println("Error: " + ex);
					}
				}
				
			}
        	
        
        
        });
        
        
		//AGREGAR AL PANEL
		
		this.add(this.tfNombre);
		this.add(this.btnNombre);
		
		
		this.add(this.rbRojo);
		this.add(this.rbVerde);
		this.add(this.rbAzul);
		this.add(this.btnColor);
		
		
		this.add(this.panelColor);
		
		this.add(this.slider);
		
		this.add(this.btnAbrir);
		this.add(this.btnGuardar);
		
		
		
	}

	@Override
	public void actionPerformed(ActionEvent evt) {	

	}

	@Override
	public void stateChanged(ChangeEvent e) {
		this.pd.setYV(this.slider.getValue());
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		Color colorSel = JColorChooser.showDialog(this.pd, "Selecciona el color del globo", this.panelColor.getBackground());
		this.panelColor.setBackground(colorSel);
		this.pd.setColorGlobo(colorSel);
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
