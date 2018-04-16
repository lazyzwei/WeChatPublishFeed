package com.obito.wechatpublishfeed.helper;

import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;

import com.obito.wechatpublishfeed.listener.OnTouchCallbackListener;


public class FeedImageTouchCallback extends ItemTouchHelper.Callback {

    private OnTouchCallbackListener touchCallbackListener;

    public void setTouchCallbackListener(OnTouchCallbackListener touchCallbackListener) {
        this.touchCallbackListener = touchCallbackListener;
    }

    @Override
    public int getMovementFlags(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder) {
        int dragFlags = 0;
        dragFlags = ItemTouchHelper.LEFT | ItemTouchHelper.DOWN | ItemTouchHelper.UP | ItemTouchHelper.RIGHT;
        return makeMovementFlags(dragFlags, 0);
    }

    @Override
    public boolean onMove(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, RecyclerView.ViewHolder target) {
        if (touchCallbackListener != null) {
            return touchCallbackListener.onItemMove(viewHolder, target);
        }
        return false;
    }

    @Override
    public void onSwiped(RecyclerView.ViewHolder viewHolder, int direction) {

    }

    @Override
    public void onSelectedChanged(RecyclerView.ViewHolder viewHolder, int actionState) {
        super.onSelectedChanged(viewHolder, actionState);
        if (touchCallbackListener != null) {
            touchCallbackListener.onSelectedChanged(viewHolder, actionState);
        }
    }

    @Override
    public void clearView(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder) {
        super.clearView(recyclerView, viewHolder);
        if (touchCallbackListener != null) {
            touchCallbackListener.onClearView();
        }
    }
}
