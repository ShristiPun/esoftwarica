package com.example.esoftwarica;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class login extends AppCompatActivity implements View.OnClickListener{

    Button login;
    EditText username,password;
    String uusername,upassword;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        username=findViewById(R.id.editUsername);
        password=findViewById(R.id.editPassword);

        login=findViewById(R.id.btnLogin);



       login.setOnClickListener(this);


    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.btnLogin){
            uusername=username.getText().toString();
            upassword=password.getText().toString();
            if (uusername.equals("softwarica") && upassword.equals("coventry")){
                Intent intent=new Intent(this,MainActivity.class);
                startActivity(intent);
            }
            else {
                Toast.makeText(this, "username or password incoorect", Toast.LENGTH_SHORT).show();
            }
        }
    }
}
