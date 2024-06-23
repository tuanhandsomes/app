package com.example.appqunlsinhvin;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {


    Button btnmonhoc, btntacgia, btnthoat;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        btnmonhoc = findViewById(R.id.btnmonhoc);
        btntacgia = findViewById(R.id.btntacgia);
        btnthoat = findViewById(R.id.btnthoat);

        //Click tác giả
        btntacgia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Dialogtacgia();
            }
        });

        //Click môn học
        btnmonhoc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Chuyển qua activity Monhoc
                Intent intent = new Intent(MainActivity.this,ActivityMonhoc.class);
                startActivity(intent);
            }
        });
        //Click exit app
        btnthoat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Dialogthoat();
            }
        });
    }
    //Hàm hiển thị cửa sổ dialog thoát
    private void Dialogthoat() {
        Dialog dialog = new Dialog(this);

        dialog.setContentView(R.layout.dialogthoat);

        //Tắt click ngoài là thoát
        dialog.setCanceledOnTouchOutside(false);

        Button btnco = dialog.findViewById(R.id.btnco);
        Button btnkhong = dialog.findViewById(R.id.btnkhong);

        btnco.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, MainActivity.class);
                startActivity(intent);

                //Thoát
                Intent intent1 = new Intent(Intent.ACTION_MAIN);
                intent1.addCategory(Intent.CATEGORY_HOME);
                startActivity(intent1);
            }
        });

        //Nếu click không thì đóng cửa sổ
        btnkhong.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.cancel();
            }
        });

        //show dialog
        dialog.show();
    }

    //Hiển thị thông tin tác giả
    private void Dialogtacgia() {
        // Tạo đối tượng cửa sổ dialog
        Dialog dialog = new Dialog(this);

        //Nạp layout vào dialog
        dialog.setContentView(R.layout.dialoginformation);
        dialog.show();
    }

}