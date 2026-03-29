package com.example.lab02;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class ThumbnailAdapter extends ArrayAdapter<Thumbnail> {
    private Context context;

    public ThumbnailAdapter(Context context, Thumbnail[] objects) {
        super(context, 0, objects);
        this.context = context;
    }

    // Hiển thị khi đóng Spinner (Chỉ hiện chữ)
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.item_selected_thumbnail, parent, false);
        }
        TextView tvName = convertView.findViewById(R.id.tvSelectedName);
        tvName.setText(getItem(position).getName());
        return convertView;
    }

    // Hiển thị dạng Dialog chọn (Có chữ và hình)
    @Override
    public View getDropDownView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.item_thumbnail, parent, false);
        }
        TextView tvName = convertView.findViewById(R.id.tvName);
        ImageView ivThumbnail = convertView.findViewById(R.id.ivThumbnail);

        Thumbnail thumbnail = getItem(position);
        tvName.setText(thumbnail.getName());
        ivThumbnail.setImageResource(thumbnail.getImg());

        return convertView;
    }
}