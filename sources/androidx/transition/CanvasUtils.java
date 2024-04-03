package androidx.transition;

import android.annotation.SuppressLint;
import android.graphics.Canvas;
import android.os.Build;
import androidx.annotation.NonNull;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

class CanvasUtils {
    private static Method sInorderBarrierMethod;
    private static boolean sOrderMethodsFetched;
    private static Method sReorderBarrierMethod;

    private CanvasUtils() {
    }

    @SuppressLint({"SoonBlockedPrivateApi"})
    public static void a(@NonNull Canvas canvas, boolean z11) {
        Method method;
        Class<Canvas> cls = Canvas.class;
        int i11 = Build.VERSION.SDK_INT;
        if (i11 >= 29) {
            if (z11) {
                canvas.enableZ();
            } else {
                canvas.disableZ();
            }
        } else if (i11 != 28) {
            if (!sOrderMethodsFetched) {
                try {
                    Method declaredMethod = cls.getDeclaredMethod("insertReorderBarrier", new Class[0]);
                    sReorderBarrierMethod = declaredMethod;
                    declaredMethod.setAccessible(true);
                    Method declaredMethod2 = cls.getDeclaredMethod("insertInorderBarrier", new Class[0]);
                    sInorderBarrierMethod = declaredMethod2;
                    declaredMethod2.setAccessible(true);
                } catch (NoSuchMethodException unused) {
                }
                sOrderMethodsFetched = true;
            }
            if (z11) {
                try {
                    Method method2 = sReorderBarrierMethod;
                    if (method2 != null) {
                        method2.invoke(canvas, new Object[0]);
                    }
                } catch (IllegalAccessException unused2) {
                    return;
                } catch (InvocationTargetException e11) {
                    throw new RuntimeException(e11.getCause());
                }
            }
            if (!z11 && (method = sInorderBarrierMethod) != null) {
                method.invoke(canvas, new Object[0]);
            }
        } else {
            throw new IllegalStateException("This method doesn't work on Pie!");
        }
    }
}
