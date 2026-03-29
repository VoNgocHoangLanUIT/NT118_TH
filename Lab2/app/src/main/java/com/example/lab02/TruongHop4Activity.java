package com.example.lab02;

import android.os.Bundle;
import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;
import java.util.ArrayList;

public class TruongHop4Activity extends AppCompatActivity {
    EditText etId, etName;
    RadioGroup rgType;
    Button btnAdd;
    ListView lvEmployee;
    ArrayList<Employee> employees;
    ArrayAdapter<Employee> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_truong_hop4);

        etId = findViewById(R.id.etId); etName = findViewById(R.id.etName);
        rgType = findViewById(R.id.rgType); btnAdd = findViewById(R.id.btnAdd);
        lvEmployee = findViewById(R.id.lvEmployee);

        employees = new ArrayList<>();
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, employees);
        lvEmployee.setAdapter(adapter);

        btnAdd.setOnClickListener(v -> {
            String id = etId.getText().toString();
            String name = etName.getText().toString();
            Employee emp = (rgType.getCheckedRadioButtonId() == R.id.radChinhThuc)
                    ? new EmployeeFullTime() : new EmployeePartTime();
            emp.setId(id);
            emp.setName(name);
            employees.add(emp);
            adapter.notifyDataSetChanged();
            etId.setText(""); etName.setText("");
        });
    }
}