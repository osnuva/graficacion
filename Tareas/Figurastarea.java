package Tareas;

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
public class Figurastarea extends JPanel {
        // ventana
    private JFrame ventana;
    // contenedor
    private Container contenedor;
// inicializar la ventana
    public Figurastarea(){
        ventana = new JFrame("Dibujando figuras");
        // definir tamaño a ventana
        ventana.setSize(650, 320);
        ventana.setVisible(true);
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.setResizable(false);
        contenedor = ventana.getContentPane();
        contenedor.setSize(600, 320);
        // agregar la ventana en el contenedor
        contenedor.add(this, BorderLayout.CENTER);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        
        //cuadros contenedores
        g.setColor(Color.red);
        g.drawRect(10,10 , 200,100 );
        g.drawRect(220,10 , 200,100 );
        g.drawRect(430,10 , 200,100 );
        g.drawRect(10,120 , 200,100 );
        g.drawRect(220,120 , 200,100 );
        g.drawRect(430,120 , 200,100 );
        //dibujando lineas
        g.setColor(Color.red);
        g.drawLine(50, 40, 150, 40);
        g.drawLine(50, 40, 50, 80);
        g.drawLine(50, 80, 150, 80);
        g.drawLine(150, 80, 150, 40);
        g.setColor(Color.blue);
        g.drawLine(50, 40, 100, 20);
        g.drawLine(100, 20, 150, 40);
        g.setColor(Color.orange);
        g.drawLine(70, 80, 70, 60);
        g.drawLine(70, 60, 80, 60);
        g.drawLine(80, 80, 80, 60);
        g.setColor(Color.black);
        g.drawLine(70, 80, 60, 90);
        g.drawLine(80, 80, 70, 90);
        g.drawString("Dibujando lineas", 60, 105);
        //dibujando rectangulos
        g.setColor(Color.decode("#FF0000"));
        g.fillRect(270, 65, 10, 20);
        g.setColor(Color.decode("#FF4200"));
        g.fillRect(290, 55, 10, 30);
        g.setColor(Color.decode("#FF7000"));
        g.fillRect(310, 45, 10, 40);
        g.setColor(Color.decode("#FFA600"));
        g.fillRect(330, 35, 10, 50);
        g.setColor(Color.decode("#FFD500"));
        g.fillRect(350, 25, 10, 60);
        g.setColor(Color.decode("#000000"));
        g.drawString("Dibujando rectangulos", 270, 105);
        //dibujando ovalos con rectangulos
        g.setColor(Color.decode("#FFD500"));
        g.drawRoundRect(525, 30, 20, 60, 90, 90);
        g.setColor(Color.decode("#00B39D"));
        g.drawRoundRect(495, 50, 80, 20, 90, 90);
        g.setColor(Color.decode("#1BB300"));
        g.drawRoundRect(515, 35, 40, 20, 90, 90);
        g.setColor(Color.black);
        g.drawString("Dibujando ovalos con rectangulos", 435, 105);
        //dibujando circulos
        g.setColor(Color.decode("#FFE800"));
        g.fillOval(75, 125, 80, 80);
        g.setColor(Color.white);
        g.fillOval(95, 145, 15, 15);
        g.fillOval(125, 145, 15, 15);
        g.setColor(Color.black);
        g.fillOval(100, 148, 7, 7);
        g.fillOval(130, 148, 7, 7);
        g.drawOval(108, 170, 20, 20); 
        g.drawString("Dibujando circulos", 70, 218);
        //dibujando ovalos con circulos
        g.setColor(Color.blue);
        g.drawOval(315, 140, 20, 60);
        g.setColor(Color.PINK);
        g.drawOval(285, 160, 80, 20);
        g.setColor(Color.RED);
        g.drawOval(305, 145, 40, 20);
        g.setColor(Color.black);
        g.drawString("Dibujando ovalos con circulos", 235, 215);
        //dibujando triangulos
        g.setColor(Color.decode("#05AD4C"));
        g.drawLine(480, 200, 580, 200);
        g.drawLine(480, 200, 540, 170);
        g.drawLine(540, 170, 580, 200);
        g.setColor(Color.decode("#03816E"));
        g.drawLine(540, 170, 590, 170);
        g.drawLine(540, 170, 540, 150);
        g.drawLine(540, 150, 590, 170);
        g.setColor(Color.decode("#BD5000"));
        g.drawLine(475, 180, 510, 180);
        g.drawLine(475, 180, 475, 140);
        g.drawLine(475, 140, 510, 180);
        g.setColor(Color.black);
        g.drawString("Dibujando tiangulos",470, 215);
    }
}
