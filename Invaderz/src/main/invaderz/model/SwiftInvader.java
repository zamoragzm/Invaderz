package invaderz.model;

import java.awt.*;

public class SwiftInvader extends Invader {


    private static final int JIGGLE_X = 3;
    public static final int DY = 3;
    public static final Color COLOR = new Color(53, 188, 17);




    public SwiftInvader(int x, int y){
        super(x,y);
    }

    @Override
    public void move(){
        super.x = super.x + SIGame.RND.nextInt(2 * (JIGGLE_X) + 1) - (JIGGLE_X);
        super.y = super.y + (DY);
        super.handleBoundary();
    }

}
