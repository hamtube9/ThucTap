package com.haiph.apivanlang.activity;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.util.Base64;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.haiph.apivanlang.R;
import com.haiph.apivanlang.Service.OkHttpService;
import com.haiph.apivanlang.Service.RetrofitService;
import com.haiph.apivanlang.adapter.AdapterChuaHoatDong;
import com.haiph.apivanlang.adapter.AdapterDuLieuThongKe;
import com.haiph.apivanlang.adapter.AdapterHuyen;
import com.haiph.apivanlang.adapter.AdapterQuocGia;
import com.haiph.apivanlang.adapter.AdapterTinh;
import com.haiph.apivanlang.adapter.AdapterXa;
import com.haiph.apivanlang.list.ListUserActivity;
import com.haiph.apivanlang.model.ChuaHoatDong;
import com.haiph.apivanlang.model.DuLieuThongKe;
import com.haiph.apivanlang.model.Huyen;
import com.haiph.apivanlang.model.PhatTu;
import com.haiph.apivanlang.model.QuocGia;
import com.haiph.apivanlang.model.Tinh;
import com.haiph.apivanlang.model.Xa;
import com.haiph.apivanlang.utils.FileUtils;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AddUserActivity extends AppCompatActivity {
    private Toolbar toolbar;
    final int PICK_IMAGE_REQUEST = 1;
    TextView tvSuKien;
    Spinner spinnerSuKien, SpinnerQuocGia, SpinnerThanhPho, SpinnerQuan, SpinnerXa, SpinnerNoiSinhHoat, SpinnerQuanNguoiThan, SpinnerXaNguoiThan, SpinnerThanhPhoNguoiThan;
    private EditText edtHoVaDem, edtTenUser, edtDiaChi, edtSoDienThoai, edtPhapDanh, edtCMT, edtID,
            edtEmail, edtNgaySinh, edtNguoiBaoLanh, edtSDTNguoiBaoLanh, edtTenNguoiThan, edtSDTNguoiThan, edtDiaChiNguoiThan;
    private CheckBox checkboxQuyY;
    private Button btnAddUser, btnUploadAvatar;
    private RadioButton rdNam, rdNu, rdKhac;

    AdapterDuLieuThongKe adapterDuLieuThongKe;
    List<DuLieuThongKe> duLieuThongKeList = new ArrayList<>();

    AdapterHuyen adapterHuyen;
    List<Huyen> huyenList;

    AdapterXa adapterXa;
    List<Xa> xaList;

    AdapterQuocGia adapterQuocGia;
    List<QuocGia> quocGiaList;

    AdapterTinh adapterTinh;
    List<Tinh> tinhList;

    AdapterChuaHoatDong adapterChuaHoatDong;
    List<ChuaHoatDong> chuaHoatDongList;

    private ImageView UserAvatar, imgDate;
    RadioGroup rdG;
    List<PhatTu> list;
    String gender;
    int idTinh;
    int positionSpinnerQuocGia, posSpinnerXa, posSpinnerXaNguoiThan, posSpinnerQuan, posSpinnerQuanNguoiThan, posSpinnerSuKien, postChuaHoatDong, posSpinnerNoiSinhHoat, posSpinnerThanhPho, posSpinnerThanhPhoNguoiThan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_user);
        initView();

        Intent i = getIntent();
        String data = i.getStringExtra("token1");
        final String token = "Bearer " + data;

        list = new ArrayList<>();

        imgDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Calendar c = Calendar.getInstance();
                int thang, nam, ngay;
                ngay = c.get(Calendar.DATE);
                thang = c.get(Calendar.MONTH);
                nam = c.get(Calendar.YEAR);
                DatePickerDialog datePickerDialog = new DatePickerDialog(AddUserActivity.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                        c.set(year, month, dayOfMonth);
                        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yy");
                        edtNgaySinh.setText(simpleDateFormat.format(c.getTime()));
                    }
                }, nam, thang, ngay);
                datePickerDialog.show();
            }
        });

        btnUploadAvatar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setType("image/*");
                intent.setAction(Intent.ACTION_GET_CONTENT);
                startActivityForResult(Intent.createChooser(intent, "Select Picture"), PICK_IMAGE_REQUEST);
            }
        });

        rdG.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.rdNam:
                        gender = rdNam.getText().toString();
                        break;
                    case R.id.rdNu:
                        gender = rdNu.getText().toString();
                        break;

                    case R.id.rdKhac:
                        gender = rdKhac.getText().toString();
                        break;
                }
            }
        });


        spinnerSuKien.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                int item = duLieuThongKeList.get(position).getId();
                posSpinnerSuKien = item;
                if (spinnerSuKien.getSelectedItem().equals(duLieuThongKeList.get(position))){
                    RetrofitService.getInstance().getTinhTheoId(token,item).enqueue(new Callback<ResponseBody>() {
                        @Override
                        public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                            if (response.isSuccessful()) {

                                try {
                                    String dulieu = response.body().string();
                                    JSONObject objectDuLieu = new JSONObject(dulieu);
                                    JSONArray arrayDulieu = objectDuLieu.getJSONArray("data");
                                    for (int i = 0; i < arrayDulieu.length(); i++) {
                                        JSONObject object = arrayDulieu.getJSONObject(i);
                                        int id = object.getInt("id");

                                        String tenTinh = object.getString("ten");
                                        Tinh quocGia = new Tinh(tenTinh,id);
                                        tinhList.add(quocGia);
                                        adapterTinh.notifyDataSetChanged();

                                        ArrayAdapter<Tinh> dataAdapter = new ArrayAdapter(getApplication(),
                                                android.R.layout.simple_spinner_item, tinhList);
                                        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                                        SpinnerThanhPho.setAdapter(dataAdapter);
                                        SpinnerThanhPhoNguoiThan.setAdapter(dataAdapter);
                                    }
                                } catch (IOException e) {
                                    e.printStackTrace();
                                } catch (JSONException e) {
                                    e.printStackTrace();
                                }

                            }
                        }

                        @Override
                        public void onFailure(Call<ResponseBody> call, Throwable t) {

                        }
                    });

                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        SpinnerNoiSinhHoat.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                int item = chuaHoatDongList.get(position).getId();
                postChuaHoatDong = item;

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        SpinnerThanhPhoNguoiThan.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                int item = tinhList.get(position).getId();
                posSpinnerThanhPhoNguoiThan = item;
                Log.e("pos",posSpinnerThanhPhoNguoiThan+"");
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        SpinnerThanhPho.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                int item = tinhList.get(position).getId();
                posSpinnerThanhPho = item;
                Log.e("pos",posSpinnerThanhPho+"");
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        SpinnerQuocGia.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                int idItem = quocGiaList.get(position).getIdQuocGia();
                positionSpinnerQuocGia = idItem;
                Log.e("pos",positionSpinnerQuocGia+"");

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        SpinnerQuan.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                int item = huyenList.get(position).getId();
                posSpinnerQuan = item;
                Log.e("pos",posSpinnerQuan+"");

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        SpinnerQuanNguoiThan.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                int item = huyenList.get(position).getId();
                posSpinnerQuanNguoiThan = item;
                Log.e("pos",posSpinnerQuanNguoiThan+"");

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        SpinnerXa.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                int item = xaList.get(position).getId();
                posSpinnerXa = item;
                Log.e("pos",posSpinnerXa+"");

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        SpinnerXaNguoiThan.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                int item = xaList.get(position).getId();
                posSpinnerXaNguoiThan = item;
                Log.e("pos",posSpinnerXaNguoiThan+"");

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        SpinnerNoiSinhHoat.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                int item = chuaHoatDongList.get(position).getId();
                posSpinnerNoiSinhHoat = item;
                Log.e("pos",posSpinnerNoiSinhHoat+"");

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


        getSuKien();
        getQuocGia();
     //   getTinh();
        getHuyen();
        getXa();
        getChuaHoatDong();


        btnAddUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (rdNam.isChecked()) {
                    gender = "Nam";
                } else if (rdNu.isChecked()) {
                    gender = "Nữ";
                } else if (rdKhac.isChecked()) {
                    gender = "Khác";
                }
                String ID = edtID.getText().toString();
                String hoVaDem = edtHoVaDem.getText().toString();
                String Ten = edtTenUser.getText().toString();
                String DiaChi = edtDiaChi.getText().toString();
                String SoDienThoai = edtSoDienThoai.getText().toString();
                String PhapDanh = edtPhapDanh.getText().toString();
                String email = edtEmail.getText().toString();
                String ngaySinh = edtNgaySinh.getText().toString();
                String nguoiBaoLanh = edtNguoiBaoLanh.getText().toString();
                String SDTnguoiBaoLanh = edtSDTNguoiBaoLanh.getText().toString();
                String NguoiThan = edtTenNguoiThan.getText().toString();
                String SDTnguoiThan = edtSDTNguoiThan.getText().toString();
                String DiaChiNguoiThan = edtDiaChiNguoiThan.getText().toString();
                String CMT = edtCMT.getText().toString();
                String quocGia = String.valueOf(positionSpinnerQuocGia);
                String tinh = String.valueOf(posSpinnerThanhPho);
                String tinhNguoiThan = String.valueOf(posSpinnerThanhPhoNguoiThan);
                String quan = String.valueOf(posSpinnerQuan);
                String quanNguoiThan = String.valueOf(posSpinnerQuanNguoiThan);
                String xa = String.valueOf(posSpinnerXa);
                String xaNguoiThan = String.valueOf(posSpinnerXaNguoiThan);
                String chuaHoatDong = String.valueOf(postChuaHoatDong);
                String sukien = String.valueOf(posSpinnerSuKien);
                String img = String.valueOf(ImageViewChange(UserAvatar));
                Log.e("img",img);
                PhatTu phatTu = new PhatTu(hoVaDem, Ten, PhapDanh, DiaChi, SoDienThoai, CMT, ID, email, nguoiBaoLanh, SDTnguoiBaoLanh, NguoiThan, SDTnguoiThan, DiaChiNguoiThan, ngaySinh, gender, quocGia, tinh, quan, xa, quanNguoiThan, xaNguoiThan, tinhNguoiThan, chuaHoatDong, sukien,ImageViewChange(UserAvatar));

                Log.e("phatTu", phatTu.toString());
                list.add(phatTu);
                Log.e("list", "" + list.add(phatTu));
                AddUser(hoVaDem, Ten, PhapDanh, DiaChi, SoDienThoai, CMT, ID, email, nguoiBaoLanh, SDTnguoiBaoLanh, NguoiThan, SDTnguoiThan, DiaChiNguoiThan, ngaySinh, gender, quocGia, tinh, quan, xa, quanNguoiThan, xaNguoiThan, tinhNguoiThan, chuaHoatDong, sukien,ImageViewChange(UserAvatar));
                Intent i = new Intent(AddUserActivity.this, ListUserActivity.class);
                Intent intent = getIntent();
                String token = intent.getStringExtra("token1");
                i.putExtra("token1", token);
                startActivity(i);
                Toast.makeText(AddUserActivity.this, "Phật tử : " + phatTu, Toast.LENGTH_SHORT).show();
            }
        });




    }

    private void getChuaHoatDong() {
        Intent i = getIntent();
        String data = i.getStringExtra("token1");
        String token = "Bearer " + data;
        Log.e("bearer", token + "");
        chuaHoatDongList = new ArrayList<>();
        adapterChuaHoatDong = new AdapterChuaHoatDong(chuaHoatDongList, getApplicationContext());

        RetrofitService.getInstance().getChuaHoatDong(token).enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                if (response.isSuccessful()) {

                    try {
                        String dulieu = response.body().string();
                        JSONObject objectDuLieu = new JSONObject(dulieu);
                        JSONArray arrayDulieu = objectDuLieu.getJSONArray("data");
                        for (int i = 0; i < arrayDulieu.length(); i++) {
                            JSONObject object = arrayDulieu.getJSONObject(i);

                            String chua = object.getString("ten");
                            int id = object.getInt("id");

                            ChuaHoatDong chuaHoatDong = new ChuaHoatDong(chua,id);

                            chuaHoatDongList.add(chuaHoatDong);
                            adapterChuaHoatDong.notifyDataSetChanged();

                            ArrayAdapter<ChuaHoatDong> dataAdapter = new ArrayAdapter(getApplication(),
                                    android.R.layout.simple_spinner_item, chuaHoatDongList);
                            dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                            SpinnerNoiSinhHoat.setAdapter(dataAdapter);
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }

                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {

            }
        });
    }
    private void getXa() {
        Intent i = getIntent();
        String data = i.getStringExtra("token1");
        String token = "Bearer " + data;
        xaList = new ArrayList<>();
        adapterXa = new AdapterXa(xaList, getApplicationContext());
        RetrofitService.getInstance().getXa(token).enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                if (response.isSuccessful()) {

                    try {
                        String dulieu = response.body().string();
                        JSONObject objectDuLieu = new JSONObject(dulieu);
                        JSONArray arrayDulieu = objectDuLieu.getJSONArray("data");
                        for (int i = 0; i < arrayDulieu.length(); i++) {
                            JSONObject object = arrayDulieu.getJSONObject(i);
                            int id = object.getInt("id");

                            String tenXa = object.getString("ten");
                            Xa quocGia = new Xa(tenXa,id);
                            xaList.add(quocGia);
                            adapterXa.notifyDataSetChanged();

                            ArrayAdapter<Xa> dataAdapter = new ArrayAdapter(getApplication(),
                                    android.R.layout.simple_spinner_item, xaList);
                            dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                            SpinnerXa.setAdapter(dataAdapter);
                            SpinnerXaNguoiThan.setAdapter(dataAdapter);
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }

                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {

            }
        });
    }
    private void getHuyen() {
        Intent i = getIntent();
        String data = i.getStringExtra("token1");
        String token = "Bearer " + data;

        huyenList = new ArrayList<>();

        adapterHuyen = new AdapterHuyen(huyenList, getApplicationContext());
        RetrofitService.getInstance().getHuyen(token).enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                if (response.isSuccessful()) {

                    try {
                        String dulieu = response.body().string();
                        JSONObject objectDuLieu = new JSONObject(dulieu);
                        JSONArray arrayDulieu = objectDuLieu.getJSONArray("data");
                        for (int i = 0; i < arrayDulieu.length(); i++) {
                            JSONObject object = arrayDulieu.getJSONObject(i);
                            int id = object.getInt("id");
                            String tenHuyen = object.getString("ten");
                            Huyen quocGia = new Huyen(tenHuyen,id);
                            huyenList.add(quocGia);
                            adapterHuyen.notifyDataSetChanged();
                            ArrayAdapter<Huyen> dataAdapter = new ArrayAdapter(getApplication(),
                                    android.R.layout.simple_spinner_item, huyenList);
                            dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                            SpinnerQuan.setAdapter(dataAdapter);
                            SpinnerQuanNguoiThan.setAdapter(dataAdapter);

                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }

                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {

            }
        });
    }
//    private void getTinh() {
//        Intent i = getIntent();
//        String data = i.getStringExtra("token1");
//        String token = "Bearer " + data;
//
//
//
//
//        tinhList = new ArrayList<>();
//        adapterTinh = new AdapterTinh(tinhList, getApplicationContext());
//        RetrofitService.getInstance().getTinh(token).enqueue(new Callback<ResponseBody>() {
//            @Override
//            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
//                if (response.isSuccessful()) {
//
//                    try {
//                        String dulieu = response.body().string();
//                        JSONObject objectDuLieu = new JSONObject(dulieu);
//                        JSONArray arrayDulieu = objectDuLieu.getJSONArray("data");
//                        for (int i = 0; i < arrayDulieu.length(); i++) {
//                            JSONObject object = arrayDulieu.getJSONObject(i);
//                            int id = object.getInt("id");
//
//                            String tenTinh = object.getString("ten");
//                            Tinh quocGia = new Tinh(tenTinh,id);
//                            tinhList.add(quocGia);
//                            adapterTinh.notifyDataSetChanged();
//
//                            ArrayAdapter<Tinh> dataAdapter = new ArrayAdapter(getApplication(),
//                                    android.R.layout.simple_spinner_item, tinhList);
//                            dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
//                            SpinnerThanhPho.setAdapter(dataAdapter);
//                            SpinnerThanhPhoNguoiThan.setAdapter(dataAdapter);
//                        }
//                    } catch (IOException e) {
//                        e.printStackTrace();
//                    } catch (JSONException e) {
//                        e.printStackTrace();
//                    }
//
//                }
//            }
//
//            @Override
//            public void onFailure(Call<ResponseBody> call, Throwable t) {
//
//            }
//        });
//    }
    public void getQuocGia() {
        Intent i = getIntent();
        String data = i.getStringExtra("token1");
        String token = "Bearer " + data;
        quocGiaList = new ArrayList<>();
        adapterQuocGia = new AdapterQuocGia(quocGiaList, getApplicationContext());


        RetrofitService.getInstance().getQuocGia(token).enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                if (response.isSuccessful()) {

                    try {
                        String dulieu = response.body().string();
                        JSONObject objectDuLieu = new JSONObject(dulieu);
                        JSONArray arrayDulieu = objectDuLieu.getJSONArray("data");
                        for (int i = 0; i < arrayDulieu.length(); i++) {
                            JSONObject object = arrayDulieu.getJSONObject(i);

                             int idQuocGia = object.getInt("id");
                            String ten = object.getString("ten");

                            QuocGia quocGia = new QuocGia(ten, idQuocGia);
                            quocGiaList.add(quocGia);
                            adapterQuocGia.notifyDataSetChanged();

                            ArrayAdapter<QuocGia> dataAdapter = new ArrayAdapter(getApplication(),
                                    android.R.layout.simple_spinner_item, quocGiaList);
                            dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                            SpinnerQuocGia.setAdapter(dataAdapter);


                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }

                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {

            }
        });
    }
    private void getSuKien() {
        Intent i = getIntent();
        String data = i.getStringExtra("token1");
        String token = "Bearer " + data;

        adapterDuLieuThongKe = new AdapterDuLieuThongKe(duLieuThongKeList, getApplicationContext());

        RetrofitService.getInstance().getDuLieu(token).enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                if (response.isSuccessful()) {
                    Log.e("dulieu", "" + response.body());
                    try {
                        String dulieu = response.body().string();
                        JSONObject objectDuLieu = new JSONObject(dulieu);
                        JSONArray arrayDulieu = objectDuLieu.getJSONArray("data");
                        for (int i = 0; i < arrayDulieu.length(); i++) {
                            JSONObject object = arrayDulieu.getJSONObject(i);

                            int id = object.getInt("id");
                            String tenSuKien = object.getString("ten");
                            DuLieuThongKe duLieuThongKe = new DuLieuThongKe(tenSuKien,id);
                            duLieuThongKeList.add(duLieuThongKe);
                            adapterDuLieuThongKe.notifyDataSetChanged();

                            ArrayAdapter<DuLieuThongKe> dataAdapter = new ArrayAdapter(getApplication(),
                                    android.R.layout.simple_spinner_item, duLieuThongKeList);
                            dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                            spinnerSuKien.setAdapter(dataAdapter);

                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }

                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {

            }
        });


    }

    private void AddUser(final String hoVaDem, final String ten, final String phapDanh, final String diaChi, final String soDienThoai, final String CMT, final String ID, final String email, final String nguoiBaoLanh, final String SDTnguoiBaoLanh, final String nguoiThan, final String SDTnguoiThan, final String diaChiNguoiThan, final String ngaySinh, final String gender, final String quocGia, final String tinh, final String quan, final String xa, final String quanNguoiThan, final String xaNguoiThan, final String tinhNguoiThan, final String chuaHoatDong, final String sukien, byte[] bytes) {
        Intent i = getIntent();
        String data = i.getStringExtra("token1");
        String token = "Bearer " + data;

        Log.e("tokenAddUser", "token : " + token);
        RetrofitService.getInstance().postNewPhatTu(token, ID, bytes.toString(), "", quocGia, hoVaDem
                , ten, phapDanh, this.gender, ngaySinh, soDienThoai, diaChi, xa,
                quan, tinh, email, "", nguoiThan,
                SDTnguoiThan, diaChiNguoiThan, xaNguoiThan, quanNguoiThan,
                tinhNguoiThan, "", "", "", "",
                "", "", "", "", nguoiBaoLanh, SDTnguoiBaoLanh,
                chuaHoatDong, "", CMT, "",
                "", "", "", "", "").enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                if (response.isSuccessful()) {

                    Log.e("response", String.valueOf(response.body()));
                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                Log.e("loiAddUser", t.getMessage());
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == PICK_IMAGE_REQUEST && resultCode == RESULT_OK &&
                data != null && data.getData() != null) {
            Uri uri = data.getData();
            uploadFile(uri);
            UserAvatar.setImageURI(uri);
        }


        if (resultCode == RESULT_OK) {
            try {
                final Uri imageUri = data.getData();
                final InputStream imageStream = getContentResolver().openInputStream(imageUri);
                final Bitmap selectedImage = BitmapFactory.decodeStream(imageStream);
                UserAvatar.setImageBitmap(selectedImage);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }

        }

    }

    private void initView() {
        toolbar = findViewById(R.id.toolbarAddUser);
        setSupportActionBar(toolbar);
        toolbar.setNavigationIcon(R.drawable.ic_arrow_back_black_24dp);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AddUserActivity.this, HomeActivity.class);
                startActivity(intent);
            }
        });
        rdG = findViewById(R.id.rdGroup);
        btnAddUser = findViewById(R.id.btnAddUser);
        btnUploadAvatar = findViewById(R.id.btnUploadAvatar);
        UserAvatar = findViewById(R.id.UserAvatar);
        imgDate = findViewById(R.id.imgDate);
        tvSuKien = findViewById(R.id.tvSuKien);
        checkboxQuyY = findViewById(R.id.checkboxQuyY);

        initEdit();
        initSpinner();
        rdKhac = findViewById(R.id.rdKhac);
        rdNam = findViewById(R.id.rdNam);
        rdNu = findViewById(R.id.rdNu);
    }

    private void initSpinner() {
        spinnerSuKien = findViewById(R.id.spinnerSuKien);
        SpinnerQuocGia = findViewById(R.id.SpinnerQuocGia);
        SpinnerQuan = findViewById(R.id.SpinnerQuan);
        SpinnerXa = findViewById(R.id.SpinnerXa);
        SpinnerThanhPho = findViewById(R.id.SpinnerThanhPho);
        SpinnerNoiSinhHoat = findViewById(R.id.SpinnerNoiSinhHoat);
        SpinnerQuanNguoiThan = findViewById(R.id.SpinnerQuanNguoiThan);
        SpinnerXaNguoiThan = findViewById(R.id.SpinnerXaNguoiThan);
        SpinnerThanhPhoNguoiThan = findViewById(R.id.SpinnerThanhPhoNguoiThan);

    }


    private void initEdit() {
        edtDiaChi = findViewById(R.id.edtDiaChi);
        edtTenUser = findViewById(R.id.edtTenUser);
        edtSoDienThoai = findViewById(R.id.edtPhone);
        edtPhapDanh = findViewById(R.id.edtPhapDanh);
        edtCMT = findViewById(R.id.edtCMT);
        edtID = findViewById(R.id.edtID);
        edtID.setEnabled(false);
        edtNgaySinh = findViewById(R.id.edtNgaySinh);
        edtHoVaDem = findViewById(R.id.edtHoVaDem);
        edtEmail = findViewById(R.id.edtEmail);
        edtNguoiBaoLanh = findViewById(R.id.edtNguoiBaoLanh);
        edtSDTNguoiBaoLanh = findViewById(R.id.edtSDTNguoiBaoLanh);
        edtTenNguoiThan = findViewById(R.id.edtTenNguoiThan);
        edtSDTNguoiThan = findViewById(R.id.edtSDTNguoiThan);
        edtDiaChiNguoiThan = findViewById(R.id.edtDiaChiNguoiThan);
    }


    private void uploadFile(Uri fileUri) {
        Intent i = getIntent();
        String data = i.getStringExtra("token1");
        String token = "Bearer " + data;
        File orifile = FileUtils.getFile(getApplicationContext(), fileUri);
        RequestBody filePart = RequestBody.create(MediaType.parse(getContentResolver().getType(fileUri)), orifile);
        MultipartBody.Part file = MultipartBody.Part.createFormData("data", orifile.getName(), filePart);
        RetrofitService.getInstance().uploadImage(token, "", "", file).enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                Toast.makeText(AddUserActivity.this, "Success", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {

            }
        });

    }

    private byte[] ImageViewChange(ImageView imageView) {
        BitmapDrawable drawable = (BitmapDrawable) imageView.getDrawable();
        Bitmap bitmap = drawable.getBitmap();
        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.PNG, 100, stream);
        return stream.toByteArray();
    }

}
