package com.example.projetcomics.Activities;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.example.projetcomics.Classes.Comics;
import com.example.projetcomics.Adapters.CustomListAdapter;
import com.example.projetcomics.R;
import com.squareup.picasso.Picasso;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ComicsActivity extends AppCompatActivity {
    private Comics c;
    private TextView title;
    private TextView date;
    private TextView code;
    private Button web;
    private ImageView img;
    private TextView price;
    private ListView lvCreators;

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()){
            case R.id.sharebutton:
                Intent sharing = new Intent(Intent.ACTION_SEND);
                sharing.setType("text/plain");
                String shareBody = c.getUrl().replace("http://","https://");
                sharing.putExtra(Intent.EXTRA_TEXT, shareBody);
                startActivity(Intent.createChooser(sharing, c.getTitle()));
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_comics);
        title = findViewById(R.id.titleOfComics);
        date = findViewById(R.id.dateOfComics);
        code = findViewById(R.id.diamondCode);
        web = findViewById(R.id.web);
        img = findViewById(R.id.imageOfComics);
        price = findViewById(R.id.price);
        lvCreators = findViewById(R.id.lvCreators);
        Intent intent = getIntent();
        c = (Comics) intent.getSerializableExtra("comics");
        title.setText(c.getTitle());
        String s = c.getSaleDate();
        String[] data = s.split("T");
        Date date1 = null;
        try {
            date1 = new SimpleDateFormat("yyyy-MM-dd").parse(data[0]);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        DateFormat dfl = DateFormat.getDateInstance(DateFormat.FULL);
        date.setText(dfl.format(date1));
        String imgComics = c.getImage();
        String newImg = imgComics.replace("http://","https://");
        Picasso.with(getApplicationContext()).load(newImg).into(img);
        code.setText(c.getDiamondCode());
        web.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String url = c.getUrl().replace("http://","https://");
                Intent intent = new Intent( Intent.ACTION_VIEW, Uri.parse( url ) );
                startActivity(intent);
            }
        });
        price.setText(c.getPrice() + " $");
        CustomListAdapter adapter = new CustomListAdapter(
                getApplicationContext(), R.layout.element_creator, c.getCretors());
        lvCreators.setAdapter(adapter);
    }
}
