package com.talabat.gem.adapters.presentation.expiration;

import com.talabat.gem.domain.entities.GemOffer;
import com.talabat.gem.domain.entities.GemRestaurant;
import com.talabat.gem.domain.usecases.GemCounterBusinessRulesKt;
import com.talabat.gem.domain.usecases.GemExpiredBusinessRulesKt;
import com.talabat.gem.domain.usecases.GemPerRestaurantBusinessRulesKt;
import com.talabat.gem.domain.usecases.GemViewBusinessRulesKt;
import com.talabat.gem.ports.presentation.GemExpiredViewPort;
import com.talabat.talabatcommon.lifecycle.AutoDisposableDsl;
import io.reactivex.Scheduler;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import io.reactivex.subjects.BehaviorSubject;
import io.reactivex.subjects.PublishSubject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000s\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006*\u0001\u0000\b\n\u0018\u00002\u00020\u0001R\u0016\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\n\n\u0002\u0010\u0006\u001a\u0004\b\u0004\u0010\u0005R\u0016\u0010\u0007\u001a\u00020\u0003X\u0004¢\u0006\n\n\u0002\u0010\u0006\u001a\u0004\b\b\u0010\u0005R\u0016\u0010\t\u001a\u00020\u0003X\u0004¢\u0006\n\n\u0002\u0010\u0006\u001a\u0004\b\n\u0010\u0005R\u0016\u0010\u000b\u001a\u00020\u0003X\u0004¢\u0006\n\n\u0002\u0010\u0006\u001a\u0004\b\f\u0010\u0005R\u0016\u0010\r\u001a\u00020\u0003X\u0004¢\u0006\n\n\u0002\u0010\u0006\u001a\u0004\b\u000e\u0010\u0005R\u0016\u0010\u000f\u001a\u00020\u0003X\u0004¢\u0006\n\n\u0002\u0010\u0006\u001a\u0004\b\u0010\u0010\u0005R\u0016\u0010\u0011\u001a\u00020\u0003X\u0004¢\u0006\n\n\u0002\u0010\u0006\u001a\u0004\b\u0012\u0010\u0005R\u0016\u0010\u0013\u001a\u00020\u0003X\u0004¢\u0006\n\n\u0002\u0010\u0006\u001a\u0004\b\u0014\u0010\u0005R\"\u0010\u0015\u001a\u0010\u0012\f\u0012\n \u0018*\u0004\u0018\u00010\u00170\u00170\u0016X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\"\u0010\u001b\u001a\u0010\u0012\f\u0012\n \u0018*\u0004\u0018\u00010\u001c0\u001c0\u0016X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001aR\"\u0010\u001e\u001a\u0010\u0012\f\u0012\n \u0018*\u0004\u0018\u00010\u001f0\u001f0\u0016X\u0004¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u001aR\u0014\u0010!\u001a\u00020\"X\u0004¢\u0006\b\n\u0000\u001a\u0004\b#\u0010$R\"\u0010%\u001a\u0010\u0012\f\u0012\n \u0018*\u0004\u0018\u00010'0'0&X\u0004¢\u0006\b\n\u0000\u001a\u0004\b(\u0010)R\"\u0010*\u001a\u0010\u0012\f\u0012\n \u0018*\u0004\u0018\u00010+0+0\u0016X\u0004¢\u0006\b\n\u0000\u001a\u0004\b,\u0010\u001aR\"\u0010-\u001a\u0010\u0012\f\u0012\n \u0018*\u0004\u0018\u00010+0+0\u0016X\u0004¢\u0006\b\n\u0000\u001a\u0004\b.\u0010\u001aR\"\u0010/\u001a\u0010\u0012\f\u0012\n \u0018*\u0004\u0018\u000100000\u0016X\u0004¢\u0006\b\n\u0000\u001a\u0004\b1\u0010\u001aR\u0014\u00102\u001a\u000203X\u0004¢\u0006\b\n\u0000\u001a\u0004\b4\u00105R\"\u00106\u001a\u0010\u0012\f\u0012\n \u0018*\u0004\u0018\u000107070\u0016X\u0004¢\u0006\b\n\u0000\u001a\u0004\b8\u0010\u001aR\"\u00109\u001a\u0010\u0012\f\u0012\n \u0018*\u0004\u0018\u00010:0:0\u0016X\u0004¢\u0006\b\n\u0000\u001a\u0004\b;\u0010\u001aR.\u0010<\u001a\u001c\u0012\u0018\u0012\u0016\u0012\u0004\u0012\u00020\u001c \u0018*\n\u0012\u0004\u0012\u00020\u001c\u0018\u00010=0=0\u0016X\u0004¢\u0006\b\n\u0000\u001a\u0004\b>\u0010\u001aR\"\u0010?\u001a\u0010\u0012\f\u0012\n \u0018*\u0004\u0018\u00010\u001c0\u001c0\u0016X\u0004¢\u0006\b\n\u0000\u001a\u0004\b@\u0010\u001aR\"\u0010A\u001a\u0010\u0012\f\u0012\n \u0018*\u0004\u0018\u00010\u001c0\u001c0\u0016X\u0004¢\u0006\b\n\u0000\u001a\u0004\bB\u0010\u001a¨\u0006C"}, d2 = {"com/talabat/gem/adapters/presentation/expiration/GemExpirationTrackerKt$GemExpirationTracker$1", "Lcom/talabat/gem/ports/presentation/GemExpiredViewPort;", "bindCollectionTriggerExpirationAlert", "", "getBindCollectionTriggerExpirationAlert", "()Lkotlin/Unit;", "Lkotlin/Unit;", "bindCounterAndVisibility", "getBindCounterAndVisibility", "bindCounterExpired", "getBindCounterExpired", "bindExpiredOffer", "getBindExpiredOffer", "bindOffer", "getBindOffer", "bindSelectedGemRestaurant", "getBindSelectedGemRestaurant", "bindTriggerExpirationAlert", "getBindTriggerExpirationAlert", "bindVisibilityPerRestaurant", "getBindVisibilityPerRestaurant", "counter", "Lio/reactivex/subjects/BehaviorSubject;", "", "kotlin.jvm.PlatformType", "getCounter", "()Lio/reactivex/subjects/BehaviorSubject;", "counterExpired", "", "getCounterExpired", "counterSubscription", "Lio/reactivex/disposables/Disposable;", "getCounterSubscription", "disposables", "Lio/reactivex/disposables/CompositeDisposable;", "getDisposables", "()Lio/reactivex/disposables/CompositeDisposable;", "errors", "Lio/reactivex/subjects/PublishSubject;", "", "getErrors", "()Lio/reactivex/subjects/PublishSubject;", "expiredOffer", "Lcom/talabat/gem/domain/entities/GemOffer;", "getExpiredOffer", "offer", "getOffer", "remainingSeconds", "", "getRemainingSeconds", "scheduler", "Lio/reactivex/Scheduler;", "getScheduler", "()Lio/reactivex/Scheduler;", "selectedGemRestaurant", "Lcom/talabat/gem/domain/entities/GemRestaurant;", "getSelectedGemRestaurant", "selectedRestaurantId", "", "getSelectedRestaurantId", "triggerExpirationAlert", "Lkotlin/Function0;", "getTriggerExpirationAlert", "visibility", "getVisibility", "visibilityPerRestaurant", "getVisibilityPerRestaurant", "com_talabat_Components_gem_gem"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class GemExpirationTrackerKt$GemExpirationTracker$1 implements GemExpiredViewPort {
    @NotNull
    private final Unit bindCollectionTriggerExpirationAlert;
    @NotNull
    private final Unit bindCounterAndVisibility;
    @NotNull
    private final Unit bindCounterExpired;
    @NotNull
    private final Unit bindExpiredOffer;
    @NotNull
    private final Unit bindOffer;
    @NotNull
    private final Unit bindSelectedGemRestaurant;
    @NotNull
    private final Unit bindTriggerExpirationAlert;
    @NotNull
    private final Unit bindVisibilityPerRestaurant;
    @NotNull
    private final BehaviorSubject<String> counter;
    @NotNull
    private final BehaviorSubject<Boolean> counterExpired;
    @NotNull
    private final BehaviorSubject<Disposable> counterSubscription;
    @NotNull
    private final CompositeDisposable disposables = new CompositeDisposable();
    @NotNull
    private final PublishSubject<Throwable> errors;
    @NotNull
    private final BehaviorSubject<GemOffer> expiredOffer;
    @NotNull
    private final BehaviorSubject<GemOffer> offer;
    @NotNull
    private final BehaviorSubject<Long> remainingSeconds;
    @NotNull
    private final Scheduler scheduler;
    @NotNull
    private final BehaviorSubject<GemRestaurant> selectedGemRestaurant;
    @NotNull
    private final BehaviorSubject<Integer> selectedRestaurantId;
    @NotNull
    private final BehaviorSubject<Function0<Boolean>> triggerExpirationAlert;
    @NotNull
    private final BehaviorSubject<Boolean> visibility;
    @NotNull
    private final BehaviorSubject<Boolean> visibilityPerRestaurant;

    public GemExpirationTrackerKt$GemExpirationTracker$1() {
        BehaviorSubject<Integer> create = BehaviorSubject.create();
        Intrinsics.checkNotNullExpressionValue(create, "create<Int>()");
        this.selectedRestaurantId = create;
        BehaviorSubject<GemRestaurant> create2 = BehaviorSubject.create();
        Intrinsics.checkNotNullExpressionValue(create2, "create<GemRestaurant>()");
        this.selectedGemRestaurant = create2;
        BehaviorSubject<Boolean> create3 = BehaviorSubject.create();
        Intrinsics.checkNotNullExpressionValue(create3, "create<Boolean>()");
        this.visibilityPerRestaurant = create3;
        Scheduler io2 = Schedulers.io();
        Intrinsics.checkNotNullExpressionValue(io2, "io()");
        this.scheduler = io2;
        BehaviorSubject<String> create4 = BehaviorSubject.create();
        Intrinsics.checkNotNullExpressionValue(create4, "create<String>()");
        this.counter = create4;
        BehaviorSubject<Disposable> create5 = BehaviorSubject.create();
        Intrinsics.checkNotNullExpressionValue(create5, "create<Disposable>()");
        this.counterSubscription = create5;
        BehaviorSubject<Boolean> create6 = BehaviorSubject.create();
        Intrinsics.checkNotNullExpressionValue(create6, "create<Boolean>()");
        this.visibility = create6;
        PublishSubject<Throwable> create7 = PublishSubject.create();
        Intrinsics.checkNotNullExpressionValue(create7, "create<Throwable>()");
        this.errors = create7;
        BehaviorSubject<GemOffer> create8 = BehaviorSubject.create();
        Intrinsics.checkNotNullExpressionValue(create8, "create<GemOffer>()");
        this.offer = create8;
        BehaviorSubject<GemOffer> create9 = BehaviorSubject.create();
        Intrinsics.checkNotNullExpressionValue(create9, "create<GemOffer>()");
        this.expiredOffer = create9;
        BehaviorSubject<Function0<Boolean>> create10 = BehaviorSubject.create();
        Intrinsics.checkNotNullExpressionValue(create10, "create<() -> Boolean>()");
        this.triggerExpirationAlert = create10;
        BehaviorSubject<Boolean> create11 = BehaviorSubject.create();
        Intrinsics.checkNotNullExpressionValue(create11, "create<Boolean>()");
        this.counterExpired = create11;
        BehaviorSubject<Long> create12 = BehaviorSubject.create();
        Intrinsics.checkNotNullExpressionValue(create12, "create<Long>()");
        this.remainingSeconds = create12;
        GemCounterBusinessRulesKt.bindCounterExpired(this);
        Unit unit = Unit.INSTANCE;
        this.bindCounterExpired = unit;
        GemPerRestaurantBusinessRulesKt.bindSelectedGemRestaurant(this);
        this.bindSelectedGemRestaurant = unit;
        GemPerRestaurantBusinessRulesKt.bindVisibilityPerRestaurant(this);
        this.bindVisibilityPerRestaurant = unit;
        GemViewBusinessRulesKt.bindOfferAsObserver(this);
        this.bindOffer = unit;
        GemCounterBusinessRulesKt.bindCounterAndVisibility$default(this, (Long) null, 1, (Object) null);
        this.bindCounterAndVisibility = unit;
        GemExpiredBusinessRulesKt.bindExpiredOffer(this);
        this.bindExpiredOffer = unit;
        this.bindTriggerExpirationAlert = unit;
        this.bindCollectionTriggerExpirationAlert = unit;
    }

    @AutoDisposableDsl
    public void autoDispose(@NotNull Function0<? extends Disposable> function0) {
        GemExpiredViewPort.DefaultImpls.autoDispose(this, function0);
    }

    @NotNull
    public Unit getBindCollectionTriggerExpirationAlert() {
        return this.bindCollectionTriggerExpirationAlert;
    }

    @NotNull
    public Unit getBindCounterAndVisibility() {
        return this.bindCounterAndVisibility;
    }

    @NotNull
    public Unit getBindCounterExpired() {
        return this.bindCounterExpired;
    }

    @NotNull
    public Unit getBindExpiredOffer() {
        return this.bindExpiredOffer;
    }

    @NotNull
    public Unit getBindOffer() {
        return this.bindOffer;
    }

    @NotNull
    public Unit getBindSelectedGemRestaurant() {
        return this.bindSelectedGemRestaurant;
    }

    @NotNull
    public Unit getBindSelectedRestaurantId() {
        return GemExpiredViewPort.DefaultImpls.getBindSelectedRestaurantId(this);
    }

    @NotNull
    public Unit getBindTriggerExpirationAlert() {
        return this.bindTriggerExpirationAlert;
    }

    @NotNull
    public Unit getBindVisibilityPerRestaurant() {
        return this.bindVisibilityPerRestaurant;
    }

    @NotNull
    public BehaviorSubject<String> getCounter() {
        return this.counter;
    }

    @NotNull
    public BehaviorSubject<Boolean> getCounterExpired() {
        return this.counterExpired;
    }

    @NotNull
    public BehaviorSubject<Disposable> getCounterSubscription() {
        return this.counterSubscription;
    }

    @NotNull
    public CompositeDisposable getDisposables() {
        return this.disposables;
    }

    @NotNull
    public BehaviorSubject<GemOffer> getExpiredOffer() {
        return this.expiredOffer;
    }

    @NotNull
    public BehaviorSubject<GemOffer> getOffer() {
        return this.offer;
    }

    @NotNull
    public BehaviorSubject<Long> getRemainingSeconds() {
        return this.remainingSeconds;
    }

    @NotNull
    public Scheduler getScheduler() {
        return this.scheduler;
    }

    @NotNull
    public BehaviorSubject<GemRestaurant> getSelectedGemRestaurant() {
        return this.selectedGemRestaurant;
    }

    @NotNull
    public BehaviorSubject<Integer> getSelectedRestaurantId() {
        return this.selectedRestaurantId;
    }

    @NotNull
    public BehaviorSubject<Function0<Boolean>> getTriggerExpirationAlert() {
        return this.triggerExpirationAlert;
    }

    @NotNull
    public BehaviorSubject<Boolean> getVisibility() {
        return this.visibility;
    }

    @NotNull
    public BehaviorSubject<Boolean> getVisibilityPerRestaurant() {
        return this.visibilityPerRestaurant;
    }

    public void onCleared() {
        GemExpiredViewPort.DefaultImpls.onCleared(this);
    }

    @AutoDisposableDsl
    public void onClearedImplementation() {
        GemExpiredViewPort.DefaultImpls.onClearedImplementation(this);
    }

    @NotNull
    public PublishSubject<Throwable> getErrors() {
        return this.errors;
    }
}
