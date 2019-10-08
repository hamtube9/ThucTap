package com.haiph.apivanlang;

import com.haiph.apivanlang.model.Token;
import com.haiph.apivanlang.model.User;

import java.util.List;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;
import retrofit2.http.Query;


public interface Service {

//    @GET("/api/phat-tu/danh-sach/{fromDate}/{toDate}")
//    Call<List<User>> getFromDateToDate(@Header("Authorization") String Authorization,
//                                       @Path("fromDate") String fromDate,
//                                       @Path("toDate") String toDate
//    );

    @GET("/api/phat-tu/danh-sach/{fromDate}/{toDate}")
    Call<ResponseBody> getFromDateToDate(@Header("Authorization") String Authorization,
                                       @Path("fromDate") String fromDate,
                                       @Path("toDate") String toDate
    );

    @FormUrlEncoded
    @POST("token")
    Call<Token> getToken(
            @Field("grant_type") String grantType,
            @Field("username") String userName,
            @Field("password") String passWord
    );
}
