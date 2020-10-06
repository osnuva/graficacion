package animacion;

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
    private JFrame ventana;
    private Container contenedor;
    //arreglo de circulos
    private Animacion circulos[];
    public Ventana(){
     ventana = new JFrame("Animando objeto");
        // Definir tamaño de ventana
        ventana.setSize(800, 600);
        ventana.setVisible(true);
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.setResizable(false);
        ventana.setBackground(Color.black);
        //creamos contenedor
        contenedor = ventana.getContentPane();
        contenedor.setSize(800, 600);
        contenedor.setBackground(Color.red);
        //Agregar la ventana en el contenedor
        contenedor.add(this, BorderLayout.CENTER);
        //definir el arreglo de circulos
        int tamanio=20;
        this.circulos=new Animacion[tamanio];
        //llenar el arreglo
        /*for(Animacion circulo : circulos){
            circulo=new Animacion(800,600,25,10);
        }*/
        for (int i = 0; i < tamanio; i++) {
            this.circulos[i]=new Animacion(800,600,25,10);
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g); 
        for(Animacion circulo : circulos){
            circulo.dibujar(g);
        }
    }
    public void animar(){
        while(this.ventana.isVisible()){
            for (Animacion circulo : circulos) {
                circulo.animar();
            }
            try{
                Thread.sleep(30);
            }catch(Exception e){
                
            }
            repaint();
        }
    }
}
