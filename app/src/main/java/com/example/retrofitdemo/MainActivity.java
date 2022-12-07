package com.example.retrofitdemo;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.retrofitdemo.Adapter.CardAdapter;
import com.example.retrofitdemo.Client.ApiClient;
import com.example.retrofitdemo.JsonInterface.ImageInterface;
import com.example.retrofitdemo.JsonObject.CardItem;
import com.example.retrofitdemo.databinding.ActivityMainBinding;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;
    List<CardItem> cardItemList;
    CardAdapter cardAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        binding.recycle.setLayoutManager(new LinearLayoutManager(this));
        cardAdapter = new CardAdapter(getApplicationContext(), cardItemList);
        binding.recycle.setAdapter(cardAdapter);


        ImageInterface imageInterface = ApiClient.getClientData().create(ImageInterface.class);
        Call<List<CardItem>> call = imageInterface.getImage();

        call.enqueue(new Callback<List<CardItem>>() {
            @Override
            public void onResponse(Call<List<CardItem>> call, Response<List<CardItem>> response) {
                cardItemList = response.body();
                cardAdapter.SetCardList(cardItemList);
            }

            @Override
            public void onFailure(Call<List<CardItem>> call, Throwable t) {
                Toast.makeText(MainActivity.this, "Fail" + t, Toast.LENGTH_SHORT).show();
            }
        });
    }

}