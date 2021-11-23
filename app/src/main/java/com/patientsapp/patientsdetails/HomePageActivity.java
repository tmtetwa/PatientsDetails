package com.patientsapp.patientsdetails;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.patientsapp.patientsdetails.db.AppDatabase;
import com.patientsapp.patientsdetails.db.User;

import java.util.ArrayList;
import java.util.List;

public class HomePageActivity extends AppCompatActivity {

    private TextView eFullName;
    private TextView eAge;
    private TextView eAddress;
    private TextView eSex;
    private TextView eTemperature;
    List<User> dataList = new ArrayList<>();
    AppDatabase database;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);

        eFullName = findViewById(R.id.tvFullName);
        eAge = findViewById(R.id.tvAge);
        eAddress = findViewById(R.id.tvAddress);
        eSex =findViewById(R.id.tvSex);
        eTemperature =findViewById(R.id.tvTemperature);

        database = AppDatabase.getInstance(this);
        dataList = database.userDao().getAll();
    }
}