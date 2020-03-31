package src.pack1;

import java.awt.event.ActionListener;
import java.awt.event.*;
import javax.swing.JButton;
import javax.swing.JFrame;

public class View {
    JFrame jf;
    JButton multiPlayer, singlePlayer;
    public View(int width, int height){
        jf = new JFrame();
        jf.setVisible(true);
        jf.setSize(width,height);
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jf.setLocationRelativeTo(null);
        jf.setLayout(null);
        jf.setTitle("Tic Tac Toe");
        jf.setResizable(false);
        createButton(width, height);
        jf.validate();
        jf.repaint();
        
    }
    private void createButton(int w, int h){
        //System.out.println(1/3*w);
        multiPlayer = new JButton("Multi Player");
        singlePlayer = new JButton("Single Player");
        multiPlayer.setBounds(w/6, h/4 ,150, 100);

        multiPlayer.addActionListener(new ActionListener(){

            public void actionPerformed(ActionEvent e){
                jf.dispose();
                jf = new MultiPlayerFrame(800, 600);
            }
        });

        singlePlayer.addActionListener(new ActionListener(){

            public void actionPerformed(ActionEvent e){
                jf.dispose();
                jf = new SinglePlayerFrame(800,600);
                
            }

        });
        singlePlayer.setBounds((3*w/6)+25, h/4 ,150, 100);
        jf.add(multiPlayer);
        jf.add(singlePlayer);
    }
    



}
