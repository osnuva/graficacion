package expo;
/**
 *
 * @author brandon osmar
 */
public class Principal {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Punto figura[] = {
            new Punto(400, 410),//1
            new Punto(400, 200),//2
            new Punto(410, 200),//3
            new Punto(410, 190),//4
            new Punto(420, 190),//5
            new Punto(420, 180),//6
            new Punto(430, 180),//7
            new Punto(430, 170),//8
            new Punto(440, 170),//9
            new Punto(440, 160),//10
            new Punto(450, 160),//11
            new Punto(450, 150),//12
            new Punto(520, 150),//13
            new Punto(520, 160),//14
            new Punto(530, 160),//15
            new Punto(530, 170),//16
            new Punto(540, 170),//17
            new Punto(540, 180),//18
            new Punto(550, 180),//19
            new Punto(550, 190),//20
            new Punto(590, 190),//21
            new Punto(590, 200),//22
            new Punto(600, 200),//23
            new Punto(600, 210),//24
            new Punto(610, 210), //25
            new Punto(610, 220),//26
            new Punto(620, 220),//27
            new Punto(620, 230),//28
            new Punto(610, 230),//29
            new Punto(610, 240),//30
            new Punto(600, 240),//31
            new Punto(600, 250),//32
            new Punto(590, 250),//33
            new Punto(590, 260),//34
            new Punto(580, 260),//35
            new Punto(580, 270),//36
            new Punto(570, 270),//37
            new Punto(570, 280),//38
            new Punto(540, 280),//39
            new Punto(540, 290),//40
            new Punto(530, 290),//41
            new Punto(530, 390),//42 
            new Punto(560, 360),//43
            new Punto(580, 360),//44
            new Punto(600, 380),//45
            new Punto(600, 400),//46
            new Punto(590, 380),//47
            new Punto(580,375),//48
            new Punto(565,375),//49
            new Punto(530,410),//50
            new Punto(400, 410),//1
        };
        //Crear instancia de ventana
        new Ventana("Transformaciones geometricas", figura);
    }
    
}
