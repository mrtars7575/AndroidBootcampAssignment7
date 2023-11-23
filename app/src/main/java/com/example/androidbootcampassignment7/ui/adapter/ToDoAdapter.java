package com.example.androidbootcampassignment7.ui.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.navigation.NavDirections;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;

import com.example.androidbootcampassignment7.data.entity.ToDo;
import com.example.androidbootcampassignment7.databinding.RowItemBinding;
import com.example.androidbootcampassignment7.ui.fragment.HomeFragmentDirections;
import com.example.androidbootcampassignment7.ui.viewmodel.HomeViewModel;
import com.google.android.material.snackbar.Snackbar;

import java.util.List;

public class ToDoAdapter extends RecyclerView.Adapter<ToDoAdapter.ToDoHolder> {


    private List<ToDo> toDoList;
    private Context mContext;
    private HomeViewModel viewModel;

    public ToDoAdapter(List<ToDo> toDoList, Context mContext, HomeViewModel viewModel) {
        this.toDoList = toDoList;
        this.mContext = mContext;
        this.viewModel = viewModel;
    }

    public class ToDoHolder extends RecyclerView.ViewHolder{
        private RowItemBinding binding;

        public ToDoHolder(RowItemBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }


    @NonNull
    @Override
    public ToDoAdapter.ToDoHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        RowItemBinding binding = RowItemBinding.inflate(
                LayoutInflater.from(mContext),parent,false);

        return new ToDoAdapter.ToDoHolder(binding);
    }

    @SuppressLint("RecyclerView")
    @Override
    public void onBindViewHolder(@NonNull ToDoAdapter.ToDoHolder holder, int position) {


        holder.binding.textView.setText(toDoList.get(position).getName());


        holder.binding.imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view,"Do " + toDoList.get(position).getName() + " remove",Snackbar.LENGTH_SHORT)
                        .setAction("Yes", new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                //clear task
                                viewModel.clear(toDoList.get(position).getId());
                            }
                        }).show();
            }
        });



        holder.binding.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                HomeFragmentDirections.ActionHomeFragmentToDetailFragment directions = HomeFragmentDirections.actionHomeFragmentToDetailFragment(
                       toDoList.get(position)
                );

                Navigation.findNavController(view).navigate((NavDirections) directions);
            }
        });


    }



    @Override
    public int getItemCount() {
        return toDoList.size();
    }
}
