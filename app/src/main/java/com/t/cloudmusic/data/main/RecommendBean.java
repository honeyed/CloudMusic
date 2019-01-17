package com.t.cloudmusic.data.main;

import android.content.Context;

import com.t.cloudmusic.adapter.RecommendAdapter;
import com.t.cloudmusic.widget.BannerView;

import java.util.ArrayList;
import java.util.List;

public class RecommendBean {

    private Banner banners;
    private List<Menu> menus;
    private List<PSList> psLists;
    private List<LookLive> lookLives;
    private List<Member> members;

    private List<RecommendAdapter.ItemType> objectList = new ArrayList<>();

    public List<RecommendAdapter.ItemType> getObjectList() {
        return objectList;
    }

    public void setObjectList(List<RecommendAdapter.ItemType> objectList) {
        this.objectList = objectList;
    }

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

    public static class Banner implements BannerView.BannerDate,RecommendAdapter.ItemType {
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

        @Override
        public int getItemType() {
            return RecommendAdapter.TYPE_ITEM_BANNER;
        }
    }

    /**
     * 菜单bean
     *
     */
    public static class Menu implements RecommendAdapter.ItemType {
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

        @Override
        public int getItemType() {
            return RecommendAdapter.TYPE_ITEM_MENU;
        }
    }

    /**
     * 私人歌单
     *
     */
    public static class PSList implements RecommendAdapter.ItemType {
        private String describe;
        private String image;
        private int listenerCount;

        public String getDescribe() {
            return describe;
        }

        public void setDescribe(String describe) {
            this.describe = describe;
        }

        public String getImage() {
            return image;
        }

        public void setImage(String image) {
            this.image = image;
        }

        public int getListenerCount() {
            return listenerCount;
        }

        public void setListenerCount(int listenerCount) {
            this.listenerCount = listenerCount;
        }

        @Override
        public int getItemType() {
            return RecommendAdapter.TYPE_ITEM_PS_LIST;
        }
    }

    public static class Title implements RecommendAdapter.ItemType {
        String title;

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        @Override
        public int getItemType() {
            return RecommendAdapter.TYPE_ITEM_TITLE;
        }
    }


    /**
    * 直播bean
    *
    */
    public static class LookLive implements RecommendAdapter.ItemType  {
        private String describe;
        private String image;
        private String name;

        public String getDescribe() {
            return describe;
        }

        public void setDescribe(String describe) {
            this.describe = describe;
        }

        public String getImage() {
            return image;
        }

        public void setImage(String image) {
            this.image = image;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        @Override
        public int getItemType() {
            return RecommendAdapter.TYPE_ITEM_LOOK_LIVE;
        }
    }

    /**
     * 会员专区bean
     *
     */
    public static class Member implements RecommendAdapter.ItemType  {

        public void addUrl(String url) {
            if(imageUrl == null) {
                imageUrl = new ArrayList<>();
            }
            imageUrl.add(url);
        }

        public List<String> getImageUrl() {
            return imageUrl;
        }

        public void setImageUrl(List<String> imageUrl) {
            this.imageUrl = imageUrl;
        }

        private List<String> imageUrl;

        @Override
        public int getItemType() {
            return RecommendAdapter.TYPE_ITEM_MEMBER;
        }
    }
}
