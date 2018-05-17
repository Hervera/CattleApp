package com.andikasoft.rwandacattle.rwandacattle;


import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;


public class VetLoginActivity extends AppCompatActivity implements View.OnClickListener{

    private Toolbar toolbar;
    private Button buttonLogin;
    private TextView linkRegister;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.vet_login_activity);

        toolbar = (Toolbar) findViewById(R.id.app_bar);
        setSupportActionBar(toolbar);
        toolbar.setTitle("");
        //Enabling back button
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("");

        buttonLogin = (Button) findViewById(R.id.btnVetLogin);
        linkRegister = (TextView) findViewById(R.id.linkVetRegister);

        buttonLogin.setOnClickListener(this);
        linkRegister.setOnClickListener(this);
    }


    @Override
    public void onClick(View view) {
        if (view == buttonLogin) {
            startActivity(new Intent(this, VetHomeActivity.class));
        }
        if (view == linkRegister){
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
                onBackPressed();
                break;
        }
        return true;
    }
}
