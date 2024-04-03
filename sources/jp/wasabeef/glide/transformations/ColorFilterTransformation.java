package jp.wasabeef.glide.transformations;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import androidx.annotation.NonNull;
import com.bumptech.glide.load.Key;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import java.security.MessageDigest;

public class ColorFilterTransformation extends BitmapTransformation {
    private static final String ID = "jp.wasabeef.glide.transformations.ColorFilterTransformation.1";
    private static final int VERSION = 1;
    private final int color;

    public ColorFilterTransformation(int i11) {
        this.color = i11;
    }

    public Bitmap b(@NonNull Context context, @NonNull BitmapPool bitmapPool, @NonNull Bitmap bitmap, int i11, int i12) {
        Bitmap.Config config;
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        if (bitmap.getConfig() != null) {
            config = bitmap.getConfig();
        } else {
            config = Bitmap.Config.ARGB_8888;
        }
        Bitmap bitmap2 = bitmapPool.get(width, height, config);
        a(bitmap, bitmap2);
        Canvas canvas = new Canvas(bitmap2);
        Paint paint = new Paint();
        paint.setAntiAlias(true);
        paint.setColorFilter(new PorterDuffColorFilter(this.color, PorterDuff.Mode.SRC_ATOP));
        canvas.drawBitmap(bitmap, 0.0f, 0.0f, paint);
        return bitmap2;
    }

    public boolean equals(Object obj) {
        return (obj instanceof ColorFilterTransformation) && ((ColorFilterTransformation) obj).color == this.color;
    }

    public int hashCode() {
        return 705373712 + (this.color * 10);
    }

    public String toString() {
        return "ColorFilterTransformation(color=" + this.color + ")";
    }

    public void updateDiskCacheKey(@NonNull MessageDigest messageDigest) {
        messageDigest.update((ID + this.color).getBytes(Key.CHARSET));
    }
}
