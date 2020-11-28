package edu.temple.listviewex;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ListView;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<String> bookmarkList;
    Button btnBookmarks;
    File file;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        bookmarkList = new ArrayList<>();
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

            //Open the second activity and send the arraylist in a bundle
        btnBookmarks = findViewById(R.id.btnBookmarks);
        btnBookmarks.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //create a bundle with all the stuff needed
                //array list for the background color
                //int for the position
                //string for the name
                Bundle bundle = new Bundle();
                bundle.putStringArrayList("ArrayList",bookmarkList);


                Intent secondActivity = new Intent(MainActivity.this, SecondActivity.class);
                secondActivity.putExtras(bundle);

                //start the activity with the bundle
                startActivity(secondActivity);


            }
        });


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