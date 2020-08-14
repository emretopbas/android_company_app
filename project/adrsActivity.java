package com.example.project;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class adrsActivity extends AppCompatActivity {
    Button adrmap;
    TextView tvadrs,tvcadrs;
    DatabaseReference compreference;
    Context context = this;

    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adrs);
        adrmap = findViewById(R.id.adrmap);
        tvcadrs = findViewById(R.id.tvcadrs);
        tvadrs = findViewById(R.id.tvadrs);
        compreference= FirebaseDatabase.getInstance().getReference().child("address");
        compreference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                Log.e("x","");
                String value = String.valueOf(dataSnapshot.getValue());
                tvcadrs.setText(value);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

        adrmap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent  mapact = new Intent(context, MapsActivity.class);
                startActivity(mapact);
            }
        });
    }
}
