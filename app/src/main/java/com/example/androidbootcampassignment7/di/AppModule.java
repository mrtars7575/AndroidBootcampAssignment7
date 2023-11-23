package com.example.androidbootcampassignment7.di;

import android.content.Context;

import androidx.room.Room;

import com.example.androidbootcampassignment7.data.repo.ToDoDaoRepository;
import com.example.androidbootcampassignment7.room.ToDoDao;
import com.example.androidbootcampassignment7.room.ToDoDatabase;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import dagger.hilt.InstallIn;
import dagger.hilt.android.qualifiers.ApplicationContext;
import dagger.hilt.components.SingletonComponent;

@Module
@InstallIn(SingletonComponent.class)
public class AppModule {

    @Provides
    @Singleton
    public ToDoDaoRepository provideToDoDaoRepository(ToDoDao toDoDao){
        return new ToDoDaoRepository(toDoDao);
    }

    @Provides
    @Singleton
    public ToDoDao provideToDoDao(@ApplicationContext Context context){
        ToDoDatabase database = Room.databaseBuilder(context, ToDoDatabase.class,"toDos").build();

        return database.toDoDao();
    }
}
