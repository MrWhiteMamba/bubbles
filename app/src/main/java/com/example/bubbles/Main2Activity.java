package com.example.bubbles;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerViewAccessibilityDelegate;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.FirebaseApp;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class Main2Activity extends AppCompatActivity {


    private RecyclerView mlistitem;
    private DatabaseReference mDatabase;
    private ArrayList<Blog> arrayList;
    private FirebaseRecyclerOptions<Blog> options;
    private FirebaseRecyclerAdapter<Blog,FirebaseViewHolder> adapter;
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
   options = new FirebaseRecyclerOptions.Builder<Blog>().setQuery(mDatabase,Blog.class).build();

        adapter = new FirebaseRecyclerAdapter<Blog, FirebaseViewHolder>(options) {
        @Override
        protected void onBindViewHolder(@NonNull FirebaseViewHolder holder, int position, @NonNull Blog model) {

            holder.day.setText(model.getDay());
            holder.desc.setText(model.getDesc());
            Picasso.get().load(model.getImage()).into(holder.image);
            final Integer id = model.getId();
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view){
                        switch (id){
                            case 1:
                                Intent intent = new Intent(Main2Activity.this,shoulderActivity.class);
                                startActivity(intent);
                                break;
                            case 2:
                                Intent intent2 = new Intent(Main2Activity.this,chestActivity.class);
                                startActivity(intent2);
                                break;
                            case 3:
                            Intent intent3 = new Intent(Main2Activity.this,legActivity.class);
                            startActivity(intent3);
                                break;
                            case 4:
                            Intent intent4 = new Intent(Main2Activity.this,armActivity.class);
                            startActivity(intent4);
                                break;
                            default:
                                Toast.makeText(Main2Activity.this,"",Toast.LENGTH_SHORT).show();
                        }
            }
            });

        }

        @NonNull
        @Override
        public FirebaseViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            return new FirebaseViewHolder(LayoutInflater.from(Main2Activity.this).inflate(R.layout.layout_lisitem,parent,false));
        }
    };
        mlistitem.setAdapter(adapter);
        adapter.startListening();
    }




}
