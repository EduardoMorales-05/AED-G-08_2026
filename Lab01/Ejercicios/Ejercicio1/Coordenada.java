package PyPooEje1;

public class Coordenada {
    private double x;
    private double y;

    // Constructor que inicializa x, y en cero 
    public Coordenada() {
        this.x = 0;
        this.y = 0;
    }

    // Constructor con parámetros
    public Coordenada(double x, double y) {
        this.x = x;
        this.y = y;
    }

    // Constructor de copia 
    public Coordenada(Coordenada c) {
        this.x = c.x;
        this.y = c.y;
    }

    // Métodos Setter 
    public void setX(double x) { this.x = x; }
    public void setY(double y) { this.y = y; }

    // Métodos Getter 
    public double getX() { return x; }
    public double getY() { return y; }

    // Método de instancia: Distancia 
    public double distancia(Coordenada c) {
        return Math.sqrt(Math.pow(this.x - c.getX(), 2) + Math.pow(this.y - c.getY(), 2));
    }

    // Método de clase (estático): Distancia entre dos coordenadas 
    public static double distancia(Coordenada c1, Coordenada c2) {
        return Math.sqrt(Math.pow(c1.getX() - c2.getX(), 2) + Math.pow(c1.getY() - c2.getY(), 2));
    }

    @Override
    public String toString() {
        // Formato: [x, y]
        return "[" + x + ", " + y + "]";
    }
    
}
