package com.padcmyanmar.charleskeith.delegates;

import com.padcmyanmar.charleskeith.data.vos.GetNewsVO;

public interface CharlesNewsDelegate
{
    void onTapNews(GetNewsVO newsVO);
    void onTapDetailNews();
}
