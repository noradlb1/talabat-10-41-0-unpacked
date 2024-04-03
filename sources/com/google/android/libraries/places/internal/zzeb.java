package com.google.android.libraries.places.internal;

import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import androidx.annotation.ColorInt;

public final class zzeb {
    @ColorInt
    public static int zza(@ColorInt int i11, @ColorInt int i12, @ColorInt int i13) {
        return zzc(i11, i12, i13) ? i13 : i12;
    }

    public static void zzb(ImageView imageView, @ColorInt int i11) {
        Drawable drawable = imageView.getDrawable();
        int rgb = Color.rgb(Color.red(i11), Color.green(i11), Color.blue(i11));
        Drawable mutate = drawable.mutate();
        mutate.setColorFilter(rgb, PorterDuff.Mode.SRC_ATOP);
        mutate.setAlpha(Color.alpha(i11));
    }

    public static boolean zzc(@ColorInt int i11, @ColorInt int i12, @ColorInt int i13) {
        double zzf = zzf(i11);
        double zze = zze(zzf(i12), zzf);
        if (zze <= 3.0d && zze <= zze(zzf(i13), zzf)) {
            return true;
        }
        return false;
    }

    private static double zzd(double d11) {
        return d11 <= 0.03928d ? d11 / 12.92d : Math.pow((d11 + 0.055d) / 1.055d, 2.4d);
    }

    private static double zze(double d11, double d12) {
        return ((double) Math.round(((Math.max(d11, d12) + 0.05d) / (Math.min(d11, d12) + 0.05d)) * 100.0d)) / 100.0d;
    }

    private static double zzf(@ColorInt int i11) {
        return (zzd(((double) Color.red(i11)) / 255.0d) * 0.2126d) + (zzd(((double) Color.green(i11)) / 255.0d) * 0.7152d) + (zzd(((double) Color.blue(i11)) / 255.0d) * 0.0722d);
    }
}
