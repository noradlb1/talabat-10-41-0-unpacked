package jp.wasabeef.glide.transformations;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import androidx.annotation.NonNull;
import com.bumptech.glide.load.Key;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import java.security.MessageDigest;

public class CropTransformation extends BitmapTransformation {
    private static final String ID = "jp.wasabeef.glide.transformations.CropTransformation.1";
    private static final int VERSION = 1;
    private CropType cropType;
    private int height;
    private int width;

    /* renamed from: jp.wasabeef.glide.transformations.CropTransformation$1  reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f23708a;

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|(3:5|6|8)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        static {
            /*
                jp.wasabeef.glide.transformations.CropTransformation$CropType[] r0 = jp.wasabeef.glide.transformations.CropTransformation.CropType.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f23708a = r0
                jp.wasabeef.glide.transformations.CropTransformation$CropType r1 = jp.wasabeef.glide.transformations.CropTransformation.CropType.TOP     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f23708a     // Catch:{ NoSuchFieldError -> 0x001d }
                jp.wasabeef.glide.transformations.CropTransformation$CropType r1 = jp.wasabeef.glide.transformations.CropTransformation.CropType.CENTER     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = f23708a     // Catch:{ NoSuchFieldError -> 0x0028 }
                jp.wasabeef.glide.transformations.CropTransformation$CropType r1 = jp.wasabeef.glide.transformations.CropTransformation.CropType.BOTTOM     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: jp.wasabeef.glide.transformations.CropTransformation.AnonymousClass1.<clinit>():void");
        }
    }

    public enum CropType {
        TOP,
        CENTER,
        BOTTOM
    }

    public CropTransformation(int i11, int i12) {
        this(i11, i12, CropType.CENTER);
    }

    private float getTop(float f11) {
        int i11 = AnonymousClass1.f23708a[this.cropType.ordinal()];
        if (i11 == 2) {
            return (((float) this.height) - f11) / 2.0f;
        }
        if (i11 != 3) {
            return 0.0f;
        }
        return ((float) this.height) - f11;
    }

    public Bitmap b(@NonNull Context context, @NonNull BitmapPool bitmapPool, @NonNull Bitmap bitmap, int i11, int i12) {
        Bitmap.Config config;
        int i13 = this.width;
        if (i13 == 0) {
            i13 = bitmap.getWidth();
        }
        this.width = i13;
        int i14 = this.height;
        if (i14 == 0) {
            i14 = bitmap.getHeight();
        }
        this.height = i14;
        if (bitmap.getConfig() != null) {
            config = bitmap.getConfig();
        } else {
            config = Bitmap.Config.ARGB_8888;
        }
        Bitmap bitmap2 = bitmapPool.get(this.width, this.height, config);
        bitmap2.setHasAlpha(true);
        float max = Math.max(((float) this.width) / ((float) bitmap.getWidth()), ((float) this.height) / ((float) bitmap.getHeight()));
        float width2 = ((float) bitmap.getWidth()) * max;
        float height2 = max * ((float) bitmap.getHeight());
        float f11 = (((float) this.width) - width2) / 2.0f;
        float top = getTop(height2);
        RectF rectF = new RectF(f11, top, width2 + f11, height2 + top);
        a(bitmap, bitmap2);
        new Canvas(bitmap2).drawBitmap(bitmap, (Rect) null, rectF, (Paint) null);
        return bitmap2;
    }

    public boolean equals(Object obj) {
        if (obj instanceof CropTransformation) {
            CropTransformation cropTransformation = (CropTransformation) obj;
            return cropTransformation.width == this.width && cropTransformation.height == this.height && cropTransformation.cropType == this.cropType;
        }
    }

    public int hashCode() {
        return -1462327117 + (this.width * 100000) + (this.height * 1000) + (this.cropType.ordinal() * 10);
    }

    public String toString() {
        return "CropTransformation(width=" + this.width + ", height=" + this.height + ", cropType=" + this.cropType + ")";
    }

    public void updateDiskCacheKey(@NonNull MessageDigest messageDigest) {
        messageDigest.update((ID + this.width + this.height + this.cropType).getBytes(Key.CHARSET));
    }

    public CropTransformation(int i11, int i12, CropType cropType2) {
        CropType cropType3 = CropType.TOP;
        this.width = i11;
        this.height = i12;
        this.cropType = cropType2;
    }
}
