package com.example.androidbootcampassignment7.ui.viewmodel;

import androidx.annotation.NonNull;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.androidbootcampassignment7.data.entity.ToDo;
import com.example.androidbootcampassignment7.data.repo.ToDoDaoRepository;

import java.io.Closeable;
import java.util.List;

import javax.inject.Inject;

import dagger.hilt.android.lifecycle.HiltViewModel;

@HiltViewModel
public class HomeViewModel extends ViewModel {

    public ToDoDaoRepository repository;
    public MutableLiveData<List<ToDo>> toDos;

    @Inject
    public HomeViewModel(ToDoDaoRepository repository) {
        this.repository = repository;
        loadTasks();
        this.toDos = repository.data;
    }

    public void search(String searchWord){
        repository.search(searchWord);
    }

    public void loadTasks(){
        repository.loadTasks();
    }

    public void clear(int id){
        repository.clear(id);
    }


}
