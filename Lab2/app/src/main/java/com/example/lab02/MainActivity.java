package com.example.lab02; // Nhớ check lại tên package của bạn trên cùng nhé

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    // Khai báo 5 nút bấm
    Button btnBai1, btnBai3, btnBai4, btnBai5, btnBai6;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 1. Ánh xạ (Tìm đúng ID bên file XML)
        btnBai1 = findViewById(R.id.btnBai1);
        btnBai3 = findViewById(R.id.btnBai3);
        btnBai4 = findViewById(R.id.btnBai4);
        btnBai5 = findViewById(R.id.btnBai5);
        btnBai6 = findViewById(R.id.btnBai6);

        // 2. Cài đặt "Chế độ tự bấm" (Chuyển trang bằng Intent)
        btnBai1.setOnClickListener(v -> {
            startActivity(new Intent(MainActivity.this, TruongHop1Activity.class));
        });

        btnBai3.setOnClickListener(v -> {
            startActivity(new Intent(MainActivity.this, TruongHop3Activity.class));
        });

        btnBai4.setOnClickListener(v -> {
            startActivity(new Intent(MainActivity.this, TruongHop4Activity.class));
        });

        btnBai5.setOnClickListener(v -> {
            startActivity(new Intent(MainActivity.this, TruongHop5Activity.class));
        });
        btnBai6.setOnClickListener(v -> {
            startActivity(new Intent(MainActivity.this, TruongHop6Activity.class));
        });
    }
}