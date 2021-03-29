package threads5Banco;


public class EjecucionTransferencias implements Runnable {

	private Banco banco;
	private int cuentaOrigen;
	private double cantidadMax;
	
	public EjecucionTransferencias(Banco banco, int cuentaOrigen, double cantidadMax) {
		
		this.banco = banco;
		this.cuentaOrigen = cuentaOrigen;
		this.cantidadMax = cantidadMax;
		
		
	}
	

	@Override
	public void run() {
		
		while(true){
			
			int cuentaDestino = (int)( 100*Math.random() );
			//Para quitar el 0, por eso se multiplica x 100, y el castin hace que no coja los valores seguidos de ,
			//0,235682 -> 23,5682 -> (int) -> 23.
			
			double cantidad =  this.cantidadMax * Math.random();
			//2000 x 0,44345 a transferir.
			
			try {
				
				this.banco.transferencia(this.cuentaOrigen, cuentaDestino, cantidad);
			
			} catch (InterruptedException e1) {
				e1.printStackTrace();
			}
			
			try {
				Thread.sleep((int)Math.random()*10);
			} catch (InterruptedException e) {
			    e.printStackTrace();
			}
		}
		
		
	}

}
