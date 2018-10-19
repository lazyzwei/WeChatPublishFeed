package com.obito.wechatpublishfeed.activity;

import android.content.Intent;
import android.os.Build;
import android.support.v4.view.ViewCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.view.MotionEvent;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.obito.wechatpublishfeed.adapter.FeedImageAdapter;
import com.obito.wechatpublishfeed.FeedLayoutManager;
import com.obito.wechatpublishfeed.R;
import com.obito.wechatpublishfeed.helper.FeedImageTouchCallback;
import com.obito.wechatpublishfeed.helper.FeedImageTouchHelper;
import com.obito.wechatpublishfeed.listener.OnItemClickListener;
import com.obito.wechatpublishfeed.listener.OnTouchCallbackListener;
import com.obito.wechatpublishfeed.utils.DialogUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static com.obito.wechatpublishfeed.adapter.FeedImageAdapter.ITEM_ADD;
import static com.obito.wechatpublishfeed.adapter.FeedImageAdapter.TYPE_ADD;

public class MainActivity extends AppCompatActivity implements OnTouchCallbackListener, OnItemClickListener {

    private RecyclerView recyclerView;
    private RelativeLayout container;
    private View title;
    private View rlDelete;
    private TextView tvDelete;

    private FeedLayoutManager layoutManager;
    private FeedImageAdapter adapter;
    private boolean isDraging;
    private List<String> datas = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initImages();
        initTouchHelper();
        layoutContainer();
    }

    private void initView() {
        recyclerView = findViewById(R.id.recyclerview);
        container = findViewById(R.id.placeholder_container);
        layoutManager = new FeedLayoutManager(this, 4, LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(layoutManager);
        title = findViewById(R.id.layout_title);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            title.setOutlineProvider(null);
        }
        rlDelete = findViewById(R.id.rl_delete);
        tvDelete = findViewById(R.id.tv_delete_tips);
    }

    private void initImages() {
        datas.add("https://ss0.bdstatic.com/94oJfD_bAAcT8t7mm9GUKT-xh_/timg?image&quality=100&size=b4000_4000&sec=1523781928&di=6cb444c97297804abd343d163ce740bd&src=http://e.hiphotos.baidu.com/zhidao/pic/item/8ad4b31c8701a18bfb27b67d992f07082838fe30.jpg");
        datas.add("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1523792014586&di=efc381a58ff70839c1f27da80f0eadcb&imgtype=0&src=http%3A%2F%2Fimgsrc.baidu.com%2Fforum%2Fw%3D580%2Fsign%3D7276a1157c1ed21b79c92eed9d6cddae%2Fb532ae0f4bfbfbed5e86069879f0f736adc31f93.jpg");
        datas.add("https://ss0.bdstatic.com/94oJfD_bAAcT8t7mm9GUKT-xh_/timg?image&quality=100&size=b4000_4000&sec=1523781928&di=6cb444c97297804abd343d163ce740bd&src=http://e.hiphotos.baidu.com/zhidao/pic/item/8ad4b31c8701a18bfb27b67d992f07082838fe30.jpg");
        datas.add("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1523792014584&di=8c77e4922fc5ef57b74d5110beec6fdd&imgtype=0&src=http%3A%2F%2Fimages6.fanpop.com%2Fimage%2Fpolls%2F1360000%2F1360567_1396688397759_full.jpg%3Fv%3D1396688440");
        datas.add("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1523792014584&di=8c77e4922fc5ef57b74d5110beec6fdd&imgtype=0&src=http%3A%2F%2Fimages6.fanpop.com%2Fimage%2Fpolls%2F1360000%2F1360567_1396688397759_full.jpg%3Fv%3D1396688440");
        datas.add("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1523792014584&di=8c77e4922fc5ef57b74d5110beec6fdd&imgtype=0&src=http%3A%2F%2Fimages6.fanpop.com%2Fimage%2Fpolls%2F1360000%2F1360567_1396688397759_full.jpg%3Fv%3D1396688440");
        datas.add("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1523792014584&di=8c77e4922fc5ef57b74d5110beec6fdd&imgtype=0&src=http%3A%2F%2Fimages6.fanpop.com%2Fimage%2Fpolls%2F1360000%2F1360567_1396688397759_full.jpg%3Fv%3D1396688440");
        datas.add("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1523792014586&di=efc381a58ff70839c1f27da80f0eadcb&imgtype=0&src=http%3A%2F%2Fimgsrc.baidu.com%2Fforum%2Fw%3D580%2Fsign%3D7276a1157c1ed21b79c92eed9d6cddae%2Fb532ae0f4bfbfbed5e86069879f0f736adc31f93.jpg");
        datas.add(ITEM_ADD);
        adapter = new FeedImageAdapter(this, datas);
        adapter.setItemClickListener(this);
        recyclerView.setAdapter(adapter);
        recyclerView.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getAction() == MotionEvent.ACTION_DOWN || event.getAction() == MotionEvent.ACTION_MOVE) {
                    ViewCompat.setTranslationZ(recyclerView, 2f);
                    ViewCompat.setTranslationZ(title, 3f);
                } else if (event.getAction() == MotionEvent.ACTION_UP && !isDraging) {
                    ViewCompat.setTranslationZ(recyclerView, 0);
                    ViewCompat.setTranslationZ(title, 0);
                }
                return false;
            }
        });
    }

    private void initTouchHelper() {
        FeedImageTouchCallback touchCallback = new FeedImageTouchCallback();
        touchCallback.setTouchCallbackListener(this);
        FeedImageTouchHelper touchHelper = new FeedImageTouchHelper(touchCallback);
        touchHelper.attachToRecyclerView(recyclerView);
    }

    @Override
    public boolean onItemMove(RecyclerView.ViewHolder srcViewHolder, RecyclerView.ViewHolder targetViewHolder) {
        if (srcViewHolder.getItemViewType() != targetViewHolder.getItemViewType() || srcViewHolder.getItemViewType() == TYPE_ADD)
            return true;
        int src = srcViewHolder.getAdapterPosition();
        int dst = targetViewHolder.getAdapterPosition();
        if (src < dst) {
            for (int i = src; i < dst; ++i) {
                Collections.swap(datas, i, i + 1);
            }
        } else {
            for (int i = dst; i < src; ++i) {
                Collections.swap(datas, i, i + 1);
            }
        }
        adapter.notifyItemMoved(src, dst);
        return false;
    }

    @Override
    public void onSelectedChanged(RecyclerView.ViewHolder viewHolder, int actionState) {
        if (actionState == ItemTouchHelper.ACTION_STATE_DRAG) {
            isDraging = true;
            showDeleteLayout(true);
        } else if (actionState == ItemTouchHelper.ACTION_STATE_IDLE) {
            showDeleteLayout(false);
        }
    }

    @Override
    public void onClearView() {
        isDraging = false;
        ViewCompat.setTranslationZ(recyclerView, 0);
        ViewCompat.setTranslationZ(title, 0);
        layoutContainer();
    }

    @Override
    public void onChildDeleteState(boolean delete) {
        int resId = delete ? getResources().getColor(R.color.color_bg_delete_image_selected)
                : getResources().getColor(R.color.color_bg_delete_image);
        String tips = delete ? getResources().getString(R.string.tips_delete_image_delete)
                : getResources().getString(R.string.tips_delete_image);
        rlDelete.setBackgroundColor(resId);
        tvDelete.setText(tips);
    }

    @Override
    public void onChildDelete(RecyclerView.ViewHolder viewHolder) {
        viewHolder.itemView.setVisibility(View.GONE);
        datas.remove(viewHolder.getAdapterPosition());
        adapter.notifyItemRemoved(viewHolder.getAdapterPosition());
    }

    @Override
    public void onItemClick(int postion) {
        if (datas.get(postion).equals(ITEM_ADD)) {
            // TODO check premission and dialog
            DialogUtils.showListDialog(this, new String[]{
                    "拍照", "打开相册"
            }, new DialogUtils.ListDialogCallback() {
                @Override
                public void onItemClick(int postion) {

                }
            });
            return;
        }
        Intent intent = new Intent(MainActivity.this, ImagePreviewActivity.class);
        intent.putStringArrayListExtra("images", (ArrayList<String>) datas);
        intent.putExtra("postion", postion);
        startActivityForResult(intent, 0);
    }

    private void layoutContainer() {
        int top = 0;
        if (datas.size() < 5) {
            top = getResources().getDimensionPixelSize(R.dimen.dimen_size_160)
                    + getResources().getDimensionPixelSize(R.dimen.dimen_size_62)
                    + getResources().getDimensionPixelSize(R.dimen.dimen_size_18);
        }
        if (datas.size() > 4 && datas.size() < 9) {
            top = getResources().getDimensionPixelSize(R.dimen.dimen_size_160)
                    + getResources().getDimensionPixelSize(R.dimen.dimen_size_62) * 2
                    + getResources().getDimensionPixelSize(R.dimen.dimen_size_8)
                    + getResources().getDimensionPixelSize(R.dimen.dimen_size_18);
        }
        if (datas.size() >= 9) {
            top = getResources().getDimensionPixelSize(R.dimen.dimen_size_160)
                    + getResources().getDimensionPixelSize(R.dimen.dimen_size_62) * 3
                    + getResources().getDimensionPixelSize(R.dimen.dimen_size_8) * 2
                    + getResources().getDimensionPixelSize(R.dimen.dimen_size_18);
        }
        RelativeLayout.LayoutParams params = (RelativeLayout.LayoutParams) container.getLayoutParams();
        params.topMargin = top;
        container.setLayoutParams(params);
    }

    private void showDeleteLayout(boolean show) {
        int detalY = getResources().getDimensionPixelSize(R.dimen.dimen_size_63);
        if (show) {
            rlDelete.setVisibility(View.VISIBLE);
            ViewCompat.animate(rlDelete)
                    .translationZ(3f).translationY(-detalY).alpha(1).start();
        } else {
            rlDelete.setVisibility(View.GONE);
            ViewCompat.animate(rlDelete).translationY(0).alpha(0).start();
        }
    }
}
