package com.google.common.util.concurrent;

import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Function;
import com.google.common.base.Preconditions;
import com.google.common.util.concurrent.FluentFuture;
import com.google.errorprone.annotations.ForOverride;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import javax.annotation.CheckForNull;

@GwtCompatible
@ElementTypesAreNonnullByDefault
abstract class AbstractTransformFuture<I, O, F, T> extends FluentFuture.TrustedFuture<O> implements Runnable {
    @CheckForNull
    F function;
    @CheckForNull
    ListenableFuture<? extends I> inputFuture;

    public static final class AsyncTransformFuture<I, O> extends AbstractTransformFuture<I, O, AsyncFunction<? super I, ? extends O>, ListenableFuture<? extends O>> {
        public AsyncTransformFuture(ListenableFuture<? extends I> listenableFuture, AsyncFunction<? super I, ? extends O> asyncFunction) {
            super(listenableFuture, asyncFunction);
        }

        public ListenableFuture<? extends O> doTransform(AsyncFunction<? super I, ? extends O> asyncFunction, @ParametricNullness I i11) throws Exception {
            ListenableFuture<? extends O> apply = asyncFunction.apply(i11);
            Preconditions.checkNotNull(apply, "AsyncFunction.apply returned null instead of a Future. Did you mean to return immediateFuture(null)? %s", (Object) asyncFunction);
            return apply;
        }

        public void setResult(ListenableFuture<? extends O> listenableFuture) {
            setFuture(listenableFuture);
        }
    }

    public static final class TransformFuture<I, O> extends AbstractTransformFuture<I, O, Function<? super I, ? extends O>, O> {
        public TransformFuture(ListenableFuture<? extends I> listenableFuture, Function<? super I, ? extends O> function) {
            super(listenableFuture, function);
        }

        public void setResult(@ParametricNullness O o11) {
            set(o11);
        }

        @ParametricNullness
        public O doTransform(Function<? super I, ? extends O> function, @ParametricNullness I i11) {
            return function.apply(i11);
        }
    }

    public AbstractTransformFuture(ListenableFuture<? extends I> listenableFuture, F f11) {
        this.inputFuture = (ListenableFuture) Preconditions.checkNotNull(listenableFuture);
        this.function = Preconditions.checkNotNull(f11);
    }

    public static <I, O> ListenableFuture<O> create(ListenableFuture<I> listenableFuture, AsyncFunction<? super I, ? extends O> asyncFunction, Executor executor) {
        Preconditions.checkNotNull(executor);
        AsyncTransformFuture asyncTransformFuture = new AsyncTransformFuture(listenableFuture, asyncFunction);
        listenableFuture.addListener(asyncTransformFuture, MoreExecutors.rejectionPropagatingExecutor(executor, asyncTransformFuture));
        return asyncTransformFuture;
    }

    public final void afterDone() {
        maybePropagateCancellationTo(this.inputFuture);
        this.inputFuture = null;
        this.function = null;
    }

    @ForOverride
    @ParametricNullness
    public abstract T doTransform(F f11, @ParametricNullness I i11) throws Exception;

    @CheckForNull
    public String pendingToString() {
        String str;
        ListenableFuture<? extends I> listenableFuture = this.inputFuture;
        F f11 = this.function;
        String pendingToString = super.pendingToString();
        if (listenableFuture != null) {
            str = "inputFuture=[" + listenableFuture + "], ";
        } else {
            str = "";
        }
        if (f11 != null) {
            return str + "function=[" + f11 + "]";
        } else if (pendingToString == null) {
            return null;
        } else {
            return str + pendingToString;
        }
    }

    public final void run() {
        boolean z11;
        ListenableFuture<? extends I> listenableFuture = this.inputFuture;
        F f11 = this.function;
        boolean isCancelled = isCancelled();
        boolean z12 = true;
        if (listenableFuture == null) {
            z11 = true;
        } else {
            z11 = false;
        }
        boolean z13 = isCancelled | z11;
        if (f11 != null) {
            z12 = false;
        }
        if (!z13 && !z12) {
            this.inputFuture = null;
            if (listenableFuture.isCancelled()) {
                setFuture(listenableFuture);
                return;
            }
            try {
                try {
                    Object doTransform = doTransform(f11, Futures.getDone(listenableFuture));
                    this.function = null;
                    setResult(doTransform);
                } catch (Throwable th2) {
                    this.function = null;
                    throw th2;
                }
            } catch (CancellationException unused) {
                cancel(false);
            } catch (ExecutionException e11) {
                setException(e11.getCause());
            } catch (RuntimeException e12) {
                setException(e12);
            } catch (Error e13) {
                setException(e13);
            }
        }
    }

    @ForOverride
    public abstract void setResult(@ParametricNullness T t11);

    public static <I, O> ListenableFuture<O> create(ListenableFuture<I> listenableFuture, Function<? super I, ? extends O> function2, Executor executor) {
        Preconditions.checkNotNull(function2);
        TransformFuture transformFuture = new TransformFuture(listenableFuture, function2);
        listenableFuture.addListener(transformFuture, MoreExecutors.rejectionPropagatingExecutor(executor, transformFuture));
        return transformFuture;
    }
}
