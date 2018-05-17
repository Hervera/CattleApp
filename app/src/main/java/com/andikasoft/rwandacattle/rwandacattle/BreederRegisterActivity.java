package com.andikasoft.rwandacattle.rwandacattle;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class BreederRegisterActivity extends AppCompatActivity implements View.OnClickListener{

    private Toolbar toolbar;
    private EditText editTextUsername, editTextPassword;
    private TextView linkLogin;
    private Button btnRegister;
    private ProgressDialog progressDialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.breeder_register_activity);

        toolbar = (Toolbar) findViewById(R.id.app_bar);
        setSupportActionBar(toolbar);
        toolbar.setTitle("");
        //Enabling back button
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("");

        btnRegister = (Button) findViewById(R.id.btnBreederRegister);
        linkLogin = (TextView) findViewById(R.id.linkBreederLogin);

        btnRegister.setOnClickListener(this);
        linkLogin.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        if (view == btnRegister){
            Toast.makeText(this, "You clicked Register", Toast.LENGTH_LONG).show();
        }
        if (view == linkLogin) {
            startActivity(new Intent(this, VetRegisterActivity.class));
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch(item.getItemId()){
            case android.R.id.home:
                onBackPressed();
                break;
            case R.id.mainHelp:
                startActivity(new Intent(this, HelpActivity.class));
                break;
            case R.id.mainHome:
                startActivity(new Intent(this, MainActivity.class));
                break;
        }
        return true;
    }
}
