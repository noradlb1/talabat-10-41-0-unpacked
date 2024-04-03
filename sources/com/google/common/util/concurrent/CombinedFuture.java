package com.google.common.util.concurrent;

import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableCollection;
import com.google.common.util.concurrent.AggregateFuture;
import java.util.concurrent.Callable;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.RejectedExecutionException;
import javax.annotation.CheckForNull;

@GwtCompatible
@ElementTypesAreNonnullByDefault
final class CombinedFuture<V> extends AggregateFuture<Object, V> {
    /* access modifiers changed from: private */
    @CheckForNull
    public CombinedFuture<V>.CombinedFutureInterruptibleTask<?> task;

    public final class AsyncCallableInterruptibleTask extends CombinedFuture<V>.CombinedFutureInterruptibleTask<ListenableFuture<V>> {
        private final AsyncCallable<V> callable;

        public AsyncCallableInterruptibleTask(AsyncCallable<V> asyncCallable, Executor executor) {
            super(executor);
            this.callable = (AsyncCallable) Preconditions.checkNotNull(asyncCallable);
        }

        public String toPendingString() {
            return this.callable.toString();
        }

        public ListenableFuture<V> runInterruptibly() throws Exception {
            return (ListenableFuture) Preconditions.checkNotNull(this.callable.call(), "AsyncCallable.call returned null instead of a Future. Did you mean to return immediateFuture(null)? %s", (Object) this.callable);
        }

        public void setValue(ListenableFuture<V> listenableFuture) {
            CombinedFuture.this.setFuture(listenableFuture);
        }
    }

    public final class CallableInterruptibleTask extends CombinedFuture<V>.CombinedFutureInterruptibleTask<V> {
        private final Callable<V> callable;

        public CallableInterruptibleTask(Callable<V> callable2, Executor executor) {
            super(executor);
            this.callable = (Callable) Preconditions.checkNotNull(callable2);
        }

        @ParametricNullness
        public V runInterruptibly() throws Exception {
            return this.callable.call();
        }

        public void setValue(@ParametricNullness V v11) {
            CombinedFuture.this.set(v11);
        }

        public String toPendingString() {
            return this.callable.toString();
        }
    }

    public abstract class CombinedFutureInterruptibleTask<T> extends InterruptibleTask<T> {
        private final Executor listenerExecutor;

        public CombinedFutureInterruptibleTask(Executor executor) {
            this.listenerExecutor = (Executor) Preconditions.checkNotNull(executor);
        }

        public final void afterRanInterruptiblyFailure(Throwable th2) {
            CombinedFutureInterruptibleTask unused = CombinedFuture.this.task = null;
            if (th2 instanceof ExecutionException) {
                CombinedFuture.this.setException(((ExecutionException) th2).getCause());
            } else if (th2 instanceof CancellationException) {
                CombinedFuture.this.cancel(false);
            } else {
                CombinedFuture.this.setException(th2);
            }
        }

        public final void afterRanInterruptiblySuccess(@ParametricNullness T t11) {
            CombinedFutureInterruptibleTask unused = CombinedFuture.this.task = null;
            setValue(t11);
        }

        public final void execute() {
            try {
                this.listenerExecutor.execute(this);
            } catch (RejectedExecutionException e11) {
                CombinedFuture.this.setException(e11);
            }
        }

        public final boolean isDone() {
            return CombinedFuture.this.isDone();
        }

        public abstract void setValue(@ParametricNullness T t11);
    }

    public CombinedFuture(ImmutableCollection<? extends ListenableFuture<?>> immutableCollection, boolean z11, Executor executor, AsyncCallable<V> asyncCallable) {
        super(immutableCollection, z11, false);
        this.task = new AsyncCallableInterruptibleTask(asyncCallable, executor);
        init();
    }

    public void collectOneValue(int i11, @CheckForNull Object obj) {
    }

    public void handleAllCompleted() {
        CombinedFuture<V>.CombinedFutureInterruptibleTask<?> combinedFutureInterruptibleTask = this.task;
        if (combinedFutureInterruptibleTask != null) {
            combinedFutureInterruptibleTask.execute();
        }
    }

    public void interruptTask() {
        CombinedFuture<V>.CombinedFutureInterruptibleTask<?> combinedFutureInterruptibleTask = this.task;
        if (combinedFutureInterruptibleTask != null) {
            combinedFutureInterruptibleTask.interruptTask();
        }
    }

    public void releaseResources(AggregateFuture.ReleaseResourcesReason releaseResourcesReason) {
        super.releaseResources(releaseResourcesReason);
        if (releaseResourcesReason == AggregateFuture.ReleaseResourcesReason.OUTPUT_FUTURE_DONE) {
            this.task = null;
        }
    }

    public CombinedFuture(ImmutableCollection<? extends ListenableFuture<?>> immutableCollection, boolean z11, Executor executor, Callable<V> callable) {
        super(immutableCollection, z11, false);
        this.task = new CallableInterruptibleTask(callable, executor);
        init();
    }
}
