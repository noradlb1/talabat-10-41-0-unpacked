package com.bumptech.glide.load.resource.bitmap;

import android.graphics.Bitmap;
import androidx.annotation.NonNull;
import com.bumptech.glide.load.Key;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import java.security.MessageDigest;

public class CenterInside extends BitmapTransformation {
    private static final String ID = "com.bumptech.glide.load.resource.bitmap.CenterInside";
    private static final byte[] ID_BYTES = ID.getBytes(Key.CHARSET);

    public boolean equals(Object obj) {
        return obj instanceof CenterInside;
    }

    public int hashCode() {
        return -670243078;
    }

    public Bitmap transform(@NonNull BitmapPool bitmapPool, @NonNull Bitmap bitmap, int i11, int i12) {
        return TransformationUtils.centerInside(bitmapPool, bitmap, i11, i12);
    }

    public void updateDiskCacheKey(@NonNull MessageDigest messageDigest) {
        messageDigest.update(ID_BYTES);
    }
}
