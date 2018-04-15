package com.obito.wechatpublishfeed.listener;

import android.support.v7.widget.RecyclerView;

/**
 * Created by zwfang on 2018/4/15.
 */

public interface OnItemMoveListener {
    boolean onItemMove(RecyclerView.ViewHolder srcViewHolder, RecyclerView.ViewHolder targetViewHolder);
}
