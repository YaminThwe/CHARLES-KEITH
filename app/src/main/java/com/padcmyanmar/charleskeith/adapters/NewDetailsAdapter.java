package com.padcmyanmar.charleskeith.adapters;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.padcmyanmar.charleskeith.R;
import com.padcmyanmar.charleskeith.activities.NewsDetailsActivity;
import com.padcmyanmar.charleskeith.viewholders.NewsDetailsViewHolder;

public class NewDetailsAdapter extends RecyclerView.Adapter<NewsDetailsViewHolder>
{
    public NewDetailsAdapter(NewsDetailsActivity newsDetailsActivity) {

    }

    @NonNull
    @Override
    public NewsDetailsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater=LayoutInflater.from(parent.getContext());
        View view=layoutInflater.inflate(R.layout.view_holder_new_in_detail,parent,false);
        return new NewsDetailsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull NewsDetailsViewHolder holder, int position) {

    }



    @Override
    public int getItemCount() {
        return 7;
    }


}
