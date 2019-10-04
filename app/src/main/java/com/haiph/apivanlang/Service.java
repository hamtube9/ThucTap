package com.haiph.apivanlang;

import com.haiph.apivanlang.model.User;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Path;


public interface Service {

@GET("/api/phat-tu/danh-sach/{fromDate}/{toDate}")
    Call<List<User>> getFromDateToDate(@Header("Authorization") String Authorization,
                                       @Path("fromDate") String fromDate,
                                       @Path("toDate") String toDate
                                        );
}
