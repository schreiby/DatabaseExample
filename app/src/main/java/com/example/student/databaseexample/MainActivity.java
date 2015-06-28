package com.example.student.databaseexample;

import android.database.Cursor;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;


public class MainActivity extends ActionBarActivity {

    private DBAdapter dbAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dbAdapter = new DBAdapter(this);

     /*   //generate employee objects
        Employee joe = new Employee("Joe Mike", "joe@example.com");
        Employee mike = new Employee("Mike Muster", "mike@example.com");
        Employee john = new Employee("John Conner", "conner@example.com");

        //insert employee into database
        dbAdapter.open();
        dbAdapter.insert(joe);
        dbAdapter.insert(mike);
        dbAdapter.insert(john);
        dbAdapter.close();*/

        //retrieve all records
        dbAdapter.open();
        Cursor cursor = dbAdapter.getAll();
        if (cursor.getCount() > 0) {
            cursor.moveToFirst();
            int id;
            String name;
            String email;
            Employee employee;
            do {
                id = cursor.getInt(cursor.getColumnIndex(DBAdapter.C_ID));
                name = cursor.getString(cursor.getColumnIndex(DBAdapter.C_NAME));
                email = cursor.getString(cursor.getColumnIndex(DBAdapter.C_EMAIL));
                employee = new Employee(id, name, email);
                Toast.makeText(this, employee.toString(), Toast.LENGTH_SHORT).show();
                } while (cursor.moveToNext());
            }
        dbAdapter.close();
        }
    }

   
