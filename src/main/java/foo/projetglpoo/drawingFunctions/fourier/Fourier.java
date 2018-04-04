package foo.projetglpoo.drawingFunctions.fourier;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class Fourier extends JPanel {
    private List<Object> shapes = new ArrayList<>();
    private Random random = new Random();

//    public static void main(String[] args) {
    public static void start(JFrame frame, Object[][] dataSet) {

        int amount = 15;

        String shape = "Circles";
        frame.add(new Fourier(amount, shape));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

    }

    public Fourier(int i, String shape) {
        setBackground(Color.BLACK);
        setPreferredSize(new Dimension(400, 400));

        switch (shape) {
            case "Circles":
                for (int j = 0; j < i; j++) {
                    addCircle(390, 390);
                }
                break;
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        for (Object s : shapes) {
            if (s instanceof Circle) {
                ((Circle) s).draw(g);
            }
        }
    }

    public void addCircle(int maxX, int maxY) {
        shapes.add(new Circle(random.nextInt(maxX), random.nextInt(maxY)));
        repaint();
    }
}
