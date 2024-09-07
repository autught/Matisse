package com.zhihu.matisse.customui;

import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.ImageView;

import androidx.recyclerview.widget.RecyclerView;

import com.zhihu.matisse.internal.entity.Item;
import com.zhihu.matisse.internal.ui.widget.MediaGrid;

public interface IMediaGrid {

    View create();

    void preBindMedia(PreBindInfo info);

    void bindMedia(Item item);

    void setCheckEnabled(boolean enabled);

    void setCheckedNum(int num);

    void setChecked(boolean checked);

    void setOnMediaGridClickListener(IMediaGrid.OnMediaGridClickListener listener);

    public interface OnMediaGridClickListener {

        void onThumbnailClicked(ImageView thumbnail, Item item, RecyclerView.ViewHolder holder);

        void onCheckViewClicked(View checkView, Item item, RecyclerView.ViewHolder holder);
    }

    public static class PreBindInfo {
        public int mResize;
        public Drawable mPlaceholder;
        public boolean mCheckViewCountable;
        public RecyclerView.ViewHolder mViewHolder;

        public PreBindInfo(int resize, Drawable placeholder, boolean checkViewCountable,
                           RecyclerView.ViewHolder viewHolder) {
            mResize = resize;
            mPlaceholder = placeholder;
            mCheckViewCountable = checkViewCountable;
            mViewHolder = viewHolder;
        }
    }
}
