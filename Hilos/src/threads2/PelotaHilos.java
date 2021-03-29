package threads2;

import java.awt.Component;


public class PelotaHilos implements Runnable {

	private Pelota pelota;
	
	private Component laLamina;
	
	
	public PelotaHilos(Pelota unaPelota, Component laLamina) {
		
		this.pelota = unaPelota;
		
		this.laLamina = laLamina;
		
	}
	


	@Override
	public void run() {

	 System.out.println("¿Está el hilo detenido?: " + Thread.currentThread().isInterrupted());	
		
     //Mientras este hilo no este imterrumpido..
	 while(!Thread.currentThread().isInterrupted()){
		
    	
		 laLamina.paint(laLamina.getGraphics());
			
    	
		    pelota.movimiento(laLamina.getBounds());
		
		      try {
		    	  
		    	  Thread.sleep(4);
		    	  //sleep() bloquea un hilo y cuando lo intentas interrumpir el metodo sleep() lanza una excepcion.
		    	  
		      }catch(InterruptedException e) {
		    	  
		    	  //interrumpir el hilo actual.
		    	  Thread.currentThread().interrupt();
		    	  
		    	  
		      }
		    
		    
		}
		
	 System.out.println("¿Está el hilo detenido?: " + Thread.currentThread().isInterrupted());	
		
	}



	
}