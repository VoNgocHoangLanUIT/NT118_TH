package com.example.lab02;

import android.os.Bundle;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.Spinner;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import java.util.ArrayList;

public class TruongHop6Activity extends AppCompatActivity {
    EditText etDishName;
    Spinner spnThumbnail;
    CheckBox cbPromotion;
    Button btnAddDish;
    GridView gvDish;

    ArrayList<Dish> dishList;
    DishAdapter dishAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_truong_hop6);

        etDishName = findViewById(R.id.etDishName);
        spnThumbnail = findViewById(R.id.spnThumbnail);
        cbPromotion = findViewById(R.id.cbPromotion);
        btnAddDish = findViewById(R.id.btnAddDish);
        gvDish = findViewById(R.id.gvDish);

        // Setup Spinner
        ThumbnailAdapter thumbnailAdapter = new ThumbnailAdapter(this, Thumbnail.values());
        spnThumbnail.setAdapter(thumbnailAdapter);

        // Setup GridView
        dishList = new ArrayList<>();
        dishAdapter = new DishAdapter(this, dishList);
        gvDish.setAdapter(dishAdapter);

        // Xử lý nút Thêm
        btnAddDish.setOnClickListener(v -> {
            String name = etDishName.getText().toString();
            Thumbnail selectedThumbnail = (Thumbnail) spnThumbnail.getSelectedItem();
            boolean isPromotion = cbPromotion.isChecked();

            // Thêm món ăn mới
            dishList.add(new Dish(name, selectedThumbnail, isPromotion));
            dishAdapter.notifyDataSetChanged();

            // Hiện Toast
            Toast.makeText(this, "Added successfully", Toast.LENGTH_SHORT).show();
            // Reset giao diện [cite: 312]
            etDishName.setText("");
            spnThumbnail.setSelection(0);
            cbPromotion.setChecked(false);
        });
    }
}