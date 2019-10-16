package com.haiph.apivanlang.response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ImageResponse extends BaseResponse {
    @SerializedName("data")
    @Expose
    public String data;

    @Override
    public String toString() {
        return "ImageResponse{" +
                "data='" + data + '\'' +
                '}';
    }
}
