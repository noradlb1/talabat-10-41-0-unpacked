package com.instabug.commons.threading;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

final class k extends Lambda implements Function1 {

    /* renamed from: a  reason: collision with root package name */
    public static final k f46360a = new k();

    public k() {
        super(1);
    }

    @NotNull
    /* renamed from: a */
    public final Boolean invoke(@NotNull Thread thread) {
        Intrinsics.checkNotNullParameter(thread, "it");
        return Boolean.valueOf(o.b(thread));
    }
}
