package com.obito.wechatpublishfeed;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.obito.wechatpublishfeed.helper.FeedImageTouchCallback;
import com.obito.wechatpublishfeed.helper.FeedImageTouchHelper;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;

    private FeedLayoutManager layoutManager;
    private FeedImageAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initTouchHelper();
    }

    private void initView() {
        recyclerView = findViewById(R.id.recyclerview);
        layoutManager = new FeedLayoutManager(this, 4, LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(layoutManager);
        adapter = new FeedImageAdapter(this);
        List<String> datas = new ArrayList<>();
        datas.add("https://ss0.bdstatic.com/94oJfD_bAAcT8t7mm9GUKT-xh_/timg?image&quality=100&size=b4000_4000&sec=1523781928&di=6cb444c97297804abd343d163ce740bd&src=http://e.hiphotos.baidu.com/zhidao/pic/item/8ad4b31c8701a18bfb27b67d992f07082838fe30.jpg");
        datas.add("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1523792014586&di=efc381a58ff70839c1f27da80f0eadcb&imgtype=0&src=http%3A%2F%2Fimgsrc.baidu.com%2Fforum%2Fw%3D580%2Fsign%3D7276a1157c1ed21b79c92eed9d6cddae%2Fb532ae0f4bfbfbed5e86069879f0f736adc31f93.jpg");
        datas.add("https://ss0.bdstatic.com/94oJfD_bAAcT8t7mm9GUKT-xh_/timg?image&quality=100&size=b4000_4000&sec=1523781928&di=6cb444c97297804abd343d163ce740bd&src=http://e.hiphotos.baidu.com/zhidao/pic/item/8ad4b31c8701a18bfb27b67d992f07082838fe30.jpg");
        datas.add("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1523792014584&di=8c77e4922fc5ef57b74d5110beec6fdd&imgtype=0&src=http%3A%2F%2Fimages6.fanpop.com%2Fimage%2Fpolls%2F1360000%2F1360567_1396688397759_full.jpg%3Fv%3D1396688440");
        datas.add("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1523792014584&di=8c77e4922fc5ef57b74d5110beec6fdd&imgtype=0&src=http%3A%2F%2Fimages6.fanpop.com%2Fimage%2Fpolls%2F1360000%2F1360567_1396688397759_full.jpg%3Fv%3D1396688440");
        datas.add("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1523792014584&di=8c77e4922fc5ef57b74d5110beec6fdd&imgtype=0&src=http%3A%2F%2Fimages6.fanpop.com%2Fimage%2Fpolls%2F1360000%2F1360567_1396688397759_full.jpg%3Fv%3D1396688440");
        datas.add("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1523792014584&di=8c77e4922fc5ef57b74d5110beec6fdd&imgtype=0&src=http%3A%2F%2Fimages6.fanpop.com%2Fimage%2Fpolls%2F1360000%2F1360567_1396688397759_full.jpg%3Fv%3D1396688440");
        datas.add("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1523792014586&di=efc381a58ff70839c1f27da80f0eadcb&imgtype=0&src=http%3A%2F%2Fimgsrc.baidu.com%2Fforum%2Fw%3D580%2Fsign%3D7276a1157c1ed21b79c92eed9d6cddae%2Fb532ae0f4bfbfbed5e86069879f0f736adc31f93.jpg");
        adapter.setDatas(datas);
        recyclerView.setAdapter(adapter);

    }

    private void initTouchHelper() {
        FeedImageTouchCallback touchCallback = new FeedImageTouchCallback();

        FeedImageTouchHelper touchHelper = new FeedImageTouchHelper(touchCallback);
        touchHelper.attachToRecyclerView(recyclerView);
    }
}
