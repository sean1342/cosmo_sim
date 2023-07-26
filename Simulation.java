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

    private List<Body> suns;
    private int tick;

    public Simulation(int size) {

        suns = new ArrayList<>();

        quadtree = new Quadtree(size / 2, size / 2, size);

        quadtree.subdivide();

        suns.add(new Body(180, 320, 0, 0, 150));
        suns.add(new Body(50, 50, 0, 0, 300));
    }

    public List<Body> getBodies() {
        return suns;
    }

    public void step() {
        System.out.println("step " + tick);

        List<Quadtree> quadsToCheck = new ArrayList<>();

        for (Quadtree q : quadtree.children) {
            quadsToCheck.add(q);
        }

        List<Quadtree> quadsToAdd = new ArrayList<>();

        for (Quadtree q : quadsToCheck) {
            if (q.countBodies(suns) > 1 && q.children.size() == 0) {
                q.subdivide();
            }
            for (Quadtree w : q.children) {
                quadsToAdd.add(w);
            }
        }

        // Add the newly created quadrants to the main quadsToCheck list
        quadsToCheck.addAll(quadsToAdd);

        for (Body b : suns) {
            b.posX += b.velX;
            b.posY += b.velY;
        }

        tick++;
    }    
}
