package com.pulsar.todolist;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.pulsar.todolist.db.Todo;

import org.w3c.dom.Text;

import java.util.List;
import java.util.zip.Inflater;

/**
 * Created by jeremie on 07/01/18.
 */

public class TodosAdapter extends ArrayAdapter<Todo> {
    List<Todo> todoList;

    public TodosAdapter(Context context, List<Todo> list){
        super(context,0,list);
        todoList = list;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        RecyclerView.ViewHolder holder;

        Todo todo = getItem(position);

        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.item_todo, parent, false);
        }

        TodoViewHolder viewHolder = (TodoViewHolder) convertView.getTag();
        if(viewHolder == null){
            viewHolder = new TodoViewHolder();
            viewHolder.todo_value = (TextView) convertView.findViewById(R.id.todo_value);
            convertView.setTag(viewHolder);
        }
        //TextView todoVal = (TextView) convertView.findViewById(R.id.todo_value);
        //todoVal.setText(todo.getValue());
        return convertView;
    }

    private class TodoViewHolder {
        public TextView todo_value;
    }
}
