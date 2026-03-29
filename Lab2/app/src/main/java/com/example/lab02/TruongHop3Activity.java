package com.example.lab02;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import java.util.ArrayList;

public class TruongHop3Activity extends AppCompatActivity {

    EditText etName;
    Button btnSubmit;
    TextView tvSelection;
    ListView lvPerson;

    ArrayList<String> names;
    ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_truong_hop3);

        // 1. Ánh xạ các thành phần trên giao diện
        etName = findViewById(R.id.etName);
        btnSubmit = findViewById(R.id.btnSubmit);
        tvSelection = findViewById(R.id.tvSelection);
        lvPerson = findViewById(R.id.lv_person);

        // 2. Tạo ArrayList và bỏ sẵn vài cái tên [cite: 52]
        names = new ArrayList<>();
        names.add("Tèo");
        names.add("Tý");
        names.add("Bin");

        // 3. Cài đặt Adapter
        adapter = new ArrayAdapter<>(
                this,
                android.R.layout.simple_list_item_1,
                names
        );
        lvPerson.setAdapter(adapter);

        // 4. BẤM NÚT "NHẬP": Thêm dữ liệu [cite: 54, 55]
        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String newName = etName.getText().toString().trim();
                if (!newName.isEmpty()) {
                    names.add(newName); // Thêm vào danh sách
                    adapter.notifyDataSetChanged(); // Cập nhật Listview
                    etName.setText(""); // Xóa chữ trong ô nhập đi cho gọn
                }
            }
        });

        // 5. CLICK NGẮN: Xem thông tin [cite: 66, 67]
        lvPerson.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                tvSelection.setText("position: " + position + " ; value = " + names.get(position));
            }
        });

        // 6. CLICK DÀI: Xóa dữ liệu [cite: 68]
        lvPerson.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                names.remove(position); // Xóa khỏi danh sách [cite: 46, 47, 48, 49]
                adapter.notifyDataSetChanged(); // Báo cập nhật
                tvSelection.setText("Đã xóa phần tử ở vị trí: " + position);
                return true; // Phải return true để nó không gọi nhầm sang sự kiện Click ngắn
            }
        });
    }
}