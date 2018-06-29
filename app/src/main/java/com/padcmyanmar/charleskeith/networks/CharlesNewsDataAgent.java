package com.padcmyanmar.charleskeith.networks;

import com.padcmyanmar.charleskeith.data.vos.GetNewsVO;

import java.util.List;

public interface CharlesNewsDataAgent
{
    void loadCharlesNewsList(int page,String accessToken);

}
