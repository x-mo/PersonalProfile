package com.x.personalprofile;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";

    private ArrayList<String> imagePaths = new ArrayList<>();
    private RecyclerViewAdapter adapter;
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.rv);

        recyclerView.setLayoutManager(new GridLayoutManager(this, 3));
//        recyclerView.setHasFixedSize(false);
//        recyclerView.setNestedScrollingEnabled(false);
        fetchImages();

        adapter = new RecyclerViewAdapter(this, imagePaths);
        recyclerView.setAdapter(adapter);

    }

    private void fetchImages() {
        imagePaths.add("http://i0sa.com/food/images/food/7.jpg");
        imagePaths.add("http://i0sa.com/food/images/food/8.jpg");
        imagePaths.add("http://i0sa.com/food/images/food/9.jpg");
        imagePaths.add("http://i0sa.com/food/images/food/10.jpg");
        imagePaths.add("http://i0sa.com/food/images/food/2.jpg");
        imagePaths.add("http://i0sa.com/food/images/food/1.jpg");
        imagePaths.add("http://i0sa.com/food/images/food/5.jpg");
        imagePaths.add("http://i0sa.com/food/images/food/5.jpg");
        imagePaths.add("http://i0sa.com/food/images/food/5.jpg");
        imagePaths.add("http://i0sa.com/food/images/food/5.jpg");
        imagePaths.add("http://i0sa.com/food/images/food/5.jpg");
        imagePaths.add("http://i0sa.com/food/images/food/5.jpg");
        imagePaths.add("http://i0sa.com/food/images/food/5.jpg");
        imagePaths.add("http://i0sa.com/food/images/food/5.jpg");
        imagePaths.add("http://i0sa.com/food/images/food/5.jpg");
        imagePaths.add("http://i0sa.com/food/images/food/5.jpg");
        imagePaths.add("http://i0sa.com/food/images/food/5.jpg");
        imagePaths.add("http://i0sa.com/food/images/food/5.jpg");
        imagePaths.add("http://i0sa.com/food/images/food/5.jpg");
        imagePaths.add("http://i0sa.com/food/images/food/5.jpg");
        imagePaths.add("http://i0sa.com/food/images/food/5.jpg");
        imagePaths.add("http://i0sa.com/food/images/food/5.jpg");
        imagePaths.add("http://i0sa.com/food/images/food/7.jpg");
        imagePaths.add("http://i0sa.com/food/images/food/7.jpg");
        imagePaths.add("http://i0sa.com/food/images/food/7.jpg");
    }
}
