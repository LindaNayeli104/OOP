import java.awt.BorderLayout;

import javax.swing.JFrame;

public class GuiNumerote extends JFrame{

	public GuiNumerote() {
		super("Numerotes Proyecto medio termino");
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.add(new PanelNumerote());
		this.pack();
		this.setLocationRelativeTo(null);
		this.setVisible(true);
		//Hace que la ventana sea visible
	}
	
	public static void main(String[] args) {
		GuiNumerote ventana = new GuiNumerote();
		
	}

}