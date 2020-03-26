package src.pack1;
public class ButtonPlacer {
    
    public static void place(int  width, int height){
        View.buttons[0].setBounds(0, 0,width/3, height/3);
        View.buttons[1].setBounds(width/3, 0,width/3, height/3);
        View.buttons[2].setBounds(width*2/3, 0,width/3, height/3);

        View.buttons[3].setBounds(0, height/3,width/3, height/3);
        View.buttons[4].setBounds(width/3, height/3,width/3, height/3);
        View.buttons[5].setBounds(width*2/3, height/3,width/3, height/3);
        
        View.buttons[6].setBounds(0, height*2/3,width/3, height/3);
        View.buttons[7].setBounds(width/3, height*2/3,width/3, height/3);
        View.buttons[8].setBounds(width*2/3, height*2/3,width/3, height/3);
    }

}
