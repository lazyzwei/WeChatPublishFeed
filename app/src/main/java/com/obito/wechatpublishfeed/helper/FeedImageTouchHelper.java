package com.obito.wechatpublishfeed.helper;

import android.support.v7.widget.helper.ItemTouchHelper;


public class FeedImageTouchHelper extends ItemTouchHelper {

    /**
     * Creates an ItemTouchHelper that will work with the given Callback.
     * <p>
     * You can attach ItemTouchHelper to a RecyclerView via
     * {@link #attachToRecyclerView(RecyclerView)}. Upon attaching, it will add an item decoration,
     * an onItemTouchListener and a Child attach / detach listener to the RecyclerView.
     *
     * @param callback The Callback which controls the behavior of this touch helper.
     */
    public FeedImageTouchHelper(Callback callback) {
        super(callback);
    }

}
