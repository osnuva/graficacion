package Transformaciones;

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
public class Ventana extends JPanel {
    // ventana
    private JFrame ventana;
    // contenedor
    private Container contenedor;
    //declarar la figura
    private Punto figura[];

    /**
     * Crear una ventana para representar la figura
     * @param titulo Titulo de la ventana
     * @param figura Figura representada por puntos
     */
    public Ventana(String titulo,Punto figura[]) {
        // inicializar la ventana
        ventana = new JFrame(titulo);
        // definir tamaño a ventana
        ventana.setSize(800, 600);
        ventana.setVisible(true);
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.setResizable(false);
        
        contenedor = ventana.getContentPane();
        contenedor.setSize(800, 600);
        // agregar la ventana en el contenedor
        contenedor.add(this, BorderLayout.CENTER);
        this.figura=figura;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g); 
        //Dibujar la figura original
        g.setColor(Color.red);
        this.dibujar(g);
        //Trasladar la figura
        this.trasladar(200,200);
        g.setColor(Color.decode("#253697"));
        this.dibujar(g);
        //Escalar la figura
        this.escalar(.9f,.9f);
        g.setColor(Color.green);
        this.dibujar(g);
    }
    
    public void trasladar(int factorx,int factory){
        for (Punto punto : figura) {
            punto.setX(punto.getX()+factorx);
            punto.setY(punto.getY()+factory);
        }
    }
    public void escalar(float factorx,float factory){
        for (Punto punto : figura) {
            punto.setX((int)(punto.getX()*factorx));
            punto.setY((int)(punto.getY()*factory));
        }
    }
    private void dibujar(Graphics g){
        for (int i = 0; i < figura.length-1; i++) {
            g.drawLine(
                    this.figura[i].getX(),//punto A
                    this.figura[i].getY(),
                    this.figura[i+1].getX(),//punto B
                    this.figura[i+1].getY()
            );
        }
    }
    
    
    
}
