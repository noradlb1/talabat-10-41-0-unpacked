package com.talabat.core.dispatcher.data;

import com.talabat.core.dispatcher.domain.RxSchedulersFactory;
import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0007¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016J\b\u0010\u0005\u001a\u00020\u0004H\u0016J\b\u0010\u0006\u001a\u00020\u0004H\u0016¨\u0006\u0007"}, d2 = {"Lcom/talabat/core/dispatcher/data/RealRxSchedulersFactory;", "Lcom/talabat/core/dispatcher/domain/RxSchedulersFactory;", "()V", "computation", "Lio/reactivex/Scheduler;", "io", "main", "com_talabat_core_dispatcher_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class RealRxSchedulersFactory implements RxSchedulersFactory {
    @NotNull
    public Scheduler computation() {
        Scheduler computation = Schedulers.computation();
        Intrinsics.checkNotNullExpressionValue(computation, "computation()");
        return computation;
    }

    @NotNull
    public Scheduler io() {
        Scheduler io2 = Schedulers.io();
        Intrinsics.checkNotNullExpressionValue(io2, "io()");
        return io2;
    }

    @NotNull
    public Scheduler main() {
        Scheduler mainThread = AndroidSchedulers.mainThread();
        Intrinsics.checkNotNullExpressionValue(mainThread, "mainThread()");
        return mainThread;
    }
}
