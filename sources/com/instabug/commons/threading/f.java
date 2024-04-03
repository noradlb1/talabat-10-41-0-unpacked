package com.instabug.commons.threading;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

final class f extends Lambda implements Function1 {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ Thread f46357g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public f(Thread thread) {
        super(1);
        this.f46357g = thread;
    }

    @NotNull
    /* renamed from: a */
    public final Boolean invoke(@NotNull Thread thread) {
        boolean z11;
        Intrinsics.checkNotNullParameter(thread, "it");
        if (o.b(thread) || o.a(thread, this.f46357g)) {
            z11 = true;
        } else {
            z11 = false;
        }
        return Boolean.valueOf(z11);
    }
}
