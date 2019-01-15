package com.t.cloudmusic.ui.main;

import com.t.cloudmusic.R;
import com.t.cloudmusic.base.BPresenter;
import com.t.cloudmusic.data.main.RecommendBean;

import java.util.ArrayList;
import java.util.List;

import static android.support.v4.util.Preconditions.checkNotNull;

/**
 * Listens to user actions from the UI ({@link }), retrieves the data and updates
 * the UI as required.
 */
public class MainPresenter extends BPresenter implements MainContract.Presenter {

    private String image = "https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1547202496578&di=ddb217f7ad4b179cec1a02072ec94dc7&imgtype=0&src=http%3A%2F%2Fku.90sjimg.com%2Felement_origin_min_pic%2F00%2F00%2F07%2F105781f03cdad03.jpg";

    @Override
    public void getRecommendDate() {
        RecommendBean recommendBean = new RecommendBean();
        RecommendBean.Banner banner = new RecommendBean.Banner();

        for(int i = 0;i<5;i++) {
            banner.addImageUrl(image);
        }
        recommendBean.setBanners(banner);
        List<RecommendBean.Menu> list = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            RecommendBean.Menu menu = new RecommendBean.Menu();
            menu.setResources(R.mipmap.cm5_disc_topbtn_fm);
            menu.setText("私人FM");
            list.add(menu);
        }
        recommendBean.setMenus(list);
        MainContract.DiscoverView discoverView = (MainContract.DiscoverView) getV();
        discoverView.onDataSuccess(recommendBean);
    }
}