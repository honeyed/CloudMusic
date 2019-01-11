package com.t.cloudmusic.ui.main.discovert;

import com.t.cloudmusic.R;
import com.t.cloudmusic.base.BFragment;
import com.t.cloudmusic.ui.main.MainContract;
import com.t.cloudmusic.widget.BannerView;

import java.util.ArrayList;
import java.util.List;

public class RecommendFragment extends BFragment<MainContract.Presenter> implements MainContract.DiscoverView {

    private BannerView bannerView;
    private String image = "https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1547202496578&di=ddb217f7ad4b179cec1a02072ec94dc7&imgtype=0&src=http%3A%2F%2Fku.90sjimg.com%2Felement_origin_min_pic%2F00%2F00%2F07%2F105781f03cdad03.jpg";

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
        bannerView = findViewById(R.id.banner);
        List<String> arrays = new ArrayList<>();
        for(int i=0;i<5;i++) {
            arrays.add(image);
        }
        bannerView.setUrlList(arrays);
    }

    @Override
    public void showErrorMsg(String message) {

    }

    @Override
    public MainContract.Presenter newP() {
        return null;
    }

    @Override
    public void onResume() {
        super.onResume();
        bannerView.start();
    }

    @Override
    public void onStop() {
        super.onStop();
        bannerView.stop();
    }
}
