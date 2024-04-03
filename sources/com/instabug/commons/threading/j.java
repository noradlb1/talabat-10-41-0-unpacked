package com.instabug.commons.threading;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

final class j extends Lambda implements Function1 {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ Thread f46359g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public j(Thread thread) {
        super(1);
        this.f46359g = thread;
    }

    @NotNull
    /* renamed from: a */
    public final Boolean invoke(@NotNull Thread thread) {
        Intrinsics.checkNotNullParameter(thread, "it");
        return Boolean.valueOf(o.a(thread, this.f46359g));
    }
}
