import java.util.ArrayList;
import java.util.List;

public class Quadtree {
    public List<Quadtree> children;

    private double x, y, width;

    public Quadtree(double x, double y, double width) {
        children = new ArrayList<>();
        // x,y marks center of quad
        // quad = 4 quadrants
        // +------------+
        // |     |      |
        // |     |      |
        // |----x,y-----|
        // |     |      |
        // |     |      |
        // +------------+
        this.x = x;
        this.y = y;
        this.width = width;
    }

    public void subdivide() {
        System.out.println("here");
        // top left, top right, bottom left, bottom right
        children.add(new Quadtree(x - width / 4, y + width / 4, width / 2));
        children.add(new Quadtree(x + width / 4, y + width / 4, width / 2));
        children.add(new Quadtree(x - width / 4, y - width / 4, width / 2));
        children.add(new Quadtree(x + width / 4, y - width / 4, width / 2));
    }

    public int countBodies(List<Body> bs) {
        int count = 0;

        for(Body b : bs) {
            if((b.posX <= x + width / 2) && (b.posX >= x - width / 2) && (b.posY <= y + width / 2) && (b.posY >= y - width / 2)) {
                count++;
            }
        }

        return count;
    }
}
