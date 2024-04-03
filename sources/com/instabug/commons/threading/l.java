package com.instabug.commons.threading;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

final class l extends Lambda implements Function1 {

    /* renamed from: a  reason: collision with root package name */
    public static final l f46361a = new l();

    public l() {
        super(1);
    }

    public final void a(@NotNull StringBuilder sb2) {
        Intrinsics.checkNotNullParameter(sb2, "$this$null");
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        a((StringBuilder) obj);
        return Unit.INSTANCE;
    }
}
