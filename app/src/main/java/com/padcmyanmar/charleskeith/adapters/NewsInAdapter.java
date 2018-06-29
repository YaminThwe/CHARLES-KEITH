package com.padcmyanmar.charleskeith.adapters;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.padcmyanmar.charleskeith.R;
import com.padcmyanmar.charleskeith.activities.NewInActivity;
import com.padcmyanmar.charleskeith.data.vos.GetNewsVO;
import com.padcmyanmar.charleskeith.delegates.CharlesNewsDelegate;
import com.padcmyanmar.charleskeith.viewholders.NewsInViewHolder;

import java.util.ArrayList;
import java.util.List;

public class NewsInAdapter extends RecyclerView.Adapter<NewsInViewHolder> {

    private CharlesNewsDelegate cNewsDelegate;
    private List<GetNewsVO> newsList;

    public NewsInAdapter(CharlesNewsDelegate pNewsDelegate) {
        cNewsDelegate = pNewsDelegate;
        newsList = new ArrayList<>();
    }

    @Override
    public NewsInViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.view_holder_new_in, parent, false);
        return new NewsInViewHolder(view, cNewsDelegate);
    }

    @Override
    public void onBindViewHolder(@NonNull NewsInViewHolder holder, int position) {
        holder.setNewsData(newsList.get(position));
    }

    @Override
    public int getItemCount() {
        return newsList.size();
    }

    public void setCharlesList(List<GetNewsVO> newsVo) {
        this.newsList = newsVo;
        notifyDataSetChanged();
    }

}
