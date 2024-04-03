package com.talabat.talabatcommon.extentions;

import av.d;
import av.e;
import av.f;
import av.g;
import av.h;
import av.i;
import av.j;
import av.k;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import io.reactivex.Observable;
import io.reactivex.Scheduler;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import io.reactivex.subjects.BehaviorSubject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.properties.Delegates;
import kotlin.properties.ReadOnlyProperty;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000L\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a-\u0010\u0002\u001a\u00020\u0003\"\u0004\b\u0000\u0010\u00042\u001d\u0010\u0005\u001a\u0019\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00040\u0007\u0012\u0004\u0012\u00020\b0\u0006¢\u0006\u0002\b\tH\u0007\u001a-\u0010\n\u001a\u00020\u0003\"\u0004\b\u0000\u0010\u00042\u001d\u0010\u0005\u001a\u0019\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00040\u0007\u0012\u0004\u0012\u00020\b0\u0006¢\u0006\u0002\b\tH\u0007\u001a\"\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00010\f\"\u0004\b\u0000\u0010\u00042\f\u0010\r\u001a\b\u0012\u0004\u0012\u0002H\u00040\u0007H\u0002\u001a>\u0010\u000e\u001a\u0016\u0012\u0006\u0012\u0004\u0018\u00010\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00040\u00110\u000f\"\u0004\b\u0000\u0010\u0004*\u00020\u00122\b\b\u0002\u0010\u0013\u001a\u00020\u00142\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u0002H\u00040\u0016H\u0007\u001a>\u0010\u0017\u001a\u0016\u0012\u0006\u0012\u0004\u0018\u00010\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00040\u00110\u000f\"\u0004\b\u0000\u0010\u0004*\u00020\u00122\b\b\u0002\u0010\u0013\u001a\u00020\u00142\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u0002H\u00040\u0016H\u0007\"\u000e\u0010\u0000\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"TICK_INTERVAL_MILLIS", "", "OnDistinctValueChangeListener", "Lio/reactivex/disposables/Disposable;", "T", "listener", "Lkotlin/Function1;", "Lcom/talabat/talabatcommon/extentions/OnValueChangeListener;", "", "Lkotlin/ExtensionFunctionType;", "OnValueChangeListener", "interval", "Lio/reactivex/Observable;", "observer", "observe", "Lkotlin/properties/ReadOnlyProperty;", "", "Lio/reactivex/subjects/BehaviorSubject;", "Lkotlin/properties/Delegates;", "scheduler", "Lio/reactivex/Scheduler;", "valueProvider", "Lkotlin/Function0;", "observeDistinct", "com_talabat_NewArchi_TalabatCommon_TalabatCommon"}, k = 2, mv = {1, 6, 0}, xi = 48)
public final class RxDelegatesKt {
    private static final long TICK_INTERVAL_MILLIS = 500;

    @NotNull
    @RxDsl
    public static final <T> Disposable OnDistinctValueChangeListener(@NotNull Function1<? super OnValueChangeListener<T>, Unit> function1) {
        Intrinsics.checkNotNullParameter(function1, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        OnValueChangeListener onValueChangeListener = new OnValueChangeListener();
        function1.invoke(onValueChangeListener);
        Disposable subscribe = interval(onValueChangeListener).observeOn(onValueChangeListener.getWith().getScheduler$com_talabat_NewArchi_TalabatCommon_TalabatCommon()).map(new h(onValueChangeListener)).distinctUntilChanged().observeOn(onValueChangeListener.getOn().getScheduler$com_talabat_NewArchi_TalabatCommon_TalabatCommon().getValue()).subscribe(new i(onValueChangeListener.getOn().getOnNext$com_talabat_NewArchi_TalabatCommon_TalabatCommon()), new j(onValueChangeListener.getOn().getOnError$com_talabat_NewArchi_TalabatCommon_TalabatCommon()), new k(onValueChangeListener.getOn().getOnComplete$com_talabat_NewArchi_TalabatCommon_TalabatCommon()));
        Intrinsics.checkNotNullExpressionValue(subscribe, "interval(observer)\n     …, observer.on.onComplete)");
        return subscribe;
    }

    /* access modifiers changed from: private */
    /* renamed from: OnDistinctValueChangeListener$lambda-4  reason: not valid java name */
    public static final Object m9353OnDistinctValueChangeListener$lambda4(OnValueChangeListener onValueChangeListener, Long l11) {
        Intrinsics.checkNotNullParameter(onValueChangeListener, "$observer");
        Intrinsics.checkNotNullParameter(l11, "it");
        return onValueChangeListener.getWith().getProvideWith$com_talabat_NewArchi_TalabatCommon_TalabatCommon().invoke();
    }

    /* access modifiers changed from: private */
    /* renamed from: OnDistinctValueChangeListener$lambda-5  reason: not valid java name */
    public static final void m9354OnDistinctValueChangeListener$lambda5(Function1 function1, Object obj) {
        Intrinsics.checkNotNullParameter(function1, "$tmp0");
        function1.invoke(obj);
    }

    /* access modifiers changed from: private */
    /* renamed from: OnDistinctValueChangeListener$lambda-6  reason: not valid java name */
    public static final void m9355OnDistinctValueChangeListener$lambda6(Function1 function1, Throwable th2) {
        Intrinsics.checkNotNullParameter(function1, "$tmp0");
        function1.invoke(th2);
    }

    /* access modifiers changed from: private */
    /* renamed from: OnDistinctValueChangeListener$lambda-7  reason: not valid java name */
    public static final void m9356OnDistinctValueChangeListener$lambda7(Function0 function0) {
        Intrinsics.checkNotNullParameter(function0, "$tmp0");
        function0.invoke();
    }

    @NotNull
    @RxDsl
    public static final <T> Disposable OnValueChangeListener(@NotNull Function1<? super OnValueChangeListener<T>, Unit> function1) {
        Intrinsics.checkNotNullParameter(function1, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        OnValueChangeListener onValueChangeListener = new OnValueChangeListener();
        function1.invoke(onValueChangeListener);
        Disposable subscribe = interval(onValueChangeListener).observeOn(onValueChangeListener.getWith().getScheduler$com_talabat_NewArchi_TalabatCommon_TalabatCommon()).map(new d(onValueChangeListener)).observeOn(onValueChangeListener.getOn().getScheduler$com_talabat_NewArchi_TalabatCommon_TalabatCommon().getValue()).subscribe(new e(onValueChangeListener.getOn().getOnNext$com_talabat_NewArchi_TalabatCommon_TalabatCommon()), new f(onValueChangeListener.getOn().getOnError$com_talabat_NewArchi_TalabatCommon_TalabatCommon()), new g(onValueChangeListener.getOn().getOnComplete$com_talabat_NewArchi_TalabatCommon_TalabatCommon()));
        Intrinsics.checkNotNullExpressionValue(subscribe, "interval(observer)\n     …, observer.on.onComplete)");
        return subscribe;
    }

    /* access modifiers changed from: private */
    /* renamed from: OnValueChangeListener$lambda-0  reason: not valid java name */
    public static final Object m9357OnValueChangeListener$lambda0(OnValueChangeListener onValueChangeListener, Long l11) {
        Intrinsics.checkNotNullParameter(onValueChangeListener, "$observer");
        Intrinsics.checkNotNullParameter(l11, "it");
        return onValueChangeListener.getWith().getProvideWith$com_talabat_NewArchi_TalabatCommon_TalabatCommon().invoke();
    }

    /* access modifiers changed from: private */
    /* renamed from: OnValueChangeListener$lambda-1  reason: not valid java name */
    public static final void m9358OnValueChangeListener$lambda1(Function1 function1, Object obj) {
        Intrinsics.checkNotNullParameter(function1, "$tmp0");
        function1.invoke(obj);
    }

    /* access modifiers changed from: private */
    /* renamed from: OnValueChangeListener$lambda-2  reason: not valid java name */
    public static final void m9359OnValueChangeListener$lambda2(Function1 function1, Throwable th2) {
        Intrinsics.checkNotNullParameter(function1, "$tmp0");
        function1.invoke(th2);
    }

    /* access modifiers changed from: private */
    /* renamed from: OnValueChangeListener$lambda-3  reason: not valid java name */
    public static final void m9360OnValueChangeListener$lambda3(Function0 function0) {
        Intrinsics.checkNotNullParameter(function0, "$tmp0");
        function0.invoke();
    }

    private static final <T> Observable<Long> interval(OnValueChangeListener<T> onValueChangeListener) {
        Observable<Long> interval = Observable.interval(0, onValueChangeListener.getWith().getInterval$com_talabat_NewArchi_TalabatCommon_TalabatCommon(), onValueChangeListener.getWith().getTimeUnit$com_talabat_NewArchi_TalabatCommon_TalabatCommon(), onValueChangeListener.getWith().getScheduler$com_talabat_NewArchi_TalabatCommon_TalabatCommon());
        Intrinsics.checkNotNullExpressionValue(interval, "interval(\n        0,\n   …rver.with.scheduler\n    )");
        return interval;
    }

    @NotNull
    @RxDsl
    public static final <T> ReadOnlyProperty<Object, BehaviorSubject<T>> observe(@NotNull Delegates delegates, @NotNull Scheduler scheduler, @NotNull Function0<? extends T> function0) {
        Intrinsics.checkNotNullParameter(delegates, "<this>");
        Intrinsics.checkNotNullParameter(scheduler, "scheduler");
        Intrinsics.checkNotNullParameter(function0, "valueProvider");
        return new RxDelegatesKt$observe$1(function0, scheduler);
    }

    public static /* synthetic */ ReadOnlyProperty observe$default(Delegates delegates, Scheduler scheduler, Function0 function0, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            scheduler = Schedulers.computation();
            Intrinsics.checkNotNullExpressionValue(scheduler, "computation()");
        }
        return observe(delegates, scheduler, function0);
    }

    @NotNull
    @RxDsl
    public static final <T> ReadOnlyProperty<Object, BehaviorSubject<T>> observeDistinct(@NotNull Delegates delegates, @NotNull Scheduler scheduler, @NotNull Function0<? extends T> function0) {
        Intrinsics.checkNotNullParameter(delegates, "<this>");
        Intrinsics.checkNotNullParameter(scheduler, "scheduler");
        Intrinsics.checkNotNullParameter(function0, "valueProvider");
        return new RxDelegatesKt$observeDistinct$1(function0, scheduler);
    }

    public static /* synthetic */ ReadOnlyProperty observeDistinct$default(Delegates delegates, Scheduler scheduler, Function0 function0, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            scheduler = Schedulers.computation();
            Intrinsics.checkNotNullExpressionValue(scheduler, "computation()");
        }
        return observeDistinct(delegates, scheduler, function0);
    }
}
