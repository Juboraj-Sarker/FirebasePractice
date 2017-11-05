package com.juborajsarker.firebasetest;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by jubor on 11/5/2017.
 */

public class CivilList extends ArrayAdapter<Civil> {

    private Activity context;
    private List<Civil> civilList;

    public CivilList(Activity context, List<Civil> civilList){

        super(context, R.layout.list_layout,civilList);
        this.context = context;
        this.civilList = civilList;


    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        LayoutInflater inflater = context.getLayoutInflater();
        View listViewItem = inflater.inflate(R.layout.list_layout, null, true);

        TextView nameTV = (TextView) listViewItem.findViewById(R.id.nameTV);
        TextView ageTV = (TextView) listViewItem.findViewById(R.id.ageTV);
        TextView universityTV = (TextView) listViewItem.findViewById(R.id.universityTV);

        Civil civil = civilList.get(position);

        nameTV.setText(civil.getName());
        ageTV.setText(civil.getAge());
        universityTV.setText(civil.getUniversity());

        return listViewItem;
    }
}
