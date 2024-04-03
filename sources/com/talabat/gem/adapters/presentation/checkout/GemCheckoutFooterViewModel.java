package com.talabat.gem.adapters.presentation.checkout;

import androidx.lifecycle.ViewModel;
import com.talabat.gem.domain.entities.GemOffer;
import com.talabat.gem.domain.entities.GemRestaurant;
import com.talabat.gem.domain.usecases.GemCounterBusinessRulesKt;
import com.talabat.gem.domain.usecases.GemExpiredBusinessRulesKt;
import com.talabat.gem.domain.usecases.GemOfferRequester;
import com.talabat.gem.domain.usecases.GemPerRestaurantBusinessRulesKt;
import com.talabat.gem.domain.usecases.GemViewBusinessRulesKt;
import com.talabat.gem.ports.presentation.GemExpiredViewPort;
import com.talabat.gem.ports.presentation.GemPerRestaurantViewPort;
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
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000|\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0000\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B\u0005¢\u0006\u0002\u0010\u0004J\b\u0010F\u001a\u00020\u0006H\u0016R\u0016\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\n\n\u0002\u0010\t\u001a\u0004\b\u0007\u0010\bR\u0016\u0010\n\u001a\u00020\u0006X\u0004¢\u0006\n\n\u0002\u0010\t\u001a\u0004\b\u000b\u0010\bR\u0016\u0010\f\u001a\u00020\u0006X\u0004¢\u0006\n\n\u0002\u0010\t\u001a\u0004\b\r\u0010\bR\u0016\u0010\u000e\u001a\u00020\u0006X\u0004¢\u0006\n\n\u0002\u0010\t\u001a\u0004\b\u000f\u0010\bR\u0016\u0010\u0010\u001a\u00020\u0006X\u0004¢\u0006\n\n\u0002\u0010\t\u001a\u0004\b\u0011\u0010\bR\u0016\u0010\u0012\u001a\u00020\u0006X\u0004¢\u0006\n\n\u0002\u0010\t\u001a\u0004\b\u0013\u0010\bR\u0016\u0010\u0014\u001a\u00020\u0006X\u0004¢\u0006\n\n\u0002\u0010\t\u001a\u0004\b\u0015\u0010\bR\u0016\u0010\u0016\u001a\u00020\u0006X\u0004¢\u0006\n\n\u0002\u0010\t\u001a\u0004\b\u0017\u0010\bR\"\u0010\u0018\u001a\u0010\u0012\f\u0012\n \u001b*\u0004\u0018\u00010\u001a0\u001a0\u0019X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\"\u0010\u001e\u001a\u0010\u0012\f\u0012\n \u001b*\u0004\u0018\u00010\u001f0\u001f0\u0019X\u0004¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u001dR\"\u0010!\u001a\u0010\u0012\f\u0012\n \u001b*\u0004\u0018\u00010\"0\"0\u0019X\u0004¢\u0006\b\n\u0000\u001a\u0004\b#\u0010\u001dR\u0014\u0010$\u001a\u00020%X\u0004¢\u0006\b\n\u0000\u001a\u0004\b&\u0010'R\"\u0010(\u001a\u0010\u0012\f\u0012\n \u001b*\u0004\u0018\u00010*0*0)X\u0004¢\u0006\b\n\u0000\u001a\u0004\b+\u0010,R\"\u0010-\u001a\u0010\u0012\f\u0012\n \u001b*\u0004\u0018\u00010.0.0\u0019X\u0004¢\u0006\b\n\u0000\u001a\u0004\b/\u0010\u001dR\"\u00100\u001a\u0010\u0012\f\u0012\n \u001b*\u0004\u0018\u00010.0.0\u0019X\u0004¢\u0006\b\n\u0000\u001a\u0004\b1\u0010\u001dR\"\u00102\u001a\u0010\u0012\f\u0012\n \u001b*\u0004\u0018\u000103030\u0019X\u0004¢\u0006\b\n\u0000\u001a\u0004\b4\u0010\u001dR\u0014\u00105\u001a\u000206X\u0004¢\u0006\b\n\u0000\u001a\u0004\b7\u00108R\"\u00109\u001a\u0010\u0012\f\u0012\n \u001b*\u0004\u0018\u00010:0:0\u0019X\u0004¢\u0006\b\n\u0000\u001a\u0004\b;\u0010\u001dR\"\u0010<\u001a\u0010\u0012\f\u0012\n \u001b*\u0004\u0018\u00010=0=0\u0019X\u0004¢\u0006\b\n\u0000\u001a\u0004\b>\u0010\u001dR.\u0010?\u001a\u001c\u0012\u0018\u0012\u0016\u0012\u0004\u0012\u00020\u001f \u001b*\n\u0012\u0004\u0012\u00020\u001f\u0018\u00010@0@0\u0019X\u0004¢\u0006\b\n\u0000\u001a\u0004\bA\u0010\u001dR\"\u0010B\u001a\u0010\u0012\f\u0012\n \u001b*\u0004\u0018\u00010\u001f0\u001f0\u0019X\u0004¢\u0006\b\n\u0000\u001a\u0004\bC\u0010\u001dR\"\u0010D\u001a\u0010\u0012\f\u0012\n \u001b*\u0004\u0018\u00010\u001f0\u001f0\u0019X\u0004¢\u0006\b\n\u0000\u001a\u0004\bE\u0010\u001d¨\u0006G"}, d2 = {"Lcom/talabat/gem/adapters/presentation/checkout/GemCheckoutFooterViewModel;", "Landroidx/lifecycle/ViewModel;", "Lcom/talabat/gem/ports/presentation/GemPerRestaurantViewPort;", "Lcom/talabat/gem/ports/presentation/GemExpiredViewPort;", "()V", "bindCollectionTriggerExpirationAlert", "", "getBindCollectionTriggerExpirationAlert", "()Lkotlin/Unit;", "Lkotlin/Unit;", "bindCounterAndVisibility", "getBindCounterAndVisibility", "bindCounterExpired", "getBindCounterExpired", "bindExpiredOffer", "getBindExpiredOffer", "bindOffer", "getBindOffer", "bindSelectedGemRestaurant", "getBindSelectedGemRestaurant", "bindTriggerExpirationAlert", "getBindTriggerExpirationAlert", "bindVisibilityPerRestaurant", "getBindVisibilityPerRestaurant", "counter", "Lio/reactivex/subjects/BehaviorSubject;", "", "kotlin.jvm.PlatformType", "getCounter", "()Lio/reactivex/subjects/BehaviorSubject;", "counterExpired", "", "getCounterExpired", "counterSubscription", "Lio/reactivex/disposables/Disposable;", "getCounterSubscription", "disposables", "Lio/reactivex/disposables/CompositeDisposable;", "getDisposables", "()Lio/reactivex/disposables/CompositeDisposable;", "errors", "Lio/reactivex/subjects/PublishSubject;", "", "getErrors", "()Lio/reactivex/subjects/PublishSubject;", "expiredOffer", "Lcom/talabat/gem/domain/entities/GemOffer;", "getExpiredOffer", "offer", "getOffer", "remainingSeconds", "", "getRemainingSeconds", "scheduler", "Lio/reactivex/Scheduler;", "getScheduler", "()Lio/reactivex/Scheduler;", "selectedGemRestaurant", "Lcom/talabat/gem/domain/entities/GemRestaurant;", "getSelectedGemRestaurant", "selectedRestaurantId", "", "getSelectedRestaurantId", "triggerExpirationAlert", "Lkotlin/Function0;", "getTriggerExpirationAlert", "visibility", "getVisibility", "visibilityPerRestaurant", "getVisibilityPerRestaurant", "onCleared", "com_talabat_Components_gem_gem"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class GemCheckoutFooterViewModel extends ViewModel implements GemPerRestaurantViewPort, GemExpiredViewPort {
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

    public GemCheckoutFooterViewModel() {
        Scheduler io2 = Schedulers.io();
        Intrinsics.checkNotNullExpressionValue(io2, "io()");
        this.scheduler = io2;
        BehaviorSubject<String> create = BehaviorSubject.create();
        Intrinsics.checkNotNullExpressionValue(create, "create<String>()");
        this.counter = create;
        BehaviorSubject<Disposable> create2 = BehaviorSubject.create();
        Intrinsics.checkNotNullExpressionValue(create2, "create<Disposable>()");
        this.counterSubscription = create2;
        BehaviorSubject<Boolean> create3 = BehaviorSubject.create();
        Intrinsics.checkNotNullExpressionValue(create3, "create<Boolean>()");
        this.visibility = create3;
        PublishSubject<Throwable> create4 = PublishSubject.create();
        Intrinsics.checkNotNullExpressionValue(create4, "create<Throwable>()");
        this.errors = create4;
        BehaviorSubject<GemOffer> create5 = BehaviorSubject.create();
        Intrinsics.checkNotNullExpressionValue(create5, "create<GemOffer>()");
        this.offer = create5;
        BehaviorSubject<Integer> create6 = BehaviorSubject.create();
        Intrinsics.checkNotNullExpressionValue(create6, "create<Int>()");
        this.selectedRestaurantId = create6;
        BehaviorSubject<GemRestaurant> create7 = BehaviorSubject.create();
        Intrinsics.checkNotNullExpressionValue(create7, "create<GemRestaurant>()");
        this.selectedGemRestaurant = create7;
        BehaviorSubject<Boolean> create8 = BehaviorSubject.create();
        Intrinsics.checkNotNullExpressionValue(create8, "create<Boolean>()");
        this.visibilityPerRestaurant = create8;
        BehaviorSubject<Boolean> create9 = BehaviorSubject.create();
        Intrinsics.checkNotNullExpressionValue(create9, "create<Boolean>()");
        this.counterExpired = create9;
        BehaviorSubject<Long> create10 = BehaviorSubject.create();
        Intrinsics.checkNotNullExpressionValue(create10, "create<Long>()");
        this.remainingSeconds = create10;
        BehaviorSubject<GemOffer> create11 = BehaviorSubject.create();
        Intrinsics.checkNotNullExpressionValue(create11, "create<GemOffer>()");
        this.expiredOffer = create11;
        BehaviorSubject<Function0<Boolean>> create12 = BehaviorSubject.create();
        Intrinsics.checkNotNullExpressionValue(create12, "create<() -> Boolean>()");
        this.triggerExpirationAlert = create12;
        GemCounterBusinessRulesKt.bindCounterExpired(this);
        Unit unit = Unit.INSTANCE;
        this.bindCounterExpired = unit;
        GemCounterBusinessRulesKt.bindCounterAndVisibility$default(this, (Long) null, 1, (Object) null);
        this.bindCounterAndVisibility = unit;
        GemViewBusinessRulesKt.bindOffer$default(this, GemOfferRequester.Existing.INSTANCE, (Function1) null, 2, (Object) null);
        this.bindOffer = unit;
        GemPerRestaurantBusinessRulesKt.bindSelectedGemRestaurant(this);
        this.bindSelectedGemRestaurant = unit;
        GemPerRestaurantBusinessRulesKt.bindVisibilityPerRestaurant(this);
        this.bindVisibilityPerRestaurant = unit;
        GemExpiredBusinessRulesKt.bindExpiredOffer(this);
        this.bindExpiredOffer = unit;
        GemExpiredBusinessRulesKt.bindTriggerExpirationAlert(this);
        this.bindTriggerExpirationAlert = unit;
        GemExpiredBusinessRulesKt.bindCollectionTriggerExpirationAlert(this);
        this.bindCollectionTriggerExpirationAlert = unit;
    }

    @AutoDisposableDsl
    public void autoDispose(@NotNull Function0<? extends Disposable> function0) {
        GemPerRestaurantViewPort.DefaultImpls.autoDispose(this, function0);
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
        return GemPerRestaurantViewPort.DefaultImpls.getBindSelectedRestaurantId(this);
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
        GemPerRestaurantViewPort.DefaultImpls.onClearedImplementation(this);
    }

    @NotNull
    public PublishSubject<Throwable> getErrors() {
        return this.errors;
    }
}
