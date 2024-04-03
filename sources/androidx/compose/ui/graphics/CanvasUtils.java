package androidx.compose.ui.graphics;

import android.annotation.SuppressLint;
import android.graphics.Canvas;
import android.os.Build;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u0006H\u0007R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Landroidx/compose/ui/graphics/CanvasUtils;", "", "()V", "inorderBarrierMethod", "Ljava/lang/reflect/Method;", "orderMethodsFetched", "", "reorderBarrierMethod", "enableZ", "", "canvas", "Landroid/graphics/Canvas;", "enable", "ui-graphics_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class CanvasUtils {
    @NotNull
    public static final CanvasUtils INSTANCE = new CanvasUtils();
    @Nullable
    private static Method inorderBarrierMethod;
    private static boolean orderMethodsFetched;
    @Nullable
    private static Method reorderBarrierMethod;

    private CanvasUtils() {
    }

    @SuppressLint({"SoonBlockedPrivateApi"})
    public final void enableZ(@NotNull Canvas canvas, boolean z11) {
        Method method;
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        int i11 = Build.VERSION.SDK_INT;
        if (i11 >= 29) {
            CanvasZHelper.INSTANCE.enableZ(canvas, z11);
            return;
        }
        if (!orderMethodsFetched) {
            Class<Canvas> cls = Canvas.class;
            if (i11 == 28) {
                Class<Class> cls2 = Class.class;
                try {
                    Method declaredMethod = cls2.getDeclaredMethod("getDeclaredMethod", new Class[]{String.class, new Class[0].getClass()});
                    reorderBarrierMethod = (Method) declaredMethod.invoke(cls, new Object[]{"insertReorderBarrier", new Class[0]});
                    inorderBarrierMethod = (Method) declaredMethod.invoke(cls, new Object[]{"insertInorderBarrier", new Class[0]});
                } catch (IllegalAccessException | NoSuchMethodException | InvocationTargetException unused) {
                }
            } else {
                reorderBarrierMethod = cls.getDeclaredMethod("insertReorderBarrier", new Class[0]);
                inorderBarrierMethod = cls.getDeclaredMethod("insertInorderBarrier", new Class[0]);
            }
            Method method2 = reorderBarrierMethod;
            if (method2 != null) {
                method2.setAccessible(true);
            }
            Method method3 = inorderBarrierMethod;
            if (method3 != null) {
                method3.setAccessible(true);
            }
            orderMethodsFetched = true;
        }
        if (z11) {
            try {
                Method method4 = reorderBarrierMethod;
                if (method4 != null) {
                    Intrinsics.checkNotNull(method4);
                    method4.invoke(canvas, new Object[0]);
                }
            } catch (IllegalAccessException | InvocationTargetException unused2) {
                return;
            }
        }
        if (!z11 && (method = inorderBarrierMethod) != null) {
            Intrinsics.checkNotNull(method);
            method.invoke(canvas, new Object[0]);
        }
    }
}
