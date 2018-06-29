package com.padcmyanmar.charleskeith.viewholders;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.padcmyanmar.charleskeith.R;
import com.padcmyanmar.charleskeith.activities.NewInActivity;
import com.padcmyanmar.charleskeith.data.vos.GetNewsVO;
import com.padcmyanmar.charleskeith.delegates.CharlesNewsDelegate;

import butterknife.BindView;
import butterknife.ButterKnife;

public class NewsInViewHolder extends RecyclerView.ViewHolder {
    private CharlesNewsDelegate newsDelegate;
    private GetNewsVO getNewsVO;

    @BindView(R.id.iv_news_image)
    ImageView ivNewsImage;
    @BindView(R.id.tv_product_title)
    TextView tvProductTitle;

    public NewsInViewHolder(View itemView, CharlesNewsDelegate pNewsDelegate) {
        super(itemView);
        ButterKnife.bind(this, itemView);
        newsDelegate = pNewsDelegate;

        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                newsDelegate.onTapNews(getNewsVO);
            }
        });
    }

    public void setNewsData(GetNewsVO newsVO) {
        getNewsVO = newsVO;
        tvProductTitle.setText(newsVO.getProductTitl());

        if (!newsVO.getProductImage().isEmpty()) {
            ivNewsImage.setVisibility(View.VISIBLE);
            Glide.with(ivNewsImage.getContext())
                    .load(newsVO.getProductImage())
                    .into(ivNewsImage);
        } else {
            ivNewsImage.setVisibility(View.GONE);
        }
    }


}
