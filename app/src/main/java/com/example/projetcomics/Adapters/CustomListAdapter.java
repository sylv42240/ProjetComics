package com.example.projetcomics.Adapters;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.projetcomics.Classes.Creator;
import com.example.projetcomics.R;
import com.squareup.picasso.Picasso;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class CustomListAdapter extends ArrayAdapter<Creator> {
    ArrayList<Creator> creators;
    Context context;
    int resource;

    public CustomListAdapter(@NonNull Context context, int resource, @NonNull ArrayList<Creator> creators) {
        super(context, resource, creators);
        this.creators = creators;
        this.context = context;
        this.resource = resource;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        if (convertView == null) {
            LayoutInflater layoutInflater = (LayoutInflater) getContext().getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
            convertView = layoutInflater.inflate(R.layout.element_creator, null, true);
        }
        Creator creator = getItem(position);
        TextView name = convertView.findViewById(R.id.nameCreator);
        TextView role = convertView.findViewById(R.id.roleCreator);
        name.setText(creator.getName());
        role.setText(creator.getRole());
        return convertView;
    }
}
