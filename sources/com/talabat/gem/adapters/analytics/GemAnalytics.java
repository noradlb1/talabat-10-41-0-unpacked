package com.talabat.gem.adapters.analytics;

import android.app.Application;
import android.content.IntentFilter;
import com.google.android.exoplayer2.util.MimeTypes;
import com.talabat.core.tracking.domain.TalabatTracker;
import com.talabat.gem.GemIntegrationDsl;
import com.talabat.gem.IntegrationKt;
import com.talabat.gem.domain.entities.GemOffer;
import com.talabat.gem.domain.entities.GemRestaurant;
import com.talabat.gem.domain.entities.GemTier;
import com.talabat.gem.domain.usecases.GemAnalyticsTriggersBusinessRulesKt;
import com.talabat.gem.domain.usecases.GemSubTotalBusinessRulesKt;
import com.talabat.gem.integration.Gem;
import com.talabat.gem.integration.GemAccessor;
import com.talabat.gem.integration.GemAnalyticsAccessor;
import com.talabat.gem.ports.analytics.AnalyticsPort;
import com.talabat.gem.ports.analytics.GemAnalyticsTriggersPort;
import com.talabat.talabatcommon.extentions.CoroutinesKt;
import com.talabat.talabatcommon.extentions.Nullable;
import com.talabat.talabatcommon.extentions.RxKt;
import com.talabat.talabatcommon.lifecycle.AutoDisposableDsl;
import datamodels.ImpressionProperties;
import io.reactivex.Scheduler;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import io.reactivex.subjects.BehaviorSubject;
import io.reactivex.subjects.PublishSubject;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import xq.b;

@Metadata(d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0006\n\u0002\b\u000f\n\u0002\u0010\b\n\u0002\b\r\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0005\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0002\b\u0002*\u0001Y\b\u0000\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B'\b\u0007\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u000e\u0010\u0006\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\b0\u0007\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0002\u0010\u000bJ\u0010\u00103\u001a\u00020\u000f2\u0006\u00104\u001a\u00020\bH\u0016J6\u00105\u001a\u00020\u000f2\u0006\u00106\u001a\u00020\b2\u0006\u00107\u001a\u00020\b2\b\u00108\u001a\u0004\u0018\u00010\b2\b\u00109\u001a\u0004\u0018\u00010\b2\b\u0010:\u001a\u0004\u0018\u00010\bH\u0016Jc\u0010;\u001a\u00020\u000f2\u0006\u00106\u001a\u00020\b2\u0006\u00107\u001a\u00020\b2\b\u00108\u001a\u0004\u0018\u00010\b2\b\u00109\u001a\u0004\u0018\u00010\b2\b\u0010<\u001a\u0004\u0018\u00010=2\b\u0010>\u001a\u0004\u0018\u00010=2\b\u0010?\u001a\u0004\u0018\u00010=2\b\u0010@\u001a\u0004\u0018\u00010\b2\b\u0010:\u001a\u0004\u0018\u00010\bH\u0016¢\u0006\u0002\u0010AJ\b\u0010B\u001a\u00020\u000fH\u0016J\u001c\u0010C\u001a\u00020\u000f2\b\u0010D\u001a\u0004\u0018\u00010\b2\b\u0010E\u001a\u0004\u0018\u00010\bH\u0016J\b\u0010F\u001a\u00020\u000fH\u0016J\b\u0010G\u001a\u00020\u000fH\u0016J\b\u0010H\u001a\u00020\u000fH\u0016J*\u0010I\u001a\u00020\u000f2\f\u0010J\u001a\b\u0012\u0004\u0012\u00020L0K2\b\u0010M\u001a\u0004\u0018\u00010\b2\b\u0010N\u001a\u0004\u0018\u00010\bH\u0016J\b\u0010O\u001a\u00020\u000fH\u0016J\b\u0010P\u001a\u00020\u000fH\u0016J\b\u0010Q\u001a\u00020\u000fH\u0016J\b\u0010R\u001a\u00020\u000fH\u0016J\b\u0010S\u001a\u00020\u000fH\u0016J\u001a\u0010T\u001a\u00020\u000f2\u0006\u0010U\u001a\u00020V2\b\u0010W\u001a\u0004\u0018\u00010\bH\u0016J\r\u0010X\u001a\u00020YH\u0002¢\u0006\u0002\u0010ZJ>\u0010[\u001a\u00020\u000f2\b\u0010\\\u001a\u0004\u0018\u00010\b2\b\u0010:\u001a\u0004\u0018\u00010\b2\u0016\u0010]\u001a\u0012\u0012\u0004\u0012\u00020\b\u0012\u0006\u0012\u0004\u0018\u00010_\u0018\u00010^2\b\u0010`\u001a\u0004\u0018\u00010\bH\u0016R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0016\u0010\u000e\u001a\u00020\u000fX\u0004¢\u0006\n\n\u0002\u0010\u0012\u001a\u0004\b\u0010\u0010\u0011R\u0016\u0010\u0013\u001a\u00020\u000fX\u0004¢\u0006\n\n\u0002\u0010\u0012\u001a\u0004\b\u0014\u0010\u0011R\u0014\u0010\u0015\u001a\u00020\u0016X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\"\u0010\u0019\u001a\u0010\u0012\f\u0012\n \u001c*\u0004\u0018\u00010\u001b0\u001b0\u001aX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001eR.\u0010\u001f\u001a\u001c\u0012\u0018\u0012\u0016\u0012\u0004\u0012\u00020\" \u001c*\n\u0012\u0004\u0012\u00020\"\u0018\u00010!0!0 X\u0004¢\u0006\b\n\u0000\u001a\u0004\b#\u0010$R\"\u0010%\u001a\u0010\u0012\f\u0012\n \u001c*\u0004\u0018\u00010&0&0 X\u0004¢\u0006\b\n\u0000\u001a\u0004\b'\u0010$R\u0016\u0010\u0006\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\b0\u0007X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010(\u001a\u00020)X\u0004¢\u0006\b\n\u0000\u001a\u0004\b*\u0010+R\"\u0010,\u001a\u0010\u0012\f\u0012\n \u001c*\u0004\u0018\u00010-0-0 X\u0004¢\u0006\b\n\u0000\u001a\u0004\b.\u0010$R\u000e\u0010\t\u001a\u00020\nX\u0004¢\u0006\u0002\n\u0000R\u0016\u0010/\u001a\u00020\u000fX\u0004¢\u0006\n\n\u0002\u0010\u0012\u001a\u0004\b0\u0010\u0011R\u0016\u00101\u001a\u00020\u000fX\u0004¢\u0006\n\n\u0002\u0010\u0012\u001a\u0004\b2\u0010\u0011¨\u0006a"}, d2 = {"Lcom/talabat/gem/adapters/analytics/GemAnalytics;", "Lcom/talabat/gem/ports/analytics/AnalyticsPort;", "Lcom/talabat/gem/ports/analytics/GemAnalyticsTriggersPort;", "Lcom/talabat/gem/integration/GemAccessor;", "application", "Landroid/app/Application;", "pageTypeProvider", "Lkotlin/Function0;", "", "talabatTracker", "Lcom/talabat/core/tracking/domain/TalabatTracker;", "(Landroid/app/Application;Lkotlin/jvm/functions/Function0;Lcom/talabat/core/tracking/domain/TalabatTracker;)V", "getApplication", "()Landroid/app/Application;", "bindLastTierReached", "", "getBindLastTierReached", "()Lkotlin/Unit;", "Lkotlin/Unit;", "bindOffer", "getBindOffer", "disposables", "Lio/reactivex/disposables/CompositeDisposable;", "getDisposables", "()Lio/reactivex/disposables/CompositeDisposable;", "errors", "Lio/reactivex/subjects/PublishSubject;", "", "kotlin.jvm.PlatformType", "getErrors", "()Lio/reactivex/subjects/PublishSubject;", "lastTierReached", "Lio/reactivex/subjects/BehaviorSubject;", "Lcom/talabat/talabatcommon/extentions/Nullable;", "Lcom/talabat/gem/domain/entities/GemTier;", "getLastTierReached", "()Lio/reactivex/subjects/BehaviorSubject;", "offer", "Lcom/talabat/gem/domain/entities/GemOffer;", "getOffer", "scheduler", "Lio/reactivex/Scheduler;", "getScheduler", "()Lio/reactivex/Scheduler;", "subTotal", "", "getSubTotal", "triggerOfferExpired", "getTriggerOfferExpired", "triggerTierReached", "getTriggerTierReached", "observeGemSyncOffers", "errorMessage", "onGemApiCallRequest", "apiRequestUrl", "status", "offerId", "reservationCode", "source", "onGemApiCallResponse", "offerCount", "", "tierCount", "responseCode", "message", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;)V", "onGemCheckoutLoaded", "onGemCollectionRestaurantLoaded", "swimlaneTitle", "shopListTrigger", "onGemExpired", "onGemFloatingViewShown", "onGemHomeSwimlaneShown", "onGemJokerImpressionTriggered", "scrollingList", "", "Ldatamodels/ImpressionProperties;", "screenName", "screenType", "onGemOfferDetailsShown", "onGemOfferRejected", "onGemOrderComplete", "onGemRestaurantLoaded", "onGemTierReached", "onShopClicked", "gemRestaurant", "Lcom/talabat/gem/domain/entities/GemRestaurant;", "channel", "subTotalReceiver", "com/talabat/gem/adapters/analytics/GemAnalytics$subTotalReceiver$1", "()Lcom/talabat/gem/adapters/analytics/GemAnalytics$subTotalReceiver$1;", "trackGemFlutterHomeData", "info", "gemHomeData", "", "", "noDataReason", "com_talabat_Components_gem_gem"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class GemAnalytics implements AnalyticsPort, GemAnalyticsTriggersPort, GemAccessor {
    @NotNull
    private final Application application;
    @NotNull
    private final Unit bindLastTierReached;
    @NotNull
    private final Unit bindOffer;
    @NotNull
    private final CompositeDisposable disposables = new CompositeDisposable();
    @NotNull
    private final PublishSubject<Throwable> errors;
    @NotNull
    private final BehaviorSubject<Nullable<GemTier>> lastTierReached;
    @NotNull
    private final BehaviorSubject<GemOffer> offer;
    /* access modifiers changed from: private */
    @NotNull
    public final Function0<String> pageTypeProvider;
    @NotNull
    private final Scheduler scheduler;
    @NotNull
    private final BehaviorSubject<Double> subTotal;
    /* access modifiers changed from: private */
    @NotNull
    public final TalabatTracker talabatTracker;
    @NotNull
    private final Unit triggerOfferExpired;
    @NotNull
    private final Unit triggerTierReached;

    @GemIntegrationDsl
    public GemAnalytics(@NotNull Application application2, @NotNull Function0<String> function0, @NotNull TalabatTracker talabatTracker2) {
        Intrinsics.checkNotNullParameter(application2, MimeTypes.BASE_TYPE_APPLICATION);
        Intrinsics.checkNotNullParameter(function0, "pageTypeProvider");
        Intrinsics.checkNotNullParameter(talabatTracker2, "talabatTracker");
        this.application = application2;
        this.pageTypeProvider = function0;
        this.talabatTracker = talabatTracker2;
        BehaviorSubject<Nullable<GemTier>> create = BehaviorSubject.create();
        Intrinsics.checkNotNullExpressionValue(create, "create<Nullable<GemTier>>()");
        this.lastTierReached = create;
        BehaviorSubject<Double> create2 = BehaviorSubject.create();
        Intrinsics.checkNotNullExpressionValue(create2, "create<Double>()");
        this.subTotal = create2;
        Scheduler io2 = Schedulers.io();
        Intrinsics.checkNotNullExpressionValue(io2, "io()");
        this.scheduler = io2;
        PublishSubject<Throwable> create3 = PublishSubject.create();
        Intrinsics.checkNotNullExpressionValue(create3, "create<Throwable>()");
        this.errors = create3;
        BehaviorSubject<GemOffer> create4 = BehaviorSubject.create();
        Intrinsics.checkNotNullExpressionValue(create4, "create<GemOffer>()");
        this.offer = create4;
        GemAnalyticsTriggersBusinessRulesKt.bindOffer(this);
        Unit unit = Unit.INSTANCE;
        this.bindOffer = unit;
        GemAnalyticsTriggersBusinessRulesKt.bindLastTierReached(this);
        this.bindLastTierReached = unit;
        GemAnalyticsTriggersBusinessRulesKt.triggerTierReached(this);
        this.triggerTierReached = unit;
        GemAnalyticsTriggersBusinessRulesKt.triggerOfferExpired(this);
        this.triggerOfferExpired = unit;
        application2.registerReceiver(subTotalReceiver(), new IntentFilter(GemSubTotalBusinessRulesKt.ACTION_UPDATE_SUBTOTAL));
        RxKt.invoke(getErrors(), AnonymousClass1.INSTANCE);
    }

    private final GemAnalytics$subTotalReceiver$1 subTotalReceiver() {
        return new GemAnalytics$subTotalReceiver$1(this);
    }

    @AutoDisposableDsl
    public void autoDispose(@NotNull Function0<? extends Disposable> function0) {
        GemAnalyticsTriggersPort.DefaultImpls.autoDispose(this, function0);
    }

    @NotNull
    public final Application getApplication() {
        return this.application;
    }

    @NotNull
    public Unit getBindLastTierReached() {
        return this.bindLastTierReached;
    }

    @NotNull
    public Unit getBindOffer() {
        return this.bindOffer;
    }

    @NotNull
    public CompositeDisposable getDisposables() {
        return this.disposables;
    }

    public /* synthetic */ Map getGemComponentState() {
        return b.a(this);
    }

    public /* synthetic */ String getGemRemainingSecondsText() {
        return b.b(this);
    }

    public /* synthetic */ String getGemSelectedRestaurantPositionText() {
        return b.c(this);
    }

    public /* synthetic */ String getGemSelectedTierIndexText() {
        return b.d(this);
    }

    @NotNull
    public BehaviorSubject<Nullable<GemTier>> getLastTierReached() {
        return this.lastTierReached;
    }

    @NotNull
    public BehaviorSubject<GemOffer> getOffer() {
        return this.offer;
    }

    @NotNull
    public Scheduler getScheduler() {
        return this.scheduler;
    }

    @NotNull
    public BehaviorSubject<Double> getSubTotal() {
        return this.subTotal;
    }

    @NotNull
    public Unit getTriggerOfferExpired() {
        return this.triggerOfferExpired;
    }

    @NotNull
    public Unit getTriggerTierReached() {
        return this.triggerTierReached;
    }

    public /* synthetic */ boolean isGemActive() {
        return b.e(this);
    }

    public /* synthetic */ boolean isGemOffersActive() {
        return b.f(this);
    }

    public void observeGemSyncOffers(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "errorMessage");
        this.talabatTracker.track(new GemSyncOffersEvent(str));
    }

    public void onCleared() {
        GemAnalyticsTriggersPort.DefaultImpls.onCleared(this);
    }

    @AutoDisposableDsl
    public void onClearedImplementation() {
        GemAnalyticsTriggersPort.DefaultImpls.onClearedImplementation(this);
    }

    public void onGemApiCallRequest(@NotNull String str, @NotNull String str2, @org.jetbrains.annotations.Nullable String str3, @org.jetbrains.annotations.Nullable String str4, @org.jetbrains.annotations.Nullable String str5) {
        String str6 = str;
        Intrinsics.checkNotNullParameter(str6, "apiRequestUrl");
        String str7 = str2;
        Intrinsics.checkNotNullParameter(str7, "status");
        this.talabatTracker.track(new GemApiCallEvent(str6, str7, str3, (Integer) null, (Integer) null, str4, (Integer) null, (String) null, str5, 216, (DefaultConstructorMarker) null));
    }

    public void onGemApiCallResponse(@NotNull String str, @NotNull String str2, @org.jetbrains.annotations.Nullable String str3, @org.jetbrains.annotations.Nullable String str4, @org.jetbrains.annotations.Nullable Integer num, @org.jetbrains.annotations.Nullable Integer num2, @org.jetbrains.annotations.Nullable Integer num3, @org.jetbrains.annotations.Nullable String str5, @org.jetbrains.annotations.Nullable String str6) {
        Intrinsics.checkNotNullParameter(str, "apiRequestUrl");
        Intrinsics.checkNotNullParameter(str2, "status");
        this.talabatTracker.track(new GemApiCallEvent(str, str2, str3, num, num2, str4, num3, str5, str6));
    }

    public void onGemCheckoutLoaded() {
        CoroutinesKt.runHandling(new GemAnalytics$onGemCheckoutLoaded$1(IntegrationKt.getLogger()), new GemAnalytics$onGemCheckoutLoaded$2(this));
    }

    public void onGemCollectionRestaurantLoaded(@org.jetbrains.annotations.Nullable String str, @org.jetbrains.annotations.Nullable String str2) {
        Gem.withGemComponent(new GemAnalytics$onGemCollectionRestaurantLoaded$1(this, str2, str));
    }

    public void onGemExpired() {
        Gem.withGemComponent(new GemAnalytics$onGemExpired$1(this));
    }

    public void onGemFloatingViewShown() {
        Gem.withGemComponent(new GemAnalytics$onGemFloatingViewShown$1(this));
    }

    public void onGemHomeSwimlaneShown() {
        Gem.withGemComponent(new GemAnalytics$onGemHomeSwimlaneShown$1(this));
    }

    public void onGemJokerImpressionTriggered(@NotNull List<ImpressionProperties> list, @org.jetbrains.annotations.Nullable String str, @org.jetbrains.annotations.Nullable String str2) {
        Intrinsics.checkNotNullParameter(list, "scrollingList");
        Gem.withGemComponent(new GemAnalytics$onGemJokerImpressionTriggered$1(this, str, str2, list));
    }

    public void onGemOfferDetailsShown() {
        Gem.withGemComponent(new GemAnalytics$onGemOfferDetailsShown$1(this));
    }

    public void onGemOfferRejected() {
        Gem.withGemComponent(new GemAnalytics$onGemOfferRejected$1(this));
    }

    public void onGemOrderComplete() {
        CoroutinesKt.runHandling(new GemAnalytics$onGemOrderComplete$1(IntegrationKt.getLogger()), new GemAnalytics$onGemOrderComplete$2(this));
    }

    public void onGemRestaurantLoaded() {
        CoroutinesKt.runHandling(new GemAnalytics$onGemRestaurantLoaded$1(IntegrationKt.getLogger()), new GemAnalytics$onGemRestaurantLoaded$2(this));
    }

    public /* synthetic */ void onGemSessionChanged() {
        b.g(this);
    }

    public void onGemTierReached() {
        Gem.withGemComponent(new GemAnalytics$onGemTierReached$1(this));
    }

    public void onShopClicked(@NotNull GemRestaurant gemRestaurant, @org.jetbrains.annotations.Nullable String str) {
        Intrinsics.checkNotNullParameter(gemRestaurant, "gemRestaurant");
        CoroutinesKt.runHandling(new GemAnalytics$onShopClicked$1(IntegrationKt.getLogger()), new GemAnalytics$onShopClicked$2(this, gemRestaurant, str));
    }

    public /* synthetic */ void resetGemFlow() {
        b.h(this);
    }

    public void trackGemFlutterHomeData(@org.jetbrains.annotations.Nullable String str, @org.jetbrains.annotations.Nullable String str2, @org.jetbrains.annotations.Nullable Map<String, ? extends Object> map, @org.jetbrains.annotations.Nullable String str3) {
        this.talabatTracker.track(new GemFlutterHomeEvent(str2, map, str3, str));
    }

    public /* synthetic */ GemAnalyticsAccessor withGemAnalytics() {
        return b.i(this);
    }

    @NotNull
    public PublishSubject<Throwable> getErrors() {
        return this.errors;
    }
}
