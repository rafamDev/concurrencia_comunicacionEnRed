package threads6Banco;

public class Principal {

	public static void main(String[] args) {
		
		Banco santander = new Banco();
		
	
		
		for(int i = 0; i < 100; i++) {
			
			
			EjecucionTransferencias r = new EjecucionTransferencias(santander, i , 2000);
			
			Thread t = new Thread(r);
			
			t.start();
		}
	}

}
