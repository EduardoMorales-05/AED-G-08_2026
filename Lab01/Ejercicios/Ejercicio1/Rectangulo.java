package PyPooEje1;

public class Rectangulo {
    private Coordenada esquina1; // variables 
    private Coordenada esquina2;

    // Constructor 
    public Rectangulo(Coordenada c1, Coordenada c2) {
        setEsquina1(c1); // Se usa setters para asegurar encapsulamiento 
        setEsquina2(c2);
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
