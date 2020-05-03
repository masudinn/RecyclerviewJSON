package com.masudinn.recyclerviewjson;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.JsonRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements adapter.OnItemClikListener {
    public static final String EXurl="imageUrl";
    public static final String EXcreator="creator";
    public static final String EXlike="like";
    public static final String EXunduh="unduh";
    public static final String EXtags="tags";


    private RecyclerView mRecycleview;
    private adapter madapter;
    private ArrayList<items> mExampleList;
    private RequestQueue mrequestQueue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mRecycleview = findViewById(R.id.recyclerview);
        mRecycleview.setHasFixedSize(true);
        mRecycleview.setLayoutManager(new LinearLayoutManager(this));

        mExampleList = new ArrayList<>();
        mrequestQueue = Volley.newRequestQueue(this);
        parseJSON();
    }

    private void parseJSON() {
        String url = "https://pixabay.com/api/?key=16248765-4f72d6272ff4a62cf3b0421a9&q=baby&image_type=photo";
        JsonRequest request = new JsonObjectRequest(Request.Method.GET, url, null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            JSONArray jsonArray = response.getJSONArray("hits");
                            for(int i = 0; i<jsonArray.length();i++){
                                JSONObject hits = jsonArray.getJSONObject(i);
                                String creator = hits.getString("user");
                                String imageUrl = hits.getString("webformatURL");
                                String tags = hits.getString("tags");
                                int like = hits.getInt("likes");
                                int unduh = hits.getInt("downloads");


                                mExampleList.add(new items(imageUrl,creator,like,tags,unduh));
                            }
                            madapter = new adapter(MainActivity.this,mExampleList);
                            mRecycleview.setAdapter(madapter);
                            madapter.setOnItemClickListener(MainActivity.this);
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                error.printStackTrace();
            }
        });
        mrequestQueue.add(request);
    }

    @Override
    public void onItemClick(int position) {
        Intent detail = new Intent (this,Detail.class);
        items clickItem = mExampleList.get(position);
        detail.putExtra(EXurl,clickItem.getmImageurl());
        detail.putExtra(EXcreator,clickItem.getmCreator());
        detail.putExtra(EXlike,clickItem.getmLikes());
        detail.putExtra(EXtags,clickItem.getTags());
        detail.putExtra(EXunduh,clickItem.getUnduh());
        startActivity(detail);
    }


}
