package practice8.state;

public class StandState implements State{
    @Override
    public void doAction() {
        System.out.println("Игрок стоит...");
    }
}
