package com.example.lab02;

public class EmployeeFullTime extends Employee {
    @Override
    public double tinhLuong() {
        return 500.0;
    }

    @Override
    public String toString() {
        return super.toString() + " --> FullTime=" + tinhLuong();
    }
}