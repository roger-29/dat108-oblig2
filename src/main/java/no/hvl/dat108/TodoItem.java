package no.hvl.dat108;

public class TodoItem{
    
    public TodoItem(String name){
        this.name = name;
    }
    private String name;

    public String getName(){
        return this.name;
    }
}