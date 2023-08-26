package com.example.braintrainerapp;

import androidx.annotation.ColorRes;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class result extends AppCompatActivity {


    LinearLayout linearLayout,linearLayout1;
    TextView textView,scoreView,TimeCount;


    int condition;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        TimeCount=findViewById(R.id.TimeCount);
        scoreView=findViewById(R.id.score);
        textView=findViewById(R.id.winprogress);
        linearLayout=findViewById(R.id.linear);
        Intent intent=getIntent();


        int   s=intent.getIntExtra("correct",0);
        int   timecount=intent.getIntExtra("timecount",0);

        if(timecount==0)
        {
            timecount=30;
        }

        if(s==1 || s==2 || s==3  || s==4)
        {
            TimeCount.setText("Time Taken  : "+timecount+" Sec");
            scoreView.setText("Score : "+s);
            textView.setText("Good");
            ImageView imageView=new ImageView(this);
            imageView.setLayoutParams(new LinearLayout.LayoutParams(200,200));
            int id=12;
            imageView.setId(id);
            imageView.setImageResource(R.drawable.star);
            linearLayout.addView(imageView);
        }
        if(s==5 || s==6 || s==7 )
        {
            TimeCount.setText("Time Taken  : "+timecount+" Sec");
            scoreView.setText("Score : "+s);
            textView.setText("Very Good");
            for(int i=1;i<=2;i++)
            {
                ImageView imageView=new ImageView(this);
                imageView.setLayoutParams(new LinearLayout.LayoutParams(200,200));
                int id=12;
                imageView.setId(id+i);
                imageView.setImageResource(R.drawable.star);
                linearLayout.addView(imageView);
            }

        }
        if(s==8 || s==9 || s==10 )
        {
            TimeCount.setText("Time Taken  : "+timecount+" Sec");
            scoreView.setText("Score : "+s);
            textView.setText("excellent");

            for(int i=1;i<=3;i++)
            {
                ImageView imageView=new ImageView(this);
                imageView.setLayoutParams(new LinearLayout.LayoutParams(200,200));
                int id=12;
                imageView.setId(id+i);
                imageView.setImageResource(R.drawable.star);
                linearLayout.addView(imageView);
            }

        }



        if(s==0)
        {

            scoreView.setText("Score : "+s);
            textView.setText("Better Luck Next Time");

        }







    }

    public  void onBackPressed()
    {
//        super.onBackPressed();
        new AlertDialog.Builder(this)
                .setCancelable(false)
                .setMessage("Do you Want to restart the game")
                .setPositiveButton("yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Intent intent=new Intent(result.this,MainActivity.class);
                        startActivity(intent);
                    }
                })
                .setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        finishAffinity();
                    }
                }).show();


    }
}