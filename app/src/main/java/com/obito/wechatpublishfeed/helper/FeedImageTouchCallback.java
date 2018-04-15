package com.obito.wechatpublishfeed.helper;

import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;

import com.obito.wechatpublishfeed.listener.OnItemMoveListener;


public class FeedImageTouchCallback extends ItemTouchHelper.Callback {

    private OnItemMoveListener itemMoveListener;

    public void setItemMoveListener(OnItemMoveListener itemMoveListener) {
        this.itemMoveListener = itemMoveListener;
    }

    @Override
    public int getMovementFlags(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder) {
        int dragFlags = 0;
        dragFlags = ItemTouchHelper.LEFT | ItemTouchHelper.DOWN | ItemTouchHelper.UP | ItemTouchHelper.RIGHT;
        return makeMovementFlags(dragFlags, 0);
    }

    @Override
    public boolean onMove(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, RecyclerView.ViewHolder target) {
        if (itemMoveListener != null) {
            return itemMoveListener.onItemMove(viewHolder,target);
        }
        return false;
    }

    @Override
    public void onSwiped(RecyclerView.ViewHolder viewHolder, int direction) {

    }
}
