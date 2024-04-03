package kotlinx.coroutines.scheduling;

import java.util.concurrent.Executor;
import java.util.concurrent.RejectedExecutionException;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.PublishedApi;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.DefaultExecutor;
import kotlinx.coroutines.ExecutorCoroutineDispatcher;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u0011\u0018\u00002\u00020\u0001B%\b\u0016\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007B\u001b\b\u0017\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\bB'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\n\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u000bJ\u0010\u0010\u0012\u001a\u00020\u00132\b\b\u0002\u0010\u0014\u001a\u00020\u0003J\b\u0010\u0015\u001a\u00020\u0016H\u0016J\b\u0010\u0017\u001a\u00020\rH\u0002J\u001c\u0010\u0018\u001a\u00020\u00162\u0006\u0010\u0019\u001a\u00020\u001a2\n\u0010\u001b\u001a\u00060\u001cj\u0002`\u001dH\u0016J)\u0010\u001e\u001a\u00020\u00162\n\u0010\u001b\u001a\u00060\u001cj\u0002`\u001d2\u0006\u0010\u0019\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020!H\u0000¢\u0006\u0002\b\"J\u001c\u0010#\u001a\u00020\u00162\u0006\u0010\u0019\u001a\u00020\u001a2\n\u0010\u001b\u001a\u00060\u001cj\u0002`\u001dH\u0016J\u000e\u0010$\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0003J\b\u0010%\u001a\u00020\u0006H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u000e\u001a\u00020\u000f8VX\u0004¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011R\u000e\u0010\t\u001a\u00020\nX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000¨\u0006&"}, d2 = {"Lkotlinx/coroutines/scheduling/ExperimentalCoroutineDispatcher;", "Lkotlinx/coroutines/ExecutorCoroutineDispatcher;", "corePoolSize", "", "maxPoolSize", "schedulerName", "", "(IILjava/lang/String;)V", "(II)V", "idleWorkerKeepAliveNs", "", "(IIJLjava/lang/String;)V", "coroutineScheduler", "Lkotlinx/coroutines/scheduling/CoroutineScheduler;", "executor", "Ljava/util/concurrent/Executor;", "getExecutor", "()Ljava/util/concurrent/Executor;", "blocking", "Lkotlinx/coroutines/CoroutineDispatcher;", "parallelism", "close", "", "createScheduler", "dispatch", "context", "Lkotlin/coroutines/CoroutineContext;", "block", "Ljava/lang/Runnable;", "Lkotlinx/coroutines/Runnable;", "dispatchWithContext", "Lkotlinx/coroutines/scheduling/TaskContext;", "tailDispatch", "", "dispatchWithContext$kotlinx_coroutines_core", "dispatchYield", "limited", "toString", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0}, xi = 48)
@PublishedApi
public class ExperimentalCoroutineDispatcher extends ExecutorCoroutineDispatcher {
    private final int corePoolSize;
    @NotNull
    private CoroutineScheduler coroutineScheduler;
    private final long idleWorkerKeepAliveNs;
    private final int maxPoolSize;
    @NotNull
    private final String schedulerName;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ ExperimentalCoroutineDispatcher(int i11, int i12, long j11, String str, int i13, DefaultConstructorMarker defaultConstructorMarker) {
        this(i11, i12, j11, (i13 & 8) != 0 ? "CoroutineScheduler" : str);
    }

    public static /* synthetic */ CoroutineDispatcher blocking$default(ExperimentalCoroutineDispatcher experimentalCoroutineDispatcher, int i11, int i12, Object obj) {
        if (obj == null) {
            if ((i12 & 1) != 0) {
                i11 = 16;
            }
            return experimentalCoroutineDispatcher.blocking(i11);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: blocking");
    }

    private final CoroutineScheduler createScheduler() {
        return new CoroutineScheduler(this.corePoolSize, this.maxPoolSize, this.idleWorkerKeepAliveNs, this.schedulerName);
    }

    @NotNull
    public final CoroutineDispatcher blocking(int i11) {
        boolean z11;
        if (i11 > 0) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (z11) {
            return new LimitingDispatcher(this, i11, (String) null, 1);
        }
        throw new IllegalArgumentException(("Expected positive parallelism level, but have " + i11).toString());
    }

    public void close() {
        this.coroutineScheduler.close();
    }

    public void dispatch(@NotNull CoroutineContext coroutineContext, @NotNull Runnable runnable) {
        try {
            CoroutineScheduler.dispatch$default(this.coroutineScheduler, runnable, (TaskContext) null, false, 6, (Object) null);
        } catch (RejectedExecutionException unused) {
            DefaultExecutor.INSTANCE.dispatch(coroutineContext, runnable);
        }
    }

    public final void dispatchWithContext$kotlinx_coroutines_core(@NotNull Runnable runnable, @NotNull TaskContext taskContext, boolean z11) {
        try {
            this.coroutineScheduler.dispatch(runnable, taskContext, z11);
        } catch (RejectedExecutionException unused) {
            DefaultExecutor.INSTANCE.enqueue(this.coroutineScheduler.createTask(runnable, taskContext));
        }
    }

    public void dispatchYield(@NotNull CoroutineContext coroutineContext, @NotNull Runnable runnable) {
        try {
            CoroutineScheduler.dispatch$default(this.coroutineScheduler, runnable, (TaskContext) null, true, 2, (Object) null);
        } catch (RejectedExecutionException unused) {
            DefaultExecutor.INSTANCE.dispatchYield(coroutineContext, runnable);
        }
    }

    @NotNull
    public Executor getExecutor() {
        return this.coroutineScheduler;
    }

    @NotNull
    public final CoroutineDispatcher limited(int i11) {
        boolean z11;
        boolean z12 = true;
        if (i11 > 0) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (z11) {
            if (i11 > this.corePoolSize) {
                z12 = false;
            }
            if (z12) {
                return new LimitingDispatcher(this, i11, (String) null, 0);
            }
            throw new IllegalArgumentException(("Expected parallelism level lesser than core pool size (" + this.corePoolSize + "), but have " + i11).toString());
        }
        throw new IllegalArgumentException(("Expected positive parallelism level, but have " + i11).toString());
    }

    @NotNull
    public String toString() {
        return super.toString() + "[scheduler = " + this.coroutineScheduler + AbstractJsonLexerKt.END_LIST;
    }

    public ExperimentalCoroutineDispatcher(int i11, int i12, long j11, @NotNull String str) {
        this.corePoolSize = i11;
        this.maxPoolSize = i12;
        this.idleWorkerKeepAliveNs = j11;
        this.schedulerName = str;
        this.coroutineScheduler = createScheduler();
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ ExperimentalCoroutineDispatcher(int i11, int i12, String str, int i13, DefaultConstructorMarker defaultConstructorMarker) {
        this((i13 & 1) != 0 ? TasksKt.CORE_POOL_SIZE : i11, (i13 & 2) != 0 ? TasksKt.MAX_POOL_SIZE : i12, (i13 & 4) != 0 ? TasksKt.DEFAULT_SCHEDULER_NAME : str);
    }

    public ExperimentalCoroutineDispatcher(int i11, int i12, @NotNull String str) {
        this(i11, i12, TasksKt.IDLE_WORKER_KEEP_ALIVE_NS, str);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ ExperimentalCoroutineDispatcher(int i11, int i12, int i13, DefaultConstructorMarker defaultConstructorMarker) {
        this((i13 & 1) != 0 ? TasksKt.CORE_POOL_SIZE : i11, (i13 & 2) != 0 ? TasksKt.MAX_POOL_SIZE : i12);
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Binary compatibility for Ktor 1.0-beta")
    public /* synthetic */ ExperimentalCoroutineDispatcher(int i11, int i12) {
        this(i11, i12, TasksKt.IDLE_WORKER_KEEP_ALIVE_NS, (String) null, 8, (DefaultConstructorMarker) null);
    }
}
