package src.pack1;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ActionHandler implements ActionListener {

    int state;
    public ActionHandler(int i){
        state = i;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        View.makeMove(state);
    }

}
