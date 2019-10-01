import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.*;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

//PAINT FRAME
public class Paint extends JFrame {
	public Paint(){
		super(">>PINTAR<<");
		PaintPanel p = new PaintPanel();
		this.add(p);
		this.add(new ControlPanel(p), BorderLayout.WEST);
		this.pack();
		this.setVisible(true);
		
		
		
		
	}
	public static void main(String args[]){
		Paint p = new Paint();
	}
}

//PAINT PANEL___________________________________________________________________________________________________________________________________________________________________
class PaintPanel extends JPanel{
	public PaintPanel(){
		super();
		this.setPreferredSize(new Dimension(1000,800));
	}
	
	public void paintComponent(Graphics g){
	}
	
	
	
	
}



//CONTROLES PANEL________________________________________________________________________________________________________________________________________________________________

class ControlPanel extends JPanel implements ChangeListener, MouseListener , MouseMotionListener{
	private PaintPanel d;
	private JSlider slados;
	private JLabel llados;
	
	
	public ControlPanel(PaintPanel d){
		super();
		this.setPreferredSize(new Dimension(200,1000));
		this.d = d;
		this.setBackground(Color.GRAY);
//NEW
		//Slider
		this.slados = new JSlider(JSlider.VERTICAL, 3, 14, 3);
        this.slados.setMinorTickSpacing(1);
        this.slados.setMajorTickSpacing(1);
        this.slados.setPaintTicks(true);
        this.slados.setPaintLabels(true);
        this.slados.addChangeListener(this);
        
        //Label
        this.llados = new JLabel("Número de lados");
        
        
//ADD
        this.add(llados);
        this.add(slados);
		
	}

//CHANGE LISTENER
	@Override
	public void stateChanged(ChangeEvent e) {
		// TODO Auto-generated method stub
		
	}

//MOUSE LISTENER
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
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

	
//MOUSE MOTION LISTENER
	@Override
	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	
}
