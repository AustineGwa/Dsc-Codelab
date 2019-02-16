package com.gwazasoftwares.DscDemo;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;


/**
 * A simple {@link Fragment} subclass.
 */
public class SignUp extends Fragment {
    EditText username, email, password,confirmpassword;
    Button create;
    TextView terms;

    private FirebaseAuth mAuth;


    public SignUp() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_sign_up, container, false);
        username = view.findViewById(R.id.createusername);
        email = view.findViewById(R.id.createemail);
        password = view.findViewById(R.id.createpassword);
        confirmpassword = view.findViewById(R.id.confirmpassword);

        mAuth = FirebaseAuth.getInstance();

        create = view.findViewById(R.id.createaccount);
        terms = view.findViewById(R.id.terms);
        return view;
    }

    @Override
    public void onStart() {
        super.onStart();

        FirebaseUser currentUser = mAuth.getCurrentUser();


        create.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String mUsername = username.getText().toString().trim();
                String mEmail = email.getText().toString().trim();
                String mPassword = password.getText().toString().trim();
                String mConfirmPassword = confirmpassword.getText().toString().trim();

                if(TextUtils.isEmpty(mUsername) || TextUtils.isEmpty(mEmail) || TextUtils.isEmpty(mPassword) || TextUtils.isEmpty(mConfirmPassword)){

                    Toast.makeText(getActivity(),"sorrry All fields are recquired ", Toast.LENGTH_SHORT).show();

                }else if(!mPassword.equals(mConfirmPassword)){
                    Toast.makeText(getActivity(),"passwords  do not match", Toast.LENGTH_SHORT).show();
                }else {
                    createAcount(mEmail, mPassword);
                }
            }
        });
    }




    private void createAcount( String mEmail, String mPassword) {
      //start of mAutH


        mAuth.createUserWithEmailAndPassword(mEmail, mPassword)
                .addOnCompleteListener(getActivity(), new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information
                           Toast.makeText(getActivity(), "User created successfully", Toast.LENGTH_SHORT).show();
                            FirebaseUser user = mAuth.getCurrentUser();
                           //updateUI(user);
                        } else {
                            // If sign in fails, display a message to the user.
                            Log.w("Activity", "createUserWithEmail:failure", task.getException());
                            Toast.makeText(getActivity(), "createUserWithEmail:failure",
                                    Toast.LENGTH_SHORT).show();
                            //updateUI(null);

                        }

                        // ...
                    }
                });
    }




    private void login() {
        Intent intent = new Intent(getActivity().getApplicationContext(), HomeFragmentHolder.class);
        startActivity(intent);
        getActivity().finish();
    }
}
