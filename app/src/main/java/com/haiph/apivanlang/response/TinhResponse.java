package com.haiph.apivanlang.response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.haiph.apivanlang.model.Tinh;

import java.util.ArrayList;
import java.util.List;

public class TinhResponse extends BaseResponse {
    @SerializedName("data")
    @Expose
    public List<Tinh> listTinh = new ArrayList<>();
}
