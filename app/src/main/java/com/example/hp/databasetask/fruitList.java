package com.example.hp.databasetask;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Base64;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.io.ByteArrayOutputStream;
import java.util.List;

public class fruitList extends Activity {

    TextView tv;
    RelativeLayout nested;
    FruitDbHelper dbhelper;
    ListView lv_fruits;
    List<Fruit> fruits;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fruit_list);

        dbhelper = new FruitDbHelper(this);
        lv_fruits = (ListView) findViewById(R.id.lv_items);
        tv = (TextView) findViewById(R.id.tv_title);
        nested = (RelativeLayout) findViewById(R.id.nestedlayout);

        String title = getIntent().getStringExtra("name");
        tv.setText(title);


        fruits = dbhelper.retreiveAll(title);
        Log.d("Size", fruits.size() + "");
        ArrayAdapter<Fruit> adapter = new customArrayAdapter(fruitList.this,android.R.layout.simple_list_item_1,fruits);
        lv_fruits.setAdapter(adapter);


        lv_fruits.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Fruit fruit = fruits.get(position);
                Intent intent = new Intent(fruitList.this,detail.class);
                intent.putExtra("fname",fruit.getFname());
                intent.putExtra("fpic",fruit.getFpic());
                intent.putExtra("fintro",fruit.getFintro());
                intent.putExtra("fdetail",fruit.getFdetail());
                startActivity(intent);
            }
        });


    }


}