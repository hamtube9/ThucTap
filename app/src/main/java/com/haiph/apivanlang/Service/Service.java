package com.haiph.apivanlang.Service;

import com.haiph.apivanlang.model.Token;
import com.haiph.apivanlang.response.ImageResponse;

import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;
import retrofit2.http.Path;


public interface Service {



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


    @GET("/api/danh-muc/danh-muc-hoat-dong-phat-su")
    Call<ResponseBody> getDuLieu(@Header("Authorization") String Authorization);

    //http://api.testqlpt.vla.vn/

    //
    @GET("/api/danh-muc/danh-muc-co-cau-to-chuc")
    Call<ResponseBody> getChuaHoatDong(@Header("Authorization") String Authorization);

    @GET("/api/danh-muc/danh-muc-xa")
    Call<ResponseBody> getXa(@Header("Authorization") String Authorization);


    @GET("/api/danh-muc/danh-muc-huyen")
    Call<ResponseBody> getHuyen(@Header("Authorization") String Authorization);



    @GET("/api/danh-muc/danh-muc-quoc-gia")
    Call<ResponseBody> getQuocGia(@Header("Authorization") String Authorization);


    @GET("/api/danh-muc/danh-sach-tinh-theo-quoc-gia/{idQuocGia}")
    Call<ResponseBody> getTinh(@Header("Authorization") String Authorization,
                               @Path("idQuocGia") int idQuocGia);





    @Multipart
    @POST("api/anh/upload-anh")
    Call<ResponseBody> uploadImage(@Header("Authorization") String Authorization,
                                   @Part("Status") String status,
                                   @Part("Message") String message,
                                   @Part MultipartBody.Part data);

    @FormUrlEncoded
    @POST("api/phat-tu/them-moi")
    Call<ResponseBody> postNewPhatTu(@Header("Authorization") String Authorization,
                                     @Field("ID") String id,
                                     @Field("AnhDaiDien") String anhDaiDien,
                                     @Field("Ma") String ma,
                                     @Field("IDQuocGia") String idQuocGia,
                                     @Field("Ho") String ho,
                                     @Field("Ten") String ten,
                                     @Field("PhapDanh") String phapDanh,
                                     @Field("GioiTinh") String gioiTinh,
                                     @Field("NgaySinh") String ngaySinh,
                                     @Field("SoDienThoai") String soDienThoai,
                                     @Field("SoNha") String soNha,
                                     @Field("IdXa") String idXa,
                                     @Field("IdHuyen") String idHuyen,
                                     @Field("IdTinh") String idTinh,
                                     @Field("Email") String Email,
                                     @Field("NgheNghiep") String ngheNghiep,
                                     @Field("NguoiThan_HoVaTen") String nguoiThan_HoVaTen,
                                     @Field("NguoiThan_SoDienThoai") String nguoiThan_SoDienThoai,
                                     @Field("NguoiThan_SoNha") String nguoiThan_SoNha,
                                     @Field("NguoiThan_IDXa") String nguoiThan_IDXa,
                                     @Field("NguoiThan_IDHuyen") String nguoiThan_IDHuyen,
                                     @Field("NguoiThan_IDTinh") String nguoiThan_IDTinh,
                                     @Field("GhiChu") String ghiChu,
                                     @Field("IdDonVi") String idDonVi,
                                     @Field("InUsed") String inUsed,
                                     @Field("CreatedBy") String createdBy,
                                     @Field("CreatedOn") String createdOn,
                                     @Field("EditedBy") String editedBy,
                                     @Field("EditedOn") String editedOn,
                                     @Field("IdNguoiBaoLanh") String idNguoiBaoLanh,
                                     @Field("NguoiBaoLanh") String nguoiBaoLanh,
                                     @Field("NguoiBaoLanh_SoDienThoai") String nguoiBaoLanh_SoDienThoai,
                                     @Field("IdCoCauToChuc") String idCoCauToChuc,
                                     @Field("Status") String status,
                                     @Field("Socmtnd") String socmtnd,
                                     @Field("LinkAnhDaiDien") String linkAnhDaiDien,
                                     @Field("NamSinh") String namSinh,
                                     @Field("NgayVaoChua") String ngayVaoChua,
                                     @Field("NamVaoChua") String namVaoChua,
                                     @Field("IsChuyenThanhTangNi") String isChuyenThanhTangNi,
                                     @Field("ThoiDiemChuyenTangNi") String thoiDiemChuyenTangNi
                                     );




    @FormUrlEncoded
    @POST("api/phat-tu/cap-nhat")
    Call<ResponseBody> postEditPhatTu(@Header("Authorization") String Authorization,
                                      @Field("ID") String id,
                                      @Field("AnhDaiDien") String anhDaiDien,
                                      @Field("Ma") String ma,
                                      @Field("IDQuocGia") String idQuocGia,
                                      @Field("Ho") String ho,
                                      @Field("Ten") String ten,
                                      @Field("PhapDanh") String phapDanh,
                                      @Field("GioiTinh") String gioiTinh,
                                      @Field("NgaySinh") String ngaySinh,
                                      @Field("SoDienThoai") String soDienThoai,
                                      @Field("SoNha") String soNha,
                                      @Field("IdXa") String idXa,
                                      @Field("IdHuyen") String idHuyen,
                                      @Field("IdTinh") String idTinh,
                                      @Field("Email") String Email,
                                      @Field("NgheNghiep") String ngheNghiep,
                                      @Field("NguoiThan_HoVaTen") String nguoiThan_HoVaTen,
                                      @Field("NguoiThan_SoDienThoai") String nguoiThan_SoDienThoai,
                                      @Field("NguoiThan_SoNha") String nguoiThan_SoNha,
                                      @Field("NguoiThan_IDXa") String nguoiThan_IDXa,
                                      @Field("NguoiThan_IDHuyen") String nguoiThan_IDHuyen,
                                      @Field("NguoiThan_IDTinh") String nguoiThan_IDTinh,
                                      @Field("GhiChu") String ghiChu,
                                      @Field("IdDonVi") String idDonVi,
                                      @Field("InUsed") String inUsed,
                                      @Field("CreatedBy") String createdBy,
                                      @Field("CreatedOn") String createdOn,
                                      @Field("EditedBy") String editedBy,
                                      @Field("EditedOn") String editedOn,
                                      @Field("IdNguoiBaoLanh") String idNguoiBaoLanh,
                                      @Field("NguoiBaoLanh") String nguoiBaoLanh,
                                      @Field("NguoiBaoLanh_SoDienThoai") String nguoiBaoLanh_SoDienThoai,
                                      @Field("IdCoCauToChuc") String idCoCauToChuc,
                                      @Field("Status") String status,
                                      @Field("Socmtnd") String socmtnd,
                                      @Field("LinkAnhDaiDien") String linkAnhDaiDien,
                                      @Field("NamSinh") String namSinh,
                                      @Field("NgayVaoChua") String ngayVaoChua,
                                      @Field("NamVaoChua") String namVaoChua,
                                      @Field("IsChuyenThanhTangNi") String isChuyenThanhTangNi,
                                      @Field("ThoiDiemChuyenTangNi") String thoiDiemChuyenTangNi
    );

    @GET("api/phat-tu/xoa/{idPhatTu}")
    Call<ResponseBody> deletePhatTu(@Header("Authorization") String Authorization
            ,@Path("idPhatTu") String idPhatTu);


}
