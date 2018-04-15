package com.obito.wechatpublishfeed.listener;

import android.support.v7.widget.RecyclerView;


public interface OnItemMoveListener {
    boolean onItemMove(RecyclerView.ViewHolder srcViewHolder, RecyclerView.ViewHolder targetViewHolder);
}
