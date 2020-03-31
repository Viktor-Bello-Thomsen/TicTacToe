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

public class MultiPlayerFrame extends JFrame implements GameFrame{
    private JButton buttons[] = new JButton[9];
    private int state[] = new int[9];
    private int player = 1;
    private int totalMoves = 0;
    private boolean winner = false;
    
    public MultiPlayerFrame(int width, int height){
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
	public int[] returnState(){
        return state;
    }
    private void changePlayer(){
        if (player == 1) player = 2;
        else player = 1;
    }

    public void makeMove(int field){
        //Player 1 sets values to 1
        //Player 2 sets values to 2
        if(state[field] != 0){
            return;
        }

        else{
            state[field] = player;
            totalMoves += 1;
            changePlayer();
            checkWin();
        }
        
        if (winner) {
            //Create popupbox declaring winner
            JOptionPane.showMessageDialog(this, "The Winner was: " + getWinnerFormat());
            reset();
            repaint();
            validate();
        }
        else if (totalMoves >= 9) {
            //Create popupbox saying no one won
            JOptionPane.showMessageDialog(this, "There was no winner");
            reset();
            repaint();
            validate();
        }
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
    
    private String getWinnerFormat() {
        if (player == 1) return "X-Player";
        else return "O-Player";
    }

    private void checkWin() {
        if (state[0] != 0 && state[0] == state[1] && state[0] == state[2]) {
            winner = true;
            player = state[0];    
        }
        else if (state[3] != 0 && state[3] == state[4] && state[3] == state[5]) {
            winner = true;
            player = state[3];    
        }
        else if (state[6] != 0 && state[6] == state[7] && state[6] == state[8]) {
            winner = true;
            player = state[6];    
        }

        else if (state[0] != 0 && state[0] == state[3] && state[0] == state[6]) {
            winner = true;
            player = state[0];    
        }
        else if (state[1] != 0 && state[1] == state[4] && state[1] == state[7]) {
            winner = true;
            player = state[1];    
        }
        else if (state[2] != 0 && state[2] == state[5] && state[2] == state[8]) {
            winner = true;
            player = state[2];    
        }
        else if (state[0] != 0 && state[0] == state[4] && state[0] == state[8]) {
            winner = true;
            player = state[0];    
        }
        else if (state[2] != 0 && state[2] == state[4] && state[2] == state[6]) {
            winner = true;
            player = state[2];    
        }
    }
    public void reset(){
        for (int i = 0; i < state.length; i++) {
            state[i] = 0;
        }
        player = 1;
        winner = false;
        totalMoves = 0;
        repaint();
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