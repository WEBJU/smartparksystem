package com.example.smartparksystem;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity {
    FirebaseAuth auth;
    private FirebaseAuth.AuthStateListener authListener;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        auth=FirebaseAuth.getInstance();

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }

//    @Override
//    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
//        super.onCreateContextMenu(menu, v, menuInfo);
//        MenuInflater inflater=getMenuInflater();
//        inflater.inflate(R.menu.main_menu,menu);
//    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.profile:
                // do something
                startActivity(new Intent(MainActivity.this,ProfileActivity.class));
                return true;
            case R.id.home:
                Toast.makeText(this, "You are already home", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.logout:
                    auth.signOut();
                    startActivity(new Intent(MainActivity.this,LoginActivity.class));
                    finish();
                return true;
            default:
                return super.onContextItemSelected(item);
        }
    }

}