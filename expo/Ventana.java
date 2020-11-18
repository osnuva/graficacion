package expo;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;


/**
 *
 * @author brandon osmar
 */
public class Ventana extends JPanel implements ActionListener , KeyListener, MouseListener, MouseWheelListener{
    // ventana
    int op;
    
    private JFrame ventana;
    // contenedor
    private Container contenedor;
    //declarar la figura
    private Punto figura[],p[];
    public JMenuBar arc;
    public JMenu uno;
    public JMenuItem u,u1,u2,u3,u4,u5,u6,u7,u8;
    public JButton b,b1,b2,b3,b4,b5,b6,b7,b8;

    /**
     * Crear una ventana para representar la figura
     * @param titulo Titulo de la ventana
     * @param figura Figura representada por puntos
     */
    public Ventana(String titulo,Punto figura[]) {
        // inicializar la ventana
        ventana = new JFrame(titulo);
        // definir tamaño a ventana
        ventana.setSize(1000, 600);
        setLayout(new FlowLayout(FlowLayout.LEFT, 2, 0));
        arc = new JMenuBar();
        uno = new JMenu("Acciones");
        u = new JMenuItem("Escalar");
        u1 = new JMenuItem("Trasladar");
        u2 = new JMenuItem("Rotacion");
        u3 = new JMenuItem("Rotacion negativa");
        u4 = new JMenuItem("Reflexion en x");
        u5 = new JMenuItem("Reflexion en y");
        u6 = new JMenuItem("Reflexion en xy");
        u7 = new JMenuItem("Deformacion");
        u8 = new JMenuItem("Repintar");
        add(arc);
        arc.add(uno);
        uno.add(u);
        uno.add(u1);
        uno.add(u2);
        uno.add(u3);
        uno.add(u4);
        uno.add(u5);
        uno.add(u6);
        uno.add(u7);
        uno.add(u8);
        u.addActionListener(this);
        u1.addActionListener(this);
        u2.addActionListener(this);
        u3.addActionListener(this);
        u4.addActionListener(this);
        u5.addActionListener(this);
        u6.addActionListener(this);
        u7.addActionListener(this);
        u8.addActionListener(this);
        b= new JButton(new javax.swing.ImageIcon(getClass().getResource("escalas.png")));
        b1= new JButton(new javax.swing.ImageIcon(getClass().getResource("flecha.png")));
        b2= new JButton(new javax.swing.ImageIcon(getClass().getResource("derecha.png")));
        b3= new JButton(new javax.swing.ImageIcon(getClass().getResource("izquierda.png")));
        b4= new JButton(new javax.swing.ImageIcon(getClass().getResource("x.jpg")));
        b5= new JButton(new javax.swing.ImageIcon(getClass().getResource("y.jpg")));
        b6= new JButton(new javax.swing.ImageIcon(getClass().getResource("z.jpg")));
        b7= new JButton(new javax.swing.ImageIcon(getClass().getResource("d.jpg")));
        b8= new JButton(new javax.swing.ImageIcon(getClass().getResource("3128.png")));
        arc.add(b);
        arc.add(b1);
        arc.add(b2);
        arc.add(b3);
        arc.add(b4);
        arc.add(b5);
        arc.add(b6);
        arc.add(b7);
        arc.add(b8);
        b.addActionListener(this);
        b1.addActionListener(this);
        b2.addActionListener(this);
        b3.addActionListener(this);
        b4.addActionListener(this);
        b5.addActionListener(this);
        b6.addActionListener(this);
        b7.addActionListener(this);
        b8.addActionListener(this);
        ventana.setVisible(true);
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.setResizable(false);
        ventana.setFocusable(true);
        ventana.addKeyListener(this);
        ventana.setLocationRelativeTo(null);
        
        contenedor = ventana.getContentPane();
        contenedor.setSize(1000, 600);
        // agregar la ventana en el contenedor
        contenedor.add(this, BorderLayout.CENTER);
        this.figura=figura;
        p=figura;
        addMouseListener(this);
        addMouseWheelListener(this);
    }
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g); 
        //Dibujar la figura original
        g.setColor(Color.decode("#1a9c00"));
        this.dibujar(g);
    }
    public void actionPerformed(ActionEvent e){
        if(e.getSource()==u){
            Double x,y;
            x=Double.parseDouble(JOptionPane.showInputDialog("Ingrese el valor de traslado en X"));
            y=Double.parseDouble(JOptionPane.showInputDialog("Ingrese el valor de traslado en Y"));
            this.escalar(x,y);
            repaint();
        }
        if(e.getSource()==u1){
            int x,y;
            x=Integer.parseInt(JOptionPane.showInputDialog("Ingrese el valor de traslado en X"));
            y=Integer.parseInt(JOptionPane.showInputDialog("Ingrese el valor de traslado en Y"));
            this.traslacion(x,y);
            ventana.repaint();
        }
        if(e.getSource()==u2){
            double angulo;
            angulo=Double.parseDouble(JOptionPane.showInputDialog("Ingrese el valor del angulo"));
            this.Rotacion(angulo);
            repaint();
        }
        if(e.getSource()==u3){
            double angulo;
            angulo=Double.parseDouble(JOptionPane.showInputDialog("Ingrese el valor del angulo"));
            this.rotacionneg(angulo);
            repaint();
        }
        if(e.getSource()==u4){
            this.reflexionx();
            repaint();
        }
        if(e.getSource()==u5){
            this.reflexiony();
            repaint();
        }
        if(e.getSource()==u6){
            this.reflexionxy();
            repaint();
        }
        if(e.getSource()==u7){
            double x,y;
            x=Double.parseDouble(JOptionPane.showInputDialog("Ingrese el valor de deformacion en X"));
            y=Double.parseDouble(JOptionPane.showInputDialog("Ingrese el valor de deformacion en Y"));
            this.deformacion(x,y);
            ventana.repaint();
        }
        if(e.getSource()==u8){
            this.redibujar();
            repaint();
        }
        if(e.getSource()==b){
            this.escalar(.8,.8);
            ventana.repaint();
        }
        if(e.getSource()==b1){
            this.traslacion(15,15);
            ventana.repaint();
        }
        if(e.getSource()==b2){
            this.Rotacion(10);
            repaint();
        }
        if(e.getSource()==b3){
            this.rotacionneg(10);
            repaint();
        }
        if(e.getSource()==b4){
            this.reflexionx();
            repaint();
        }
        if(e.getSource()==b5){
            this.reflexiony();
            repaint();
        }
        if(e.getSource()==b6){
            this.reflexionxy();
            repaint();
        }
        if(e.getSource()==b7){
            this.deformacion(.5,.5);
            ventana.repaint();
        }
        if(e.getSource()==b8){
            this.redibujar();
            repaint();
        }
    }
  public void escalar(double fx, double fy){
        int tx=figura[0].getX(),ty=figura[0].getY();
        for (Punto punto : figura) {
        //punto x:((x – tx) * fx) + tx
        //punto y:((y – ty) * fy) + ty
            punto.setX((int)(((punto.getX() - tx)* fx) + tx));
            punto.setY((int)(((punto.getY() - ty)* fy) + ty));
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
    public void reflexionx(){
        int tx=figura[0].getX(),ty=figura[0].getY();
        for(Punto punto :figura){
            //punto x:-(a – tx) + tx
            //punto y: (b – ty) + ty
            punto.setX((int) -(punto.getX()-tx)+tx);
            punto.setY((int) (punto.getY()-ty)+ty);
        }
    }public void reflexiony(){
        int tx=figura[0].getX(),ty=figura[0].getY();
        for(Punto punto :figura){
            //punto x:-(a – tx) + tx
            //punto y: (b – ty) + ty
            punto.setX((int) (punto.getX()-tx)+tx);
            punto.setY((int) -(punto.getY()-ty)+ty);
        }
    }
    public void reflexionxy(){
        int tx=figura[0].getX(),ty=figura[0].getY();
        for(Punto punto :figura){
            //punto x:-(a – tx) + tx
            //punto y: (b – ty) + ty
            punto.setX((int) -(punto.getX()-tx)+tx);
            punto.setY((int) -(punto.getY()-ty)+ty);
        }
    }
    public void deformacion(double dx, double dy){
        int tx=figura[0].getX(),ty=figura[0].getY();
        for (Punto punto : figura) {
        //punto x:((x - tx) + (b - ty) * dx) + tx
        //punto y: ((y - ty) * dy + (b – ty )) + ty
            punto.setX((int)(((punto.getX() - tx)+ (punto.getY()-ty)*dx + tx)));
            punto.setY((int)(((punto.getY() - ty)* dy + (punto.getY()-ty) + ty)));
        }
    }
    public void setFigura(Punto figura[]){
        this.figura=figura;
    }
    public void redibujar(){
        Punto fig[] = {
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
        setFigura(fig);
        repaint();
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

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_E){
            this.escalar(.9,.9 );
            repaint();
        }
        if (e.getKeyCode() == KeyEvent.VK_T){
            this.traslacion(10, 1);
            repaint();
        }
        if (e.getKeyCode() == KeyEvent.VK_R){
            this.Rotacion(5.0);
            repaint();
        }
        if (e.getKeyCode() == KeyEvent.VK_Q){
            this.rotacionneg(5.0);
            repaint();
        }
        if (e.getKeyCode() == KeyEvent.VK_X){
            this.reflexionx();
            repaint();
        }
        if (e.getKeyCode() == KeyEvent.VK_Y){
            this.reflexiony();
            repaint();
        }
        if (e.getKeyCode() == KeyEvent.VK_Z){
            this.reflexionxy();
            repaint();
        }
        if (e.getKeyCode() == KeyEvent.VK_D){
            this.deformacion(.1, .1);
            repaint();
        }
        if(e.getKeyCode()==KeyEvent.VK_I){
            this.redibujar();
            repaint();
        }

    }

    @Override
    public void keyReleased(KeyEvent e) {
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        
        
    }

    @Override
    public void mousePressed(MouseEvent e) {
        if(e.getButton()==1){
            this.traslacion(10,10);
            ventana.repaint();
        }
    }

    @Override
    public void mouseReleased(MouseEvent e) {
      if(e.getButton()==3){
            this.traslacion(-5,-5);
            repaint();
        }
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }

    @Override
    public void mouseWheelMoved(MouseWheelEvent e) {
        double scroll = .1;
        scroll = (e.getWheelRotation() > 0) ? 1 + scroll : 1 - scroll;
        this.escalar( scroll, scroll);
        repaint();
    }
}

