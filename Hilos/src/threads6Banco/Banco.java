package threads6Banco;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;


public class Banco{

	
	private final double cuentas [];
	
	private Lock cierreHiloN = new ReentrantLock();
	
	private Condition saldoSuficiente;
	
	public Banco(){
		
		
		this.cuentas = new double[100];
		
		
		
		for(int i = 0; i < this.cuentas.length; i++){
		
		
			this.cuentas[i] = 2000;
		}
		
	    //Cada vez que creamos un banco este banco va con la condicion de cierre de hilo, es decir bloqueo y desbloque de hilos.
		this.saldoSuficiente = this.cierreHiloN.newCondition();
		
	}
	
	public void transferencia(int cuentaOrigen, int cuentaDestino, double cantidad) throws InterruptedException{
		
		this.cierreHiloN.lock();
	
		
		try{
	
		
		while(this.cuentas[cuentaOrigen] < cantidad){
			
			//Si se cumple la condicion el hiloN permanece a la espera hasta que lo despierte signalAll() y salga del bucle en caso de que esta vexz no se cumpla la condicion.
			this.saldoSuficiente.await();
			//Al ponerse a la espera se libera el bloqueo y ya puede entrar otro hilo.
		}
		
		
		
	
		System.out.println(Thread.currentThread());
		
		this.cuentas[cuentaOrigen] = this.cuentas[cuentaOrigen] - cantidad; 
		
		System.out.printf("%10.2f$ de la cuenta: %d ,para la cuenta: %d ", cantidad, cuentaOrigen, cuentaDestino);
	
		this.cuentas[cuentaDestino] = this.cuentas[cuentaDestino] + cantidad;
	
		System.out.printf("Saldo total del banco: %10.2f%n",saldoTotal(), "$");
	
	
		//Despierta al hilo X una vez el hilo Y ya haya ejecutado este bloque de codigo, ya que permanece a la espera.
		saldoSuficiente.signalAll();
		
		} finally {
			
		    this.cierreHiloN.unlock();
			
		}
	
	
	
	}


     public double saldoTotal(){
    	
    	 double sumaCuentas = 0; 
    	 
    	 for(double s: cuentas){
    		
    		 sumaCuentas = sumaCuentas + s;
    	   
         }

    	 return sumaCuentas;
    }


}
