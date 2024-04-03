package androidx.work;

import android.annotation.SuppressLint;
import android.os.Build;
import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.work.impl.DefaultRunnableScheduler;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

public final class Configuration {
    @SuppressLint({"MinMaxConstant"})
    public static final int MIN_SCHEDULER_LIMIT = 20;
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    public final Executor f37956a;
    @NonNull

    /* renamed from: b  reason: collision with root package name */
    public final Executor f37957b;
    @NonNull

    /* renamed from: c  reason: collision with root package name */
    public final WorkerFactory f37958c;
    @NonNull

    /* renamed from: d  reason: collision with root package name */
    public final InputMergerFactory f37959d;
    @NonNull

    /* renamed from: e  reason: collision with root package name */
    public final RunnableScheduler f37960e;
    @Nullable

    /* renamed from: f  reason: collision with root package name */
    public final InitializationExceptionHandler f37961f;
    @Nullable

    /* renamed from: g  reason: collision with root package name */
    public final String f37962g;

    /* renamed from: h  reason: collision with root package name */
    public final int f37963h;

    /* renamed from: i  reason: collision with root package name */
    public final int f37964i;

    /* renamed from: j  reason: collision with root package name */
    public final int f37965j;

    /* renamed from: k  reason: collision with root package name */
    public final int f37966k;
    private final boolean mIsUsingDefaultTaskExecutor;

    public interface Provider {
        @NonNull
        Configuration getWorkManagerConfiguration();
    }

    public Configuration(@NonNull Builder builder) {
        Executor executor = builder.f37969a;
        if (executor == null) {
            this.f37956a = createDefaultExecutor(false);
        } else {
            this.f37956a = executor;
        }
        Executor executor2 = builder.f37972d;
        if (executor2 == null) {
            this.mIsUsingDefaultTaskExecutor = true;
            this.f37957b = createDefaultExecutor(true);
        } else {
            this.mIsUsingDefaultTaskExecutor = false;
            this.f37957b = executor2;
        }
        WorkerFactory workerFactory = builder.f37970b;
        if (workerFactory == null) {
            this.f37958c = WorkerFactory.getDefaultWorkerFactory();
        } else {
            this.f37958c = workerFactory;
        }
        InputMergerFactory inputMergerFactory = builder.f37971c;
        if (inputMergerFactory == null) {
            this.f37959d = InputMergerFactory.getDefaultInputMergerFactory();
        } else {
            this.f37959d = inputMergerFactory;
        }
        RunnableScheduler runnableScheduler = builder.f37973e;
        if (runnableScheduler == null) {
            this.f37960e = new DefaultRunnableScheduler();
        } else {
            this.f37960e = runnableScheduler;
        }
        this.f37963h = builder.f37976h;
        this.f37964i = builder.f37977i;
        this.f37965j = builder.f37978j;
        this.f37966k = builder.f37979k;
        this.f37961f = builder.f37974f;
        this.f37962g = builder.f37975g;
    }

    @NonNull
    private Executor createDefaultExecutor(boolean z11) {
        return Executors.newFixedThreadPool(Math.max(2, Math.min(Runtime.getRuntime().availableProcessors() - 1, 4)), createDefaultThreadFactory(z11));
    }

    @NonNull
    private ThreadFactory createDefaultThreadFactory(final boolean z11) {
        return new ThreadFactory() {
            private final AtomicInteger mThreadCount = new AtomicInteger(0);

            public Thread newThread(Runnable runnable) {
                String str;
                if (z11) {
                    str = "WM.task-";
                } else {
                    str = "androidx.work-";
                }
                return new Thread(runnable, str + this.mThreadCount.incrementAndGet());
            }
        };
    }

    @Nullable
    public String getDefaultProcessName() {
        return this.f37962g;
    }

    @Nullable
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public InitializationExceptionHandler getExceptionHandler() {
        return this.f37961f;
    }

    @NonNull
    public Executor getExecutor() {
        return this.f37956a;
    }

    @NonNull
    public InputMergerFactory getInputMergerFactory() {
        return this.f37959d;
    }

    public int getMaxJobSchedulerId() {
        return this.f37965j;
    }

    @IntRange(from = 20, to = 50)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public int getMaxSchedulerLimit() {
        if (Build.VERSION.SDK_INT == 23) {
            return this.f37966k / 2;
        }
        return this.f37966k;
    }

    public int getMinJobSchedulerId() {
        return this.f37964i;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public int getMinimumLoggingLevel() {
        return this.f37963h;
    }

    @NonNull
    public RunnableScheduler getRunnableScheduler() {
        return this.f37960e;
    }

    @NonNull
    public Executor getTaskExecutor() {
        return this.f37957b;
    }

    @NonNull
    public WorkerFactory getWorkerFactory() {
        return this.f37958c;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public boolean isUsingDefaultTaskExecutor() {
        return this.mIsUsingDefaultTaskExecutor;
    }

    public static final class Builder {

        /* renamed from: a  reason: collision with root package name */
        public Executor f37969a;

        /* renamed from: b  reason: collision with root package name */
        public WorkerFactory f37970b;

        /* renamed from: c  reason: collision with root package name */
        public InputMergerFactory f37971c;

        /* renamed from: d  reason: collision with root package name */
        public Executor f37972d;

        /* renamed from: e  reason: collision with root package name */
        public RunnableScheduler f37973e;
        @Nullable

        /* renamed from: f  reason: collision with root package name */
        public InitializationExceptionHandler f37974f;
        @Nullable

        /* renamed from: g  reason: collision with root package name */
        public String f37975g;

        /* renamed from: h  reason: collision with root package name */
        public int f37976h;

        /* renamed from: i  reason: collision with root package name */
        public int f37977i;

        /* renamed from: j  reason: collision with root package name */
        public int f37978j;

        /* renamed from: k  reason: collision with root package name */
        public int f37979k;

        public Builder() {
            this.f37976h = 4;
            this.f37977i = 0;
            this.f37978j = Integer.MAX_VALUE;
            this.f37979k = 20;
        }

        @NonNull
        public Configuration build() {
            return new Configuration(this);
        }

        @NonNull
        public Builder setDefaultProcessName(@NonNull String str) {
            this.f37975g = str;
            return this;
        }

        @NonNull
        public Builder setExecutor(@NonNull Executor executor) {
            this.f37969a = executor;
            return this;
        }

        @NonNull
        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
        public Builder setInitializationExceptionHandler(@NonNull InitializationExceptionHandler initializationExceptionHandler) {
            this.f37974f = initializationExceptionHandler;
            return this;
        }

        @NonNull
        public Builder setInputMergerFactory(@NonNull InputMergerFactory inputMergerFactory) {
            this.f37971c = inputMergerFactory;
            return this;
        }

        @NonNull
        public Builder setJobSchedulerJobIdRange(int i11, int i12) {
            if (i12 - i11 >= 1000) {
                this.f37977i = i11;
                this.f37978j = i12;
                return this;
            }
            throw new IllegalArgumentException("WorkManager needs a range of at least 1000 job ids.");
        }

        @NonNull
        public Builder setMaxSchedulerLimit(int i11) {
            if (i11 >= 20) {
                this.f37979k = Math.min(i11, 50);
                return this;
            }
            throw new IllegalArgumentException("WorkManager needs to be able to schedule at least 20 jobs in JobScheduler.");
        }

        @NonNull
        public Builder setMinimumLoggingLevel(int i11) {
            this.f37976h = i11;
            return this;
        }

        @NonNull
        public Builder setRunnableScheduler(@NonNull RunnableScheduler runnableScheduler) {
            this.f37973e = runnableScheduler;
            return this;
        }

        @NonNull
        public Builder setTaskExecutor(@NonNull Executor executor) {
            this.f37972d = executor;
            return this;
        }

        @NonNull
        public Builder setWorkerFactory(@NonNull WorkerFactory workerFactory) {
            this.f37970b = workerFactory;
            return this;
        }

        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
        public Builder(@NonNull Configuration configuration) {
            this.f37969a = configuration.f37956a;
            this.f37970b = configuration.f37958c;
            this.f37971c = configuration.f37959d;
            this.f37972d = configuration.f37957b;
            this.f37976h = configuration.f37963h;
            this.f37977i = configuration.f37964i;
            this.f37978j = configuration.f37965j;
            this.f37979k = configuration.f37966k;
            this.f37973e = configuration.f37960e;
            this.f37974f = configuration.f37961f;
            this.f37975g = configuration.f37962g;
        }
    }
}
