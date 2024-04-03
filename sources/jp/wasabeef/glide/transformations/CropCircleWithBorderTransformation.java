package jp.wasabeef.glide.transformations;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import androidx.annotation.ColorInt;
import androidx.annotation.NonNull;
import androidx.core.view.ViewCompat;
import com.bumptech.glide.load.Key;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import com.bumptech.glide.load.resource.bitmap.TransformationUtils;
import java.security.MessageDigest;
import jp.wasabeef.glide.transformations.internal.Utils;

public class CropCircleWithBorderTransformation extends BitmapTransformation {
    private static final String ID = "jp.wasabeef.glide.transformations.CropCircleWithBorderTransformation.1";
    private static final int VERSION = 1;
    private final int borderColor;
    private final int borderSize;

    public CropCircleWithBorderTransformation() {
        this.borderSize = Utils.toDp(4);
        this.borderColor = ViewCompat.MEASURED_STATE_MASK;
    }

    public Bitmap b(@NonNull Context context, @NonNull BitmapPool bitmapPool, @NonNull Bitmap bitmap, int i11, int i12) {
        Bitmap circleCrop = TransformationUtils.circleCrop(bitmapPool, bitmap, i11, i12);
        a(bitmap, circleCrop);
        Paint paint = new Paint();
        paint.setColor(this.borderColor);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth((float) this.borderSize);
        paint.setAntiAlias(true);
        new Canvas(circleCrop).drawCircle(((float) i11) / 2.0f, ((float) i12) / 2.0f, (((float) Math.max(i11, i12)) / 2.0f) - (((float) this.borderSize) / 2.0f), paint);
        return circleCrop;
    }

    public boolean equals(Object obj) {
        if (obj instanceof CropCircleWithBorderTransformation) {
            CropCircleWithBorderTransformation cropCircleWithBorderTransformation = (CropCircleWithBorderTransformation) obj;
            return cropCircleWithBorderTransformation.borderSize == this.borderSize && cropCircleWithBorderTransformation.borderColor == this.borderColor;
        }
    }

    public int hashCode() {
        return 882652245 + (this.borderSize * 100) + this.borderColor + 10;
    }

    public void updateDiskCacheKey(@NonNull MessageDigest messageDigest) {
        messageDigest.update((ID + this.borderSize + this.borderColor).getBytes(Key.CHARSET));
    }

    public CropCircleWithBorderTransformation(int i11, @ColorInt int i12) {
        this.borderSize = i11;
        this.borderColor = i12;
    }
}
