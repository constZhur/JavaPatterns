package practice6.prototype;

public class Rectangle implements  IShape{
    private double width;
    private double height;

    public Rectangle(double width, double height) {
        this.width = width;
        this.height = height;
    }

    @Override
    public double getPerimeter() {
        return 2 * (width + height);
    }

    @Override
    public double getArea() {
        return width * height;
    }

    @Override
    public IShape clone() {
        Rectangle copy = new Rectangle(height, width);
        return copy;
    }

    @Override
    public String toString() {
        return "Прямоугольник: ширина - " + width + ", длина - " + height + ", хэш - " + this.hashCode();
    }
}
