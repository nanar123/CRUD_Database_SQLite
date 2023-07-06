package com.example.belajarsqlite;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ListMhsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listmhs);

        //ListView lvNama = (ListView) findViewById(R.id.lvNama);

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recyclerView);

        ArrayList<MhsModel> mhsList = getIntent().getExtras().getParcelableArrayList("mhsList");

        MhsAdapter mhsAdapter = new MhsAdapter(mhsList);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(ListMhsActivity.this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(mhsAdapter);

 //       if(mhsList.isEmpty()){
 //           mhsList.add("data masih kosong");
 //       }

//        ArrayAdapter<String> ad_nama = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, daftar_nama);
//
//        lvNama.setAdapter(ad_nama);

    }
}