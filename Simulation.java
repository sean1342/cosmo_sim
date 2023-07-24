import java.util.ArrayList;
import java.util.List;

class Body {
    double posX, posY;
    double mass;
    double radius;

    public Body(double posX, double posY, double mass) {
        this.posX = posX;
        this.posY = posY;
        this.mass = mass;
        this.radius = Math.sqrt(mass / Math.PI) ;
    }
}

// each individual square of Quad Tree
class Cell {
    List<Cell> childCells;
    double centerOfMassX, centerOfMassY;
}

// Quad Tree for Barnes-Hut approximation
class QuadTree {
    List<Cell> cells;

    public QuadTree genQuadTree(List<Body> bodies) {
        QuadTree q = new QuadTree();

        for(int i = 0; i < bodies.size(); i++) {
            System.out.println(bodies.get(i).posX);
        }

        return q;
    }

    public void computeCenterOfMasses() {
    }
}

public class Simulation {
    private List<Body> suns;
    private int tick;

    public Simulation() {
        suns = new ArrayList<>();

        suns.add(new Body(0, 0, 50));
        suns.add(new Body(100, 100, 30));
    }

    public List<Body> getSuns() {
        return suns;
    }

    public void step() {
        System.out.println("step " + tick);
        tick++;
    }
}
