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
