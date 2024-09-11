package com.zhihu.matisse.customui;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

public interface ImageUi {
    /**
     * 添加文件夹选择入口
     *
     * @param toolbar
     * @param bottomBar
     * @return
     */
    TextView createFolderTextView(FrameLayout toolbar, FrameLayout bottomBar);

    /**
     * 添加预览入口
     *
     * @param toolbar
     * @param bottomBar
     * @return
     */
    View createPreviewEnter(FrameLayout toolbar, FrameLayout bottomBar);

    /**
     * 添加提交入口
     *
     * @param toolbar
     * @param bottomBar
     * @return
     */
    View createSubmitEnter(FrameLayout toolbar, FrameLayout bottomBar);

    /**
     * 添加计数显示
     *
     * @param toolbar
     * @param bottomBar
     * @return
     */
    View createCountView(FrameLayout toolbar, FrameLayout bottomBar);

    /**
     * 设置状态栏
     */
    void setStatusBar(Activity activity);

    /**
     * 设置空布局
     *
     * @param textView
     */
    void setupEmptyTextView(TextView textView);

    /**
     * 设置RecyclerView
     *
     * @param view
     */
    void setRecyclerView(RecyclerView view);

    /**
     * 更新计数
     *
     * @param toolbar
     * @param bottomBar
     * @param count
     * @param max
     */
    void updateSelectCount(FrameLayout toolbar, FrameLayout bottomBar, int count, int max);

    /**
     * 创建image item
     *
     * @param context
     * @return
     */
    IMediaGrid mediaItemCreate(Context context);

}
