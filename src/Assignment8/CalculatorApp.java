package Assignment8;

import java.awt.Font;

/**
 *
 * @author Jeremy Santorelli
 */
public class CalculatorApp {

    public static void main(String... args) {
        Font font = new Font("Serif", Font.BOLD, 25);//Custom font

        FrameBuilder f = new FrameBuilderCalculator();

        f.setPanels("Assignment 8 Calculator", font);
        f.setGridConstraints(7, 7, 7, 7);
        f.initButtons();
        f.setButtonOrientation();
        f.display(400, 600);
    }

}
