package com.example.list_student;

import com.example.list_student.models.Student;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface RetrofitApiService {

    @GET("experts/student")
    Call<List<Student>>  getStudent();
}
