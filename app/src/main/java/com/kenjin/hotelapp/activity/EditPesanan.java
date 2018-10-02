package com.kenjin.hotelapp.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.kenjin.hotelapp.R;
import com.kenjin.hotelapp.database.HotelDb;
import com.kenjin.hotelapp.model.Pesanan;

public class EditPesanan extends AppCompatActivity {
    public static final String EXTRAID = "EXTRAID";
    private EditText nama, email, phone, lama;
    private Button cancel, done;
    private HotelDb db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.edit_pesanan);
        db = HotelDb.getInstance(this);

        nama = (EditText) findViewById(R.id.input_name);
        email = (EditText) findViewById(R.id.input_email);
        phone = (EditText) findViewById(R.id.input_phone);
        lama = (EditText) findViewById(R.id.input_lama);
        cancel = (Button) findViewById(R.id.btn_del);
        done = (Button) findViewById(R.id.btn_update);
        final Pesanan pesanan = (Pesanan) getIntent().getSerializableExtra(EXTRAID);


        done.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!getIntent().hasExtra(EXTRAID)) {
                    finish();
                    return;
                }
                if (pesanan==null) {
                    finish();
                    return;
                }
                pesanan.setNama(nama.getText().toString());
                pesanan.setEmail(email.getText().toString());
                pesanan.setNumber(phone.getText().toString());
                pesanan.setLamainap(lama.getText().toString());
                if (db.editPesanan(pesanan)) {
                    startActivity(new Intent(EditPesanan.this, HistoryActivity.class));
                    finish();
                } else {
                    Toast.makeText(EditPesanan.this, "Error On Order", Toast.LENGTH_SHORT)
                            .show();
                }
            }
        });
        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                db.deletePesanan(pesanan.getId());
                startActivity(new Intent(EditPesanan.this, HistoryActivity.class));
                finish();
            }

        });
    }

}
