package com.example.mymusic.Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mymusic.Adapter.BaihatAdapter;
import com.example.mymusic.Model.Baihat;
import com.example.mymusic.R;
import com.example.mymusic.Service.APIService;
import com.example.mymusic.Service.Dataservice;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Fragment_Baihat extends Fragment {
    View view;
    RecyclerView recyclerViewbaihat;
    BaihatAdapter baihatAdapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_baihat,container,false);
        recyclerViewbaihat = view.findViewById(R.id.recyclerviewbaihat);
        GetData();
        return view;
    }

    private void GetData() {
        Dataservice dataservice = APIService.getService();
        Call<List<Baihat>> callback = dataservice.GetBaihat();
        callback.enqueue(new Callback<List<Baihat>>() {
            @Override
            public void onResponse(Call<List<Baihat>> call, Response<List<Baihat>> response) {
                ArrayList<Baihat> baihatArrayList = (ArrayList<Baihat>) response.body();
                baihatAdapter = new BaihatAdapter(getActivity(),baihatArrayList);
                LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
                linearLayoutManager.setOrientation(RecyclerView.VERTICAL);
                recyclerViewbaihat.setLayoutManager(linearLayoutManager);
                recyclerViewbaihat.setAdapter(baihatAdapter);
            }

            @Override
            public void onFailure(Call<List<Baihat>> call, Throwable t) {

            }
        });
    }
}
