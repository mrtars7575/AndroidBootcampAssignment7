package com.example.androidbootcampassignment7.ui.viewmodel;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.androidbootcampassignment7.data.entity.ToDo;
import com.example.androidbootcampassignment7.data.repo.ToDoDaoRepository;

import java.util.List;

import javax.inject.Inject;

import dagger.hilt.android.lifecycle.HiltViewModel;

@HiltViewModel
public class RecordViewModel extends ViewModel {

    ToDoDaoRepository repository;
    MutableLiveData<List<ToDo>> toDos;

    @Inject
    public RecordViewModel(ToDoDaoRepository repository) {
        this.repository = repository;
        this.toDos = repository.data;
    }

    public void save(String name){
        repository.save(name);
    }

}
