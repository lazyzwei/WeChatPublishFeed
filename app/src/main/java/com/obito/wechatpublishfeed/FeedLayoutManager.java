package com.obito.wechatpublishfeed;

import android.content.Context;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.view.View;


public class FeedLayoutManager extends GridLayoutManager {

    private int width;
    private int offset;
    private int paddingTop;
    private int paddingLeft;
    private int spanCount;

    public FeedLayoutManager(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init(context);
    }

    public FeedLayoutManager(Context context, int spanCount) {
        super(context, spanCount);
        init(context);
    }

    public FeedLayoutManager(Context context, int spanCount, int orientation, boolean reverseLayout) {
        super(context, spanCount, orientation, reverseLayout);
        init(context);
    }
    private void init(Context context) {
        width = context.getResources().getDimensionPixelSize(R.dimen.dimen_size_62);
        offset = context.getResources().getDimensionPixelOffset(R.dimen.dimen_size_8);
        paddingTop = context.getResources().getDimensionPixelOffset(R.dimen.dimen_size_160);
        paddingLeft = context.getResources().getDimensionPixelOffset(R.dimen.dimen_size_18);
        spanCount = getSpanCount();
    }


    @Override
    public void onLayoutChildren(RecyclerView.Recycler recycler, RecyclerView.State state) {
        super.onLayoutChildren(recycler, state);
        int childCount = getItemCount();
        for (int i = 0; i < childCount; ++i) {
            View childView = getChildAt(i);
            int left = paddingLeft + (i % spanCount) * width + (i % spanCount) * offset;
            int top = paddingTop + (i / spanCount) * width + (i / spanCount) * offset;
            if (childView != null) {
                childView.layout(left, top, left + width, top + width);
            }
        }
    }
}
