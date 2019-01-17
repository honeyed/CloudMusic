package com.t.cloudmusic.adapter;

import android.graphics.Canvas;
import android.graphics.Rect;
import android.support.annotation.NonNull;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.t.cloudmusic.R;
import com.t.cloudmusic.data.imageLoader.ImageLoader;
import com.t.cloudmusic.data.main.RecommendBean;
import com.t.cloudmusic.widget.BannerView;
import com.t.cloudmusic.widget.MemberView;

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

    public RecommendAdapter(RecommendBean recommendBean) {
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
        } else if (viewType == TYPE_ITEM_MENU) {
            view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.recyclerview_item_recommend_menu,
                    viewGroup, false);
            MenuHolder menuViewHolder = new MenuHolder(view);
            return menuViewHolder;
        } else if (viewType == TYPE_ITEM_TITLE) {
            view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.recyclerview_item_recommend_title,
                    viewGroup, false);
            TitleHolder titleHolder = new TitleHolder(view);
            return titleHolder;
        } else if (viewType == TYPE_ITEM_PS_LIST) {
            view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.recyclerview_item_recommend_ps,
                    viewGroup, false);
            PSHolder psHolder = new PSHolder(view);
            return psHolder;
        } else if(viewType == TYPE_ITEM_LOOK_LIVE) {
            view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.recyclerview_item_recommend_living,
                    viewGroup, false);
            LookLivingHolder lookLiving = new LookLivingHolder(view);
            return lookLiving;
        } else if(viewType == TYPE_ITEM_MEMBER) {
            view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.recyclerview_item_recommend_member,
                    viewGroup, false);
            MemberHolder memberHolder = new MemberHolder(view);
            return memberHolder;
        }
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
        if (viewHolder instanceof BannerHolder) {

        } else if (viewHolder instanceof MenuHolder) {
            MenuHolder menuHolder = (MenuHolder) viewHolder;
            menuHolder.imageView.setImageResource(recommendBean.getMenus().get(i - 1).getResources());
            menuHolder.textView.setText(recommendBean.getMenus().get(i - 1).getText());
        } else if (viewHolder instanceof TitleHolder) {
            TitleHolder titleHolder = (TitleHolder) viewHolder;
            RecommendBean.Title title = (RecommendBean.Title) recommendBean.getObjectList().get(i);
            titleHolder.titleTxt.setText(title.getTitle()+" ");
        } else if (viewHolder instanceof PSHolder) {
            PSHolder psHolder = (PSHolder) viewHolder;
            RecommendBean.PSList psList = (RecommendBean.PSList) recommendBean.getObjectList().get(i);
            psHolder.count.setText(psList.getListenerCount() + "万");
            psHolder.describe.setText(psList.getDescribe());
            ImageLoader.loadImage(psHolder.image.getContext(), psHolder.image, psList.getImage());
        } else if(viewHolder instanceof LookLivingHolder) {
            LookLivingHolder psHolder = (LookLivingHolder) viewHolder;
            RecommendBean.LookLive lookLive = (RecommendBean.LookLive) recommendBean.getObjectList().get(i);
            psHolder.name.setText(lookLive.getName());
            psHolder.describe.setText(lookLive.getDescribe());
            ImageLoader.loadImage(psHolder.imageView.getContext(), psHolder.imageView, lookLive.getImage());
        } else if(viewHolder instanceof MemberHolder) {
            MemberHolder holder = (MemberHolder) viewHolder;
            RecommendBean.Member member = (RecommendBean.Member) recommendBean.getObjectList().get(i);
            holder.memberView.setData(member);
        }
    }

    @Override
    public int getItemCount() {
        return recommendBean.getObjectList().size();
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
                        case TYPE_ITEM_PS_LIST:
                            return 4;
                        case TYPE_ITEM_LOOK_LIVE:
                            return 4;
                        case TYPE_ITEM_MEMBER:
                            return 12;
                        default:
                            return 12;
                    }
                }
            });
        }
    }

    @Override
    public int getItemViewType(int position) {
        return recommendBean.getObjectList().get(position).getItemType();
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

        private TextView titleTxt;

        public TitleHolder(@NonNull View itemView) {
            super(itemView);
            titleTxt = itemView.findViewById(R.id.titleTxt);
        }
    }

    class PSHolder extends RecyclerView.ViewHolder {

        private ImageView image;
        private TextView count, describe;

        public PSHolder(@NonNull View itemView) {
            super(itemView);
            image = itemView.findViewById(R.id.image);
            count = itemView.findViewById(R.id.count);
            describe = itemView.findViewById(R.id.describe);
        }
    }

    class LookLivingHolder extends RecyclerView.ViewHolder {

        TextView describe,name;
        ImageView imageView;

        public LookLivingHolder(@NonNull View itemView) {
            super(itemView);
            describe = itemView.findViewById(R.id.describe);
            name = itemView.findViewById(R.id.name);
            imageView = itemView.findViewById(R.id.imageView);
        }
    }

    class MemberHolder extends RecyclerView.ViewHolder {

        MemberView memberView;

        public MemberHolder(@NonNull View itemView) {
            super(itemView);
            memberView = itemView.findViewById(R.id.memberView);
        }
    }

    public interface ItemType {
        int getItemType();
    }

    public static class ChatDetailItemDecoration extends RecyclerView.ItemDecoration {
        private int space;

        public ChatDetailItemDecoration(int space) {
            this.space = space;
        }

        @Override
        public void getItemOffsets(Rect outRect, View view,
                                   RecyclerView parent, RecyclerView.State state) {
            if (parent.getChildViewHolder(view).getItemViewType() == RecommendAdapter.TYPE_ITEM_PS_LIST) {
                if (parent.getChildAdapterPosition(view)% 3 == 0)
                    outRect.left = space;
                else if (parent.getChildAdapterPosition(view) % 3 == 2)
                    outRect.right = space;
                else {
                    outRect.left = space / 2;
                    outRect.right = space / 2;
                }
            }

            if (parent.getChildViewHolder(view).getItemViewType() == RecommendAdapter.TYPE_ITEM_LOOK_LIVE) {
                if (parent.getChildAdapterPosition(view)% 3 == 1)
                    outRect.left = space;
                else if (parent.getChildAdapterPosition(view) % 3 == 0)
                    outRect.right = space;
                else {
                    outRect.left = space / 2;
                    outRect.right = space / 2;
                }
            }
        }

        @Override
        public void onDraw(@NonNull Canvas c, @NonNull RecyclerView parent, @NonNull RecyclerView.State state) {
            super.onDraw(c, parent, state);
        }

        @Override
        public void onDrawOver(@NonNull Canvas c, @NonNull RecyclerView parent, @NonNull RecyclerView.State state) {
            super.onDrawOver(c, parent, state);
        }
    }
}
