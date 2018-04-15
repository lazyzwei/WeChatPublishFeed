package com.obito.wechatpublishfeed;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;


public class FeedImageAdapter extends RecyclerView.Adapter {

    private Context context;
    private LayoutInflater inflater;
    private List<String> datas;

    public FeedImageAdapter(Context context) {
        this.context = context;
        inflater = LayoutInflater.from(context);
        datas = new ArrayList<>();
    }

    public void setDatas(List<String> images) {
        datas.clear();
        datas.addAll(images);
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
}
