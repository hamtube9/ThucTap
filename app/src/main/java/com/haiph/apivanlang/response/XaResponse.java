package com.haiph.apivanlang.response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.haiph.apivanlang.model.Xa;

import java.util.ArrayList;
import java.util.List;

public class XaResponse extends BaseResponse{
    @SerializedName("data")
    @Expose
    public List<Xa> xaList = new ArrayList<>();
}
