package edu.temple.listviewex;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;


public class BookmarkFragment extends Fragment{

    View l;
    Context context;
    ListView listView;
    ArrayList<String> bookmarkList;
    File file;

    public BookmarkFragment() {
        // Required empty public constructor
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
      //  parentActivity = (BookmarkInterface)context;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        l = inflater.inflate(R.layout.fragment_bookmark, container, false);

        context = l.getContext();
        Bundle bundle = getArguments();
        bookmarkList = bundle.getStringArrayList("ArrayList");

        //get the list view and add adapter
        listView = l.findViewById(R.id.lvBookmarks);


        //create adapter
        final BookmarkAdapter bookmarkAdapter = new BookmarkAdapter(context, bookmarkList);
        listView.setAdapter(bookmarkAdapter);
        return l;
    }

    public ArrayList<String> getBookmarkList() {
        return bookmarkList;
    }

    public String getSelectedItem()
    {
        return (String)listView.getSelectedItem();
    }




}