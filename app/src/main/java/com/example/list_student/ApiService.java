package com.example.list_student;

import com.example.list_student.models.Student;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiService {
    private final RetrofitApiService apiService;
    public  ApiService(){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://expertdevelopers.ir/api/v1/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        apiService = retrofit.create(RetrofitApiService.class);
    }

    public void getStudent(CallBack callBack){
        apiService.getStudent().enqueue(new Callback<List<Student>>() {
            @Override
            public void onResponse(Call<List<Student>> call, Response<List<Student>> response) {
                callBack.studentLisener(response.body());
            }

            @Override
            public void onFailure(Call<List<Student>> call, Throwable t) {
                callBack.onError(new Exception(t));
            }
        });
    }

}
 interface CallBack{
    void studentLisener(List<Student> students);
    void onError(Exception e);
}
