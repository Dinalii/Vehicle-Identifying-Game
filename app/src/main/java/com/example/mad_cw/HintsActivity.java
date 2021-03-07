package com.example.mad_cw;


import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.mad_cw.Adapter.GridViewAnswerAdapter;
import com.example.mad_cw.Adapter.GridViewSuggestAdapter;
import com.example.mad_cw.Common.Common;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class HintsActivity extends AppCompatActivity {

    public List<String> suggestSource = new ArrayList<>();
    public GridViewAnswerAdapter answerAdapter;
    public GridViewSuggestAdapter suggestAdapter;
    public Button submitBtn;
    public GridView gridViewAnswer;
    public GridView gridViewSuggest;
    public ImageView imageViewQuestion;
    public char[] answer;
    String correct_answer;
    int[] image_list = {R.drawable.audi_1, R.drawable.audi_2, R.drawable.audi_3, R.drawable.audi_4, R.drawable.audi_5, R.drawable.audi_6, R.drawable.audi_7, R.drawable.audi_8, R.drawable.audi_9, R.drawable.audi_10,
            R.drawable.benz_1, R.drawable.benz_2, R.drawable.benz_3, R.drawable.benz_4, R.drawable.benz_5, R.drawable.benz_6, R.drawable.benz_7, R.drawable.benz_8, R.drawable.benz_9, R.drawable.benz_10,
            R.drawable.bmw_1, R.drawable.bmw_2, R.drawable.bmw_3, R.drawable.bmw_4, R.drawable.bmw_5, R.drawable.bmw_6, R.drawable.bmw_7, R.drawable.bmw_8, R.drawable.bmw_9, R.drawable.bmw_10,
            R.drawable.honda_1, R.drawable.honda_2, R.drawable.honda_3, R.drawable.honda_4, R.drawable.honda_5, R.drawable.honda_6, R.drawable.honda_7, R.drawable.honda_8, R.drawable.honda_9, R.drawable.honda_10,
            R.drawable.kia_1, R.drawable.kia_2, R.drawable.kia_3, R.drawable.kia_4, R.drawable.kia_5, R.drawable.kia_6, R.drawable.kia_7, R.drawable.kia_8, R.drawable.kia_9, R.drawable.kia_10,
            R.drawable.lex_1, R.drawable.lex_2, R.drawable.lex_3, R.drawable.lex_4, R.drawable.lex_5, R.drawable.lex_6, R.drawable.lex_7, R.drawable.lex_8, R.drawable.lex_9, R.drawable.lex_10,
            R.drawable.maz_1, R.drawable.maz_2, R.drawable.maz_3, R.drawable.maz_4, R.drawable.maz_5, R.drawable.maz_6, R.drawable.maz_7, R.drawable.maz_8, R.drawable.maz_9, R.drawable.maz_10,
            R.drawable.sko_1, R.drawable.sko_2, R.drawable.sko_3, R.drawable.sko_4, R.drawable.sko_5, R.drawable.sko_6, R.drawable.sko_7, R.drawable.sko_8, R.drawable.sko_9, R.drawable.sko_10,
            R.drawable.suba_1, R.drawable.suba_2, R.drawable.suba_3, R.drawable.suba_4, R.drawable.suba_5, R.drawable.suba_6, R.drawable.suba_7, R.drawable.suba_8, R.drawable.suba_9, R.drawable.suba_10,
            R.drawable.toyo_1, R.drawable.toyo_2, R.drawable.toyo_3, R.drawable.toyo_4, R.drawable.toyo_5, R.drawable.toyo_6, R.drawable.toyo_7, R.drawable.toyo_8, R.drawable.toyo_9, R.drawable.toyo_10,
            R.drawable.vol_1, R.drawable.vol_2, R.drawable.vol_3, R.drawable.vol_4, R.drawable.vol_5, R.drawable.vol_6, R.drawable.vol_7, R.drawable.vol_8, R.drawable.vol_9, R.drawable.vol_10};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hints);

        initView();
    }

    private void initView() {
        gridViewAnswer = (GridView) findViewById(R.id.gridViewAnswer);
        gridViewSuggest = (GridView) findViewById(R.id.gridViewSuggestion);
        imageViewQuestion = (ImageView) findViewById(R.id.hint_image);

        //Add SetupList
        setupList();

        submitBtn = (Button) findViewById(R.id.submit_btn);
        submitBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
        String result = "";

        for (int i = 0; i < Common.user_submit_answer.length; i++)
        result += String.valueOf(Common.user_submit_answer[i]);
        if (result.equals(correct_answer)) {

            Toast.makeText(getApplicationContext(),"Finish!"+result,Toast.LENGTH_SHORT).show();

            //Reset
            Common.count = 0;
            Common.user_submit_answer = new char[correct_answer.length()];

            //Set Adapter
            GridViewAnswerAdapter answerAdapter = new GridViewAnswerAdapter(setupNullList(), getApplicationContext());
            gridViewAnswer.setAdapter(answerAdapter);
            answerAdapter.notifyDataSetChanged();

            GridViewSuggestAdapter suggestAdapter = new GridViewSuggestAdapter(suggestSource,getApplicationContext(),HintsActivity.this);
            gridViewSuggest.setAdapter(suggestAdapter);
            suggestAdapter.notifyDataSetChanged();

            setupList();

        }else{
            Toast.makeText(HintsActivity.this,"Incorrect",Toast.LENGTH_SHORT).show();


        }
    }

});


        }

private void setupList(){
        //Random car
    Random random = new Random();
    int imageSelected = image_list[random.nextInt(image_list.length)];
    imageViewQuestion.setImageResource(imageSelected);

    correct_answer = getResources().getResourceName(imageSelected);
    correct_answer = correct_answer.substring(correct_answer.lastIndexOf("/")+1);
    answer = correct_answer.toCharArray();

    Common.user_submit_answer = new char[answer.length];

    //Add Answer character to list
    suggestSource.clear();
    for(char item:answer){
        //Add car make to the list
        suggestSource.add(String.valueOf(item));
    }

    //Randomly add some characters to list
    for(int i = answer.length;i<answer.length*2;i++)
        suggestSource.add(Common.alphabet_character[random.nextInt(Common.alphabet_character.length)]);

    //Sort random
    Collections.shuffle(suggestSource);

    //Set for GridView
    answerAdapter =  new GridViewAnswerAdapter(setupNullList(),this);
    suggestAdapter = new GridViewSuggestAdapter(suggestSource,this,this);

    answerAdapter.notifyDataSetChanged();
    suggestAdapter.notifyDataSetChanged();

    gridViewSuggest.setAdapter(suggestAdapter);
    gridViewAnswer.setAdapter(answerAdapter);

}

private char[] setupNullList(){
        char result[] = new char[answer.length];
        for(int i =0;i<answer.length;i++)
            result[i]=' ';
        return result;

}

}
