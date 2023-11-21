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

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_act);

        et1 = (EditText) findViewById(R.id.et1);
        et2 = (EditText) findViewById(R.id.et2);
        btnOpenSecondAct = (Button) findViewById(R.id.btnCallSecondAct);

        btnOpenSecondAct.setOnClickListener(this);
    }

    protected void onResume(){
        super.onResume();

        Intent intent = getIntent();
        if (intent != null){
            et1.setText(intent.getStringExtra("et1"));
            et2.setText(intent.getStringExtra("et2"));
        }
    }

    @Override
    public void onClick(View view) {
        Intent intent = new Intent(this, Second.class);
        intent.putExtra("et1", et1.getText().toString());
        intent.putExtra("et2", et2.getText().toString());
        startActivity(intent);
    }
}
