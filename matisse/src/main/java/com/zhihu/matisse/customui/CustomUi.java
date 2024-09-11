package com.zhihu.matisse.customui;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.os.Build;
import android.view.Gravity;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.zhihu.matisse.R;
import com.zhihu.matisse.internal.utils.UIUtils;

public class CustomUi implements ImageUi {
    @Override
    public void setStatusBar(Activity activity) {

    }

    @Override
    public TextView createFolderTextView(FrameLayout toolbar, FrameLayout bottomBar) {
        toolbar.setBackgroundColor(Color.WHITE);
        return null;
    }

    @Override
    public View createPreviewEnter(FrameLayout toolbar, FrameLayout bottomBar) {
        return null;
    }

    @Override
    public View createSubmitEnter(FrameLayout toolbar, FrameLayout bottomBar) {
        bottomBar.setBackgroundColor(Color.TRANSPARENT);
        TextView tv = new TextView(bottomBar.getContext());
        tv.setId(R.id.submit_id);
        tv.setText("导入");
        tv.setTextColor(Color.WHITE);
        tv.setTextSize(18);
        tv.setGravity(Gravity.CENTER);
        GradientDrawable drawable = new GradientDrawable(
                GradientDrawable.Orientation.TOP_BOTTOM,
                new int[]{Color.parseColor("#49BEFF"), Color.parseColor("#2C8BFF")}
        );
        drawable.setCornerRadius(UIUtils.dp2px(27));
        tv.setBackgroundDrawable(drawable);
        FrameLayout.LayoutParams params = new FrameLayout.LayoutParams((int) UIUtils.dp2px(123), (int) UIUtils.dp2px(54));
        params.gravity = Gravity.CENTER_HORIZONTAL;
        params.bottomMargin = (int) UIUtils.dp2px(30);
        params.topMargin = (int) UIUtils.dp2px(30);
        bottomBar.addView(tv, params);
        return tv;
    }

    @Override
    public View createCountView(FrameLayout toolbar, FrameLayout bottomBar) {
        TextView tv = new TextView(bottomBar.getContext());
        tv.setId(R.id.count_id);
        tv.setTextColor(Color.parseColor("#333333"));
        tv.setTextSize(18);
        FrameLayout.LayoutParams params = new FrameLayout.LayoutParams(FrameLayout.LayoutParams.WRAP_CONTENT, FrameLayout.LayoutParams.WRAP_CONTENT);
        params.gravity = Gravity.CENTER_VERTICAL;
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR1) {
            params.setMarginStart((int) UIUtils.dp2px(16));
        }
        bottomBar.addView(tv, params);
        return tv;
    }

    @Override
    public void setupEmptyTextView(TextView textView) {

    }

    @Override
    public void setRecyclerView(RecyclerView view) {
        view.setClipToPadding(false);
        view.setPadding(view.getPaddingLeft(), view.getPaddingTop(), view.getPaddingRight(), (int) UIUtils.dp2px(114));
    }

    @Override
    public void updateSelectCount(FrameLayout toolbar, FrameLayout bottomBar, int count, int max) {
        TextView tv = bottomBar.findViewById(R.id.count_id);
        if (tv != null) {
            tv.setText(count + "/" + max);
        }
    }

    @Override
    public IMediaGrid mediaItemCreate(Context context) {
        return new CustomMediaGrid(context);
    }
}
