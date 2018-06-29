package com.padcmyanmar.charleskeith.networks.response;

import com.google.gson.annotations.SerializedName;
import com.padcmyanmar.charleskeith.data.vos.GetNewsVO;

import java.util.List;

public class GetNewsResponse {
    @SerializedName("code")
    private int code;
    @SerializedName("message")
    private String message;
    @SerializedName("apiVersion")
    private String apiVersion;
    @SerializedName("page")
    private String page;
    @SerializedName("newProducts")
    private List<GetNewsVO> charlesNewsIn;

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    public String getApiVersion() {
        return apiVersion;
    }

    public String getPage() {
        return page;
    }

    public List<GetNewsVO> getCharlesNewsIn() {
        return charlesNewsIn;
    }

    public boolean isResponse()
    {
        return (code==200 && charlesNewsIn!=null);
    }
}


