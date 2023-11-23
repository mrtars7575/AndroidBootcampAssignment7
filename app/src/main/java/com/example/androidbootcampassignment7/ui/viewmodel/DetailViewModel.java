package com.example.androidbootcampassignment7.ui.viewmodel;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.androidbootcampassignment7.data.entity.ToDo;
import com.example.androidbootcampassignment7.data.repo.ToDoDaoRepository;

import java.util.List;

import javax.inject.Inject;

import dagger.hilt.android.lifecycle.HiltViewModel;

@HiltViewModel
public class DetailViewModel extends ViewModel {
    private ToDoDaoRepository repository;
    private MutableLiveData<List<ToDo>> toDos;

    @Inject
    public DetailViewModel(ToDoDaoRepository repository) {
        this.repository = repository;
        this.toDos = repository.data;
    }

    public void update(int id,String name){
        repository.update(id,name);
    }
}
