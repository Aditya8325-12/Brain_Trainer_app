package com.example.braintrainerapp;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.PorterDuff;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;

import java.util.ArrayList;

public class Multiplication extends AppCompatActivity implements View.OnClickListener {



    TextView Question, QuestionLeft;
    Button option1,option2,option3,option4;
    int ques=0,correct=0,wrong=0;
    boolean intentValue =true;
    int count=0;

    SeekBar seekBar;

    int SeekbarTime=0;

    //    for generate Random Number Class
    ArrayList<Integer> data=new ArrayList<Integer>();
    GenrateRandomNumber genrateRandomNumber=new GenrateRandomNumber();
    int num1,num2,CorrectAnswerLocation;

//        for CheckOption is Wrong or not

    ChoiceAnswers choiceAnswers=new ChoiceAnswers();
    boolean CorrectValueCheck;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_multiplication);



//        value Assign part
        Question =findViewById(R.id.Question);
        QuestionLeft =findViewById(R.id.questionLeft);
        seekBar=findViewById(R.id.Seekbar);
        seekBar.setMax(30);

        option1=findViewById(R.id.option1);
        option2=findViewById(R.id.option2);
        option3=findViewById(R.id.option3);
        option4=findViewById(R.id.option4);


//       Genrate Number First time

        num1=genrateRandomNumber.GenerateQuestion();
        num2=genrateRandomNumber.GenerateQuestion();
        Question.setText(num1+" X "+num2);
        data= genrateRandomNumber.GenerateQuestionOption(num1*num2);
        CorrectAnswerLocation=genrateRandomNumber.CorrectAnswersLocation;


//        Set Color on option
        option1.getBackground().setColorFilter(0xFF018786, PorterDuff.Mode.MULTIPLY);
        option2.getBackground().setColorFilter(0xFF018786, PorterDuff.Mode.MULTIPLY);
        option3.getBackground().setColorFilter(0xFF018786, PorterDuff.Mode.MULTIPLY);
        option4.getBackground().setColorFilter(0xFF018786, PorterDuff.Mode.MULTIPLY);

//       set value in Option
        option1.setText(Integer.toString( data.get(0)));
        option2.setText(Integer.toString( data.get(1)));
        option3.setText(Integer.toString( data.get(2)));
        option4.setText(Integer.toString( data.get(3)));

//      create On click Listener
        option1.setOnClickListener(this);
        option2.setOnClickListener(this);
        option3.setOnClickListener(this);
        option4.setOnClickListener(this);



//        Create Countdown Timer


        CountDownTimer countDownTimer=new CountDownTimer(30000,1000) {
            @Override
            public void onTick(long l) {
                SeekbarTime++;
                seekBar.setProgress(SeekbarTime);
                count++;
            }
            @Override
            public void onFinish() {

                if(intentValue ==true)
                {
                    Intent intent=new Intent(Multiplication.this,result.class);
                    intent.putExtra("correct",correct);
                    startActivity(intent);
                    ques=0;
                    correct=0;
                    wrong=0;
                    SeekbarTime=0;
                    count=0;

                }
            }
        }.start();

    }


    @Override
    public void onClick(View view) {
        switch (view.getId())
        {
            case R.id.option1:
                CheckOptionIsWrongOrRight(view);
                break;
            case R.id.option2:
                CheckOptionIsWrongOrRight(view);
                break;
            case R.id.option3:
                CheckOptionIsWrongOrRight(view);
                break;
            case R.id.option4:
                CheckOptionIsWrongOrRight(view);
                break;
        }
    }




    public  void CheckOptionIsWrongOrRight(View view)
    {


//    fuction for Check   option is wrong or not
        CorrectValueCheck =choiceAnswers.OptionIsCorrectOrNot(view, CorrectAnswerLocation);

        if(CorrectValueCheck==true)
        {
            view.getBackground().setColorFilter(0xFF00FF00, PorterDuff.Mode.MULTIPLY);
            correct++;
        }
        else
        {
            view.getBackground().setColorFilter(0xFFF44336,PorterDuff.Mode.MULTIPLY);
            wrong++;
        }
        ques++;


//        Check how many ques are complete
        if(ques==10)
        {
            intentValue =false;
            Intent intent=new Intent(Multiplication.this,result.class);
            intent.putExtra("correct",correct);
            intent.putExtra("timecount",count);
            startActivity(intent);
            ques=0; correct=0; wrong=0; count=0;
        }


//           set the how many question are left

        QuestionLeft.setText(ques+"/10");


//        Creating the handler class when on question is Complete Than Generate the Second Question


        Handler handler=new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                data.clear();
                num1=genrateRandomNumber.GenerateQuestion();
                num2=genrateRandomNumber.GenerateQuestion();
                Question.setText(num1+" x "+num2);
                data= genrateRandomNumber.GenerateQuestionOption(num1*num2);
                CorrectAnswerLocation=genrateRandomNumber.CorrectAnswersLocation;
                option1.getBackground().setColorFilter(0xFF018786, PorterDuff.Mode.MULTIPLY);
                option2.getBackground().setColorFilter(0xFF018786, PorterDuff.Mode.MULTIPLY);
                option3.getBackground().setColorFilter(0xFF018786, PorterDuff.Mode.MULTIPLY);
                option4.getBackground().setColorFilter(0xFF018786, PorterDuff.Mode.MULTIPLY);
                option1.setText(Integer.toString( data.get(0)));
                option2.setText(Integer.toString( data.get(1)));
                option3.setText(Integer.toString( data.get(2)));
                option4.setText(Integer.toString( data.get(3)));

            }
        },500);

    }




    //       OnbackPressed when backButton is pressed
    public  void onBackPressed()
    {
        new AlertDialog.Builder(this)
                .setCancelable(false)
                .setMessage("Do you Want to restart the game")
                .setPositiveButton("yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Intent intent=new Intent(Multiplication.this,MainActivity.class);
                        startActivity(intent);
                    }
                })
                .setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.cancel();
                    }
                }).show();
    }



}