package threads1;

import java.awt.Component;

//PARA PODER TENER VARIOS HILOS DE EJCUCUCION EN UN PROGRAMA NECESITAMOS UNA CLASE QUE IMPLEMENTE LA INTERFAZ RUNNABLE.
public class PelotaHilos implements Runnable {

	private Pelota pelota;
	
	private Component laLamina;
	
	
	public PelotaHilos(Pelota unaPelota, Component laLamina) {
		
		this.pelota = unaPelota;
		
		this.laLamina = laLamina;
		
	}
	
	
	@Override
	public void run() {

        for(int i = 1;  i <= 3000; i++){
			
			//En la primera vuelta de bucle la pinta en la posicion XY inicial.
      	//Despues cambia 3000 veces la posicion como consecuencia de la iteracion.
      	laLamina.paint(laLamina.getGraphics());
			
      	//Llamamos al metodo mueve pelota unas 3000 veces.
		    pelota.movimiento(laLamina.getBounds());
		
		
		    try{
		    
		    	//Tiempo del movimiento.** Este metodo lanza una Excepcion.
		    	Thread.sleep(4);
		    
		    }catch(InterruptedException ex) {
		    	
		    	ex.printStackTrace();
		    	
		    }
		    
		    
		}
		
	
		
	}
  


	
}
