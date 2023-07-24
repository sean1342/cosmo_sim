import javax.swing.*;
import java.awt.*;

public class Main {
    private static int width = 800;
    private static int height = 800;
    private static Simulation simulation;
    private static JFrame frame;
    private static Canvas canvas;

    public static void main(String[] args) {
        simulation = new Simulation();

        frame = new JFrame("N-Body Simulator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(width, height);

        canvas = new Canvas();
        canvas.setSize(width, height);
        frame.getContentPane().add(canvas);

        frame.setVisible(true);

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
            drawBodies(g);
        }

        private void drawBodies(Graphics g) {
            java.util.List<Body> bodies = simulation.getSuns();

            for (Body body : bodies) {
                int radius = (int) body.radius;
                int posX = (int) body.posX;
                int posY = (int) body.posY;

                g.setColor(Color.BLUE);
                g.fillOval(posX - radius + (width / 2), -(posY - radius) + (height / 2), radius * 2, radius * 2);
            }
        }
    }
}
