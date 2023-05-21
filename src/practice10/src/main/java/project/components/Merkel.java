package project.model;

import project.interfaces.Politician;


public class Merkel implements Politician {

    private String message;

    public Merkel(String message){
        this.message = message;
    }

    @Override
    public void doPolitic() {
        System.out.print(message);
    }
}
