package com.example.facultyhandbook;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;


public class SchoolsListViewAdapter extends BaseAdapter {

    Context context;
    ArrayList<Schools> arraylist;
    int count = 0;

    public SchoolsListViewAdapter(Context context, ArrayList<Schools> arraylist) {
        this.context = context;
        this.arraylist = arraylist;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public Object getItem(int position) {
        return arraylist.get(position);
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {


        LayoutInflater inflater = (LayoutInflater)context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
        convertView = inflater.inflate(R.layout.listview_schools, null);

        //ImageView productpicture = (ImageView)convertView.findViewById(R.id.prodpicture);
        TextView schoolName = (TextView)convertView.findViewById(R.id.schoolName);
        TextView schoolDescriptions = (TextView)convertView.findViewById(R.id.schoolDescription);
        TextView numCourses = (TextView)convertView.findViewById(R.id.numCourses);



        schoolName.setText(arraylist.get(position).getschoolName());
        schoolDescriptions.setText(arraylist.get(position).getschoolDescriptions());
        numCourses.setText(arraylist.get(position).getnumCourses());


        return convertView;
    }

    @Override
    public int getCount() {
        return this.arraylist.size();
    }

}
