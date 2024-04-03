package com.talabat.gem.adapters.presentation.payment;

import androidx.lifecycle.ViewModel;
import com.talabat.gem.adapters.presentation.ConfigurationsKt;
import com.talabat.gem.adapters.presentation.GemOfferProcessingConfigurations;
import com.talabat.gem.domain.entities.GemOffer;
import com.talabat.gem.domain.entities.GemOfferAcceptance;
import com.talabat.gem.domain.entities.GemRestaurant;
import com.talabat.gem.domain.usecases.GemCounterBusinessRulesKt;
import com.talabat.gem.domain.usecases.GemOfferRequester;
import com.talabat.gem.domain.usecases.GemPerRestaurantBusinessRulesKt;
import com.talabat.gem.domain.usecases.GemViewBusinessRulesKt;
import com.talabat.gem.ports.presentation.GemOfferProcessingViewPort;
import com.talabat.talabatcommon.extentions.RxKt;
import com.talabat.talabatcommon.extentions.SingleAccess;
import com.talabat.talabatcommon.lifecycle.AutoDisposable;
import com.talabat.talabatcommon.lifecycle.AutoDisposableDsl;
import io.reactivex.Scheduler;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import io.reactivex.subjects.BehaviorSubject;
import io.reactivex.subjects.PublishSubject;
import io.reactivex.subjects.ReplaySubject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0007\b\u0000\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B\u0005¢\u0006\u0002\u0010\u0004J\b\u0010O\u001a\u00020\u0006H\u0016R\u0016\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\n\n\u0002\u0010\t\u001a\u0004\b\u0007\u0010\bR\u0016\u0010\n\u001a\u00020\u0006X\u0004¢\u0006\n\n\u0002\u0010\t\u001a\u0004\b\u000b\u0010\bR\u0016\u0010\f\u001a\u00020\u0006X\u0004¢\u0006\n\n\u0002\u0010\t\u001a\u0004\b\r\u0010\bR\u0016\u0010\u000e\u001a\u00020\u0006X\u0004¢\u0006\n\n\u0002\u0010\t\u001a\u0004\b\u000f\u0010\bR\u0016\u0010\u0010\u001a\u00020\u0006X\u0004¢\u0006\n\n\u0002\u0010\t\u001a\u0004\b\u0011\u0010\bR\u0016\u0010\u0012\u001a\u00020\u0006X\u0004¢\u0006\n\n\u0002\u0010\t\u001a\u0004\b\u0013\u0010\bR\"\u0010\u0014\u001a\u0010\u0012\f\u0012\n \u0017*\u0004\u0018\u00010\u00160\u00160\u0015X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\"\u0010\u001a\u001a\u0010\u0012\f\u0012\n \u0017*\u0004\u0018\u00010\u001c0\u001c0\u001bX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001eR\"\u0010\u001f\u001a\u0010\u0012\f\u0012\n \u0017*\u0004\u0018\u00010 0 0\u001bX\u0004¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\u001eR\"\u0010\"\u001a\u0010\u0012\f\u0012\n \u0017*\u0004\u0018\u00010#0#0\u001bX\u0004¢\u0006\b\n\u0000\u001a\u0004\b$\u0010\u001eR\u0014\u0010%\u001a\u00020&X\u0004¢\u0006\b\n\u0000\u001a\u0004\b'\u0010(R\"\u0010)\u001a\u0010\u0012\f\u0012\n \u0017*\u0004\u0018\u00010+0+0*X\u0004¢\u0006\b\n\u0000\u001a\u0004\b,\u0010-R\"\u0010.\u001a\u0010\u0012\f\u0012\n \u0017*\u0004\u0018\u00010/0/0\u001bX\u0004¢\u0006\b\n\u0000\u001a\u0004\b0\u0010\u001eR:\u00101\u001a(\u0012$\u0012\"\u0012\u0004\u0012\u000203\u0012\u0004\u0012\u00020\u0006 \u0017*\u0010\u0012\u0004\u0012\u000203\u0012\u0004\u0012\u00020\u0006\u0018\u000102020\u001bX\u0004¢\u0006\b\n\u0000\u001a\u0004\b4\u0010\u001eR:\u00105\u001a(\u0012$\u0012\"\u0012\u0004\u0012\u00020 \u0012\u0004\u0012\u00020\u0006 \u0017*\u0010\u0012\u0004\u0012\u00020 \u0012\u0004\u0012\u00020\u0006\u0018\u000102020\u001bX\u0004¢\u0006\b\n\u0000\u001a\u0004\b6\u0010\u001eR:\u00107\u001a(\u0012$\u0012\"\u0012\u0004\u0012\u00020+\u0012\u0004\u0012\u00020\u0006 \u0017*\u0010\u0012\u0004\u0012\u00020+\u0012\u0004\u0012\u00020\u0006\u0018\u000102020\u001bX\u0004¢\u0006\b\n\u0000\u001a\u0004\b8\u0010\u001eR\"\u00109\u001a\u0010\u0012\f\u0012\n \u0017*\u0004\u0018\u00010 0 0\u001bX\u0004¢\u0006\b\n\u0000\u001a\u0004\b:\u0010\u001eR \u0010;\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002030<0\u001bX\u0004¢\u0006\b\n\u0000\u001a\u0004\b=\u0010\u001eR\"\u0010>\u001a\u0010\u0012\f\u0012\n \u0017*\u0004\u0018\u00010?0?0\u001bX\u0004¢\u0006\b\n\u0000\u001a\u0004\b@\u0010\u001eR\u0014\u0010A\u001a\u00020BX\u0004¢\u0006\b\n\u0000\u001a\u0004\bC\u0010DR\"\u0010E\u001a\u0010\u0012\f\u0012\n \u0017*\u0004\u0018\u00010F0F0\u001bX\u0004¢\u0006\b\n\u0000\u001a\u0004\bG\u0010\u001eR\"\u0010H\u001a\u0010\u0012\f\u0012\n \u0017*\u0004\u0018\u00010I0I0\u001bX\u0004¢\u0006\b\n\u0000\u001a\u0004\bJ\u0010\u001eR\"\u0010K\u001a\u0010\u0012\f\u0012\n \u0017*\u0004\u0018\u00010 0 0\u001bX\u0004¢\u0006\b\n\u0000\u001a\u0004\bL\u0010\u001eR\"\u0010M\u001a\u0010\u0012\f\u0012\n \u0017*\u0004\u0018\u00010 0 0\u001bX\u0004¢\u0006\b\n\u0000\u001a\u0004\bN\u0010\u001e¨\u0006P"}, d2 = {"Lcom/talabat/gem/adapters/presentation/payment/GemOfferProcessingViewModel;", "Landroidx/lifecycle/ViewModel;", "Lcom/talabat/talabatcommon/lifecycle/AutoDisposable;", "Lcom/talabat/gem/ports/presentation/GemOfferProcessingViewPort;", "()V", "bindCounterAndVisibility", "", "getBindCounterAndVisibility", "()Lkotlin/Unit;", "Lkotlin/Unit;", "bindCounterExpired", "getBindCounterExpired", "bindOffer", "getBindOffer", "bindSelectedGemRestaurant", "getBindSelectedGemRestaurant", "bindSelectedRestaurantId", "getBindSelectedRestaurantId", "bindVisibilityPerRestaurant", "getBindVisibilityPerRestaurant", "configurations", "Lio/reactivex/subjects/ReplaySubject;", "Lcom/talabat/gem/adapters/presentation/GemOfferProcessingConfigurations;", "kotlin.jvm.PlatformType", "getConfigurations$com_talabat_Components_gem_gem", "()Lio/reactivex/subjects/ReplaySubject;", "counter", "Lio/reactivex/subjects/BehaviorSubject;", "", "getCounter", "()Lio/reactivex/subjects/BehaviorSubject;", "counterExpired", "", "getCounterExpired", "counterSubscription", "Lio/reactivex/disposables/Disposable;", "getCounterSubscription", "disposables", "Lio/reactivex/disposables/CompositeDisposable;", "getDisposables", "()Lio/reactivex/disposables/CompositeDisposable;", "errors", "Lio/reactivex/subjects/PublishSubject;", "", "getErrors", "()Lio/reactivex/subjects/PublishSubject;", "offer", "Lcom/talabat/gem/domain/entities/GemOffer;", "getOffer", "onProcessed", "Lkotlin/Function1;", "Lcom/talabat/gem/domain/entities/GemOfferAcceptance;", "getOnProcessed$com_talabat_Components_gem_gem", "onProcessing", "getOnProcessing$com_talabat_Components_gem_gem", "onProcessingError", "getOnProcessingError$com_talabat_Components_gem_gem", "processing", "getProcessing", "processingResult", "Lcom/talabat/talabatcommon/extentions/SingleAccess;", "getProcessingResult", "remainingSeconds", "", "getRemainingSeconds", "scheduler", "Lio/reactivex/Scheduler;", "getScheduler", "()Lio/reactivex/Scheduler;", "selectedGemRestaurant", "Lcom/talabat/gem/domain/entities/GemRestaurant;", "getSelectedGemRestaurant", "selectedRestaurantId", "", "getSelectedRestaurantId", "visibility", "getVisibility", "visibilityPerRestaurant", "getVisibilityPerRestaurant", "onCleared", "com_talabat_Components_gem_gem"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class GemOfferProcessingViewModel extends ViewModel implements AutoDisposable, GemOfferProcessingViewPort {
    @NotNull
    private final Unit bindCounterAndVisibility;
    @NotNull
    private final Unit bindCounterExpired;
    @NotNull
    private final Unit bindOffer;
    @NotNull
    private final Unit bindSelectedGemRestaurant;
    @NotNull
    private final Unit bindSelectedRestaurantId;
    @NotNull
    private final Unit bindVisibilityPerRestaurant;
    @NotNull
    private final ReplaySubject<GemOfferProcessingConfigurations> configurations;
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
    private final BehaviorSubject<GemOffer> offer;
    @NotNull
    private final BehaviorSubject<Function1<GemOfferAcceptance, Unit>> onProcessed;
    @NotNull
    private final BehaviorSubject<Function1<Boolean, Unit>> onProcessing;
    @NotNull
    private final BehaviorSubject<Function1<Throwable, Unit>> onProcessingError;
    @NotNull
    private final BehaviorSubject<Boolean> processing;
    @NotNull
    private final BehaviorSubject<SingleAccess<GemOfferAcceptance>> processingResult;
    @NotNull
    private final BehaviorSubject<Long> remainingSeconds;
    @NotNull
    private final Scheduler scheduler;
    @NotNull
    private final BehaviorSubject<GemRestaurant> selectedGemRestaurant;
    @NotNull
    private final BehaviorSubject<Integer> selectedRestaurantId;
    @NotNull
    private final BehaviorSubject<Boolean> visibility;
    @NotNull
    private final BehaviorSubject<Boolean> visibilityPerRestaurant;

    public GemOfferProcessingViewModel() {
        Scheduler io2 = Schedulers.io();
        Intrinsics.checkNotNullExpressionValue(io2, "io()");
        this.scheduler = io2;
        BehaviorSubject<Integer> create = BehaviorSubject.create();
        Intrinsics.checkNotNullExpressionValue(create, "create<Int>()");
        this.selectedRestaurantId = create;
        BehaviorSubject<GemRestaurant> create2 = BehaviorSubject.create();
        Intrinsics.checkNotNullExpressionValue(create2, "create<GemRestaurant>()");
        this.selectedGemRestaurant = create2;
        BehaviorSubject<Boolean> create3 = BehaviorSubject.create();
        Intrinsics.checkNotNullExpressionValue(create3, "create<Boolean>()");
        this.visibilityPerRestaurant = create3;
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
        BehaviorSubject<Boolean> create9 = BehaviorSubject.create();
        Intrinsics.checkNotNullExpressionValue(create9, "create<Boolean>()");
        this.processing = create9;
        BehaviorSubject<Boolean> create10 = BehaviorSubject.create();
        Intrinsics.checkNotNullExpressionValue(create10, "create<Boolean>()");
        this.counterExpired = create10;
        BehaviorSubject<Long> create11 = BehaviorSubject.create();
        Intrinsics.checkNotNullExpressionValue(create11, "create<Long>()");
        this.remainingSeconds = create11;
        GemCounterBusinessRulesKt.bindCounterExpired(this);
        Unit unit = Unit.INSTANCE;
        this.bindCounterExpired = unit;
        GemPerRestaurantBusinessRulesKt.bindSelectedGemRestaurant(this);
        this.bindSelectedGemRestaurant = unit;
        GemPerRestaurantBusinessRulesKt.bindSelectedRestaurantId(this);
        this.bindSelectedRestaurantId = unit;
        GemPerRestaurantBusinessRulesKt.bindVisibilityPerRestaurant(this);
        this.bindVisibilityPerRestaurant = unit;
        GemCounterBusinessRulesKt.bindCounterAndVisibility$default(this, (Long) null, 1, (Object) null);
        this.bindCounterAndVisibility = unit;
        GemViewBusinessRulesKt.bindOffer$default(this, GemOfferRequester.Existing.INSTANCE, (Function1) null, 2, (Object) null);
        this.bindOffer = unit;
        this.processingResult = RxKt.SingleAccessSubject$default((Object) null, 1, (Object) null);
        this.configurations = ConfigurationsKt.Configurations();
        BehaviorSubject<Function1<GemOfferAcceptance, Unit>> create12 = BehaviorSubject.create();
        Intrinsics.checkNotNullExpressionValue(create12, "create<(GemOfferAcceptance) -> Unit>()");
        this.onProcessed = create12;
        BehaviorSubject<Function1<Throwable, Unit>> create13 = BehaviorSubject.create();
        Intrinsics.checkNotNullExpressionValue(create13, "create<(Throwable) -> Unit>()");
        this.onProcessingError = create13;
        BehaviorSubject<Function1<Boolean, Unit>> create14 = BehaviorSubject.create();
        Intrinsics.checkNotNullExpressionValue(create14, "create<(Boolean) -> Unit>()");
        this.onProcessing = create14;
        GemOfferProcessingKt.onInitialize(this);
    }

    @AutoDisposableDsl
    public void autoDispose(@NotNull Function0<? extends Disposable> function0) {
        AutoDisposable.DefaultImpls.autoDispose(this, function0);
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
    public Unit getBindOffer() {
        return this.bindOffer;
    }

    @NotNull
    public Unit getBindSelectedGemRestaurant() {
        return this.bindSelectedGemRestaurant;
    }

    @NotNull
    public Unit getBindSelectedRestaurantId() {
        return this.bindSelectedRestaurantId;
    }

    @NotNull
    public Unit getBindVisibilityPerRestaurant() {
        return this.bindVisibilityPerRestaurant;
    }

    @NotNull
    public final ReplaySubject<GemOfferProcessingConfigurations> getConfigurations$com_talabat_Components_gem_gem() {
        return this.configurations;
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
    public BehaviorSubject<GemOffer> getOffer() {
        return this.offer;
    }

    @NotNull
    public final BehaviorSubject<Function1<GemOfferAcceptance, Unit>> getOnProcessed$com_talabat_Components_gem_gem() {
        return this.onProcessed;
    }

    @NotNull
    public final BehaviorSubject<Function1<Boolean, Unit>> getOnProcessing$com_talabat_Components_gem_gem() {
        return this.onProcessing;
    }

    @NotNull
    public final BehaviorSubject<Function1<Throwable, Unit>> getOnProcessingError$com_talabat_Components_gem_gem() {
        return this.onProcessingError;
    }

    @NotNull
    public BehaviorSubject<Boolean> getProcessing() {
        return this.processing;
    }

    @NotNull
    public BehaviorSubject<SingleAccess<GemOfferAcceptance>> getProcessingResult() {
        return this.processingResult;
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
    public BehaviorSubject<Boolean> getVisibility() {
        return this.visibility;
    }

    @NotNull
    public BehaviorSubject<Boolean> getVisibilityPerRestaurant() {
        return this.visibilityPerRestaurant;
    }

    public void onCleared() {
        GemOfferProcessingViewPort.DefaultImpls.onCleared(this);
    }

    @AutoDisposableDsl
    public void onClearedImplementation() {
        AutoDisposable.DefaultImpls.onClearedImplementation(this);
    }

    @NotNull
    public PublishSubject<Throwable> getErrors() {
        return this.errors;
    }
}
