package com.example.firebasefirstlectureinsertfetchdata;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;

public class AdapterClass  extends FirebaseRecyclerAdapter<ModelClass,AdapterClass.ViewHolder> {

    public AdapterClass(@NonNull FirebaseRecyclerOptions<ModelClass> options) {
        super(options);
    }

    @Override
    protected void onBindViewHolder(@NonNull AdapterClass.ViewHolder holder, int position, @NonNull ModelClass model) {
        holder.tvName.setText(model.Name);
        holder.tvEmail.setText(model.Email);
        holder.tvPassword.setText(model.Password);
        holder.tvDept.setText(model.Dept);
    }

    @NonNull
    @Override
    public AdapterClass.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list,parent,false);
        return new ViewHolder(view);
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvName,tvEmail,tvPassword,tvDept;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvName=itemView.findViewById(R.id.tvOne);
            tvEmail=itemView.findViewById(R.id.tvTwo);
            tvPassword=itemView.findViewById(R.id.tvThree);
            tvDept=itemView.findViewById(R.id.tvFour);
        }
    }
}
