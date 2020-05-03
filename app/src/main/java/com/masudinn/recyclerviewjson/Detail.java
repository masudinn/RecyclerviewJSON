package com.masudinn.recyclerviewjson;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import static com.masudinn.recyclerviewjson.MainActivity.EXcreator;
import static com.masudinn.recyclerviewjson.MainActivity.EXlike;
import static com.masudinn.recyclerviewjson.MainActivity.EXtags;
import static com.masudinn.recyclerviewjson.MainActivity.EXunduh;
import static com.masudinn.recyclerviewjson.MainActivity.EXurl;

public class Detail extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);


        ImageView image = findViewById(R.id.imgdetail);
        TextView txtCreator = findViewById(R.id.creatordetail);
        TextView txtlike = findViewById(R.id.likedetail);
        TextView txtunduh = findViewById(R.id.unduhdetail);
        TextView txtTags = findViewById(R.id.tagsdetail);

        Intent intent = getIntent();
        String Url = intent.getStringExtra(EXurl);
        String creator = intent.getStringExtra(EXcreator);
        String tags = intent.getStringExtra(EXtags);
        int unduh = intent.getIntExtra(EXunduh,0);
        int likes = intent.getIntExtra(EXlike,0);

        Picasso.with(this).load(Url).fit().centerInside().into(image);
        txtCreator.setText(creator);
        txtunduh.setText("Unduh : "+unduh);
        txtTags.setText("Tags : " +tags);
        txtlike.setText("Likes : "+likes);
    }
}
