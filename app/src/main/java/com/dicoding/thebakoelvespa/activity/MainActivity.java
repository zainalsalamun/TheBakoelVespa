package com.dicoding.thebakoelvespa.activity;

import android.content.Intent;
import android.os.Bundle;

import com.dicoding.thebakoelvespa.R;
import com.dicoding.thebakoelvespa.adapter.VespaAdapter;
import com.dicoding.thebakoelvespa.entity.VespaModel;

import android.view.View;

import androidx.core.view.GravityCompat;
import androidx.appcompat.app.ActionBarDrawerToggle;

import android.view.MenuItem;

import com.google.android.material.navigation.NavigationView;

import androidx.drawerlayout.widget.DrawerLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.Menu;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by zainalsalamun on 03/09/2019.
 */

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    String[][] data = new String[][]{
            {
                    "Vespa, BTS 150,I-GET ABS, 2017",
                    "https://www.vespa.com/dam/jcr:886e6ea5-ddb3-4859-88d4-55d56948b875/TopBanner.jpg","Rp. 34 Juta", "Jakarta Selatan"
            },
            {
                    "Vespa, 150, I-GET ABS, 2018",
                    "https://bd.gaadicdn.com/processedimages/piaggio/piaggio-vespa-125/source/v_piaggio-vespa-125-std1530859339.jpg","Rp. 33 Juta", "Jakarta Selatan"
            },
            {
                    "VESPA, VESPA S 125 I-GET, 2019",
                    "https://ecs7.tokopedia.net/img/cache/700/product-1/2017/11/24/24482425/24482425_284f1148-fa8a-41a1-94be-6c0ebc132f0a.jpg", "Rp. 44 Juta","Jakarta Timur"
            },
            {
                    "Vespa, VESPA LX 125 I-GET GIALLO LIME, 2017",
                    "https://ecs7.tokopedia.net/img/cache/700/product-1/2018/10/3/41192869/41192869_1b397083-fa9a-4199-b521-e17dc27ecf04_2048_2048.jpg","Rp. 27 Juta", "Jakarta Barat"
            },
            {
                    "Vespa, VESPA SPRINT I-GET 150 GRIGIO TITANIO, 2019",
                    "https://ecs7.tokopedia.net/img/cache/700/product-1/2018/10/11/41192869/41192869_92a8cc94-dd95-44c0-bb3d-e0d7046649c7_1182_1182.jpg","Rp. 44 Juta", "Tangerang"
            },
            {
                    "Vespa, BTS 150,I-GET ABS, 2017",
                    "https://ecs7.tokopedia.net/img/cache/700/product-1/2017/11/24/24482425/24482425_284f1148-fa8a-41a1-94be-6c0ebc132f0a.jpg ","Rp. 33 Juta", "Tangerang"
            },
            {
                    "Vespa, BTS 150,I-GET ABS, 2017",
                    "https://ecs7.tokopedia.net/img/cache/700/product-1/2018/10/11/41192869/41192869_92a8cc94-dd95-44c0-bb3d-e0d7046649c7_1182_1182.jpg","35 Juta", "Tangerang"
            },
            {
                    "Vespa, 150, I-GET ABS, 2018",
                    "https://bd.gaadicdn.com/processedimages/piaggio/piaggio-vespa-125/source/v_piaggio-vespa-125-std1530859339.jpg","Rp. 33 Juta", "Jakarta Selatan"
            },
            {
                    "Vespa, VESPA LX 125 I-GET GIALLO LIME, 2017",
                    "https://ecs7.tokopedia.net/img/cache/700/product-1/2018/10/3/41192869/41192869_1b397083-fa9a-4199-b521-e17dc27ecf04_2048_2048.jpg","Rp. 27 Juta", "Jakarta Barat"
            },
            {
                    "Vespa, BTS 150,I-GET ABS, 2017",
                    "https://www.vespa.com/dam/jcr:886e6ea5-ddb3-4859-88d4-55d56948b875/TopBanner.jpg","Rp. 34 Juta", "Jakarta Selatan"
            }
    };

    private ListView lvItem;
    private ArrayList listItem;
    private ArrayList<VespaModel>list;
    private TextView txtShare;
    private Button btnShare;
    private VespaModel item;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
        navigationView.setNavigationItemSelectedListener(this);


        lvItem = findViewById(R.id.lv_item);
        listItem = new ArrayList<>();


        VespaModel vespa = null;

        for (int i = 0 ; i < data.length ; i++) {
            vespa = new VespaModel();
            vespa.setTitle(data[i][0]);
            vespa.setImage(data[i][1]);
            vespa.setHarga(data[i][2]);
            vespa.setLokasi(data[i][3]);

            listItem.add(vespa);
        }

        VespaAdapter adapter = new VespaAdapter(MainActivity.this, listItem);
        lvItem.setAdapter(adapter);

        lvItem.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                VespaModel mbl = (VespaModel) listItem.get(position);

                Intent intent = new Intent(MainActivity.this, DetailVespaActivity.class);
                intent.putExtra(DetailVespaActivity.KEY_ITEM, mbl);
                startActivityForResult(intent, 0);

            }
        });

    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            Intent intent = new Intent(getApplication(), AboutActivity.class);
            startActivity(intent);
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_home) {
            // Handle the camera action
        } else if (id == R.id.nav_gallery) {

        } else if (id == R.id.nav_slideshow) {

        } else if (id == R.id.nav_tools) {

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}

