package Assignment3;

import Assignment3.ShapeFactory.ShapeComponent;
import Assignment3.ShapeFactory.ShapeFactory;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Shape;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JComponent;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 * Main Method for Assignment 3
 *
 * @author Jreemy Santorelli
 */
public class AppMain {

    protected static JComponent component;
    protected static ArrayList<Shape> shapes = new ArrayList<>();
    protected static String shapeName = "none"; //Sets the name of the active button
    protected static int horizontal = 30; //Sets Horizontal size 
    protected static int vertical = 30; //Sets Vertical size
    protected static ShapeFactory shapeFactory = ShapeFactory.getFactory();

    public static void main(String[] args) {
        final JFrame frame = new JFrame();

        //Frame Setup
        final int FRAME_WIDTH = 800;
        final int FRAME_HEIGHT = 800;

        frame.setSize(FRAME_WIDTH, FRAME_HEIGHT);
        frame.setTitle("Assignment 3");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());

        JPanel topPanel = new JPanel();
        JPanel rightPanel = new JPanel();

        frame.add(topPanel, BorderLayout.NORTH);
        frame.add(rightPanel, BorderLayout.SOUTH);

        rightPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));

        //shows which shape button is selected
        JLabel btnSelected = new JLabel("Please Select a shape to draw that shape");

        //Button Names
        List<String> buttonNames = new ArrayList<>();
        buttonNames.add("Rectangle");
        buttonNames.add("Circle");
        buttonNames.add("Triangle");

        //Non-Shape Buttons
        buttonNames.add("Set Size");
        buttonNames.add("Clear Shapes");

        //Size Text Fields
        JTextField hField = new JTextField(horizontal + "");
        JTextField vField = new JTextField(vertical + "");

        hField.setPreferredSize(new Dimension(60, 24));
        vField.setPreferredSize(new Dimension(60, 24));

        rightPanel.add(hField);
        rightPanel.add(vField);

        //Action Listener for all buttons
        class ButtonListener implements ActionListener {

            @Override
            public void actionPerformed(ActionEvent event) {

                String buttonPressed = event.getActionCommand();
                if (buttonPressed.equalsIgnoreCase("CLEAR SHAPES")) {
                    //Reset the Drawing Area
                    shapes.removeAll(shapes);
                    component.repaint();
                } else if (buttonPressed.equalsIgnoreCase("SET SIZE")) {
                    //Will need some validation here but for now we will do
                    //Set the new size of shapes from text fields
                    horizontal = Integer.parseInt(hField.getText());
                    vertical = Integer.parseInt(vField.getText());
                } else {
                    shapeName = buttonPressed;
                    btnSelected.setText(shapeName + " Selected");
                }

            }
        }
        ActionListener btnListener = new ButtonListener();

        //Responds to clicks on the frame
        MousePressListener mListener = new MousePressListener();
        frame.addMouseListener(mListener);

        //Shape Buttons
        buttonNames.forEach((name) -> {
            JButton temp = new JButton(name);
            temp.setActionCommand(name);
            if (name.contains(" ")) {
                rightPanel.add(temp);
            } else {
                topPanel.add(temp);
            }
            temp.addActionListener(btnListener);
            if (!name.equals("Get Size")) {

            }
        });

        topPanel.add(btnSelected);

        //Add Draw Area
        component = new ShapeComponent(shapes);
        frame.add(component);

        frame.setVisible(true);
    }

    public static void setShape(Shape shapes) {
        AppMain.shapes.add(shapes);
    }

}
