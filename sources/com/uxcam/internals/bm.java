package com.uxcam.internals;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Point;
import android.os.Build;
import android.provider.Settings;
import android.util.DisplayMetrics;
import android.util.Pair;
import android.view.WindowManager;
import java.lang.reflect.Field;
import java.math.BigInteger;
import java.security.SecureRandom;

public class bm {

    /* renamed from: a  reason: collision with root package name */
    public static String f13079a;

    public static String a() {
        int i11;
        StringBuilder sb2 = new StringBuilder();
        for (Field field : Build.VERSION_CODES.class.getFields()) {
            String name2 = field.getName();
            try {
                i11 = field.getInt(new Object());
            } catch (IllegalAccessException | IllegalArgumentException | NullPointerException unused) {
                gu.f13504c.getClass();
                i11 = -1;
            }
            if (i11 == Build.VERSION.SDK_INT) {
                sb2.append(" ");
                sb2.append(name2);
            }
        }
        return sb2.toString();
    }

    public static Pair<Double, Double> b(Context context) {
        Point c11 = c(context);
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        return new Pair<>(Double.valueOf((double) (((float) c11.x) / displayMetrics.xdpi)), Double.valueOf((double) (((float) c11.y) / displayMetrics.ydpi)));
    }

    public static Point c(Context context) {
        WindowManager windowManager = (WindowManager) context.getSystemService("window");
        Point point = new Point();
        if (windowManager != null) {
            windowManager.getDefaultDisplay().getRealSize(point);
        }
        return point;
    }

    public static String d(Context context) {
        return f(context) ? "Tablet" : "Phone";
    }

    public static int e(Context context) {
        Point c11 = c(context);
        int i11 = c11.x;
        int i12 = c11.y;
        double sqrt = Math.sqrt((double) ((i12 * i12) + (i11 * i11)));
        Pair<Double, Double> b11 = b(context);
        return (int) (sqrt / Math.sqrt((((Double) b11.second).doubleValue() * ((Double) b11.second).doubleValue()) + (((Double) b11.first).doubleValue() * ((Double) b11.first).doubleValue())));
    }

    public static boolean f(Context context) {
        boolean z11;
        boolean z12;
        if ((context.getResources().getConfiguration().screenLayout & 15) == 4) {
            z11 = true;
        } else {
            z11 = false;
        }
        if ((context.getResources().getConfiguration().screenLayout & 15) == 3) {
            z12 = true;
        } else {
            z12 = false;
        }
        if (z11 || z12) {
            return true;
        }
        return false;
    }

    @SuppressLint({"HardwareIds"})
    public static String a(Context context) {
        String string = Settings.Secure.getString(context.getContentResolver(), "android_id");
        f13079a = string;
        if (string.isEmpty()) {
            f13079a = new BigInteger(64, new SecureRandom()).toString(16);
        }
        return f13079a;
    }
}
