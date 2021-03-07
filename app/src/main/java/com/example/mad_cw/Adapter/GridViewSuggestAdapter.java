package com.example.mad_cw.Adapter;

import android.content.Context;
import android.graphics.Color;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.GridView;

import com.example.mad_cw.Common.Common;
import com.example.mad_cw.HintsActivity;
import com.example.mad_cw.MainActivity;

import java.util.List;

public class GridViewSuggestAdapter extends BaseAdapter {

    private List<String> suggestSource;
    private Context context;
    private HintsActivity hintsActivity;


    public GridViewSuggestAdapter(List<String> suggestSource, Context applicationContext, HintsActivity hintsActivity) {
        this.suggestSource = suggestSource;
        this.context = context;
        this.hintsActivity = hintsActivity;
    }


    @Override
    public int getCount() {
        return suggestSource.size();
    }

    @Override
    public Object getItem(int position) {
        return suggestSource.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Button button;
        if(convertView ==null){
            if(suggestSource.get(position).equals("null")) {
                button = new Button(context);
                button.setLayoutParams(new ViewGroup.LayoutParams(85, 85));
                button.setPadding(0, 0, 0, 0);
                button.setBackgroundColor(Color.DKGRAY);
            }else{
                button = new Button(context);
                button.setLayoutParams(new ViewGroup.LayoutParams(85,85));
                button.setPadding(0,0,0,0);
                button.setBackgroundColor(Color.DKGRAY);
                button.setTextColor(Color.YELLOW);
                button.setText(suggestSource.get(position));
                button.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        //If correct answer contains character user selected
                        if(String.valueOf(hintsActivity.answer).contains(suggestSource.get(position))){
                            char compare = suggestSource.get(position).charAt(0);//Get char
                            for(int i = 0; i <hintsActivity.answer.length;i++){
                                if(compare == hintsActivity.answer[i])
                                    Common.user_submit_answer[i] = compare;
                            }

                            //Update UI
                            GridViewAnswerAdapter answerAdapter = new GridViewAnswerAdapter(Common.user_submit_answer,context);
                            hintsActivity.gridViewAnswer.setAdapter(answerAdapter);
                            answerAdapter.notifyDataSetChanged();

                            //Remove from suggest source
                            hintsActivity.suggestSource.set(position,"null");
                            hintsActivity.suggestAdapter = new GridViewSuggestAdapter(hintsActivity.suggestSource,context,hintsActivity);
                            hintsActivity.gridViewSuggest.setAdapter(hintsActivity.suggestAdapter);
                            hintsActivity.suggestAdapter.notifyDataSetChanged();
                        }
                        else{
                            //Remove from suggest source
                            hintsActivity.suggestSource.set(position,"null");
                            hintsActivity.suggestAdapter = new GridViewSuggestAdapter(hintsActivity.suggestSource,context,hintsActivity);
                            hintsActivity.gridViewSuggest.setAdapter(hintsActivity.suggestAdapter);
                            hintsActivity.suggestAdapter.notifyDataSetChanged();

                        }

                    }
                });


            }
        }else button =(Button)convertView;
        return button;
    }
}
