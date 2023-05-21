package practice8.state;

public class MoveState implements State{
    @Override
    public void doAction() {
        System.out.println("Игрок идет...");
    }
}
