package com.talabat.helpers;

import io.reactivex.Observable;
import io.reactivex.Scheduler;
import io.reactivex.Single;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.observers.DisposableSingleObserver;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0019\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\u0006\u0010\b\u001a\u00020\tJ(\u0010\n\u001a\u00020\u000b\"\u0004\b\u0000\u0010\f2\f\u0010\r\u001a\b\u0012\u0004\u0012\u0002H\f0\u000e2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u0002H\f0\u0010J(\u0010\n\u001a\u00020\u000b\"\u0004\b\u0000\u0010\f2\f\u0010\r\u001a\b\u0012\u0004\u0012\u0002H\f0\u00112\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u0002H\f0\u0012R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lcom/talabat/helpers/RxProcessor;", "", "backgroundSchedulers", "Lio/reactivex/Scheduler;", "foregroundSchedulers", "(Lio/reactivex/Scheduler;Lio/reactivex/Scheduler;)V", "disposables", "Lio/reactivex/disposables/CompositeDisposable;", "clear", "", "process", "Lio/reactivex/disposables/Disposable;", "T", "business", "Lio/reactivex/Observable;", "observer", "Lio/reactivex/observers/DisposableObserver;", "Lio/reactivex/Single;", "Lio/reactivex/observers/DisposableSingleObserver;", "com_talabat_talabatlib_talabatlib"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class RxProcessor {
    @NotNull
    private final Scheduler backgroundSchedulers;
    @NotNull
    private final CompositeDisposable disposables;
    @NotNull
    private final Scheduler foregroundSchedulers;

    public RxProcessor() {
        this((Scheduler) null, (Scheduler) null, 3, (DefaultConstructorMarker) null);
    }

    public RxProcessor(@NotNull Scheduler scheduler, @NotNull Scheduler scheduler2) {
        Intrinsics.checkNotNullParameter(scheduler, "backgroundSchedulers");
        Intrinsics.checkNotNullParameter(scheduler2, "foregroundSchedulers");
        this.backgroundSchedulers = scheduler;
        this.foregroundSchedulers = scheduler2;
        this.disposables = new CompositeDisposable();
    }

    public final void clear() {
        this.disposables.clear();
    }

    @NotNull
    public final <T> Disposable process(@NotNull Observable<T> observable, @NotNull DisposableObserver<T> disposableObserver) {
        Intrinsics.checkNotNullParameter(observable, "business");
        Intrinsics.checkNotNullParameter(disposableObserver, "observer");
        DisposableObserver disposableObserver2 = (DisposableObserver) observable.subscribeOn(this.backgroundSchedulers).observeOn(this.foregroundSchedulers).subscribeWith(disposableObserver);
        this.disposables.add(disposableObserver2);
        Intrinsics.checkNotNullExpressionValue(disposableObserver2, "disposableSubscription");
        return disposableObserver2;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ RxProcessor(io.reactivex.Scheduler r1, io.reactivex.Scheduler r2, int r3, kotlin.jvm.internal.DefaultConstructorMarker r4) {
        /*
            r0 = this;
            r4 = r3 & 1
            if (r4 == 0) goto L_0x000d
            io.reactivex.Scheduler r1 = io.reactivex.schedulers.Schedulers.io()
            java.lang.String r4 = "io()"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r4)
        L_0x000d:
            r3 = r3 & 2
            if (r3 == 0) goto L_0x001a
            io.reactivex.Scheduler r2 = io.reactivex.android.schedulers.AndroidSchedulers.mainThread()
            java.lang.String r3 = "mainThread()"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r2, r3)
        L_0x001a:
            r0.<init>(r1, r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.talabat.helpers.RxProcessor.<init>(io.reactivex.Scheduler, io.reactivex.Scheduler, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }

    @NotNull
    public final <T> Disposable process(@NotNull Single<T> single, @NotNull DisposableSingleObserver<T> disposableSingleObserver) {
        Intrinsics.checkNotNullParameter(single, "business");
        Intrinsics.checkNotNullParameter(disposableSingleObserver, "observer");
        DisposableSingleObserver disposableSingleObserver2 = (DisposableSingleObserver) single.subscribeOn(this.backgroundSchedulers).observeOn(this.foregroundSchedulers).subscribeWith(disposableSingleObserver);
        this.disposables.add(disposableSingleObserver2);
        Intrinsics.checkNotNullExpressionValue(disposableSingleObserver2, "disposableSubscription");
        return disposableSingleObserver2;
    }
}
