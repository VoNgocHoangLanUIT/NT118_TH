package com.example.lab02;

public class Employee {
    private String id;
    private String name;
    private boolean isManager;

    // Getters và Setters
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public boolean isManager() { return isManager; }
    public void setManager(boolean manager) { isManager = manager; }

    public double tinhLuong() {
        return 0;
    }

    @Override
    public String toString() {
        return id + " - " + name;
    }
}