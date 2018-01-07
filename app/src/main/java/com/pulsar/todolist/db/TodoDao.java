package com.pulsar.todolist.db;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import java.util.List;

/**
 * Created by jeremie on 05/01/18.
 */

@Dao
public interface TodoDao {
    @Query("SELECT * FROM todo")
    List<Todo> getAll();

    @Query("SELECT * FROM todo WHERE id IN (:todoIds)")
    List<Todo> loadAllByIds(int[] todoIds);

    @Insert
    void insert(Todo todo);

    @Insert
    void insertAll( Todo... todos);

    @Delete
    void delete(Todo todo);
}
