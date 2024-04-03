package com.google.android.material.color;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.res.TypedArray;
import android.os.Build;
import android.os.Bundle;
import android.view.ContextThemeWrapper;
import androidx.annotation.ChecksSdkIntAtLeast;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.StyleRes;
import com.adjust.sdk.Constants;
import com.google.android.material.R;
import java.lang.reflect.Method;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class DynamicColors {
    private static final Precondition ALWAYS_ALLOW = new Precondition() {
        public boolean shouldApplyDynamicColors(@NonNull Activity activity, int i11) {
            return true;
        }
    };
    private static final DeviceSupportCondition DEFAULT_DEVICE_SUPPORT_CONDITION;
    private static final Map<String, DeviceSupportCondition> DYNAMIC_COLOR_SUPPORTED_BRANDS;
    private static final Map<String, DeviceSupportCondition> DYNAMIC_COLOR_SUPPORTED_MANUFACTURERS;
    private static final int[] DYNAMIC_COLOR_THEME_OVERLAY_ATTRIBUTE = {R.attr.dynamicColorThemeOverlay};
    @SuppressLint({"PrivateApi"})
    private static final DeviceSupportCondition SAMSUNG_DEVICE_SUPPORT_CONDITION;
    private static final int USE_DEFAULT_THEME_OVERLAY = 0;

    public interface DeviceSupportCondition {
        boolean isSupported();
    }

    public static class DynamicColorsActivityLifecycleCallbacks implements Application.ActivityLifecycleCallbacks {
        private final int dynamicColorThemeOverlay;
        private final Precondition precondition;

        public DynamicColorsActivityLifecycleCallbacks(@StyleRes int i11, @NonNull Precondition precondition2) {
            this.dynamicColorThemeOverlay = i11;
            this.precondition = precondition2;
        }

        public void onActivityCreated(@NonNull Activity activity, @Nullable Bundle bundle) {
        }

        public void onActivityDestroyed(@NonNull Activity activity) {
        }

        public void onActivityPaused(@NonNull Activity activity) {
        }

        public void onActivityPreCreated(@NonNull Activity activity, @Nullable Bundle bundle) {
            DynamicColors.applyIfAvailable(activity, this.dynamicColorThemeOverlay, this.precondition);
        }

        public void onActivityResumed(@NonNull Activity activity) {
        }

        public void onActivitySaveInstanceState(@NonNull Activity activity, @NonNull Bundle bundle) {
        }

        public void onActivityStarted(@NonNull Activity activity) {
        }

        public void onActivityStopped(@NonNull Activity activity) {
        }
    }

    public interface Precondition {
        boolean shouldApplyDynamicColors(@NonNull Activity activity, @StyleRes int i11);
    }

    static {
        AnonymousClass1 r02 = new DeviceSupportCondition() {
            public boolean isSupported() {
                return true;
            }
        };
        DEFAULT_DEVICE_SUPPORT_CONDITION = r02;
        AnonymousClass2 r12 = new DeviceSupportCondition() {
            private Long version;

            public boolean isSupported() {
                if (this.version == null) {
                    try {
                        Method declaredMethod = Build.class.getDeclaredMethod("getLong", new Class[]{String.class});
                        declaredMethod.setAccessible(true);
                        this.version = Long.valueOf(((Long) declaredMethod.invoke((Object) null, new Object[]{"ro.build.version.oneui"})).longValue());
                    } catch (Exception unused) {
                        this.version = -1L;
                    }
                }
                if (this.version.longValue() >= 40100) {
                    return true;
                }
                return false;
            }
        };
        SAMSUNG_DEVICE_SUPPORT_CONDITION = r12;
        HashMap hashMap = new HashMap();
        hashMap.put("oppo", r02);
        hashMap.put("realme", r02);
        hashMap.put("oneplus", r02);
        hashMap.put(Constants.REFERRER_API_VIVO, r02);
        hashMap.put(Constants.REFERRER_API_XIAOMI, r02);
        hashMap.put("motorola", r02);
        hashMap.put("itel", r02);
        hashMap.put("tecno mobile limited", r02);
        hashMap.put("infinix mobility limited", r02);
        hashMap.put("hmd global", r02);
        hashMap.put("sharp", r02);
        hashMap.put("sony", r02);
        hashMap.put("tcl", r02);
        hashMap.put("lenovo", r02);
        hashMap.put("lge", r02);
        hashMap.put(Constants.REFERRER_API_GOOGLE, r02);
        hashMap.put("robolectric", r02);
        hashMap.put(Constants.REFERRER_API_SAMSUNG, r12);
        DYNAMIC_COLOR_SUPPORTED_MANUFACTURERS = Collections.unmodifiableMap(hashMap);
        HashMap hashMap2 = new HashMap();
        hashMap2.put("asus", r02);
        hashMap2.put("jio", r02);
        DYNAMIC_COLOR_SUPPORTED_BRANDS = Collections.unmodifiableMap(hashMap2);
    }

    private DynamicColors() {
    }

    public static void applyIfAvailable(@NonNull Activity activity) {
        applyIfAvailable(activity, 0);
    }

    public static void applyToActivitiesIfAvailable(@NonNull Application application) {
        applyToActivitiesIfAvailable(application, 0);
    }

    private static int getDefaultThemeOverlay(@NonNull Context context) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(DYNAMIC_COLOR_THEME_OVERLAY_ATTRIBUTE);
        int resourceId = obtainStyledAttributes.getResourceId(0, 0);
        obtainStyledAttributes.recycle();
        return resourceId;
    }

    @SuppressLint({"DefaultLocale"})
    @ChecksSdkIntAtLeast(api = 31)
    public static boolean isDynamicColorAvailable() {
        if (Build.VERSION.SDK_INT < 31) {
            return false;
        }
        DeviceSupportCondition deviceSupportCondition = DYNAMIC_COLOR_SUPPORTED_MANUFACTURERS.get(Build.MANUFACTURER.toLowerCase());
        if (deviceSupportCondition == null) {
            deviceSupportCondition = DYNAMIC_COLOR_SUPPORTED_BRANDS.get(Build.BRAND.toLowerCase());
        }
        if (deviceSupportCondition == null || !deviceSupportCondition.isSupported()) {
            return false;
        }
        return true;
    }

    @NonNull
    public static Context wrapContextIfAvailable(@NonNull Context context) {
        return wrapContextIfAvailable(context, 0);
    }

    public static void applyIfAvailable(@NonNull Activity activity, @StyleRes int i11) {
        applyIfAvailable(activity, i11, ALWAYS_ALLOW);
    }

    public static void applyToActivitiesIfAvailable(@NonNull Application application, @StyleRes int i11) {
        applyToActivitiesIfAvailable(application, i11, ALWAYS_ALLOW);
    }

    @NonNull
    public static Context wrapContextIfAvailable(@NonNull Context context, @StyleRes int i11) {
        if (!isDynamicColorAvailable()) {
            return context;
        }
        if (i11 == 0) {
            i11 = getDefaultThemeOverlay(context);
        }
        return i11 == 0 ? context : new ContextThemeWrapper(context, i11);
    }

    public static void applyIfAvailable(@NonNull Activity activity, @NonNull Precondition precondition) {
        applyIfAvailable(activity, 0, precondition);
    }

    public static void applyToActivitiesIfAvailable(@NonNull Application application, @NonNull Precondition precondition) {
        applyToActivitiesIfAvailable(application, 0, precondition);
    }

    /* access modifiers changed from: private */
    public static void applyIfAvailable(@NonNull Activity activity, @StyleRes int i11, @NonNull Precondition precondition) {
        if (isDynamicColorAvailable()) {
            if (i11 == 0) {
                i11 = getDefaultThemeOverlay(activity);
            }
            if (i11 != 0 && precondition.shouldApplyDynamicColors(activity, i11)) {
                activity.setTheme(i11);
            }
        }
    }

    public static void applyToActivitiesIfAvailable(@NonNull Application application, @StyleRes int i11, @NonNull Precondition precondition) {
        application.registerActivityLifecycleCallbacks(new DynamicColorsActivityLifecycleCallbacks(i11, precondition));
    }
}
