package com.padcmyanmar.charleskeith.data.models;

import com.padcmyanmar.charleskeith.data.vos.GetNewsVO;
import com.padcmyanmar.charleskeith.events.SuccessGetCharlesNewsEvent;
import com.padcmyanmar.charleskeith.networks.CharlesNewsDataAgent;
import com.padcmyanmar.charleskeith.networks.RetrofitDataAgentImpl;
import com.padcmyanmar.charleskeith.utils.CharlesNewsConstant;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GetNewsModels {
    private static GetNewsModels objInstance;
    private CharlesNewsDataAgent charlesDataAgent;
    private Map<String, GetNewsVO> mcharlesMap;

    public GetNewsModels() {
        charlesDataAgent = RetrofitDataAgentImpl.getsObjInstance();
        mcharlesMap = new HashMap<>();
        EventBus.getDefault().register(this);
    }

    public static GetNewsModels getObjInstance() {
        if (objInstance == null) {
            objInstance = new GetNewsModels();
        }
        return objInstance;
    }


    public void loadCharlesList() {
        charlesDataAgent.loadCharlesNewsList(1, CharlesNewsConstant.DUMMY_ACCESS_TOKEN);
    }
    public GetNewsVO getCharlesById(String charlesId)
    {
        return mcharlesMap.get(charlesId);
    }

    @Subscribe(threadMode = ThreadMode.BACKGROUND)
    public void onSuccessGetNews(SuccessGetCharlesNewsEvent event)
    {
        for(GetNewsVO newsVO:event.getCharlesList())
        {
            mcharlesMap.put(String.valueOf(newsVO.getProductId()),newsVO);
        }
    }
    public List<GetNewsVO> getCharlesList()
    {
        return new ArrayList<>(mcharlesMap.values());
    }
}