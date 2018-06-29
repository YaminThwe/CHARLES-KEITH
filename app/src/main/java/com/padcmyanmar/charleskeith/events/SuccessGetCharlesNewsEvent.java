package com.padcmyanmar.charleskeith.events;

import com.padcmyanmar.charleskeith.data.vos.GetNewsVO;

import java.util.List;

public class SuccessGetCharlesNewsEvent
{
    private List<GetNewsVO> charlesList;

    public SuccessGetCharlesNewsEvent(List<GetNewsVO> charlesList) {
        this.charlesList = charlesList;
    }
    public List<GetNewsVO> getCharlesList()
    {
        return charlesList;
    }
}
