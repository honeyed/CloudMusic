package com.t.cloudmusic.adapter;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.support.annotation.NonNull;
import android.support.v4.view.ViewCompat;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.t.cloudmusic.R;
import com.t.cloudmusic.data.AdapterBean;
import com.t.cloudmusic.data.main.MusicBean;

import org.w3c.dom.Text;

public class MusicAdapter extends RecyclerView.Adapter {

    public static final int Column = 2;
    private MusicBean musicBean;
    public static final int TITLE = 1;
    public static final int SongList = 3;

    public MusicAdapter(AdapterBean musicBean) {
        this.musicBean = (MusicBean) musicBean;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        View view = null;
        if (viewType == TITLE) {
            view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.recyclerview_item_musci_title,
                    viewGroup, false);
            TitleHolder titleHolder = new TitleHolder(view);
            return titleHolder;
        } else if (viewType == Column) {
            view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.recyclerview_item_music_column,
                    viewGroup, false);
            ColumnHolder titleHolder = new ColumnHolder(view);
            return titleHolder;
        } else if (viewType == SongList) {
            view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.recyclerview_item_music_song_list,
                    viewGroup, false);
            SongListHolder titleHolder = new SongListHolder(view);
            return titleHolder;
        }
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int position) {
        if(viewHolder instanceof ColumnHolder) {
            MusicBean.Column column = (MusicBean.Column) musicBean.getObjectList().get(position);
            ColumnHolder holder = (ColumnHolder) viewHolder;
            holder.imageView.setImageResource(column.getImageUrl());
            holder.name.setText(column.getName());
            holder.count.setText(column.getType());
        }
    }

    @Override
    public int getItemViewType(int position) {
        return musicBean.getObjectList().get(position).getItemType();
    }

    @Override
    public int getItemCount() {
        return musicBean.getObjectList().size();
    }

//    @Override
//    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
//    }
//    }

    class TitleHolder extends RecyclerView.ViewHolder {

        public TitleHolder(@NonNull View itemView) {
            super(itemView);
        }
    }

    class ColumnHolder extends RecyclerView.ViewHolder {

        private ImageView imageView;
        private TextView name,count;

        public ColumnHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.imageView);
            name = itemView.findViewById(R.id.name);
            count = itemView.findViewById(R.id.count);
        }
    }

    class SongListHolder extends RecyclerView.ViewHolder {

        public SongListHolder(@NonNull View itemView) {
            super(itemView);
        }
    }

    public static class MusicItemDecoration extends RecyclerView.ItemDecoration {
        private final Paint mPaint;
        private int mSpace = 1;

        public MusicItemDecoration() {
            mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
            mPaint.setColor(Color.parseColor("#e2e3e4"));
            mPaint.setStyle(Paint.Style.FILL);
        }

        @Override
        public void getItemOffsets(Rect outRect, View view,
                                   RecyclerView parent, RecyclerView.State state) {
//            if (parent.getChildViewHolder(view).getItemViewType() == MusicAdapter.Column) {
//                if (parent.getChildAdapterPosition(view) != 3)
//                    outRect.bottom = mSpace;
//            }

        }

        /**
         * 画divider (orientation为vertical)
         *
         * @param c
         * @param parent
         */
        private void drawVertical(Canvas c, RecyclerView parent) {
            // recyclerView是否设置了paddingLeft和paddingRight
            final int left = parent.getPaddingLeft();
            final int right = parent.getWidth() - parent.getPaddingRight();
            final int childCount = parent.getChildCount();
            for (int i = 0; i < childCount; i++) {
                if (i != 0) {
                    final View child = parent.getChildAt(i);
                    final RecyclerView.LayoutParams params = (RecyclerView.LayoutParams) child
                            .getLayoutParams();
                    // divider的top 应该是 item的bottom 加上 marginBottom 再加上 Y方向上的位移
                    final int top = child.getBottom() + params.bottomMargin +
                            Math.round(ViewCompat.getTranslationY(child));
                    // divider的bottom就是top加上divider的高度了
                    final int bottom = (int) (top + 1);
                    c.drawRect(150, top, right, bottom, mPaint);
                } else if(i==5) {

                }
            }
        }

        @Override
        public void onDraw(@NonNull Canvas c, @NonNull RecyclerView parent, @NonNull RecyclerView.State state) {
            super.onDraw(c, parent, state);
            drawVertical(c,parent);
        }

        @Override
        public void onDrawOver(@NonNull Canvas c, @NonNull RecyclerView parent, @NonNull RecyclerView.State state) {
            super.onDrawOver(c, parent, state);

        }
    }
}
