package com.haiph.apivanlang.activity;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
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

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.haiph.apivanlang.R;
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
import com.haiph.apivanlang.response.HuyenResponse;
import com.haiph.apivanlang.response.ImageResponse;
import com.haiph.apivanlang.response.TinhResponse;
import com.haiph.apivanlang.response.XaResponse;
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
import java.lang.reflect.Type;
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

public class AddUserActivity extends AppCompatActivity implements View.OnClickListener, AdapterView.OnItemSelectedListener {
    private Toolbar toolbar;
    final int PICK_IMAGE_REQUEST = 1;
    private TextView tvSuKien, tvGetContent;
    private Spinner spinnerSuKien, SpinnerQuocGia, SpinnerThanhPho, SpinnerQuan, SpinnerXa, SpinnerNoiSinhHoat, SpinnerQuanNguoiThan,
            SpinnerXaNguoiThan, SpinnerThanhPhoNguoiThan;
    private EditText edtHoVaDem, edtTenUser, edtDiaChi, edtSoDienThoai, edtPhapDanh, edtCMT, edtID,
            edtEmail, edtNgaySinh, edtNguoiBaoLanh, edtSDTNguoiBaoLanh, edtTenNguoiThan, edtSDTNguoiThan, edtDiaChiNguoiThan, edtGhiChu;
    private CheckBox checkboxQuyY;
    private Button btnAddUser, btnUploadAvatar;
    private RadioButton rdNam, rdNu, rdKhac;
    private AdapterDuLieuThongKe adapterDuLieuThongKe;
    private List<DuLieuThongKe> duLieuThongKeList = new ArrayList<>();
    private AdapterHuyen adapterHuyen;
    private List<Huyen> huyenList = new ArrayList<>();
    private AdapterXa adapterXa;
    private List<Xa> xaList = new ArrayList<>();
    private AdapterQuocGia adapterQuocGia;
    private List<QuocGia> quocGiaList = new ArrayList<>();
    private AdapterTinh adapterTinh;
    private List<Tinh> tinhList = new ArrayList<>();
    private AdapterChuaHoatDong adapterChuaHoatDong;
    private List<ChuaHoatDong> chuaHoatDongList = new ArrayList<>();
    private ImageView UserAvatar, imgDate;
    private RadioGroup rdG;
    private List<PhatTu> list = new ArrayList<>();
    private String gender;
    int positionSpinnerQuocGia, posSpinnerXa, posSpinnerXaNguoiThan, posSpinnerQuan, posSpinnerQuanNguoiThan, posSpinnerSuKien, postChuaHoatDong, posSpinnerNoiSinhHoat, posSpinnerThanhPho, posSpinnerThanhPhoNguoiThan;
    private String uriFile;
    int idGender;
    private Uri uri;
    String ID, hoVaDem, Ten, DiaChi, SoDienThoai, PhapDanh, email, ngaySinh, nguoiBaoLanh, SDTnguoiBaoLanh, NguoiThan, SDTnguoiThan, DiaChiNguoiThan, CMT, quocGia;
    String tinh, tinhNguoiThan, quan, quanNguoiThan, xa, xaNguoiThan, chuaHoatDong, sukien, anh, ghichu;
    String token;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_user);
        initView();
        Intent i = getIntent();
        String data = i.getStringExtra("token1");
        token = "Bearer " + data;
        list = new ArrayList<>();
        rdG.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (rdNam.isChecked()) {
                    idGender = 1;
                } else if (rdNu.isChecked()) {
                    idGender = 2;
                } else if (rdKhac.isChecked()) {
                    idGender = 3;
                }
                Log.e("idGender", idGender + "");
            }
        });


        SpinnerQuocGia.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                int idItemQuocGia = quocGiaList.get(position).getIdQuocGia();
                positionSpinnerQuocGia = idItemQuocGia;
                getTinh(idItemQuocGia);
                Log.e("idItemQuocGia", idItemQuocGia + "");

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });

        SpinnerThanhPho.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                int itemTinh = tinhList.get(position).getId();
                posSpinnerThanhPho = itemTinh;
                getHuyen(itemTinh);

                Log.e("posThanhPho", itemTinh + "");

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });
        SpinnerQuan.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                int itemQuan = huyenList.get(position).getId();
                posSpinnerQuan = itemQuan;
                getXa(itemQuan);
                Log.e("pos", posSpinnerQuan + "");
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });
        SpinnerXa.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                int itemXa = xaList.get(position).getId();
                posSpinnerXa = itemXa;
                Log.e("pos", posSpinnerXa + "");
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });
        SpinnerThanhPhoNguoiThan.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                int itemTPNguoiThan = tinhList.get(position).getId();
                posSpinnerThanhPhoNguoiThan = itemTPNguoiThan;
                getHuyenNguoiThan(itemTPNguoiThan);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        SpinnerQuanNguoiThan.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                int itemQuan = huyenList.get(position).getId();
                posSpinnerQuanNguoiThan = itemQuan;
                getXaNguoiThan(itemQuan);
                Log.e("pos", posSpinnerQuanNguoiThan + "");
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });
        SpinnerXaNguoiThan.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                int itemXaNguoiThan = xaList.get(position).getId();
                posSpinnerXa = itemXaNguoiThan;
                Log.e("pos", posSpinnerXa + "");
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });


        getSuKien();
        getQuocGia();
        getChuaHoatDong();
        //    setUpSpinner();
        listener();


    }

//    private void setUpSpinner() {
//        spinnerSuKien.setOnItemSelectedListener(this);
//        SpinnerThanhPhoNguoiThan.setOnItemSelectedListener(this);
//        SpinnerQuocGia.setOnItemSelectedListener(this);
//        SpinnerThanhPho.setOnItemSelectedListener(this);
//        SpinnerQuan.setOnItemSelectedListener(this);
//        SpinnerQuanNguoiThan.setOnItemSelectedListener(this);
//        SpinnerXa.setOnItemSelectedListener(this);
//        SpinnerXaNguoiThan.setOnItemSelectedListener(this);
//        SpinnerNoiSinhHoat.setOnItemSelectedListener(this);
//    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        switch (view.getId()) {
            case R.id.SpinnerQuocGia:
                positionSpinnerQuocGia = quocGiaList.get(position).getIdQuocGia();
                Log.e("posQuocGia", String.valueOf(positionSpinnerQuocGia));
                break;
            case R.id.SpinnerThanhPho:
                int itemThanhPho = tinhList.get(position).getId();
                posSpinnerThanhPho = itemThanhPho;
                getHuyen(posSpinnerThanhPho);
                Log.e("posTinh", posSpinnerThanhPho + "");
                break;
            case R.id.SpinnerQuan:
                posSpinnerQuan = huyenList.get(position).getId();
                Log.e("pos", posSpinnerQuan + "");
                break;
            case R.id.SpinnerXa:
                posSpinnerXa = xaList.get(position).getId();
                Log.e("pos", posSpinnerXa + "");
                break;
            case R.id.SpinnerNoiSinhHoat:
                posSpinnerNoiSinhHoat = chuaHoatDongList.get(position).getId();
                Log.e("pos", posSpinnerNoiSinhHoat + "");
                break;
            case R.id.SpinnerXaNguoiThan:
                posSpinnerXaNguoiThan = xaList.get(position).getId();
                Log.e("pos", posSpinnerXaNguoiThan + "");
                break;
            case R.id.SpinnerQuanNguoiThan:
                posSpinnerQuanNguoiThan = huyenList.get(position).getId();
                Log.e("pos", posSpinnerQuanNguoiThan + "");
                break;
            case R.id.SpinnerThanhPhoNguoiThan:
                posSpinnerThanhPhoNguoiThan = tinhList.get(position).getId();
                Log.e("pos", posSpinnerThanhPhoNguoiThan + "");
                break;
            case R.id.spinnerSuKien:
                posSpinnerSuKien = chuaHoatDongList.get(position).getId();
                Log.e("pos", posSpinnerSuKien + "");
                break;

        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    private void listener() {
        imgDate.setOnClickListener(this);
        btnUploadAvatar.setOnClickListener(this);
        btnAddUser.setOnClickListener(this);
    }

    private void addUser() {
        //validate();
        ID = edtID.getText().toString();
        hoVaDem = edtHoVaDem.getText().toString();
        Ten = edtTenUser.getText().toString();
        DiaChi = edtDiaChi.getText().toString();
        SoDienThoai = edtSoDienThoai.getText().toString();
        PhapDanh = edtPhapDanh.getText().toString();
        email = edtEmail.getText().toString();
        ngaySinh = edtNgaySinh.getText().toString();
        nguoiBaoLanh = edtNguoiBaoLanh.getText().toString();
        SDTnguoiBaoLanh = edtSDTNguoiBaoLanh.getText().toString();
        NguoiThan = edtTenNguoiThan.getText().toString();
        SDTnguoiThan = edtSDTNguoiThan.getText().toString();
        DiaChiNguoiThan = edtDiaChiNguoiThan.getText().toString();
        CMT = edtCMT.getText().toString();
        quocGia = String.valueOf(positionSpinnerQuocGia);
        tinh = String.valueOf(posSpinnerThanhPho);
        tinhNguoiThan = String.valueOf(posSpinnerThanhPhoNguoiThan);
        quan = String.valueOf(posSpinnerQuan);
        quanNguoiThan = String.valueOf(posSpinnerQuanNguoiThan);
        xa = String.valueOf(posSpinnerXa);
        xaNguoiThan = String.valueOf(posSpinnerXaNguoiThan);
        chuaHoatDong = String.valueOf(postChuaHoatDong);
        sukien = String.valueOf(posSpinnerSuKien);
        anh = tvGetContent.getText().toString();
        ghichu = edtGhiChu.getText().toString();
        Log.e("idgender", gender + "");
        Log.e("dataImage", anh + "");
        PhatTu phatTu = new PhatTu(hoVaDem, Ten, PhapDanh, DiaChi, SoDienThoai, CMT, ID, email, nguoiBaoLanh, SDTnguoiBaoLanh, NguoiThan, SDTnguoiThan, DiaChiNguoiThan, ngaySinh, idGender, quocGia, tinh, quan, xa, quanNguoiThan, xaNguoiThan, tinhNguoiThan, chuaHoatDong, sukien, anh);
        Log.e("phatTu", phatTu.toString());
        list.add(phatTu);
        AddUser(hoVaDem, Ten, PhapDanh, DiaChi, SoDienThoai, CMT, ID, email, nguoiBaoLanh, SDTnguoiBaoLanh, NguoiThan, SDTnguoiThan, DiaChiNguoiThan, ngaySinh, idGender, quocGia, tinh, quan, xa, quanNguoiThan, xaNguoiThan, tinhNguoiThan, chuaHoatDong, sukien, anh, ghichu);
        Intent i = new Intent(AddUserActivity.this, ListUserActivity.class);
        Intent intent = getIntent();
        String token = intent.getStringExtra("token1");
        i.putExtra("token1", token);
        startActivity(i);
        Toast.makeText(AddUserActivity.this, "Phật tử : " + phatTu, Toast.LENGTH_SHORT).show();
    }

    private void clickImageDate() {
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

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.imgDate:
                clickImageDate();
                break;
            case R.id.btnUploadAvatar:
                Intent intent = new Intent();
                intent.setType("image/*");
                intent.setAction(Intent.ACTION_GET_CONTENT);
                startActivityForResult(Intent.createChooser(intent, "Select Picture"), PICK_IMAGE_REQUEST);
                break;
            case R.id.btnAddUser:
                addUser();
                break;
        }
    }

    private void getChuaHoatDong() {

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
                            ChuaHoatDong chuaHoatDong = new ChuaHoatDong(chua, id);
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

    private void getXa(int idHuyen) {
        adapterXa = new AdapterXa(xaList, getApplicationContext());
        RetrofitService.getInstance().getXatheoIdHuyen(token, idHuyen).enqueue(new Callback<XaResponse>() {
            @Override
            public void onResponse(Call<XaResponse> call, Response<XaResponse> response) {
                if (response.isSuccessful()) {
                    ArrayAdapter<Xa> dataAdapter = new ArrayAdapter(getApplication(), android.R.layout.simple_spinner_item, xaList);
                    dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    dataAdapter.clear();
                    xaList.addAll(response.body().xaList);
                    SpinnerXa.setAdapter(dataAdapter);
                    dataAdapter.notifyDataSetChanged();
                    adapterXa.notifyDataSetChanged();
                }
            }

            @Override
            public void onFailure(Call<XaResponse> call, Throwable t) {
            }
        });
    }

    private void getXaNguoiThan(int idHuyen) {
        adapterXa = new AdapterXa(xaList, getApplicationContext());
        RetrofitService.getInstance().getXatheoIdHuyen(token, idHuyen).enqueue(new Callback<XaResponse>() {
            @Override
            public void onResponse(Call<XaResponse> call, Response<XaResponse> response) {
                if (response.isSuccessful()) {
                    ArrayAdapter<Xa> dataAdapter = new ArrayAdapter(getApplication(), android.R.layout.simple_spinner_item, xaList);
                    dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    dataAdapter.clear();
                    xaList.addAll(response.body().xaList);
                    SpinnerXaNguoiThan.setAdapter(dataAdapter);
                    dataAdapter.notifyDataSetChanged();
                    adapterXa.notifyDataSetChanged();
                }
            }

            @Override
            public void onFailure(Call<XaResponse> call, Throwable t) {
            }
        });
    }

    private void getHuyen(int idTinh) {
        adapterHuyen = new AdapterHuyen(huyenList, getApplicationContext());
        RetrofitService.getInstance().getHuyentheoIdTinh(token, idTinh).enqueue(new Callback<HuyenResponse>() {
            @Override
            public void onResponse(Call<HuyenResponse> call, Response<HuyenResponse> response) {
                if (response.isSuccessful()) {
                    ArrayAdapter<Huyen> dataAdapter = new ArrayAdapter(AddUserActivity.this,
                            android.R.layout.simple_spinner_item, huyenList);
                    dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    dataAdapter.clear();
                    huyenList.addAll(response.body().huyenList);
                    SpinnerQuan.setAdapter(dataAdapter);
                    dataAdapter.notifyDataSetChanged();
                    adapterHuyen.notifyDataSetChanged();
                }
            }

            @Override
            public void onFailure(Call<HuyenResponse> call, Throwable t) {
            }
        });
    }

    private void getHuyenNguoiThan(int idTinh) {
        adapterHuyen = new AdapterHuyen(huyenList, getApplicationContext());
        RetrofitService.getInstance().getHuyentheoIdTinh(token, idTinh).enqueue(new Callback<HuyenResponse>() {
            @Override
            public void onResponse(Call<HuyenResponse> call, Response<HuyenResponse> response) {
                if (response.isSuccessful()) {
                    ArrayAdapter<Huyen> dataAdapter = new ArrayAdapter(AddUserActivity.this,
                            android.R.layout.simple_spinner_item, huyenList);
                    dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    dataAdapter.clear();
                    huyenList.addAll(response.body().huyenList);
                    SpinnerQuanNguoiThan.setAdapter(dataAdapter);
                    dataAdapter.notifyDataSetChanged();
                    adapterHuyen.notifyDataSetChanged();
                }
            }

            @Override
            public void onFailure(Call<HuyenResponse> call, Throwable t) {
            }
        });
    }

    private void getTinh(int idQuocGia) {
        adapterTinh = new AdapterTinh(tinhList, getApplicationContext());
        RetrofitService.getInstance().getTinh(token, idQuocGia).enqueue(new Callback<TinhResponse>() {
            @Override
            public void onResponse(Call<TinhResponse> call, Response<TinhResponse> response) {
                if (response.isSuccessful()) {
                    ArrayAdapter<Tinh> dataAdapter = new ArrayAdapter(AddUserActivity.this,
                            android.R.layout.simple_spinner_item, tinhList);
                    dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    SpinnerThanhPhoNguoiThan.setAdapter(dataAdapter);
                    SpinnerThanhPho.setAdapter(dataAdapter);
                    tinhList.addAll(response.body().listTinh);
                    dataAdapter.notifyDataSetChanged();
                    Log.d("abc", tinhList.get(0).getTenQuocGia() + "");
                }
            }

            @Override
            public void onFailure(Call<TinhResponse> call, Throwable t) {
            }
        });
    }


    public void getQuocGia() {
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
                            DuLieuThongKe duLieuThongKe = new DuLieuThongKe(tenSuKien, id);
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

    private void AddUser(final String hoVaDem, final String ten, final String phapDanh, final String diaChi, final String soDienThoai, final String CMT, final String ID, final String email, final String nguoiBaoLanh, final String SDTnguoiBaoLanh, final String nguoiThan, final String SDTnguoiThan, final String diaChiNguoiThan, final String ngaySinh, final int gender, final String quocGia, final String tinh, final String quan, final String xa, final String quanNguoiThan, final String xaNguoiThan, final String tinhNguoiThan, final String chuaHoatDong, final String sukien, String anh, String ghichu) {
        RetrofitService.getInstance().postNewPhatTu(token, ID, "", "",
                quocGia, hoVaDem, ten, phapDanh, this.gender, ngaySinh, soDienThoai, diaChi, xa,
                quan, tinh, email, "", nguoiThan, SDTnguoiThan, diaChiNguoiThan, xaNguoiThan,
                quanNguoiThan, tinhNguoiThan, ghichu, "", "", "",
                "", "", "", "", nguoiBaoLanh, SDTnguoiBaoLanh,
                chuaHoatDong, "", CMT, anh, "", "", "", "", "")
                .enqueue(new Callback<ResponseBody>() {
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
            uri = data.getData();

            uploadFile(data.getData());
            UserAvatar.setImageURI(uri);
            Log.e("uri", uri + "");

            String content = uri.toString();
            tvGetContent.setText(content);

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
        checkboxQuyY = findViewById(R.id.checkboxQuyY);
        tvSuKien = findViewById(R.id.tvSuKien);
        tvGetContent = findViewById(R.id.tvGetContent);
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
        edtGhiChu = findViewById(R.id.edtGhiChu);
    }

//    public void validate() {
//        if (edtCMT.equals("")) {
//            Toast.makeText(this, "Nhập đầy đủ thông tin", Toast.LENGTH_SHORT).show();
//            return;
//        } else if (edtTenUser.equals("")) {
//            Toast.makeText(this, "Nhập đầy đủ thông tin", Toast.LENGTH_SHORT).show();
//            return;
//        } else if (edtNgaySinh.equals("")) {
//
//            Toast.makeText(this, "Nhập đầy đủ thông tin", Toast.LENGTH_SHORT).show();
//            return;
//        }
//    }

    private void uploadFile(Uri fileUri) {
        File orifile = FileUtils.getFile(getApplicationContext(), fileUri);
        RequestBody status = RequestBody.create(MediaType.parse("text/plain"), "");
        RequestBody message = RequestBody.create(MediaType.parse("text/plain"), "");
        RequestBody filePart = RequestBody.create(MediaType.parse(getContentResolver().getType(fileUri)), orifile);
        MultipartBody.Part file = MultipartBody.Part.createFormData("data", orifile.getName(), filePart);
        RetrofitService.getInstance().uploadImage(token, status, message, file).enqueue(new Callback<ImageResponse>() {
            @Override
            public void onResponse(Call<ImageResponse> call, Response<ImageResponse> response) {
                if (response.code() == 200) {
                    Toast.makeText(AddUserActivity.this, "Success", Toast.LENGTH_SHORT).show();
                    String dataImage = response.body().data;
                    Log.e("response", dataImage + "");
                    Toast.makeText(AddUserActivity.this, "Upload Success", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<ImageResponse> call, Throwable t) {
                Toast.makeText(AddUserActivity.this, "Upload Failed", Toast.LENGTH_SHORT).show();

            }
        });

    }

    private void uploadImageToSever(String filePath) {

        File file = new File(filePath);
        RequestBody fileRequest = RequestBody.create(MediaType.parse("image/*"), file);
        MultipartBody.Part part = MultipartBody.Part.createFormData("upload", file.getName(), fileRequest);
        RequestBody message = RequestBody.create(MediaType.parse("text/plain"), "message");
        RequestBody status = RequestBody.create(MediaType.parse("text/plain"), "status");
        RetrofitService.getInstance().uploadImage(token, status, message, part).enqueue(new Callback<ImageResponse>() {
            @Override
            public void onResponse(Call<ImageResponse> call, Response<ImageResponse> response) {
                if (response.isSuccessful()) {
                    Log.e("imgData", response.body().data + "");
                    Toast.makeText(AddUserActivity.this, "Upload Success", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<ImageResponse> call, Throwable t) {
                Toast.makeText(AddUserActivity.this, "Upload Failed", Toast.LENGTH_SHORT).show();

            }
        });
    }


}
