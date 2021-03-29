package threads3;

public class SincrHilos extends Thread {

	
	@Override
	public void run() {
		
		for(int i= 0; i<10; i++) {
			
			System.out.println("Ejecutando hilo " + getName());
			

			try {
				SincrHilos.sleep(700);
				//Al heredar utilizo la subclase para llamar a este metodo static.
			} catch (InterruptedException e) {
				
				e.printStackTrace();
			}
	
			
		}
		
		
	}
	
	
	
}
