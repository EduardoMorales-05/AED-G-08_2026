package PyPooEje1;

public class ContainerRect
{
    private Rectangulo[] rectangulos;
    private double[] distancias;
    private double[] areas;
    private int n;

    public static int numRec = 0;

    // Constructor
    public ContainerRect(int n)
    {
        this.n = n;
        rectangulos = new Rectangulo[n];
        distancias = new double[n];
        areas = new double[n];
    }

    // Método para agregar rectángulos
    public void addRectangulo(Rectangulo r)
    {
        if (numRec < n)
        {
            rectangulos[numRec] = r;

            // Distancia entre esquinas
            Coordenada c1 = r.getEsquina1();
            Coordenada c2 = r.getEsquina2();

            distancias[numRec] = Coordenada.distancia(c1, c2);

            // Área
            areas[numRec] = r.calculoArea();

            numRec++;
        }
        else
        {
            System.out.println("No se pueden agregar más rectángulos.");
        }
    }

    // Mostrar contenido
    public String toString()
    {
        String resultado = "Rectangulo Coordenadas Distancia Area\n";

        for (int i = 0; i < numRec; i++)
        {
            resultado += (i + 1) + " "
                    + rectangulos[i].toString() + " "
                    + String.format("%.3f", distancias[i]) + " "
                    + String.format("%.2f", areas[i]) + "\n";
        }

        return resultado;
    }
}
