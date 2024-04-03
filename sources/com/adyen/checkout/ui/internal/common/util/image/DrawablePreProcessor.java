package com.adyen.checkout.ui.internal.common.util.image;

import android.annotation.SuppressLint;
import android.app.Application;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import androidx.annotation.ColorInt;
import androidx.annotation.NonNull;
import androidx.annotation.Px;
import androidx.core.content.ContextCompat;
import com.adyen.checkout.ui.R;
import java.util.concurrent.Callable;

public final class DrawablePreProcessor {
    private static final float CORNER_RADIUS_FACTOR = 0.125f;
    @SuppressLint({"StaticFieldLeak"})
    private static DrawablePreProcessor sInstance;
    private final Application mApplication;

    private DrawablePreProcessor(@NonNull Application application) {
        this.mApplication = application;
    }

    @NonNull
    private Bitmap convertToBitmap(@NonNull Drawable drawable) {
        if (drawable instanceof BitmapDrawable) {
            return ((BitmapDrawable) drawable).getBitmap();
        }
        Bitmap createBitmap = Bitmap.createBitmap(drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight(), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(createBitmap);
        drawable.setBounds(0, 0, canvas.getWidth(), canvas.getHeight());
        drawable.draw(canvas);
        createBitmap.setDensity(Resources.getSystem().getDisplayMetrics().densityDpi);
        return createBitmap;
    }

    @NonNull
    public static synchronized DrawablePreProcessor getInstance(@NonNull Application application) {
        DrawablePreProcessor drawablePreProcessor;
        synchronized (DrawablePreProcessor.class) {
            if (sInstance == null) {
                sInstance = new DrawablePreProcessor(application);
            }
            drawablePreProcessor = sInstance;
        }
        return drawablePreProcessor;
    }

    @NonNull
    private Drawable makeRoundCornersAndAddBorder(@NonNull Context context, @NonNull Bitmap bitmap, @Px int i11, @ColorInt int i12) {
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        Bitmap createBitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
        createBitmap.setDensity(Resources.getSystem().getDisplayMetrics().densityDpi);
        Canvas canvas = new Canvas(createBitmap);
        Paint paint = new Paint();
        paint.setAntiAlias(true);
        Rect rect = new Rect(0, 0, width, height);
        RectF rectF = new RectF(rect);
        float f11 = (float) i11;
        canvas.drawRoundRect(rectF, f11, f11, paint);
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_ATOP));
        canvas.drawBitmap(bitmap, rect, rect, paint);
        Paint paint2 = new Paint();
        paint2.setStyle(Paint.Style.STROKE);
        paint2.setColor(i12);
        paint2.setAntiAlias(true);
        paint2.setStrokeWidth(1.0f);
        canvas.drawRoundRect(rectF, f11, f11, paint2);
        BitmapDrawable bitmapDrawable = new BitmapDrawable(context.getResources(), createBitmap);
        bitmapDrawable.setAntiAlias(true);
        return bitmapDrawable;
    }

    /* access modifiers changed from: private */
    @NonNull
    public Drawable preProcess(@NonNull Drawable drawable) {
        Bitmap convertToBitmap = convertToBitmap(drawable);
        int color = ContextCompat.getColor(this.mApplication, R.color.drawable_border);
        return makeRoundCornersAndAddBorder(this.mApplication, convertToBitmap, (int) (((float) convertToBitmap.getHeight()) * CORNER_RADIUS_FACTOR), color);
    }

    @NonNull
    public static Callable<Drawable> wrapCallable(@NonNull Application application, @NonNull final Callable<Drawable> callable) {
        final DrawablePreProcessor instance = getInstance(application);
        return new Callable<Drawable>() {
            public Drawable call() throws Exception {
                Drawable drawable = (Drawable) callable.call();
                return drawable != null ? instance.preProcess(drawable) : drawable;
            }
        };
    }
}
