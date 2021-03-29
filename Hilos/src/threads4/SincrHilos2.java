package threads4;

public class SincrHilos2 extends Thread {

	private Thread hilo;
	
	
	public SincrHilos2(Thread hilo){
		
		this.hilo = hilo;
		
	}

	
	@Override
	public void run() {
		
		
		//Gracias a join() se ordena cada hilo ya que no empieza el siguiente sin acabar el anteriior.
		try {
		
			this.hilo.join();
		
		} catch (InterruptedException e1) {
		
			e1.printStackTrace();
		}
		
		
		for(int i= 0; i<10; i++) {
			
			System.out.println("Ejecutando hilo " + getName());
			

			try {
				SincrHilos.sleep(500);
				//Al heredar utilizo la subclase para llamar a este metodo static.
			} catch (InterruptedException e) {
				
				e.printStackTrace();
			}
			
		
			
		}
		
		
	}
	
	

}
