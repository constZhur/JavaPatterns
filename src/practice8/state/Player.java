package practice8.state;

public class Player {
    private State state;

    public void setStatement(State state){
        this.state = state;
    }

    public void changeStatement() {
        if (state instanceof LieState) setStatement(new MoveState());
        else if (state instanceof MoveState) setStatement(new StandState());
        else if (state instanceof StandState) setStatement(new LieState());
    }

    public void start(){
        state.doAction();
    }
}
