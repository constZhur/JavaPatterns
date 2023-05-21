package practice8.state;

public class Game {
    public static void main(String[] args) {
        Player player = new Player();
        player.setStatement(new LieState());
        for (int i = 0; i < 10; i++) {
            player.start();
            player.changeStatement();
        }
    }
}
