package com.huawei.secure.android.common.util;

import android.app.Activity;
import android.view.Window;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.security.AccessController;
import java.security.PrivilegedAction;

public class ScreenUtil {

    /* renamed from: a  reason: collision with root package name */
    private static final String f34001a = "ScreenUtil";

    /* renamed from: b  reason: collision with root package name */
    private static final int f34002b = 524288;

    public static class a implements PrivilegedAction {

        /* renamed from: b  reason: collision with root package name */
        public Method f34003b;

        public a(Method method) {
            this.f34003b = method;
        }

        public Object run() {
            Method method = this.f34003b;
            if (method == null) {
                return null;
            }
            method.setAccessible(true);
            return null;
        }
    }

    private static void a(Activity activity, int i11) {
        if (activity == null || activity.isFinishing()) {
            LogsUtil.e("", "activity is null");
        } else {
            activity.getWindow().addFlags(i11);
        }
    }

    private static void b(Activity activity, int i11) {
        if (activity == null || activity.isFinishing()) {
            LogsUtil.e("", "activity is null");
        } else {
            activity.getWindow().clearFlags(i11);
        }
    }

    public static void disableScreenshots(Activity activity) {
        a(activity, 8192);
    }

    public static void enableScreenshots(Activity activity) {
        b(activity, 8192);
    }

    public static void hideOverlayWindows(Activity activity) {
        if (activity != null && !activity.isFinishing()) {
            try {
                Window window = activity.getWindow();
                Class<?> cls = Class.forName("android.view.Window");
                Method declaredMethod = cls.getDeclaredMethod("addPrivateFlags", new Class[]{Integer.TYPE});
                AccessController.doPrivileged(new a(declaredMethod));
                declaredMethod.invoke(window, new Object[]{524288});
            } catch (ClassNotFoundException unused) {
                LogsUtil.e(f34001a, "hideOverlayWindows ClassNotFoundException");
            } catch (NoSuchMethodException unused2) {
                LogsUtil.e(f34001a, "hideOverlayWindows NoSuchMethodException");
            } catch (InvocationTargetException unused3) {
                LogsUtil.e(f34001a, "hideOverlayWindows InvocationTargetException");
            } catch (IllegalAccessException unused4) {
                LogsUtil.e(f34001a, "hideOverlayWindows IllegalAccessException");
            }
        }
    }
}
