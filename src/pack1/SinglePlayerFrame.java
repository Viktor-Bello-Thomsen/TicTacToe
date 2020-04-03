package src.pack1;

import java.awt.Dimension;
import java.awt.event.*;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class SinglePlayerFrame extends JFrame implements GameFrame{
    private JButton buttons[] = new JButton[9];
    private int state[] = new int[9];
    private int player = 1;
    private int totalMoves = 0;
    private boolean winner = false;
    private int aIMode = 1;
    
    public SinglePlayerFrame(int width, int height){
        super();
        setJMenuBar(CreateMenuBar());
        CreateButtons();
        setVisible(true);
        setSize(width,height);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setTitle("Tic Tac Toe");
        setResizable(true);
        add(new Drawer(this));
        setMinimumSize(new Dimension(200, 200));
        validate();
        repaint();
    }

    public void makeMove(int i){
        if (state[i] != 0) return;
        else{
            state[i] = 1;
            moveAI();
        }



    };
    
    private void moveAI() {
        if(aIMode == 1){
            
        }

    }

    private void CreateButtons() {
        for (int i = 0; i < buttons.length; i++) {
            buttons[i] = new JButton("");
            buttons[i].setVisible(true);
            buttons[i].addActionListener(new ActionHandler(i, this));
            buttons[i].setFocusPainted(false);
            buttons[i].setContentAreaFilled(false);
            buttons[i].setBorder(null);
            add(buttons[i]);
        }
        place(getWidth(), getHeight());
    }

    public int[] returnState(){
        return state;
    }
    
    public void place(int  width, int height){
        buttons[0].setBounds(0, 0,width/3, height/3);
        buttons[1].setBounds(width/3, 0,width/3, height/3);
        buttons[2].setBounds(width*2/3, 0,width/3, height/3);

        buttons[3].setBounds(0, height/3,width/3, height/3);
        buttons[4].setBounds(width/3, height/3,width/3, height/3);
        buttons[5].setBounds(width*2/3, height/3,width/3, height/3);
        
        buttons[6].setBounds(0, height*2/3,width/3, height/3);
        buttons[7].setBounds(width/3, height*2/3,width/3, height/3);
        buttons[8].setBounds(width*2/3, height*2/3,width/3, height/3);
    }
    private JMenuBar CreateMenuBar(){
        JMenuBar mb = new JMenuBar();
        return mb;
    }
}
