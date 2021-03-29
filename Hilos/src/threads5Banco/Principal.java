package threads5Banco;

import threads6Banco.Banco;
import threads6Banco.EjecucionTransferencias;

public class Principal {

	public static void main(String[] args) {
		
		Banco santander = new Banco();
		
		//Crear un bucle que haga transferencias.Desde la cuenta 0 hasta la 99.
		
		for(int i = 0; i < 100; i++) {
			
			//A cada vuelta de bucle crea una cuenta empezando por la 0 hasta la 99.
			EjecucionTransferencias r = new EjecucionTransferencias(santander, i , 2000);
			
			//Todo esto que me lo haga en hilos distintos
			Thread t = new Thread(r);
			
			t.start();
		}
	}

}
