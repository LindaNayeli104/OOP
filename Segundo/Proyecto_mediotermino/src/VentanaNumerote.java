import javax.swing.JFrame;

public class VentanaNumerote extends JFrame {
		//OSCAR FERNÁNDEZ MORENO 			A07013362
		//DIEGO ARMANDO VÁZQUEZ CALDERÓN 	A00226803
		//PROYECTO: NUMEROTE
		//CLASE: VentanaNumerote.java
		//10/04/2019
	public VentanaNumerote() {
		super("NUMEROTES v.0.0.1");
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setSize(1000, 400);
		PanelNumerote p=new PanelNumerote();
		this.add(p);
		this.setVisible(true);
	}
	public static void main(String [] args) {
		VentanaNumerote vn=new VentanaNumerote();
	}
}