package kotlin.reflect.jvm.internal.impl.utils;

import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

public final class ExceptionUtilsKt {
    public static final boolean isProcessCanceledException(@NotNull Throwable th2) {
        Intrinsics.checkNotNullParameter(th2, "<this>");
        Class cls = th2.getClass();
        while (!Intrinsics.areEqual((Object) cls.getCanonicalName(), (Object) "com.intellij.openapi.progress.ProcessCanceledException")) {
            cls = cls.getSuperclass();
            if (cls == null) {
                return false;
            }
        }
        return true;
    }

    @NotNull
    public static final RuntimeException rethrow(@NotNull Throwable th2) {
        Intrinsics.checkNotNullParameter(th2, "e");
        throw th2;
    }
}
