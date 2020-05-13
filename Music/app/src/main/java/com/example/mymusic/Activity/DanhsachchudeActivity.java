package com.example.mymusic.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.example.mymusic.Adapter.DanhsachAllchudeAdapter;
import com.example.mymusic.Model.ChuDe;
import com.example.mymusic.R;
import com.example.mymusic.Service.APIService;
import com.example.mymusic.Service.Dataservice;
import com.google.gson.JsonObject;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DanhsachchudeActivity extends AppCompatActivity {
    RecyclerView recyclerViewtatcachucde;
    Toolbar toolbartatcachude;
    DanhsachAllchudeAdapter danhsachAllchudeAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_danhsachchude);
        init();
        GetData();
    }

    private void GetData() {
        Call<List<ChuDe>> callback = null;
        try {
            Dataservice dataservice = APIService.getService();
            callback = dataservice.GetAllchude();
        } catch (Exception e) {
            e.printStackTrace();
        }


        callback.enqueue(new Callback<List<ChuDe>>() {
            @Override
            public void onResponse(Call<List<ChuDe>> call, Response<List<ChuDe>> response) {
                ArrayList<ChuDe> mangchude = (ArrayList<ChuDe>) response.body();
                danhsachAllchudeAdapter = new DanhsachAllchudeAdapter(DanhsachchudeActivity.this,mangchude);
                recyclerViewtatcachucde.setLayoutManager(new GridLayoutManager(DanhsachchudeActivity.this, 2));
                recyclerViewtatcachucde.setAdapter(danhsachAllchudeAdapter);
            }

            @Override
            public void onFailure(Call<List<ChuDe>> call, Throwable t) {

            }
        });
    }

    private void init() {
        recyclerViewtatcachucde = findViewById(R.id.recyclerviewAllChude);
        toolbartatcachude = findViewById(R.id.toolbarallchude);
        setSupportActionBar(toolbartatcachude);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Tất Cả Chủ Đề");
        toolbartatcachude.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
