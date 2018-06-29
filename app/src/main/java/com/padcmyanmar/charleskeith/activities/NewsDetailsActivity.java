package com.padcmyanmar.charleskeith.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.padcmyanmar.charleskeith.R;
import com.padcmyanmar.charleskeith.adapters.NewDetailsAdapter;
import com.padcmyanmar.charleskeith.adapters.NewsInAdapter;
import com.padcmyanmar.charleskeith.data.vos.GetNewsVO;
import com.padcmyanmar.charleskeith.delegates.CharlesNewsDelegate;

import butterknife.BindView;

public class NewsDetailsActivity extends BaseActivity implements CharlesNewsDelegate
{
    private NewDetailsAdapter charlesNewAdapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_in_details);

        RecyclerView rvDetailsNewsIn = findViewById(R.id.rv_news_in_detail);
        charlesNewAdapter = new NewDetailsAdapter(this);

        rvDetailsNewsIn.setAdapter(charlesNewAdapter);
        rvDetailsNewsIn.setLayoutManager(new LinearLayoutManager(getApplicationContext(), LinearLayout.VERTICAL,false));

        ImageView btnBack=findViewById(R.id.btn_back);
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(NewsDetailsActivity.this,NewInActivity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    public void onTapNews(GetNewsVO newsVO) {

    }

    @Override
    public void onTapDetailNews() {

    }
}
