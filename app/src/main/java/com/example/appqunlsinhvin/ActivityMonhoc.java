package com.example.appqunlsinhvin;

import android.database.Cursor;
import android.os.Bundle;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.appqunlsinhvin.adapter.adaptermonhoc;
import com.example.appqunlsinhvin.database.database;
import com.example.appqunlsinhvin.model.Monhoc;

import java.util.ArrayList;

public class ActivityMonhoc extends AppCompatActivity {

    Toolbar toolbar;
    ListView listViewmonhoc;
    ArrayList<Monhoc> ArrayListMonhoc;
    com.example.appqunlsinhvin.database.database database;
    com.example.appqunlsinhvin.adapter.adaptermonhoc adaptermonhoc;
    int count = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_monhoc);

        toolbar = findViewById(R.id.toolbarMonhoc);
        listViewmonhoc = findViewById(R.id.listviewMonhoc);

        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        database = new database(this);

        ArrayListMonhoc = new ArrayList<>();

        Cursor cursor = database.getDataMonhoc();
        while (cursor.moveToNext()){

            int id = cursor.getInt(0);
            String tenmonhoc = cursor.getString(1);
            int sotinchi = cursor.getInt(2);
            String timeHoc = cursor.getString(3);
            String diaDiem = cursor.getString(4);

            ArrayListMonhoc.add(new Monhoc(id, tenmonhoc,sotinchi,timeHoc,diaDiem));
        }

        adaptermonhoc = new adaptermonhoc(ActivityMonhoc.this, ArrayListMonhoc);
        listViewmonhoc.setAdapter(adaptermonhoc);
        cursor.moveToFirst();
        cursor.close();
    }
    
}