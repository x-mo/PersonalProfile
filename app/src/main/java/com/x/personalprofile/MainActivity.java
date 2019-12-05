package com.x.personalprofile;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.bumptech.glide.Glide;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";

    private ArrayList<String> imagePaths = new ArrayList<>();
    private RecyclerViewAdapter adapter;
    private RecyclerView recyclerView;

    private TextView nameTV;
    private TextView locationTV;
    private TextView bioTV;
    private TextView postsTV;
    private TextView followersTV;
    private TextView followingTV;
    private ImageView profileIV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nameTV = findViewById(R.id.tv_name);
        locationTV = findViewById(R.id.tv_location);
        bioTV = findViewById(R.id.tv_bio);
        postsTV = findViewById(R.id.tv_posts_count);
        followersTV = findViewById(R.id.tv_followers_count);
        followingTV = findViewById(R.id.tv_following_count);

        profileIV = findViewById(R.id.profile_image);

        recyclerView = findViewById(R.id.rv);

        recyclerView.setLayoutManager(new GridLayoutManager(this, 3));
//        recyclerView.setHasFixedSize(false);
//        recyclerView.setNestedScrollingEnabled(false);
        fetchUserInfo();
        fetchUserImages();

        adapter = new RecyclerViewAdapter(this, imagePaths);
        recyclerView.setAdapter(adapter);

    }

    private void fetchUserInfo() {

        String url = "http://i0sa.com/bit/task/profile";

        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest
                (Request.Method.GET, url, null, new Response.Listener<JSONObject>() {

                    @Override
                    public void onResponse(JSONObject response) {
                        try {

                            JSONObject data = response.getJSONObject("data");
                            nameTV.setText(data.getString("full_name"));
                            locationTV.setText(data.getString("location"));
                            bioTV.setText(data.getString("bio"));

                            JSONObject counts = data.getJSONObject("counts");
                            postsTV.setText(counts.getString("posts"));
                            followersTV.setText(counts.getString("followers"));
                            followingTV.setText(counts.getString("following"));

                            Glide.with(MainActivity.this).load(data.getString("profile_picture")).error(Glide.with(MainActivity.this).load(R.drawable.image_not_found)).into(profileIV);


                        } catch (JSONException e) {
                            e.printStackTrace();
                        }

                    }
                }, new Response.ErrorListener() {

                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Log.e("VolleyError", error.toString());

                    }
                });

        VolleySingleton.getInstance(this).addToRequestQueue(jsonObjectRequest);

    }

    private void fetchUserImages() {

        String url = "http://i0sa.com/bit/task/home";

        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest
                (Request.Method.GET, url, null, new Response.Listener<JSONObject>() {

                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            JSONArray imagesArray = response.getJSONArray("data");
                            JSONObject imageObject;
                            for (int i = 0; i < imagesArray.length(); i++) {
                                imageObject = (JSONObject) imagesArray.get(i);
                                imagePaths.add(imageObject.getString("image"));
                            }

                            adapter.notifyDataSetChanged();
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }

                    }
                }, new Response.ErrorListener() {

                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Log.e("VolleyError", error.toString());

                    }
                });

        VolleySingleton.getInstance(this).addToRequestQueue(jsonObjectRequest);

    }

}
