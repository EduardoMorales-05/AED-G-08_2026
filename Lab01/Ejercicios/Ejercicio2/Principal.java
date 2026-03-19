package PyPooEje2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.HashMap;
import java.util.Map;

public class Principal
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);

        Zona[][] matriz = null;
        int filas = 0;
        int columnas = 0;

        // Lectura de datos desde archivo
        try
        {
            File archivo = new File("zonas.txt");
            Scanner lector = new Scanner(archivo);

            // La primera línea contiene dimensiones de la matriz
            filas = lector.nextInt();
            columnas = lector.nextInt();

            // Creación dinámica de la matriz
            matriz = new Zona[filas][columnas];

            // Lectura de cada zona
            for (int i = 0; i < filas; i++)
            {
                for (int j = 0; j < columnas; j++)
                {
                    String mineral = lector.next();
                    double cantidad = lector.nextDouble();
                    double pureza = lector.nextDouble();

                    matriz[i][j] = new Zona(mineral, cantidad, pureza);
                }
            }

            lector.close();
        }
        catch (FileNotFoundException e)
        {
            System.out.println("Error: archivo no encontrado.");
            return;
        }

        // Entrada del tamaño de la subregión
        System.out.print("Ingrese el tamaño k de la subregión: ");
        int k = sc.nextInt();

        double maxValor = -1;
        int mejorFila = 0;
        int mejorCol = 0;

        // Recorrido de todas las submatrices k x k posibles
        for (int i = 0; i <= filas - k; i++)
        {
            for (int j = 0; j <= columnas - k; j++)
            {
                double suma = 0;

                // Cálculo del valor total de la subregión
                for (int x = i; x < i + k; x++)
                {
                    for (int y = j; y < j + k; y++)
                    {
                        suma += matriz[x][y].getValor();
                    }
                }

                // Actualización del valor máximo encontrado
                if (suma > maxValor)
                {
                    maxValor = suma;
                    mejorFila = i;
                    mejorCol = j;
                }
            }
        }

        // Mostrar resultados principales
        System.out.println("\nValor total máximo: " + maxValor);
        System.out.println("Posición inicial de la subregión: (" + mejorFila + ", " + mejorCol + ")");

        // Estructura para contar frecuencia de minerales
        Map<String, Integer> conteo = new HashMap<>();

        System.out.println("\nZonas dentro de la subregión seleccionada:");

        // Recorrido de la subregión óptima
        for (int i = mejorFila; i < mejorFila + k; i++)
        {
            for (int j = mejorCol; j < mejorCol + k; j++)
            {
                System.out.println(matriz[i][j]);

                // Conteo de minerales
                String mineral = matriz[i][j].getMineral();
                conteo.put(mineral, conteo.getOrDefault(mineral, 0) + 1);
            }
        }

        // Determinar el mineral predominante
        String mineralDominante = "";
        int maxFrecuencia = 0;

        for (String key : conteo.keySet())
        {
            if (conteo.get(key) > maxFrecuencia)
            {
                maxFrecuencia = conteo.get(key);
                mineralDominante = key;
            }
        }

        System.out.println("\nMineral predominante: " + mineralDominante);
    }
}
