package com.example.androidbootcampassignment7.room;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.example.androidbootcampassignment7.data.entity.ToDo;

@Database(entities = {ToDo.class},version = 1)
public abstract class ToDoDatabase extends RoomDatabase {
    public abstract ToDoDao toDoDao();
}
