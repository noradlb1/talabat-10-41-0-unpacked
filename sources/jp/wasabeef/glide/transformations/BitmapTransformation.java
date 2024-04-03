package jp.wasabeef.glide.transformations;

import android.content.Context;
import android.graphics.Bitmap;
import androidx.annotation.NonNull;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.Transformation;
import com.bumptech.glide.load.engine.Resource;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import com.bumptech.glide.load.resource.bitmap.BitmapResource;
import com.bumptech.glide.util.Util;
import java.security.MessageDigest;

public abstract class BitmapTransformation implements Transformation<Bitmap> {
    public void a(@NonNull Bitmap bitmap, @NonNull Bitmap bitmap2) {
        bitmap2.setDensity(bitmap.getDensity());
    }

    public abstract Bitmap b(@NonNull Context context, @NonNull BitmapPool bitmapPool, @NonNull Bitmap bitmap, int i11, int i12);

    public abstract boolean equals(Object obj);

    public abstract int hashCode();

    @NonNull
    public final Resource<Bitmap> transform(@NonNull Context context, @NonNull Resource<Bitmap> resource, int i11, int i12) {
        if (Util.isValidDimensions(i11, i12)) {
            BitmapPool bitmapPool = Glide.get(context).getBitmapPool();
            Bitmap bitmap = resource.get();
            if (i11 == Integer.MIN_VALUE) {
                i11 = bitmap.getWidth();
            }
            int i13 = i11;
            if (i12 == Integer.MIN_VALUE) {
                i12 = bitmap.getHeight();
            }
            Bitmap b11 = b(context.getApplicationContext(), bitmapPool, bitmap, i13, i12);
            if (bitmap.equals(b11)) {
                return resource;
            }
            return BitmapResource.obtain(b11, bitmapPool);
        }
        throw new IllegalArgumentException("Cannot apply transformation on width: " + i11 + " or height: " + i12 + " less than or equal to zero and not Target.SIZE_ORIGINAL");
    }

    public abstract void updateDiskCacheKey(@NonNull MessageDigest messageDigest);
}
