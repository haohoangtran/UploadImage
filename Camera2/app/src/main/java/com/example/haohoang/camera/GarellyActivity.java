package com.example.haohoang.camera;

import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
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

import java.io.File;
import java.io.IOException;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;

public class GarellyActivity extends AppCompatActivity {
    private static final int RESULT_LOAD_IMAGE = 1;
    private static final String TAG = GarellyActivity.class.toString();
    @BindView(R.id.bt_garelly)
    Button btGarely;
    @BindView(R.id.bt_uploadgarelly)
    Button btUpload;
    @BindView(R.id.iv_garelly)
    ImageView ivGarelly;
    String picturePath;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_garelly);
        ButterKnife.bind(this);
        addListener();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        if (requestCode == RESULT_LOAD_IMAGE && resultCode == RESULT_OK && null != data) {
            Uri selectedImage = data.getData();
            String[] filePathColumn = {MediaStore.Images.Media.DATA};

            Cursor cursor = getContentResolver().query(selectedImage,
                    filePathColumn, null, null, null);
            cursor.moveToFirst();

            int columnIndex = cursor.getColumnIndex(filePathColumn[0]);
            picturePath = cursor.getString(columnIndex);
            cursor.close();

            Bitmap bmp = BitmapFactory.decodeFile(picturePath);
            ivGarelly.setImageBitmap(bmp);

        }
    }

    private void addListener() {
        btGarely.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(
                        Intent.ACTION_PICK,
                        android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                startActivityForResult(i, RESULT_LOAD_IMAGE);
            }
        });
        btUpload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                GarellyActivity.Retrievedata retrievedata=new Retrievedata();
                retrievedata.execute(picturePath);
            }
        });
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
