package com.example.hp.databasetask;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends Activity {

    FruitDbHelper dbHelper;
    Button btn1,btn2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn1 = (Button) findViewById(R.id.button1);
        btn2 = (Button) findViewById(R.id.button2);
        dbHelper = new FruitDbHelper(MainActivity.this);
    }

    public void coldFruitsintent(View view) {
        Intent intent = new Intent(MainActivity.this,fruitList.class);
        intent.putExtra("name","cold fruit");
        startActivity(intent);
    }

    public void hotFruitsintent(View view) {

        Intent intent = new Intent(MainActivity.this,fruitList.class);
        intent.putExtra("name","hot fruit");
        startActivity(intent);
    }

    public void addNew(View view) {
        Intent intent = new Intent(MainActivity.this,addNew.class);
        startActivity(intent
        );
    }

    public void deleteRow(View view) {

        final Dialog d = new Dialog(MainActivity.this);
        d.requestWindowFeature(Window.FEATURE_NO_TITLE);
        d.setContentView(R.layout.customdialog);
        final EditText et = (EditText) d.findViewById(R.id.et_deleteName);
        Button btn_confirm = (Button) d.findViewById(R.id.btn_confirm);
        Button btn_cancel = (Button) d.findViewById(R.id.btn_cancel);
        d.show();
        btn_confirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                dbHelper.deleteRow(et.getText().toString());
                Toast.makeText(MainActivity.this, "Data deleted successfully...", Toast.LENGTH_SHORT).show();
                d.dismiss();
            }
        });
        btn_cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                d.dismiss();
            }
        });

    }
}
