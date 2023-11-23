package com.example.androidbootcampassignment7.data.repo;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;

import com.example.androidbootcampassignment7.data.entity.ToDo;
import com.example.androidbootcampassignment7.room.ToDoDao;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.CompletableObserver;
import io.reactivex.SingleObserver;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class ToDoDaoRepository {
    public MutableLiveData<List<ToDo>> data = new MutableLiveData<>();
    private ToDoDao toDoDao;

    public ToDoDaoRepository(ToDoDao toDoDao) {
        this.toDoDao = toDoDao;
    }

    public void clear(int id){
        ToDo toDo = new ToDo(id,"");
        toDoDao.clear(toDo).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new CompletableObserver() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onComplete() {
                        loadTasks();
                    }

                    @Override
                    public void onError(Throwable e) {

                    }
                });

    }

    public void save(String name){
        ToDo toDo = new ToDo(0,name);
        toDoDao.save(toDo).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new CompletableObserver() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onComplete() {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }
                });
    }

    public void update(int id,String name){
        ToDo toDo = new ToDo(id,name);
        toDoDao.update(toDo).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new CompletableObserver() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onComplete() {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }
                });
    }

    public void search(String searchWord){
        toDoDao.search(searchWord).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new SingleObserver<List<ToDo>>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onSuccess(List<ToDo> toDos) {
                        data.setValue(toDos);
                    }

                    @Override
                    public void onError(Throwable e) {

                    }
                });
    }

    public void loadTasks(){
        toDoDao.loadTasks().subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new SingleObserver<List<ToDo>>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onSuccess(List<ToDo> toDos) {
                        data.setValue(toDos);
                    }

                    @Override
                    public void onError(Throwable e) {

                    }
                });

    }



}
