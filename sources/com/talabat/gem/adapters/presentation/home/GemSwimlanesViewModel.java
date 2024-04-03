package com.talabat.gem.adapters.presentation.home;

import androidx.lifecycle.ViewModel;
import com.talabat.gem.domain.entities.GemOffer;
import com.talabat.gem.domain.entities.GemRestaurant;
import com.talabat.gem.domain.entities.Location;
import com.talabat.gem.domain.usecases.GemCounterBusinessRulesKt;
import com.talabat.gem.domain.usecases.GemEntryBusinessRulesKt;
import com.talabat.gem.domain.usecases.GemOfferRequester;
import com.talabat.gem.domain.usecases.GemRefreshableBusinessRulesKt;
import com.talabat.gem.domain.usecases.GemRestaurantsBusinessRulesKt;
import com.talabat.gem.domain.usecases.GemViewBusinessRulesKt;
import com.talabat.gem.domain.usecases.SaveUpToAmountText;
import com.talabat.gem.ports.presentation.GemEntryViewPort;
import com.talabat.gem.ports.presentation.GemRefreshableViewPort;
import com.talabat.gem.ports.presentation.GemRestaurantsViewPort;
import com.talabat.talabatcommon.lifecycle.AutoDisposableDsl;
import io.reactivex.Scheduler;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import io.reactivex.subjects.BehaviorSubject;
import io.reactivex.subjects.PublishSubject;
import io.reactivex.subjects.ReplaySubject;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u0004B\u0005¢\u0006\u0002\u0010\u0005J\b\u0010I\u001a\u00020\u0007H\u0016R\u0016\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\n\n\u0002\u0010\n\u001a\u0004\b\b\u0010\tR\u0016\u0010\u000b\u001a\u00020\u0007X\u0004¢\u0006\n\n\u0002\u0010\n\u001a\u0004\b\f\u0010\tR\u0016\u0010\r\u001a\u00020\u0007X\u0004¢\u0006\n\n\u0002\u0010\n\u001a\u0004\b\u000e\u0010\tR\u0016\u0010\u000f\u001a\u00020\u0007X\u0004¢\u0006\n\n\u0002\u0010\n\u001a\u0004\b\u0010\u0010\tR\u0016\u0010\u0011\u001a\u00020\u0007X\u0004¢\u0006\n\n\u0002\u0010\n\u001a\u0004\b\u0012\u0010\tR\u0016\u0010\u0013\u001a\u00020\u0007X\u0004¢\u0006\n\n\u0002\u0010\n\u001a\u0004\b\u0014\u0010\tR\u0016\u0010\u0015\u001a\u00020\u0007X\u0004¢\u0006\n\n\u0002\u0010\n\u001a\u0004\b\u0016\u0010\tR\"\u0010\u0017\u001a\u0010\u0012\f\u0012\n \u001a*\u0004\u0018\u00010\u00190\u00190\u0018X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\"\u0010\u001d\u001a\u0010\u0012\f\u0012\n \u001a*\u0004\u0018\u00010\u001e0\u001e0\u0018X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u001cR\"\u0010 \u001a\u0010\u0012\f\u0012\n \u001a*\u0004\u0018\u00010!0!0\u0018X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u001cR\u0014\u0010#\u001a\u00020$X\u0004¢\u0006\b\n\u0000\u001a\u0004\b%\u0010&R\"\u0010'\u001a\u0010\u0012\f\u0012\n \u001a*\u0004\u0018\u00010)0)0(X\u0004¢\u0006\b\n\u0000\u001a\u0004\b*\u0010+R\u001a\u0010,\u001a\b\u0012\u0004\u0012\u00020\u00190-X\u0004¢\u0006\b\n\u0000\u001a\u0004\b.\u0010/R\u001a\u00100\u001a\b\u0012\u0004\u0012\u0002010-X\u0004¢\u0006\b\n\u0000\u001a\u0004\b2\u0010/R\"\u00103\u001a\u0010\u0012\f\u0012\n \u001a*\u0004\u0018\u000104040\u0018X\u0004¢\u0006\b\n\u0000\u001a\u0004\b5\u0010\u001cR\"\u00106\u001a\u0010\u0012\f\u0012\n \u001a*\u0004\u0018\u000101010\u0018X\u0004¢\u0006\b\n\u0000\u001a\u0004\b7\u0010\u001cR\"\u00108\u001a\u0010\u0012\f\u0012\n \u001a*\u0004\u0018\u000109090\u0018X\u0004¢\u0006\b\n\u0000\u001a\u0004\b:\u0010\u001cR8\u0010;\u001a&\u0012\"\u0012 \u0012\u0004\u0012\u00020= \u001a*\u0010\u0012\u0004\u0012\u00020=\u0018\u00010<j\u0004\u0018\u0001`>0<j\u0002`>0\u0018X\u0004¢\u0006\b\n\u0000\u001a\u0004\b?\u0010\u001cR\"\u0010@\u001a\u0010\u0012\f\u0012\n \u001a*\u0004\u0018\u00010A0A0\u0018X\u0004¢\u0006\b\n\u0000\u001a\u0004\bB\u0010\u001cR\u0014\u0010C\u001a\u00020DX\u0004¢\u0006\b\n\u0000\u001a\u0004\bE\u0010FR\"\u0010G\u001a\u0010\u0012\f\u0012\n \u001a*\u0004\u0018\u00010\u001e0\u001e0\u0018X\u0004¢\u0006\b\n\u0000\u001a\u0004\bH\u0010\u001c¨\u0006J"}, d2 = {"Lcom/talabat/gem/adapters/presentation/home/GemSwimlanesViewModel;", "Landroidx/lifecycle/ViewModel;", "Lcom/talabat/gem/ports/presentation/GemEntryViewPort;", "Lcom/talabat/gem/ports/presentation/GemRestaurantsViewPort;", "Lcom/talabat/gem/ports/presentation/GemRefreshableViewPort;", "()V", "bindCounterAndVisibility", "", "getBindCounterAndVisibility", "()Lkotlin/Unit;", "Lkotlin/Unit;", "bindCounterExpired", "getBindCounterExpired", "bindLocalizationHistory", "getBindLocalizationHistory", "bindLocationsHistory", "getBindLocationsHistory", "bindOffer", "getBindOffer", "bindRestaurants", "getBindRestaurants", "bindSaveUpToAmountText", "getBindSaveUpToAmountText", "counter", "Lio/reactivex/subjects/BehaviorSubject;", "", "kotlin.jvm.PlatformType", "getCounter", "()Lio/reactivex/subjects/BehaviorSubject;", "counterExpired", "", "getCounterExpired", "counterSubscription", "Lio/reactivex/disposables/Disposable;", "getCounterSubscription", "disposables", "Lio/reactivex/disposables/CompositeDisposable;", "getDisposables", "()Lio/reactivex/disposables/CompositeDisposable;", "errors", "Lio/reactivex/subjects/PublishSubject;", "", "getErrors", "()Lio/reactivex/subjects/PublishSubject;", "localizationHistory", "Lio/reactivex/subjects/ReplaySubject;", "getLocalizationHistory", "()Lio/reactivex/subjects/ReplaySubject;", "locationsHistory", "Lcom/talabat/gem/domain/entities/Location;", "getLocationsHistory", "offer", "Lcom/talabat/gem/domain/entities/GemOffer;", "getOffer", "refreshedLocation", "getRefreshedLocation", "remainingSeconds", "", "getRemainingSeconds", "restaurants", "", "Lcom/talabat/gem/domain/entities/GemRestaurant;", "Lcom/talabat/gem/domain/entities/GemRestaurants;", "getRestaurants", "saveUpToAmountText", "Lcom/talabat/gem/domain/usecases/SaveUpToAmountText;", "getSaveUpToAmountText", "scheduler", "Lio/reactivex/Scheduler;", "getScheduler", "()Lio/reactivex/Scheduler;", "visibility", "getVisibility", "onCleared", "com_talabat_Components_gem_gem"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class GemSwimlanesViewModel extends ViewModel implements GemEntryViewPort, GemRestaurantsViewPort, GemRefreshableViewPort {
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
    private final Unit bindRestaurants;
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
    private final BehaviorSubject<GemOffer> offer;
    @NotNull
    private final BehaviorSubject<Location> refreshedLocation;
    @NotNull
    private final BehaviorSubject<Long> remainingSeconds;
    @NotNull
    private final BehaviorSubject<List<GemRestaurant>> restaurants;
    @NotNull
    private final BehaviorSubject<SaveUpToAmountText> saveUpToAmountText;
    @NotNull
    private final Scheduler scheduler;
    @NotNull
    private final BehaviorSubject<Boolean> visibility;

    public GemSwimlanesViewModel() {
        Scheduler io2 = Schedulers.io();
        Intrinsics.checkNotNullExpressionValue(io2, "io()");
        this.scheduler = io2;
        PublishSubject<Throwable> create = PublishSubject.create();
        Intrinsics.checkNotNullExpressionValue(create, "create<Throwable>()");
        this.errors = create;
        BehaviorSubject<Boolean> createDefault = BehaviorSubject.createDefault(Boolean.FALSE);
        Intrinsics.checkNotNullExpressionValue(createDefault, "createDefault(false)");
        this.visibility = createDefault;
        BehaviorSubject<GemOffer> create2 = BehaviorSubject.create();
        Intrinsics.checkNotNullExpressionValue(create2, "create<GemOffer>()");
        this.offer = create2;
        BehaviorSubject<String> create3 = BehaviorSubject.create();
        Intrinsics.checkNotNullExpressionValue(create3, "create<String>()");
        this.counter = create3;
        BehaviorSubject<Disposable> create4 = BehaviorSubject.create();
        Intrinsics.checkNotNullExpressionValue(create4, "create<Disposable>()");
        this.counterSubscription = create4;
        BehaviorSubject<SaveUpToAmountText> create5 = BehaviorSubject.create();
        Intrinsics.checkNotNullExpressionValue(create5, "create<SaveUpToAmountText>()");
        this.saveUpToAmountText = create5;
        BehaviorSubject<Boolean> create6 = BehaviorSubject.create();
        Intrinsics.checkNotNullExpressionValue(create6, "create<Boolean>()");
        this.counterExpired = create6;
        BehaviorSubject<Long> create7 = BehaviorSubject.create();
        Intrinsics.checkNotNullExpressionValue(create7, "create<Long>()");
        this.remainingSeconds = create7;
        BehaviorSubject<List<GemRestaurant>> create8 = BehaviorSubject.create();
        Intrinsics.checkNotNullExpressionValue(create8, "create<GemRestaurants>()");
        this.restaurants = create8;
        BehaviorSubject<Location> create9 = BehaviorSubject.create();
        Intrinsics.checkNotNullExpressionValue(create9, "create<Location>()");
        this.refreshedLocation = create9;
        this.locationsHistory = GemRefreshableBusinessRulesKt.createLocationsSubject(this);
        GemRefreshableBusinessRulesKt.bindLocationsHistory$default(this, (Function0) null, 1, (Object) null);
        Unit unit = Unit.INSTANCE;
        this.bindLocationsHistory = unit;
        this.localizationHistory = GemRefreshableBusinessRulesKt.createLocalizationSubject(this);
        GemRefreshableBusinessRulesKt.bindLocalizationHistory$default(this, (Function0) null, 1, (Object) null);
        this.bindLocalizationHistory = unit;
        GemCounterBusinessRulesKt.bindCounterExpired(this);
        this.bindCounterExpired = unit;
        GemViewBusinessRulesKt.bindOffer$default(this, GemOfferRequester.Refresh.INSTANCE, (Function1) null, 2, (Object) null);
        this.bindOffer = unit;
        GemCounterBusinessRulesKt.bindCounterAndVisibility$default(this, (Long) null, 1, (Object) null);
        this.bindCounterAndVisibility = unit;
        GemEntryBusinessRulesKt.bindSaveUpToAmountText(this);
        this.bindSaveUpToAmountText = unit;
        GemRestaurantsBusinessRulesKt.bindRestaurants(this);
        this.bindRestaurants = unit;
    }

    @AutoDisposableDsl
    public void autoDispose(@NotNull Function0<? extends Disposable> function0) {
        GemEntryViewPort.DefaultImpls.autoDispose(this, function0);
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
    public Unit getBindRestaurants() {
        return this.bindRestaurants;
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
    public BehaviorSubject<List<GemRestaurant>> getRestaurants() {
        return this.restaurants;
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
