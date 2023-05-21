package practice6.prototype;

public class Client {
    public static void main(String[] args) {
        Rectangle myRectangle = new Rectangle(2.0, 2.0);
        Rectangle copyRectangle = (Rectangle) myRectangle.clone();
        System.out.println(myRectangle.getArea() + "\t" + myRectangle.getPerimeter());
        System.out.println(myRectangle.toString() + "\n" + copyRectangle.toString());
        System.out.println(myRectangle.equals(copyRectangle));

        Circle myCircle= new Circle(5.0);
        Circle copyCircle = (Circle) myCircle.clone();
        System.out.println(myCircle.getArea() + "\t" + myCircle.getPerimeter());
        System.out.println(myCircle.toString() + "\n" + copyCircle.toString());
        System.out.println(myCircle.equals(copyCircle));

    }
}
