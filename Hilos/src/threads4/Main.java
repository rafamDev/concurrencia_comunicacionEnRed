package threads4;



public class Main {

	public static void main(String[] args) {
		
		SincrHilos hilo1 = new SincrHilos();
       
		SincrHilos2 hilo2 = new SincrHilos2(hilo1);
        SincrHilos2 hilo3 = new SincrHilos2(hilo2);
		
        hilo1.start();
		
		hilo3.start();
		
		hilo2.start();
		
		//El sleep de cada hilo deben ser los mismos para una mejor sincronizacion.
		//Proimero ejecuta el Main por eso esto es la primaro. 
		System.out.println("Hilos terminados");
	

	}

}
