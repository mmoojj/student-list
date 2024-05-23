package com.example.list_student.models;


import lombok.Data;

@Data
public class Student {
    public int id;
    public String first_name;
    public String last_name;
    public String course;
    public int score;
    public String created_at;
    public String updated_at;

}
