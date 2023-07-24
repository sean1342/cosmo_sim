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
    private List<Body> suns;
    private int tick;

    public Simulation() {
        suns = new ArrayList<>();

        suns.add(new Body(0, 0, 0, 0, 50));
        suns.add(new Body(100, 100, 0, 0, 100));
    }

    public List<Body> getBodies() {
        return suns;
    }

    public void step() {
        System.out.println("step " + tick);

        for(int i = 0; i < suns.size(); i++) {
            suns.get(i).posX += suns.get(i).velX;
            suns.get(i).posY += suns.get(i).velY;
        }

        tick++;
    }
}
