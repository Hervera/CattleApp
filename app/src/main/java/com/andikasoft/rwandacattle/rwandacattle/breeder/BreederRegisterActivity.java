package com.andikasoft.rwandacattle.rwandacattle.breeder;

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
import android.view.View.OnClickListener;
import android.widget.Toast;

import com.andikasoft.rwandacattle.rwandacattle.HelpActivity;
import com.andikasoft.rwandacattle.rwandacattle.MainActivity;
import com.andikasoft.rwandacattle.rwandacattle.R;
import com.andikasoft.rwandacattle.rwandacattle.api_helper.Login;
import com.andikasoft.rwandacattle.rwandacattle.api_helper.Register;
import com.andikasoft.rwandacattle.rwandacattle.api_helper.Token;
import com.andikasoft.rwandacattle.rwandacattle.api_interface.BreederLogin;
import com.andikasoft.rwandacattle.rwandacattle.api_interface.BreederRegister;
import com.andikasoft.rwandacattle.rwandacattle.api_interface.UserProfileInterface;
import com.andikasoft.rwandacattle.rwandacattle.helper.DatabaseHelper;
import com.andikasoft.rwandacattle.rwandacattle.model.User;
import com.andikasoft.rwandacattle.rwandacattle.veterinarian.VetRegisterActivity;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class BreederRegisterActivity extends AppCompatActivity {

    private Toolbar toolbar;
    EditText name;
    EditText email;
    EditText phone;
    EditText password;
    EditText confirm_password;
    private TextView linkLogin;
    private Button btnRegister;

    private Retrofit.Builder builder = new Retrofit.Builder()
            .baseUrl("http://192.168.42.209:8000/api/")
            .addConverterFactory(GsonConverterFactory.create());
    private Retrofit retrofit = builder.build();
    private BreederRegister registerInterface = retrofit.create(BreederRegister.class);
    private UserProfileInterface userProfileInterface = retrofit.create(UserProfileInterface.class);
    private static String token;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.breeder_register_activity);

        toolbar = findViewById(R.id.app_bar);
        setSupportActionBar(toolbar);
        toolbar.setTitle("");
        //Enabling back button
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("");

        btnRegister = findViewById(R.id.btnBreederRegister);
        linkLogin = findViewById(R.id.linkBreederLogin);

        btnRegister.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                name = findViewById(R.id.breeder_name);
                email = findViewById(R.id.breeder_email);
                phone = findViewById(R.id.breeder_phone_number);
                password = findViewById(R.id.breeder_password);
                confirm_password = findViewById(R.id.breeder_confirm_password);

                String namestr = name.getText().toString();
                String emailstr = email.getText().toString();
                String phonestr = phone.getText().toString();
                String passwordstr = password.getText().toString();
                String confirm_passwordstr = confirm_password.getText().toString();

                Register rgstr = new Register(namestr,emailstr,phonestr,passwordstr, confirm_passwordstr);
                Call<Token> call = registerInterface.register(rgstr);
                call.enqueue(new Callback<Token>() {
                    @Override
                    public void onResponse(Call<Token> call, Response<Token> response) {
                        if (response.isSuccessful()){
                            Toast.makeText(BreederRegisterActivity.this, response.body().getToken(), Toast.LENGTH_SHORT).show();
                            token = response.body().getToken();

                            getUserProfile(token);
                        } else {
                            Toast.makeText(BreederRegisterActivity.this, ""+response.message(), Toast.LENGTH_SHORT).show();
                        }
                    }

                    @Override
                    public void onFailure(Call<Token> call, Throwable t) {
                        Toast.makeText(BreederRegisterActivity.this, "No internet", Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });

        linkLogin.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), VetRegisterActivity.class));
            }
        });
    }

    private void getUserProfile(String token) {
        Call<User> userCall = userProfileInterface.getUserProfile("Bearer "+token);

        userCall.enqueue(new Callback<User>() {
            @Override
            public void onResponse(Call<User> call, Response<User> response) {
                if (response.isSuccessful()){
                    User user = response.body();
                    Toast.makeText(BreederRegisterActivity.this, ""+user.getName(), Toast.LENGTH_SHORT).show();
//                    startActivity(new Intent(getApplicationContext(), BreederHomeActivity.class));
                } else {
                    Toast.makeText(BreederRegisterActivity.this, "Failed to get user details", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<User> call, Throwable t) {
                Toast.makeText(BreederRegisterActivity.this, "Network problem", Toast.LENGTH_SHORT).show();
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
        switch (item.getItemId()) {
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
