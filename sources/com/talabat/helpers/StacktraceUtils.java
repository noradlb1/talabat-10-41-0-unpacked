package com.talabat.helpers;

import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0005\u001a\u00020\u0006H\u0007R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Lcom/talabat/helpers/StacktraceUtils;", "", "()V", "LIMIT", "", "current", "", "com_talabat_talabatlib_talabatlib"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class StacktraceUtils {
    @NotNull
    public static final StacktraceUtils INSTANCE = new StacktraceUtils();
    private static final int LIMIT = 10;

    private StacktraceUtils() {
    }

    @JvmStatic
    @NotNull
    public static final String current() {
        StackTraceElement[] stackTrace = new Throwable().getStackTrace();
        Intrinsics.checkNotNullExpressionValue(stackTrace, "Throwable().stackTrace");
        return ArraysKt___ArraysKt.take((T[]) stackTrace, 10).toString();
    }
}
