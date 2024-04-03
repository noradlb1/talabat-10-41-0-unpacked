package io.flutter.plugins.googlesignin;

import a00.a;
import a00.b;
import androidx.annotation.NonNull;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.SettableFuture;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public final class BackgroundTaskRunner {
    private final ThreadPoolExecutor executor;

    public interface Callback<T> {
        void run(@NonNull Future<T> future);
    }

    public BackgroundTaskRunner(int i11) {
        int i12 = i11;
        int i13 = i11;
        this.executor = new ThreadPoolExecutor(i12, i13, 1, TimeUnit.SECONDS, new LinkedBlockingQueue());
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ void lambda$runInBackground$1(SettableFuture settableFuture, Callable callable) {
        if (!settableFuture.isCancelled()) {
            try {
                settableFuture.set(callable.call());
            } catch (Throwable th2) {
                settableFuture.setException(th2);
            }
        }
    }

    public <T> void runInBackground(@NonNull Callable<T> callable, @NonNull Callback<T> callback) {
        ListenableFuture<T> runInBackground = runInBackground(callable);
        runInBackground.addListener(new a(callback, runInBackground), Executors.uiThreadExecutor());
    }

    @NonNull
    public <T> ListenableFuture<T> runInBackground(@NonNull Callable<T> callable) {
        SettableFuture create = SettableFuture.create();
        this.executor.execute(new b(create, callable));
        return create;
    }
}
