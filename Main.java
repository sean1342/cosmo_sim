import javax.swing.*;
import java.awt.*;

public class Main {
    private static int size = 800;
    private static Simulation simulation;
    private static JFrame frame;
    private static Canvas canvas;

    public static void main(String[] args) {
        simulation = new Simulation(size);

        frame = new JFrame("N-Body Simulator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(size, size);

        canvas = new Canvas();
        canvas.setSize(size, size);
        frame.getContentPane().add(canvas);

        frame.setVisible(true);
        simulation.quadtree.subdivide();

        boolean running = true;
        while (running) {
            simulation.step();
            canvas.repaint();
            
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    static class Canvas extends JPanel {
        @Override
        public void paintComponent(Graphics g) {
            super.paintComponent(g);
            draw(g);
        }

        private void draw(Graphics g) {
            g.setColor(Color.BLACK);
            g.fillRect(0, 0, frame.getWidth(), frame.getHeight());

            java.util.List<Body> bodies = simulation.getBodies();

            for (Body body : bodies) {
                int radius = (int) body.radius;
                int posX = (int) body.posX;
                int posY = (int) body.posY;

                g.setColor(Color.WHITE);
                g.fillOval(posX - radius + (size / 2), -(posY - radius) + (size / 2), radius * 2, radius * 2);
            }
        }
    }
}
