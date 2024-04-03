package com.bumptech.glide.request;

import android.graphics.drawable.Drawable;
import androidx.annotation.GuardedBy;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.request.target.SizeReadyCallback;
import com.bumptech.glide.request.target.Target;
import com.bumptech.glide.request.transition.Transition;
import com.bumptech.glide.util.Util;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class RequestFutureTarget<R> implements FutureTarget<R>, RequestListener<R> {
    private static final Waiter DEFAULT_WAITER = new Waiter();
    private final boolean assertBackgroundThread;
    @GuardedBy("this")
    @Nullable
    private GlideException exception;
    private final int height;
    @GuardedBy("this")
    private boolean isCancelled;
    @GuardedBy("this")
    private boolean loadFailed;
    @GuardedBy("this")
    @Nullable
    private Request request;
    @GuardedBy("this")
    @Nullable
    private R resource;
    @GuardedBy("this")
    private boolean resultReceived;
    private final Waiter waiter;
    private final int width;

    @VisibleForTesting
    public static class Waiter {
        public void notifyAll(Object obj) {
            obj.notifyAll();
        }

        public void waitForTimeout(Object obj, long j11) throws InterruptedException {
            obj.wait(j11);
        }
    }

    public RequestFutureTarget(int i11, int i12) {
        this(i11, i12, true, DEFAULT_WAITER);
    }

    private synchronized R doGet(Long l11) throws ExecutionException, InterruptedException, TimeoutException {
        if (this.assertBackgroundThread && !isDone()) {
            Util.assertBackgroundThread();
        }
        if (this.isCancelled) {
            throw new CancellationException();
        } else if (this.loadFailed) {
            throw new ExecutionException(this.exception);
        } else if (this.resultReceived) {
            return this.resource;
        } else {
            if (l11 == null) {
                this.waiter.waitForTimeout(this, 0);
            } else if (l11.longValue() > 0) {
                long currentTimeMillis = System.currentTimeMillis();
                long longValue = l11.longValue() + currentTimeMillis;
                while (!isDone() && currentTimeMillis < longValue) {
                    this.waiter.waitForTimeout(this, longValue - currentTimeMillis);
                    currentTimeMillis = System.currentTimeMillis();
                }
            }
            if (Thread.interrupted()) {
                throw new InterruptedException();
            } else if (this.loadFailed) {
                throw new ExecutionException(this.exception);
            } else if (this.isCancelled) {
                throw new CancellationException();
            } else if (this.resultReceived) {
                return this.resource;
            } else {
                throw new TimeoutException();
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x001b, code lost:
        if (r1 == null) goto L_0x0020;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:11:0x001d, code lost:
        r1.clear();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0020, code lost:
        return true;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean cancel(boolean r3) {
        /*
            r2 = this;
            monitor-enter(r2)
            boolean r0 = r2.isDone()     // Catch:{ all -> 0x0021 }
            if (r0 == 0) goto L_0x000a
            monitor-exit(r2)     // Catch:{ all -> 0x0021 }
            r3 = 0
            return r3
        L_0x000a:
            r0 = 1
            r2.isCancelled = r0     // Catch:{ all -> 0x0021 }
            com.bumptech.glide.request.RequestFutureTarget$Waiter r1 = r2.waiter     // Catch:{ all -> 0x0021 }
            r1.notifyAll(r2)     // Catch:{ all -> 0x0021 }
            r1 = 0
            if (r3 == 0) goto L_0x001a
            com.bumptech.glide.request.Request r3 = r2.request     // Catch:{ all -> 0x0021 }
            r2.request = r1     // Catch:{ all -> 0x0021 }
            r1 = r3
        L_0x001a:
            monitor-exit(r2)     // Catch:{ all -> 0x0021 }
            if (r1 == 0) goto L_0x0020
            r1.clear()
        L_0x0020:
            return r0
        L_0x0021:
            r3 = move-exception
            monitor-exit(r2)     // Catch:{ all -> 0x0021 }
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bumptech.glide.request.RequestFutureTarget.cancel(boolean):boolean");
    }

    public R get() throws InterruptedException, ExecutionException {
        try {
            return doGet((Long) null);
        } catch (TimeoutException e11) {
            throw new AssertionError(e11);
        }
    }

    @Nullable
    public synchronized Request getRequest() {
        return this.request;
    }

    public void getSize(@NonNull SizeReadyCallback sizeReadyCallback) {
        sizeReadyCallback.onSizeReady(this.width, this.height);
    }

    public synchronized boolean isCancelled() {
        return this.isCancelled;
    }

    public synchronized boolean isDone() {
        boolean z11;
        if (this.isCancelled || this.resultReceived || this.loadFailed) {
            z11 = true;
        } else {
            z11 = false;
        }
        return z11;
    }

    public void onDestroy() {
    }

    public void onLoadCleared(@Nullable Drawable drawable) {
    }

    public synchronized void onLoadFailed(@Nullable Drawable drawable) {
    }

    public void onLoadStarted(@Nullable Drawable drawable) {
    }

    public synchronized void onResourceReady(@NonNull R r11, @Nullable Transition<? super R> transition) {
    }

    public void onStart() {
    }

    public void onStop() {
    }

    public void removeCallback(@NonNull SizeReadyCallback sizeReadyCallback) {
    }

    public synchronized void setRequest(@Nullable Request request2) {
        this.request = request2;
    }

    public RequestFutureTarget(int i11, int i12, boolean z11, Waiter waiter2) {
        this.width = i11;
        this.height = i12;
        this.assertBackgroundThread = z11;
        this.waiter = waiter2;
    }

    public synchronized boolean onLoadFailed(@Nullable GlideException glideException, Object obj, Target<R> target, boolean z11) {
        this.loadFailed = true;
        this.exception = glideException;
        this.waiter.notifyAll(this);
        return false;
    }

    public synchronized boolean onResourceReady(R r11, Object obj, Target<R> target, DataSource dataSource, boolean z11) {
        this.resultReceived = true;
        this.resource = r11;
        this.waiter.notifyAll(this);
        return false;
    }

    public R get(long j11, @NonNull TimeUnit timeUnit) throws InterruptedException, ExecutionException, TimeoutException {
        return doGet(Long.valueOf(timeUnit.toMillis(j11)));
    }
}
