package threads5Banco;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

//Creacion de un banco con 100 cuentas cuyo saldo inicial es 2000$.
public class Banco{

	//Utilizo constante porque no se puede modificar el valor.
	//En este caso la inicializo en el constructor.
	private final double cuentas [];
	
	private Lock cierreHiloN = new ReentrantLock();
	
	
	public Banco(){
		
		 //Creacion de 100 cuentas.
		//cuenta 0, cuenta 1, cuenta 2.. hasta cuenta 99.
		this.cuentas = new double[100];
		
		
		//Para cargar un saldo en cada cuenta.
		for(int i = 0; i < this.cuentas.length; i++){
		
			//A cada vuelta de bucle, designará un valor de 2000$ en cada cuenta.
			this.cuentas[i] = 2000;
		}
		
	   
	}
	
	public void transferencia(int cuentaOrigen, int cuentaDestino, double cantidad) throws InterruptedException{
		
		//El hilo que este ejecutando este metodo bloquea la ejecucion hasta que termine, asi desbloqueandolo. 
		this.cierreHiloN.lock();
		//Bloquea el hilo x hasta que termine la tarea, es decir NO DEJA QUE OTRO HILO PASE hasta que no este desbloqueado, termine.
		
		try{
		
       			
		
		//Para no transferir mas saldo del disponible en cada cuenta.
		//Evalua que el saldo no es inferior a la transferencia.
		if(this.cuentas[cuentaOrigen] < cantidad){
		  //Este array recibe enteros [100]. Entonces se le pasará por parámetros la posición solicitada.	
			
			double saldoNegativo = cantidad - this.cuentas[cuentaOrigen]; 
			
			System.out.println("---------------SALDO INSUFICIENTE en la cuenta: " + cuentaOrigen
					           + " , saldo: "+ this.cuentas[cuentaOrigen] + "$."
					           + " NO SE HA PODIDO HACER LA TRANSFERENCIA DE: " + cantidad + "$."
					           + " Le faltan: " + saldoNegativo + "$");
			
			return;
			//Con esta sentencia devuelve el flujo de ejecucion dentro del metodo.(Para que no haga nada).
			
		}else {
			
			System.out.println("---------------SALDO SUFICIENTE en la cuenta: " + cuentaOrigen
			           + " , saldo: "+ this.cuentas[cuentaOrigen] + "$"
			           + " SE HA PODIDO HACER LA TRANSFERENCIA DE: " + cantidad + "$");
	
			
		}
		
		
		
	
		
		//Para saber que hilo hara la transferencia.
		System.out.println(Thread.currentThread());
		
		this.cuentas[cuentaOrigen] = this.cuentas[cuentaOrigen] - cantidad; 
		//Dinero que sale de la cuentaOrigen.
		//Descontamos el saldo de la cuentaOrigen la cantidad que queremos transferir.
		
		System.out.printf("%10.2f$ de la cuenta: %d ,para la cuenta: %d ", cantidad, cuentaOrigen, cuentaDestino);
	
		this.cuentas[cuentaDestino] = this.cuentas[cuentaDestino] + cantidad;
	
		System.out.printf("Saldo total del banco: %10.2f%n",saldoTotal(), "$");
	
	
		} finally {
			
		    this.cierreHiloN.unlock();
			
		}
	
	
	
	}


     public double saldoTotal(){
    	
    	 double sumaCuentas = 0; 
    	 
    	 for(double s: cuentas){
    		 //Almacenar en s el valor(double) de cada posicion.
    		 sumaCuentas = sumaCuentas + s;
    	     //SumaCuenta acumula el valor double en cada posicion de cuentas, recorriendo cada posicion del array.
    		 //SumaCuentas acumula el saldo de cada cuenta recorriendo cada cuenta.
    		 //sumaCuentas acumule lo que se incremente en s.
         }

    	 return sumaCuentas;
    }


}
