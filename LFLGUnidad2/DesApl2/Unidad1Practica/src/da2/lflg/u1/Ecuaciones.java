package da2.lflg.u1;

import java.io.Serializable;



public class Ecuaciones implements Serializable{
	private int x;
	private int y;
	
	
	@Override
	public String toString() {
		return "Ecuaciones [x=" + x + ", y=" + y + "]";
	}
	
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
	
	public double getResultado() {
		//(4xy + 5x^2y - 6x^3) + (3y^3 - 6xy^2 + 7xy + x^3 - 2x^2y)
		//return ((2*(Math.pow(x,2))) + y) + ((2*(Math.pow(x,2))) + y);
		return ( (4*x*y) + (5*(Math.pow(x,2)*(y))) - (6*(Math.pow(x, 3))) ) +  (3*(Math.pow(y, 3))  - (6*(x)*(Math.pow(y,2)))  + 7*(x)*(y) + ((Math.pow(x, 3))) - (2*(Math.pow(x, 2)*(y)))) ;
	}
	
	
	

}//End
