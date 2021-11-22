package com.patientsapp.patientsdetails;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class RegistrationActivity extends AppCompatActivity {

    private EditText eRgName;
    private EditText eRgPassword;
    private Button eRegister;

    public static Credentials credentials;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);

        eRgName = findViewById(R.id.rgName);
        eRgPassword = findViewById(R.id.rgPassword);
        eRegister = findViewById(R.id.btnReg);

        eRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String regUsername = eRgName.getText().toString();
                String regPassword = eRgPassword.getText().toString();

                if(validate(regUsername,regPassword))
                {
                    credentials = new Credentials(regUsername,regPassword);
                    Intent intent = new Intent(RegistrationActivity.this, MainActivity.class);
                    startActivity(intent);
                    Toast.makeText(RegistrationActivity.this, "Registration is succesful",
                            Toast.LENGTH_SHORT).show();
                }
            }
        });
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