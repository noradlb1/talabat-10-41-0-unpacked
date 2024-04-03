package com.squareup.picasso;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import com.squareup.picasso.Picasso;

class FetchAction extends Action<Object> {
    private Callback callback;
    private final Object target = new Object();

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FetchAction(Picasso picasso, Request request, int i11, int i12, Object obj, String str, Callback callback2) {
        super(picasso, null, request, i11, i12, 0, (Drawable) null, str, obj, false);
        this.callback = callback2;
    }

    public void a() {
        super.a();
        this.callback = null;
    }

    public void complete(Bitmap bitmap, Picasso.LoadedFrom loadedFrom) {
        Callback callback2 = this.callback;
        if (callback2 != null) {
            callback2.onSuccess();
        }
    }

    public void error(Exception exc) {
        Callback callback2 = this.callback;
        if (callback2 != null) {
            callback2.onError(exc);
        }
    }

    public Object i() {
        return this.target;
    }
}
