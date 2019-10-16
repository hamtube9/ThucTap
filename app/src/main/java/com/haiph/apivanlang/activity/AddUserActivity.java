package com.haiph.apivanlang.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
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

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AddUserActivity extends AppCompatActivity {
    private Toolbar toolbar;
    TextView tvSuKien;
    Spinner spinnerSuKien, SpinnerQuocGia, SpinnerThanhPho, SpinnerQuan, SpinnerXa, SpinnerNoiSinhHoat, SpinnerQuanNguoiThan, SpinnerXaNguoiThan, SpinnerThanhPhoNguoiThan;
    private EditText edtHoVaDem, edtTenUser, edtDiaChi, edtSoDienThoai, edtPhapDanh, edtCMT, edtID,
            edtEmail, edtNgaySinh, edtNguoiBaoLanh, edtSDTNguoiBaoLanh, edtTenNguoiThan, edtSDTNguoiThan, edtDiaChiNguoiThan;
    private CheckBox checkboxQuyY;
    private Button btnAddUser, btnUploadAvatar;
    private RadioButton rdNam, rdNu, rdKhac;
    SharedPreferences sharedPreferences;


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

    String tenXa, tenHuyen, tenQuocGia, tenTinh, tenSuKien,chua;
    private ImageView UserAvatar, imgDate;
    RadioGroup rdG;
    List<PhatTu> list;
    String gender;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_user);
        initView();

        list = new ArrayList<>();

//        imgDate.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                final Calendar c = Calendar.getInstance();
//                int thang, nam, ngay;
//                ngay = c.get(Calendar.DATE);
//                thang = c.get(Calendar.MONTH);
//                nam = c.get(Calendar.YEAR);
////                        edtNgaySinh.setText(dayOfMonth+"/"+(month+1)+"/"+year);
//                //mDay,mMonth,mYear
//
//                DatePickerDialog datePickerDialog = new DatePickerDialog(AddUserActivity.this, new DatePickerDialog.OnDateSetListener() {
//                    @Override
//                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
//                        c.set(year,month,dayOfMonth);
//                        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yy");
//                        edtNgaySinh.setText(simpleDateFormat.format(c.getTime()));
//                    }
//                }, nam, thang, ngay);
//                datePickerDialog.show();
//            }
//        });

        btnAddUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

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
                String QuocGia = SpinnerQuocGia.getSelectedItem().toString();
                String Tinh = SpinnerThanhPho.getSelectedItem().toString();
                String Quan = SpinnerQuan.getSelectedItem().toString();
                String QuanNguoiThan = SpinnerQuanNguoiThan.getSelectedItem().toString();
                String Xa = SpinnerXa.getSelectedItem().toString();
                String XaNguoiThan = SpinnerXaNguoiThan.getSelectedItem().toString();
                String ChuaHoatDong = SpinnerNoiSinhHoat.getSelectedItem().toString();
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
                PhatTu phatTu = new PhatTu(hoVaDem, Ten, PhapDanh, DiaChi, SoDienThoai, CMT, ID, email, ngaySinh, nguoiBaoLanh,
                        SDTnguoiBaoLanh, NguoiThan, SDTnguoiThan, DiaChiNguoiThan, gender, QuocGia, Tinh, Quan, Xa, XaNguoiThan, QuanNguoiThan,
                        ChuaHoatDong);
                list.add(phatTu);
                Log.e("list", "" + list.add(phatTu));
                AddUser(PhapDanh, Ten, DiaChi, SoDienThoai, CMT, ID);

                Intent i = new Intent(AddUserActivity.this, ListUserActivity.class);

                startActivity(i);

                Toast.makeText(AddUserActivity.this, "Phật tử : " + phatTu, Toast.LENGTH_SHORT).show();
            }
        });

        getSuKien();

        getQuocGia();
        getTinh();
        getHuyen();
        getXa();
        getChuaHoatDong();
    }

    private void getChuaHoatDong() {
        Intent i =getIntent();
        String token = i.getStringExtra("token1");
        Log.e("addUserToken",token+"");
        chuaHoatDongList = new ArrayList<>();
        adapterChuaHoatDong = new AdapterChuaHoatDong(chuaHoatDongList,getApplicationContext());

        OkHttpService.getService().getChuaHoatDong(token).enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                if (response.isSuccessful()) {

                    try {
                        String dulieu = response.body().string();
                        JSONObject objectDuLieu = new JSONObject(dulieu);
                        JSONArray arrayDulieu = objectDuLieu.getJSONArray("data");
                        for (int i = 0; i < arrayDulieu.length(); i++) {
                            JSONObject object = arrayDulieu.getJSONObject(i);

                            chua = object.getString("ten");
                            ChuaHoatDong chuaHoatDong = new ChuaHoatDong(chua);
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
        Intent i =getIntent();
        String token = i.getStringExtra("token1");
        xaList = new ArrayList<>();
        adapterXa = new AdapterXa(xaList, getApplicationContext());
        OkHttpService.getService().getXa(token).enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                if (response.isSuccessful()) {

                    try {
                        String dulieu = response.body().string();
                        JSONObject objectDuLieu = new JSONObject(dulieu);
                        JSONArray arrayDulieu = objectDuLieu.getJSONArray("data");
                        for (int i = 0; i < arrayDulieu.length(); i++) {
                            JSONObject object = arrayDulieu.getJSONObject(i);

                            tenXa = object.getString("ten");
                            Xa quocGia = new Xa(tenXa);
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
        Intent i =getIntent();
        String token ="Bearer"+ i.getStringExtra("token1");

        huyenList = new ArrayList<>();

        adapterHuyen = new AdapterHuyen(huyenList, getApplicationContext());
        OkHttpService.getService().getHuyen(token).enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                if (response.isSuccessful()) {

                    try {
                        String dulieu = response.body().string();
                        JSONObject objectDuLieu = new JSONObject(dulieu);
                        JSONArray arrayDulieu = objectDuLieu.getJSONArray("data");
                        for (int i = 0; i < arrayDulieu.length(); i++) {
                            JSONObject object = arrayDulieu.getJSONObject(i);

                            tenHuyen = object.getString("ten");
                            Huyen quocGia = new Huyen(tenHuyen);
                            huyenList.add(quocGia);
                            adapterHuyen.notifyDataSetChanged();

                            ArrayAdapter<Huyen> dataAdapter = new ArrayAdapter(getApplication(),
                                    android.R.layout.simple_spinner_item, huyenList);
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

    private void getTinh() {
        Intent i =getIntent();
        String token ="Bearer"+ i.getStringExtra("token1");


        tinhList = new ArrayList<>();
        adapterTinh = new AdapterTinh(tinhList, getApplicationContext());
        OkHttpService.getService().getTinh(token).enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                if (response.isSuccessful()) {

                    try {
                        String dulieu = response.body().string();
                        JSONObject objectDuLieu = new JSONObject(dulieu);
                        JSONArray arrayDulieu = objectDuLieu.getJSONArray("data");
                        for (int i = 0; i < arrayDulieu.length(); i++) {
                            JSONObject object = arrayDulieu.getJSONObject(i);

                            tenTinh = object.getString("ten");
                            Tinh quocGia = new Tinh(tenTinh);
                            tinhList.add(quocGia);
                            adapterTinh.notifyDataSetChanged();

                            ArrayAdapter<Tinh> dataAdapter = new ArrayAdapter(getApplication(),
                                    android.R.layout.simple_spinner_item, tinhList);
                            dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                            SpinnerThanhPho.setAdapter(dataAdapter);
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

    public void getQuocGia() {
        Intent i =getIntent();
        String token ="Bearer"+ i.getStringExtra("token1");

        quocGiaList = new ArrayList<>();
        adapterQuocGia = new AdapterQuocGia(quocGiaList, getApplicationContext());


        OkHttpService.getService().getQuocGia(token).enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                if (response.isSuccessful()) {

                    try {
                        String dulieu = response.body().string();
                        JSONObject objectDuLieu = new JSONObject(dulieu);
                        JSONArray arrayDulieu = objectDuLieu.getJSONArray("data");
                        for (int i = 0; i < arrayDulieu.length(); i++) {
                            JSONObject object = arrayDulieu.getJSONObject(i);

                            tenQuocGia = object.getString("ten");
                            QuocGia quocGia = new QuocGia(tenQuocGia);
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
        Intent i =getIntent();
        String token ="Bearer"+ i.getStringExtra("token1");

        adapterDuLieuThongKe = new AdapterDuLieuThongKe(duLieuThongKeList, getApplicationContext());

        OkHttpService.getService().getDuLieu(token, "2019").enqueue(new Callback<ResponseBody>() {
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

                            tenSuKien = object.getString("tenSuKien");
                            DuLieuThongKe duLieuThongKe = new DuLieuThongKe(tenSuKien);
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


    private void AddUser(final String PhapDanh, final String Ten, final String DiaChi, final String SoDienThoai, String CMT, String ID) {
        Intent i =getIntent();
        String token ="Bearer"+ i.getStringExtra("token1");

        Log.e("tokenAddUser", "token : " + token);
        OkHttpService.getService().postNewPhatTu(token, ID, "", "", SpinnerQuocGia.getSelectedItem().toString(),
                edtHoVaDem.getText().toString(), Ten, PhapDanh, gender, edtNgaySinh.getText().toString(), SoDienThoai, DiaChi, SpinnerXa.getSelectedItem().toString(),
                SpinnerQuan.getSelectedItem().toString(), SpinnerThanhPho.getSelectedItem().toString(), edtEmail.getText().toString(), "", edtTenNguoiThan.getText().toString(),
                edtSDTNguoiThan.getText().toString(), edtDiaChiNguoiThan.getText().toString(), "", SpinnerXaNguoiThan.getSelectedItem().toString(),
                SpinnerThanhPhoNguoiThan.getSelectedItem().toString(), "", "", "", "",
                "", "", "", "",  edtNguoiBaoLanh.getText().toString(),edtSDTNguoiBaoLanh.getText().toString(),
                "", "", CMT, "",
                "", "", "", "", "").enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                if (response.isSuccessful()) {
                    response.body();

                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                Log.e("loiAddUser", t.getMessage());
            }
        });
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

        //up anh
        btnUploadAvatar = findViewById(R.id.btnUploadAvatar);
        UserAvatar = findViewById(R.id.UserAvatar);


        imgDate = findViewById(R.id.imgDate);

        checkboxQuyY = findViewById(R.id.checkboxQuyY);
        tvSuKien = findViewById(R.id.tvSuKien);


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
        edtHoVaDem = findViewById(R.id.edtHoVaDem);
        edtEmail = findViewById(R.id.edtEmail);
        edtNguoiBaoLanh = findViewById(R.id.edtNguoiBaoLanh);
        edtSDTNguoiBaoLanh = findViewById(R.id.edtSDTNguoiBaoLanh);
        edtTenNguoiThan = findViewById(R.id.edtTenNguoiThan);
        edtSDTNguoiThan = findViewById(R.id.edtSDTNguoiThan);
        edtDiaChiNguoiThan = findViewById(R.id.edtDiaChiNguoiThan);
    }
}
