package com.example.lab02;

import android.os.Bundle;
import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;
import java.util.ArrayList;

public class TruongHop5Activity extends AppCompatActivity {
    EditText etId, etName;
    CheckBox cbManager;
    Button btnAdd;
    ListView lvEmployee;
    ArrayList<Employee> employees;
    EmployeeAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_truong_hop5);

        etId = findViewById(R.id.etId); etName = findViewById(R.id.etName);
        cbManager = findViewById(R.id.cbManager); btnAdd = findViewById(R.id.btnAdd);
        lvEmployee = findViewById(R.id.lvEmployee);

        employees = new ArrayList<>();
        adapter = new EmployeeAdapter(this, R.layout.item_employee, employees);
        lvEmployee.setAdapter(adapter);

        btnAdd.setOnClickListener(v -> {
            Employee emp = new Employee();
            emp.setId(etId.getText().toString());
            emp.setName(etName.getText().toString());
            emp.setManager(cbManager.isChecked());

            employees.add(emp);
            adapter.notifyDataSetChanged();

            etId.setText(""); etName.setText(""); cbManager.setChecked(false);
        });
    }
}