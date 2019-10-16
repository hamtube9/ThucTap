package com.haiph.apivanlang.activity;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import com.haiph.apivanlang.R;
import com.haiph.apivanlang.Service.RetrofitService;
import com.haiph.apivanlang.list.ListUserActivity;
import com.haiph.apivanlang.utils.FileUtils;

import java.io.File;

import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class UploadImageActivity extends AppCompatActivity {
    ImageView imgAvatar;
    Button btnUploadImage;
    public static final int MY_PERMISSION_REQUEST = 10;
    public static final int MY_PERMISSIONS_REQUEST_READ_EXTERNAL_STORAGE = 123;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_upload_image);
        imgAvatar = findViewById(R.id.imgAvatar);
        btnUploadImage = findViewById(R.id.btnUploadImage);
        imgAvatar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_GET_CONTENT);
                intent.setType("image/*");
                startActivityForResult(intent, 0);
            }
        });

        btnUploadImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(UploadImageActivity.this, ListUserActivity.class);
                startActivity(i);

            }
        });

            if (ContextCompat.checkSelfPermission(this,Manifest.permission.READ_EXTERNAL_STORAGE)!=PackageManager.PERMISSION_GRANTED){
                ActivityCompat.requestPermissions(UploadImageActivity.this,new String[]{Manifest.permission.READ_EXTERNAL_STORAGE},MY_PERMISSION_REQUEST);
            }

    }

    private void uploadImage( Uri fileUri) {
        Intent intent = getIntent();
        String token = intent.getStringExtra("token");
        RequestBody fileUriDescription = RequestBody.create(MultipartBody.FORM, "");
        File originalFile = FileUtils.getFile(this,fileUri);
        RequestBody filePart = RequestBody.create(MediaType.parse(getContentResolver().getType(fileUri)),
               originalFile );

        MultipartBody.Part file = MultipartBody.Part.createFormData("photo", originalFile.getName(), filePart);

        RetrofitService.getInstance().uploadAvatar(token,fileUriDescription,file).enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {

            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {

            }
        });
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == MY_PERMISSION_REQUEST && resultCode == RESULT_OK && data != null && data.getData() != null) {
            Log.e("dataIMG", data + "");
            Uri uri = data.getData();
            uploadImage(uri);
        }
    }
}
