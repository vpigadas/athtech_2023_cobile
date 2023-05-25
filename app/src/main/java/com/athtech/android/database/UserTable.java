package com.athtech.android.database;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;

@Entity(primaryKeys = {"full_name"})
public class UserTable {

    @ColumnInfo(name = "full_name")
    @NonNull
    private String name;

    @ColumnInfo(name = "age")
    private int age;

    @ColumnInfo(name = "job_type")
    private String jobType;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getJobType() {
        return jobType;
    }

    public void setJobType(String jobType) {
        this.jobType = jobType;
    }
}
