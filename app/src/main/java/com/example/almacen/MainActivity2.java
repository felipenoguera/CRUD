package com.example.almacen;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity2 extends AppCompatActivity implements View.OnClickListener {

    Button btnDelete, btnEdit;
    EditText etName, etPassword, etEmail, etPhone, etId;
@Override
    protected void oncreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        //ui
        initUI();
        btnDelete.setOnClickListener(this);
        btnEdit.setOnClickListener(this);

    }

    private void initUI() {
        //editext
        etName = findViewById(R.id.etName);
        etPassword = findViewById(R.id.etPassword);
        etEmail = findViewById(R.id.etEmail);
        etPhone = findViewById(R.id.etPhone);
        etId = findViewById(R.id.etId);
        //buttons
        btnDelete = findViewById(R.id.btnDelete);
        btnEdit = findViewById(R.id.btnEdit);

    }

    @Override
    public void onClick(View v) {
        int id = v.getId();

        if (id == R.id.btnEdit) {

        } else if (id == R.id.btnDelete) {

        }

    }
}