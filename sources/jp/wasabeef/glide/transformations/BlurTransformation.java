package jp.wasabeef.glide.transformations;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.renderscript.RSRuntimeException;
import androidx.annotation.NonNull;
import com.bumptech.glide.load.Key;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import java.security.MessageDigest;
import jp.wasabeef.glide.transformations.internal.FastBlur;
import jp.wasabeef.glide.transformations.internal.RSBlur;

public class BlurTransformation extends BitmapTransformation {
    private static final int DEFAULT_DOWN_SAMPLING = 1;
    private static final String ID = "jp.wasabeef.glide.transformations.BlurTransformation.1";
    private static final int MAX_RADIUS = 25;
    private static final int VERSION = 1;
    private final int radius;
    private final int sampling;

    public BlurTransformation() {
        this(25, 1);
    }

    public Bitmap b(@NonNull Context context, @NonNull BitmapPool bitmapPool, @NonNull Bitmap bitmap, int i11, int i12) {
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        int i13 = this.sampling;
        Bitmap bitmap2 = bitmapPool.get(width / i13, height / i13, Bitmap.Config.ARGB_8888);
        a(bitmap, bitmap2);
        Canvas canvas = new Canvas(bitmap2);
        int i14 = this.sampling;
        canvas.scale(1.0f / ((float) i14), 1.0f / ((float) i14));
        Paint paint = new Paint();
        paint.setFlags(2);
        canvas.drawBitmap(bitmap, 0.0f, 0.0f, paint);
        try {
            return RSBlur.blur(context, bitmap2, this.radius);
        } catch (RSRuntimeException unused) {
            return FastBlur.blur(bitmap2, this.radius, true);
        }
    }

    public boolean equals(Object obj) {
        if (obj instanceof BlurTransformation) {
            BlurTransformation blurTransformation = (BlurTransformation) obj;
            return blurTransformation.radius == this.radius && blurTransformation.sampling == this.sampling;
        }
    }

    public int hashCode() {
        return 737513610 + (this.radius * 1000) + (this.sampling * 10);
    }

    public String toString() {
        return "BlurTransformation(radius=" + this.radius + ", sampling=" + this.sampling + ")";
    }

    public void updateDiskCacheKey(@NonNull MessageDigest messageDigest) {
        messageDigest.update((ID + this.radius + this.sampling).getBytes(Key.CHARSET));
    }

    public BlurTransformation(int i11) {
        this(i11, 1);
    }

    public BlurTransformation(int i11, int i12) {
        this.radius = i11;
        this.sampling = i12;
    }
}
