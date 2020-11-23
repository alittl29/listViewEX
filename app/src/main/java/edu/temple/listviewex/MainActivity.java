package edu.temple.listviewex;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.GridView;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        ListView listView;
        //get the list view and add adapter
        listView = findViewById(R.id.lvBookmarks);
        //Create List
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add("Red");
        arrayList.add("Blue");
        arrayList.add("Green");
        arrayList.add("Yellow");

        //create adapter
        BookmarkAdapter bookmarkAdapter = new BookmarkAdapter(this, arrayList);
        listView.setAdapter(bookmarkAdapter);





    }
}