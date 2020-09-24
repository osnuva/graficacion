package figura;
/**
 *
 * @author brandon osmar
 */
import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Graphics;
import javax.swing.JFrame;
import javax.swing.JPanel;
public class Dibujo extends JPanel {

    //ventana
    private JFrame ventana;
    //contenedor
    private Container contenedor;

    private final int Figura[] = {
0X000FE000,
0X001FF000,
0X003FF800,
0X007FFC00,
0X00FF8FC0,
0X01FF8FE0,
0X01FF8FE0,
0X01FFFFF8,
0X01FFFFF0,
0X01FFFFE0,
0X01FFFFC0,
0X01FFFF80,
0X01FFFF00,
0X01FFF800,
0X01FFF000,
0X01FFF000

    };
    //mascara
    private final int Mascara = 0x8000000;
    //ancho de bites
    private final int Ancho_bits = 32;
    //coordenadas 
    private int coordenada_x,coordenada_y;
    //declarando hilo de ejecucion
    private Thread hilo;
    

    public Dibujo() {
        //inicializar ventana
        ventana = new JFrame("Dibujando icono");
        // Definir tamaño de ventana
        ventana.setSize(510, 510);
        ventana.setVisible(true);
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.setResizable(false);
        //creamos contenedor
        contenedor = ventana.getContentPane();
        contenedor.setSize(510, 510);
        //Agregar la ventana en el contenedor
        contenedor.add(this, BorderLayout.CENTER);
        //definir el hilo
        this.hilo = new Thread();
    }

    @Override
    protected void paintComponent(Graphics graphics) {
        super.paintComponent(graphics);
       
        System.out.println("Coordenada en x"+coordenada_x);
        System.out.println("Coordenada en y"+coordenada_y);
        //iterador de la figura
        for (int i = 0; i < this.Figura.length; i++) {
            //iterador para el ancho en bits de la figura 
            for (int j = 0; j < this.Ancho_bits; j++) {
                int temp=this.Figura[i] & (this.Mascara >> j);
                if((temp!=0)){
                    graphics.drawLine(
                            this.coordenada_x+j,
                            this.coordenada_y+i,
                            this.coordenada_x+j, 
                            this.coordenada_y+i
                    );
                }
            }
        }
    }
    public void dibujar(){
        int a=0,j=0;
       this.coordenada_x=(int)(Math.random()*500);
       this.coordenada_y=(int)(Math.random()*500);
       int eje=1;//(int)(Math.random()*2);
        System.out.println("Direccion"+eje);
       int dir=(int)(Math.random()*2);
        System.out.println("Direccion"+dir);
        if(dir==0){
           a=-10;
        }else
            a=-10;
        for (int i = 0; i < 10; i++) {
            System.out.println("Interacion: "+j);
            j++;
            try {
                if(coordenada_x>10 && coordenada_y>10&&coordenada_x<450 && coordenada_y<450){
                if(eje==0){
                this.coordenada_x=this.coordenada_x+a;
                }else{
                 this.coordenada_y=this.coordenada_y+a;   
                }
                this.hilo.sleep(1000);//medio segundo
                paint(getGraphics());
                }else{
                    this.coordenada_x=(int)(Math.random()*500);
                    this.coordenada_y=(int)(Math.random()*500);
                    System.out.println("Choque, reubicando");
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }
}