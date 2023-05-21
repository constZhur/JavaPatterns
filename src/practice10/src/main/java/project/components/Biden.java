package project.model;

import project.interfaces.Politician;

public class Biden  implements Politician {
    private String message;

    public Biden(String message){
        this.message = message;
    }

    @Override
    public void doPolitic() {
        System.out.print(message);
    }
}
