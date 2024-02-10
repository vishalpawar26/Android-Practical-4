package com.example.practical4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button b1, b2;
    EditText e1, e2, e3, e4, e5, e6;
    String s1, s2, s3, s4, s5, s6;

    DataStore db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        b1 = findViewById(R.id.login);
        b2 = findViewById(R.id.register);

        e1 = findViewById(R.id.name);
        e2 = findViewById(R.id.contect);
        e3 = findViewById(R.id.dob);
        e4 = findViewById(R.id.email);
        e5 = findViewById(R.id.address);
        e6 = findViewById(R.id.password);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, Login.class);
                startActivity(i);
            }
        });

        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                db = new DataStore(getApplicationContext());

                s1 = e1.getText().toString();
                s2 = e2.getText().toString();
                s3 = e3.getText().toString();
                s4 = e4.getText().toString();
                s5 = e5.getText().toString();
                s6 = e6.getText().toString();

                boolean result = db.storeData(s1, s2, s3, s4, s5, s6);
                if (result) {
                    Intent i = new Intent(MainActivity.this, Login.class);
                    startActivity(i);
                }
                else {
                    Toast.makeText(MainActivity.this, "Registration Failed!", Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}