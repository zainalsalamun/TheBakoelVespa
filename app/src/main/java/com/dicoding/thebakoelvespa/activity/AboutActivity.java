package com.dicoding.thebakoelvespa.activity;

import android.os.Bundle;


import com.dicoding.thebakoelvespa.R;
import com.dicoding.thebakoelvespa.utils.BackPageNavigator;

import androidx.appcompat.app.AppCompatActivity;
import android.view.MenuItem;

public class AboutActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.about);
        new BackPageNavigator(this, R.id.imgNavBack).setActionNavBack();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if(id == android.R.id.home) {
            finish();
        }

        return super.onOptionsItemSelected(item);
    }

}
