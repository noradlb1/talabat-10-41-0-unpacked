package kotlinx.coroutines;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Metadata;
import net.bytebuddy.jar.asm.signature.SignatureVisitor;
import org.jetbrains.annotations.NotNull;
import p00.a;

@Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u001a\u0018\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0007\u001a\u0010\u0010\u0006\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u0005H\u0007¨\u0006\u0007"}, d2 = {"newFixedThreadPoolContext", "Lkotlinx/coroutines/ExecutorCoroutineDispatcher;", "nThreads", "", "name", "", "newSingleThreadContext", "kotlinx-coroutines-core"}, k = 2, mv = {1, 6, 0}, xi = 48)
public final class ThreadPoolDispatcherKt {
    @NotNull
    @DelicateCoroutinesApi
    public static final ExecutorCoroutineDispatcher newFixedThreadPoolContext(int i11, @NotNull String str) {
        boolean z11 = true;
        if (i11 < 1) {
            z11 = false;
        }
        if (z11) {
            return ExecutorsKt.from((ExecutorService) Executors.newScheduledThreadPool(i11, new a(i11, str, new AtomicInteger())));
        }
        throw new IllegalArgumentException(("Expected at least one thread, but " + i11 + " specified").toString());
    }

    /* access modifiers changed from: private */
    /* renamed from: newFixedThreadPoolContext$lambda-1  reason: not valid java name */
    public static final Thread m7783newFixedThreadPoolContext$lambda1(int i11, String str, AtomicInteger atomicInteger, Runnable runnable) {
        if (i11 != 1) {
            str = str + SignatureVisitor.SUPER + atomicInteger.incrementAndGet();
        }
        Thread thread = new Thread(runnable, str);
        thread.setDaemon(true);
        return thread;
    }

    @NotNull
    @DelicateCoroutinesApi
    public static final ExecutorCoroutineDispatcher newSingleThreadContext(@NotNull String str) {
        return newFixedThreadPoolContext(1, str);
    }
}
