package com.talabat.core.dispatcher.domain;

import kotlin.Metadata;
import kotlinx.coroutines.CoroutineDispatcher;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0003H&J\b\u0010\u0005\u001a\u00020\u0003H&J\b\u0010\u0006\u001a\u00020\u0003H&J\b\u0010\u0007\u001a\u00020\u0003H&¨\u0006\b"}, d2 = {"Lcom/talabat/core/dispatcher/domain/CoroutineDispatchersFactory;", "", "default", "Lkotlinx/coroutines/CoroutineDispatcher;", "io", "main", "single", "unconfined", "com_talabat_core_dispatcher_domain_domain"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface CoroutineDispatchersFactory {
    @NotNull
    /* renamed from: default  reason: not valid java name */
    CoroutineDispatcher m9577default();

    @NotNull
    CoroutineDispatcher io();

    @NotNull
    CoroutineDispatcher main();

    @NotNull
    CoroutineDispatcher single();

    @NotNull
    CoroutineDispatcher unconfined();
}
