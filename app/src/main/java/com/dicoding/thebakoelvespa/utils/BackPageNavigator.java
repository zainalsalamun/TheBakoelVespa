package com.dicoding.thebakoelvespa.utils;

import android.app.Activity;
import android.view.View;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;

public class BackPageNavigator {

    ImageButton imageButton;
    Activity act;

    public BackPageNavigator(AppCompatActivity activity, int id){
        imageButton = activity.findViewById(id);
        act = activity;
    }

    public void setActionNavBack(){
        imageButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {
                // TODO Auto-generated method stub
                // close database and back to previous page
                act.finish();
            }
        });
    }

}
