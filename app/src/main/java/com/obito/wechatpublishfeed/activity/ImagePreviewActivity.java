package com.obito.wechatpublishfeed.activity;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.obito.wechatpublishfeed.R;

import java.util.List;

public class ImagePreviewActivity extends AppCompatActivity {

    private List<String> uris;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_preview);
    }
}
