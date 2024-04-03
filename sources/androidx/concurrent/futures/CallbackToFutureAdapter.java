package androidx.concurrent.futures;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.common.util.concurrent.ListenableFuture;
import java.lang.ref.WeakReference;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public final class CallbackToFutureAdapter {

    public static final class Completer<T> {

        /* renamed from: a  reason: collision with root package name */
        public Object f10422a;
        private boolean attemptedSetting;

        /* renamed from: b  reason: collision with root package name */
        public SafeFuture<T> f10423b;
        private ResolvableFuture<Void> cancellationFuture = ResolvableFuture.create();

        private void setCompletedNormally() {
            this.f10422a = null;
            this.f10423b = null;
            this.cancellationFuture = null;
        }

        public void a() {
            this.f10422a = null;
            this.f10423b = null;
            this.cancellationFuture.set(null);
        }

        public void addCancellationListener(@NonNull Runnable runnable, @NonNull Executor executor) {
            ResolvableFuture<Void> resolvableFuture = this.cancellationFuture;
            if (resolvableFuture != null) {
                resolvableFuture.addListener(runnable, executor);
            }
        }

        public void finalize() {
            ResolvableFuture<Void> resolvableFuture;
            SafeFuture<T> safeFuture = this.f10423b;
            if (safeFuture != null && !safeFuture.isDone()) {
                safeFuture.c(new FutureGarbageCollectedException("The completer object was garbage collected - this future would otherwise never complete. The tag was: " + this.f10422a));
            }
            if (!this.attemptedSetting && (resolvableFuture = this.cancellationFuture) != null) {
                resolvableFuture.set(null);
            }
        }

        public boolean set(T t11) {
            boolean z11 = true;
            this.attemptedSetting = true;
            SafeFuture<T> safeFuture = this.f10423b;
            if (safeFuture == null || !safeFuture.b(t11)) {
                z11 = false;
            }
            if (z11) {
                setCompletedNormally();
            }
            return z11;
        }

        public boolean setCancelled() {
            boolean z11 = true;
            this.attemptedSetting = true;
            SafeFuture<T> safeFuture = this.f10423b;
            if (safeFuture == null || !safeFuture.a(true)) {
                z11 = false;
            }
            if (z11) {
                setCompletedNormally();
            }
            return z11;
        }

        public boolean setException(@NonNull Throwable th2) {
            boolean z11 = true;
            this.attemptedSetting = true;
            SafeFuture<T> safeFuture = this.f10423b;
            if (safeFuture == null || !safeFuture.c(th2)) {
                z11 = false;
            }
            if (z11) {
                setCompletedNormally();
            }
            return z11;
        }
    }

    public static final class FutureGarbageCollectedException extends Throwable {
        public FutureGarbageCollectedException(String str) {
            super(str);
        }

        public synchronized Throwable fillInStackTrace() {
            return this;
        }
    }

    public interface Resolver<T> {
        @Nullable
        Object attachCompleter(@NonNull Completer<T> completer) throws Exception;
    }

    public static final class SafeFuture<T> implements ListenableFuture<T> {

        /* renamed from: b  reason: collision with root package name */
        public final WeakReference<Completer<T>> f10424b;
        private final AbstractResolvableFuture<T> delegate = new AbstractResolvableFuture<T>() {
            public String pendingToString() {
                Completer completer = SafeFuture.this.f10424b.get();
                if (completer == null) {
                    return "Completer object has been garbage collected, future will fail soon";
                }
                return "tag=[" + completer.f10422a + "]";
            }
        };

        public SafeFuture(Completer<T> completer) {
            this.f10424b = new WeakReference<>(completer);
        }

        public boolean a(boolean z11) {
            return this.delegate.cancel(z11);
        }

        public void addListener(@NonNull Runnable runnable, @NonNull Executor executor) {
            this.delegate.addListener(runnable, executor);
        }

        public boolean b(T t11) {
            return this.delegate.set(t11);
        }

        public boolean c(Throwable th2) {
            return this.delegate.setException(th2);
        }

        public boolean cancel(boolean z11) {
            Completer completer = this.f10424b.get();
            boolean cancel = this.delegate.cancel(z11);
            if (cancel && completer != null) {
                completer.a();
            }
            return cancel;
        }

        public T get() throws InterruptedException, ExecutionException {
            return this.delegate.get();
        }

        public boolean isCancelled() {
            return this.delegate.isCancelled();
        }

        public boolean isDone() {
            return this.delegate.isDone();
        }

        public String toString() {
            return this.delegate.toString();
        }

        public T get(long j11, @NonNull TimeUnit timeUnit) throws InterruptedException, ExecutionException, TimeoutException {
            return this.delegate.get(j11, timeUnit);
        }
    }

    private CallbackToFutureAdapter() {
    }

    @NonNull
    public static <T> ListenableFuture<T> getFuture(@NonNull Resolver<T> resolver) {
        Completer completer = new Completer();
        SafeFuture<T> safeFuture = new SafeFuture<>(completer);
        completer.f10423b = safeFuture;
        completer.f10422a = resolver.getClass();
        try {
            Object attachCompleter = resolver.attachCompleter(completer);
            if (attachCompleter != null) {
                completer.f10422a = attachCompleter;
            }
        } catch (Exception e11) {
            safeFuture.c(e11);
        }
        return safeFuture;
    }
}
