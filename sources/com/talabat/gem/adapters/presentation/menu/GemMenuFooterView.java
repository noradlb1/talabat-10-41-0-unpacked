package com.talabat.gem.adapters.presentation.menu;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.RelativeLayout;
import com.instabug.library.internal.storage.cache.UserAttributesCacheManager;
import com.talabat.gem.adapters.presentation.ConfigurationsKt;
import com.talabat.gem.adapters.presentation.GemMenuFooterConfigurations;
import com.talabat.gem.adapters.presentation.GemView;
import com.talabat.gem.adapters.presentation.GemViewKt;
import com.talabat.gem.adapters.presentation.GemViewsDsl;
import com.talabat.gem.domain.entities.GemOffer;
import com.talabat.gem.domain.entities.GemRestaurant;
import com.talabat.gem.domain.entities.GemTier;
import com.talabat.gem.domain.usecases.GemCounterBusinessRulesKt;
import com.talabat.gem.domain.usecases.GemExpiredBusinessRulesKt;
import com.talabat.gem.domain.usecases.GemOfferRequester;
import com.talabat.gem.domain.usecases.GemPerRestaurantBusinessRulesKt;
import com.talabat.gem.domain.usecases.GemSubTotalBusinessRulesKt;
import com.talabat.gem.domain.usecases.GemTiersBusinessRulesKt;
import com.talabat.gem.domain.usecases.GemViewBusinessRulesKt;
import com.talabat.gem.domain.usecases.SubTotalLineOne;
import com.talabat.gem.domain.usecases.SubTotalLineTwo;
import com.talabat.gem.ports.presentation.GemExpiredViewPort;
import com.talabat.gem.ports.presentation.GemPerRestaurantViewPort;
import com.talabat.gem.ports.presentation.GemSubTotalViewPort;
import com.talabat.gem.ports.presentation.GemTiersViewPort;
import com.talabat.talabatcommon.extentions.RxKt;
import com.talabat.talabatcommon.extentions.SingleAccess;
import com.talabat.talabatcommon.lifecycle.AutoDisposableDsl;
import io.reactivex.Scheduler;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import io.reactivex.subjects.BehaviorSubject;
import io.reactivex.subjects.PublishSubject;
import io.reactivex.subjects.ReplaySubject;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000Ö\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u00042\u00020\u00052\u00020\u0006B\u0015\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0002\u0010\u000bJ\"\u0010v\u001a\u00020\r2\u0017\u0010w\u001a\u0013\u0012\u0004\u0012\u00020-\u0012\u0004\u0012\u00020\r0x¢\u0006\u0002\byH\u0002R\u0016\u0010\f\u001a\u00020\rX\u0004¢\u0006\n\n\u0002\u0010\u0010\u001a\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0011\u001a\u00020\rX\u0004¢\u0006\n\n\u0002\u0010\u0010\u001a\u0004\b\u0012\u0010\u000fR\u0016\u0010\u0013\u001a\u00020\rX\u0004¢\u0006\n\n\u0002\u0010\u0010\u001a\u0004\b\u0014\u0010\u000fR\u0016\u0010\u0015\u001a\u00020\rX\u0004¢\u0006\n\n\u0002\u0010\u0010\u001a\u0004\b\u0016\u0010\u000fR\u0016\u0010\u0017\u001a\u00020\rX\u0004¢\u0006\n\n\u0002\u0010\u0010\u001a\u0004\b\u0018\u0010\u000fR\u0016\u0010\u0019\u001a\u00020\rX\u0004¢\u0006\n\n\u0002\u0010\u0010\u001a\u0004\b\u001a\u0010\u000fR\u0016\u0010\u001b\u001a\u00020\rX\u0004¢\u0006\n\n\u0002\u0010\u0010\u001a\u0004\b\u001c\u0010\u000fR\u0016\u0010\u001d\u001a\u00020\rX\u0004¢\u0006\n\n\u0002\u0010\u0010\u001a\u0004\b\u001e\u0010\u000fR\u0016\u0010\u001f\u001a\u00020\rX\u0004¢\u0006\n\n\u0002\u0010\u0010\u001a\u0004\b \u0010\u000fR\u0016\u0010!\u001a\u00020\rX\u0004¢\u0006\n\n\u0002\u0010\u0010\u001a\u0004\b\"\u0010\u000fR\u0016\u0010#\u001a\u00020\rX\u0004¢\u0006\n\n\u0002\u0010\u0010\u001a\u0004\b$\u0010\u000fR\u0016\u0010%\u001a\u00020\rX\u0004¢\u0006\n\n\u0002\u0010\u0010\u001a\u0004\b&\u0010\u000fR\u0016\u0010'\u001a\u00020\rX\u0004¢\u0006\n\n\u0002\u0010\u0010\u001a\u0004\b(\u0010\u000fR\u0016\u0010)\u001a\u00020\rX\u0004¢\u0006\n\n\u0002\u0010\u0010\u001a\u0004\b*\u0010\u000fR\u001c\u0010+\u001a\u0010\u0012\f\u0012\n .*\u0004\u0018\u00010-0-0,X\u0004¢\u0006\u0002\n\u0000R\"\u0010/\u001a\u0010\u0012\f\u0012\n .*\u0004\u0018\u0001010100X\u0004¢\u0006\b\n\u0000\u001a\u0004\b2\u00103R\"\u00104\u001a\u0010\u0012\f\u0012\n .*\u0004\u0018\u0001050500X\u0004¢\u0006\b\n\u0000\u001a\u0004\b6\u00103R\"\u00107\u001a\u0010\u0012\f\u0012\n .*\u0004\u0018\u0001080800X\u0004¢\u0006\b\n\u0000\u001a\u0004\b9\u00103R\"\u0010:\u001a\u0010\u0012\f\u0012\n .*\u0004\u0018\u0001010100X\u0004¢\u0006\b\n\u0000\u001a\u0004\b;\u00103R\u0014\u0010<\u001a\u00020=X\u0004¢\u0006\b\n\u0000\u001a\u0004\b>\u0010?R\"\u0010@\u001a\u0010\u0012\f\u0012\n .*\u0004\u0018\u00010B0B0AX\u0004¢\u0006\b\n\u0000\u001a\u0004\bC\u0010DR\"\u0010E\u001a\u0010\u0012\f\u0012\n .*\u0004\u0018\u00010F0F00X\u0004¢\u0006\b\n\u0000\u001a\u0004\bG\u00103R\u0016\u0010H\u001a\u00020\rX\u0004¢\u0006\n\n\u0002\u0010\u0010\u001a\u0004\bI\u0010\u000fR\"\u0010J\u001a\u0010\u0012\f\u0012\n .*\u0004\u0018\u00010F0F00X\u0004¢\u0006\b\n\u0000\u001a\u0004\bK\u00103R\u001c\u0010L\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0N\u0018\u00010MX\u000e¢\u0006\u0002\n\u0000R\u001c\u0010O\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0N\u0018\u00010MX\u000e¢\u0006\u0002\n\u0000R(\u0010P\u001a\u001c\u0012\u0018\u0012\u0016\u0012\u0004\u0012\u00020\r .*\n\u0012\u0004\u0012\u00020\r\u0018\u00010N0N00X\u0004¢\u0006\u0002\n\u0000R\"\u0010Q\u001a\u0010\u0012\f\u0012\n .*\u0004\u0018\u00010R0R00X\u0004¢\u0006\b\n\u0000\u001a\u0004\bS\u00103R\u0014\u0010T\u001a\u00020UX\u0004¢\u0006\b\n\u0000\u001a\u0004\bV\u0010WR\"\u0010X\u001a\u0010\u0012\f\u0012\n .*\u0004\u0018\u00010Y0Y00X\u0004¢\u0006\b\n\u0000\u001a\u0004\bZ\u00103R\"\u0010[\u001a\u0010\u0012\f\u0012\n .*\u0004\u0018\u00010\\0\\00X\u0004¢\u0006\b\n\u0000\u001a\u0004\b]\u00103R\"\u0010^\u001a\u0010\u0012\f\u0012\n .*\u0004\u0018\u0001050500X\u0004¢\u0006\b\n\u0000\u001a\u0004\b_\u00103R\"\u0010`\u001a\u0010\u0012\f\u0012\n .*\u0004\u0018\u00010a0a00X\u0004¢\u0006\b\n\u0000\u001a\u0004\bb\u00103R\"\u0010c\u001a\u0010\u0012\f\u0012\n .*\u0004\u0018\u00010d0d00X\u0004¢\u0006\b\n\u0000\u001a\u0004\be\u00103R\"\u0010f\u001a\u0010\u0012\f\u0012\n .*\u0004\u0018\u00010g0g00X\u0004¢\u0006\b\n\u0000\u001a\u0004\bh\u00103R\"\u0010i\u001a\u0010\u0012\f\u0012\n .*\u0004\u0018\u0001050500X\u0004¢\u0006\b\n\u0000\u001a\u0004\bj\u00103R8\u0010k\u001a&\u0012\"\u0012 \u0012\u0004\u0012\u00020m .*\u0010\u0012\u0004\u0012\u00020m\u0018\u00010lj\u0004\u0018\u0001`n0lj\u0002`n00X\u0004¢\u0006\b\n\u0000\u001a\u0004\bo\u00103R.\u0010p\u001a\u001c\u0012\u0018\u0012\u0016\u0012\u0004\u0012\u000205 .*\n\u0012\u0004\u0012\u000205\u0018\u00010N0N00X\u0004¢\u0006\b\n\u0000\u001a\u0004\bq\u00103R\"\u0010r\u001a\u0010\u0012\f\u0012\n .*\u0004\u0018\u0001050500X\u0004¢\u0006\b\n\u0000\u001a\u0004\bs\u00103R\"\u0010t\u001a\u0010\u0012\f\u0012\n .*\u0004\u0018\u0001050500X\u0004¢\u0006\b\n\u0000\u001a\u0004\bu\u00103¨\u0006z"}, d2 = {"Lcom/talabat/gem/adapters/presentation/menu/GemMenuFooterView;", "Landroid/widget/RelativeLayout;", "Lcom/talabat/gem/adapters/presentation/GemView;", "Lcom/talabat/gem/ports/presentation/GemTiersViewPort;", "Lcom/talabat/gem/ports/presentation/GemPerRestaurantViewPort;", "Lcom/talabat/gem/ports/presentation/GemSubTotalViewPort;", "Lcom/talabat/gem/ports/presentation/GemExpiredViewPort;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "bindCollectionTriggerExpirationAlert", "", "getBindCollectionTriggerExpirationAlert", "()Lkotlin/Unit;", "Lkotlin/Unit;", "bindCounterAndVisibility", "getBindCounterAndVisibility", "bindCounterExpired", "getBindCounterExpired", "bindCurrency", "getBindCurrency", "bindExpiredOffer", "getBindExpiredOffer", "bindOffer", "getBindOffer", "bindSelectedGemRestaurant", "getBindSelectedGemRestaurant", "bindStaticTiersMode", "getBindStaticTiersMode", "bindSubTitleLineOne", "getBindSubTitleLineOne", "bindSubTitleLineTwo", "getBindSubTitleLineTwo", "bindSubTotalVisibility", "getBindSubTotalVisibility", "bindTiers", "getBindTiers", "bindTriggerExpirationAlert", "getBindTriggerExpirationAlert", "bindVisibilityPerRestaurant", "getBindVisibilityPerRestaurant", "configurations", "Lio/reactivex/subjects/ReplaySubject;", "Lcom/talabat/gem/adapters/presentation/GemMenuFooterConfigurations;", "kotlin.jvm.PlatformType", "counter", "Lio/reactivex/subjects/BehaviorSubject;", "", "getCounter", "()Lio/reactivex/subjects/BehaviorSubject;", "counterExpired", "", "getCounterExpired", "counterSubscription", "Lio/reactivex/disposables/Disposable;", "getCounterSubscription", "currency", "getCurrency", "disposables", "Lio/reactivex/disposables/CompositeDisposable;", "getDisposables", "()Lio/reactivex/disposables/CompositeDisposable;", "errors", "Lio/reactivex/subjects/PublishSubject;", "", "getErrors", "()Lio/reactivex/subjects/PublishSubject;", "expiredOffer", "Lcom/talabat/gem/domain/entities/GemOffer;", "getExpiredOffer", "initialize", "getInitialize", "offer", "getOffer", "onDisabledAction", "Lcom/talabat/talabatcommon/extentions/SingleAccess;", "Lkotlin/Function0;", "onEnabledAction", "onViewBasketClick", "remainingSeconds", "", "getRemainingSeconds", "scheduler", "Lio/reactivex/Scheduler;", "getScheduler", "()Lio/reactivex/Scheduler;", "selectedGemRestaurant", "Lcom/talabat/gem/domain/entities/GemRestaurant;", "getSelectedGemRestaurant", "selectedRestaurantId", "", "getSelectedRestaurantId", "staticTiersMode", "getStaticTiersMode", "subTitleLineOne", "Lcom/talabat/gem/domain/usecases/SubTotalLineOne;", "getSubTitleLineOne", "subTitleLineTwo", "Lcom/talabat/gem/domain/usecases/SubTotalLineTwo;", "getSubTitleLineTwo", "subTotal", "", "getSubTotal", "subTotalVisibility", "getSubTotalVisibility", "tiers", "", "Lcom/talabat/gem/domain/entities/GemTier;", "Lcom/talabat/gem/domain/entities/GemTiers;", "getTiers", "triggerExpirationAlert", "getTriggerExpirationAlert", "visibility", "getVisibility", "visibilityPerRestaurant", "getVisibilityPerRestaurant", "invoke", "configurationsInitializer", "Lkotlin/Function1;", "Lkotlin/ExtensionFunctionType;", "com_talabat_Components_gem_gem"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class GemMenuFooterView extends RelativeLayout implements GemView, GemTiersViewPort, GemPerRestaurantViewPort, GemSubTotalViewPort, GemExpiredViewPort {
    @NotNull
    public Map<Integer, View> _$_findViewCache = new LinkedHashMap();
    @NotNull
    private final Unit bindCollectionTriggerExpirationAlert;
    @NotNull
    private final Unit bindCounterAndVisibility;
    @NotNull
    private final Unit bindCounterExpired;
    @NotNull
    private final Unit bindCurrency;
    @NotNull
    private final Unit bindExpiredOffer;
    @NotNull
    private final Unit bindOffer;
    @NotNull
    private final Unit bindSelectedGemRestaurant;
    @NotNull
    private final Unit bindStaticTiersMode;
    @NotNull
    private final Unit bindSubTitleLineOne;
    @NotNull
    private final Unit bindSubTitleLineTwo;
    @NotNull
    private final Unit bindSubTotalVisibility;
    @NotNull
    private final Unit bindTiers;
    @NotNull
    private final Unit bindTriggerExpirationAlert;
    @NotNull
    private final Unit bindVisibilityPerRestaurant;
    /* access modifiers changed from: private */
    @NotNull
    public final ReplaySubject<GemMenuFooterConfigurations> configurations;
    @NotNull
    private final BehaviorSubject<String> counter;
    @NotNull
    private final BehaviorSubject<Boolean> counterExpired;
    @NotNull
    private final BehaviorSubject<Disposable> counterSubscription;
    @NotNull
    private final BehaviorSubject<String> currency;
    @NotNull
    private final CompositeDisposable disposables;
    @NotNull
    private final PublishSubject<Throwable> errors;
    @NotNull
    private final BehaviorSubject<GemOffer> expiredOffer;
    @NotNull
    private final Unit initialize;
    @NotNull
    private final BehaviorSubject<GemOffer> offer;
    /* access modifiers changed from: private */
    @Nullable
    public SingleAccess<Function0<Unit>> onDisabledAction;
    /* access modifiers changed from: private */
    @Nullable
    public SingleAccess<Function0<Unit>> onEnabledAction;
    /* access modifiers changed from: private */
    @NotNull
    public final BehaviorSubject<Function0<Unit>> onViewBasketClick;
    @NotNull
    private final BehaviorSubject<Long> remainingSeconds;
    @NotNull
    private final Scheduler scheduler;
    @NotNull
    private final BehaviorSubject<GemRestaurant> selectedGemRestaurant;
    @NotNull
    private final BehaviorSubject<Integer> selectedRestaurantId;
    @NotNull
    private final BehaviorSubject<Boolean> staticTiersMode;
    @NotNull
    private final BehaviorSubject<SubTotalLineOne> subTitleLineOne;
    @NotNull
    private final BehaviorSubject<SubTotalLineTwo> subTitleLineTwo;
    @NotNull
    private final BehaviorSubject<Double> subTotal;
    @NotNull
    private final BehaviorSubject<Boolean> subTotalVisibility;
    @NotNull
    private final BehaviorSubject<List<GemTier>> tiers;
    @NotNull
    private final BehaviorSubject<Function0<Boolean>> triggerExpirationAlert;
    @NotNull
    private final BehaviorSubject<Boolean> visibility;
    @NotNull
    private final BehaviorSubject<Boolean> visibilityPerRestaurant;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public GemMenuFooterView(@NotNull Context context, @NotNull AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(attributeSet, UserAttributesCacheManager.USER_ATTRIBUTES_CACHE_KEY);
        this.configurations = ConfigurationsKt.Configurations();
        BehaviorSubject<Function0<Unit>> create = BehaviorSubject.create();
        Intrinsics.checkNotNullExpressionValue(create, "create<() -> Unit>()");
        this.onViewBasketClick = create;
        this.disposables = new CompositeDisposable();
        BehaviorSubject<Integer> create2 = BehaviorSubject.create();
        Intrinsics.checkNotNullExpressionValue(create2, "create<Int>()");
        this.selectedRestaurantId = create2;
        BehaviorSubject<GemRestaurant> create3 = BehaviorSubject.create();
        Intrinsics.checkNotNullExpressionValue(create3, "create<GemRestaurant>()");
        this.selectedGemRestaurant = create3;
        BehaviorSubject<Boolean> create4 = BehaviorSubject.create();
        Intrinsics.checkNotNullExpressionValue(create4, "create<Boolean>()");
        this.visibilityPerRestaurant = create4;
        Scheduler io2 = Schedulers.io();
        Intrinsics.checkNotNullExpressionValue(io2, "io()");
        this.scheduler = io2;
        BehaviorSubject<String> create5 = BehaviorSubject.create();
        Intrinsics.checkNotNullExpressionValue(create5, "create<String>()");
        this.counter = create5;
        BehaviorSubject<Disposable> create6 = BehaviorSubject.create();
        Intrinsics.checkNotNullExpressionValue(create6, "create<Disposable>()");
        this.counterSubscription = create6;
        BehaviorSubject<Boolean> create7 = BehaviorSubject.create();
        Intrinsics.checkNotNullExpressionValue(create7, "create<Boolean>()");
        this.visibility = create7;
        PublishSubject<Throwable> create8 = PublishSubject.create();
        Intrinsics.checkNotNullExpressionValue(create8, "create<Throwable>()");
        this.errors = create8;
        BehaviorSubject<GemOffer> create9 = BehaviorSubject.create();
        Intrinsics.checkNotNullExpressionValue(create9, "create<GemOffer>()");
        this.offer = create9;
        BehaviorSubject<List<GemTier>> create10 = BehaviorSubject.create();
        Intrinsics.checkNotNullExpressionValue(create10, "create<GemTiers>()");
        this.tiers = create10;
        BehaviorSubject<Double> create11 = BehaviorSubject.create();
        Intrinsics.checkNotNullExpressionValue(create11, "create<Double>()");
        this.subTotal = create11;
        BehaviorSubject<Boolean> create12 = BehaviorSubject.create();
        Intrinsics.checkNotNullExpressionValue(create12, "create<Boolean>()");
        this.subTotalVisibility = create12;
        BehaviorSubject<String> create13 = BehaviorSubject.create();
        Intrinsics.checkNotNullExpressionValue(create13, "create<String>()");
        this.currency = create13;
        BehaviorSubject<SubTotalLineOne> create14 = BehaviorSubject.create();
        Intrinsics.checkNotNullExpressionValue(create14, "create<SubTotalLineOne>()");
        this.subTitleLineOne = create14;
        BehaviorSubject<SubTotalLineTwo> create15 = BehaviorSubject.create();
        Intrinsics.checkNotNullExpressionValue(create15, "create<SubTotalLineTwo>()");
        this.subTitleLineTwo = create15;
        BehaviorSubject<GemOffer> create16 = BehaviorSubject.create();
        Intrinsics.checkNotNullExpressionValue(create16, "create<GemOffer>()");
        this.expiredOffer = create16;
        BehaviorSubject<Function0<Boolean>> create17 = BehaviorSubject.create();
        Intrinsics.checkNotNullExpressionValue(create17, "create<() -> Boolean>()");
        this.triggerExpirationAlert = create17;
        BehaviorSubject<Boolean> create18 = BehaviorSubject.create();
        Intrinsics.checkNotNullExpressionValue(create18, "create<Boolean>()");
        this.counterExpired = create18;
        BehaviorSubject<Long> create19 = BehaviorSubject.create();
        Intrinsics.checkNotNullExpressionValue(create19, "create<Long>()");
        this.remainingSeconds = create19;
        BehaviorSubject<Boolean> create20 = BehaviorSubject.create();
        Intrinsics.checkNotNullExpressionValue(create20, "create<Boolean>()");
        this.staticTiersMode = create20;
        GemTiersBusinessRulesKt.bindStaticTiersMode(this);
        Unit unit = Unit.INSTANCE;
        this.bindStaticTiersMode = unit;
        GemCounterBusinessRulesKt.bindCounterExpired(this);
        this.bindCounterExpired = unit;
        GemPerRestaurantBusinessRulesKt.bindSelectedGemRestaurant(this);
        this.bindSelectedGemRestaurant = unit;
        GemPerRestaurantBusinessRulesKt.bindVisibilityPerRestaurant(this);
        this.bindVisibilityPerRestaurant = unit;
        GemViewBusinessRulesKt.bindOffer$default(this, GemOfferRequester.Existing.INSTANCE, (Function1) null, 2, (Object) null);
        this.bindOffer = unit;
        GemCounterBusinessRulesKt.bindCounterAndVisibility$default(this, (Long) null, 1, (Object) null);
        this.bindCounterAndVisibility = unit;
        GemTiersBusinessRulesKt.bindTiers(this);
        this.bindTiers = unit;
        GemSubTotalBusinessRulesKt.bindSubTotalVisibility(this);
        this.bindSubTotalVisibility = unit;
        GemSubTotalBusinessRulesKt.bindCurrency(this);
        this.bindCurrency = unit;
        GemSubTotalBusinessRulesKt.bindSubTitleLineOne(this);
        this.bindSubTitleLineOne = unit;
        GemSubTotalBusinessRulesKt.bindSubTitleLineTwo(this);
        this.bindSubTitleLineTwo = unit;
        GemExpiredBusinessRulesKt.bindExpiredOffer(this);
        this.bindExpiredOffer = unit;
        GemExpiredBusinessRulesKt.bindTriggerExpirationAlert(this);
        this.bindTriggerExpirationAlert = unit;
        GemExpiredBusinessRulesKt.bindCollectionTriggerExpirationAlert(this);
        this.bindCollectionTriggerExpirationAlert = unit;
        GemViewKt.withGemFlowTracking(this, context, new GemMenuFooterView$initialize$1(this, context));
        this.initialize = unit;
    }

    public void _$_clearFindViewByIdCache() {
        this._$_findViewCache.clear();
    }

    @Nullable
    public View _$_findCachedViewById(int i11) {
        Map<Integer, View> map = this._$_findViewCache;
        View view = map.get(Integer.valueOf(i11));
        if (view != null) {
            return view;
        }
        View findViewById = findViewById(i11);
        if (findViewById == null) {
            return null;
        }
        map.put(Integer.valueOf(i11), findViewById);
        return findViewById;
    }

    @AutoDisposableDsl
    public void autoDispose(@NotNull Function0<? extends Disposable> function0) {
        GemView.DefaultImpls.autoDispose(this, function0);
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
    public Unit getBindCurrency() {
        return this.bindCurrency;
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
    public Unit getBindStaticTiersMode() {
        return this.bindStaticTiersMode;
    }

    @NotNull
    public Unit getBindSubTitleLineOne() {
        return this.bindSubTitleLineOne;
    }

    @NotNull
    public Unit getBindSubTitleLineTwo() {
        return this.bindSubTitleLineTwo;
    }

    @NotNull
    public Unit getBindSubTotalVisibility() {
        return this.bindSubTotalVisibility;
    }

    @NotNull
    public Unit getBindTiers() {
        return this.bindTiers;
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
    public BehaviorSubject<String> getCurrency() {
        return this.currency;
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
    public BehaviorSubject<Boolean> getStaticTiersMode() {
        return this.staticTiersMode;
    }

    @NotNull
    public BehaviorSubject<SubTotalLineOne> getSubTitleLineOne() {
        return this.subTitleLineOne;
    }

    @NotNull
    public BehaviorSubject<SubTotalLineTwo> getSubTitleLineTwo() {
        return this.subTitleLineTwo;
    }

    @NotNull
    public BehaviorSubject<Double> getSubTotal() {
        return this.subTotal;
    }

    @NotNull
    public BehaviorSubject<Boolean> getSubTotalVisibility() {
        return this.subTotalVisibility;
    }

    @NotNull
    public BehaviorSubject<List<GemTier>> getTiers() {
        return this.tiers;
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

    @GemViewsDsl
    public final void invoke(@NotNull Function1<? super GemMenuFooterConfigurations, Unit> function1) {
        Intrinsics.checkNotNullParameter(function1, "configurationsInitializer");
        ReplaySubject<GemMenuFooterConfigurations> replaySubject = this.configurations;
        GemMenuFooterConfigurations gemMenuFooterConfigurations = new GemMenuFooterConfigurations();
        function1.invoke(gemMenuFooterConfigurations);
        RxKt.plusAssign(replaySubject, gemMenuFooterConfigurations);
    }

    public void onCleared() {
        GemView.DefaultImpls.onCleared(this);
    }

    @AutoDisposableDsl
    public void onClearedImplementation() {
        GemView.DefaultImpls.onClearedImplementation(this);
    }

    @NotNull
    public PublishSubject<Throwable> getErrors() {
        return this.errors;
    }

    @NotNull
    public Unit getInitialize() {
        return this.initialize;
    }
}
