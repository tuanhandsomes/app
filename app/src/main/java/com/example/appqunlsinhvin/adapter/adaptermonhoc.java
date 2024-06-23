package com.example.appqunlsinhvin.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.appqunlsinhvin.ActivityMonhoc;
import com.example.appqunlsinhvin.R;
import com.example.appqunlsinhvin.model.Monhoc;

import java.util.ArrayList;

public class adaptermonhoc extends BaseAdapter {

    private ActivityMonhoc context;

    private ArrayList<Monhoc> ArrayListMonhoc;

    public adaptermonhoc(ActivityMonhoc context, ArrayList<Monhoc> arrayListMonhoc) {
        this.context = context;
        ArrayListMonhoc = arrayListMonhoc;
    }

    @Override
    public int getCount() {
        return ArrayListMonhoc.size();
    }

    @Override
    public Object getItem(int i) {

        return ArrayListMonhoc.get(i);
    }

    @Override
    public long getItemId(int i) {

        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        view = inflater.inflate(R.layout.listmonhoc,null);

        TextView TextViewtenmonhoc = view.findViewById(R.id.Textview_tenmonhoc);

        TextView TextViewsotinchi = view.findViewById(R.id.Textview_sotinchi);

        ImageButton imageDelete = view.findViewById(R.id.deletemonhoc);

        ImageButton imagethongtin = view.findViewById(R.id.thongtinmonhoc);

        ImageButton imageUpdate = view.findViewById(R.id.updatemonhoc);

        Monhoc monhoc = ArrayListMonhoc.get(i);

        TextViewsotinchi.setText(monhoc.getSoTinChi());

        TextViewtenmonhoc.setText(monhoc.getTenMonhoc());

        int id = monhoc.getId();

        imagethongtin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        imageDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

       imageUpdate.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {

           }
       });

        return null;
    }
}
