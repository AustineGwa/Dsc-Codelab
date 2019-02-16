package com.gwazasoftwares.DscDemo;

import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;


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
