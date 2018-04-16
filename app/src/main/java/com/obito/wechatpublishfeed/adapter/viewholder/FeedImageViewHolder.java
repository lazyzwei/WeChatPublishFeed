package com.obito.wechatpublishfeed.adapter.viewholder;

import android.content.Context;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.facebook.drawee.view.SimpleDraweeView;
import com.obito.wechatpublishfeed.R;

import static com.obito.wechatpublishfeed.adapter.FeedImageAdapter.ITEM_ADD;


public class FeedImageViewHolder extends RecyclerView.ViewHolder {

    private SimpleDraweeView simpleDraweeView;
    private Context context;

    public FeedImageViewHolder(View itemView) {
        super(itemView);
        simpleDraweeView = itemView.findViewById(R.id.image);
        context = itemView.getContext();
    }

    public void bindView(String url) {
        if (url.equals(ITEM_ADD)) {
            Uri uri = Uri.parse("res://" + context.getPackageName() + "/" + R.mipmap.ic_add_pic);
            simpleDraweeView.setImageURI(uri);
        } else {
            simpleDraweeView.setImageURI(url);
        }
    }
}
