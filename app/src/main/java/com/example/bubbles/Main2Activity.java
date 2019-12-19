package com.example.bubbles;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerViewAccessibilityDelegate;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.google.firebase.FirebaseApp;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class Main2Activity extends AppCompatActivity {


    private RecyclerView mlistitem;
    private DatabaseReference mDatabase;
    private ArrayList<Blog> arrayList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
   mDatabase= FirebaseDatabase.getInstance().getReference().child("veri");
   mDatabase.keepSynced(true);

   mlistitem=(RecyclerView)findViewById(R.id.recyclerv_view);
   mlistitem.setHasFixedSize(true);
   mlistitem.setLayoutManager(new LinearLayoutManager(this));

   arrayList = new ArrayList<Blog>();

    }

    @Override
    protected void onStart() {
        super.onStart();
        FirebaseRecyclerAdapter<Blog, BlogViewHolder>FirebaseRecyclerAdapter = new FirebaseRecyclerAdapter<Blog, BlogViewHolder>
                (Blog.class, R.layout.layout_lisitem, BlogViewHolder.class, mDatabase) {


            @Override
            protected void onBindViewHolder(@NonNull BlogViewHolder viewHolder, int position, @NonNull Blog model) {
                viewHolder.setDay(model.getDay());
                viewHolder.setDesc(model.getDesc());
                viewHolder.setImage(getApplicationContext(),model.getImage());
            }

            @NonNull
            @Override
            public BlogViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
                return null;
            }
        };
        mlistitem.setAdapter(FirebaseRecyclerAdapter);
    }
    public static class BlogViewHolder extends RecyclerView.ViewHolder
    {
      View mView;

        public BlogViewHolder(@NonNull View itemView) {
            super(itemView);
            mView = itemView;
        }
        public void setDay(String day)
        {
            TextView post_day = (TextView)mView.findViewById(R.id.post_day);
            post_day.setText(day);
        }
        public void setDesc(String desc)
        {
           TextView post_desc = (TextView)mView.findViewById(R.id.post_desc);
           post_desc.setText(desc);
        }
        public void setImage(Context ctx,String image)
        {
            ImageView post_image=(ImageView)mView.findViewById(R.id.post_image);
            Picasso.get().load(image).into(post_image);
        }
    }

}
