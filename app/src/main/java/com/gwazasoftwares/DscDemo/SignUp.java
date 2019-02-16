package com.gwazasoftwares.DscDemo;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 */
public class SignUp extends Fragment {
    EditText username, email, password,confirmpassword;
    Button create;
    TextView terms;


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

        create = view.findViewById(R.id.createaccount);
        terms = view.findViewById(R.id.terms);
        return view;
    }

    @Override
    public void onStart() {
        super.onStart();
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
                    createAcount(mUsername, mEmail, mPassword);
                }
            }
        });
    }

    private void createAcount(String mUsername, String mEmail, String mPassword) {

    }


    private void login() {
        Intent intent = new Intent(getActivity().getApplicationContext(), HomeFragmentHolder.class);
        startActivity(intent);
        getActivity().finish();
    }
}
