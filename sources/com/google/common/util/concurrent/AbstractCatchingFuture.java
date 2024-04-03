package com.google.common.util.concurrent;

import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Function;
import com.google.common.base.Preconditions;
import com.google.common.util.concurrent.FluentFuture;
import com.google.errorprone.annotations.ForOverride;
import java.lang.Throwable;
import java.util.concurrent.Executor;
import javax.annotation.CheckForNull;

@GwtCompatible
@ElementTypesAreNonnullByDefault
abstract class AbstractCatchingFuture<V, X extends Throwable, F, T> extends FluentFuture.TrustedFuture<V> implements Runnable {
    @CheckForNull
    Class<X> exceptionType;
    @CheckForNull
    F fallback;
    @CheckForNull
    ListenableFuture<? extends V> inputFuture;

    public static final class AsyncCatchingFuture<V, X extends Throwable> extends AbstractCatchingFuture<V, X, AsyncFunction<? super X, ? extends V>, ListenableFuture<? extends V>> {
        public AsyncCatchingFuture(ListenableFuture<? extends V> listenableFuture, Class<X> cls, AsyncFunction<? super X, ? extends V> asyncFunction) {
            super(listenableFuture, cls, asyncFunction);
        }

        public ListenableFuture<? extends V> doFallback(AsyncFunction<? super X, ? extends V> asyncFunction, X x11) throws Exception {
            ListenableFuture<? extends V> apply = asyncFunction.apply(x11);
            Preconditions.checkNotNull(apply, "AsyncFunction.apply returned null instead of a Future. Did you mean to return immediateFuture(null)? %s", (Object) asyncFunction);
            return apply;
        }

        public void setResult(ListenableFuture<? extends V> listenableFuture) {
            setFuture(listenableFuture);
        }
    }

    public static final class CatchingFuture<V, X extends Throwable> extends AbstractCatchingFuture<V, X, Function<? super X, ? extends V>, V> {
        public CatchingFuture(ListenableFuture<? extends V> listenableFuture, Class<X> cls, Function<? super X, ? extends V> function) {
            super(listenableFuture, cls, function);
        }

        public void setResult(@ParametricNullness V v11) {
            set(v11);
        }

        @ParametricNullness
        public V doFallback(Function<? super X, ? extends V> function, X x11) throws Exception {
            return function.apply(x11);
        }
    }

    public AbstractCatchingFuture(ListenableFuture<? extends V> listenableFuture, Class<X> cls, F f11) {
        this.inputFuture = (ListenableFuture) Preconditions.checkNotNull(listenableFuture);
        this.exceptionType = (Class) Preconditions.checkNotNull(cls);
        this.fallback = Preconditions.checkNotNull(f11);
    }

    public static <V, X extends Throwable> ListenableFuture<V> create(ListenableFuture<? extends V> listenableFuture, Class<X> cls, Function<? super X, ? extends V> function, Executor executor) {
        CatchingFuture catchingFuture = new CatchingFuture(listenableFuture, cls, function);
        listenableFuture.addListener(catchingFuture, MoreExecutors.rejectionPropagatingExecutor(executor, catchingFuture));
        return catchingFuture;
    }

    public final void afterDone() {
        maybePropagateCancellationTo(this.inputFuture);
        this.inputFuture = null;
        this.exceptionType = null;
        this.fallback = null;
    }

    @ForOverride
    @ParametricNullness
    public abstract T doFallback(F f11, X x11) throws Exception;

    @CheckForNull
    public String pendingToString() {
        String str;
        ListenableFuture<? extends V> listenableFuture = this.inputFuture;
        Class<X> cls = this.exceptionType;
        F f11 = this.fallback;
        String pendingToString = super.pendingToString();
        if (listenableFuture != null) {
            str = "inputFuture=[" + listenableFuture + "], ";
        } else {
            str = "";
        }
        if (cls != null && f11 != null) {
            return str + "exceptionType=[" + cls + "], fallback=[" + f11 + "]";
        } else if (pendingToString == null) {
            return null;
        } else {
            return str + pendingToString;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:30:0x0074  */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x007c  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void run() {
        /*
            r8 = this;
            com.google.common.util.concurrent.ListenableFuture<? extends V> r0 = r8.inputFuture
            java.lang.Class<X> r1 = r8.exceptionType
            F r2 = r8.fallback
            r3 = 1
            r4 = 0
            if (r0 != 0) goto L_0x000c
            r5 = r3
            goto L_0x000d
        L_0x000c:
            r5 = r4
        L_0x000d:
            if (r1 != 0) goto L_0x0011
            r6 = r3
            goto L_0x0012
        L_0x0011:
            r6 = r4
        L_0x0012:
            r5 = r5 | r6
            if (r2 != 0) goto L_0x0016
            goto L_0x0017
        L_0x0016:
            r3 = r4
        L_0x0017:
            r3 = r3 | r5
            if (r3 != 0) goto L_0x00a4
            boolean r3 = r8.isCancelled()
            if (r3 == 0) goto L_0x0022
            goto L_0x00a4
        L_0x0022:
            r3 = 0
            r8.inputFuture = r3
            boolean r4 = r0 instanceof com.google.common.util.concurrent.internal.InternalFutureFailureAccess     // Catch:{ ExecutionException -> 0x003e, RuntimeException -> 0x003b, Error -> 0x0039 }
            if (r4 == 0) goto L_0x0031
            r4 = r0
            com.google.common.util.concurrent.internal.InternalFutureFailureAccess r4 = (com.google.common.util.concurrent.internal.InternalFutureFailureAccess) r4     // Catch:{ ExecutionException -> 0x003e, RuntimeException -> 0x003b, Error -> 0x0039 }
            java.lang.Throwable r4 = com.google.common.util.concurrent.internal.InternalFutures.tryInternalFastPathGetFailure(r4)     // Catch:{ ExecutionException -> 0x003e, RuntimeException -> 0x003b, Error -> 0x0039 }
            goto L_0x0032
        L_0x0031:
            r4 = r3
        L_0x0032:
            if (r4 != 0) goto L_0x003c
            java.lang.Object r5 = com.google.common.util.concurrent.Futures.getDone(r0)     // Catch:{ ExecutionException -> 0x003e, RuntimeException -> 0x003b, Error -> 0x0039 }
            goto L_0x0072
        L_0x0039:
            r4 = move-exception
            goto L_0x003c
        L_0x003b:
            r4 = move-exception
        L_0x003c:
            r5 = r3
            goto L_0x0072
        L_0x003e:
            r4 = move-exception
            java.lang.Throwable r5 = r4.getCause()
            if (r5 != 0) goto L_0x0070
            java.lang.NullPointerException r5 = new java.lang.NullPointerException
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>()
            java.lang.String r7 = "Future type "
            r6.append(r7)
            java.lang.Class r7 = r0.getClass()
            r6.append(r7)
            java.lang.String r7 = " threw "
            r6.append(r7)
            java.lang.Class r4 = r4.getClass()
            r6.append(r4)
            java.lang.String r4 = " without a cause"
            r6.append(r4)
            java.lang.String r4 = r6.toString()
            r5.<init>(r4)
        L_0x0070:
            r4 = r5
            goto L_0x003c
        L_0x0072:
            if (r4 != 0) goto L_0x007c
            java.lang.Object r0 = com.google.common.util.concurrent.NullnessCasts.uncheckedCastNullableTToT(r5)
            r8.set(r0)
            return
        L_0x007c:
            boolean r1 = com.google.common.util.concurrent.Platform.isInstanceOfThrowableClass(r4, r1)
            if (r1 != 0) goto L_0x0086
            r8.setFuture(r0)
            return
        L_0x0086:
            java.lang.Object r0 = r8.doFallback(r2, r4)     // Catch:{ all -> 0x0092 }
            r8.exceptionType = r3
            r8.fallback = r3
            r8.setResult(r0)
            return
        L_0x0092:
            r0 = move-exception
            com.google.common.util.concurrent.Platform.restoreInterruptIfIsInterruptedException(r0)     // Catch:{ all -> 0x009e }
            r8.setException(r0)     // Catch:{ all -> 0x009e }
            r8.exceptionType = r3
            r8.fallback = r3
            return
        L_0x009e:
            r0 = move-exception
            r8.exceptionType = r3
            r8.fallback = r3
            throw r0
        L_0x00a4:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.common.util.concurrent.AbstractCatchingFuture.run():void");
    }

    @ForOverride
    public abstract void setResult(@ParametricNullness T t11);

    public static <X extends Throwable, V> ListenableFuture<V> create(ListenableFuture<? extends V> listenableFuture, Class<X> cls, AsyncFunction<? super X, ? extends V> asyncFunction, Executor executor) {
        AsyncCatchingFuture asyncCatchingFuture = new AsyncCatchingFuture(listenableFuture, cls, asyncFunction);
        listenableFuture.addListener(asyncCatchingFuture, MoreExecutors.rejectionPropagatingExecutor(executor, asyncCatchingFuture));
        return asyncCatchingFuture;
    }
}
