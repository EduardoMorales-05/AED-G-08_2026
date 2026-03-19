package PyPooAct1;

public class Rectangulo {
    private Coordenada esquina1; // variables 
    private Coordenada esquina2;

    // Constructor 
    public Rectangulo(Coordenada c1, Coordenada c2) {
        // Buscamos el X más pequeño y el X más grande
        double minX = Math.min(c1.getX(), c2.getX());
        double maxX = Math.max(c1.getX(), c2.getX());
        
        // Buscamos el Y más pequeño y el Y más grande
        double minY = Math.min(c1.getY(), c2.getY());
        double maxY = Math.max(c1.getY(), c2.getY());
        
        // Asignamos siempre el punto menor a esquina1 y el mayor a esquina2
        this.esquina1 = new Coordenada(minX, minY);
        this.esquina2 = new Coordenada(maxX, maxY);
    }
    //Setters
    public void setEsquina1(Coordenada coo) { this.esquina1 = new Coordenada(coo); } 
    public void setEsquina2(Coordenada coo) { this.esquina2 = new Coordenada(coo); }
    //Getters
    public Coordenada getEsquina1() { return esquina1; } 
    public Coordenada getEsquina2() { return esquina2; } 

    // Método de instancia para calcular el área (requerido para sobreposición) 
    public double calculoArea() {
        // Calculamos la base y la altura restando las coordenadas
        double base = Math.abs(esquina1.getX() - esquina2.getX());
        double altura = Math.abs(esquina1.getY() - esquina2.getY());
        return base * altura;
    }
    
	@Override
	public String toString() {
	    // Formato: (Coordenada1, Coordenada2)
	    // El método toString de Coordenada ya pone los [ ]
	    return "(" + esquina1.toString() + ", " + esquina2.toString() + ")";
	}
}