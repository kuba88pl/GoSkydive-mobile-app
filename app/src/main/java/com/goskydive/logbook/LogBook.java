package com.goskydive.logbook;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.navigation.NavigationView;
import com.google.firebase.Firebase;
import com.google.firebase.auth.FirebaseAuth;
import com.goskydive.Alerts;
import com.goskydive.Friends;
import com.goskydive.Login;
import com.goskydive.MainActivity;
import com.goskydive.Messages;
import com.goskydive.R;
import com.goskydive.Settings;
import com.goskydive.Weather;

public class LogBook extends AppCompatActivity {

    private RecyclerView recyclerView;
    private RecyclerViewAdapter adapter;
    private FirebaseAuth fAuth;
    private String userId;

    Toolbar toolbar;
    NavigationView navigationView;
    DrawerLayout drawerLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_log_book);

        fAuth = FirebaseAuth.getInstance();
        if (fAuth != null) {
            userId = fAuth.getCurrentUser().getUid();
        } else {
            Log.e("Logbook", "User is not logged in");
            return;
        }

        toolbar = findViewById(R.id.toolbar);
        navigationView = findViewById(R.id.navigation_view);
        drawerLayout = findViewById(R.id.drawerLayout);
        recyclerView = findViewById(R.id.logbook_recyclerview);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new RecyclerViewAdapter(userId);
        recyclerView.setAdapter(adapter);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(LogBook.this, drawerLayout, toolbar, R.string.open, R.string.close);
        drawerLayout.addDrawerListener(toggle);
        toggle.getDrawerArrowDrawable().setColor(getResources().getColor(R.color.black));
        toggle.syncState();

        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                if (item.getItemId() == R.id.nav_home) {
                    Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                    startActivity(intent);
                }
                if (item.getItemId() == R.id.nav_logbok) {
                    Intent intent = new Intent(getApplicationContext(), LogBook.class);
                    startActivity(intent);
                }
                if (item.getItemId() == R.id.nav_messages) {
                    Intent intent = new Intent(getApplicationContext(), Messages.class);
                    startActivity(intent);
                }
                if (item.getItemId() == R.id.nav_friends) {
                    Intent intent = new Intent(getApplicationContext(), Friends.class);
                    startActivity(intent);
                }
                if (item.getItemId() == R.id.nav_weather) {
                    Intent intent = new Intent(getApplicationContext(), Weather.class);
                    startActivity(intent);
                }
                if (item.getItemId() == R.id.nav_alerts) {
                    Intent intent = new Intent(getApplicationContext(), Alerts.class);
                    startActivity(intent);
                }
                if (item.getItemId() == R.id.nav_settings) {
                    Intent intent = new Intent(getApplicationContext(), Settings.class);
                    startActivity(intent);
                }
                if (item.getItemId() == R.id.nav_logout) {
                    Intent intent = new Intent(getApplicationContext(), Login.class);
                    FirebaseAuth.getInstance().signOut();
                    intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                    startActivity(intent);
                }


                return true;
            }
        });


    }


}