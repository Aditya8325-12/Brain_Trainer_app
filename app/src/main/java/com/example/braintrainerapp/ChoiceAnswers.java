package com.example.braintrainerapp;

import android.graphics.PorterDuff;
import android.view.View;

public class ChoiceAnswers {



    public Boolean OptionIsCorrectOrNot(View view,int CorrectAnswerLocation)
    {
        boolean value;

        if(view.getTag().toString().equals(String.valueOf(CorrectAnswerLocation))){

                value=true;
            }
            else
            {

                value=false;
            }
            return value;
    }

}
