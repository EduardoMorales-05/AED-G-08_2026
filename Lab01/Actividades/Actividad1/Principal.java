package PyPooAct1;

import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        // Variable para capturar lo que el usuario escribe 
        Scanner sc = new Scanner(System.in);

        // ENTRADA PARA EL RECTÁNGULO A
        System.out.println("Datos del 1er Rectángulo (A)");
        System.out.println("Ingrese la primera esquina:");
        System.out.print("x1 = "); // el valor de X
        double ax1 = sc.nextDouble();
        System.out.print("y1 = "); // el valor de Y
        double ay1 = sc.nextDouble();
        Coordenada a1 = new Coordenada(ax1, ay1);

        System.out.println("Ingrese la esquina opuesta:");
        System.out.print("x2 = "); // el valor de X2
        double ax2 = sc.nextDouble();
        System.out.print("y2 = "); //el valor de Y2
        double ay2 = sc.nextDouble();
        Coordenada a2 = new Coordenada(ax2, ay2);
        
        // Creamos el rectángulo A con los puntos capturados 
        Rectangulo rectA = new Rectangulo(a1, a2); // OBJETO RECTANGULO CREADO

        //  ENTRADA PARA EL RECTÁNGULO B 
        System.out.println("\nDatos del 2do Rectángulo (B)");
        System.out.println("Ingrese la primera esquina:");
        System.out.print("x1 = "); // el valor de X1
        double bx1 = sc.nextDouble();
        System.out.print("y1 = "); // el valor de Y1
        double by1 = sc.nextDouble();
        Coordenada b1 = new Coordenada(bx1, by1);

        System.out.println("Ingrese la esquina opuesta:");
        System.out.print("x2 = "); // el valor de X2
        double bx2 = sc.nextDouble();
        System.out.print("y2 = "); // el valor de Y2
        double by2 = sc.nextDouble();
        Coordenada b2 = new Coordenada(bx2, by2);
        
        // Creamos el rectángulo B 
        Rectangulo rectB = new Rectangulo(b1, b2); // OBJETO RECTANGULO CREADO

        // MOSTRAR RESULTADOS
        System.out.println("\n");
        // Se usa el método toString para mostrar la info en formato 
     // Mostrar información de rectángulos exactamente como la imagen
        System.out.println("Rectangulo A = " + rectA.toString());
        System.out.println("Rectangulo B = " + rectB.toString());

        if (Verificador.esSobrePos(rectA, rectB)) {
            System.out.println("Rectangulos A y B se sobreponen."); 
            Rectangulo sobre = rectanguloSobre(rectA, rectB); 
            // formato igual que el de la guia
            System.out.printf("Area de sobreposicion = %.2f\n", sobre.calculoArea());
        }
        
        else if (Verificador.esJunto(rectA, rectB)) {
            System.out.println("Resultado: Los rectángulos A y B se juntan.");
        } 
        else {
        	System.out.println("Rectangulos A y B son disjuntos");
        }
    }

    // Método para encontrar el rectángulo que se forma en la intersección 
    public static Rectangulo rectanguloSobre(Rectangulo r1, Rectangulo r2) {
        // Buscamos los límites donde ambos rectángulos coinciden
        double xInicio = Math.max(Math.min(r1.getEsquina1().getX(), r1.getEsquina2().getX()), 
                                  Math.min(r2.getEsquina1().getX(), r2.getEsquina2().getX()));
        double yInicio = Math.max(Math.min(r1.getEsquina1().getY(), r1.getEsquina2().getY()), 
                                  Math.min(r2.getEsquina1().getY(), r2.getEsquina2().getY()));
        double xFin = Math.min(Math.max(r1.getEsquina1().getX(), r1.getEsquina2().getX()), 
                               Math.max(r2.getEsquina1().getX(), r2.getEsquina2().getX()));
        double yFin = Math.min(Math.max(r1.getEsquina1().getY(), r1.getEsquina2().getY()), 
                               Math.max(r2.getEsquina1().getY(), r2.getEsquina2().getY()));

        return new Rectangulo(new Coordenada(xInicio, yInicio), new Coordenada(xFin, yFin));
    }
}
