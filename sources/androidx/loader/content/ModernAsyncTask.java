package androidx.loader.content;

import android.os.Binder;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.Process;
import android.util.Log;
import androidx.annotation.RestrictTo;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.FutureTask;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

abstract class ModernAsyncTask<Params, Progress, Result> {
    private static final int CORE_POOL_SIZE = 5;
    private static final int KEEP_ALIVE = 1;
    private static final String LOG_TAG = "AsyncTask";
    private static final int MAXIMUM_POOL_SIZE = 128;
    private static final int MESSAGE_POST_PROGRESS = 2;
    private static final int MESSAGE_POST_RESULT = 1;
    public static final Executor THREAD_POOL_EXECUTOR;
    private static volatile Executor sDefaultExecutor;
    private static InternalHandler sHandler;
    private static final BlockingQueue<Runnable> sPoolWorkQueue;
    private static final ThreadFactory sThreadFactory;

    /* renamed from: b  reason: collision with root package name */
    public final AtomicBoolean f36159b = new AtomicBoolean();

    /* renamed from: c  reason: collision with root package name */
    public final AtomicBoolean f36160c = new AtomicBoolean();
    private final FutureTask<Result> mFuture;
    private volatile Status mStatus = Status.PENDING;
    private final WorkerRunnable<Params, Result> mWorker;

    /* renamed from: androidx.loader.content.ModernAsyncTask$4  reason: invalid class name */
    public static /* synthetic */ class AnonymousClass4 {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f36163a;

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|6) */
        /* JADX WARNING: Code restructure failed: missing block: B:7:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        static {
            /*
                androidx.loader.content.ModernAsyncTask$Status[] r0 = androidx.loader.content.ModernAsyncTask.Status.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f36163a = r0
                androidx.loader.content.ModernAsyncTask$Status r1 = androidx.loader.content.ModernAsyncTask.Status.RUNNING     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f36163a     // Catch:{ NoSuchFieldError -> 0x001d }
                androidx.loader.content.ModernAsyncTask$Status r1 = androidx.loader.content.ModernAsyncTask.Status.FINISHED     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.loader.content.ModernAsyncTask.AnonymousClass4.<clinit>():void");
        }
    }

    public static class AsyncTaskResult<Data> {

        /* renamed from: a  reason: collision with root package name */
        public final ModernAsyncTask f36164a;

        /* renamed from: b  reason: collision with root package name */
        public final Data[] f36165b;

        public AsyncTaskResult(ModernAsyncTask modernAsyncTask, Data... dataArr) {
            this.f36164a = modernAsyncTask;
            this.f36165b = dataArr;
        }
    }

    public static class InternalHandler extends Handler {
        public InternalHandler() {
            super(Looper.getMainLooper());
        }

        public void handleMessage(Message message) {
            AsyncTaskResult asyncTaskResult = (AsyncTaskResult) message.obj;
            int i11 = message.what;
            if (i11 == 1) {
                asyncTaskResult.f36164a.b(asyncTaskResult.f36165b[0]);
            } else if (i11 == 2) {
                asyncTaskResult.f36164a.g(asyncTaskResult.f36165b);
            }
        }
    }

    public enum Status {
        PENDING,
        RUNNING,
        FINISHED
    }

    public static abstract class WorkerRunnable<Params, Result> implements Callable<Result> {

        /* renamed from: b  reason: collision with root package name */
        public Params[] f36166b;
    }

    static {
        AnonymousClass1 r72 = new ThreadFactory() {
            private final AtomicInteger mCount = new AtomicInteger(1);

            public Thread newThread(Runnable runnable) {
                return new Thread(runnable, "ModernAsyncTask #" + this.mCount.getAndIncrement());
            }
        };
        sThreadFactory = r72;
        LinkedBlockingQueue linkedBlockingQueue = new LinkedBlockingQueue(10);
        sPoolWorkQueue = linkedBlockingQueue;
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(5, 128, 1, TimeUnit.SECONDS, linkedBlockingQueue, r72);
        THREAD_POOL_EXECUTOR = threadPoolExecutor;
        sDefaultExecutor = threadPoolExecutor;
    }

    public ModernAsyncTask() {
        AnonymousClass2 r02 = new WorkerRunnable<Params, Result>() {
            public Result call() throws Exception {
                ModernAsyncTask.this.f36160c.set(true);
                Result result = null;
                try {
                    Process.setThreadPriority(10);
                    result = ModernAsyncTask.this.a(this.f36166b);
                    Binder.flushPendingCommands();
                    ModernAsyncTask.this.h(result);
                    return result;
                } catch (Throwable th2) {
                    ModernAsyncTask.this.h(result);
                    throw th2;
                }
            }
        };
        this.mWorker = r02;
        this.mFuture = new FutureTask<Result>(r02) {
            public void done() {
                try {
                    ModernAsyncTask.this.i(get());
                } catch (InterruptedException e11) {
                    Log.w(ModernAsyncTask.LOG_TAG, e11);
                } catch (ExecutionException e12) {
                    throw new RuntimeException("An error occurred while executing doInBackground()", e12.getCause());
                } catch (CancellationException unused) {
                    ModernAsyncTask.this.i(null);
                } catch (Throwable th2) {
                    throw new RuntimeException("An error occurred while executing doInBackground()", th2);
                }
            }
        };
    }

    private static Handler getHandler() {
        InternalHandler internalHandler;
        synchronized (ModernAsyncTask.class) {
            if (sHandler == null) {
                sHandler = new InternalHandler();
            }
            internalHandler = sHandler;
        }
        return internalHandler;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public static void setDefaultExecutor(Executor executor) {
        sDefaultExecutor = executor;
    }

    public abstract Result a(Params... paramsArr);

    public void b(Result result) {
        if (isCancelled()) {
            d(result);
        } else {
            e(result);
        }
        this.mStatus = Status.FINISHED;
    }

    public void c() {
    }

    public final boolean cancel(boolean z11) {
        this.f36159b.set(true);
        return this.mFuture.cancel(z11);
    }

    public void d(Result result) {
        c();
    }

    public void e(Result result) {
    }

    public final ModernAsyncTask<Params, Progress, Result> execute(Params... paramsArr) {
        return executeOnExecutor(sDefaultExecutor, paramsArr);
    }

    public final ModernAsyncTask<Params, Progress, Result> executeOnExecutor(Executor executor, Params... paramsArr) {
        if (this.mStatus != Status.PENDING) {
            int i11 = AnonymousClass4.f36163a[this.mStatus.ordinal()];
            if (i11 == 1) {
                throw new IllegalStateException("Cannot execute task: the task is already running.");
            } else if (i11 != 2) {
                throw new IllegalStateException("We should never reach this state");
            } else {
                throw new IllegalStateException("Cannot execute task: the task has already been executed (a task can be executed only once)");
            }
        } else {
            this.mStatus = Status.RUNNING;
            f();
            this.mWorker.f36166b = paramsArr;
            executor.execute(this.mFuture);
            return this;
        }
    }

    public void f() {
    }

    public void g(Progress... progressArr) {
    }

    public final Result get() throws InterruptedException, ExecutionException {
        return this.mFuture.get();
    }

    public final Status getStatus() {
        return this.mStatus;
    }

    public Result h(Result result) {
        getHandler().obtainMessage(1, new AsyncTaskResult(this, result)).sendToTarget();
        return result;
    }

    public void i(Result result) {
        if (!this.f36160c.get()) {
            h(result);
        }
    }

    public final boolean isCancelled() {
        return this.f36159b.get();
    }

    public static void execute(Runnable runnable) {
        sDefaultExecutor.execute(runnable);
    }

    public final Result get(long j11, TimeUnit timeUnit) throws InterruptedException, ExecutionException, TimeoutException {
        return this.mFuture.get(j11, timeUnit);
    }
}
