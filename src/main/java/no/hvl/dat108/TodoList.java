package no.hvl.dat108;

import java.util.ArrayList;
import java.util.List;

public class TodoList{
    private List<TodoItem> items = new ArrayList<>();

    public synchronized void addItem(TodoItem item){
        synchronized(this){
            items.add(item);
            this.notifyAll();
        }
    }

    public synchronized void removeItem(String item){
        synchronized(this){
            items.removeIf(s -> s.getName().equals(item));
            this.notifyAll();
        }
    }

    public List<TodoItem> getItems(){
        return items;
    }

    public TodoList(){
        
    }
}