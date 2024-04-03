package com.talabat.core.dispatcher.domain;

import io.reactivex.Scheduler;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0003H&J\b\u0010\u0005\u001a\u00020\u0003H&¨\u0006\u0006"}, d2 = {"Lcom/talabat/core/dispatcher/domain/RxSchedulersFactory;", "", "computation", "Lio/reactivex/Scheduler;", "io", "main", "com_talabat_core_dispatcher_domain_domain"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface RxSchedulersFactory {
    @NotNull
    Scheduler computation();

    @NotNull
    Scheduler io();

    @NotNull
    Scheduler main();
}
