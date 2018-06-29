package com.padcmyanmar.charleskeith.networks;

import com.padcmyanmar.charleskeith.networks.response.GetNewsResponse;
import com.padcmyanmar.charleskeith.utils.CharlesNewsConstant;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface CharlesNewsApi
{
    @FormUrlEncoded
    @POST(CharlesNewsConstant.GET_NEWS)
    Call<GetNewsResponse> loadCharlesNewsList(
        @Field(CharlesNewsConstant.PARAM_ACCESS_TOKEN) String accessToken,
        @Field(CharlesNewsConstant.PARAM_ACCESS_PAGE) int page);
}
