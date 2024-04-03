package com.squareup.picasso;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.SystemClock;
import android.widget.ImageView;
import com.squareup.picasso.Picasso;

final class PicassoDrawable extends BitmapDrawable {
    private static final Paint DEBUG_PAINT = new Paint();
    private static final float FADE_DURATION = 200.0f;

    /* renamed from: a  reason: collision with root package name */
    public Drawable f53448a;

    /* renamed from: b  reason: collision with root package name */
    public long f53449b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f53450c;

    /* renamed from: d  reason: collision with root package name */
    public int f53451d = 255;
    private final boolean debugging;
    private final float density;
    private final Picasso.LoadedFrom loadedFrom;

    public PicassoDrawable(Context context, Bitmap bitmap, Drawable drawable, Picasso.LoadedFrom loadedFrom2, boolean z11, boolean z12) {
        super(context.getResources(), bitmap);
        boolean z13;
        this.debugging = z12;
        this.density = context.getResources().getDisplayMetrics().density;
        this.loadedFrom = loadedFrom2;
        if (loadedFrom2 == Picasso.LoadedFrom.MEMORY || z11) {
            z13 = false;
        } else {
            z13 = true;
        }
        if (z13) {
            this.f53448a = drawable;
            this.f53450c = true;
            this.f53449b = SystemClock.uptimeMillis();
        }
    }

    public static void a(ImageView imageView, Context context, Bitmap bitmap, Picasso.LoadedFrom loadedFrom2, boolean z11, boolean z12) {
        Drawable drawable = imageView.getDrawable();
        if (drawable instanceof Animatable) {
            ((Animatable) drawable).stop();
        }
        imageView.setImageDrawable(new PicassoDrawable(context, bitmap, drawable, loadedFrom2, z11, z12));
    }

    public static void b(ImageView imageView, Drawable drawable) {
        imageView.setImageDrawable(drawable);
        if (imageView.getDrawable() instanceof Animatable) {
            ((Animatable) imageView.getDrawable()).start();
        }
    }

    private void drawDebugIndicator(Canvas canvas) {
        Paint paint = DEBUG_PAINT;
        paint.setColor(-1);
        canvas.drawPath(getTrianglePath(0, 0, (int) (this.density * 16.0f)), paint);
        paint.setColor(this.loadedFrom.f53447b);
        canvas.drawPath(getTrianglePath(0, 0, (int) (this.density * 15.0f)), paint);
    }

    private static Path getTrianglePath(int i11, int i12, int i13) {
        Path path = new Path();
        float f11 = (float) i11;
        float f12 = (float) i12;
        path.moveTo(f11, f12);
        path.lineTo((float) (i11 + i13), f12);
        path.lineTo(f11, (float) (i12 + i13));
        return path;
    }

    public void draw(Canvas canvas) {
        if (!this.f53450c) {
            super.draw(canvas);
        } else {
            float uptimeMillis = ((float) (SystemClock.uptimeMillis() - this.f53449b)) / 200.0f;
            if (uptimeMillis >= 1.0f) {
                this.f53450c = false;
                this.f53448a = null;
                super.draw(canvas);
            } else {
                Drawable drawable = this.f53448a;
                if (drawable != null) {
                    drawable.draw(canvas);
                }
                super.setAlpha((int) (((float) this.f53451d) * uptimeMillis));
                super.draw(canvas);
                super.setAlpha(this.f53451d);
            }
        }
        if (this.debugging) {
            drawDebugIndicator(canvas);
        }
    }

    public void onBoundsChange(Rect rect) {
        Drawable drawable = this.f53448a;
        if (drawable != null) {
            drawable.setBounds(rect);
        }
        super.onBoundsChange(rect);
    }

    public void setAlpha(int i11) {
        this.f53451d = i11;
        Drawable drawable = this.f53448a;
        if (drawable != null) {
            drawable.setAlpha(i11);
        }
        super.setAlpha(i11);
    }

    public void setColorFilter(ColorFilter colorFilter) {
        Drawable drawable = this.f53448a;
        if (drawable != null) {
            drawable.setColorFilter(colorFilter);
        }
        super.setColorFilter(colorFilter);
    }
}
