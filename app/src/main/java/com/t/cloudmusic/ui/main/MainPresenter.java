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
        recommendBean.getObjectList().add(banner);

        List<RecommendBean.Menu> list = new ArrayList<>();
        int[] mips = {R.mipmap.cm5_disc_topbtn_fm, R.mipmap.cm5_disc_topbtn_daily, R.mipmap.cm5_disc_topbtn_list, R.mipmap.cm5_disc_topbtn_rank};
        String[] titles = {"私人FM", "每日推荐", "歌单", "排行榜"};
        for (int i = 0; i < 4; i++) {
            RecommendBean.Menu menu = new RecommendBean.Menu();
            menu.setResources(mips[i]);
            menu.setText(titles[i]);
            list.add(menu);
        }
        recommendBean.setMenus(list);
        recommendBean.getObjectList().addAll(list);

        RecommendBean.Title title = new RecommendBean.Title();
        title.setTitle("个性推荐");
        recommendBean.getObjectList().add(title);

        List<RecommendBean.PSList> psLists = new ArrayList<>();
        for (int i = 0; i < 6; i++) {
            RecommendBean.PSList psList = new RecommendBean.PSList();
            psList.setDescribe("生活没那么简单 也没那么糟糕");
            psList.setImage("https://img2.woyaogexing.com/2019/01/15/0aa0b330a9f54706b5d691bc338863a1!400x400.jpeg");
            psList.setListenerCount(112+i);
            psLists.add(psList);
        }
        recommendBean.setPsLists(psLists);
        recommendBean.getObjectList().addAll(psLists);

        RecommendBean.Title title2 = new RecommendBean.Title();
        title2.setTitle("LOOK直播");
        recommendBean.getObjectList().add(title2);

        List<RecommendBean.LookLive> lk = new ArrayList<>();
        for (int i = 0; i < 6; i++) {
            RecommendBean.LookLive psList = new RecommendBean.LookLive();
            psList.setName("大国");
            psList.setImage("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1547718268597&di=aa7c38a5fd563e3e0fb0b3bab0a8f9d8&imgtype=0&src=http%3A%2F%2Fimg4.duitang.com%2Fuploads%2Fitem%2F201402%2F09%2F20140209224057_jrUnw.thumb.700_0.jpeg");
            psList.setDescribe("再不看就要被删除");
            lk.add(psList);
        }
        recommendBean.setLookLives(lk);
        recommendBean.getObjectList().addAll(lk);

        RecommendBean.Member member = new RecommendBean.Member();
        for(int i =0;i<4;i++) {
            member.addUrl("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1547723762632&di=efd971df10121e503edd2e97e89b1cf4&imgtype=0&src=http%3A%2F%2Fwww.36588.com.cn%3A8080%2FImageResourceMongo%2FUploadedFile%2Fdimension%2Fbig%2F52632a9c-9a0a-49f4-a16e-424ee9538893.png");
        }
        recommendBean.getObjectList().add(member);

        MainContract.DiscoverView discoverView = (MainContract.DiscoverView) getV();
        discoverView.onDataSuccess(recommendBean);
    }
}