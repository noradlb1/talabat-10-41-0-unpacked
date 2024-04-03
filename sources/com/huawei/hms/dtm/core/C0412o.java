package com.huawei.hms.dtm.core;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import com.huawei.hms.dtm.core.util.Logger;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* renamed from: com.huawei.hms.dtm.core.o  reason: case insensitive filesystem */
public final class C0412o {
    public static void a(Activity activity, View view) {
        boolean z11 = view instanceof ViewGroup;
        ViewGroup viewGroup = view;
        if (z11) {
            ViewGroup viewGroup2 = (ViewGroup) view;
            int childCount = viewGroup2.getChildCount();
            for (int i11 = 0; i11 < childCount; i11++) {
                a(activity, viewGroup2.getChildAt(i11));
            }
            viewGroup = viewGroup2;
        }
        b(activity, viewGroup);
    }

    private static void b(Activity activity, View view) {
        try {
            if (view.hasOnClickListeners()) {
                Method declaredMethod = View.class.getDeclaredMethod("getListenerInfo", new Class[0]);
                declaredMethod.setAccessible(true);
                Object invoke = declaredMethod.invoke(view, new Object[0]);
                if (invoke != null) {
                    Field declaredField = invoke.getClass().getDeclaredField("mOnClickListener");
                    declaredField.setAccessible(true);
                    Object obj = declaredField.get(invoke);
                    if (!(obj instanceof C0407n) && obj != null) {
                        declaredField.set(invoke, new C0407n(activity, (View.OnClickListener) obj));
                    }
                }
            }
        } catch (IllegalAccessException | NoSuchFieldException | NoSuchMethodException | InvocationTargetException e11) {
            Logger.warn("DTM-AutoTrace", "wrapperOnClickListener#" + e11.getMessage());
        }
    }
}
