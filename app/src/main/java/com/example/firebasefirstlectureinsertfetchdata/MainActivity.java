package com.example.firebasefirstlectureinsertfetchdata;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

EditText etName,etEmail,etPassword,etDept;
TextView tvName,tvEmail,tvPassword,tvDept;
Button btnSend ,btnFetch;
    FirebaseDatabase database;
    DatabaseReference myRef ;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        etName=findViewById(R.id.edit_text_1);
        etEmail=findViewById(R.id.edit_text_2);
        etPassword=findViewById(R.id.edit_text_3);
        etDept=findViewById(R.id.edit_text_4);
        tvName=findViewById(R.id.tvOne);
        tvEmail=findViewById(R.id.tvTwo);
        tvPassword=findViewById(R.id.tvThree);
        tvDept=findViewById(R.id.tvFour);

      btnSend=findViewById(R.id.button_1);
      btnFetch=findViewById(R.id.button_2);
        database = FirebaseDatabase.getInstance();
        myRef = database.getReference("message");
     btnSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String valueOne = etName.getText().toString();
                String valueTwo = etEmail.getText().toString();
                String valueThree =etPassword.getText().toString();
                String valueFour =etDept.getText().toString();
                HashMap map = new HashMap<>();
                map.put("Name", valueOne);
                map.put("Email", valueTwo);
                map.put("Password", valueThree);
                map.put("Dept", valueFour);
                clearEditText();
                myRef.push().setValue(map).addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void unused) {
                        Toast.makeText(MainActivity.this, "Data Send", Toast.LENGTH_SHORT).show();}
                }).addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(MainActivity.this, "Fail", Toast.LENGTH_SHORT).show();

                    }
                });
            }
        });
       btnFetch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
             myRef.addValueEventListener(new ValueEventListener() {
                 @Override
                 public void onDataChange(@androidx.annotation.NonNull DataSnapshot snapshot) {
                     Map GetDataMap = (Map) snapshot.getValue();
                     if(snapshot.exists())
                     {
                         String name = (String) GetDataMap.get("Name");
                         String email = (String) GetDataMap.get("Email");
                         String password = (String)  GetDataMap.get("Password");
                         String dept = (String) GetDataMap.get("Dept");
                         tvName.setText(name);
                         tvEmail.setText(email);
                         tvPassword.setText(password);
                         tvDept.setText(dept);
                     }
                     else {
                         Toast.makeText(MainActivity.this, "Data Not Found", Toast.LENGTH_SHORT).show();
                     }}

                 @Override
                 public void onCancelled(@androidx.annotation.NonNull DatabaseError error) {

                 }



             });
            }
        });
    }
    private void clearEditText() {

       etName.setText("");
       etEmail.setText("");
        etPassword.setText("");
        etDept.setText("");
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

       // Toast.makeText(this, "OnRestart", Toast.LENGTH_SHORT).show();
    }


}