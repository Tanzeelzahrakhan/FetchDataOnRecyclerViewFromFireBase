package com.example.firebasefirstlectureinsertfetchdata;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Main_RecyclerView extends AppCompatActivity {
    RecyclerView recyclerView;
    Button btnAdd;
    FirebaseDatabase database;
    DatabaseReference myRef ;
    AdapterClass adapterClass;
    ModelClass modelClass;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_recyclerview);
        recyclerView=findViewById(R.id.recyclerview);
        btnAdd=findViewById(R.id.buttonAdd);
        database = FirebaseDatabase.getInstance();
        myRef = database.getReference("message");
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Main_RecyclerView.this,MainActivity.class);
                startActivity(intent);
            }
        });


        FirebaseRecyclerOptions<ModelClass> options =
                new FirebaseRecyclerOptions.Builder<ModelClass>()
                        .setQuery(FirebaseDatabase.getInstance().getReference().child("message"),ModelClass.class)
                        .build();
        adapterClass=new AdapterClass(options);
        recyclerView.setAdapter(adapterClass);
    }
    @Override
    protected void onStart() {
        super.onStart();
        adapterClass.startListening();
    }
    @Override
    protected void onPause() {
        super.onPause();
        //Toast.makeText(this, "OnPause", Toast.LENGTH_SHORT).show();


    }
    @Override
    protected void onStop() {
        super.onStop();
        //Toast.makeText(this, "OnStop", Toast.LENGTH_SHORT).show();

    }
    @Override
    protected void onRestart() {
        super.onRestart();

        //Toast.makeText(this, "OnRestart", Toast.LENGTH_SHORT).show();
    }

}