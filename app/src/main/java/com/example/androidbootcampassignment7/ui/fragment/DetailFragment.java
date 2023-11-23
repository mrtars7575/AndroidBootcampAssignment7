package com.example.androidbootcampassignment7.ui.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.androidbootcampassignment7.R;
import com.example.androidbootcampassignment7.data.entity.ToDo;
import com.example.androidbootcampassignment7.databinding.FragmentDetailBinding;
import com.example.androidbootcampassignment7.ui.viewmodel.DetailViewModel;

import dagger.hilt.android.AndroidEntryPoint;

@AndroidEntryPoint
public class DetailFragment extends Fragment {

    FragmentDetailBinding binding;
    DetailViewModel viewModel;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        viewModel = new ViewModelProvider(this).get(DetailViewModel.class);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentDetailBinding.inflate(inflater,container,false);

        DetailFragmentArgs bundle = DetailFragmentArgs.fromBundle(getArguments());
        ToDo toDo = bundle.getToDo();

        binding.detailEt.setText(toDo.getName());

        binding.updateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String updateTask = binding.detailEt.getText().toString();
                viewModel.update(toDo.getId(), updateTask);
            }
        });

        return binding.getRoot();
    }
}