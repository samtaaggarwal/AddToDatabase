package com.example.user126065.addtodatabase;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class AddForm extends AppCompatActivity
{
DatabaseHelper mDatabaseHelper;
    Button btnadd;
    EditText editText;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_form);
        btnadd = (Button) findViewById(R.id.btnadd);
        editText = (EditText) findViewById(R.id.addText);
        mDatabaseHelper= new DatabaseHelper(this);
        btnadd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String NewEntry = editText.getText().toString();
                if(editText.length() != 0)
                {
                    AddData(NewEntry);
                    Intent intent =  new Intent(AddForm.this,MainActivity.class);
                    startActivity(intent);
                }
                else
                {
                    Toast("Field mandatory");
                }
            }


        });
    }
    private void AddData(String newEntry)
    {
        boolean insertData = mDatabaseHelper.addData(newEntry);
        if(insertData)
        {
            Toast("Data inserted");

        }
        else
        {
            Toast("Data not inserted");
        }
    }
    private  void Toast(String s)
    {
        Toast.makeText(this,s,Toast.LENGTH_SHORT).show();
    }
}
