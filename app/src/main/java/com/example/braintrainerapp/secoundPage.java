package com.example.braintrainerapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class secoundPage extends AppCompatActivity implements View.OnClickListener {

    Button addition,subsTract,multiplication;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_secound_page);

        addition=findViewById(R.id.addition);
        subsTract=findViewById(R.id.Substraction);
        multiplication=findViewById(R.id.Multiplication);


        addition.setOnClickListener(this);
        subsTract.setOnClickListener(this);
        multiplication.setOnClickListener(this);

    }


    @Override
    public void onClick(View view) {

        switch (view.getId())
        {
            case R.id.addition:
                Intent intent=new Intent(secoundPage.this,Addition.class);
                startActivity(intent);
                break;
            case R.id.Multiplication:
                Intent intent1=new Intent(secoundPage.this,Multiplication.class);
                startActivity(intent1);
                break;
            case R.id.Substraction:
                Intent intent2=new Intent(secoundPage.this, Subtractions.class);
                startActivity(intent2);
                break;

        }
    }
}