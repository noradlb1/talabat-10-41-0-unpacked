package com.instabug.commons.snapshot;

import java.util.concurrent.ScheduledExecutorService;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

final class c extends Lambda implements Function0 {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ d f46342g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public c(d dVar) {
        super(0);
        this.f46342g = dVar;
    }

    @NotNull
    /* renamed from: a */
    public final ScheduledExecutorService invoke() {
        return (ScheduledExecutorService) this.f46342g.executorFactory.invoke(Intrinsics.stringPlus(this.f46342g.d(), "CaptorExecutor"));
    }
}
