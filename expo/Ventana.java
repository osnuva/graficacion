/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package expo;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JToolBar;

/**
 *
 * @author brandon osmar
 */
public class Ventana extends JPanel implements ActionListener{
    // ventana
    int op;
    private JFrame ventana;
    // contenedor
    private Container contenedor;
    //declarar la figura
    private Punto figura[];
    public JMenuBar arc;
    public JMenu uno, dos, tres;
    public JMenuItem u1,u2,u3,d1,d2,d3,t1,t2;

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
        setLayout(new FlowLayout(FlowLayout.LEFT, 2, 0));
        arc = new JMenuBar();
        uno = new JMenu("Acciones");
        uno.setBorder(BorderFactory.createLineBorder(Color.BLUE));
        u3 = new JMenuItem("Trasladar",new javax.swing.ImageIcon(getClass().getResource("flecha.png")));
        add(arc);
        arc.add(uno);
        uno.add(u3);
        u3.addActionListener(this);

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
    public void paintComponent(Graphics g) {
        super.paintComponent(g); 
        //Dibujar la figura original
        g.setColor(Color.decode("#1a9c00"));
        this.dibujar(g);
    }
    public void actionPerformed(ActionEvent e){
        if(e.getSource()==u3){
            int x,y;
            x=Integer.parseInt(JOptionPane.showInputDialog("Ingrese el valor de traslado en X"));
            y=Integer.parseInt(JOptionPane.showInputDialog("Ingrese el valor de traslado en Y"));
            this.traslacion(x,y);
            ventana.repaint();
        }
    }
    public void traslacion(int xf, int yf){
        for (Punto punto : figura) {
        //punto x:((x - xf) 
        //punto y: ((y - yf)
            punto.setX((int)(punto.getX() + xf));
            punto.setY((int)(punto.getY() + yf));
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
