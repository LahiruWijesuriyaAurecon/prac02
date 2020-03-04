package shapes;

public class Tetrahedron implements Shape {
    double edge;
    public Tetrahedron(double edge) {
        this.edge = edge;
    }

    @Override
    public double volume() {
        return Math.pow(edge,3)/(6*Math.pow(2,0.5));
    }

    @Override
    public double surfaceArea() {
        return Math.pow(3,0.5) * Math.pow(edge,2);
    }
}
