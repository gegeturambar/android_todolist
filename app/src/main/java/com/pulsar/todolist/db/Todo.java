package com.pulsar.todolist.db;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

/**
 * Created by jeremie on 05/01/18.
 */

@Entity
public class Todo {
    @PrimaryKey
    private Integer id;

    @ColumnInfo(name = "value")
    private String value;

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return this.id;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getValue() {
        return this.value;
    }

}
