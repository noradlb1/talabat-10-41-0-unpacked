package com.bumptech.glide.load.engine.executor;

import android.os.Process;
import android.os.StrictMode;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import androidx.annotation.VisibleForTesting;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public final class GlideExecutor implements ExecutorService {
    private static final String DEFAULT_ANIMATION_EXECUTOR_NAME = "animation";
    private static final String DEFAULT_DISK_CACHE_EXECUTOR_NAME = "disk-cache";
    private static final int DEFAULT_DISK_CACHE_EXECUTOR_THREADS = 1;
    private static final String DEFAULT_SOURCE_EXECUTOR_NAME = "source";
    private static final String DEFAULT_SOURCE_UNLIMITED_EXECUTOR_NAME = "source-unlimited";
    private static final long KEEP_ALIVE_TIME_MS = TimeUnit.SECONDS.toMillis(10);
    private static final int MAXIMUM_AUTOMATIC_THREAD_COUNT = 4;
    private static final String TAG = "GlideExecutor";
    private static volatile int bestThreadCount;
    private final ExecutorService delegate;

    public static final class Builder {
        public static final long NO_THREAD_TIMEOUT = 0;
        private int corePoolSize;
        private int maximumPoolSize;

        /* renamed from: name  reason: collision with root package name */
        private String f44194name;
        private final boolean preventNetworkOperations;
        private long threadTimeoutMillis;
        @NonNull
        private UncaughtThrowableStrategy uncaughtThrowableStrategy = UncaughtThrowableStrategy.DEFAULT;

        public Builder(boolean z11) {
            this.preventNetworkOperations = z11;
        }

        public GlideExecutor build() {
            if (!TextUtils.isEmpty(this.f44194name)) {
                ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(this.corePoolSize, this.maximumPoolSize, this.threadTimeoutMillis, TimeUnit.MILLISECONDS, new PriorityBlockingQueue(), new DefaultThreadFactory(this.f44194name, this.uncaughtThrowableStrategy, this.preventNetworkOperations));
                if (this.threadTimeoutMillis != 0) {
                    threadPoolExecutor.allowCoreThreadTimeOut(true);
                }
                return new GlideExecutor(threadPoolExecutor);
            }
            throw new IllegalArgumentException("Name must be non-null and non-empty, but given: " + this.f44194name);
        }

        public Builder setName(String str) {
            this.f44194name = str;
            return this;
        }

        public Builder setThreadCount(@IntRange(from = 1) int i11) {
            this.corePoolSize = i11;
            this.maximumPoolSize = i11;
            return this;
        }

        public Builder setThreadTimeoutMillis(long j11) {
            this.threadTimeoutMillis = j11;
            return this;
        }

        public Builder setUncaughtThrowableStrategy(@NonNull UncaughtThrowableStrategy uncaughtThrowableStrategy2) {
            this.uncaughtThrowableStrategy = uncaughtThrowableStrategy2;
            return this;
        }
    }

    public static final class DefaultThreadFactory implements ThreadFactory {
        private static final int DEFAULT_PRIORITY = 9;

        /* renamed from: name  reason: collision with root package name */
        private final String f44195name;
        final boolean preventNetworkOperations;
        private int threadNum;
        final UncaughtThrowableStrategy uncaughtThrowableStrategy;

        public DefaultThreadFactory(String str, UncaughtThrowableStrategy uncaughtThrowableStrategy2, boolean z11) {
            this.f44195name = str;
            this.uncaughtThrowableStrategy = uncaughtThrowableStrategy2;
            this.preventNetworkOperations = z11;
        }

        public synchronized Thread newThread(@NonNull Runnable runnable) {
            AnonymousClass1 r02;
            r02 = new Thread(runnable, "glide-" + this.f44195name + "-thread-" + this.threadNum) {
                public void run() {
                    Process.setThreadPriority(9);
                    if (DefaultThreadFactory.this.preventNetworkOperations) {
                        StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder().detectNetwork().penaltyDeath().build());
                    }
                    try {
                        super.run();
                    } catch (Throwable th2) {
                        DefaultThreadFactory.this.uncaughtThrowableStrategy.handle(th2);
                    }
                }
            };
            this.threadNum = this.threadNum + 1;
            return r02;
        }
    }

    public interface UncaughtThrowableStrategy {
        public static final UncaughtThrowableStrategy DEFAULT;
        public static final UncaughtThrowableStrategy IGNORE = new UncaughtThrowableStrategy() {
            public void handle(Throwable th2) {
            }
        };
        public static final UncaughtThrowableStrategy LOG;
        public static final UncaughtThrowableStrategy THROW = new UncaughtThrowableStrategy() {
            public void handle(Throwable th2) {
                if (th2 != null) {
                    throw new RuntimeException("Request threw uncaught throwable", th2);
                }
            }
        };

        static {
            AnonymousClass2 r02 = new UncaughtThrowableStrategy() {
                public void handle(Throwable th2) {
                    if (th2 != null && Log.isLoggable(GlideExecutor.TAG, 6)) {
                        Log.e(GlideExecutor.TAG, "Request threw uncaught throwable", th2);
                    }
                }
            };
            LOG = r02;
            DEFAULT = r02;
        }

        void handle(Throwable th2);
    }

    @VisibleForTesting
    public GlideExecutor(ExecutorService executorService) {
        this.delegate = executorService;
    }

    public static int calculateBestThreadCount() {
        if (bestThreadCount == 0) {
            bestThreadCount = Math.min(4, RuntimeCompat.availableProcessors());
        }
        return bestThreadCount;
    }

    public static Builder newAnimationBuilder() {
        int i11;
        if (calculateBestThreadCount() >= 4) {
            i11 = 2;
        } else {
            i11 = 1;
        }
        return new Builder(true).setThreadCount(i11).setName("animation");
    }

    public static GlideExecutor newAnimationExecutor() {
        return newAnimationBuilder().build();
    }

    public static Builder newDiskCacheBuilder() {
        return new Builder(true).setThreadCount(1).setName(DEFAULT_DISK_CACHE_EXECUTOR_NAME);
    }

    public static GlideExecutor newDiskCacheExecutor() {
        return newDiskCacheBuilder().build();
    }

    public static Builder newSourceBuilder() {
        return new Builder(false).setThreadCount(calculateBestThreadCount()).setName("source");
    }

    public static GlideExecutor newSourceExecutor() {
        return newSourceBuilder().build();
    }

    public static GlideExecutor newUnlimitedSourceExecutor() {
        return new GlideExecutor(new ThreadPoolExecutor(0, Integer.MAX_VALUE, KEEP_ALIVE_TIME_MS, TimeUnit.MILLISECONDS, new SynchronousQueue(), new DefaultThreadFactory(DEFAULT_SOURCE_UNLIMITED_EXECUTOR_NAME, UncaughtThrowableStrategy.DEFAULT, false)));
    }

    public boolean awaitTermination(long j11, @NonNull TimeUnit timeUnit) throws InterruptedException {
        return this.delegate.awaitTermination(j11, timeUnit);
    }

    public void execute(@NonNull Runnable runnable) {
        this.delegate.execute(runnable);
    }

    @NonNull
    public <T> List<Future<T>> invokeAll(@NonNull Collection<? extends Callable<T>> collection) throws InterruptedException {
        return this.delegate.invokeAll(collection);
    }

    @NonNull
    public <T> T invokeAny(@NonNull Collection<? extends Callable<T>> collection) throws InterruptedException, ExecutionException {
        return this.delegate.invokeAny(collection);
    }

    public boolean isShutdown() {
        return this.delegate.isShutdown();
    }

    public boolean isTerminated() {
        return this.delegate.isTerminated();
    }

    public void shutdown() {
        this.delegate.shutdown();
    }

    @NonNull
    public List<Runnable> shutdownNow() {
        return this.delegate.shutdownNow();
    }

    @NonNull
    public Future<?> submit(@NonNull Runnable runnable) {
        return this.delegate.submit(runnable);
    }

    public String toString() {
        return this.delegate.toString();
    }

    @Deprecated
    public static GlideExecutor newAnimationExecutor(int i11, UncaughtThrowableStrategy uncaughtThrowableStrategy) {
        return newAnimationBuilder().setThreadCount(i11).setUncaughtThrowableStrategy(uncaughtThrowableStrategy).build();
    }

    @Deprecated
    public static GlideExecutor newDiskCacheExecutor(UncaughtThrowableStrategy uncaughtThrowableStrategy) {
        return newDiskCacheBuilder().setUncaughtThrowableStrategy(uncaughtThrowableStrategy).build();
    }

    @Deprecated
    public static GlideExecutor newSourceExecutor(UncaughtThrowableStrategy uncaughtThrowableStrategy) {
        return newSourceBuilder().setUncaughtThrowableStrategy(uncaughtThrowableStrategy).build();
    }

    @NonNull
    public <T> List<Future<T>> invokeAll(@NonNull Collection<? extends Callable<T>> collection, long j11, @NonNull TimeUnit timeUnit) throws InterruptedException {
        return this.delegate.invokeAll(collection, j11, timeUnit);
    }

    public <T> T invokeAny(@NonNull Collection<? extends Callable<T>> collection, long j11, @NonNull TimeUnit timeUnit) throws InterruptedException, ExecutionException, TimeoutException {
        return this.delegate.invokeAny(collection, j11, timeUnit);
    }

    @NonNull
    public <T> Future<T> submit(@NonNull Runnable runnable, T t11) {
        return this.delegate.submit(runnable, t11);
    }

    @Deprecated
    public static GlideExecutor newDiskCacheExecutor(int i11, String str, UncaughtThrowableStrategy uncaughtThrowableStrategy) {
        return newDiskCacheBuilder().setThreadCount(i11).setName(str).setUncaughtThrowableStrategy(uncaughtThrowableStrategy).build();
    }

    @Deprecated
    public static GlideExecutor newSourceExecutor(int i11, String str, UncaughtThrowableStrategy uncaughtThrowableStrategy) {
        return newSourceBuilder().setThreadCount(i11).setName(str).setUncaughtThrowableStrategy(uncaughtThrowableStrategy).build();
    }

    public <T> Future<T> submit(@NonNull Callable<T> callable) {
        return this.delegate.submit(callable);
    }
}
