package PyPooAct1;

public class Coordenada { // Clase Coordenada
	private double x;  //Variables
	private double y;
	
	public Coordenada () { //Constructor de la clase coordenada
		this.x=0;
		this.y=0;
	}
	
	public Coordenada (double x, double y) {  // Constructor Parametrizado
		this.x=x;
		this.y=y;
	}
	
	public Coordenada (Coordenada c) { //Constructor Copia
		this.x=c.x;
		this.y=c.y;
	}
	
	// Setters
	public void setX (double x) {
		this.x = x;
	}
	
	public void setY(double y) {
		this.y = y;
	}
	
	//Getters
	public double getX() {
		return this.x;
	}
	
	public double getY() {
		return this.y;
	}
	
	// Metodo instancias
	// Metodo distancia entre 2 puntos
	double distancia (Coordenada c) {
		double dx = this.x - c.x;
		double dy = this.y - c.y;
		return Math.sqrt(dx * dx + dy * dy);
	}
	
	// Metodo distancia entre 2 Objetos
	static double distancia(Coordenada c1, Coordenada c2) {
		double dx = c1.x - c2.x;  
		double dy = c1.y - c2.y;
		return Math.sqrt(dx * dx + dy * dy);
	}
	
	// To string para imprimir los valores
	@Override
	public String toString() {
		return "[" + x + ", " + y + "]";
	}
}
