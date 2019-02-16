package com.gwazasoftwares.DscDemo;

import android.app.ActionBar;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.Window;


public class AuthenticationFragmentHolder extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_authentication_fragment_holder);

        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.replace(R.id.authactivity, new Login());
        ft.commit();
    }
}
