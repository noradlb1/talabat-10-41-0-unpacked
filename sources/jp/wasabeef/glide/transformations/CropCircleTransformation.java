package jp.wasabeef.glide.transformations;

import android.content.Context;
import android.graphics.Bitmap;
import androidx.annotation.NonNull;
import com.bumptech.glide.load.Key;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import com.bumptech.glide.load.resource.bitmap.TransformationUtils;
import java.security.MessageDigest;

@Deprecated
public class CropCircleTransformation extends BitmapTransformation {
    private static final String ID = "jp.wasabeef.glide.transformations.CropCircleTransformation.1";
    private static final int VERSION = 1;

    public Bitmap b(@NonNull Context context, @NonNull BitmapPool bitmapPool, @NonNull Bitmap bitmap, int i11, int i12) {
        return TransformationUtils.circleCrop(bitmapPool, bitmap, i11, i12);
    }

    public boolean equals(Object obj) {
        return obj instanceof CropCircleTransformation;
    }

    public int hashCode() {
        return 1288474723;
    }

    public String toString() {
        return "CropCircleTransformation()";
    }

    public void updateDiskCacheKey(@NonNull MessageDigest messageDigest) {
        messageDigest.update(ID.getBytes(Key.CHARSET));
    }
}
