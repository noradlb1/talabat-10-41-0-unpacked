package jp.wasabeef.glide.transformations;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.drawable.Drawable;
import androidx.annotation.NonNull;
import com.bumptech.glide.load.Key;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import java.security.MessageDigest;

public class MaskTransformation extends BitmapTransformation {
    private static final String ID = "jp.wasabeef.glide.transformations.MaskTransformation.1";
    private static final int VERSION = 1;
    private static final Paint paint;
    private final int maskId;

    static {
        Paint paint2 = new Paint();
        paint = paint2;
        paint2.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
    }

    public MaskTransformation(int i11) {
        this.maskId = i11;
    }

    public Bitmap b(@NonNull Context context, @NonNull BitmapPool bitmapPool, @NonNull Bitmap bitmap, int i11, int i12) {
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        Bitmap bitmap2 = bitmapPool.get(width, height, Bitmap.Config.ARGB_8888);
        bitmap2.setHasAlpha(true);
        Drawable drawable = context.getDrawable(this.maskId);
        a(bitmap, bitmap2);
        Canvas canvas = new Canvas(bitmap2);
        drawable.setBounds(0, 0, width, height);
        drawable.draw(canvas);
        canvas.drawBitmap(bitmap, 0.0f, 0.0f, paint);
        return bitmap2;
    }

    public boolean equals(Object obj) {
        return (obj instanceof MaskTransformation) && ((MaskTransformation) obj).maskId == this.maskId;
    }

    public int hashCode() {
        return -1949385457 + (this.maskId * 10);
    }

    public String toString() {
        return "MaskTransformation(maskId=" + this.maskId + ")";
    }

    public void updateDiskCacheKey(@NonNull MessageDigest messageDigest) {
        messageDigest.update((ID + this.maskId).getBytes(Key.CHARSET));
    }
}
