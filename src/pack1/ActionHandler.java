package src.pack1;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class ActionHandler implements ActionListener {

    int state;
    GameFrame gf;
    public ActionHandler(int i, GameFrame gf){
        state = i;
        this.gf = gf;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        gf.makeMove(state);
    }

}
