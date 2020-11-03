package barra;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
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
        arc = new JMenuBar();
        uno = new JMenu("Acciones");
        uno.setBorder(BorderFactory.createLineBorder(Color.BLUE));
        u1 = new JMenuItem("Rotar derecha",new javax.swing.ImageIcon(getClass().getResource("derecha.png")));
        u2 = new JMenuItem("Rotar Izquierda",new javax.swing.ImageIcon(getClass().getResource("izquierda.png")));
        u3 = new JMenuItem("Trasladar",new javax.swing.ImageIcon(getClass().getResource("flecha.png")));
        add(arc);
        arc.add(uno);
        uno.add(u1);
        uno.add(u2);
        uno.add(u3);
        u1.addActionListener(this);
        u2.addActionListener(this);
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
        g.setColor(Color.red);
        this.dibujar(g);
       /* switch(op){
            case 1:
                this.Rotacion(10);
                this.dibujar(g);
                break;
            case 2:
                this.rotacionneg(10);
                this.dibujar(g);
                break;
            case 3:
                this.traslacion(50,50);
                this.dibujar(g);
                break;
        }*/        
        
    }
    public void actionPerformed(ActionEvent e){
        if(e.getSource() == u1){
            this.Rotacion(10);
            System.out.println("evento 1");
            
        }
        if(e.getSource()==u2){
            this.rotacionneg(10);
            System.out.println("evento 2");
        }
        if(e.getSource()==u3){
            this.traslacion(50, 50);
            System.out.println("evento 3");
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
    public void rotacionneg(double angulo){
        int tx=figura[0].getX(),ty=figura[0].getY();
        for (Punto punto : figura) {
        //punto x:((a-tx)cos + (b-ty)(sen)) +tx
        //punto y: (-(a-tx)(sen) + (b-ty)(cos))+ty
            punto.setX((int)((punto.getX() - tx)*Math.cos(Math.toRadians(angulo))+(punto.getY()-ty)*Math.sin(Math.toRadians(angulo))+tx));
            //punto y
            punto.setY((int)(-(punto.getX() - ty)*Math.sin(Math.toRadians(angulo))+(punto.getY()-ty)*Math.cos(Math.toRadians(angulo))+ty));
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
