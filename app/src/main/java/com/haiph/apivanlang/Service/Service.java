package com.haiph.apivanlang.Service;

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

    @FormUrlEncoded
    @POST("api/phat-tu/them-moi")
    Call<ResponseBody> postNewPhatTu(@Header("Authorization") String Authorization,
                                     @Field("id") String id,
                                     @Field("anhDaiDien") String anhDaiDien,
                                     @Field("ma") String ma,
                                     @Field("idQuocGia") String idQuocGia,
                                     @Field("ho") String ho,
                                     @Field("ten") String ten,
                                     @Field("phapDanh") String phapDanh,
                                     @Field("gioiTinh") String gioiTinh,
                                     @Field("ngaySinh") String ngaySinh,
                                     @Field("soDienThoai") String soDienThoai,
                                     @Field("soNha") String soNha,
                                     @Field("idXa") String idXa,
                                     @Field("idHuyen") String idHuyen,
                                     @Field("idTinh") String idTinh,
                                     @Field("email") String email,
                                     @Field("ngheNghiep") String ngheNghiep,
                                     @Field("nguoiThan_HoVaTen") String nguoiThan_HoVaTen,
                                     @Field("nguoiThan_SoDienThoai") String nguoiThan_SoDienThoai,
                                     @Field("nguoiThan_SoNha") String nguoiThan_SoNha,
                                     @Field("nguoiThan_IDXa") String nguoiThan_IDXa,
                                     @Field("nguoiThan_IDHuyen") String nguoiThan_IDHuyen,
                                     @Field("nguoiThan_IDTinh") String nguoiThan_IDTinh,
                                     @Field("ghiChu") String ghiChu,
                                     @Field("idDonVi") String idDonVi,
                                     @Field("inUsed") String inUsed,
                                     @Field("createdBy") String createdBy,
                                     @Field("createdOn") String createdOn,
                                     @Field("editedBy") String editedBy,
                                     @Field("editedOn") String editedOn,
                                     @Field("idNguoiBaoLanh") String idNguoiBaoLanh,
                                     @Field("nguoiBaoLanh") String nguoiBaoLanh,
                                     @Field("nguoiBaoLanh_SoDienThoai") String nguoiBaoLanh_SoDienThoai,
                                     @Field("idCoCauToChuc") String idCoCauToChuc,
                                     @Field("status") String status,
                                     @Field("socmtnd") String socmtnd,
                                     @Field("linkAnhDaiDien") String linkAnhDaiDien,
                                     @Field("namSinh") String namSinh,
                                     @Field("ngayVaoChua") String ngayVaoChua,
                                     @Field("namVaoChua") String namVaoChua,
                                     @Field("isChuyenThanhTangNi") String isChuyenThanhTangNi,
                                     @Field("thoiDiemChuyenTangNi") String thoiDiemChuyenTangNi
                                     );
}
