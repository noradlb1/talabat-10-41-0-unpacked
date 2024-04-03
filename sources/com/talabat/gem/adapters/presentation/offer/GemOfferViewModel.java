package com.talabat.gem.adapters.presentation.offer;

import androidx.lifecycle.ViewModel;
import com.talabat.gem.domain.entities.GemOffer;
import com.talabat.gem.domain.entities.GemRestaurant;
import com.talabat.gem.domain.entities.GemTier;
import com.talabat.gem.domain.usecases.GemCounterBusinessRulesKt;
import com.talabat.gem.domain.usecases.GemExpiredBusinessRulesKt;
import com.talabat.gem.domain.usecases.GemOfferRequester;
import com.talabat.gem.domain.usecases.GemPerRestaurantBusinessRulesKt;
import com.talabat.gem.domain.usecases.GemRestaurantsBusinessRulesKt;
import com.talabat.gem.domain.usecases.GemTiersBusinessRulesKt;
import com.talabat.gem.domain.usecases.GemTitleBusinessRulesKt;
import com.talabat.gem.domain.usecases.GemViewBusinessRulesKt;
import com.talabat.gem.ports.presentation.GemCounterViewPort;
import com.talabat.gem.ports.presentation.GemExpiredViewPort;
import com.talabat.gem.ports.presentation.GemOfferTitleViewPort;
import com.talabat.gem.ports.presentation.GemRestaurantsViewPort;
import com.talabat.gem.ports.presentation.GemTiersViewPort;
import com.talabat.gem.ports.presentation.TitleData;
import com.talabat.talabatcommon.lifecycle.AutoDisposableDsl;
import io.reactivex.Scheduler;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import io.reactivex.subjects.BehaviorSubject;
import io.reactivex.subjects.PublishSubject;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000¤\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\b\u0000\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u00042\u00020\u00052\u00020\u0006B\u0005¢\u0006\u0002\u0010\u0007J\b\u0010b\u001a\u00020\tH\u0016R\u0016\u0010\b\u001a\u00020\tX\u0004¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\n\u0010\u000bR\u0016\u0010\r\u001a\u00020\tX\u0004¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\u000e\u0010\u000bR\u0016\u0010\u000f\u001a\u00020\tX\u0004¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\u0010\u0010\u000bR\u0016\u0010\u0011\u001a\u00020\tX\u0004¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\u0012\u0010\u000bR\u0016\u0010\u0013\u001a\u00020\tX\u0004¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\u0014\u0010\u000bR\u0016\u0010\u0015\u001a\u00020\tX\u0004¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\u0016\u0010\u000bR\u0016\u0010\u0017\u001a\u00020\tX\u0004¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\u0018\u0010\u000bR\u0016\u0010\u0019\u001a\u00020\tX\u0004¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\u001a\u0010\u000bR\u0016\u0010\u001b\u001a\u00020\tX\u0004¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\u001c\u0010\u000bR\u0016\u0010\u001d\u001a\u00020\tX\u0004¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\u001e\u0010\u000bR\u0016\u0010\u001f\u001a\u00020\tX\u0004¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b \u0010\u000bR\u0016\u0010!\u001a\u00020\tX\u0004¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\"\u0010\u000bR\u0016\u0010#\u001a\u00020\tX\u0004¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b$\u0010\u000bR\"\u0010%\u001a\u0010\u0012\f\u0012\n (*\u0004\u0018\u00010'0'0&X\u0004¢\u0006\b\n\u0000\u001a\u0004\b)\u0010*R\"\u0010+\u001a\u0010\u0012\f\u0012\n (*\u0004\u0018\u00010,0,0&X\u0004¢\u0006\b\n\u0000\u001a\u0004\b-\u0010*R\"\u0010.\u001a\u0010\u0012\f\u0012\n (*\u0004\u0018\u00010/0/0&X\u0004¢\u0006\b\n\u0000\u001a\u0004\b0\u0010*R\u0014\u00101\u001a\u000202X\u0004¢\u0006\b\n\u0000\u001a\u0004\b3\u00104R\"\u00105\u001a\u0010\u0012\f\u0012\n (*\u0004\u0018\u0001070706X\u0004¢\u0006\b\n\u0000\u001a\u0004\b8\u00109R\"\u0010:\u001a\u0010\u0012\f\u0012\n (*\u0004\u0018\u00010;0;0&X\u0004¢\u0006\b\n\u0000\u001a\u0004\b<\u0010*R\"\u0010=\u001a\u0010\u0012\f\u0012\n (*\u0004\u0018\u00010;0;0&X\u0004¢\u0006\b\n\u0000\u001a\u0004\b>\u0010*R\"\u0010?\u001a\u0010\u0012\f\u0012\n (*\u0004\u0018\u00010@0@0&X\u0004¢\u0006\b\n\u0000\u001a\u0004\bA\u0010*R8\u0010B\u001a&\u0012\"\u0012 \u0012\u0004\u0012\u00020D (*\u0010\u0012\u0004\u0012\u00020D\u0018\u00010Cj\u0004\u0018\u0001`E0Cj\u0002`E0&X\u0004¢\u0006\b\n\u0000\u001a\u0004\bF\u0010*R\u0014\u0010G\u001a\u00020HX\u0004¢\u0006\b\n\u0000\u001a\u0004\bI\u0010JR\"\u0010K\u001a\u0010\u0012\f\u0012\n (*\u0004\u0018\u00010D0D0&X\u0004¢\u0006\b\n\u0000\u001a\u0004\bL\u0010*R\"\u0010M\u001a\u0010\u0012\f\u0012\n (*\u0004\u0018\u00010N0N0&X\u0004¢\u0006\b\n\u0000\u001a\u0004\bO\u0010*R\"\u0010P\u001a\u0010\u0012\f\u0012\n (*\u0004\u0018\u00010,0,0&X\u0004¢\u0006\b\n\u0000\u001a\u0004\bQ\u0010*R8\u0010R\u001a&\u0012\"\u0012 \u0012\u0004\u0012\u00020S (*\u0010\u0012\u0004\u0012\u00020S\u0018\u00010Cj\u0004\u0018\u0001`T0Cj\u0002`T0&X\u0004¢\u0006\b\n\u0000\u001a\u0004\bU\u0010*R\"\u0010V\u001a\u0010\u0012\f\u0012\n (*\u0004\u0018\u00010W0W0&X\u0004¢\u0006\b\n\u0000\u001a\u0004\bX\u0010*R.\u0010Y\u001a\u001c\u0012\u0018\u0012\u0016\u0012\u0004\u0012\u00020, (*\n\u0012\u0004\u0012\u00020,\u0018\u00010Z0Z0&X\u0004¢\u0006\b\n\u0000\u001a\u0004\b[\u0010*R\"\u0010\\\u001a\u0010\u0012\f\u0012\n (*\u0004\u0018\u00010'0'0&X\u0004¢\u0006\b\n\u0000\u001a\u0004\b]\u0010*R\"\u0010^\u001a\u0010\u0012\f\u0012\n (*\u0004\u0018\u00010,0,0&X\u0004¢\u0006\b\n\u0000\u001a\u0004\b_\u0010*R\"\u0010`\u001a\u0010\u0012\f\u0012\n (*\u0004\u0018\u00010,0,0&X\u0004¢\u0006\b\n\u0000\u001a\u0004\ba\u0010*¨\u0006c"}, d2 = {"Lcom/talabat/gem/adapters/presentation/offer/GemOfferViewModel;", "Landroidx/lifecycle/ViewModel;", "Lcom/talabat/gem/ports/presentation/GemCounterViewPort;", "Lcom/talabat/gem/ports/presentation/GemTiersViewPort;", "Lcom/talabat/gem/ports/presentation/GemRestaurantsViewPort;", "Lcom/talabat/gem/ports/presentation/GemOfferTitleViewPort;", "Lcom/talabat/gem/ports/presentation/GemExpiredViewPort;", "()V", "bindCollectionTriggerExpirationAlert", "", "getBindCollectionTriggerExpirationAlert", "()Lkotlin/Unit;", "Lkotlin/Unit;", "bindCounterAndVisibility", "getBindCounterAndVisibility", "bindCounterExpired", "getBindCounterExpired", "bindExpiredOffer", "getBindExpiredOffer", "bindOffer", "getBindOffer", "bindRestaurants", "getBindRestaurants", "bindSelectedGemRestaurant", "getBindSelectedGemRestaurant", "bindStaticTiersMode", "getBindStaticTiersMode", "bindTiers", "getBindTiers", "bindTitleData", "getBindTitleData", "bindTriggerExpirationAlert", "getBindTriggerExpirationAlert", "bindUserName", "getBindUserName", "bindVisibilityPerRestaurant", "getBindVisibilityPerRestaurant", "counter", "Lio/reactivex/subjects/BehaviorSubject;", "", "kotlin.jvm.PlatformType", "getCounter", "()Lio/reactivex/subjects/BehaviorSubject;", "counterExpired", "", "getCounterExpired", "counterSubscription", "Lio/reactivex/disposables/Disposable;", "getCounterSubscription", "disposables", "Lio/reactivex/disposables/CompositeDisposable;", "getDisposables", "()Lio/reactivex/disposables/CompositeDisposable;", "errors", "Lio/reactivex/subjects/PublishSubject;", "", "getErrors", "()Lio/reactivex/subjects/PublishSubject;", "expiredOffer", "Lcom/talabat/gem/domain/entities/GemOffer;", "getExpiredOffer", "offer", "getOffer", "remainingSeconds", "", "getRemainingSeconds", "restaurants", "", "Lcom/talabat/gem/domain/entities/GemRestaurant;", "Lcom/talabat/gem/domain/entities/GemRestaurants;", "getRestaurants", "scheduler", "Lio/reactivex/Scheduler;", "getScheduler", "()Lio/reactivex/Scheduler;", "selectedGemRestaurant", "getSelectedGemRestaurant", "selectedRestaurantId", "", "getSelectedRestaurantId", "staticTiersMode", "getStaticTiersMode", "tiers", "Lcom/talabat/gem/domain/entities/GemTier;", "Lcom/talabat/gem/domain/entities/GemTiers;", "getTiers", "titleData", "Lcom/talabat/gem/ports/presentation/TitleData;", "getTitleData", "triggerExpirationAlert", "Lkotlin/Function0;", "getTriggerExpirationAlert", "userName", "getUserName", "visibility", "getVisibility", "visibilityPerRestaurant", "getVisibilityPerRestaurant", "onCleared", "com_talabat_Components_gem_gem"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class GemOfferViewModel extends ViewModel implements GemCounterViewPort, GemTiersViewPort, GemRestaurantsViewPort, GemOfferTitleViewPort, GemExpiredViewPort {
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
    private final Unit bindRestaurants;
    @NotNull
    private final Unit bindSelectedGemRestaurant;
    @NotNull
    private final Unit bindStaticTiersMode;
    @NotNull
    private final Unit bindTiers;
    @NotNull
    private final Unit bindTitleData;
    @NotNull
    private final Unit bindTriggerExpirationAlert;
    @NotNull
    private final Unit bindUserName;
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
    private final BehaviorSubject<List<GemRestaurant>> restaurants;
    @NotNull
    private final Scheduler scheduler;
    @NotNull
    private final BehaviorSubject<GemRestaurant> selectedGemRestaurant;
    @NotNull
    private final BehaviorSubject<Integer> selectedRestaurantId;
    @NotNull
    private final BehaviorSubject<Boolean> staticTiersMode;
    @NotNull
    private final BehaviorSubject<List<GemTier>> tiers;
    @NotNull
    private final BehaviorSubject<TitleData> titleData;
    @NotNull
    private final BehaviorSubject<Function0<Boolean>> triggerExpirationAlert;
    @NotNull
    private final BehaviorSubject<String> userName;
    @NotNull
    private final BehaviorSubject<Boolean> visibility;
    @NotNull
    private final BehaviorSubject<Boolean> visibilityPerRestaurant;

    public GemOfferViewModel() {
        BehaviorSubject<List<GemTier>> create = BehaviorSubject.create();
        Intrinsics.checkNotNullExpressionValue(create, "create<GemTiers>()");
        this.tiers = create;
        BehaviorSubject<List<GemRestaurant>> create2 = BehaviorSubject.create();
        Intrinsics.checkNotNullExpressionValue(create2, "create<GemRestaurants>()");
        this.restaurants = create2;
        BehaviorSubject<String> create3 = BehaviorSubject.create();
        Intrinsics.checkNotNullExpressionValue(create3, "create<String>()");
        this.counter = create3;
        BehaviorSubject<Disposable> create4 = BehaviorSubject.create();
        Intrinsics.checkNotNullExpressionValue(create4, "create<Disposable>()");
        this.counterSubscription = create4;
        Scheduler io2 = Schedulers.io();
        Intrinsics.checkNotNullExpressionValue(io2, "io()");
        this.scheduler = io2;
        BehaviorSubject<Boolean> create5 = BehaviorSubject.create();
        Intrinsics.checkNotNullExpressionValue(create5, "create<Boolean>()");
        this.visibility = create5;
        PublishSubject<Throwable> create6 = PublishSubject.create();
        Intrinsics.checkNotNullExpressionValue(create6, "create<Throwable>()");
        this.errors = create6;
        BehaviorSubject<GemOffer> create7 = BehaviorSubject.create();
        Intrinsics.checkNotNullExpressionValue(create7, "create<GemOffer>()");
        this.offer = create7;
        BehaviorSubject<Boolean> create8 = BehaviorSubject.create();
        Intrinsics.checkNotNullExpressionValue(create8, "create<Boolean>()");
        this.counterExpired = create8;
        BehaviorSubject<Long> create9 = BehaviorSubject.create();
        Intrinsics.checkNotNullExpressionValue(create9, "create<Long>()");
        this.remainingSeconds = create9;
        BehaviorSubject<String> create10 = BehaviorSubject.create();
        Intrinsics.checkNotNullExpressionValue(create10, "create<String>()");
        this.userName = create10;
        BehaviorSubject<TitleData> create11 = BehaviorSubject.create();
        Intrinsics.checkNotNullExpressionValue(create11, "create<TitleData>()");
        this.titleData = create11;
        BehaviorSubject<Boolean> create12 = BehaviorSubject.create();
        Intrinsics.checkNotNullExpressionValue(create12, "create<Boolean>()");
        this.staticTiersMode = create12;
        GemTiersBusinessRulesKt.bindStaticTiersMode(this);
        Unit unit = Unit.INSTANCE;
        this.bindStaticTiersMode = unit;
        GemCounterBusinessRulesKt.bindCounterExpired(this);
        this.bindCounterExpired = unit;
        GemCounterBusinessRulesKt.bindCounterAndVisibility$default(this, (Long) null, 1, (Object) null);
        this.bindCounterAndVisibility = unit;
        GemTiersBusinessRulesKt.bindTiers(this);
        this.bindTiers = unit;
        GemRestaurantsBusinessRulesKt.bindRestaurants(this);
        this.bindRestaurants = unit;
        GemViewBusinessRulesKt.bindOffer$default(this, GemOfferRequester.Existing.INSTANCE, (Function1) null, 2, (Object) null);
        this.bindOffer = unit;
        GemTitleBusinessRulesKt.bindUserName(this);
        this.bindUserName = unit;
        GemTitleBusinessRulesKt.bindTitleData(this);
        this.bindTitleData = unit;
        BehaviorSubject<GemOffer> create13 = BehaviorSubject.create();
        Intrinsics.checkNotNullExpressionValue(create13, "create<GemOffer>()");
        this.expiredOffer = create13;
        BehaviorSubject<Function0<Boolean>> create14 = BehaviorSubject.create();
        Intrinsics.checkNotNullExpressionValue(create14, "create<() -> Boolean>()");
        this.triggerExpirationAlert = create14;
        BehaviorSubject<Integer> create15 = BehaviorSubject.create();
        Intrinsics.checkNotNullExpressionValue(create15, "create<Int>()");
        this.selectedRestaurantId = create15;
        BehaviorSubject<GemRestaurant> create16 = BehaviorSubject.create();
        Intrinsics.checkNotNullExpressionValue(create16, "create<GemRestaurant>()");
        this.selectedGemRestaurant = create16;
        BehaviorSubject<Boolean> create17 = BehaviorSubject.create();
        Intrinsics.checkNotNullExpressionValue(create17, "create<Boolean>()");
        this.visibilityPerRestaurant = create17;
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
        GemCounterViewPort.DefaultImpls.autoDispose(this, function0);
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
    public Unit getBindRestaurants() {
        return this.bindRestaurants;
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
    public Unit getBindStaticTiersMode() {
        return this.bindStaticTiersMode;
    }

    @NotNull
    public Unit getBindTiers() {
        return this.bindTiers;
    }

    @NotNull
    public Unit getBindTitleData() {
        return this.bindTitleData;
    }

    @NotNull
    public Unit getBindTriggerExpirationAlert() {
        return this.bindTriggerExpirationAlert;
    }

    @NotNull
    public Unit getBindUserName() {
        return this.bindUserName;
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
    public BehaviorSubject<List<GemRestaurant>> getRestaurants() {
        return this.restaurants;
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
    public BehaviorSubject<Boolean> getStaticTiersMode() {
        return this.staticTiersMode;
    }

    @NotNull
    public BehaviorSubject<List<GemTier>> getTiers() {
        return this.tiers;
    }

    @NotNull
    public BehaviorSubject<TitleData> getTitleData() {
        return this.titleData;
    }

    @NotNull
    public BehaviorSubject<Function0<Boolean>> getTriggerExpirationAlert() {
        return this.triggerExpirationAlert;
    }

    @NotNull
    public BehaviorSubject<String> getUserName() {
        return this.userName;
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
        GemCounterViewPort.DefaultImpls.onClearedImplementation(this);
    }

    @NotNull
    public PublishSubject<Throwable> getErrors() {
        return this.errors;
    }
}
