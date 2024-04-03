package com.instabug.terminations;

import java.util.concurrent.ScheduledExecutorService;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

final /* synthetic */ class d extends FunctionReferenceImpl implements Function1 {
    public d(Object obj) {
        super(1, obj, com.instabug.terminations.di.d.class, "getScheduledExecutor", "getScheduledExecutor(Ljava/lang/String;)Ljava/util/concurrent/ScheduledExecutorService;", 0);
    }

    @NotNull
    /* renamed from: a */
    public final ScheduledExecutorService invoke(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "p0");
        return ((com.instabug.terminations.di.d) this.receiver).b(str);
    }
}
