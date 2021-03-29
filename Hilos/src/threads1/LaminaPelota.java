package threads1;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.ArrayList;

import javax.swing.JPanel;

public class LaminaPelota extends JPanel {

	//El ArrayList es porque no solo se va a pintar una pelota sino varias.
	//Recibira un argumento de tipo Pelota.
	ArrayList <Pelota> pelotas = new ArrayList <Pelota> (); 
	
	
	//Agregamos la pelota a la lamina.
	public void add(Pelota b) {
		
		//La objeto lista/coleccion añade un objeto de tipo Pelota.
		pelotas.add(b);
	
	}
	
	
	
    //Dibujar la pelota en la lamina
	public void paintComponent(Graphics g) {
		
	   
		super.paintComponent(g);
		
		
	   Graphics2D g2 = (Graphics2D) g;
	
		
		for(Pelota p: pelotas) {
			
			g2.fill(p.getShape());
			
		}
		
		
	
	
	
	}
	
	
	
	
	
	
	
	
	
}
