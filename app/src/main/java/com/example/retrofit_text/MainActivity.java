package com.example.retrofit_text;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    TextView tv;
    Retrofit retrofit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tv=findViewById(R.id.text);
        retrofit=new Retrofit.Builder()
                .baseUrl("https://api.uomg.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        findViewById(R.id.get).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getDataCall();
            }
        });
    }

    private void getDataCall() {
        //创建api接口
        Api api=retrofit.create(Api.class);
        //创建实例
        Call<Data> call = api.getJsonData("json");
        //异步实现
        call.enqueue(new Callback<Data>() {
            @Override
            public void onResponse(Call<Data> call, Response<Data> response) {
                Toast.makeText(MainActivity.this, "异步回调", Toast.LENGTH_SHORT).show();
                Data data = response.body();
                if(data==null){
                    return ;
                }
                tv.setText(data.getContent());
            }

            @Override
            public void onFailure(Call<Data> call, Throwable t) {
                Toast.makeText(MainActivity.this,"get回调失败",Toast.LENGTH_SHORT).show();
            }
        });
    }
}