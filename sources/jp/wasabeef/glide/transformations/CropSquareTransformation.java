package jp.wasabeef.glide.transformations;

import android.content.Context;
import android.graphics.Bitmap;
import androidx.annotation.NonNull;
import com.bumptech.glide.load.Key;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import com.bumptech.glide.load.resource.bitmap.TransformationUtils;
import java.security.MessageDigest;

public class CropSquareTransformation extends BitmapTransformation {
    private static final String ID = "jp.wasabeef.glide.transformations.CropSquareTransformation.1";
    private static final int VERSION = 1;
    private int size;

    public Bitmap b(@NonNull Context context, @NonNull BitmapPool bitmapPool, @NonNull Bitmap bitmap, int i11, int i12) {
        int max = Math.max(i11, i12);
        this.size = max;
        return TransformationUtils.centerCrop(bitmapPool, bitmap, max, max);
    }

    public boolean equals(Object obj) {
        return (obj instanceof CropSquareTransformation) && ((CropSquareTransformation) obj).size == this.size;
    }

    public int hashCode() {
        return -789843280 + (this.size * 10);
    }

    public String toString() {
        return "CropSquareTransformation(size=" + this.size + ")";
    }

    public void updateDiskCacheKey(@NonNull MessageDigest messageDigest) {
        messageDigest.update((ID + this.size).getBytes(Key.CHARSET));
    }
}
