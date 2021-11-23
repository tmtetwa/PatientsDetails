package com.patientsapp.patientsdetails;

import static android.app.ProgressDialog.show;

import static com.patientsapp.patientsdetails.db.AppDatabase.*;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.room.processor.Context;

import com.patientsapp.patientsdetails.db.AppDatabase;
import com.patientsapp.patientsdetails.db.User;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity {

    private EditText eUsername;
    private EditText ePassword;
    private Button eLogin;
    private TextView eAttempts;
    private TextView eRegister;
    boolean isValid = false;
    private int count = 6;
    //List<User> dataList = new ArrayList<>();
    //AppDatabase database;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        eUsername = findViewById(R.id.etUsername);
        ePassword = findViewById(R.id.etPassword);
        eLogin = findViewById(R.id.btnSignIn);
        eAttempts = findViewById(R.id.eAttempts);
        eRegister = findViewById(R.id.tvRegister);

        eRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, RegistrationActivity.class);
                startActivity(intent);
            }
        });
        eLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String inputName = eUsername.getText().toString();
                String inputPassword = ePassword.getText().toString();

                if(inputName.isEmpty() || inputPassword.isEmpty())
                {
                    Toast.makeText(MainActivity.this, "Please enter all the details correctly",
                            Toast.LENGTH_SHORT).show();
                }else{
                    isValid = validate(inputName, inputPassword);

                    if(!isValid){
                        count--;
                        Toast.makeText(MainActivity.this, "Incorrect username or password",
                                Toast.LENGTH_SHORT).show();
                        eAttempts.setText("no. of attempts " + count);
                    }
                    if(count == 0){
                        eLogin.setEnabled(false);
                    } else {

                        Toast.makeText(MainActivity.this, "Login was successful",
                                Toast.LENGTH_SHORT).show();

                        Intent intent = new Intent(MainActivity.this, HomePageActivity.class);
                        startActivity(intent);
                    }
                }
            }
        });
    }

    private boolean validate(String name, String password)
    {
        if( RegistrationActivity.credentials != null){
            if(name.equals(RegistrationActivity.credentials.getUsername()) &&
                    name.equals(RegistrationActivity.credentials.getUsername()))
            {
            return true;
         }
        }
        return false;
    }

//    private void loadUserList(){
//        AppDatabase db = getInstance(this.getApplicationContext());
//        List<User> dataList = db.UserDoa().getAll();
//   }
}