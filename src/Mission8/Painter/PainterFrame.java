package Mission8.Painter;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.image.BufferedImage;

public class PainterFrame extends Frame {

    private BufferedImage img;
    public static Graphics g;
    // public static Graphics2D g2D;

    static String checkboxChecker = "Pen";

    int x;
    int y;
    int x2;
    int y2;

    PainterFrame(String title) {
        super(title);
        init();
    }

    public void paint(Graphics g) {
        g.drawImage(img, 0, 0, this); // g2D 로 하면 자꾸 null pointer exception 뜬다 왜죠
    }

    private void init() {
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
        setLayout(new FlowLayout());
        setSize(800, 600);
        setBackground(Color.white);

        toolButtons();
        mouseAction();

        setVisible(true);

        img = (BufferedImage) createImage(800, 600);
        g = img.getGraphics();
        //g2D = (Graphics2D) g;
        //g2D.setStroke(new BasicStroke(10));
    }

    private void toolButtons() {
        CheckboxGroup tools = new CheckboxGroup();
        Checkbox pen = new Checkbox("Pen", tools, true);
        Checkbox line = new Checkbox("Line", tools, false);
        Checkbox eraser = new Checkbox("Eraser", tools, false);

        pen.addItemListener(new Actions());
        line.addItemListener(new Actions());
        eraser.addItemListener(new Actions());

        add(pen);
        add(line);
        add(eraser);
    }

    private void mouseAction() {

        addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                x = e.getX();
                y = e.getY();
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                if (checkboxChecker.equals("Line")) {
                    g.drawLine(x, y, x2, y2);
                    repaint();
                }
            }
        });

        addMouseMotionListener(new MouseAdapter() {
            @Override
            public void mouseDragged(MouseEvent e) {
                if (checkboxChecker.equals("Pen")) {
                    g.setColor(Color.black);
                    g.drawLine(x, y, e.getX(), e.getY());
                    x = e.getX();
                    y = e.getY();
                    repaint();
                }
                if (checkboxChecker.equals("Line")) {
                    g.setColor(Color.black);
                    x2 = e.getX();
                    y2 = e.getY();
                }
                if (checkboxChecker.equals("Eraser")) {
                    g.drawLine(x, y, e.getX(), e.getY());
                    x = e.getX();
                    y = e.getY();
                    repaint();
                }
            }
        });
    }
}