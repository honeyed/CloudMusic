package com.t.cloudmusic.data.main;

import android.content.Context;

import com.t.cloudmusic.widget.BannerView;

import java.util.ArrayList;
import java.util.List;

public class RecommendBean {

    private Banner banners;
    private List<Menu> menus;
    private List<PSList> psLists;
    private List<LookLive> lookLives;
    private List<Member> members;

    public Banner getBanners() {
        return banners;
    }

    public void setBanners(Banner banners) {
        this.banners = banners;
    }

    public List<Menu> getMenus() {
        return menus;
    }

    public void setMenus(List<Menu> menus) {
        this.menus = menus;
    }

    public List<PSList> getPsLists() {
        return psLists;
    }

    public void setPsLists(List<PSList> psLists) {
        this.psLists = psLists;
    }

    public List<LookLive> getLookLives() {
        return lookLives;
    }

    public void setLookLives(List<LookLive> lookLives) {
        this.lookLives = lookLives;
    }

    public List<Member> getMembers() {
        return members;
    }

    public void setMembers(List<Member> members) {
        this.members = members;
    }

    public static class Banner implements BannerView.BannerDate {
        private List<String> imageUrls;
        private int type;
        private int itemType;

        public void addImageUrl(String url) {
            if(imageUrls == null)
                imageUrls = new ArrayList<>();
            imageUrls.add(url);
        }

        @Override
        public List<String> getImageList() {
            return imageUrls;
        }
    }

    /**
     * 菜单bean
     *
     */
    public static class Menu {
        private int resources;
        private String text;

        public int getResources() {
            return resources;
        }

        public void setResources(int resources) {
            this.resources = resources;
        }

        public String getText() {
            return text;
        }

        public void setText(String text) {
            this.text = text;
        }
    }

    /**
     * 私人歌单
     *
     */
    class PSList {
        private String describe;
        private String image;
        private int listenerCount;
    }


    /**
    * 直播bean
    *
    */
    class LookLive {
        private String describe;
        private String image;
    }

    /**
     * 会员专区bean
     *
     */
    class Member {
        private String describe;
        private String title;
        private String imageUrl;
        private int type;
    }
}
