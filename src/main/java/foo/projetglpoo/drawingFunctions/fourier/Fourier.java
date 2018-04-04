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
    private List<Object> circles = new ArrayList<>();
    private Random random = new Random();

//    public static void main(String[] args) {
    public static void start(JFrame frame, Object[][] dataSet) {

        int amount = 20;

        frame.add(new Fourier(amount));
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

    }

    public Fourier(int i) {
        setBackground(Color.BLACK);
        setPreferredSize(new Dimension(1000, 1000));
        for (int j = 0; j < i; j++) {
            addCircle(1000, 1000,200);
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        for (Object s : circles) {
            if (s instanceof Circle) {
                ((Circle) s).draw(g);
            }
        }
    }

    public void addCircle(int maxX, int maxY, int maxR) {
        circles.add(new Circle(random.nextInt(maxX), random.nextInt(maxY), /*random.nextInt(maxR)*/100,0));
        repaint();
    }
}
