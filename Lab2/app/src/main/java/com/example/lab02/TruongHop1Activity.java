package com.example.lab02;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class TruongHop1Activity extends AppCompatActivity {

    TextView tvSelection;
    ListView lvPerson;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Nhớ check tên file layout chỗ này
        setContentView(R.layout.activity_truong_hop1);

        // 1. Tìm các view trên giao diện
        tvSelection = findViewById(R.id.tvSelection);
        lvPerson = findViewById(R.id.lv_person);

        // 2. Khởi tạo mảng chứa dữ liệu
        final String[] arr = {"Tèo", "Tý", "Bin", "Bo"};

        // 3. Xây dựng adapter (cầu nối giữa dữ liệu và giao diện)
        ArrayAdapter<String> adapter = new ArrayAdapter<>(
                this,
                android.R.layout.simple_list_item_1,
                arr
        );

        // 4. Đổ dữ liệu lên ListView
        lvPerson.setAdapter(adapter);

        // 5. Xử lý sự kiện click vào từng dòng trên listview
        lvPerson.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                tvSelection.setText("position: " + position + " ; value = " + arr[position]);
            }
        });
    }
}