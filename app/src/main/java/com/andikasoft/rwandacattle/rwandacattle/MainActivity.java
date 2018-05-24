package com.andikasoft.rwandacattle.rwandacattle;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import com.andikasoft.rwandacattle.rwandacattle.breeder.BreederLoginActivity;
import com.andikasoft.rwandacattle.rwandacattle.helper.DatabaseHelper;
import com.andikasoft.rwandacattle.rwandacattle.veterinarian.VetLoginActivity;

public class MainActivity extends AppCompatActivity {
    TextView mTextView;
    Spinner mLanguage;
    ArrayAdapter<String> mAdapter;
    DatabaseHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        db = new  DatabaseHelper(this);

        Button breederButton = (Button) findViewById(R.id.breederButton);
        Button vetButton = (Button) findViewById(R.id.vetButton);

        breederButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendBreeder();
            }
        });


        vetButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendVet();
            }
        });


        mLanguage = (Spinner) findViewById(R.id.spLanguage);
        mTextView = (TextView) findViewById(R.id.textView);
        mAdapter = new ArrayAdapter<String>(MainActivity.this, android.R.layout.simple_spinner_dropdown_item, getResources().getStringArray(R.array.language_option));
        mLanguage.setAdapter(mAdapter);

        if (LocaleHelper.getLanguage(MainActivity.this).equalsIgnoreCase("en")) {
            mLanguage.setSelection(mAdapter.getPosition("English"));
        } else if (LocaleHelper.getLanguage(MainActivity.this).equalsIgnoreCase("fr")) {
            mLanguage.setSelection(mAdapter.getPosition("French"));
        } else {
            mLanguage.setSelection(mAdapter.getPosition("Kinyarwanda"));
        }

        mLanguage.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                Context context;
                Resources resources;
                switch (i) {
                    case 0:
                        context = LocaleHelper.setLocale(MainActivity.this, "en");
                        resources = context.getResources();
                        mTextView.setText(resources.getString(R.string.choose_job));
                        break;
                    case 1:
                        context = LocaleHelper.setLocale(MainActivity.this, "fr");
                        resources = context.getResources();
                        mTextView.setText(resources.getString(R.string.choose_job));
                        break;
                    case 2:
                        context = LocaleHelper.setLocale(MainActivity.this, "rw");
                        resources = context.getResources();
                        mTextView.setText(resources.getString(R.string.choose_job));
                        break;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }
    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(LocaleHelper.onAttach(newBase));
    }

    public void sendBreeder(){
        Intent intentobjct1 = new Intent(this, BreederLoginActivity.class);
        startActivity(intentobjct1);
    }

    public void sendVet(){
        Intent intentobjct2 = new Intent(this, VetLoginActivity.class);
        startActivity(intentobjct2);
    }

}
