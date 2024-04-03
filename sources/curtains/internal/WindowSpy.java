package curtains.internal;

import android.annotation.SuppressLint;
import android.view.View;
import android.view.Window;
import java.lang.reflect.Field;
import kotlin.Lazy;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÁ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011J\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u00132\u0006\u0010\u0010\u001a\u00020\u0011R!\u0010\u0003\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u00048BX\u0002¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006R\u001d\u0010\t\u001a\u0004\u0018\u00010\n8BX\u0002¢\u0006\f\n\u0004\b\r\u0010\b\u001a\u0004\b\u000b\u0010\f¨\u0006\u0014"}, d2 = {"Lcurtains/internal/WindowSpy;", "", "()V", "decorViewClass", "Ljava/lang/Class;", "getDecorViewClass", "()Ljava/lang/Class;", "decorViewClass$delegate", "Lkotlin/Lazy;", "windowField", "Ljava/lang/reflect/Field;", "getWindowField", "()Ljava/lang/reflect/Field;", "windowField$delegate", "attachedToPhoneWindow", "", "maybeDecorView", "Landroid/view/View;", "pullWindow", "Landroid/view/Window;", "curtains_release"}, k = 1, mv = {1, 4, 1})
@SuppressLint({"PrivateApi"})
public final class WindowSpy {
    @NotNull
    public static final WindowSpy INSTANCE = new WindowSpy();
    private static final Lazy decorViewClass$delegate;
    private static final Lazy windowField$delegate;

    static {
        LazyThreadSafetyMode lazyThreadSafetyMode = LazyThreadSafetyMode.NONE;
        decorViewClass$delegate = LazyKt__LazyJVMKt.lazy(lazyThreadSafetyMode, WindowSpy$decorViewClass$2.INSTANCE);
        windowField$delegate = LazyKt__LazyJVMKt.lazy(lazyThreadSafetyMode, WindowSpy$windowField$2.INSTANCE);
    }

    private WindowSpy() {
    }

    /* access modifiers changed from: private */
    public final Class<?> getDecorViewClass() {
        return (Class) decorViewClass$delegate.getValue();
    }

    private final Field getWindowField() {
        return (Field) windowField$delegate.getValue();
    }

    public final boolean attachedToPhoneWindow(@NotNull View view) {
        Intrinsics.checkNotNullParameter(view, "maybeDecorView");
        Class<?> decorViewClass = getDecorViewClass();
        if (decorViewClass != null) {
            return decorViewClass.isInstance(view);
        }
        return false;
    }

    @Nullable
    public final Window pullWindow(@NotNull View view) {
        Field windowField;
        Intrinsics.checkNotNullParameter(view, "maybeDecorView");
        Class<?> decorViewClass = getDecorViewClass();
        if (decorViewClass == null || !decorViewClass.isInstance(view) || (windowField = INSTANCE.getWindowField()) == null) {
            return null;
        }
        Object obj = windowField.get(view);
        if (obj != null) {
            return (Window) obj;
        }
        throw new NullPointerException("null cannot be cast to non-null type android.view.Window");
    }
}
