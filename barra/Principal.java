package barra;
/**
 *
 * @author brandon osmar
 */
public class Principal {
    public static void main(String[] args) {
        Punto figura[] = {
            new Punto(100, 410),//1
            new Punto(100, 200),//2
            new Punto(110, 200),//3
            new Punto(110, 190),//4
            new Punto(120, 190),//5
            new Punto(120, 180),//6
            new Punto(130, 180),//7
            new Punto(130, 170),//8
            new Punto(140, 170),//9
            new Punto(140, 160),//10
            new Punto(150, 160),//11
            new Punto(150, 150),//12
            new Punto(220, 150),//13
            new Punto(220, 160),//14
            new Punto(230, 160),//15
            new Punto(230, 170),//16
            new Punto(240, 170),//17
            new Punto(240, 180),//18
            new Punto(250, 180),//19
            new Punto(250, 190),//20
            new Punto(290, 190),//21
            new Punto(290, 200),//22
            new Punto(300, 200),//23
            new Punto(300, 210),//24
            new Punto(310, 210), //25
            new Punto(310, 220),//26
            new Punto(320, 220),//27
            new Punto(320, 230),//28
            new Punto(310, 230),//29
            new Punto(310, 240),//30
            new Punto(300, 240),//31
            new Punto(300, 250),//32
            new Punto(290, 250),//33
            new Punto(290, 260),//34
            new Punto(280, 260),//35
            new Punto(280, 270),//36
            new Punto(270, 270),//37
            new Punto(270, 280),//38
            new Punto(240, 280),//39
            new Punto(240, 290),//40
            new Punto(230, 290),//41
            new Punto(230, 390),//42 
            new Punto(260, 360),//43
            new Punto(280, 360),//44
            new Punto(300, 380),//45
            new Punto(300, 400),//46
            new Punto(290, 380),//47
            new Punto(280,375),//48
            new Punto(265,375),//49
            new Punto(230,410),//50
            new Punto(100, 410),//1
        };
        //Crear instancia de ventana
        new Ventana("Transformaciones geometricas", figura);
    }
    
}
