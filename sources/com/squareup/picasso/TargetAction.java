package com.squareup.picasso;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import com.squareup.picasso.Picasso;

final class TargetAction extends Action<Target> {
    public TargetAction(Picasso picasso, Target target, Request request, int i11, int i12, Drawable drawable, String str, Object obj, int i13) {
        super(picasso, target, request, i11, i12, i13, drawable, str, obj, false);
    }

    public void complete(Bitmap bitmap, Picasso.LoadedFrom loadedFrom) {
        if (bitmap != null) {
            Target target = (Target) i();
            if (target != null) {
                target.onBitmapLoaded(bitmap, loadedFrom);
                if (bitmap.isRecycled()) {
                    throw new IllegalStateException("Target callback must not recycle bitmap!");
                }
                return;
            }
            return;
        }
        throw new AssertionError(String.format("Attempted to complete action with no result!\n%s", new Object[]{this}));
    }

    public void error(Exception exc) {
        Target target = (Target) i();
        if (target == null) {
            return;
        }
        if (this.f53364g != 0) {
            target.onBitmapFailed(exc, this.f53358a.f53433a.getResources().getDrawable(this.f53364g));
        } else {
            target.onBitmapFailed(exc, this.f53365h);
        }
    }
}
