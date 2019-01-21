package com.t.cloudmusic.ui.main.discovert;

import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.t.cloudmusic.R;
import com.t.cloudmusic.adapter.RecommendAdapter;
import com.t.cloudmusic.base.BFragment;
import com.t.cloudmusic.data.AdapterBean;
import com.t.cloudmusic.data.main.RecommendBean;
import com.t.cloudmusic.ui.main.MainContract;
import com.t.cloudmusic.ui.main.MainPresenter;
import com.t.cloudmusic.widget.BannerView;

import java.util.ArrayList;
import java.util.List;

public class RecommendFragment extends BFragment<MainContract.Presenter> implements MainContract.DiscoverView {

//    private BannerView bannerView;
    private RecommendAdapter recommendAdapter;
    private RecyclerView recyclerView;

    @Override
    public boolean onBackPressed() {
        return false;
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_main_discover_recommend;
    }

    @Override
    protected void bindView() {
        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new GridLayoutManager(getContext(),12));
        getP().getRecommendDate();
    }

    @Override
    public void showErrorMsg(String message) {

    }

    @Override
    public MainContract.Presenter newP() {
        return new MainPresenter();
    }

    @Override
    public void onResume() {
        super.onResume();
//        recyclerView.start();
//        bannerView.start();
    }

    @Override
    public void onStop() {
        super.onStop();
//        bannerView.stop();
    }


    @Override
    public void onDataSuccess(AdapterBean recommendBean) {
        recommendAdapter = new RecommendAdapter(recommendBean);
        recyclerView.addItemDecoration(new RecommendAdapter.ChatDetailItemDecoration(15));
        recyclerView.setAdapter(recommendAdapter);
    }

}
