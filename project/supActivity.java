package com.example.project;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class supActivity extends AppCompatActivity {

    EditText etName, etEmail, etPhoneNumber, etMessage;
    BaseAdapter ba;
    FirebaseDatabase db;
    DatabaseReference supRef;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sup);

        etName = findViewById(R.id.etName);
        etEmail = findViewById(R.id.etEmail);
        etPhoneNumber = findViewById(R.id.etPhoneNumber);
        etMessage = findViewById(R.id.etMessage);
        db = FirebaseDatabase.getInstance();
        supRef = db.getReference("/support_messages");


    }

    public void doSend(View view) {
        String name = etName.getText().toString();
        String email = etEmail.getText().toString();
        String phonenumber = etPhoneNumber.getText().toString();
        String message = etMessage.getText().toString();

        if (name.isEmpty() || email.isEmpty() || phonenumber.isEmpty()
                || message.isEmpty()){
            Toast.makeText(supActivity.this,"You Need To Fill All Fields",
                    Toast.LENGTH_SHORT).show();
            return;
        }

        Message msg = new Message(name,email,phonenumber,message);
        final ProgressDialog pd = new ProgressDialog(supActivity.this);
        pd.setMessage("Please Wait");
        pd.setIndeterminate(true);
        pd.setCancelable(false);
        pd.show();
        supRef.push().setValue(msg).addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {
                pd.dismiss();

                final AlertDialog.Builder adb = new AlertDialog.Builder(supActivity.this);
                adb.setMessage("Thank You");
                adb.setMessage("We'll Be Contacting In Short Time.");
                adb.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        adb.setOnDismissListener(new DialogInterface.OnDismissListener() {
                            @Override
                            public void onDismiss(DialogInterface dialog) {

                            }
                        });
                    }
                });
                adb.show();
            }
        });

    }
}
