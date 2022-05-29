package com.pkg.touchshop;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;

public class LoginActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_page);
        findViewById(R.id.login_btn).setOnClickListener(view -> login());
    }

    private void login() {
        EditText email=findViewById(R.id.email_input);
        EditText password=findViewById(R.id.password_input);
        if(email.getText().toString().equalsIgnoreCase("tag@gmail.com")&&password.getText().toString().equals("Tag@123")){
            Intent intent=new Intent(LoginActivity.this,NewEntryForm.class);
            startActivity(intent);
        }else{
            System.out.println("mismatch");
        }
    }
}