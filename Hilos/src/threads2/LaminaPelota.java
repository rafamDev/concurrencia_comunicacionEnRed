package threads2;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.ArrayList;

import javax.swing.JPanel;

public class LaminaPelota extends JPanel {

	
	ArrayList <Pelota> pelotas = new ArrayList <Pelota> (); 
	
	
	public void add(Pelota b) {
		
		
		pelotas.add(b);
	
	}
	
	
	
   
	public void paintComponent(Graphics g) {
		
	   
		super.paintComponent(g);
		
		
		Graphics2D g2 = (Graphics2D) g;
	
		
		for(Pelota p: pelotas) {
			
			g2.fill(p.getShape());
			
		}
		
		
	
	
	
	}
	
	
	
	
	
	
	
	
	
}