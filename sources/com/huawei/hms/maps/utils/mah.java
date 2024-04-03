package com.huawei.hms.maps.utils;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;

public class mah extends maa {

    /* renamed from: a  reason: collision with root package name */
    private int f49635a;

    /* renamed from: b  reason: collision with root package name */
    private Bitmap f49636b;

    public mah(int i11) {
        this.f49635a = i11;
    }

    public static Bitmap a(Context context, Drawable drawable) {
        if (drawable instanceof BitmapDrawable) {
            return ((BitmapDrawable) drawable).getBitmap();
        }
        if (drawable.getIntrinsicWidth() <= 0 || drawable.getIntrinsicHeight() <= 0) {
            return mad.f49625a.b(context);
        }
        Bitmap createBitmap = Bitmap.createBitmap(drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight(), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(createBitmap);
        drawable.setBounds(0, 0, canvas.getWidth(), canvas.getHeight());
        drawable.draw(canvas);
        return createBitmap;
    }

    public Bitmap a(Context context) {
        Bitmap a11 = a(context, context.getResources().getDrawable(this.f49635a));
        this.f49636b = a11;
        return a11;
    }
}
