package curtains.internal;

import android.os.Handler;
import android.os.Looper;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\u001a\b\u0010\u0006\u001a\u00020\u0007H\u0000\"\u001b\u0010\u0000\u001a\u00020\u00018@X\u0002¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0002\u0010\u0003¨\u0006\b"}, d2 = {"mainHandler", "Landroid/os/Handler;", "getMainHandler", "()Landroid/os/Handler;", "mainHandler$delegate", "Lkotlin/Lazy;", "checkMainThread", "", "curtains_release"}, k = 2, mv = {1, 4, 1})
public final class HandlersKt {
    @NotNull
    private static final Lazy mainHandler$delegate = LazyKt__LazyJVMKt.lazy(HandlersKt$mainHandler$2.INSTANCE);

    public static final void checkMainThread() {
        boolean z11;
        Looper mainLooper = Looper.getMainLooper();
        Intrinsics.checkNotNullExpressionValue(mainLooper, "Looper.getMainLooper()");
        if (mainLooper.getThread() == Thread.currentThread()) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (!z11) {
            throw new IllegalStateException(("Should be called from the main thread, not " + Thread.currentThread()).toString());
        }
    }

    @NotNull
    public static final Handler getMainHandler() {
        return (Handler) mainHandler$delegate.getValue();
    }
}
