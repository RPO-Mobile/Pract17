package com.example.pract14;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class Main extends AppCompatActivity implements View.OnClickListener {
    EditText et1, et2;
    Button btnOpenSecondAct;

     MyApp app;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_act);

        et1 = (EditText) findViewById(R.id.et1);
        et2 = (EditText) findViewById(R.id.et2);
        btnOpenSecondAct = (Button) findViewById(R.id.btnCallSecondAct);

        btnOpenSecondAct.setOnClickListener(this);

        app = (MyApp) getApplicationContext();
        app.setStr1(getString(R.string.str1));
        app.setStr2(getString(R.string.str2));
    }

    @Override
    protected void onStart() {
        super.onStart();

        et1.setText(app.getStr1().toString());
        et2.setText(app.getStr2().toString());
    }


    @Override
    public void onClick(View view) {
        app.setStr1(et1.getText().toString());
        app.setStr2(et2.getText().toString());
        Intent intent = new Intent(this, Second.class);
        startActivity(intent);
    }
}
