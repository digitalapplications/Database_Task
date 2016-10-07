package com.example.hp.databasetask;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Base64;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class detail extends Activity {

    TextView tv_fruitname,tv_intro,tv_detail;
    ImageView iv_detailFruitName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        tv_fruitname = (TextView) findViewById(R.id.fruitname);
        tv_intro = (TextView) findViewById(R.id.tv_intro);
        tv_detail = (TextView) findViewById(R.id.tv_detail);
        iv_detailFruitName = (ImageView) findViewById(R.id.detail_pic);

        String name = getIntent().getStringExtra("fname");
        String fintro = getIntent().getStringExtra("fintro");
        String fdetail = getIntent().getStringExtra("fdetail");
        String fpic = getIntent().getStringExtra("fpic");

       final byte[] decodedString = Base64.decode(fpic, Base64.DEFAULT);
        Bitmap decodedByte = BitmapFactory.decodeByteArray(decodedString, 0, decodedString.length);
        iv_detailFruitName.setImageBitmap(decodedByte);

        tv_fruitname.setText(name);
        tv_detail.setText(fdetail);
        tv_intro.setText(fintro);
    }

}
