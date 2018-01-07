package com.pulsar.todolist;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.pulsar.todolist.db.AppDatabase;
import com.pulsar.todolist.db.Todo;

public class addTodoActivity extends AppCompatActivity {

    private AppDatabase mDb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mDb = AppDatabase.getInMemoryDatabase(this.getApplicationContext());
        setContentView(R.layout.activity_add_todo);
    }

    public void addTodoClick(View view) {

        TextView textView = this.findViewById(R.id.editText);
        String todoTxt = textView.getText().toString();
        if( todoTxt != null && !todoTxt.isEmpty()) {
            /*
            SharedPreferences sharedPref = this.getSharedPreferences(
                    getString(R.string.array_todos), Context.MODE_PRIVATE);

            SharedPreferences.Editor editor = sharedPref.edit();

            editor.putInt(getString(R.string.saved_high_score), todoTxt);
            editor.commit();
            */
            Todo todo = new Todo();
            todo.setValue(todoTxt);
            mDb.todoDao().insert(todo);
            Intent intent = new Intent(addTodoActivity.this, MainActivity.class);
            startActivity(intent);
        }
    }
}
