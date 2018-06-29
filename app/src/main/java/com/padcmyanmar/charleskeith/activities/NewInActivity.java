package com.padcmyanmar.charleskeith.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toolbar;

import com.padcmyanmar.charleskeith.R;
import com.padcmyanmar.charleskeith.adapters.NewsInAdapter;
import com.padcmyanmar.charleskeith.data.models.GetNewsModels;
import com.padcmyanmar.charleskeith.data.vos.GetNewsVO;
import com.padcmyanmar.charleskeith.delegates.CharlesNewsDelegate;
import com.padcmyanmar.charleskeith.events.SuccessGetCharlesNewsEvent;
import com.padcmyanmar.charleskeith.viewholders.NewsDetailsViewHolder;
import com.padcmyanmar.charleskeith.viewholders.NewsInViewHolder;


import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import butterknife.BindView;

public class NewInActivity extends BaseActivity implements CharlesNewsDelegate {

    private NewsInAdapter charlesNewAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_in);

        final RecyclerView rvNewsIn = findViewById(R.id.rv_news_in);
        charlesNewAdapter = new NewsInAdapter(this);
        rvNewsIn.setAdapter(charlesNewAdapter);
        rvNewsIn.setLayoutManager(new LinearLayoutManager(getApplicationContext(), LinearLayout.VERTICAL, false));
        ImageView ivOneColumn = findViewById(R.id.iv_one_column);
        ivOneColumn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                rvNewsIn.setLayoutManager(new LinearLayoutManager(getApplicationContext(), LinearLayout.VERTICAL, false));
            }
        });
        ImageView ivTwoColumn = findViewById(R.id.iv_two_column);
        ivTwoColumn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                rvNewsIn.setLayoutManager(new GridLayoutManager(getApplicationContext(), 2));
            }
        });

        GetNewsModels.getObjInstance().loadCharlesList();

    }

    @Override
    protected void onStart() {
        super.onStart();
        if (!EventBus.getDefault().isRegistered(this)) {
            EventBus.getDefault().register(this);
        }
    }

    @Override
    protected void onStop() {
        super.onStop();
        if (EventBus.getDefault().isRegistered(this)) {
            EventBus.getDefault().unregister(this);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_new_in, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onTapNews(GetNewsVO newsVO) {
        Intent intent = new Intent(getApplicationContext(), NewsDetailsActivity.class);
        intent.putExtra("charlesId", newsVO.getProductId());
        startActivity(intent);
    }

    @Override
    public void onTapDetailNews() {

    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onSuccessGetNews(SuccessGetCharlesNewsEvent event) {
        Log.d("onSuccessGetNews", "onSuccessGetNews" + event.getCharlesList());
        charlesNewAdapter.setCharlesList(event.getCharlesList());
    }


}
