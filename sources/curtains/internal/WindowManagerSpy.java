package curtains.internal;

import android.annotation.SuppressLint;
import android.util.Log;
import android.view.View;
import java.lang.reflect.Field;
import java.util.ArrayList;
import kotlin.Lazy;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0002\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J<\u0010\u0012\u001a\u00020\u001322\u0010\u0014\u001a.\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u00170\u0016j\b\u0012\u0004\u0012\u00020\u0017`\u0018\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u00170\u0016j\b\u0012\u0004\u0012\u00020\u0017`\u00180\u0015H\u0007J\u0011\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00170\u001a¢\u0006\u0002\u0010\u001bR\u001d\u0010\u0003\u001a\u0004\u0018\u00010\u00048BX\u0002¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006R!\u0010\t\u001a\b\u0012\u0002\b\u0003\u0018\u00010\n8BX\u0002¢\u0006\f\n\u0004\b\r\u0010\b\u001a\u0004\b\u000b\u0010\fR\u001d\u0010\u000e\u001a\u0004\u0018\u00010\u00018BX\u0002¢\u0006\f\n\u0004\b\u0011\u0010\b\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u001c"}, d2 = {"Lcurtains/internal/WindowManagerSpy;", "", "()V", "mViewsField", "Ljava/lang/reflect/Field;", "getMViewsField", "()Ljava/lang/reflect/Field;", "mViewsField$delegate", "Lkotlin/Lazy;", "windowManagerClass", "Ljava/lang/Class;", "getWindowManagerClass", "()Ljava/lang/Class;", "windowManagerClass$delegate", "windowManagerInstance", "getWindowManagerInstance", "()Ljava/lang/Object;", "windowManagerInstance$delegate", "swapWindowManagerGlobalMViews", "", "swap", "Lkotlin/Function1;", "Ljava/util/ArrayList;", "Landroid/view/View;", "Lkotlin/collections/ArrayList;", "windowManagerMViewsArray", "", "()[Landroid/view/View;", "curtains_release"}, k = 1, mv = {1, 4, 1})
public final class WindowManagerSpy {
    @NotNull
    public static final WindowManagerSpy INSTANCE = new WindowManagerSpy();
    private static final Lazy mViewsField$delegate;
    private static final Lazy windowManagerClass$delegate;
    private static final Lazy windowManagerInstance$delegate;

    static {
        LazyThreadSafetyMode lazyThreadSafetyMode = LazyThreadSafetyMode.NONE;
        windowManagerClass$delegate = LazyKt__LazyJVMKt.lazy(lazyThreadSafetyMode, WindowManagerSpy$windowManagerClass$2.INSTANCE);
        windowManagerInstance$delegate = LazyKt__LazyJVMKt.lazy(lazyThreadSafetyMode, WindowManagerSpy$windowManagerInstance$2.INSTANCE);
        mViewsField$delegate = LazyKt__LazyJVMKt.lazy(lazyThreadSafetyMode, WindowManagerSpy$mViewsField$2.INSTANCE);
    }

    private WindowManagerSpy() {
    }

    private final Field getMViewsField() {
        return (Field) mViewsField$delegate.getValue();
    }

    /* access modifiers changed from: private */
    public final Class<?> getWindowManagerClass() {
        return (Class) windowManagerClass$delegate.getValue();
    }

    private final Object getWindowManagerInstance() {
        return windowManagerInstance$delegate.getValue();
    }

    @SuppressLint({"PrivateApi", "ObsoleteSdkInt", "DiscouragedPrivateApi"})
    public final void swapWindowManagerGlobalMViews(@NotNull Function1<? super ArrayList<View>, ? extends ArrayList<View>> function1) {
        Field mViewsField;
        Intrinsics.checkNotNullParameter(function1, "swap");
        try {
            Object windowManagerInstance = getWindowManagerInstance();
            if (windowManagerInstance != null && (mViewsField = INSTANCE.getMViewsField()) != null) {
                Object obj = mViewsField.get(windowManagerInstance);
                if (obj != null) {
                    mViewsField.set(windowManagerInstance, function1.invoke((ArrayList) obj));
                    return;
                }
                throw new NullPointerException("null cannot be cast to non-null type kotlin.collections.ArrayList<android.view.View> /* = java.util.ArrayList<android.view.View> */");
            }
        } catch (Throwable th2) {
            Log.w("WindowManagerSpy", th2);
        }
    }

    @NotNull
    public final View[] windowManagerMViewsArray() {
        return new View[0];
    }
}
