package com.example.lab02;

public class EmployeePartTime extends Employee {
    @Override
    public double tinhLuong() {
        return 150.0;
    }

    @Override
    public String toString() {
        return super.toString() + " --> PartTime=" + tinhLuong();
    }
}