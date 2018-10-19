package com.obito.wechatpublishfeed.utils;


import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;


public class DialogUtils {

    public static void showListDialog(Context context, String[] items, final ListDialogCallback callback) {
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setItems(items, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                if (callback != null) {
                    callback.onItemClick(which);
                }
            }
        });
        AlertDialog dialog = builder.create();
        dialog.show();
    }

    public interface ListDialogCallback {
        void onItemClick(int postion);
    }
}
