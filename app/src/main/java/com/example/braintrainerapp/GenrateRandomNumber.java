package com.example.braintrainerapp;

import android.graphics.RenderNode;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Random;

public class GenrateRandomNumber {

    int CorrectAnswersLocation;
    Random random=new Random();

    public int GenerateQuestion()
    {
        int num=random.nextInt(50);
        return  num;
    }

    public ArrayList<Integer> GenerateQuestionOption(int CorrectAnswersValue)
    {
        ArrayList<Integer> data=new ArrayList<>();
        CorrectAnswersLocation=random.nextInt(3);
        for(int i=0;i<=3;i++)
        {
            if(CorrectAnswersLocation == i )
            {
                data.add(CorrectAnswersValue);
            }
            else
            {
                int InCorrectAnswerValue=random.nextInt(95);
                while (InCorrectAnswerValue==CorrectAnswersValue)
                {
                    InCorrectAnswerValue= random.nextInt(99);
                }

                data.add(InCorrectAnswerValue);
            }
        }
        return data;

    }


    public Integer CorrectAnswerLocationValue()
    {
        return CorrectAnswersLocation;
    }


}
