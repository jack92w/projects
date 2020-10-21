package io.github.jack92w.todoapp.model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name= "tasks")
public class Task {
    @Id //information to Hibernate that this field will be id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //strategia generowania wartości
    private int id;
    @NotBlank(message= "Task's description must not be empty")
    private String descritpion;
    private boolean done;

    Task(){
    }

    public int getId() {
        return id;
    }

    void setId(int id) {
        this.id = id;
    }

    public String getDescritpion() {
        return descritpion;
    }

    void setDescritpion(String descritpion) {
        this.descritpion = descritpion;
    }

    public boolean isDone() {
        return done;
    }

    void setDone(boolean done) {
        this.done = done;
    }
}
