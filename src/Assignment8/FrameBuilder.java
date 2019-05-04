package Assignment8;

import java.awt.Font;

/**
 *
 * @author Jeremy Santorelli
 */
public interface FrameBuilder {

    //step 1
    void setPanels(String frameName, Font f);

    //step 2
    void setGridConstraints(int w, int x, int y, int z);
    
    //step 3
    void initButtons();

    //step 4
    void setButtonOrientation();

    //step 5
    void display(int xSize, int ySize);

}
