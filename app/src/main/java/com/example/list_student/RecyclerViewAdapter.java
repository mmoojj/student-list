package com.example.list_student;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.list_student.databinding.ItemRecyclerViewBinding;
import com.example.list_student.models.Student;

import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.StudentViewHolder> {

    private final List<Student> students;
    public RecyclerViewAdapter(List<Student> students) {
        this.students=students;
    }


    @NonNull
    @Override
    public StudentViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new StudentViewHolder(ItemRecyclerViewBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull StudentViewHolder holder, int position) {
        holder.bind(students.get(position));
    }

    @Override
    public int getItemCount() {
        return students.size();
    }

    public static class StudentViewHolder extends RecyclerView.ViewHolder {
        private final ItemRecyclerViewBinding binding;

        public StudentViewHolder(ItemRecyclerViewBinding binding) {
            super(binding.getRoot());
            this.binding=binding;
        }

        public void bind(Student student) {
            binding.textViewFirstChar.setText(student.first_name.substring(0,1));
            binding.textViewFullName.setText(String.format("%s%s", student.first_name, student.last_name));
        }
    }
}
