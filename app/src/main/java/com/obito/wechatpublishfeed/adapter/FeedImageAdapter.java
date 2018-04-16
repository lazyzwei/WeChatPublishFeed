package com.obito.wechatpublishfeed.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.obito.wechatpublishfeed.adapter.viewholder.FeedImageViewHolder;
import com.obito.wechatpublishfeed.R;

import java.util.List;


public class FeedImageAdapter extends RecyclerView.Adapter {

    private Context context;
    private LayoutInflater inflater;
    private List<String> datas;

    public static final String ITEM_ADD = "item_add";

    public static final int TYPE_ADD = 0;
    public static final int TYPE_PIC = 1;

    public FeedImageAdapter(Context context, List<String> images) {
        this.context = context;
        inflater = LayoutInflater.from(context);
        datas = images;
        notifyDataSetChanged();
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.item_feed_image, parent, false);
        FeedImageViewHolder viewHolder = new FeedImageViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        FeedImageViewHolder viewHolder = (FeedImageViewHolder) holder;
        viewHolder.bindView(datas.get(position));
    }

    @Override
    public int getItemCount() {
        if (datas == null || datas.size() == 0) return 0;
        return datas.size();
    }

    @Override
    public int getItemViewType(int position) {
        if (datas.get(position).equals(ITEM_ADD)) {
            return TYPE_ADD;
        }
        return TYPE_PIC;
    }
}
