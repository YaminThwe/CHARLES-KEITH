package com.padcmyanmar.charleskeith.networks;

import com.padcmyanmar.charleskeith.data.vos.GetNewsVO;
import com.padcmyanmar.charleskeith.events.ApiErrorEvent;
import com.padcmyanmar.charleskeith.events.SuccessGetCharlesNewsEvent;
import com.padcmyanmar.charleskeith.networks.response.GetNewsResponse;
import com.padcmyanmar.charleskeith.utils.CharlesNewsConstant;

import org.greenrobot.eventbus.EventBus;

import java.util.List;
import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitDataAgentImpl implements CharlesNewsDataAgent
{
    private static RetrofitDataAgentImpl sObjInstance;
    private CharlesNewsApi cTheApi;

    public RetrofitDataAgentImpl()
    {
        final OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .connectTimeout(15, TimeUnit.SECONDS)
                .writeTimeout(15, TimeUnit.SECONDS)
                .readTimeout(60, TimeUnit.SECONDS)
                .build();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(CharlesNewsConstant.API_BASE)
                .addConverterFactory(GsonConverterFactory.create())
                .client(okHttpClient)
                .build();
        cTheApi=retrofit.create(CharlesNewsApi.class);
    }
    public static RetrofitDataAgentImpl getsObjInstance()
    {
        if(sObjInstance==null)
        {
            sObjInstance=new RetrofitDataAgentImpl();
        }
        return sObjInstance;
    }

    @Override
    public void loadCharlesNewsList(int page, String accessToken)
    {
        Call<GetNewsResponse> loadNewsCall =  cTheApi.loadCharlesNewsList(accessToken, page);
        loadNewsCall.enqueue(new Callback<GetNewsResponse>() {
            @Override
            public void onResponse(Call<GetNewsResponse> call, Response<GetNewsResponse> response) {
                GetNewsResponse newsResponse = response.body();
                if (newsResponse != null && newsResponse.isResponse()) {
                    SuccessGetCharlesNewsEvent event = new SuccessGetCharlesNewsEvent(newsResponse.getCharlesNewsIn());
                    EventBus.getDefault().post(event);

                } else {
                    if (newsResponse == null) {
                        ApiErrorEvent event = new ApiErrorEvent("Empty response in network call.");
                        EventBus.getDefault().post(event);
                    } else {
                        ApiErrorEvent event = new ApiErrorEvent(newsResponse.getMessage());
                        EventBus.getDefault().post(event);
                    }
                }
            }




            @Override
            public void onFailure(Call<GetNewsResponse> call, Throwable t) {
                ApiErrorEvent event = new ApiErrorEvent(t.getMessage());
                EventBus.getDefault().post(event);
            }
        });
    }


}
