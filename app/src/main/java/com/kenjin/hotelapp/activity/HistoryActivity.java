package com.kenjin.hotelapp.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.kenjin.hotelapp.R;
import com.kenjin.hotelapp.adapter.PesananAdapter;
import com.kenjin.hotelapp.database.HotelDb;

import java.io.Serializable;

import static com.kenjin.hotelapp.activity.EditPesanan.EXTRAID;

public class HistoryActivity extends AppCompatActivity {
    private ListView lv;
    private HotelDb db;
    private PesananAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        db = HotelDb.getInstance(this);

        lv = (ListView) findViewById(R.id.listview_history);

        lv.setEmptyView(findViewById(R.id.empty));

        if (db.isContactHasData())
        {
            adapter = new PesananAdapter(this, db.getAllPesanan());
            lv.setAdapter(adapter);
        }
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent i = new Intent (getBaseContext(),EditPesanan.class);
                i.putExtra(EXTRAID, (Serializable) adapter.getItem(position));
                startActivity(i);
            }
        });
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() == android.R.id.home) {
            Log.e("Home pressed", "home presed");
            onBackPressed();
        }
        return super.onOptionsItemSelected(menuItem);
    }
}
