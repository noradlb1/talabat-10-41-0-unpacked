package com.talabat.sdsquad.core;

import io.reactivex.Scheduler;
import io.reactivex.schedulers.Schedulers;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016J\b\u0010\u0005\u001a\u00020\u0004H\u0016¨\u0006\u0006"}, d2 = {"Lcom/talabat/sdsquad/core/TestSchedulerProvider;", "Lcom/talabat/sdsquad/core/BaseSchedulerProvider;", "()V", "io", "Lio/reactivex/Scheduler;", "ui", "com_talabat_NewArchi_sdsquad_sdsquad"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class TestSchedulerProvider implements BaseSchedulerProvider {
    @NotNull
    public Scheduler io() {
        Scheduler trampoline = Schedulers.trampoline();
        Intrinsics.checkNotNullExpressionValue(trampoline, "trampoline()");
        return trampoline;
    }

    @NotNull
    public Scheduler ui() {
        Scheduler trampoline = Schedulers.trampoline();
        Intrinsics.checkNotNullExpressionValue(trampoline, "trampoline()");
        return trampoline;
    }
}
