package com.example.lab02;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.List;

public class DishAdapter extends ArrayAdapter<Dish> {
    private Context context;

    public DishAdapter(Context context, List<Dish> objects) {
        super(context, 0, objects);
        this.context = context;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.item_dish, parent, false);
        }

        Dish dish = getItem(position);
        ImageView ivDishThumbnail = convertView.findViewById(R.id.ivDishThumbnail);
        TextView tvDishName = convertView.findViewById(R.id.tvDishName);
        ImageView ivPromotion = convertView.findViewById(R.id.ivPromotion);

        tvDishName.setText(dish.getName());
        tvDishName.setSelected(true); // Bắt buộc để hiệu ứng chữ chạy (Marquee) hoạt động
        ivDishThumbnail.setImageResource(dish.getThumbnail().getImg());

        if (dish.isPromotion()) {
            ivPromotion.setVisibility(View.VISIBLE);
        } else {
            ivPromotion.setVisibility(View.GONE);
        }

        return convertView;
    }
}