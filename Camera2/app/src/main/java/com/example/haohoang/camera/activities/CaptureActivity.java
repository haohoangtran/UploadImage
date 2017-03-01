package com.example.haohoang.camera.activities;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.AsyncTask;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import com.example.haohoang.camera.R;

import java.io.File;
import java.io.IOException;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;

public class CaptureActivity extends AppCompatActivity {
    private static final int CAM_REQUEST = 1;
    private static final String TAG = CaptureActivity.class.toString();
    @BindView(R.id.bt_camera)
    Button buttonCamera;
    @BindView(R.id.iv_camera)
    ImageView imgCamera;
    @BindView(R.id.bt_summit)
    Button btSummit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_capture);
        ButterKnife.bind(this);
        addListener();

    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        String path ="sdcard/camera_app/cam_image.jpg";
        Log.e(TAG, String.format("onActivityResult: %s", (new File(path)).getTotalSpace()) );
        imgCamera.setImageDrawable(Drawable.createFromPath(path));

    }

    private void addListener() {
        buttonCamera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                File file=getFile();
                intent.putExtra(MediaStore.EXTRA_OUTPUT, Uri.fromFile(file));
                startActivityForResult(intent,CAM_REQUEST);
            }
        });
        btSummit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Retrievedata retrievedata=new Retrievedata();
                String path ="sdcard/camera_app/cam_image.jpg";
                retrievedata.execute(path);
            }
        });
    }
    private File getFile(){
        File foder=new File("sdcard/camera_app");
        if (!foder.exists()){
            foder.mkdir();
        }
        File file=new File(foder,"cam_image.jpg");
        return file;
    }
    public void setBtSummit(File file)  {
        Cloudinary cloudinary=new Cloudinary(
                ObjectUtils.asMap(
                        "cloud_name", "dhtl",
                        "api_key", "767781774363334",
                        "api_secret", "AC5_uhn8LY2JaiWPeONIhz6ZLPg")
        );
        Map uploadResult = null;
        try {
            uploadResult = cloudinary.uploader().upload(file, ObjectUtils.emptyMap());
        } catch (IOException e) {
            e.printStackTrace();
        }
        Log.e(TAG, String.format("setBtSummit: %s", uploadResult.toString()) );
    }
    class Retrievedata extends AsyncTask<String, Void, String> {
        @Override
        protected String doInBackground(String... params) {
                setBtSummit(new File(params[0]));
            return null;
        }
    }
}
