package com.example.mentalpeaceapp.ui.util;


import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mentalpeaceapp.R;
import com.example.mentalpeaceapp.data.models.Quote;

import java.util.List;

public class ImageAdapter extends RecyclerView.Adapter<ImageAdapter.ImageViewHolder> {

    private final List<Quote> dataset;
    private final Context context;

    public ImageAdapter(Context context, List<Quote> dataset) {
        this.context = context;
        this.dataset = dataset;
    }

    @NonNull
    @Override
    public ImageViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.carousel_item, parent, false);
        return new ImageViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ImageViewHolder holder, int position) {
        Drawable img = dataset.get(position).getImg();
        String quote = dataset.get(position).getQuoteText();
        holder.imageView.setImageDrawable(img);
        holder.textView.setText(quote);
    }

    @Override
    public int getItemCount() {
        return dataset.size();
    }

    static class ImageViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView textView;

        ImageViewHolder(View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.quoteImg);
            textView = itemView.findViewById(R.id.quote);
        }
    }
}
