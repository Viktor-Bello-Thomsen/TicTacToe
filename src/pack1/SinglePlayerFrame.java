package src.pack1;

import java.awt.Dimension;
import java.awt.event.*;
import java.util.concurrent.ThreadLocalRandom;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

public class SinglePlayerFrame extends JFrame implements GameFrame{
    private JButton buttons[] = new JButton[9];
    private int state[] = new int[9];
    private int totalMoves = 0;
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
            if (checkWin() != 0) {
                //Create popupbox declaring winner
                JOptionPane.showMessageDialog(this, "The Winner was: " + getWinnerFormat(checkWin()));
                reset();
                repaint();
                validate();
                return;
            }
            else if (totalMoves >= 9) {
                //Create popupbox saying no one won
                JOptionPane.showMessageDialog(this, "There was no winner");
                reset();
                repaint();
                validate();
                return;
            }
            moveAI();
            if (checkWin() != 0) {
                //Create popupbox declaring winner
                JOptionPane.showMessageDialog(this, "The Winner was: " + getWinnerFormat(checkWin()));
                //reset();
                repaint();
                validate();
            }

        }
    };
    
    private void reset() {
        state = new int[9];
        totalMoves = 0;
        repaint();
        validate();
    }

    private String getWinnerFormat(int winner) {
        if (winner == 1) return "YOU";
        else return "..  well.... not you";
    }
    //return 0 if no winner, 1 for player1 or 2 for player2
    private int checkWin() {
        if (state[0] != 0 && state[0] == state[1] && state[0] == state[2]) {
            return state[0];    
        }
        else if (state[3] != 0 && state[3] == state[4] && state[3] == state[5]) {
            return state[3];     
        }
        else if (state[6] != 0 && state[6] == state[7] && state[6] == state[8]) {
            return state[6];    
        }

        else if (state[0] != 0 && state[0] == state[3] && state[0] == state[6]) {
            return state[0];    
        }
        else if (state[1] != 0 && state[1] == state[4] && state[1] == state[7]) {
            return state[1];     
        }
        else if (state[2] != 0 && state[2] == state[5] && state[2] == state[8]) {
            return state[2];    
        }
        else if (state[0] != 0 && state[0] == state[4] && state[0] == state[8]) {
            return state[0];     
        }
        else if (state[2] != 0 && state[2] == state[4] && state[2] == state[6]) {
            return state[2];     
        }
        totalMoves += 1;
        return 0;
    }

    private void moveAI() {
        if(aIMode == 1){
            boolean searching = true;
            while(searching){
                int num = ThreadLocalRandom.current().nextInt(0, 9);
                if (state[num] == 0){
                    state[num] = 2;
                    searching = false;
                }
            }
            repaint();
            validate(); 
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
