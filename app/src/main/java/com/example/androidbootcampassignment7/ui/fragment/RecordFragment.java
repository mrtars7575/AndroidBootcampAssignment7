package com.example.androidbootcampassignment7.ui.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.androidbootcampassignment7.R;
import com.example.androidbootcampassignment7.databinding.FragmentDetailBinding;
import com.example.androidbootcampassignment7.databinding.FragmentRecordBinding;
import com.example.androidbootcampassignment7.ui.viewmodel.RecordViewModel;

import dagger.hilt.android.AndroidEntryPoint;

@AndroidEntryPoint
public class RecordFragment extends Fragment {

    FragmentRecordBinding binding;
    RecordViewModel viewModel;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        viewModel = new ViewModelProvider(this).get(RecordViewModel.class);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentRecordBinding.inflate(inflater,container,false);


        binding.saveBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String task = binding.addEt.getText().toString();
                viewModel.save(task);
            }
        });

        return binding.getRoot();
    }
}