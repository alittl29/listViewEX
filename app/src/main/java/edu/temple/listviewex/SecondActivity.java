package edu.temple.listviewex;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;

public class SecondActivity extends AppCompatActivity {

    ArrayList<String> bookmarkList;
    File file;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);


        //get the bundle sent from the initial activity
        Bundle bundle = getIntent().getExtras();

        //store the data from the bundle
        bookmarkList = bundle.getStringArrayList("ArrayList");

        String internalFile = "myFile";
        file = new File(getFilesDir(), internalFile);

        if(file.exists())
        {
            try
            {
                FileInputStream fis = new FileInputStream(file);
                ObjectInputStream ois = new ObjectInputStream(fis);
                bookmarkList = (ArrayList<String>) ois.readObject();
            }
            catch (FileNotFoundException e)
            {
                CreateList();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }

        else
        {
            CreateList();

        }



        ListView listView;
        //get the list view and add adapter
        listView = findViewById(R.id.lvBookmarks);


        //create adapter
        BookmarkAdapter bookmarkAdapter = new BookmarkAdapter(this, bookmarkList);
        listView.setAdapter(bookmarkAdapter);




    }

    public void CreateList()
    {
        bookmarkList = new ArrayList<>();
        bookmarkList.add("Red");
        bookmarkList.add("Blue");
        bookmarkList.add("Green");
        bookmarkList.add("White");
    }

}