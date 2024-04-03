package com.huawei.hms.locationSdk;

import android.app.Activity;
import android.content.Context;
import com.huawei.hms.utils.Checker;
import java.util.Locale;

public class b {
    public static c a(Activity activity, w wVar) {
        Checker.assertNonNull(activity);
        return new e(activity, wVar);
    }

    public static c a(Context context, w wVar) {
        Checker.assertNonNull(context);
        return new e(context, wVar);
    }

    public static l a(Activity activity, Locale locale, w wVar) {
        Checker.assertNonNull(activity);
        return new n(activity, locale, wVar);
    }

    public static l a(Context context, Locale locale, w wVar) {
        Checker.assertNonNull(context);
        return new n(context, locale, wVar);
    }

    public static f b(Activity activity, w wVar) {
        Checker.assertNonNull(activity);
        return new h(activity, wVar);
    }

    public static f b(Context context, w wVar) {
        Checker.assertNonNull(context);
        return new h(context, wVar);
    }

    public static i c(Activity activity, w wVar) {
        Checker.assertNonNull(activity);
        return new k(activity, wVar);
    }

    public static i c(Context context, w wVar) {
        Checker.assertNonNull(context);
        return new k(context, wVar);
    }

    public static o d(Activity activity, w wVar) {
        Checker.assertNonNull(activity);
        return new q(activity, wVar);
    }

    public static o d(Context context, w wVar) {
        Checker.assertNonNull(context);
        return new q(context, wVar);
    }
}
