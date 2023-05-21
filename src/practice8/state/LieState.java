package practice8.state;

public class LieState implements State {
    @Override
    public void doAction() {
        System.out.println("Игрок лежит...");
    }
}
