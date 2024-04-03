package com.bumptech.glide.load.resource.bitmap;

import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.os.Build;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.VisibleForTesting;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import com.bumptech.glide.util.Preconditions;
import com.huawei.hms.flutter.map.constants.Param;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public final class TransformationUtils {
    private static final Lock BITMAP_DRAWABLE_LOCK;
    private static final Paint CIRCLE_CROP_BITMAP_PAINT;
    private static final int CIRCLE_CROP_PAINT_FLAGS = 7;
    private static final Paint CIRCLE_CROP_SHAPE_PAINT = new Paint(7);
    private static final Paint DEFAULT_PAINT = new Paint(6);
    private static final Set<String> MODELS_REQUIRING_BITMAP_LOCK;
    public static final int PAINT_FLAGS = 6;
    private static final String TAG = "TransformationUtils";

    public interface DrawRoundedCornerFn {
        void drawRoundedCorners(Canvas canvas, Paint paint, RectF rectF);
    }

    public static final class NoLock implements Lock {
        public void lock() {
        }

        public void lockInterruptibly() throws InterruptedException {
        }

        @NonNull
        public Condition newCondition() {
            throw new UnsupportedOperationException("Should not be called");
        }

        public boolean tryLock() {
            return true;
        }

        public boolean tryLock(long j11, @NonNull TimeUnit timeUnit) throws InterruptedException {
            return true;
        }

        public void unlock() {
        }
    }

    static {
        Lock lock;
        HashSet hashSet = new HashSet(Arrays.asList(new String[]{"XT1085", "XT1092", "XT1093", "XT1094", "XT1095", "XT1096", "XT1097", "XT1098", "XT1031", "XT1028", "XT937C", "XT1032", "XT1008", "XT1033", "XT1035", "XT1034", "XT939G", "XT1039", "XT1040", "XT1042", "XT1045", "XT1063", "XT1064", "XT1068", "XT1069", "XT1072", "XT1077", "XT1078", "XT1079"}));
        MODELS_REQUIRING_BITMAP_LOCK = hashSet;
        if (hashSet.contains(Build.MODEL)) {
            lock = new ReentrantLock();
        } else {
            lock = new NoLock();
        }
        BITMAP_DRAWABLE_LOCK = lock;
        Paint paint = new Paint(7);
        CIRCLE_CROP_BITMAP_PAINT = paint;
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
    }

    private TransformationUtils() {
    }

    private static void applyMatrix(@NonNull Bitmap bitmap, @NonNull Bitmap bitmap2, Matrix matrix) {
        Lock lock = BITMAP_DRAWABLE_LOCK;
        lock.lock();
        try {
            Canvas canvas = new Canvas(bitmap2);
            canvas.drawBitmap(bitmap, matrix, DEFAULT_PAINT);
            clear(canvas);
            lock.unlock();
        } catch (Throwable th2) {
            BITMAP_DRAWABLE_LOCK.unlock();
            throw th2;
        }
    }

    public static Bitmap centerCrop(@NonNull BitmapPool bitmapPool, @NonNull Bitmap bitmap, int i11, int i12) {
        float f11;
        float f12;
        if (bitmap.getWidth() == i11 && bitmap.getHeight() == i12) {
            return bitmap;
        }
        Matrix matrix = new Matrix();
        float f13 = 0.0f;
        if (bitmap.getWidth() * i12 > bitmap.getHeight() * i11) {
            f12 = ((float) i12) / ((float) bitmap.getHeight());
            f13 = (((float) i11) - (((float) bitmap.getWidth()) * f12)) * 0.5f;
            f11 = 0.0f;
        } else {
            f12 = ((float) i11) / ((float) bitmap.getWidth());
            f11 = (((float) i12) - (((float) bitmap.getHeight()) * f12)) * 0.5f;
        }
        matrix.setScale(f12, f12);
        matrix.postTranslate((float) ((int) (f13 + 0.5f)), (float) ((int) (f11 + 0.5f)));
        Bitmap bitmap2 = bitmapPool.get(i11, i12, getNonNullConfig(bitmap));
        setAlpha(bitmap, bitmap2);
        applyMatrix(bitmap, bitmap2, matrix);
        return bitmap2;
    }

    public static Bitmap centerInside(@NonNull BitmapPool bitmapPool, @NonNull Bitmap bitmap, int i11, int i12) {
        if (bitmap.getWidth() > i11 || bitmap.getHeight() > i12) {
            Log.isLoggable(TAG, 2);
            return fitCenter(bitmapPool, bitmap, i11, i12);
        }
        Log.isLoggable(TAG, 2);
        return bitmap;
    }

    public static Bitmap circleCrop(@NonNull BitmapPool bitmapPool, @NonNull Bitmap bitmap, int i11, int i12) {
        int min = Math.min(i11, i12);
        float f11 = (float) min;
        float f12 = f11 / 2.0f;
        float width = (float) bitmap.getWidth();
        float height = (float) bitmap.getHeight();
        float max = Math.max(f11 / width, f11 / height);
        float f13 = width * max;
        float f14 = max * height;
        float f15 = (f11 - f13) / 2.0f;
        float f16 = (f11 - f14) / 2.0f;
        RectF rectF = new RectF(f15, f16, f13 + f15, f14 + f16);
        Bitmap alphaSafeBitmap = getAlphaSafeBitmap(bitmapPool, bitmap);
        Bitmap bitmap2 = bitmapPool.get(min, min, getAlphaSafeConfig(bitmap));
        bitmap2.setHasAlpha(true);
        Lock lock = BITMAP_DRAWABLE_LOCK;
        lock.lock();
        try {
            Canvas canvas = new Canvas(bitmap2);
            canvas.drawCircle(f12, f12, f12, CIRCLE_CROP_SHAPE_PAINT);
            canvas.drawBitmap(alphaSafeBitmap, (Rect) null, rectF, CIRCLE_CROP_BITMAP_PAINT);
            clear(canvas);
            lock.unlock();
            if (!alphaSafeBitmap.equals(bitmap)) {
                bitmapPool.put(alphaSafeBitmap);
            }
            return bitmap2;
        } catch (Throwable th2) {
            BITMAP_DRAWABLE_LOCK.unlock();
            throw th2;
        }
    }

    private static void clear(Canvas canvas) {
        canvas.setBitmap((Bitmap) null);
    }

    public static Bitmap fitCenter(@NonNull BitmapPool bitmapPool, @NonNull Bitmap bitmap, int i11, int i12) {
        if (bitmap.getWidth() == i11 && bitmap.getHeight() == i12) {
            Log.isLoggable(TAG, 2);
            return bitmap;
        }
        float min = Math.min(((float) i11) / ((float) bitmap.getWidth()), ((float) i12) / ((float) bitmap.getHeight()));
        int round = Math.round(((float) bitmap.getWidth()) * min);
        int round2 = Math.round(((float) bitmap.getHeight()) * min);
        if (bitmap.getWidth() == round && bitmap.getHeight() == round2) {
            Log.isLoggable(TAG, 2);
            return bitmap;
        }
        Bitmap bitmap2 = bitmapPool.get((int) (((float) bitmap.getWidth()) * min), (int) (((float) bitmap.getHeight()) * min), getNonNullConfig(bitmap));
        setAlpha(bitmap, bitmap2);
        if (Log.isLoggable(TAG, 2)) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("request: ");
            sb2.append(i11);
            sb2.append(Param.X);
            sb2.append(i12);
            StringBuilder sb3 = new StringBuilder();
            sb3.append("toFit:   ");
            sb3.append(bitmap.getWidth());
            sb3.append(Param.X);
            sb3.append(bitmap.getHeight());
            StringBuilder sb4 = new StringBuilder();
            sb4.append("toReuse: ");
            sb4.append(bitmap2.getWidth());
            sb4.append(Param.X);
            sb4.append(bitmap2.getHeight());
            StringBuilder sb5 = new StringBuilder();
            sb5.append("minPct:   ");
            sb5.append(min);
        }
        Matrix matrix = new Matrix();
        matrix.setScale(min, min);
        applyMatrix(bitmap, bitmap2, matrix);
        return bitmap2;
    }

    private static Bitmap getAlphaSafeBitmap(@NonNull BitmapPool bitmapPool, @NonNull Bitmap bitmap) {
        Bitmap.Config alphaSafeConfig = getAlphaSafeConfig(bitmap);
        if (alphaSafeConfig.equals(bitmap.getConfig())) {
            return bitmap;
        }
        Bitmap bitmap2 = bitmapPool.get(bitmap.getWidth(), bitmap.getHeight(), alphaSafeConfig);
        new Canvas(bitmap2).drawBitmap(bitmap, 0.0f, 0.0f, (Paint) null);
        return bitmap2;
    }

    @NonNull
    private static Bitmap.Config getAlphaSafeConfig(@NonNull Bitmap bitmap) {
        if (Build.VERSION.SDK_INT < 26 || !Bitmap.Config.RGBA_F16.equals(bitmap.getConfig())) {
            return Bitmap.Config.ARGB_8888;
        }
        return Bitmap.Config.RGBA_F16;
    }

    public static Lock getBitmapDrawableLock() {
        return BITMAP_DRAWABLE_LOCK;
    }

    public static int getExifOrientationDegrees(int i11) {
        switch (i11) {
            case 3:
            case 4:
                return 180;
            case 5:
            case 6:
                return 90;
            case 7:
            case 8:
                return 270;
            default:
                return 0;
        }
    }

    @NonNull
    private static Bitmap.Config getNonNullConfig(@NonNull Bitmap bitmap) {
        return bitmap.getConfig() != null ? bitmap.getConfig() : Bitmap.Config.ARGB_8888;
    }

    @VisibleForTesting
    public static void initializeMatrixForRotation(int i11, Matrix matrix) {
        switch (i11) {
            case 2:
                matrix.setScale(-1.0f, 1.0f);
                return;
            case 3:
                matrix.setRotate(180.0f);
                return;
            case 4:
                matrix.setRotate(180.0f);
                matrix.postScale(-1.0f, 1.0f);
                return;
            case 5:
                matrix.setRotate(90.0f);
                matrix.postScale(-1.0f, 1.0f);
                return;
            case 6:
                matrix.setRotate(90.0f);
                return;
            case 7:
                matrix.setRotate(-90.0f);
                matrix.postScale(-1.0f, 1.0f);
                return;
            case 8:
                matrix.setRotate(-90.0f);
                return;
            default:
                return;
        }
    }

    public static boolean isExifOrientationRequired(int i11) {
        switch (i11) {
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
                return true;
            default:
                return false;
        }
    }

    public static Bitmap rotateImage(@NonNull Bitmap bitmap, int i11) {
        if (i11 == 0) {
            return bitmap;
        }
        try {
            Matrix matrix = new Matrix();
            matrix.setRotate((float) i11);
            return Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);
        } catch (Exception e11) {
            if (!Log.isLoggable(TAG, 6)) {
                return bitmap;
            }
            Log.e(TAG, "Exception when trying to orient image", e11);
            return bitmap;
        }
    }

    public static Bitmap rotateImageExif(@NonNull BitmapPool bitmapPool, @NonNull Bitmap bitmap, int i11) {
        if (!isExifOrientationRequired(i11)) {
            return bitmap;
        }
        Matrix matrix = new Matrix();
        initializeMatrixForRotation(i11, matrix);
        RectF rectF = new RectF(0.0f, 0.0f, (float) bitmap.getWidth(), (float) bitmap.getHeight());
        matrix.mapRect(rectF);
        Bitmap bitmap2 = bitmapPool.get(Math.round(rectF.width()), Math.round(rectF.height()), getNonNullConfig(bitmap));
        matrix.postTranslate(-rectF.left, -rectF.top);
        bitmap2.setHasAlpha(bitmap.hasAlpha());
        applyMatrix(bitmap, bitmap2, matrix);
        return bitmap2;
    }

    @Deprecated
    public static Bitmap roundedCorners(@NonNull BitmapPool bitmapPool, @NonNull Bitmap bitmap, int i11, int i12, int i13) {
        return roundedCorners(bitmapPool, bitmap, i13);
    }

    public static void setAlpha(Bitmap bitmap, Bitmap bitmap2) {
        bitmap2.setHasAlpha(bitmap.hasAlpha());
    }

    public static Bitmap roundedCorners(@NonNull BitmapPool bitmapPool, @NonNull Bitmap bitmap, final int i11) {
        Preconditions.checkArgument(i11 > 0, "roundingRadius must be greater than 0.");
        return roundedCorners(bitmapPool, bitmap, (DrawRoundedCornerFn) new DrawRoundedCornerFn() {
            public void drawRoundedCorners(Canvas canvas, Paint paint, RectF rectF) {
                int i11 = i11;
                canvas.drawRoundRect(rectF, (float) i11, (float) i11, paint);
            }
        });
    }

    public static Bitmap roundedCorners(@NonNull BitmapPool bitmapPool, @NonNull Bitmap bitmap, final float f11, final float f12, final float f13, final float f14) {
        return roundedCorners(bitmapPool, bitmap, (DrawRoundedCornerFn) new DrawRoundedCornerFn() {
            public void drawRoundedCorners(Canvas canvas, Paint paint, RectF rectF) {
                Path path = new Path();
                float f11 = f11;
                float f12 = f12;
                float f13 = f13;
                float f14 = f14;
                path.addRoundRect(rectF, new float[]{f11, f11, f12, f12, f13, f13, f14, f14}, Path.Direction.CW);
                canvas.drawPath(path, paint);
            }
        });
    }

    private static Bitmap roundedCorners(@NonNull BitmapPool bitmapPool, @NonNull Bitmap bitmap, DrawRoundedCornerFn drawRoundedCornerFn) {
        Bitmap.Config alphaSafeConfig = getAlphaSafeConfig(bitmap);
        Bitmap alphaSafeBitmap = getAlphaSafeBitmap(bitmapPool, bitmap);
        Bitmap bitmap2 = bitmapPool.get(alphaSafeBitmap.getWidth(), alphaSafeBitmap.getHeight(), alphaSafeConfig);
        bitmap2.setHasAlpha(true);
        Shader.TileMode tileMode = Shader.TileMode.CLAMP;
        BitmapShader bitmapShader = new BitmapShader(alphaSafeBitmap, tileMode, tileMode);
        Paint paint = new Paint();
        paint.setAntiAlias(true);
        paint.setShader(bitmapShader);
        RectF rectF = new RectF(0.0f, 0.0f, (float) bitmap2.getWidth(), (float) bitmap2.getHeight());
        Lock lock = BITMAP_DRAWABLE_LOCK;
        lock.lock();
        try {
            Canvas canvas = new Canvas(bitmap2);
            canvas.drawColor(0, PorterDuff.Mode.CLEAR);
            drawRoundedCornerFn.drawRoundedCorners(canvas, paint, rectF);
            clear(canvas);
            lock.unlock();
            if (!alphaSafeBitmap.equals(bitmap)) {
                bitmapPool.put(alphaSafeBitmap);
            }
            return bitmap2;
        } catch (Throwable th2) {
            BITMAP_DRAWABLE_LOCK.unlock();
            throw th2;
        }
    }
}
