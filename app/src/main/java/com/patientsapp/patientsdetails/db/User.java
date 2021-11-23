package com.patientsapp.patientsdetails.db;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity (tableName = "tableName")
public class User {

    @PrimaryKey(autoGenerate = true)
    public int uid;

    @ColumnInfo (name= "userName")
    public String userName;

    @ColumnInfo(name= "Password")
    public String password;

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
