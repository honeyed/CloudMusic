package com.t.cloudmusic.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.t.cloudmusic.R;
import com.t.cloudmusic.data.main.RecommendBean;
import com.t.cloudmusic.widget.BannerView;

public class RecommendAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    public static final int TYPE_ITEM_BANNER = 0; //轮播图
    public static final int TYPE_ITEM_MENU = 1; //标题  热门信用卡
    public static final int TYPE_ITEM_PS_LIST = 2; //推荐歌单
    public static final int TYPE_ITEM_LOOK_LIVE = 3; //Look 直播
    public static final int TYPE_ITEM_MEMBER = 4; // 会员专区
    public static final int TYPE_ITEM_NEW_SONG = 5; //最新歌曲
    public static final int TYPE_ITEM_LIST = 6; //竖向list列表

    public static final int TYPE_ITEM_TITLE = 7; //说明的标题
    private RecommendBean recommendBean;

    public RecommendAdapter(RecommendBean recommendBean){
        this.recommendBean = recommendBean;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        View view = null;
        if (viewType == TYPE_ITEM_BANNER) {
            view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.recyclerview_item_recommend_banner,
                    viewGroup, false);
            BannerHolder bannerViewHolder = new BannerHolder(view);
            bannerViewHolder.bannerView.setUrlList(recommendBean.getBanners());
            return bannerViewHolder;
        } else if(viewType == TYPE_ITEM_MENU) {
            view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.recyclerview_item_recommend_menu,
                    viewGroup, false);
            MenuHolder menuViewHolder = new MenuHolder(view);
            return menuViewHolder;
        }
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
        if(viewHolder instanceof BannerHolder) {

        } else if (viewHolder instanceof MenuHolder) {
            MenuHolder menuHolder = (MenuHolder) viewHolder;
            menuHolder.imageView.setImageResource(recommendBean.getMenus().get(i-1).getResources());
            menuHolder.textView.setText(recommendBean.getMenus().get(i-1).getText());
        }
    }

    @Override
    public int getItemCount() {
        return 5;
    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);

        RecyclerView.LayoutManager manager = recyclerView.getLayoutManager();
        if (manager instanceof GridLayoutManager) {
            GridLayoutManager gridManager = ((GridLayoutManager) manager);

            gridManager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() {
                @Override
                public int getSpanSize(int position) {
                    int type = getItemViewType(position);
                    switch (type) {
                        case TYPE_ITEM_BANNER:
                            return 12;
                        case TYPE_ITEM_MENU:
                            return 3;
                        default:
                            return 12;
                    }
                }
            });
        }
    }

    @Override
    public int getItemViewType(int position) {
        if(position == 0)
            return TYPE_ITEM_BANNER;
        switch (position) {
            case 0:
                return TYPE_ITEM_BANNER;
            case 5:
                return TYPE_ITEM_TITLE;
        }
        return TYPE_ITEM_MENU;
    }

    class BannerHolder extends RecyclerView.ViewHolder {

        private BannerView bannerView;

        public BannerHolder(@NonNull View itemView) {
            super(itemView);
            bannerView = itemView.findViewById(R.id.banner);
        }
    }

    class MenuHolder extends RecyclerView.ViewHolder {

        private ImageView imageView;
        private TextView textView;

        public MenuHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.image);
            textView = itemView.findViewById(R.id.text);
        }
    }

    class TitleHolder extends RecyclerView.ViewHolder {

        public TitleHolder(@NonNull View itemView) {
            super(itemView);
        }
    }
}
