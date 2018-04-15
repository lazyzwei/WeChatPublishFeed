package com.obito.wechatpublishfeed;

import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.facebook.drawee.view.SimpleDraweeView;


public class FeedImageViewHolder extends RecyclerView.ViewHolder {

    private SimpleDraweeView simpleDraweeView;

    public FeedImageViewHolder(View itemView) {
        super(itemView);
        simpleDraweeView = itemView.findViewById(R.id.image);
    }

    public void bindView(String url) {
        simpleDraweeView.setImageURI(url);
    }
}
