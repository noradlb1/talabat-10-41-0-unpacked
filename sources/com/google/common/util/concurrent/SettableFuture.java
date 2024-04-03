package com.google.common.util.concurrent;

import com.google.common.annotations.GwtCompatible;
import com.google.common.util.concurrent.AbstractFuture;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;

@GwtCompatible
@ElementTypesAreNonnullByDefault
public final class SettableFuture<V> extends AbstractFuture.TrustedFuture<V> {
    private SettableFuture() {
    }

    public static <V> SettableFuture<V> create() {
        return new SettableFuture<>();
    }

    public /* bridge */ /* synthetic */ void addListener(Runnable runnable, Executor executor) {
        super.addListener(runnable, executor);
    }

    @CanIgnoreReturnValue
    public /* bridge */ /* synthetic */ boolean cancel(boolean z11) {
        return super.cancel(z11);
    }

    @ParametricNullness
    @CanIgnoreReturnValue
    public /* bridge */ /* synthetic */ Object get() throws InterruptedException, ExecutionException {
        return super.get();
    }

    public /* bridge */ /* synthetic */ boolean isCancelled() {
        return super.isCancelled();
    }

    @CanIgnoreReturnValue
    public boolean set(@ParametricNullness V v11) {
        return super.set(v11);
    }

    @CanIgnoreReturnValue
    public boolean setException(Throwable th2) {
        return super.setException(th2);
    }

    @CanIgnoreReturnValue
    public boolean setFuture(ListenableFuture<? extends V> listenableFuture) {
        return super.setFuture(listenableFuture);
    }
}
