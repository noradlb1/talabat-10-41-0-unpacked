package com.instabug.commons.snapshot;

import ec.a;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import kotlin.Lazy;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public abstract class d implements Captor {
    @NotNull
    public static final a Companion = new a((DefaultConstructorMarker) null);
    @NotNull
    private static final String EXECUTOR_NAME_SUFFIX = "CaptorExecutor";
    /* access modifiers changed from: private */
    @NotNull
    public final Function1<String, ScheduledExecutorService> executorFactory;
    @NotNull
    private final Lazy scheduledExecutor$delegate = LazyKt__LazyJVMKt.lazy(new c(this));
    @Nullable
    private ScheduledFuture<?> scheduledJob;

    public d(@NotNull Function1 function1) {
        Intrinsics.checkNotNullParameter(function1, "executorFactory");
        this.executorFactory = function1;
    }

    private final boolean a() {
        ScheduledFuture<?> scheduledFuture = this.scheduledJob;
        return !(scheduledFuture == null ? true : scheduledFuture.isCancelled());
    }

    public abstract void c();

    @NotNull
    public abstract String d();

    public abstract long e();

    @NotNull
    public final ScheduledExecutorService f() {
        return (ScheduledExecutorService) this.scheduledExecutor$delegate.getValue();
    }

    public final void force() {
        synchronized (this) {
            if (!isShutdown()) {
                try {
                    Result.Companion companion = Result.Companion;
                    g();
                    f().execute(new a(this));
                    Result.m6329constructorimpl(Unit.INSTANCE);
                } catch (Throwable th2) {
                    Result.Companion companion2 = Result.Companion;
                    Result.m6329constructorimpl(ResultKt.createFailure(th2));
                }
                Unit unit = Unit.INSTANCE;
            }
        }
    }

    public final boolean g() {
        if (!a() || isShutdown()) {
            return false;
        }
        ScheduledFuture<?> scheduledFuture = this.scheduledJob;
        if (scheduledFuture != null) {
            scheduledFuture.cancel(true);
        }
        this.scheduledJob = null;
        return true;
    }

    public final boolean h(long j11) {
        if (a() || isShutdown()) {
            return false;
        }
        this.scheduledJob = a(f(), new b(this), j11);
        return true;
    }

    public void i() {
    }

    public final boolean isShutdown() {
        return f().isShutdown();
    }

    public void j() {
    }

    public final void shutdown() {
        synchronized (this) {
            if (!isShutdown()) {
                try {
                    Result.Companion companion = Result.Companion;
                    i();
                    Result.m6329constructorimpl(Unit.INSTANCE);
                } catch (Throwable th2) {
                    Result.Companion companion2 = Result.Companion;
                    Result.m6329constructorimpl(ResultKt.createFailure(th2));
                }
                try {
                    g();
                    Result.m6329constructorimpl(f().shutdownNow());
                } catch (Throwable th3) {
                    Result.Companion companion3 = Result.Companion;
                    Result.m6329constructorimpl(ResultKt.createFailure(th3));
                }
                Unit unit = Unit.INSTANCE;
                return;
            }
            return;
        }
    }

    public final void start() {
        synchronized (this) {
            if (h(0)) {
                j();
                Unit unit = Unit.INSTANCE;
            }
        }
    }

    /* access modifiers changed from: private */
    public static final void a(d dVar) {
        Intrinsics.checkNotNullParameter(dVar, "$this_runCatching");
        dVar.c();
        dVar.h(dVar.e());
    }

    private final ScheduledFuture a(ScheduledExecutorService scheduledExecutorService, Runnable runnable, long j11) {
        return scheduledExecutorService.scheduleAtFixedRate(runnable, j11, e(), TimeUnit.SECONDS);
    }
}
