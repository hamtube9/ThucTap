package com.haiph.apivanlang.response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class BaseResponse {
    @SerializedName("status")
    @Expose
    public String status;

    @SerializedName("message")
    @Expose
    public String message;
}
