package com.talabat.core.dispatcher.data;

import com.talabat.core.dispatcher.domain.CoroutineDispatchersFactory;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.ExecutorsKt;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007\b\u0007¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016J\b\u0010\u0005\u001a\u00020\u0004H\u0016J\b\u0010\u0006\u001a\u00020\u0004H\u0016J\b\u0010\u0007\u001a\u00020\u0004H\u0016J\b\u0010\b\u001a\u00020\u0004H\u0016¨\u0006\t"}, d2 = {"Lcom/talabat/core/dispatcher/data/RealCoroutineDispatchersFactory;", "Lcom/talabat/core/dispatcher/domain/CoroutineDispatchersFactory;", "()V", "default", "Lkotlinx/coroutines/CoroutineDispatcher;", "io", "main", "single", "unconfined", "com_talabat_core_dispatcher_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class RealCoroutineDispatchersFactory implements CoroutineDispatchersFactory {
    @NotNull
    /* renamed from: default  reason: not valid java name */
    public CoroutineDispatcher m9576default() {
        return Dispatchers.getDefault();
    }

    @NotNull
    public CoroutineDispatcher io() {
        return Dispatchers.getIO();
    }

    @NotNull
    public CoroutineDispatcher main() {
        return Dispatchers.getMain();
    }

    @NotNull
    public CoroutineDispatcher single() {
        ExecutorService newSingleThreadExecutor = Executors.newSingleThreadExecutor(new SingleThreadFactory());
        Intrinsics.checkNotNullExpressionValue(newSingleThreadExecutor, "newSingleThreadExecutor(SingleThreadFactory())");
        return ExecutorsKt.from(newSingleThreadExecutor);
    }

    @NotNull
    public CoroutineDispatcher unconfined() {
        return Dispatchers.getUnconfined();
    }
}
