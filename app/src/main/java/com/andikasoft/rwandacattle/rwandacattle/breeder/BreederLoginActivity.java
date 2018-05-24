package com.andikasoft.rwandacattle.rwandacattle.breeder;


import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.andikasoft.rwandacattle.rwandacattle.HelpActivity;
import com.andikasoft.rwandacattle.rwandacattle.Preferences.TokenPreferences;
import com.andikasoft.rwandacattle.rwandacattle.R;
import com.andikasoft.rwandacattle.rwandacattle.api_helper.Login;
import com.andikasoft.rwandacattle.rwandacattle.api_helper.Token;
import com.andikasoft.rwandacattle.rwandacattle.api_interface.BreederLogin;
import com.andikasoft.rwandacattle.rwandacattle.helper.DatabaseHelper;

import java.io.IOException;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class BreederLoginActivity extends AppCompatActivity{

    private Toolbar toolbar;
    EditText email;
    EditText password;
    private Button buttonLogin;
    private TextView linkRegister;

    private Retrofit.Builder builder = new Retrofit.Builder()
            .baseUrl("http://192.168.42.209:8000/api/")
            .addConverterFactory(GsonConverterFactory.create());
    private Retrofit retrofit = builder.build();
    private BreederLogin loginInterface = retrofit.create(BreederLogin.class);
    private static String token;

    private TokenPreferences tokenPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.breeder_login_activity);

        toolbar = (Toolbar) findViewById(R.id.app_bar);
        setSupportActionBar(toolbar);
        toolbar.setTitle("");
        //Enabling back button
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("");

        buttonLogin = findViewById(R.id.btnBreederLogin);
        linkRegister = findViewById(R.id.linkBreederRegister);

        tokenPreferences = new TokenPreferences(this);

        buttonLogin.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                email = findViewById(R.id.breeder_login_email);
                password = findViewById(R.id.breeder_login_password);
                String emailstr = email.getText().toString();
                String passwordstr = password.getText().toString();

                Login lg = new Login(emailstr,passwordstr);
                Call<Token> call = loginInterface.login(lg);
                call.enqueue(new Callback<Token>() {
                    @Override
                    public void onResponse(Call<Token> call, Response<Token> response) {
                        if (response.isSuccessful()){
                            token = response.body().getToken();
                            tokenPreferences.saveToken("Bearer "+token);
                            getUserProfile(tokenPreferences.getToken());
                        } else {
                            Toast.makeText(BreederLoginActivity.this, ""+response.message(), Toast.LENGTH_SHORT).show();
                        }
                    }

                    @Override
                    public void onFailure(Call<Token> call, Throwable t) {
                        Toast.makeText(BreederLoginActivity.this, "No internet", Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });

        linkRegister.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), BreederRegisterActivity.class));
            }
        });


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

    public void getUserProfile(String token){
        Call<ResponseBody> call = loginInterface.getSecret(token);

        call.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                if (response.isSuccessful()){
                    try {
                        Toast.makeText(BreederLoginActivity.this, response.body().string(), Toast.LENGTH_SHORT).show();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                } else {
                    Toast.makeText(BreederLoginActivity.this, ""+response.message(), Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                Toast.makeText(BreederLoginActivity.this, "No internet", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
