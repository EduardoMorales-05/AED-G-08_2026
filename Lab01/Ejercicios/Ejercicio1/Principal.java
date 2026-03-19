package PyPooEje1;

import java.util.Scanner;

public class Principal
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);

        // Crear contenedor (máximo 5 por ejemplo)
        ContainerRect contenedor = new ContainerRect(5);

        // Crear rectángulo 1
        Coordenada c1 = new Coordenada(1.5, 0.3);
        Coordenada c2 = new Coordenada(7.6, 2.2);
        Rectangulo r1 = new Rectangulo(c1, c2);

        contenedor.addRectangulo(r1);

        // Crear rectángulo 2
        Coordenada c3 = new Coordenada(4.0, 4.2);
        Coordenada c4 = new Coordenada(9.4, -2.5);
        Rectangulo r2 = new Rectangulo(c3, c4);

        contenedor.addRectangulo(r2);

        // Mostrar contenido
        System.out.println(contenedor.toString());
    }
}
