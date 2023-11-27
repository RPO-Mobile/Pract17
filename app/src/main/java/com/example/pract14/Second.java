package com.example.pract14;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class Second extends AppCompatActivity implements View.OnClickListener {

    EditText et1, et2;
    Button btnOk, btnCancel;

    MyApp myApp;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second_act);

        et1 = (EditText) findViewById(R.id.et3);
        et2 = (EditText) findViewById(R.id.et4);
        btnOk = (Button) findViewById(R.id.btnOk);
        btnCancel = (Button) findViewById(R.id.btnCancel);

        btnOk.setOnClickListener(this);
        btnCancel.setOnClickListener(this);

        myApp = (MyApp) getApplicationContext();
        et1.setText(myApp.getStr1());
        et2.setText(myApp.getStr2());
    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent(this, Main.class);
        if (v ==  btnOk){
            myApp.setStr1(et1.getText().toString());
            myApp.setStr2(et2.getText().toString());
            finish();
        } else if (v == btnCancel) {
            finish();
        }
    }
}
