import java.util.ArrayList;
import java.util.List;

class Body {
    double posX, posY;
    double velX, velY;
    double mass;
    double radius;

    public Body(double posX, double posY, double velX, double velY, double mass) {
        this.posX = posX;
        this.posY = posY;
        this.velX = velX;
        this.velY = velY;
        this.mass = mass;
        this.radius = Math.sqrt(mass / Math.PI);
    }
}

public class Simulation {
    public Quadtree quadtree;

    private int size;

    private List<Body> suns;
    private int tick;

    public Simulation(int size) {
        this.size = size;

        suns = new ArrayList<>();

        quadtree = new Quadtree(size / 2, size / 2, size);

        quadtree.subdivide();

        suns.add(new Body(0, 0, 0, 0, 50));
        suns.add(new Body(100, 100, 0, 0, 100));
    }

    public List<Body> getBodies() {
        return suns;
    }

    public void step() {
        System.out.println("step " + tick);

        for(Body b : suns) {
            b.posX += b.velX;
            b.posY += b.velY;
        }

        tick++;
    }
}
