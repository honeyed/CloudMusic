package com.t.cloudmusic.data.main;

import com.t.cloudmusic.adapter.ItemType;
import com.t.cloudmusic.adapter.MusicAdapter;
import com.t.cloudmusic.data.AdapterBean;

public class MusicBean extends AdapterBean {

    private TitleBean titleBean;

    public static class TitleBean implements ItemType {
        private String imageUrl;
        private String name;
        private String type;// 是不是黑胶会员

        public String getImageUrl() {
            return imageUrl;
        }

        public void setImageUrl(String imageUrl) {
            this.imageUrl = imageUrl;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        @Override
        public int getItemType() {
            return MusicAdapter.TITLE;
        }
    }

    public static class Column implements ItemType {

        private int imageUrl;
        private String name;
        private String type;// 是不是黑胶会员

        public Column(int imageUrl, String name, String type) {
            this.imageUrl = imageUrl;
            this.name = name;
            this.type = type;
        }

        public int getImageUrl() {
            return imageUrl;
        }

        public void setImageUrl(int imageUrl) {
            this.imageUrl = imageUrl;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        @Override
        public int getItemType() {
            return MusicAdapter.Column;
        }
    }

    public static class SongList implements ItemType {


        @Override
        public int getItemType() {
            return MusicAdapter.SongList;
        }
    }
}
