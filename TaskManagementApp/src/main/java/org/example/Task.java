package org.example;

import lombok.Data;

import java.io.Serializable;

@Data
public class Task implements Serializable {
    private final int id;
    private final String description;
    private boolean isDone;

    public Task(int id, String description) {
        this.id = id;
        this.description = description;
        this.isDone = false;
    }

    public void markAsDone() {
        this.isDone = true;
    }

    @Override
    public String toString() {
        return "[" + (isDone ? "X" : " ") + "] " + id + ". " + description;
    }
}
