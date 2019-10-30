package com.haiph.apivanlang.response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.haiph.apivanlang.model.Huyen;
import com.haiph.apivanlang.model.Tinh;

import java.util.ArrayList;
import java.util.List;

public class HuyenResponse extends BaseResponse {
    @SerializedName("data")
    @Expose
    public List<Huyen> huyenList = new ArrayList<>();
}
