package androidx.transition;

import android.annotation.SuppressLint;
import android.os.Build;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

class ViewGroupUtils {
    private static Method sGetChildDrawingOrderMethod = null;
    private static boolean sGetChildDrawingOrderMethodFetched = false;
    private static boolean sTryHiddenSuppressLayout = true;

    private ViewGroupUtils() {
    }

    public static int a(@NonNull ViewGroup viewGroup, int i11) {
        if (Build.VERSION.SDK_INT >= 29) {
            return viewGroup.getChildDrawingOrder(i11);
        }
        if (!sGetChildDrawingOrderMethodFetched) {
            Class<ViewGroup> cls = ViewGroup.class;
            try {
                Class cls2 = Integer.TYPE;
                Method declaredMethod = cls.getDeclaredMethod("getChildDrawingOrder", new Class[]{cls2, cls2});
                sGetChildDrawingOrderMethod = declaredMethod;
                declaredMethod.setAccessible(true);
            } catch (NoSuchMethodException unused) {
            }
            sGetChildDrawingOrderMethodFetched = true;
        }
        Method method = sGetChildDrawingOrderMethod;
        if (method != null) {
            try {
                return ((Integer) method.invoke(viewGroup, new Object[]{Integer.valueOf(viewGroup.getChildCount()), Integer.valueOf(i11)})).intValue();
            } catch (IllegalAccessException | InvocationTargetException unused2) {
            }
        }
        return i11;
    }

    public static ViewGroupOverlayImpl b(@NonNull ViewGroup viewGroup) {
        return new ViewGroupOverlayApi18(viewGroup);
    }

    public static void c(@NonNull ViewGroup viewGroup, boolean z11) {
        if (Build.VERSION.SDK_INT >= 29) {
            viewGroup.suppressLayout(z11);
        } else {
            hiddenSuppressLayout(viewGroup, z11);
        }
    }

    @RequiresApi(18)
    @SuppressLint({"NewApi"})
    private static void hiddenSuppressLayout(@NonNull ViewGroup viewGroup, boolean z11) {
        if (sTryHiddenSuppressLayout) {
            try {
                viewGroup.suppressLayout(z11);
            } catch (NoSuchMethodError unused) {
                sTryHiddenSuppressLayout = false;
            }
        }
    }
}
