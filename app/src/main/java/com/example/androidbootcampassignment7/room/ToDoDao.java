package com.example.androidbootcampassignment7.room;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.androidbootcampassignment7.data.entity.ToDo;

import java.util.List;

import io.reactivex.Completable;
import io.reactivex.Single;

@Dao
public interface ToDoDao {
    @Query("SELECT * FROM toDos")
    Single<List<ToDo>> loadTasks();

    @Insert
    Completable save(ToDo toDo);

    @Update
    Completable update(ToDo toDo);

    @Delete
    Completable clear(ToDo toDo);

    @Query("SELECT * FROM toDos WHERE name like '%' || :searchWord || '%'")
    Single<List<ToDo>> search(String searchWord);
}
