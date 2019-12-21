package com.example.bubbles;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class FirebaseViewHolder extends RecyclerView .ViewHolder{

    public TextView day, desc;
    public ImageView image;

    public FirebaseViewHolder(@NonNull View itemView) {
        super(itemView);

        day = itemView.findViewById(R.id.post_day);
        desc = itemView.findViewById(R.id.post_desc);
        image = itemView.findViewById(R.id.post_image);
    }

}
