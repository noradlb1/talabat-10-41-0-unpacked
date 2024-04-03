package com.talabat.talabatcommon.extentions;

import io.reactivex.Observable;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003R.\u0010\u0004\u001a\u0014\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00060\u00058\u0006X\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0007\u0010\u0003\u001a\u0004\b\b\u0010\tR\"\u0010\n\u001a\b\u0012\u0004\u0012\u00028\u00000\u000b8\u0006X\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\f\u0010\u0003\u001a\u0004\b\r\u0010\u000e¨\u0006\u000f"}, d2 = {"Lcom/talabat/talabatcommon/extentions/OnValueChangeListener;", "T", "", "()V", "on", "Lcom/talabat/talabatcommon/extentions/ObserverCallbacks;", "Lio/reactivex/Observable;", "getOn$annotations", "getOn", "()Lcom/talabat/talabatcommon/extentions/ObserverCallbacks;", "with", "Lcom/talabat/talabatcommon/extentions/TimedObservableProvider;", "getWith$annotations", "getWith", "()Lcom/talabat/talabatcommon/extentions/TimedObservableProvider;", "com_talabat_NewArchi_TalabatCommon_TalabatCommon"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class OnValueChangeListener<T> {
    @NotNull

    /* renamed from: on  reason: collision with root package name */
    private final ObserverCallbacks<T, Observable<T>> f47068on = new ObserverCallbacks<>();
    @NotNull
    private final TimedObservableProvider<T> with = new TimedObservableProvider<>();

    @RxDsl
    public static /* synthetic */ void getOn$annotations() {
    }

    @RxDsl
    public static /* synthetic */ void getWith$annotations() {
    }

    @NotNull
    public final ObserverCallbacks<T, Observable<T>> getOn() {
        return this.f47068on;
    }

    @NotNull
    public final TimedObservableProvider<T> getWith() {
        return this.with;
    }
}
