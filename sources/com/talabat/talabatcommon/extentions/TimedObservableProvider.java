package com.talabat.talabatcommon.extentions;

import io.reactivex.Scheduler;
import io.reactivex.schedulers.Schedulers;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0005\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003J\u0011\u0010\u0004\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u0005H\u0004J\u0017\u0010\u001e\u001a\u00020\u001c2\f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00028\u00000\u000bH\u0004J\u0011\u0010\u0010\u001a\u00020\u001c2\u0006\u0010 \u001a\u00020\u0011H\u0004J\u0011\u0010\u0016\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u0017H\u0004R\u001a\u0010\u0004\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR \u0010\n\u001a\b\u0012\u0004\u0012\u00028\u00000\u000bX.¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0010\u001a\u00020\u0011X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001a\u0010\u0016\u001a\u00020\u0017X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001b¨\u0006!"}, d2 = {"Lcom/talabat/talabatcommon/extentions/TimedObservableProvider;", "T", "", "()V", "interval", "", "getInterval$com_talabat_NewArchi_TalabatCommon_TalabatCommon", "()J", "setInterval$com_talabat_NewArchi_TalabatCommon_TalabatCommon", "(J)V", "provideWith", "Lkotlin/Function0;", "getProvideWith$com_talabat_NewArchi_TalabatCommon_TalabatCommon", "()Lkotlin/jvm/functions/Function0;", "setProvideWith$com_talabat_NewArchi_TalabatCommon_TalabatCommon", "(Lkotlin/jvm/functions/Function0;)V", "scheduler", "Lio/reactivex/Scheduler;", "getScheduler$com_talabat_NewArchi_TalabatCommon_TalabatCommon", "()Lio/reactivex/Scheduler;", "setScheduler$com_talabat_NewArchi_TalabatCommon_TalabatCommon", "(Lio/reactivex/Scheduler;)V", "timeUnit", "Ljava/util/concurrent/TimeUnit;", "getTimeUnit$com_talabat_NewArchi_TalabatCommon_TalabatCommon", "()Ljava/util/concurrent/TimeUnit;", "setTimeUnit$com_talabat_NewArchi_TalabatCommon_TalabatCommon", "(Ljava/util/concurrent/TimeUnit;)V", "", "value", "provider", "valueProvider", "backgroundScheduler", "com_talabat_NewArchi_TalabatCommon_TalabatCommon"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class TimedObservableProvider<T> {
    private long interval = 500;
    public Function0<? extends T> provideWith;
    @NotNull
    private Scheduler scheduler;
    @NotNull
    private TimeUnit timeUnit = TimeUnit.MILLISECONDS;

    public TimedObservableProvider() {
        Scheduler computation = Schedulers.computation();
        Intrinsics.checkNotNullExpressionValue(computation, "computation()");
        this.scheduler = computation;
    }

    public final long getInterval$com_talabat_NewArchi_TalabatCommon_TalabatCommon() {
        return this.interval;
    }

    @NotNull
    public final Function0<T> getProvideWith$com_talabat_NewArchi_TalabatCommon_TalabatCommon() {
        Function0<? extends T> function0 = this.provideWith;
        if (function0 != null) {
            return function0;
        }
        Intrinsics.throwUninitializedPropertyAccessException("provideWith");
        return null;
    }

    @NotNull
    public final Scheduler getScheduler$com_talabat_NewArchi_TalabatCommon_TalabatCommon() {
        return this.scheduler;
    }

    @NotNull
    public final TimeUnit getTimeUnit$com_talabat_NewArchi_TalabatCommon_TalabatCommon() {
        return this.timeUnit;
    }

    @RxDsl
    public final void interval(long j11) {
        this.interval = j11;
    }

    @RxDsl
    public final void provider(@NotNull Function0<? extends T> function0) {
        Intrinsics.checkNotNullParameter(function0, "valueProvider");
        setProvideWith$com_talabat_NewArchi_TalabatCommon_TalabatCommon(function0);
    }

    @RxDsl
    public final void scheduler(@NotNull Scheduler scheduler2) {
        Intrinsics.checkNotNullParameter(scheduler2, "backgroundScheduler");
        this.scheduler = scheduler2;
    }

    public final void setInterval$com_talabat_NewArchi_TalabatCommon_TalabatCommon(long j11) {
        this.interval = j11;
    }

    public final void setProvideWith$com_talabat_NewArchi_TalabatCommon_TalabatCommon(@NotNull Function0<? extends T> function0) {
        Intrinsics.checkNotNullParameter(function0, "<set-?>");
        this.provideWith = function0;
    }

    public final void setScheduler$com_talabat_NewArchi_TalabatCommon_TalabatCommon(@NotNull Scheduler scheduler2) {
        Intrinsics.checkNotNullParameter(scheduler2, "<set-?>");
        this.scheduler = scheduler2;
    }

    public final void setTimeUnit$com_talabat_NewArchi_TalabatCommon_TalabatCommon(@NotNull TimeUnit timeUnit2) {
        Intrinsics.checkNotNullParameter(timeUnit2, "<set-?>");
        this.timeUnit = timeUnit2;
    }

    @RxDsl
    public final void timeUnit(@NotNull TimeUnit timeUnit2) {
        Intrinsics.checkNotNullParameter(timeUnit2, "value");
        this.timeUnit = timeUnit2;
    }
}
