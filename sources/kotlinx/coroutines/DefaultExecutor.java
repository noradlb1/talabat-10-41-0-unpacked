package kotlinx.coroutines;

import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.LockSupport;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;
import kotlinx.coroutines.EventLoopImplBase;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0011\bÀ\u0002\u0018\u00002\u00020\u00012\u00060\u0002j\u0002`\u0003B\t\b\u0002¢\u0006\u0004\b8\u0010\u001bJ\b\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\u0007\u001a\u00020\u0006H\u0002J\b\u0010\t\u001a\u00020\bH\u0002J\b\u0010\n\u001a\u00020\u0004H\u0002J\u0014\u0010\f\u001a\u00020\u00042\n\u0010\u000b\u001a\u00060\u0002j\u0002`\u0003H\u0016J\u0018\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u000fH\u0014J\b\u0010\u0012\u001a\u00020\u0004H\u0016J$\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0013\u001a\u00020\r2\n\u0010\u0014\u001a\u00060\u0002j\u0002`\u00032\u0006\u0010\u0016\u001a\u00020\u0015H\u0016J\b\u0010\u0019\u001a\u00020\u0004H\u0016J\u000f\u0010\u001c\u001a\u00020\u0004H\u0000¢\u0006\u0004\b\u001a\u0010\u001bJ\u000e\u0010\u001e\u001a\u00020\u00042\u0006\u0010\u001d\u001a\u00020\rR\u0014\u0010 \u001a\u00020\u001f8\u0006XT¢\u0006\u0006\n\u0004\b \u0010!R\u0014\u0010\"\u001a\u00020\r8\u0002XT¢\u0006\u0006\n\u0004\b\"\u0010#R\u0014\u0010$\u001a\u00020\r8\u0002X\u0004¢\u0006\u0006\n\u0004\b$\u0010#R\u001e\u0010%\u001a\u0004\u0018\u00010\u00068\u0002@\u0002X\u000e¢\u0006\f\n\u0004\b%\u0010&\u0012\u0004\b'\u0010\u001bR\u0014\u0010)\u001a\u00020(8\u0002XT¢\u0006\u0006\n\u0004\b)\u0010*R\u0014\u0010+\u001a\u00020(8\u0002XT¢\u0006\u0006\n\u0004\b+\u0010*R\u0014\u0010,\u001a\u00020(8\u0002XT¢\u0006\u0006\n\u0004\b,\u0010*R\u0014\u0010-\u001a\u00020(8\u0002XT¢\u0006\u0006\n\u0004\b-\u0010*R\u0014\u0010.\u001a\u00020(8\u0002XT¢\u0006\u0006\n\u0004\b.\u0010*R\u0016\u0010/\u001a\u00020(8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b/\u0010*R\u0014\u00100\u001a\u00020\b8BX\u0004¢\u0006\u0006\u001a\u0004\b0\u00101R\u0014\u00102\u001a\u00020\b8BX\u0004¢\u0006\u0006\u001a\u0004\b2\u00101R\u0014\u00105\u001a\u00020\u00068TX\u0004¢\u0006\u0006\u001a\u0004\b3\u00104R\u0014\u00107\u001a\u00020\b8@X\u0004¢\u0006\u0006\u001a\u0004\b6\u00101¨\u00069"}, d2 = {"Lkotlinx/coroutines/DefaultExecutor;", "Lkotlinx/coroutines/EventLoopImplBase;", "Ljava/lang/Runnable;", "Lkotlinx/coroutines/Runnable;", "", "shutdownError", "Ljava/lang/Thread;", "createThreadSync", "", "notifyStartup", "acknowledgeShutdownIfNeeded", "task", "enqueue", "", "now", "Lkotlinx/coroutines/EventLoopImplBase$DelayedTask;", "delayedTask", "c", "shutdown", "timeMillis", "block", "Lkotlin/coroutines/CoroutineContext;", "context", "Lkotlinx/coroutines/DisposableHandle;", "invokeOnTimeout", "run", "ensureStarted$kotlinx_coroutines_core", "()V", "ensureStarted", "timeout", "shutdownForTests", "", "THREAD_NAME", "Ljava/lang/String;", "DEFAULT_KEEP_ALIVE_MS", "J", "KEEP_ALIVE_NANOS", "_thread", "Ljava/lang/Thread;", "get_thread$annotations", "", "FRESH", "I", "ACTIVE", "SHUTDOWN_REQ", "SHUTDOWN_ACK", "SHUTDOWN", "debugStatus", "isShutDown", "()Z", "isShutdownRequested", "b", "()Ljava/lang/Thread;", "thread", "isThreadPresent$kotlinx_coroutines_core", "isThreadPresent", "<init>", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0})
public final class DefaultExecutor extends EventLoopImplBase implements Runnable {
    private static final int ACTIVE = 1;
    private static final long DEFAULT_KEEP_ALIVE_MS = 1000;
    private static final int FRESH = 0;
    @NotNull
    public static final DefaultExecutor INSTANCE;
    private static final long KEEP_ALIVE_NANOS;
    private static final int SHUTDOWN = 4;
    private static final int SHUTDOWN_ACK = 3;
    private static final int SHUTDOWN_REQ = 2;
    @NotNull
    public static final String THREAD_NAME = "kotlinx.coroutines.DefaultExecutor";
    @Nullable
    private static volatile Thread _thread;
    private static volatile int debugStatus;

    static {
        Long l11;
        DefaultExecutor defaultExecutor = new DefaultExecutor();
        INSTANCE = defaultExecutor;
        EventLoop.incrementUseCount$default(defaultExecutor, false, 1, (Object) null);
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        try {
            l11 = Long.getLong("kotlinx.coroutines.DefaultExecutor.keepAlive", 1000);
        } catch (SecurityException unused) {
            l11 = 1000L;
        }
        KEEP_ALIVE_NANOS = timeUnit.toNanos(l11.longValue());
    }

    private DefaultExecutor() {
    }

    private final synchronized void acknowledgeShutdownIfNeeded() {
        if (isShutdownRequested()) {
            debugStatus = 3;
            f();
            notifyAll();
        }
    }

    private final synchronized Thread createThreadSync() {
        Thread thread;
        thread = _thread;
        if (thread == null) {
            thread = new Thread(this, THREAD_NAME);
            _thread = thread;
            thread.setDaemon(true);
            thread.start();
        }
        return thread;
    }

    private static /* synthetic */ void get_thread$annotations() {
    }

    private final boolean isShutDown() {
        return debugStatus == 4;
    }

    private final boolean isShutdownRequested() {
        int i11 = debugStatus;
        return i11 == 2 || i11 == 3;
    }

    private final synchronized boolean notifyStartup() {
        if (isShutdownRequested()) {
            return false;
        }
        debugStatus = 1;
        notifyAll();
        return true;
    }

    private final void shutdownError() {
        throw new RejectedExecutionException("DefaultExecutor was shut down. This error indicates that Dispatchers.shutdown() was invoked prior to completion of exiting coroutines, leaving coroutines in incomplete state. Please refer to Dispatchers.shutdown documentation for more details");
    }

    @NotNull
    public Thread b() {
        Thread thread = _thread;
        return thread == null ? createThreadSync() : thread;
    }

    public void c(long j11, @NotNull EventLoopImplBase.DelayedTask delayedTask) {
        shutdownError();
    }

    public void enqueue(@NotNull Runnable runnable) {
        if (isShutDown()) {
            shutdownError();
        }
        super.enqueue(runnable);
    }

    public final synchronized void ensureStarted$kotlinx_coroutines_core() {
        debugStatus = 0;
        createThreadSync();
        while (debugStatus == 0) {
            wait();
        }
    }

    @NotNull
    public DisposableHandle invokeOnTimeout(long j11, @NotNull Runnable runnable, @NotNull CoroutineContext coroutineContext) {
        return g(j11, runnable);
    }

    public final boolean isThreadPresent$kotlinx_coroutines_core() {
        return _thread != null;
    }

    public void run() {
        Unit unit;
        long j11;
        ThreadLocalEventLoop.INSTANCE.setEventLoop$kotlinx_coroutines_core(this);
        AbstractTimeSource timeSource = AbstractTimeSourceKt.getTimeSource();
        if (timeSource != null) {
            timeSource.registerTimeLoopThread();
        }
        try {
            if (notifyStartup()) {
                long j12 = Long.MAX_VALUE;
                while (true) {
                    Thread.interrupted();
                    long processNextEvent = processNextEvent();
                    if (processNextEvent == Long.MAX_VALUE) {
                        AbstractTimeSource timeSource2 = AbstractTimeSourceKt.getTimeSource();
                        if (timeSource2 != null) {
                            j11 = timeSource2.nanoTime();
                        } else {
                            j11 = System.nanoTime();
                        }
                        if (j12 == Long.MAX_VALUE) {
                            j12 = KEEP_ALIVE_NANOS + j11;
                        }
                        long j13 = j12 - j11;
                        if (j13 <= 0) {
                            _thread = null;
                            acknowledgeShutdownIfNeeded();
                            AbstractTimeSource timeSource3 = AbstractTimeSourceKt.getTimeSource();
                            if (timeSource3 != null) {
                                timeSource3.unregisterTimeLoopThread();
                            }
                            if (!e()) {
                                b();
                                return;
                            }
                            return;
                        }
                        processNextEvent = RangesKt___RangesKt.coerceAtMost(processNextEvent, j13);
                    } else {
                        j12 = Long.MAX_VALUE;
                    }
                    if (processNextEvent > 0) {
                        if (isShutdownRequested()) {
                            _thread = null;
                            acknowledgeShutdownIfNeeded();
                            AbstractTimeSource timeSource4 = AbstractTimeSourceKt.getTimeSource();
                            if (timeSource4 != null) {
                                timeSource4.unregisterTimeLoopThread();
                            }
                            if (!e()) {
                                b();
                                return;
                            }
                            return;
                        }
                        AbstractTimeSource timeSource5 = AbstractTimeSourceKt.getTimeSource();
                        if (timeSource5 != null) {
                            timeSource5.parkNanos(this, processNextEvent);
                            unit = Unit.INSTANCE;
                        } else {
                            unit = null;
                        }
                        if (unit == null) {
                            LockSupport.parkNanos(this, processNextEvent);
                        }
                    }
                }
            }
        } finally {
            _thread = null;
            acknowledgeShutdownIfNeeded();
            AbstractTimeSource timeSource6 = AbstractTimeSourceKt.getTimeSource();
            if (timeSource6 != null) {
                timeSource6.unregisterTimeLoopThread();
            }
            if (!e()) {
                b();
            }
        }
    }

    public void shutdown() {
        debugStatus = 4;
        super.shutdown();
    }

    public final synchronized void shutdownForTests(long j11) {
        Unit unit;
        long currentTimeMillis = System.currentTimeMillis() + j11;
        if (!isShutdownRequested()) {
            debugStatus = 2;
        }
        while (debugStatus != 3 && _thread != null) {
            Thread thread = _thread;
            if (thread != null) {
                AbstractTimeSource timeSource = AbstractTimeSourceKt.getTimeSource();
                if (timeSource != null) {
                    timeSource.unpark(thread);
                    unit = Unit.INSTANCE;
                } else {
                    unit = null;
                }
                if (unit == null) {
                    LockSupport.unpark(thread);
                }
            }
            if (currentTimeMillis - System.currentTimeMillis() <= 0) {
                break;
            }
            wait(j11);
        }
        debugStatus = 0;
    }
}
