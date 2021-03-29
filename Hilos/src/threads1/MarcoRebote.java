package threads1;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class MarcoRebote extends JFrame{

	
	//Marco con Lamina y Botones.
	
	
	private LaminaPelota lamina;
	
	
	
	public MarcoRebote() {
		
		setBounds(600,300,400,350);
		
		setTitle("Juego Pelota");
		
		
		//Agregacin de la lamina donde estaran las pelotas.
		this.lamina = new LaminaPelota();
		
		//La añadimos en el centro/norte.
		add(lamina, BorderLayout.CENTER);
		
		//Creacion de la lamina de los botones en el sur.
		JPanel laminaBotones = new JPanel();
	
		
		
		//Metodo ponerBoton se le va a pasar la lamina sur (el objeto)
		//y el titulo y el objeto oyente que estara a la escucha del evento.
		ponerBoton(laminaBotones,"Jugar", new ActionListener(){
			
			public void actionPerformed(ActionEvent evento) {
				
				inicioDelJuego();
				
			}

			
			
			private void inicioDelJuego() {
				
			//AGREGAMOS LA PELOTA A LA LAMINA.	
			  Pelota pelota = new Pelota();
				
			  lamina.add(pelota);
				
			  Runnable r = new PelotaHilos(pelota,lamina);
			  
			  //El argumento de tipo Runnable es el destino del hilo.
			  Thread t = new Thread(r);
			  
			  //Comienzo del hilo.
			  t.start();
			  
			  //CUANDO SE PRESIONE EL BOTON SE CREARAN OBJETOS DE TIPO PELOTA SIN ESPERAR A QUE TERMINE LA EJECUCCION DEL PROGRAMA.
			  
			  
				}

				
				
			

			
		
		});
		
		
		
	    ponerBoton(laminaBotones,"Salir", new ActionListener(){
			
			public void actionPerformed(ActionEvent evento) {
				
				System.exit(0);
				
			}
			
			
		});
		
		
		//Se añade la lamina sur.
	    add(laminaBotones, BorderLayout.SOUTH);
		
		
	}


	
	 private void ponerBoton(Container c, String titulo, ActionListener oyente) {
		
		 //Se crean los botones con este metodo.
		 JButton boton = new JButton(titulo);
		 
		 //Se añaden a la lamina sur.
		 c.add(boton);
		 
		 //Se pone a la escucha. 
		 boton.addActionListener(oyente);
		 
		 
		
	}



	
	
	
}
