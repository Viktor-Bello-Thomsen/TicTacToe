package src.pack1;

import java.awt.Dimension;
import java.awt.event.*;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

/**
 * Takes Care of creating the view and acts as model.
 */

public class View{
    static JFrame jf;
    static JButton buttons[] = new JButton[9];
    static int state[] = new int[9];
    static int player = 1;
    static int totalMoves = 0;
    static boolean winner = false;
    Drawer draw;
    static JButton reset_game;
    
    public View(int width, int height){
        jf = new JFrame();
        jf.setJMenuBar(CreateMenuBar());
        CreateButtons();
        jf.setVisible(true);
        jf.setSize(width,height);
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jf.setLocationRelativeTo(null);
        jf.setTitle("Tic Tac Toe");
        jf.setResizable(true);
        jf.add(new Drawer());
        jf.setMinimumSize(new Dimension(200, 200));
        jf.validate();
        jf.repaint();
    }

    private static void changePlayer(){
        if (player == 1) player = 2;
        else player = 1;
    }



    public static void makeMove(int field){
        System.out.println(totalMoves);
        
        //Player 1 sets values to 1
        //Player 2 sets values to 2
        if (state[field] == 0) {
            state[field] = player;
            totalMoves += 1;
            changePlayer();
            checkWin();
        }
        
        if (winner) {
            //Create popupbox declaring winner
            JOptionPane.showMessageDialog(jf, "The Winner was: " + getWinnerFormat());
            reset();
            jf.repaint();
            jf.validate();
        }
        else if (totalMoves >= 9) {
            //Create popupbox saying no one won
            JOptionPane.showMessageDialog(jf, "There was no winner");
            reset();
            jf.repaint();
            jf.validate();
        }
    }
    
    private static String getWinnerFormat() {
        if (player == 1) return "X-Player";
        else return "O-Player";
    }

    private static void checkWin() {
        if (state[0] != 0 && state[0] == state[1] && state[0] == state[2]) {
            winner = true;
            player = state[0];    
        }
        else if (state[3] != 0 && state[3] == state[4] && state[3] == state[5]) {
            winner = true;
            player = state[0];    
        }
        else if (state[6] != 0 && state[6] == state[7] && state[6] == state[8]) {
            winner = true;
            player = state[0];    
        }

        else if (state[0] != 0 && state[0] == state[3] && state[0] == state[6]) {
            winner = true;
            player = state[0];    
        }
        else if (state[1] != 0 && state[1] == state[4] && state[1] == state[7]) {
            winner = true;
            player = state[0];    
        }
        else if (state[2] != 0 && state[2] == state[5] && state[2] == state[8]) {
            winner = true;
            player = state[0];    
        }
        else if (state[0] != 0 && state[0] == state[4] && state[0] == state[8]) {
            winner = true;
            player = state[0];    
        }
        else if (state[2] != 0 && state[2] == state[4] && state[2] == state[6]) {
            winner = true;
            player = state[0];    
        }
    }
    static void reset(){
        for (int i = 0; i < View.state.length; i++) {
            View.state[i] = 0;
        }
        View.player = 1;
        View.winner = false;
        View.totalMoves = 0;
        View.jf.repaint();
    }

    private void CreateButtons() {
        for (int i = 0; i < buttons.length; i++) {
            buttons[i] = new JButton("");
            buttons[i].setVisible(true);
            buttons[i].addActionListener(new ActionHandler(i));
            buttons[i].setFocusPainted(false);
            buttons[i].setContentAreaFilled(false);
            buttons[i].setBorder(null);
            jf.add(buttons[i]);
        }
        ButtonPlacer.place(jf.getContentPane().getWidth(), jf.getContentPane().getHeight());

    }
    private JMenuBar CreateMenuBar(){
        JMenuBar mb = new JMenuBar();
        JMenuItem resetButton = new JMenuItem("Reset Game");
        resetButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                reset();
            }
        });
        mb.add(resetButton);
        return mb;
    }
    
}