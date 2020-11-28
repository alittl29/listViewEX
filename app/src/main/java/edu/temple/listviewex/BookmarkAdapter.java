package edu.temple.listviewex;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Hashtable;

public class BookmarkAdapter extends BaseAdapter {

    Context context;
    ArrayList<String> arrayList;
    MainActivity parentActivity;

    //constructor
    public BookmarkAdapter(Context context, ArrayList<String> arrayList)
    {
        this.context = context;
        this.arrayList = arrayList;
        parentActivity = (MainActivity) context;
    }

    @Override
    public int getCount() {
        return arrayList.size();
    }

    @Override
    public Object getItem(int position) {
        return arrayList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }



    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {

        View view = convertView;

        if(view == null)
        {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.custom_list_layout, null);
        }


        TextView txtBookmark = (TextView) view.findViewById(R.id.txtBookmark);
        txtBookmark.setText(arrayList.get(position).toString());
        txtBookmark.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String selectedBookmark = arrayList.get(position).toString();
                parentActivity.OpenSite(selectedBookmark);
            }
        });



        ImageButton btnDelete = (ImageButton)view.findViewById(R.id.btnDelete);
        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //create dialog and show it
                final AlertDialog.Builder builder = new AlertDialog.Builder(context);
                builder.setMessage("Delete this bookmark?")
                        .setTitle("Confirm Delete")
                        .setPositiveButton("Confirm", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                // CONFIRM
                                arrayList.remove(position);
                                parentActivity.SaveFile(arrayList);
                                notifyDataSetChanged();

                             //

                            }
                        })
                        .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                // CANCEL
                            }
                        });


                AlertDialog dialog = builder.create();
                dialog.show();
            }
        });


        return view;
    }

}
