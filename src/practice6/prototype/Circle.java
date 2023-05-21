package practice6.prototype;

public class Circle implements IShape{
    private double radius;

    public Circle(double radius){
        this.radius = radius;
    }

    @Override
    public double getPerimeter() {
        return 2 * Math.PI * radius;
    }

    @Override
    public double getArea() {
        return Math.PI * Math.pow(radius, 2);
    }

    @Override
    public IShape clone() {
        Circle copy = new Circle(radius);
        return copy;
    }

    @Override
    public String toString() {
        return "Окружность: радиус - " + radius + ", хэш - " + this.hashCode();
    }
}
