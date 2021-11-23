package com.patientsapp.patientsdetails;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.patientsapp.patientsdetails.db.AppDatabase;
import com.patientsapp.patientsdetails.db.User;

import java.util.ArrayList;
import java.util.List;


public class RegistrationActivity extends AppCompatActivity {

    private EditText eRgName;
    private EditText eRgPassword;
    private Button eRegister;
    List<User> dataList = new ArrayList<>();
    AppDatabase database;


    public static Credentials credentials;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);

        eRgName = findViewById(R.id.rgName);
        eRgPassword = findViewById(R.id.rgPassword);
        eRegister = findViewById(R.id.btnReg);

        database = AppDatabase.getInstance(this);
        dataList = database.userDao().getAll();

        eRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String regUsername = eRgName.getText().toString();
                String regPassword = eRgPassword.getText().toString();

                //database = AppDatabase.getInstance(this);
                dataList = database.userDao().getAll();

                if(validate(regUsername,regPassword))
                {
                    credentials = new Credentials(regUsername,regPassword);

                    User user = new User();
                    user.setUserName(regUsername);
                    database.UserDoa().insert(user);
                    user.setPassword(regPassword);
                    dataList.clear();
                    dataList.addAll(database.userDao().getAll());


                    Intent intent = new Intent(RegistrationActivity.this, MainActivity.class);
                    startActivity(intent);
                    Toast.makeText(RegistrationActivity.this, "Registration is succesful",
                            Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private void saveNewUser(String username, String password)
    {
        AppDatabase db = AppDatabase.getInstance(this.getApplicationContext());
        User user = new User();

        user.password = password;
        db.UserDoa().insert(user);

        finish();
    }

    private boolean validate(String username, String password)
    {
        if(username.isEmpty() || password.length() < 6)
        {

                Toast.makeText(this, "Please enter all the details, Passwor " +
                                "should be at least 5 characters!",
                        Toast.LENGTH_SHORT).show();
                return false;

        }
        return true;
    }
}