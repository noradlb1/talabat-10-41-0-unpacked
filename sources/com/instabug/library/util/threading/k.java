package com.instabug.library.util.threading;

import com.instabug.library.apichecker.ReturnableRunnable;
import com.instabug.library.internal.servicelocator.CoreServiceLocator;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class k extends ReturnableSingleThreadExecutor {
    @NotNull

    /* renamed from: a  reason: collision with root package name */
    private final e f52112a;

    public k() {
        this((e) null, 1, (DefaultConstructorMarker) null);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ k(e eVar, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this((i11 & 1) != 0 ? CoreServiceLocator.INSTANCE.getQueueMonitoringHelper() : eVar);
    }

    public void afterExecute(@Nullable Runnable runnable, @Nullable Throwable th2) {
        int i11;
        super.afterExecute(runnable, th2);
        e eVar = this.f52112a;
        if (runnable == null) {
            i11 = 0;
        } else {
            i11 = runnable.hashCode();
        }
        eVar.a(String.valueOf(i11));
    }

    public void beforeExecute(@Nullable Thread thread, @Nullable Runnable runnable) {
        String str;
        super.beforeExecute(thread, runnable);
        e eVar = this.f52112a;
        if (runnable == null) {
            str = null;
        } else {
            str = Integer.valueOf(runnable.hashCode()).toString();
        }
        eVar.b(str);
    }

    public void execute(@Nullable Runnable runnable) {
        int i11;
        e eVar = this.f52112a;
        if (runnable == null) {
            i11 = 0;
        } else {
            i11 = runnable.hashCode();
        }
        eVar.c(String.valueOf(i11));
        super.execute(DefensiveRunnableKt.runDefensive(runnable));
    }

    @Nullable
    public Object executeAndGet(@Nullable ReturnableRunnable returnableRunnable) {
        int i11;
        e eVar = this.f52112a;
        if (returnableRunnable == null) {
            i11 = 0;
        } else {
            i11 = returnableRunnable.hashCode();
        }
        eVar.c(String.valueOf(i11));
        return super.executeAndGet(returnableRunnable);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public k(@NotNull e eVar) {
        super("monitored-single-executor", 15, TimeUnit.SECONDS, new LinkedBlockingQueue(), new PriorityThreadFactory("monitored-single-executor", 10));
        Intrinsics.checkNotNullParameter(eVar, "monitoringHelper");
        this.f52112a = eVar;
    }
}
