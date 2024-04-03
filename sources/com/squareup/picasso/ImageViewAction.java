package com.squareup.picasso;

import android.graphics.Bitmap;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import com.squareup.picasso.Picasso;

class ImageViewAction extends Action<ImageView> {

    /* renamed from: m  reason: collision with root package name */
    public Callback f53417m;

    public ImageViewAction(Picasso picasso, ImageView imageView, Request request, int i11, int i12, int i13, Drawable drawable, String str, Object obj, Callback callback, boolean z11) {
        super(picasso, imageView, request, i11, i12, i13, drawable, str, obj, z11);
        this.f53417m = callback;
    }

    public void a() {
        super.a();
        if (this.f53417m != null) {
            this.f53417m = null;
        }
    }

    public void complete(Bitmap bitmap, Picasso.LoadedFrom loadedFrom) {
        if (bitmap != null) {
            ImageView imageView = (ImageView) this.f53360c.get();
            if (imageView != null) {
                Picasso picasso = this.f53358a;
                Bitmap bitmap2 = bitmap;
                Picasso.LoadedFrom loadedFrom2 = loadedFrom;
                PicassoDrawable.a(imageView, picasso.f53433a, bitmap2, loadedFrom2, this.f53361d, picasso.f53441i);
                Callback callback = this.f53417m;
                if (callback != null) {
                    callback.onSuccess();
                    return;
                }
                return;
            }
            return;
        }
        throw new AssertionError(String.format("Attempted to complete action with no result!\n%s", new Object[]{this}));
    }

    public void error(Exception exc) {
        ImageView imageView = (ImageView) this.f53360c.get();
        if (imageView != null) {
            Drawable drawable = imageView.getDrawable();
            if (drawable instanceof Animatable) {
                ((Animatable) drawable).stop();
            }
            int i11 = this.f53364g;
            if (i11 != 0) {
                imageView.setImageResource(i11);
            } else {
                Drawable drawable2 = this.f53365h;
                if (drawable2 != null) {
                    imageView.setImageDrawable(drawable2);
                }
            }
            Callback callback = this.f53417m;
            if (callback != null) {
                callback.onError(exc);
            }
        }
    }
}
