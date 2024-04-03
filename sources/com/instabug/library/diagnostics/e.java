package com.instabug.library.diagnostics;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

final class e extends Lambda implements Function1 {

    /* renamed from: a  reason: collision with root package name */
    public static final e f34287a = new e();

    public e() {
        super(1);
    }

    @NotNull
    /* renamed from: a */
    public final Boolean invoke(@NotNull StackTraceElement stackTraceElement) {
        Intrinsics.checkNotNullParameter(stackTraceElement, "it");
        String className = stackTraceElement.getClassName();
        Intrinsics.checkNotNullExpressionValue(className, "it.className");
        return Boolean.valueOf(!StringsKt__StringsKt.contains$default((CharSequence) className, (CharSequence) "IBGDiagnostics", false, 2, (Object) null));
    }
}
