package threads7Banco;

//Con los metodos de la clase Object solo podemos hacer una condicion con la Interfaz Condition
//podemos hacer varias.
public class Banco{

	private final double cuentas [];
	
	public Banco(){
		
		this.cuentas = new double[100];
		
		for(int i = 0; i < this.cuentas.length; i++){
		
			
			this.cuentas[i] = 2000;
		}
		
	   //Se puede eliminar la condicion.
	}
	
    //Al ser el metodo mas importante.
	public synchronized void transferencia(int cuentaOrigen, int cuentaDestino, double cantidad) throws InterruptedException{
		
		
	  //Se puede eliminar el blocueo/cierre.
	
	    while(this.cuentas[cuentaOrigen] < cantidad){
			
			wait();
			//Si se cumple la condicion el hilo se va a poner a la espera.
		
		}
		
		
	    System.out.println(Thread.currentThread());
		
		this.cuentas[cuentaOrigen] = this.cuentas[cuentaOrigen] - cantidad; 
		
		System.out.printf("%10.2f$ de la cuenta: %d ,para la cuenta: %d ", cantidad, cuentaOrigen, cuentaDestino);
	
		this.cuentas[cuentaDestino] = this.cuentas[cuentaDestino] + cantidad;
	
		System.out.printf("Saldo total del banco: %10.2f%n",saldoTotal(), "$");
	

         notifyAll();
         //Este metodo de la clase Object informa a los otros hilos de que se ha terminado de ejecutar y que vuelvan a revisar la condicion.
		
		//Se puede eliminar el finally , el desbloqueo y signalAll() que despierta a todos los hilos..
	
	
	}


     public double saldoTotal(){
    	
    	 double sumaCuentas = 0; 
    	 
    	 for(double s: cuentas){
    		 
    		 sumaCuentas = sumaCuentas + s;
    	   
         }

    	 return sumaCuentas;
    }


}