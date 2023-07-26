import java.util.ArrayList;
import java.util.List;

public class Quadtree {
    public List<Quadtree> children;

    public double x, y, size;

    public Quadtree(double x, double y, double size) {
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
        this.size = size;
    }

    public void subdivide() {
        // top left, top right, bottom left, bottom right
        children.add(new Quadtree(x - size / 4, y + size / 4, size / 2));
        children.add(new Quadtree(x + size / 4, y + size / 4, size / 2));
        children.add(new Quadtree(x - size / 4, y - size / 4, size / 2));
        children.add(new Quadtree(x + size / 4, y - size / 4, size / 2));
    }

    public int countBodies(List<Body> bs) {
        int count = 0;

        for (Body b : bs) {
            if ((b.posX <= x + size / 2) && (b.posX >= x - size / 2) && (b.posY <= y + size / 2) && (b.posY >= y - size / 2)) {
                count++;
            }
        }

        return count;
    }
}
