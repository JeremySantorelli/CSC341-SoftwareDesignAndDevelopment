package Week3Demo_Factory;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.geom.*;
import java.util.*;

/**
 * @author chu
 *
 */
public class GraphicsApp {

    public static void main(String[] args) {
        JFrame gui = new AppFrame("Demo");
    }
}

class AppFrame extends JFrame {

    public AppFrame(String name) {
        super(name);
    }

    @Override
    public void frameInit() { //called by JFrame constructor		
        super.frameInit();
        this.setLayout(new GridLayout(1, 2));

        JPanel pnlOp = new JPanel();

        JPanel pnlGraphics = new ColorPanel(pnlOp);
        pnlGraphics.setBorder(BorderFactory.createTitledBorder("Graphics Pane"));
        this.add(pnlGraphics);

        this.setSize(450, 300);
        this.setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}

class ColorPanel extends JPanel {

    JButton btnChangeColor;
    DrawingPanel pnlDrawing;

    public ColorPanel(JPanel pnlOP) {
        super();
        setup(pnlOP);
    }

    private void setup(JPanel pnlOP) {
        this.setLayout(new BorderLayout());
        btnChangeColor = new JButton("Change Color");
        btnChangeColor.addActionListener(new ButtonListener());

        pnlDrawing = new DrawingPanel(pnlOP);
        add(pnlDrawing, BorderLayout.CENTER);
        add(btnChangeColor, BorderLayout.SOUTH);
    }

    class ButtonListener implements ActionListener {	//inner class

        /* (non-Javadoc)
		 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
         */
        @Override
        public void actionPerformed(ActionEvent arg0) {
            pnlDrawing.repaint();
        }
    }
}

class DrawingPanel extends JPanel {

    private JPanel display;

    /**
     * @param displayObj pre:
     *
     * post:
     */
    public DrawingPanel(JPanel displayObj) {
        this.addMouseListener(new MsListener());
        this.display = displayObj;
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g.create();
        int green = (int) (Math.random() * 255);
        g2.setColor(new Color(200, green, 100));
        Ellipse2D.Double el = new Ellipse2D.Double(50, 50, 100, 100);
        g2.fill(el);
        //g.fillOval(50, 50, 100, 100);
    }

    class MsListener extends MouseAdapter {

        public void mouseClicked(MouseEvent e) {
            //c.setP(e.getPoint());
            //display.add(e.getPoint().toString());
            getGraphics().drawRect(e.getX(), e.getY(), 30, 30); //doesn't cause repaint of the panel
        }
    }
}

class OpPanel extends JPanel implements IDisplay {

    JTextField txtOperant1 = new JTextField(5);
    JTextField txtOperant2 = new JTextField(5);
    JTextArea txtOutput = new JTextArea(5, 10);
    JScrollPane scroll;
    JButton btnAdd = new JButton("Add");
    JButton btnMul = new JButton("Multiply");
    JPanel pnlOperants = new JPanel();
    JPanel pnlDisplay = new JPanel();
    JPanel pnlButtons = new JPanel();

    public OpPanel() {
        super();
        setup();
    }

    private void setup() {
        pnlOperants.add(txtOperant1);
        pnlOperants.add(txtOperant2);
        scroll = new JScrollPane(txtOutput);
        scroll.setPreferredSize(new Dimension(200, 150));
        pnlDisplay.add(scroll);
        pnlButtons.add(btnAdd);
        pnlButtons.add(btnMul);
        this.setLayout(new BorderLayout());
        this.add(pnlOperants, BorderLayout.NORTH);
        this.add(pnlDisplay, BorderLayout.CENTER);
        this.add(pnlButtons, BorderLayout.SOUTH);
        btnAdd.addActionListener(new ActionListener() {  //Anonymous class 
            @Override
            public void actionPerformed(ActionEvent arg0) {
                txtOutput.setText("" + (Double.parseDouble(txtOperant1.getText()) + Double.parseDouble(txtOperant2.getText())));
            }
        });
        btnMul.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                txtOutput.setText("" + (Double.parseDouble(txtOperant1.getText()) * Double.parseDouble(txtOperant2.getText())));
            }
        });

        txtOutput.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                txtOutput.append("\n Mouse location: \n" + "(" + e.getX() + "," + e.getY() + ")");
            }
        });
    }

    @Override
    public void displayText(String text) {
        txtOutput.append("\n Mouse location: \n" + "(" + text + ")");
    }
}

interface IDisplay {

    void displayText(String text);
}
