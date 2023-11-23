package com.example.androidbootcampassignment7.ui.fragment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.NavDirections;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.SearchView;

import com.example.androidbootcampassignment7.R;
import com.example.androidbootcampassignment7.data.entity.ToDo;
import com.example.androidbootcampassignment7.databinding.FragmentHomeBinding;
import com.example.androidbootcampassignment7.ui.adapter.ToDoAdapter;
import com.example.androidbootcampassignment7.ui.viewmodel.HomeViewModel;

import java.util.ArrayList;

import dagger.hilt.android.AndroidEntryPoint;

@AndroidEntryPoint
public class HomeFragment extends Fragment {

    private FragmentHomeBinding binding;
    private HomeViewModel viewModel;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        viewModel = new ViewModelProvider(this).get(HomeViewModel.class);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentHomeBinding.inflate(inflater,container,false);

        binding.recyclerView.setLayoutManager(new LinearLayoutManager(requireContext()));

        viewModel.toDos.observe(getViewLifecycleOwner(),toDos -> {
            ToDoAdapter toDoAdapter = new ToDoAdapter(toDos,getContext(),viewModel);
            binding.recyclerView.setAdapter(toDoAdapter);
        });


        binding.searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String s) {
                viewModel.search(s);
                return true;
            }

            @Override
            public boolean onQueryTextChange(String s) {
                viewModel.search(s);
                return true;
            }
        });

        binding.floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavController navController = Navigation.findNavController(requireView());
                navController.navigate(R.id.action_homeFragment_to_recordFragment);

            }
        });

        return binding.getRoot();



    }


    @Override
    public void onResume() {
        super.onResume();
        viewModel.loadTasks();
    }
}