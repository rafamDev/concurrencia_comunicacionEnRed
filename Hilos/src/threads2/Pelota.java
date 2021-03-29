package threads2;

import java.awt.geom.Ellipse2D;

import java.awt.geom.Rectangle2D;

public class Pelota {

	
	
    private static final int TAMX = 15;
	
	private static final int TAMY = 15;
	
	
	private double x = 0;
	
	private double y = 0;
	
	
	private double Xmas1 = 1;
	
	private double Ymas1 = 1;
	

	
	public void movimiento(Rectangle2D limites) {
	
		
		
		x = x + Xmas1;
		
		y = y + Ymas1;
	
		
	  
		
		if(x < limites.getMinX()){
		  
		  
		  x = limites.getMinX();
		  
	      
		  Xmas1 = - Xmas1;
	  
		
	  
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
	
	
	public Ellipse2D getShape() {
		
		return new Ellipse2D.Double(x,y,TAMX,TAMY);
		
	}

	
}