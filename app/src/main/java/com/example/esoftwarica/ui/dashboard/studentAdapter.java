package com.example.esoftwarica.ui.dashboard;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.esoftwarica.R;

import java.util.List;

public class studentAdapter extends RecyclerView.Adapter<studentAdapter.myHolder>{

    List<student> students;

    public studentAdapter(List<student> students) {
        this.students = students;
    }

    @NonNull
    @Override
    public myHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.studentdetail,parent,false);

        //inflater means kunchayi layout/design use garnai
        myHolder myHolder=new myHolder(view);

        return myHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull myHolder holder, final int position) {
        final student student=students.get(position);
        holder.name.setText(student.getName());
        holder.age.setText(student.getAge());
        holder.address.setText(student.getAddress());
        holder.gender.setText(student.getGender());
        holder.image.setImageResource(R.drawable.ema);
        holder.delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                students.remove(student);
                notifyItemRemoved(position);
            }
        });

    }

    @Override
    public int getItemCount() {

        return students.size();
    }

    public class myHolder extends RecyclerView.ViewHolder {

        TextView name,age,address,gender;
        ImageView image;
        Button delete;

        public myHolder(@NonNull View itemView) {

            super(itemView);
            name=itemView.findViewById(R.id.textName);
            age=itemView.findViewById(R.id.textAge);
            address=itemView.findViewById(R.id.textAddress);
            gender=itemView.findViewById(R.id.textGender);
            image=itemView.findViewById(R.id.imageView);
            delete=itemView.findViewById(R.id.btnDelete);



        }

    }
}
