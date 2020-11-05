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
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;


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
    public JMenu uno, dos;
    public JMenuItem u1,u3;
    public JButton b;
    public JLabel t;

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
        dos = new JMenu("Accion 2");
        uno.setBorder(BorderFactory.createLineBorder(Color.BLUE));
        dos.setBorder(BorderFactory.createLineBorder(Color.yellow));
        u3 = new JMenuItem("Trasladar",new javax.swing.ImageIcon(getClass().getResource("flecha.png")));
        u1 = new JMenuItem("Rotacion");
        add(arc);
        arc.add(uno);
        arc.add(dos);
        uno.add(u3);
        dos.add(u1);
        u3.addActionListener(this);
        u1.addActionListener(this);
        b = new JButton("salir");
        b.setBounds(100, 150, 100, 30);
        b.addActionListener(this);
        add(b);
        t=new JLabel("salir");
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
        if(e.getSource()==u1){
            double angulo;
            angulo=Double.parseDouble(JOptionPane.showInputDialog("Ingrese el valor del angulo"));
            this.Rotacion(angulo);
            repaint();
        }
        if(e.getSource()==b){
            System.out.println("hola");
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
    public void Rotacion (double angulo){
        int tx=figura[0].getX(),ty=figura[0].getY();
        for (Punto punto : figura) {
        //punto x:(x - tx) * cos – (b – ty) * sin + tx
        //punto y: (x - ty) * sin + (b – ty) * cos + ty
            punto.setX((int)((punto.getX() - tx)*Math.cos(Math.toRadians(angulo))-(punto.getY()-ty)*Math.sin(Math.toRadians(angulo))+tx));
            //punto y
            punto.setY((int)((punto.getX() - ty)*Math.sin(Math.toRadians(angulo))+(punto.getY()-ty)*Math.cos(Math.toRadians(angulo))+ty));
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
