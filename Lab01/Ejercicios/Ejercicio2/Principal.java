package PyPooEje2;

import java.util.*;

public class Principal
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);

        int filas = 3;
        int columnas = 3;

        Zona[][] matriz = new Zona[filas][columnas];

        // Ejemplo manual se puede hacer don dos for
        matriz[0][0] = new Zona("Oro", 10, 0.8);
        matriz[0][1] = new Zona("Plata", 8, 0.6);
        matriz[0][2] = new Zona("Oro", 6, 0.9);

        matriz[1][0] = new Zona("Cobre", 12, 0.5);
        matriz[1][1] = new Zona("Oro", 7, 0.7);
        matriz[1][2] = new Zona("Plata", 9, 0.6);

        matriz[2][0] = new Zona("Oro", 5, 0.8);
        matriz[2][1] = new Zona("Cobre", 11, 0.4);
        matriz[2][2] = new Zona("Oro", 10, 0.9);

        System.out.print("Ingrese k: ");
        int k = sc.nextInt();

        double maxValor = -1;
        int mejorFila = 0;
        int mejorCol = 0;

        // recorrer submatrices k x k
        for (int i = 0; i <= filas - k; i++)
        {
            for (int j = 0; j <= columnas - k; j++)
            {
                double suma = 0;

                for (int x = i; x < i + k; x++)
                {
                    for (int y = j; y < j + k; y++)
                    {
                        suma += matriz[x][y].getValor();
                    }
                }

                if (suma > maxValor)
                {
                    maxValor = suma;
                    mejorFila = i;
                    mejorCol = j;
                }
            }
        }

        // mostrar resultados
        System.out.println("\nValor máximo: " + maxValor);
        System.out.println("Posición inicial: (" + mejorFila + ", " + mejorCol + ")");

        // mostrar subregión
        Map<String, Integer> conteo = new HashMap<>();

        System.out.println("\nZonas en la región:");

        for (int i = mejorFila; i < mejorFila + k; i++)
        {
            for (int j = mejorCol; j < mejorCol + k; j++)
            {
                System.out.println(matriz[i][j]);

                String mineral = matriz[i][j].getMineral();
                conteo.put(mineral, conteo.getOrDefault(mineral, 0) + 1);
            }
        }

        //Mineral predominante
        String dominante = "";
        int maxCount = 0;

        for (String key : conteo.keySet())
        {
            if (conteo.get(key) > maxCount)
            {
                maxCount = conteo.get(key);
                dominante = key;
            }
        }

        System.out.println("\nMineral predominante: " + dominante);
    }
}
