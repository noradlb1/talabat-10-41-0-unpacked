package com.instabug.library.annotation.utility;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.renderscript.Allocation;
import android.renderscript.Element;
import android.renderscript.RenderScript;
import android.renderscript.ScriptIntrinsicBlur;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.ViewCompat;

public abstract class b {
    @Nullable
    public static Bitmap a(@NonNull Bitmap bitmap, int i11, Context context) {
        Bitmap copy = bitmap.copy(bitmap.getConfig(), true);
        RenderScript create = RenderScript.create(context);
        Allocation createFromBitmap = Allocation.createFromBitmap(create, bitmap, Allocation.MipmapControl.MIPMAP_NONE, 1);
        Allocation createTyped = Allocation.createTyped(create, createFromBitmap.getType());
        ScriptIntrinsicBlur create2 = ScriptIntrinsicBlur.create(create, Element.U8_4(create));
        create2.setRadius((float) i11);
        create2.setInput(createFromBitmap);
        create2.forEach(createTyped);
        createTyped.copyTo(copy);
        return copy;
    }

    public static Bitmap a(Bitmap bitmap, int i11) {
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        int i12 = (width * i11) / 100;
        int i13 = (i11 * height) / 100;
        return Bitmap.createBitmap(Bitmap.createScaledBitmap(bitmap, i12, i13, true), Math.abs(i12 - width) / 2, Math.abs(i13 - height) / 2, width, height);
    }

    @SuppressLint({"ERADICATE_PARAMETER_NOT_NULLABLE"})
    public static Bitmap a(Bitmap bitmap) {
        Rect rect = new Rect(0, 0, bitmap.getWidth(), bitmap.getHeight());
        rect.inset(-6, -6);
        Bitmap createBitmap = Bitmap.createBitmap(rect.width(), rect.height(), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(createBitmap);
        Paint paint = new Paint(1);
        canvas.drawARGB(0, 0, 0, 0);
        paint.setColor(-12434878);
        float centerX = (float) rect.centerX();
        float centerY = (float) rect.centerY();
        float min = Math.min(centerX, centerY);
        canvas.drawCircle(centerX, centerY, min, paint);
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
        canvas.drawBitmap(bitmap, (Rect) null, rect, paint);
        Paint paint2 = new Paint(1);
        paint2.setColor(ViewCompat.MEASURED_STATE_MASK);
        paint2.setStyle(Paint.Style.STROKE);
        paint2.setStrokeWidth(2.0f);
        canvas.drawCircle(centerX, centerY, min - 2.0f, paint2);
        return createBitmap;
    }

    public static Bitmap a(Drawable drawable) {
        Bitmap bitmap;
        if (drawable instanceof BitmapDrawable) {
            BitmapDrawable bitmapDrawable = (BitmapDrawable) drawable;
            if (bitmapDrawable.getBitmap() != null) {
                return bitmapDrawable.getBitmap();
            }
        }
        if (drawable.getIntrinsicWidth() <= 0 || drawable.getIntrinsicHeight() <= 0) {
            bitmap = Bitmap.createBitmap(1, 1, Bitmap.Config.ARGB_8888);
        } else {
            bitmap = Bitmap.createBitmap(drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight(), Bitmap.Config.ARGB_8888);
        }
        Canvas canvas = new Canvas(bitmap);
        drawable.setBounds(0, 0, canvas.getWidth(), canvas.getHeight());
        drawable.draw(canvas);
        return bitmap;
    }
}
