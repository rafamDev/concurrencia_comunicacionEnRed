package threads6Banco;

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
			
			
			double cantidad =  this.cantidadMax * Math.random();
		
			
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
