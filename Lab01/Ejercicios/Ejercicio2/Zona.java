package PyPooEje2;

public class Zona
{
    private String mineral;
    private double cantidad;
    private double pureza;

    public Zona(String mineral, double cantidad, double pureza)
    {
        this.mineral = mineral;
        this.cantidad = cantidad;
        this.pureza = pureza;
    }

    public double getValor()
    {
        return cantidad * pureza;
    }

    public String getMineral()
    {
        return mineral;
    }

    public String toString()
    {
        return mineral + " (" + cantidad + ", " + pureza + ")";
    }
}
