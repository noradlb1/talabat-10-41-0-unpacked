package com.squareup.picasso;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import com.squareup.picasso.Picasso;

class GetAction extends Action<Void> {
    public GetAction(Picasso picasso, Request request, int i11, int i12, Object obj, String str) {
        super(picasso, null, request, i11, i12, 0, (Drawable) null, str, obj, false);
    }

    public void complete(Bitmap bitmap, Picasso.LoadedFrom loadedFrom) {
    }

    public void error(Exception exc) {
    }
}
