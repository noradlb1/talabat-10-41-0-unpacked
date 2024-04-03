package com.talabat.gem.adapters.presentation.restaurants;

import androidx.lifecycle.ViewModel;
import com.talabat.gem.domain.entities.GemMode;
import com.talabat.gem.domain.entities.GemOffer;
import com.talabat.gem.domain.entities.Location;
import com.talabat.gem.domain.usecases.GemAutoTriggerOfferBusinessRulesKt;
import com.talabat.gem.domain.usecases.GemCounterBusinessRulesKt;
import com.talabat.gem.domain.usecases.GemEntryBusinessRulesKt;
import com.talabat.gem.domain.usecases.GemOfferRequester;
import com.talabat.gem.domain.usecases.GemRefreshableBusinessRulesKt;
import com.talabat.gem.domain.usecases.GemViewBusinessRulesKt;
import com.talabat.gem.domain.usecases.SaveUpToAmountText;
import com.talabat.gem.ports.presentation.GemAutoTriggerOfferViewPort;
import com.talabat.gem.ports.presentation.GemEntryViewPort;
import com.talabat.gem.ports.presentation.GemRefreshableViewPort;
import com.talabat.talabatcommon.extentions.Flag;
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

@Metadata(d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0010\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0000\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u0004B\u0005¢\u0006\u0002\u0010\u0005J\b\u0010J\u001a\u00020\rH\u0016R\"\u0010\u0006\u001a\u0010\u0012\f\u0012\n \t*\u0004\u0018\u00010\b0\b0\u0007X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0016\u0010\f\u001a\u00020\rX\u0004¢\u0006\n\n\u0002\u0010\u0010\u001a\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0011\u001a\u00020\rX\u0004¢\u0006\n\n\u0002\u0010\u0010\u001a\u0004\b\u0012\u0010\u000fR\u0016\u0010\u0013\u001a\u00020\rX\u0004¢\u0006\n\n\u0002\u0010\u0010\u001a\u0004\b\u0014\u0010\u000fR\u0016\u0010\u0015\u001a\u00020\rX\u0004¢\u0006\n\n\u0002\u0010\u0010\u001a\u0004\b\u0016\u0010\u000fR\u0016\u0010\u0017\u001a\u00020\rX\u0004¢\u0006\n\n\u0002\u0010\u0010\u001a\u0004\b\u0018\u0010\u000fR\u0016\u0010\u0019\u001a\u00020\rX\u0004¢\u0006\n\n\u0002\u0010\u0010\u001a\u0004\b\u001a\u0010\u000fR\u0016\u0010\u001b\u001a\u00020\rX\u0004¢\u0006\n\n\u0002\u0010\u0010\u001a\u0004\b\u001c\u0010\u000fR\"\u0010\u001d\u001a\u0010\u0012\f\u0012\n \t*\u0004\u0018\u00010\u001e0\u001e0\u0007X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u000bR\"\u0010 \u001a\u0010\u0012\f\u0012\n \t*\u0004\u0018\u00010!0!0\u0007X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u000bR\"\u0010#\u001a\u0010\u0012\f\u0012\n \t*\u0004\u0018\u00010$0$0\u0007X\u0004¢\u0006\b\n\u0000\u001a\u0004\b%\u0010\u000bR\u0014\u0010&\u001a\u00020'X\u0004¢\u0006\b\n\u0000\u001a\u0004\b(\u0010)R\"\u0010*\u001a\u0010\u0012\f\u0012\n \t*\u0004\u0018\u00010,0,0+X\u0004¢\u0006\b\n\u0000\u001a\u0004\b-\u0010.R\u001a\u0010/\u001a\b\u0012\u0004\u0012\u00020\u001e00X\u0004¢\u0006\b\n\u0000\u001a\u0004\b1\u00102R\u001a\u00103\u001a\b\u0012\u0004\u0012\u00020400X\u0004¢\u0006\b\n\u0000\u001a\u0004\b5\u00102R\"\u00106\u001a\u0010\u0012\f\u0012\n \t*\u0004\u0018\u000107070\u0007X\u0004¢\u0006\b\n\u0000\u001a\u0004\b8\u0010\u000bR\"\u00109\u001a\u0010\u0012\f\u0012\n \t*\u0004\u0018\u00010:0:0\u0007X\u0004¢\u0006\b\n\u0000\u001a\u0004\b;\u0010\u000bR\"\u0010<\u001a\u0010\u0012\f\u0012\n \t*\u0004\u0018\u000104040\u0007X\u0004¢\u0006\b\n\u0000\u001a\u0004\b=\u0010\u000bR\"\u0010>\u001a\u0010\u0012\f\u0012\n \t*\u0004\u0018\u00010?0?0\u0007X\u0004¢\u0006\b\n\u0000\u001a\u0004\b@\u0010\u000bR\"\u0010A\u001a\u0010\u0012\f\u0012\n \t*\u0004\u0018\u00010B0B0\u0007X\u0004¢\u0006\b\n\u0000\u001a\u0004\bC\u0010\u000bR\u0014\u0010D\u001a\u00020EX\u0004¢\u0006\b\n\u0000\u001a\u0004\bF\u0010GR\"\u0010H\u001a\u0010\u0012\f\u0012\n \t*\u0004\u0018\u00010!0!0\u0007X\u0004¢\u0006\b\n\u0000\u001a\u0004\bI\u0010\u000b¨\u0006K"}, d2 = {"Lcom/talabat/gem/adapters/presentation/restaurants/GemFloatingViewModel;", "Landroidx/lifecycle/ViewModel;", "Lcom/talabat/gem/ports/presentation/GemEntryViewPort;", "Lcom/talabat/gem/ports/presentation/GemAutoTriggerOfferViewPort;", "Lcom/talabat/gem/ports/presentation/GemRefreshableViewPort;", "()V", "autoTriggerOffer", "Lio/reactivex/subjects/BehaviorSubject;", "Lcom/talabat/talabatcommon/extentions/Flag;", "kotlin.jvm.PlatformType", "getAutoTriggerOffer", "()Lio/reactivex/subjects/BehaviorSubject;", "bindAutoTriggerOffer", "", "getBindAutoTriggerOffer", "()Lkotlin/Unit;", "Lkotlin/Unit;", "bindCounterAndVisibility", "getBindCounterAndVisibility", "bindCounterExpired", "getBindCounterExpired", "bindLocalizationHistory", "getBindLocalizationHistory", "bindLocationsHistory", "getBindLocationsHistory", "bindOffer", "getBindOffer", "bindSaveUpToAmountText", "getBindSaveUpToAmountText", "counter", "", "getCounter", "counterExpired", "", "getCounterExpired", "counterSubscription", "Lio/reactivex/disposables/Disposable;", "getCounterSubscription", "disposables", "Lio/reactivex/disposables/CompositeDisposable;", "getDisposables", "()Lio/reactivex/disposables/CompositeDisposable;", "errors", "Lio/reactivex/subjects/PublishSubject;", "", "getErrors", "()Lio/reactivex/subjects/PublishSubject;", "localizationHistory", "Lio/reactivex/subjects/ReplaySubject;", "getLocalizationHistory", "()Lio/reactivex/subjects/ReplaySubject;", "locationsHistory", "Lcom/talabat/gem/domain/entities/Location;", "getLocationsHistory", "mode", "Lcom/talabat/gem/domain/entities/GemMode;", "getMode", "offer", "Lcom/talabat/gem/domain/entities/GemOffer;", "getOffer", "refreshedLocation", "getRefreshedLocation", "remainingSeconds", "", "getRemainingSeconds", "saveUpToAmountText", "Lcom/talabat/gem/domain/usecases/SaveUpToAmountText;", "getSaveUpToAmountText", "scheduler", "Lio/reactivex/Scheduler;", "getScheduler", "()Lio/reactivex/Scheduler;", "visibility", "getVisibility", "onCleared", "com_talabat_Components_gem_gem"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class GemFloatingViewModel extends ViewModel implements GemEntryViewPort, GemAutoTriggerOfferViewPort, GemRefreshableViewPort {
    @NotNull
    private final BehaviorSubject<Flag> autoTriggerOffer;
    @NotNull
    private final Unit bindAutoTriggerOffer;
    @NotNull
    private final Unit bindCounterAndVisibility;
    @NotNull
    private final Unit bindCounterExpired;
    @NotNull
    private final Unit bindLocalizationHistory;
    @NotNull
    private final Unit bindLocationsHistory;
    @NotNull
    private final Unit bindOffer;
    @NotNull
    private final Unit bindSaveUpToAmountText;
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
    private final ReplaySubject<String> localizationHistory;
    @NotNull
    private final ReplaySubject<Location> locationsHistory;
    @NotNull
    private final BehaviorSubject<GemMode> mode;
    @NotNull
    private final BehaviorSubject<GemOffer> offer;
    @NotNull
    private final BehaviorSubject<Location> refreshedLocation;
    @NotNull
    private final BehaviorSubject<Long> remainingSeconds;
    @NotNull
    private final BehaviorSubject<SaveUpToAmountText> saveUpToAmountText;
    @NotNull
    private final Scheduler scheduler;
    @NotNull
    private final BehaviorSubject<Boolean> visibility;

    public GemFloatingViewModel() {
        Scheduler io2 = Schedulers.io();
        Intrinsics.checkNotNullExpressionValue(io2, "io()");
        this.scheduler = io2;
        PublishSubject<Throwable> create = PublishSubject.create();
        Intrinsics.checkNotNullExpressionValue(create, "create<Throwable>()");
        this.errors = create;
        BehaviorSubject<Boolean> create2 = BehaviorSubject.create();
        Intrinsics.checkNotNullExpressionValue(create2, "create<Boolean>()");
        this.visibility = create2;
        BehaviorSubject<GemOffer> create3 = BehaviorSubject.create();
        Intrinsics.checkNotNullExpressionValue(create3, "create<GemOffer>()");
        this.offer = create3;
        BehaviorSubject<String> create4 = BehaviorSubject.create();
        Intrinsics.checkNotNullExpressionValue(create4, "create<String>()");
        this.counter = create4;
        BehaviorSubject<Disposable> create5 = BehaviorSubject.create();
        Intrinsics.checkNotNullExpressionValue(create5, "create<Disposable>()");
        this.counterSubscription = create5;
        BehaviorSubject<SaveUpToAmountText> create6 = BehaviorSubject.create();
        Intrinsics.checkNotNullExpressionValue(create6, "create<SaveUpToAmountText>()");
        this.saveUpToAmountText = create6;
        BehaviorSubject<Flag> create7 = BehaviorSubject.create();
        Intrinsics.checkNotNullExpressionValue(create7, "create<Flag>()");
        this.autoTriggerOffer = create7;
        BehaviorSubject<Boolean> create8 = BehaviorSubject.create();
        Intrinsics.checkNotNullExpressionValue(create8, "create<Boolean>()");
        this.counterExpired = create8;
        BehaviorSubject<Long> create9 = BehaviorSubject.create();
        Intrinsics.checkNotNullExpressionValue(create9, "create<Long>()");
        this.remainingSeconds = create9;
        BehaviorSubject<Location> create10 = BehaviorSubject.create();
        Intrinsics.checkNotNullExpressionValue(create10, "create<Location>()");
        this.refreshedLocation = create10;
        this.mode = GemAutoTriggerOfferBusinessRulesKt.createGemMode(this);
        this.locationsHistory = GemRefreshableBusinessRulesKt.createLocationsSubject(this);
        this.localizationHistory = GemRefreshableBusinessRulesKt.createLocalizationSubject(this);
        GemRefreshableBusinessRulesKt.bindLocalizationHistory$default(this, (Function0) null, 1, (Object) null);
        Unit unit = Unit.INSTANCE;
        this.bindLocalizationHistory = unit;
        GemRefreshableBusinessRulesKt.bindLocationsHistory$default(this, (Function0) null, 1, (Object) null);
        this.bindLocationsHistory = unit;
        GemCounterBusinessRulesKt.bindCounterExpired(this);
        this.bindCounterExpired = unit;
        GemViewBusinessRulesKt.bindOffer$default(this, GemOfferRequester.Existing.INSTANCE, (Function1) null, 2, (Object) null);
        this.bindOffer = unit;
        GemCounterBusinessRulesKt.bindCounterAndVisibility$default(this, (Long) null, 1, (Object) null);
        this.bindCounterAndVisibility = unit;
        GemAutoTriggerOfferBusinessRulesKt.bindAutoTriggerOffer(this);
        this.bindAutoTriggerOffer = unit;
        GemEntryBusinessRulesKt.bindSaveUpToAmountText(this);
        this.bindSaveUpToAmountText = unit;
    }

    @AutoDisposableDsl
    public void autoDispose(@NotNull Function0<? extends Disposable> function0) {
        GemEntryViewPort.DefaultImpls.autoDispose(this, function0);
    }

    @NotNull
    public BehaviorSubject<Flag> getAutoTriggerOffer() {
        return this.autoTriggerOffer;
    }

    @NotNull
    public Unit getBindAutoTriggerOffer() {
        return this.bindAutoTriggerOffer;
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
    public Unit getBindLocalizationHistory() {
        return this.bindLocalizationHistory;
    }

    @NotNull
    public Unit getBindLocationsHistory() {
        return this.bindLocationsHistory;
    }

    @NotNull
    public Unit getBindOffer() {
        return this.bindOffer;
    }

    @NotNull
    public Unit getBindSaveUpToAmountText() {
        return this.bindSaveUpToAmountText;
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
    public ReplaySubject<String> getLocalizationHistory() {
        return this.localizationHistory;
    }

    @NotNull
    public ReplaySubject<Location> getLocationsHistory() {
        return this.locationsHistory;
    }

    @NotNull
    public BehaviorSubject<GemMode> getMode() {
        return this.mode;
    }

    @NotNull
    public BehaviorSubject<GemOffer> getOffer() {
        return this.offer;
    }

    @NotNull
    public BehaviorSubject<Location> getRefreshedLocation() {
        return this.refreshedLocation;
    }

    @NotNull
    public BehaviorSubject<Long> getRemainingSeconds() {
        return this.remainingSeconds;
    }

    @NotNull
    public BehaviorSubject<SaveUpToAmountText> getSaveUpToAmountText() {
        return this.saveUpToAmountText;
    }

    @NotNull
    public Scheduler getScheduler() {
        return this.scheduler;
    }

    @NotNull
    public BehaviorSubject<Boolean> getVisibility() {
        return this.visibility;
    }

    public void onCleared() {
        GemEntryViewPort.DefaultImpls.onCleared(this);
    }

    @AutoDisposableDsl
    public void onClearedImplementation() {
        GemEntryViewPort.DefaultImpls.onClearedImplementation(this);
    }

    @NotNull
    public PublishSubject<Throwable> getErrors() {
        return this.errors;
    }
}
