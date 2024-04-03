package com.instabug.library.diagnostics.sdkEvents.cache;

import com.instabug.library.diagnostics.sdkEvents.models.a;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

final class e extends Lambda implements Function1 {

    /* renamed from: a  reason: collision with root package name */
    public static final e f34328a = new e();

    public e() {
        super(1);
    }

    @NotNull
    /* renamed from: a */
    public final Boolean invoke(@NotNull a aVar) {
        Intrinsics.checkNotNullParameter(aVar, "it");
        return Boolean.valueOf(com.instabug.library.util.extenstions.e.a(aVar.b()));
    }
}
