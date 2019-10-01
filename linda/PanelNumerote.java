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
import javax.swing.*;


public class PanelNumerote extends JPanel implements ActionListener{
	private JTextField num1,	
						num2;
	private JButton btnSum,
					btnRes,
					btnMul,
					btnAbrir;
	private JLabel resultado;

	public PanelNumerote() {
		super();
		this.setPreferredSize(new Dimension(600,300));
		this.setBackground(Color.BLACK);
		this.resultado=new JLabel();
		this.resultado.setForeground(Color.WHITE);
		
		this.num1=new JTextField(25);
		
		this.num2=new JTextField(25);
		
		this.btnSum=new JButton("Suma");
		this.btnSum.addActionListener(this);
		
		this.btnRes=new JButton("Resta");
		this.btnRes.addActionListener(this);
		
		this.btnMul=new JButton("Multiplicación");
		this.btnMul.addActionListener(this);
		
		this.btnAbrir=new JButton("Abrir");
		this.btnAbrir.addActionListener(this);
		
		this.add(this.num1);
		
		this.add(this.num2);
		
		this.add(this.btnSum);
		
		this.add(this.btnRes);
		
		this.add(this.btnMul);
		
		this.add(this.btnAbrir);
		
		this.add(this.resultado);
	}

	@Override
	public void actionPerformed(ActionEvent evt) {
		
			Numerote num1=new Numerote(this.num1.getText());
			Numerote num2=new Numerote(this.num2.getText());

			if(evt.getSource()==btnSum) {
				try {
				Numerote num3 = num1.suma(num2);
				this.resultado.setText("El resultado de "+num1.toString() + " + " + num2.toString()+" es: " + num3.toString());
					}catch (NumberFormatException ex) {
						JOptionPane.showMessageDialog(this,"Los datos introducidos son incorrectos");	
					}catch(StringIndexOutOfBoundsException ex) {
						JOptionPane.showMessageDialog(this,"No se han introducido uno o mas numeros");
					}
			}

			else if(evt.getSource()==btnRes) {
				Numerote num3=num1.resta(num2);
				this.resultado.setText("El resultado de "+num1.toString()+" - "+num2.toString()+" es: "+num3.toString());
			}else if(evt.getSource()==btnMul){
				Numerote num3=num1.resta(num2);
				this.resultado.setText("El resultado de "+num1.toString()+" x "+num2.toString()+" es: "+num3.toString());
			}

		


		if(evt.getSource()==btnAbrir){
			JFileChooser fc=new JFileChooser();
			int respArchivo=fc.showOpenDialog(this);
			if (respArchivo==JFileChooser.APPROVE_OPTION) {
				File archivo=fc.getSelectedFile();
				String entrada=archivo.getAbsolutePath();
				String salida="salida.txt";
				Numerote.ejecutaArchivo(entrada, salida);
				}
		}
		
		
		
		
	}

}