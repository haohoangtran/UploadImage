package com.example.haohoang.microsofttest.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.example.haohoang.microsofttest.R;
import com.example.haohoang.microsofttest.databases.model.bodies.AddNewGroupBody;
import com.example.haohoang.microsofttest.networks.NetContext;
import com.example.haohoang.microsofttest.services.FaceGroupService;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.toString();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        FaceGroupService faceGroupService= NetContext.instance.create(FaceGroupService.class);

//        faceGroupService.getGroupFace("1").enqueue(new Callback<GetPersionGroupResponJSON>() {
//            @Override
//            public void onResponse(Call<GetPersionGroupResponJSON> call, Response<GetPersionGroupResponJSON> response) {
//                if (response.code()==200) {
//                    GetPersionGroupResponJSON g=response.body();
//                    if (g!=null)
//                    Log.e(TAG, String.format("onResponse: %s", response.body().toString()));
//                }
//            }
//
//            @Override
//            public void onFailure(Call<GetPersionGroupResponJSON> call, Throwable t) {
//
//            }
//        });


        faceGroupService.addNewGroupFace("1",new AddNewGroupBody("57TH1","Day la lop TH!"))
                .enqueue(new Callback<String>() {
                    @Override
                    public void onResponse(Call<String> call, Response<String> response) {
                        Log.e(TAG, String.format("onResponse: %s", response.body()) );
                    }

                    @Override
                    public void onFailure(Call<String> call, Throwable t) {

                    }
                });
    }
}
