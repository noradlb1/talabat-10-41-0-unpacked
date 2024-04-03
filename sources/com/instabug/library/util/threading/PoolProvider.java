package com.instabug.library.util.threading;

import android.content.Context;
import android.os.Looper;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import com.instabug.library.Instabug;
import com.instabug.library.util.InstabugSDKLogger;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public class PoolProvider {
    private static PoolProvider INSTANCE;
    public static final int NUMBER_OF_CORES = Runtime.getRuntime().availableProcessors();
    private static final Map<String, k> monitoredSingleThreadExecutorMap = new HashMap();
    private static final Map<String, l> networkingSingleThreadExecutorhMap = new HashMap();
    private static final Map<String, ReturnableSingleThreadExecutor> returnableSingleThreadPoolExecutorhMap = new HashMap();
    /* access modifiers changed from: private */
    public static final Map<String, SingleThreadPoolExecutor> singleThreadPoolExecutorhMap = new HashMap();
    private final ThreadPoolExecutor forBitmapTasks;
    /* access modifiers changed from: private */
    public final ThreadPoolExecutor forComputationTasks;
    private final ThreadPoolExecutor forIOTasks;
    private final ScheduledThreadPoolExecutor forScheduledTasks;
    private final Executor mainThreadExecutor = new MainThreadExecutor();

    public class a implements Runnable {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ Runnable f52094b;

        public a(Runnable runnable) {
            this.f52094b = runnable;
        }

        public void run() {
            if (PoolProvider.getContext() != null) {
                try {
                    this.f52094b.run();
                } catch (OutOfMemoryError e11) {
                    InstabugSDKLogger.e("IBG-Core", "low memory, can't perform bitmap task", e11);
                }
            }
        }
    }

    public class b implements Runnable {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ Runnable f52095b;

        public b(Runnable runnable) {
            this.f52095b = runnable;
        }

        public void run() {
            if (PoolProvider.getContext() != null) {
                try {
                    this.f52095b.run();
                } catch (Throwable th2) {
                    if (th2 instanceof OutOfMemoryError) {
                        InstabugSDKLogger.e("IBG-Core", "low memory, can't run i/o task", th2);
                    } else {
                        InstabugSDKLogger.e("IBG-Core", "Error while running IO task", th2);
                    }
                }
            }
        }
    }

    public class c implements Runnable {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ Runnable f52096b;

        public c(Runnable runnable) {
            this.f52096b = runnable;
        }

        public void run() {
            if (PoolProvider.getContext() != null) {
                try {
                    PoolProvider.getInstance().forComputationTasks.execute(this.f52096b);
                } catch (OutOfMemoryError e11) {
                    InstabugSDKLogger.e("IBG-Core", "low memory, can't run computation task", e11);
                }
            }
        }
    }

    public class d implements Runnable {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ Runnable f52097b;

        public d(Runnable runnable) {
            this.f52097b = runnable;
        }

        public void run() {
            if (PoolProvider.getContext() != null) {
                try {
                    this.f52097b.run();
                } catch (OutOfMemoryError e11) {
                    InstabugSDKLogger.e("IBG-Core", "low memory, can't run delayed task", e11);
                }
            }
        }
    }

    public class e implements Runnable {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ Runnable f52098b;

        public e(Runnable runnable) {
            this.f52098b = runnable;
        }

        public void run() {
            try {
                this.f52098b.run();
            } catch (OutOfMemoryError e11) {
                InstabugSDKLogger.e("IBG-Core", "low memory, can't run main thread task", e11);
            }
        }
    }

    public class f implements Runnable {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ Runnable f52099b;

        public f(Runnable runnable) {
            this.f52099b = runnable;
        }

        public void run() {
            if (PoolProvider.getContext() != null) {
                try {
                    this.f52099b.run();
                } catch (OutOfMemoryError e11) {
                    InstabugSDKLogger.e("IBG-Core", "low memory, can't run main thread task", e11);
                }
            }
        }
    }

    public class g implements Runnable {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ Runnable f52100b;

        public g(Runnable runnable) {
            this.f52100b = runnable;
        }

        public void run() {
            if (PoolProvider.getContext() != null) {
                try {
                    this.f52100b.run();
                } catch (OutOfMemoryError e11) {
                    InstabugSDKLogger.e("IBG-Core", "low memory, can't run task", e11);
                }
            }
        }
    }

    public class h implements n {
        public void a(@Nullable String str) {
            if (str != null) {
                PoolProvider.singleThreadPoolExecutorhMap.remove(str);
            }
        }
    }

    public class i implements n {
        public void a(@Nullable String str) {
            if (str != null) {
                PoolProvider.singleThreadPoolExecutorhMap.remove(str);
            }
        }
    }

    private PoolProvider() {
        int i11 = NUMBER_OF_CORES;
        TimeUnit timeUnit = TimeUnit.SECONDS;
        this.forBitmapTasks = new ThreadPoolExecutor(i11, i11, 10, timeUnit, new LinkedBlockingQueue(), new PriorityThreadFactory("core-bitmap-executor", 10));
        int i12 = i11 * 2;
        this.forIOTasks = new ThreadPoolExecutor(i12, i12, 10, timeUnit, new LinkedBlockingQueue(), new PriorityThreadFactory("core-io-executor", 10));
        this.forComputationTasks = new ThreadPoolExecutor(1, 2, 10, timeUnit, new LinkedBlockingQueue(), new PriorityThreadFactory("core-computation-executor", 10));
        this.forScheduledTasks = new ScheduledThreadPoolExecutor(i12, new PriorityThreadFactory("core-scheduled-executor", 10));
    }

    public static ReturnableSingleThreadExecutor getApiExecutor() {
        return getReturnableSingleThreadExecutor("API-executor");
    }

    public static ReturnableSingleThreadExecutor getChatsCacheExecutor() {
        return getReturnableSingleThreadExecutor("chats-cache-executor");
    }

    @Nullable
    public static Context getContext() {
        try {
            return Instabug.getApplicationContext();
        } catch (IllegalStateException unused) {
            return null;
        }
    }

    public static k getDatabaseExecutor() {
        return getMonitoredSingleThreadExecutor("IBG-db-executor");
    }

    public static k getDiagnosticsDatabaseExecutor() {
        return getMonitoredSingleThreadExecutor("IBG-diagnostics-db-executor");
    }

    public static ReturnableSingleThreadExecutor getFilesEncryptionExecutor() {
        return getReturnableSingleThreadExecutor("Files-Encryption");
    }

    public static synchronized PoolProvider getInstance() {
        PoolProvider poolProvider;
        synchronized (PoolProvider.class) {
            if (INSTANCE == null) {
                synchronized (PoolProvider.class) {
                    INSTANCE = new PoolProvider();
                }
            }
            poolProvider = INSTANCE;
        }
        return poolProvider;
    }

    public static synchronized k getMonitoredSingleThreadExecutor(String str) {
        synchronized (PoolProvider.class) {
            Map<String, k> map = monitoredSingleThreadExecutorMap;
            if (map.containsKey(str)) {
                k kVar = map.get(str);
                return kVar;
            }
            k kVar2 = new k();
            map.put(str, kVar2);
            return kVar2;
        }
    }

    public static synchronized Executor getNetworkingSingleThreadExecutor(String str) {
        synchronized (PoolProvider.class) {
            Map<String, l> map = networkingSingleThreadExecutorhMap;
            if (map.containsKey(str)) {
                Executor executor = map.get(str);
                return executor;
            }
            l lVar = new l(str);
            lVar.setIdentifier(str).setThreadPoolIdleListener(new i());
            map.put(str, lVar);
            return lVar;
        }
    }

    public static synchronized ReturnableSingleThreadExecutor getReturnableSingleThreadExecutor(String str) {
        synchronized (PoolProvider.class) {
            Map<String, ReturnableSingleThreadExecutor> map = returnableSingleThreadPoolExecutorhMap;
            if (map.containsKey(str)) {
                ReturnableSingleThreadExecutor returnableSingleThreadExecutor = map.get(str);
                return returnableSingleThreadExecutor;
            }
            ReturnableSingleThreadExecutor returnableSingleThreadExecutor2 = new ReturnableSingleThreadExecutor(str);
            map.put(str, returnableSingleThreadExecutor2);
            return returnableSingleThreadExecutor2;
        }
    }

    public static synchronized Executor getSingleThreadExecutor(String str) {
        synchronized (PoolProvider.class) {
            Map<String, SingleThreadPoolExecutor> map = singleThreadPoolExecutorhMap;
            if (map.containsKey(str)) {
                Executor executor = map.get(str);
                return executor;
            }
            SingleThreadPoolExecutor singleThreadPoolExecutor = new SingleThreadPoolExecutor(str);
            singleThreadPoolExecutor.setIdentifier(str).setThreadPoolIdleListener(new h());
            map.put(str, singleThreadPoolExecutor);
            return singleThreadPoolExecutor;
        }
    }

    public static ReturnableSingleThreadExecutor getSurveysDBExecutor() {
        return getReturnableSingleThreadExecutor("surveys-db-executor");
    }

    public static synchronized Executor getSyncExecutor() {
        Executor singleThreadExecutor;
        synchronized (PoolProvider.class) {
            singleThreadExecutor = getSingleThreadExecutor("sync-Executor");
        }
        return singleThreadExecutor;
    }

    public static Executor getUserActionsExecutor() {
        return getSingleThreadExecutor("user-actions-executor");
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ void lambda$postDelayedTaskAtFixedDelay$0(Runnable runnable) {
        if (getContext() != null) {
            DefensiveRunnableKt.runDefensive(runnable).run();
        }
    }

    public static Executor newBackgroundExecutor(String str) {
        int i11 = NUMBER_OF_CORES * 2;
        return new ThreadPoolExecutor(i11, i11 + 1, 60, TimeUnit.SECONDS, new LinkedBlockingQueue(), new PriorityThreadFactory(str, 10));
    }

    public static void postBitmapTask(Runnable runnable) {
        getInstance().forBitmapTasks.execute(new a(runnable));
    }

    public static void postComputationTask(Runnable runnable) {
        getInstance().forComputationTasks.execute(new c(runnable));
    }

    public static void postDelayedTask(Runnable runnable, long j11) {
        getInstance().forScheduledTasks.schedule(new d(runnable), j11, TimeUnit.MILLISECONDS);
    }

    @NonNull
    public static ScheduledFuture<?> postDelayedTaskAtFixedDelay(long j11, long j12, @NonNull Runnable runnable) {
        return getInstance().forScheduledTasks.scheduleWithFixedDelay(new qd.a(runnable), j11, j12, TimeUnit.MILLISECONDS);
    }

    public static void postIOTask(Runnable runnable) {
        getInstance().forIOTasks.execute(new b(runnable));
    }

    public static void postIOTaskWithCheck(Runnable runnable) {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            postIOTask(runnable);
        } else {
            runnable.run();
        }
    }

    public static void postMainThreadTask(Runnable runnable) {
        getInstance().mainThreadExecutor.execute(new f(runnable));
    }

    public static void postMainThreadTaskWithoutCheck(Runnable runnable) {
        getInstance().mainThreadExecutor.execute(new e(runnable));
    }

    public static void postTask(Executor executor, Runnable runnable) {
        executor.execute(new g(runnable));
    }

    public static <T> Future<T> submitIOTask(Callable<T> callable) {
        return getInstance().forIOTasks.submit(callable);
    }

    public ThreadPoolExecutor getBackgroundExecutor() {
        return this.forIOTasks;
    }

    public ThreadPoolExecutor getIOExecutor() {
        return this.forIOTasks;
    }

    public ScheduledExecutorService getScheduledExecutor() {
        return this.forScheduledTasks;
    }
}
