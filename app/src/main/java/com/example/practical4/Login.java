package com.example.practical4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Login extends AppCompatActivity {

    Button b1;
    EditText e1, e2;
    String s1, s2;
    DataStore db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        b1 = findViewById(R.id.l_login);
        e1 = findViewById(R.id.l_email);
        e2 = findViewById(R.id.l_password);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                s1 = e1.getText().toString();
                s2 = e2.getText().toString();

                db = new DataStore(getApplicationContext());

                boolean result = db.login(s1, s2);

                if (result) {
                    Intent i = new Intent(Login.this, Home.class);
                    Toast.makeText(Login.this, "Login Successful!", Toast.LENGTH_LONG).show();

                    startActivity(i);
                }
                else {
                    Toast.makeText(Login.this, "Login Failed!", Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}