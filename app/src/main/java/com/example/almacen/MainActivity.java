package com.example.almacen;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;


import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.HashMap;
import java.util.Map;

public abstract class MainActivity extends AppCompatActivity implements View.OnClickListener {
    EditText etName, etPassword, etEmail, etPhone, etId;
    Button btnCreate, btnFetch;
    RequestQueue requestQueue;
    private static final String URL1 = "http://186.168.152.220/crud/save.php";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        requestQueue = Volley.newRequestQueue(this);

        initUI();
        btnCreate.setOnClickListener(this);
        btnFetch.setOnClickListener(this);


    }

    private void initUI() {
        //editartexto
        etName = findViewById(R.id.etName);
        etPassword = findViewById(R.id.etPassword);
        etEmail = findViewById(R.id.etEmail);
        etPhone = findViewById(R.id.etPhone);
        etId = findViewById(R.id.etId);
        //buttons
        btnCreate = findViewById(R.id.btnCreate);
        btnFetch = findViewById(R.id.btnFrench);
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();


        if (id == R.id.btnCreate) {
            String name = etName.getText().toString().trim();
            String email = etEmail.getText().toString().trim();
            String password = etPassword.getText().toString().trim();
            String phone = etPhone.getText().toString().trim();

            createuser(name, email, password, phone);


        } else if (id == R.id.btnFrench) {

        }
    }

    private void createuser(final String name,final String email,final String password,final String phone) {

        StringRequest stringRequest = new StringRequest(
                Request.Method.POST,
                URL1,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Toast.makeText(MainActivity.this, "correct", Toast.LENGTH_SHORT).show();
                    }

                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                    }
                }
        ){
            @Nullable
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String>params = new HashMap<>();
                params.put("name",name);
                params.put("email",email);
                params.put("password",password);
                params.put("phone",phone);
                return params;
            }
        };

        requestQueue.add(stringRequest);
    }

}