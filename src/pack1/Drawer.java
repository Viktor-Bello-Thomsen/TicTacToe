package src.pack1;
import javax.swing.JPanel;
import java.awt.*;
import java.util.HashMap;
import java.util.Map;

public class Drawer extends JPanel{
    
    int width, height;
    Map<Integer, int[]> coords;
    GameFrame gf;

    public Drawer(GameFrame gf){
        super();
        this.gf = gf;
    }
    
    public void createMap(int width, int height) {
        coords = new HashMap<Integer, int[]>();
        coords.put(0,new int[] {0, 0,width/3, height/3});
        coords.put(1,new int[] {width/3, 0,width/3, height/3});
        coords.put(2,new int[] {width*2/3, 0,width/3, height/3});
        
        coords.put(3,new int[] {0, height/3,width/3, height/3});
        coords.put(4,new int[] {width/3, height/3,width/3, height/3});
        coords.put(5,new int[] {width*2/3, height/3,width/3, height/3});
        
        coords.put(6,new int[] {0, height*2/3,width/3, height/3});
        coords.put(7,new int[] {width/3, height*2/3,width/3, height/3});
        coords.put(8,new int[] {width*2/3, height*2/3,width/3, height/3});
    }

    public void paintComponent(Graphics g) {
        int h = getHeight();
        int w = getWidth();
        createMap(w, h);
        gf.place(w,h);
        int[] state = gf.returnState();
        for (int i = 0; i < 9; i++) {
            int[] placement = coords.get(i);
            if (state[i] == 1){
                g.drawImage(ImageLoader.imgX, placement[0],placement[1],placement[2],placement[3], null);
            }
            else if (state[i] == 2){
                g.drawImage(ImageLoader.imgO, placement[0],placement[1],placement[2],placement[3], null);
            }
        }
        g.drawLine(0, h/3, w, h/3);
        g.drawLine(0, h *2/3, w, h*2/3);
        g.drawLine(w/3, h, w/3, 0);
        g.drawLine(w *2/3, h , w*2/3, 0);
    }
    
}