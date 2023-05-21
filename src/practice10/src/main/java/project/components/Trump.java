package project.model;

import project.interfaces.Politician;


public class Trump implements Politician {

    private String message;

    public Trump(String message){
        this.message = message;
    }

    @Override
    public void doPolitic() {
        System.out.print(message);
    }
}
