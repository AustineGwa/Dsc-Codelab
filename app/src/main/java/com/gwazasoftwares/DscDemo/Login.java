package com.gwazasoftwares.DscDemo;


import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;



/**
 * A simple {@link Fragment} subclass.
 */
public class Login extends Fragment {

   private  TextView label, reset;
   private  Button signup, login;
   private  EditText username, passsword;
   private ProgressDialog progressDialog;




    public Login() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_login, container, false);
        label = view.findViewById(R.id.txtlabel);
        reset = view.findViewById(R.id.txtreset);
        signup = view.findViewById(R.id.btnsignup);
        login = view.findViewById(R.id.btnlogin);
        progressDialog = new ProgressDialog(getActivity());

        username = view.findViewById(R.id.txtusername);
        passsword = view.findViewById(R.id.txtpassword);
        return view;
    }

    @Override
    public void onStart() {
        super.onStart();

        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openSignup();
            }
        });

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String incomingEmail = username.getText().toString().trim();
                String incomingPassword = passsword.getText().toString().trim();
                progressDialog.setMessage("Verifying  user  credentials...");
                progressDialog.setCanceledOnTouchOutside(false);
                progressDialog.show();
               // verifyUser(incomingEmail, incomingPassword);

            }
        });

        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startReset();
            }
        });
    }

    private void openSignup() {

        FragmentTransaction ft = getFragmentManager().beginTransaction();
        ft.replace(R.id.authactivity, new SignUp());
        ft.commit();

    }


    private void startReset() {
        FragmentTransaction ft = getFragmentManager().beginTransaction();
        ft.replace(R.id.authactivity, new Reset());
        ft.commit();
    }


}

