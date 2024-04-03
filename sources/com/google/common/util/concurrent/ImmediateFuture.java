package com.google.common.util.concurrent;

import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Preconditions;
import com.google.common.util.concurrent.AbstractFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.CheckForNull;

@GwtCompatible
@ElementTypesAreNonnullByDefault
class ImmediateFuture<V> implements ListenableFuture<V> {
    static final ListenableFuture<?> NULL = new ImmediateFuture((Object) null);
    private static final Logger log = Logger.getLogger(ImmediateFuture.class.getName());
    @ParametricNullness
    private final V value;

    public static final class ImmediateCancelledFuture<V> extends AbstractFuture.TrustedFuture<V> {
        @CheckForNull
        static final ImmediateCancelledFuture<Object> INSTANCE = (AbstractFuture.GENERATE_CANCELLATION_CAUSES ? null : new ImmediateCancelledFuture<>());

        public ImmediateCancelledFuture() {
            cancel(false);
        }
    }

    public static final class ImmediateFailedFuture<V> extends AbstractFuture.TrustedFuture<V> {
        public ImmediateFailedFuture(Throwable th2) {
            setException(th2);
        }
    }

    public ImmediateFuture(@ParametricNullness V v11) {
        this.value = v11;
    }

    public void addListener(Runnable runnable, Executor executor) {
        Preconditions.checkNotNull(runnable, "Runnable was null.");
        Preconditions.checkNotNull(executor, "Executor was null.");
        try {
            executor.execute(runnable);
        } catch (RuntimeException e11) {
            Logger logger = log;
            Level level = Level.SEVERE;
            logger.log(level, "RuntimeException while executing runnable " + runnable + " with executor " + executor, e11);
        }
    }

    public boolean cancel(boolean z11) {
        return false;
    }

    @ParametricNullness
    public V get() {
        return this.value;
    }

    public boolean isCancelled() {
        return false;
    }

    public boolean isDone() {
        return true;
    }

    public String toString() {
        return super.toString() + "[status=SUCCESS, result=[" + this.value + "]]";
    }

    @ParametricNullness
    public V get(long j11, TimeUnit timeUnit) throws ExecutionException {
        Preconditions.checkNotNull(timeUnit);
        return get();
    }
}
