package threads3;

public class Principal {

	public static void main(String[] args) {
		
		SincrHilos hilo1 = new SincrHilos();
        SincrHilos hilo2 = new SincrHilos();
        SincrHilos hilo3 = new SincrHilos();
		
        hilo1.start();
		
		//Hasta que este hilo1 muera, es decir se acabe la ejecucion del metodo run(), no empezara el otro hilo2. 
		try {
			hilo1.join();
		} catch (InterruptedException e) {
		
			e.printStackTrace();
		}
	
		
		hilo2.start();
		
	
		try {
			hilo2.join();
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}
	
		
		hilo3.start();
		
		
	}

}
