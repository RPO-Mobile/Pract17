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

        Intent intent = getIntent();
        if (intent != null) {
            et1.setText(intent.getStringExtra("et1"));
            et2.setText(intent.getStringExtra("et2"));
        }
    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent(this, Main.class);
        if (v ==  btnOk){
            intent.putExtra("et1", et1.getText().toString());
            intent.putExtra("et2", et2.getText().toString());
            startActivity(intent);
        } else if (v == btnCancel) {
            startActivity(intent);
        }
    }
}
