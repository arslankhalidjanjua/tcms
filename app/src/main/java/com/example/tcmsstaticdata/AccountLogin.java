package com.example.tcmsstaticdata;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class AccountLogin extends AppCompatActivity {
    Button btn_loginstu;
    Button admin_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account_login);

        btn_loginstu = findViewById(R.id.btn_loginstu);
      admin_btn=findViewById(R.id.admin_btn);

        btn_loginstu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(AccountLogin.this, StudentLogin.class));

            }
        });

        admin_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(AccountLogin.this, AdminLogin.class));

            }
        });
    }
}