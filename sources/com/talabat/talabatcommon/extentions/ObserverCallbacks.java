package com.talabat.talabatcommon.extentions;

import io.reactivex.Scheduler;
import kotlin.Lazy;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000*\u0004\b\u0000\u0010\u0001*\u0004\b\u0001\u0010\u00022\u00020\u0003B\u0007\b\u0000¢\u0006\u0002\u0010\u0004J\u0017\u0010%\u001a\u00020\u000b2\f\u0010&\u001a\b\u0012\u0004\u0012\u00020\u000b0\nH\u0004J\u001d\u0010'\u001a\u00020\u000b2\u0012\u0010&\u001a\u000e\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u000b0\u0011H\u0004J\u001d\u0010(\u001a\u00020\u000b2\u0012\u0010&\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u000b0\u0011H\u0004J\u0011\u0010\u001a\u001a\u00020\u000b2\u0006\u0010\u001a\u001a\u00020\u001cH\u0004J\"\u0010)\u001a\u00020\u000b2\u0017\u0010!\u001a\u0013\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00010\u0011¢\u0006\u0002\b\"H\u0004R(\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00008\u0006X\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0006\u0010\u0004\u001a\u0004\b\u0007\u0010\bR \u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR&\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u000b0\u0011X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R&\u0010\u0017\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u000b0\u0011X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0014\"\u0004\b\u0019\u0010\u0016R \u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u001c0\u001bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R+\u0010!\u001a\u0013\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00010\u0011¢\u0006\u0002\b\"X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010\u0014\"\u0004\b$\u0010\u0016¨\u0006*"}, d2 = {"Lcom/talabat/talabatcommon/extentions/ObserverCallbacks;", "T", "O", "", "()V", "on", "getOn$annotations", "getOn", "()Lcom/talabat/talabatcommon/extentions/ObserverCallbacks;", "onComplete", "Lkotlin/Function0;", "", "getOnComplete$com_talabat_NewArchi_TalabatCommon_TalabatCommon", "()Lkotlin/jvm/functions/Function0;", "setOnComplete$com_talabat_NewArchi_TalabatCommon_TalabatCommon", "(Lkotlin/jvm/functions/Function0;)V", "onError", "Lkotlin/Function1;", "", "getOnError$com_talabat_NewArchi_TalabatCommon_TalabatCommon", "()Lkotlin/jvm/functions/Function1;", "setOnError$com_talabat_NewArchi_TalabatCommon_TalabatCommon", "(Lkotlin/jvm/functions/Function1;)V", "onNext", "getOnNext$com_talabat_NewArchi_TalabatCommon_TalabatCommon", "setOnNext$com_talabat_NewArchi_TalabatCommon_TalabatCommon", "scheduler", "Lkotlin/Lazy;", "Lio/reactivex/Scheduler;", "getScheduler$com_talabat_NewArchi_TalabatCommon_TalabatCommon", "()Lkotlin/Lazy;", "setScheduler$com_talabat_NewArchi_TalabatCommon_TalabatCommon", "(Lkotlin/Lazy;)V", "transformer", "Lkotlin/ExtensionFunctionType;", "getTransformer$com_talabat_NewArchi_TalabatCommon_TalabatCommon", "setTransformer$com_talabat_NewArchi_TalabatCommon_TalabatCommon", "complete", "callback", "error", "next", "transform", "com_talabat_NewArchi_TalabatCommon_TalabatCommon"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class ObserverCallbacks<T, O> {
    @NotNull

    /* renamed from: on  reason: collision with root package name */
    private final ObserverCallbacks<T, O> f47066on = this;
    @NotNull
    private Function0<Unit> onComplete = ObserverCallbacks$onComplete$1.INSTANCE;
    @NotNull
    private Function1<? super Throwable, Unit> onError = ObserverCallbacks$onError$1.INSTANCE;
    @NotNull
    private Function1<? super T, Unit> onNext = ObserverCallbacks$onNext$1.INSTANCE;
    @NotNull
    private Lazy<? extends Scheduler> scheduler = LazyKt__LazyJVMKt.lazy(ObserverCallbacks$scheduler$1.INSTANCE);
    @NotNull
    private Function1<? super O, ? extends O> transformer = ObserverCallbacks$transformer$1.INSTANCE;

    @RxDsl
    public static /* synthetic */ void getOn$annotations() {
    }

    @RxDsl
    public final void complete(@NotNull Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(function0, "callback");
        this.onComplete = function0;
    }

    @RxDsl
    public final void error(@NotNull Function1<? super Throwable, Unit> function1) {
        Intrinsics.checkNotNullParameter(function1, "callback");
        this.onError = function1;
    }

    @NotNull
    public final ObserverCallbacks<T, O> getOn() {
        return this.f47066on;
    }

    @NotNull
    public final Function0<Unit> getOnComplete$com_talabat_NewArchi_TalabatCommon_TalabatCommon() {
        return this.onComplete;
    }

    @NotNull
    public final Function1<Throwable, Unit> getOnError$com_talabat_NewArchi_TalabatCommon_TalabatCommon() {
        return this.onError;
    }

    @NotNull
    public final Function1<T, Unit> getOnNext$com_talabat_NewArchi_TalabatCommon_TalabatCommon() {
        return this.onNext;
    }

    @NotNull
    public final Lazy<Scheduler> getScheduler$com_talabat_NewArchi_TalabatCommon_TalabatCommon() {
        return this.scheduler;
    }

    @NotNull
    public final Function1<O, O> getTransformer$com_talabat_NewArchi_TalabatCommon_TalabatCommon() {
        return this.transformer;
    }

    @RxDsl
    public final void next(@NotNull Function1<? super T, Unit> function1) {
        Intrinsics.checkNotNullParameter(function1, "callback");
        this.onNext = function1;
    }

    @RxDsl
    public final void scheduler(@NotNull Scheduler scheduler2) {
        Intrinsics.checkNotNullParameter(scheduler2, "scheduler");
        this.scheduler = LazyKt__LazyJVMKt.lazy(LazyThreadSafetyMode.NONE, new ObserverCallbacks$scheduler$2(scheduler2));
    }

    public final void setOnComplete$com_talabat_NewArchi_TalabatCommon_TalabatCommon(@NotNull Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(function0, "<set-?>");
        this.onComplete = function0;
    }

    public final void setOnError$com_talabat_NewArchi_TalabatCommon_TalabatCommon(@NotNull Function1<? super Throwable, Unit> function1) {
        Intrinsics.checkNotNullParameter(function1, "<set-?>");
        this.onError = function1;
    }

    public final void setOnNext$com_talabat_NewArchi_TalabatCommon_TalabatCommon(@NotNull Function1<? super T, Unit> function1) {
        Intrinsics.checkNotNullParameter(function1, "<set-?>");
        this.onNext = function1;
    }

    public final void setScheduler$com_talabat_NewArchi_TalabatCommon_TalabatCommon(@NotNull Lazy<? extends Scheduler> lazy) {
        Intrinsics.checkNotNullParameter(lazy, "<set-?>");
        this.scheduler = lazy;
    }

    public final void setTransformer$com_talabat_NewArchi_TalabatCommon_TalabatCommon(@NotNull Function1<? super O, ? extends O> function1) {
        Intrinsics.checkNotNullParameter(function1, "<set-?>");
        this.transformer = function1;
    }

    @RxDsl
    public final void transform(@NotNull Function1<? super O, ? extends O> function1) {
        Intrinsics.checkNotNullParameter(function1, "transformer");
        this.transformer = function1;
    }
}
