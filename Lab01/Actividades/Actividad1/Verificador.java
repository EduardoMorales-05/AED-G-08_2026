package PyPooAct1;

public class Verificador {
    // Caso 1: Cuando Se sobreponen 
    public static boolean esSobrePos(Rectangulo r1, Rectangulo r2) {
        return !(Math.max(r1.getEsquina1().getX(), r1.getEsquina2().getX()) <= Math.min(r2.getEsquina1().getX(), r2.getEsquina2().getX()) ||
                 Math.min(r1.getEsquina1().getX(), r1.getEsquina2().getX()) >= Math.max(r2.getEsquina1().getX(), r2.getEsquina2().getX()) ||
                 Math.max(r1.getEsquina1().getY(), r1.getEsquina2().getY()) <= Math.min(r2.getEsquina1().getY(), r2.getEsquina2().getY()) ||
                 Math.min(r1.getEsquina1().getY(), r1.getEsquina2().getY()) >= Math.max(r2.getEsquina1().getY(), r2.getEsquina2().getY()));
    }

    // Caso 2: Cuando estan juntos 
    public static boolean esJunto(Rectangulo r1, Rectangulo r2) {
        if (esSobrePos(r1, r2)) return false;
        
        boolean tocaX = Math.max(r1.getEsquina1().getX(), r1.getEsquina2().getX()) == Math.min(r2.getEsquina1().getX(), r2.getEsquina2().getX()) ||
                        Math.min(r1.getEsquina1().getX(), r1.getEsquina2().getX()) == Math.max(r2.getEsquina1().getX(), r2.getEsquina2().getX());
        boolean tocaY = Math.max(r1.getEsquina1().getY(), r1.getEsquina2().getY()) == Math.min(r2.getEsquina1().getY(), r2.getEsquina2().getY()) ||
                        Math.min(r1.getEsquina1().getY(), r1.getEsquina2().getY()) == Math.max(r2.getEsquina1().getY(), r2.getEsquina2().getY());
        
        return tocaX || tocaY;
    }

    // Caso 3: Cuando no se sobrepone ni esta junto
    public static boolean esDisjunto(Rectangulo r1, Rectangulo r2) {
        return !esSobrePos(r1, r2) && !esJunto(r1, r2);
    }
}