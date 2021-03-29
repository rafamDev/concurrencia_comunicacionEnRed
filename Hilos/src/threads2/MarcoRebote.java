package threads2;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

import javax.swing.JPanel;

public class MarcoRebote extends JFrame{

	
	private LaminaPelota lamina;
	
	private Thread t1,t2,t3;
	
	private JButton arranca1 , arranca2, arranca3, detener1, detener2, detener3;
	
	public MarcoRebote() {
		
		setBounds(600,300,600,350);
		
		setTitle("Juego Pelota");
		
		
		
		this.lamina = new LaminaPelota();
		
		
		add(lamina, BorderLayout.CENTER);
		
		
		JPanel laminaBotones = new JPanel();
	
	    
		arranca1 = new JButton("Hilo1");
		
		arranca1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent evento) {
				inicioDelJuego(evento);
				
			}
		});
		
		
		laminaBotones.add(arranca1);
		
	//------------------------------------------------------------	
	    arranca2 = new JButton("Hilo2");
		
		arranca2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent evento) {
				inicioDelJuego(evento);
				
			}
		});
		
		
		laminaBotones.add(arranca2);
		
		
		//------------------------------------------------------------	
	    arranca3 = new JButton("Hilo3");
		
		arranca3.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent evento) {
				inicioDelJuego(evento);
				
			}
		});
		
		
		laminaBotones.add(arranca3);
		
		//------------------------------------------------------------	
	    detener1 = new JButton("Detener1");
		
		detener1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent evento) {
				detener(evento);
				
			}
		});
		
		
		laminaBotones.add(detener1);
		
		//------------------------------------------------------------	

	    detener2 = new JButton("Detener2");
		
		detener2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent evento) {
				detener(evento);
				
			}
		});
		
		
		laminaBotones.add(detener2);
		
		
		//------------------------------------------------------------	
	    detener3 = new JButton("Detener3");
		
		detener3.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent evento) {
				detener(evento);
				
			}
		});
		
		
		laminaBotones.add(detener3);
		
		
		
	  //----------------------------------------------------------	
	  add(laminaBotones,BorderLayout.SOUTH);
	
	
	}
	
			
	
	      private void inicioDelJuego(ActionEvent e) {
				
		
			  Pelota pelota = new Pelota();
				
			  lamina.add(pelota);
				
			  Runnable r = new PelotaHilos(pelota,lamina);
			  
			  
		if(e.getSource() == arranca1){
			  
			  t1 = new Thread(r);
			  
			 
			  t1.start();
			  
		 }else if(e.getSource() == arranca2) {
				 
			  t2 = new Thread(r);
			  
			  t2.start();
			   	  
				  
	     }else if(e.getSource() == arranca3) {
			 
		  t3 = new Thread(r);
		  
		  t3.start();
		   	  
	     }	  
		
		
	  }

	//Las comparaciones estan echas de forma distinta como prueba. Funcionan Ambas.
				
	      private void detener(ActionEvent e) {

	              
	    	  if(e.getSource().equals(detener1)){
	    	  //Solicitud de detencion del hilo1.
			      t1.interrupt();
					
	    	  }else if(e.getSource().equals(detener2)){
	    		  //Solicitud de detencion del hilo2.
			      t2.interrupt();
					 
	    		  
	          }else if(e.getSource().equals(detener3)){
	    		  //Solicitud de detencion del hilo3.
			      t3.interrupt();
					 
	          }
	    	  
	    	 
	      }
	
	
}