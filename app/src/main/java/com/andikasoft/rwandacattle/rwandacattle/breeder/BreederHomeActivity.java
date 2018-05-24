package com.andikasoft.rwandacattle.rwandacattle.breeder;


import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import android.widget.Toast;

import com.andikasoft.rwandacattle.rwandacattle.HelpActivity;
import com.andikasoft.rwandacattle.rwandacattle.R;


public class BreederHomeActivity extends AppCompatActivity {
    DrawerLayout drawerLayout;
    private Toolbar toolbar;
    ActionBarDrawerToggle actionBarDrawerToggle;
    FragmentTransaction fragmentTransaction;
    NavigationView navigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.breeder_home_activity);

        toolbar = (Toolbar) findViewById(R.id.app_bar);
        setSupportActionBar(toolbar);

        //Enabling back button
        getSupportActionBar().setDisplayShowTitleEnabled(false);

        toolbar.setTitle("");

        drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);

        actionBarDrawerToggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.drawer_open, R.string.drawer_close);

        drawerLayout.setDrawerListener(actionBarDrawerToggle);


        fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.breeder_main_container, new BreederInboxFragment());
        fragmentTransaction.commit();


        navigationView = (NavigationView) findViewById(R.id.breeder_navigation_view);

        View view = navigationView.getHeaderView(0);
        TextView myProfile = view.findViewById(R.id.breeder_profile_id);
        myProfile.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Fragment someFragment = new BreederViewProfileFragment();
                fragmentTransaction = getSupportFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.breeder_main_container,someFragment); // give your fragment container id in first parameter
                fragmentTransaction.addToBackStack(null);  // if written, this transaction will be added to backstack
                fragmentTransaction.commit();
                drawerLayout.closeDrawers();
            }
        });



        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.breeder_inbox_id:
                        fragmentTransaction = getSupportFragmentManager().beginTransaction();
                        fragmentTransaction.replace(R.id.breeder_main_container, new BreederInboxFragment());
                        fragmentTransaction.commit();
                        item.setChecked(true);
                        drawerLayout.closeDrawers();
                        break;

                    case R.id.view_animals_id:
                        fragmentTransaction = getSupportFragmentManager().beginTransaction();
                        fragmentTransaction.replace(R.id.breeder_main_container, new BreederViewAnimalsFragment());
                        fragmentTransaction.commit();
                        item.setChecked(true);
                        drawerLayout.closeDrawers();
                        break;

                    case R.id.view_veterinarians_id:
                        fragmentTransaction = getSupportFragmentManager().beginTransaction();
                        fragmentTransaction.replace(R.id.breeder_main_container, new BreederViewVetsFragment());
                        fragmentTransaction.commit();
                        item.setChecked(true);
                        drawerLayout.closeDrawers();
                        break;

                    case R.id.breeder_update_profile_id:
                        fragmentTransaction = getSupportFragmentManager().beginTransaction();
                        fragmentTransaction.replace(R.id.breeder_main_container, new BreederUpdateProfileFragment());
                        fragmentTransaction.commit();
                        item.setChecked(true);
                        drawerLayout.closeDrawers();
                        break;
                }
                return false;
            }
        });
    }

    @Override
    protected void onPostCreate(@Nullable Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        actionBarDrawerToggle.syncState();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.home_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menuHelp:
                startActivity(new Intent(this, HelpActivity.class));
                break;
            case R.id.menuLogout:
                Toast.makeText(this, "You clicked logout", Toast.LENGTH_LONG).show();
                break;
        }
        return true;
    }
}
