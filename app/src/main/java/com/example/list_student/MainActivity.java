package com.example.list_student;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.list_student.databinding.ActivityMainBinding;
import com.example.list_student.models.Student;
import com.google.android.material.snackbar.Snackbar;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        ApiService apiService = new ApiService();
        apiService.getStudent(new CallBack() {
            @Override
            public void studentLisener(List<Student> students) {
                binding.progressBar.setVisibility(View.GONE);
                binding.recyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this, RecyclerView.VERTICAL, false));
                binding.recyclerView.setAdapter(new RecyclerViewAdapter(students));
            }

            @Override
            public void onError(Exception e) {
                Toast.makeText(MainActivity.this, "error in get data", Toast.LENGTH_SHORT).show();
            }
        });

    }
}