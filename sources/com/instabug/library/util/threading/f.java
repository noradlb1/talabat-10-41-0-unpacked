package com.instabug.library.util.threading;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

public final class f extends Lambda implements Function1 {

    /* renamed from: a  reason: collision with root package name */
    public static final f f52108a = new f();

    public f() {
        super(1);
    }

    public final void a(@NotNull Thread thread) {
        Intrinsics.checkNotNullParameter(thread, "$this$null");
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        a((Thread) obj);
        return Unit.INSTANCE;
    }
}
