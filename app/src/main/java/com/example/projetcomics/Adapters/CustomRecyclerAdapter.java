package com.example.projetcomics.Adapters;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.projetcomics.Activities.ComicsActivity;
import com.example.projetcomics.Classes.Comics;
import com.example.projetcomics.R;
import com.squareup.picasso.Picasso;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class CustomRecyclerAdapter extends RecyclerView.Adapter<CustomRecyclerAdapter.MyViewHolder> {
    private ArrayList<Comics> comicsArrayList;
    private Context context;
    public static class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private ItemClickListener itemClickListener;
        public ImageView img;
        public TextView title;
        public TextView date;
        public MyViewHolder(View itemView) {
            super(itemView);
            img = itemView.findViewById(R.id.imgComics);
            title= itemView.findViewById(R.id.titleComics);
            date = itemView.findViewById(R.id.dateComics);
            itemView.setOnClickListener(this);
        }
        public void setItemClickListener(ItemClickListener itemClickListener){
            this.itemClickListener = itemClickListener;
        }

        @Override
        public void onClick(View v) {
            itemClickListener.onClick(v, getAdapterPosition());
        }
    }
    public CustomRecyclerAdapter(Context context, ArrayList<Comics> comicsArrayList){
        this.context=context;
        this.comicsArrayList=comicsArrayList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.element_recycler, viewGroup, false);
        MyViewHolder myViewHolder = new MyViewHolder(v);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, int i) {
        final Comics currentComics = comicsArrayList.get(i);
        String imgComics = currentComics.getImage();
        String newImg = imgComics.replace("http://","https://");
        Picasso.with(context).load(newImg).into(myViewHolder.img);
        myViewHolder.title.setText(currentComics.getTitle());
        String s = currentComics.getSaleDate();
        String[] data = s.split("T");
        Date date1 = null;
        try {
            date1 = new SimpleDateFormat("yyyy-MM-dd").parse(data[0]);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        DateFormat dfl = DateFormat.getDateInstance(DateFormat.FULL);
        myViewHolder.date.setText(dfl.format(date1));
        myViewHolder.setItemClickListener(new ItemClickListener() {
            @Override
            public void onClick(View view, int position) {
                Intent myIntent = new Intent(view.getContext(), ComicsActivity.class);
                myIntent.putExtra("comics", currentComics).setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);;
                view.getContext().startActivity(myIntent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return comicsArrayList.size();
    }


}
