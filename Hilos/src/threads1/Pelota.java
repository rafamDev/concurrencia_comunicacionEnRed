package threads1;

import java.awt.geom.Ellipse2D;
import java.awt.geom.Ellipse2D.Double;
import java.awt.geom.Rectangle2D;

public class Pelota {

	
	//MOVIMIENTO DE LA PELOTA
	
    private static final int TAMX = 15;
	
	private static final int TAMY = 15;
	
	//Primera pelota
	private double x = 0;
	
	private double y = 0;
	
	//Siguientes pelotas
	private double Xmas1 = 1;
	
	private double Ymas1 = 1;
	

	
	//Mueve la pelota invirtiendo la posicion si choca con los limites.
	//Recibe por parametro las dimensiones de la pelota y detecta los rebotes de esta.	
	public void movimiento(Rectangle2D limites) {
	//Las dimensiones de la lamina se guardan en un objeto de tipo Rectangle2D.	
	//Sabiendo asi el ancho y el alto.
		
		
		//Incrementar cordenadas X e Y.
		x = x + Xmas1;
		
		y = y + Ymas1;
		//Es lo que hace la sensacion de movimiento, por que la pelota tiene cordenadas.

		
	  
		//Con los metodos se consigue las cordenadas max y min de cada eje, consiguiendo asi detectar los limites
		if(x < limites.getMinX()){
		  
		  
		  x = limites.getMinX();
		  
	      
		  Xmas1 = - Xmas1;
	  
		  //Y cuando conseguimos los limites invertimos la cordenada X e Y.
	  
	  }
	
	  
	  if(x + TAMX >= limites.getMaxX()) {
		  
		  x = limites.getMaxX() - TAMX;
		  
		  Xmas1 = - Xmas1;
		  
	  }
	  

	  
	  if(y < limites.getMinY()) {
		  
		  y = limites.getMinY();
		  
	      Ymas1 = - Ymas1;
	    
	  
	  }
	  
	  
	  if(y + TAMY >= limites.getMaxY()){
		  
		  y = limites.getMinY() - TAMY;
		  
		  Ymas1 = - Ymas1;
	  }
	  
	  
	  
	  
	
	}
	
	
	//Forma de la pelota en su psicion inicial.
	public Ellipse2D getShape() {
		
		return new Ellipse2D.Double(x,y,TAMX,TAMY);
		//Posiciones y pixeles
	}

	
}
