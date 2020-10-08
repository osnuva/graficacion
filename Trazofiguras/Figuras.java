package Trazofiguras;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Graphics;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author brandon osmar
 */
public class Figuras extends JPanel{
    // ventana
    private JFrame ventana;
    // contenedor
    private Container contenedor;
// inicializar la ventana
    public Figuras(){
        ventana = new JFrame("Dibujando icono");
        // definir tamaño a ventana
        ventana.setSize(800, 600);
        ventana.setVisible(true);
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.setResizable(false);
        contenedor = ventana.getContentPane();
        contenedor.setSize(800, 600);
        // agregar la ventana en el contenedor
        contenedor.add(this, BorderLayout.CENTER);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        //trazo de lineas
        g.setColor(Color.red);
        g.drawLine(100,50 ,200 ,50 );
        g.drawLine(200,50, 200, 100);
        g.drawLine(100,50, 100, 100);
        g.drawLine(100,100, 200, 100);
        g.setColor(Color.gray);
        g.drawLine(100,50, 150, 20);
        g.drawLine(200,50, 150, 20);
        
        //trazo de rectangulos
        g.setColor(Color.blue);
        g.drawRect(280, 50, 100, 50);
        g.fillRect(280, 110, 100, 50);
        
        //trazo de rectangulos redondeados
        g.setColor(Color.black);
        g.drawRoundRect(450, 50, 100, 50, 50, 50);
        g.fillRoundRect(450, 110, 100, 50, 20, 20);
        
        //Trazo de circulos
        g.setColor(Color.yellow);
        g.drawOval(100, 200, 80, 80);
        g.fillOval(100, 300, 50, 50);
        
        //trazo de ovalos
        g.setColor(Color.green);
        g.drawOval(200, 200, 80, 40);
        g.fillOval(200, 300, 40, 80);
        
        //trazo de triangulo
        g.setColor(Color.pink);
        g.drawLine(450, 300, 550, 300);
        g.drawLine(450, 300, 500, 250);
        g.drawLine(500, 250, 550, 300);
        
        //dibujo de cadenas de texto
        g.setColor(Color.black);
        g.drawString("Ejemplo de trazo de figuras basicas", 200, 400);
        //trazo de arcos
        g.setColor(Color.MAGENTA);
        //Figura 1: solo contorono
        g.drawArc(400, 310, 400, 390, 40, 100);
        //Figura 2: Relleno
        g.fillArc(400, 320, 400, 400, 40, 100);
    }
    
}
