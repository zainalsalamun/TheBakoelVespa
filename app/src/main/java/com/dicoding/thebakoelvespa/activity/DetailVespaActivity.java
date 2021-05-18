package com.dicoding.thebakoelvespa.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.dicoding.thebakoelvespa.R;
import com.dicoding.thebakoelvespa.entity.VespaModel;
import com.squareup.picasso.Picasso;

/**
 * Created by zainalsalamun on 03/09/2019.
 */

public class DetailVespaActivity extends AppCompatActivity {

    public static String KEY_ITEM = "item";

    private VespaModel item;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_vespa);

        getSupportActionBar().setTitle("DETAIL VESPA");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        ImageView imgDetail = findViewById(R.id.img_detail);
        TextView txtHarga = findViewById(R.id.txt_item_harga);
        TextView txtTitle = findViewById(R.id.txt_item_title);
        TextView txtlokasi = findViewById(R.id.txt_item_lokasi);

        item = (VespaModel) getIntent().getSerializableExtra(KEY_ITEM);

        Picasso.with(DetailVespaActivity.this)
                .load(item.getImage())
                .placeholder(R.drawable.placeholder)
                .error(R.drawable.error)
                .into(imgDetail);
        txtHarga.setText((item.getHarga()));
        txtTitle.setText(item.getTitle());
        txtlokasi.setText(item.getLokasi());
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_detail_vespa, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if(id == R.id.action_share) {
            share();
            return true;
        }

        if(id == android.R.id.home) {
            finish();
        }

        return super.onOptionsItemSelected(item);
    }

    public void share() {
        Intent sendIntent = new Intent();
        sendIntent.setAction(Intent.ACTION_SEND);
        sendIntent.putExtra(Intent.EXTRA_TEXT, item.getTitle() + " " + item.getHarga() + " " + item.getLokasi());
        sendIntent.putExtra(Intent.EXTRA_TITLE, "Jual Vespa Murah");
        sendIntent.setType("text/plain");
        startActivity(sendIntent);
    }
}
