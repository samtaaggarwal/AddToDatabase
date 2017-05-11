package com.example.user126065.addtodatabase;




import android.app.Activity;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;


import java.util.ArrayList;

public class MainActivity extends Activity
{

    DatabaseHelper mDatabaseHelper;
    public ListView listView;
    ArrayList<String>  listData = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

         listView = (ListView) findViewById(R.id.myList);
        mDatabaseHelper = new DatabaseHelper(this);
        populateView();
        CustomAdapter adapter = new CustomAdapter();
        listView.setAdapter(adapter);
    }

    private void populateView()
    {
        Cursor data = mDatabaseHelper.getdata();
        while(data.moveToNext())
        {
            listData.add(data.getString((1)));
        }
    }

    public class CustomAdapter extends BaseAdapter
    {

        @Override
        public int getCount()
        {
            return listData.size();
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent)
        {
            convertView = getLayoutInflater().inflate(R.layout.custom_activity,null);
            TextView text = (TextView) convertView.findViewById(R.id.textView);
            text.setText((listData.get(position)));
            return convertView;
        }
    }
}
