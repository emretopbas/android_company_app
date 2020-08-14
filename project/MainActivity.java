package com.example.project;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.maps.GoogleMap;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    Button hst, vis, adrs, sup;
    GoogleMap map;
    Context context = this;



    public void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        hst = findViewById(R.id.hst);
        vis = findViewById(R.id.vis);

        adrs = findViewById(R.id.adrs);
        sup = findViewById(R.id.sup);



        hst.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent hstact = new Intent(context, hstActivity.class);
                startActivity(hstact);
            }
        });

        vis.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent visact= new Intent(context, visActivity.class);
                startActivity(visact);
            }
        });

        adrs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent adrsact= new Intent(context, adrsActivity.class);
                startActivity(adrsact);
            }
        });

        sup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent supact = new Intent(context, supActivity.class);
                startActivity(supact);
            }
        });





    }





}
