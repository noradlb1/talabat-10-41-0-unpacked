package com.bumptech.glide.load.engine.bitmap_recycle;

import android.graphics.Bitmap;
import androidx.annotation.NonNull;

public class BitmapPoolAdapter implements BitmapPool {
    public void clearMemory() {
    }

    @NonNull
    public Bitmap get(int i11, int i12, Bitmap.Config config) {
        return Bitmap.createBitmap(i11, i12, config);
    }

    @NonNull
    public Bitmap getDirty(int i11, int i12, Bitmap.Config config) {
        return get(i11, i12, config);
    }

    public long getMaxSize() {
        return 0;
    }

    public void put(Bitmap bitmap) {
        bitmap.recycle();
    }

    public void setSizeMultiplier(float f11) {
    }

    public void trimMemory(int i11) {
    }
}
