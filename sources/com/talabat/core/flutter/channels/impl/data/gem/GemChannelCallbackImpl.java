package com.talabat.core.flutter.channels.impl.data.gem;

import JsonModels.Response.GEMResponse.GemOfferResponse;
import android.app.Activity;
import android.content.Context;
import com.google.gson.Gson;
import com.newrelic.agent.android.instrumentation.GsonInstrumentation;
import com.newrelic.agent.android.instrumentation.Instrumented;
import com.talabat.core.context.domain.ApplicationContext;
import com.talabat.core.experiment.domain.ITalabatExperiment;
import com.talabat.core.experiment.domain.TalabatExperimentDataSourceStrategy;
import com.talabat.core.flutter.channels.domain.gem.GemChannelCallback;
import com.talabat.core.flutter.channels.impl.data.gem.dto.GemNavArguments;
import com.talabat.core.fwfprojectskeys.domain.projects.adex.AdExExperimentsKeys;
import com.talabat.core.navigation.domain.Navigator;
import com.talabat.core.navigation.domain.screen.gem.FlutterGemCollectionScreen;
import com.talabat.core.navigation.domain.screen.gem.GemCollectionEntrypoint;
import com.talabat.core.navigation.domain.screen.gem.GemCollectionScreen;
import com.talabat.core.navigation.domain.screen.gem.GemOffersScreen;
import com.talabat.gem.IntegrationKt;
import com.talabat.gem.adapters.data.GemMappersKt;
import com.talabat.gem.adapters.data.GemOfferRawResponse;
import com.talabat.gem.domain.entities.GemOffer;
import com.talabat.gem.domain.entities.GemTier;
import com.talabat.gem.domain.usecases.BusinessRulesKt;
import com.talabat.gem.domain.usecases.GemCounterBusinessRulesKt;
import com.talabat.gem.domain.usecases.GemOfferRequester;
import com.talabat.gem.domain.usecases.GemViewBusinessRulesKt;
import com.talabat.gem.domain.usecases.SaveUpToAmountText;
import com.talabat.gem.domain.usecases.SubTotalLineTwo;
import com.talabat.gem.integration.GemAccessor;
import com.talabat.gem.integration.GemAnalyticsAccessor;
import com.talabat.gem.ports.analytics.AnalyticsPort;
import com.talabat.gem.ports.presentation.GemCounterViewPort;
import com.talabat.localization.R;
import com.talabat.talabatcommon.extentions.DoubleKt;
import com.talabat.talabatcommon.extentions.FloatKt;
import com.talabat.talabatcommon.extentions.GsonKt;
import com.talabat.talabatcommon.extentions.KotlinResultKt;
import com.talabat.talabatcommon.helpers.DynamicLocalizationKt;
import com.talabat.talabatcommon.lifecycle.AutoDisposableDsl;
import io.flutter.plugin.common.MethodChannel;
import io.reactivex.Scheduler;
import io.reactivex.Single;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.rxkotlin.SubscribersKt;
import io.reactivex.schedulers.Schedulers;
import io.reactivex.subjects.BehaviorSubject;
import io.reactivex.subjects.PublishSubject;
import java.util.Collection;
import java.util.Map;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import pg.a;
import xq.b;

@Instrumented
@Metadata(d1 = {"\u0000²\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0006\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 j2\u00020\u00012\u00020\u00022\u00020\u0003:\u0001jB\u0019\b\u0007\u0012\b\b\u0001\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0018\u00108\u001a\u00020\u00132\u0006\u00109\u001a\u00020:2\u0006\u0010;\u001a\u00020<H\u0002J!\u0010=\u001a\u0004\u0018\u00010:2\b\u0010>\u001a\u0004\u0018\u00010<2\u0006\u00109\u001a\u00020:H\u0002¢\u0006\u0002\u0010?Ju\u0010@\u001a\u0010\u0012\u0004\u0012\u00020\u0016\u0012\u0006\u0012\u0004\u0018\u00010B0A2\b\u0010C\u001a\u0004\u0018\u00010\u00162\b\u0010D\u001a\u0004\u0018\u00010\u00162\b\u0010E\u001a\u0004\u0018\u00010\u00162\b\u0010F\u001a\u0004\u0018\u00010\u00162\b\u0010G\u001a\u0004\u0018\u00010\u00132\b\u0010H\u001a\u0004\u0018\u00010\u00162\b\u0010I\u001a\u0004\u0018\u00010\u00132\b\u0010J\u001a\u0004\u0018\u00010:2\b\u0010K\u001a\u0004\u0018\u00010\u0013H\u0002¢\u0006\u0002\u0010LJ\u0018\u0010M\u001a\u00020\u00162\u0006\u00109\u001a\u00020:2\u0006\u0010N\u001a\u00020OH\u0002J\u0018\u0010P\u001a\u00020\u00162\u0006\u00109\u001a\u00020:2\u0006\u0010N\u001a\u00020OH\u0002J\"\u0010Q\u001a\u00020\u00162\u0006\u0010R\u001a\u00020\u00132\u0006\u0010N\u001a\u00020O2\b\u0010S\u001a\u0004\u0018\u00010<H\u0002J,\u0010T\u001a\u00020\u00162\u0006\u00108\u001a\u00020\u00132\b\u0010U\u001a\u0004\u0018\u00010V2\u0006\u0010N\u001a\u00020O2\b\u0010S\u001a\u0004\u0018\u00010<H\u0002J0\u0010W\u001a\u0010\u0012\u0004\u0012\u00020\u0016\u0012\u0006\u0012\u0004\u0018\u00010\u00160X2\u0006\u00108\u001a\u00020\u00132\u0006\u00109\u001a\u00020:2\b\u0010S\u001a\u0004\u0018\u00010<H\u0002J\u0016\u0010Y\u001a\u0010\u0012\u0004\u0012\u00020\u0016\u0012\u0006\u0012\u0004\u0018\u00010B0AH\u0016J\u001a\u0010Z\u001a\u00020\n2\u0006\u0010[\u001a\u00020\\2\b\u0010]\u001a\u0004\u0018\u00010BH\u0016J\u0010\u0010^\u001a\u00020\n2\u0006\u0010[\u001a\u00020\\H\u0016J\u0014\u0010_\u001a\u000e\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020/0AH\u0016J\u0012\u0010`\u001a\u00020\u00132\b\u0010]\u001a\u0004\u0018\u00010BH\u0016J\u0016\u0010a\u001a\u0010\u0012\u0004\u0012\u00020\u0016\u0012\u0006\u0012\u0004\u0018\u00010B0AH\u0016J\u0010\u0010b\u001a\u00020\n2\u0006\u0010[\u001a\u00020\\H\u0002J\u0010\u0010c\u001a\u00020\n2\u0006\u0010d\u001a\u00020eH\u0016J\u001a\u0010f\u001a\u00020\n2\b\u0010]\u001a\u0004\u0018\u00010B2\u0006\u0010d\u001a\u00020eH\u0016J\u0010\u0010g\u001a\u00020\n2\u0006\u0010[\u001a\u00020\\H\u0002J\b\u0010h\u001a\u00020\nH\u0016J\u001a\u0010i\u001a\u00020\n2\u0006\u0010[\u001a\u00020\\2\b\u0010]\u001a\u0004\u0018\u00010BH\u0016R\u0016\u0010\t\u001a\u00020\nX\u0004¢\u0006\n\n\u0002\u0010\r\u001a\u0004\b\u000b\u0010\fR\u0016\u0010\u000e\u001a\u00020\nX\u0004¢\u0006\n\n\u0002\u0010\r\u001a\u0004\b\u000f\u0010\fR\u0016\u0010\u0010\u001a\u00020\nX\u0004¢\u0006\n\n\u0002\u0010\r\u001a\u0004\b\u0011\u0010\fR\u000e\u0010\u0012\u001a\u00020\u0013X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0013X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016XD¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\"\u0010\u0017\u001a\u0010\u0012\f\u0012\n \u0019*\u0004\u0018\u00010\u00160\u00160\u0018X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\"\u0010\u001c\u001a\u0010\u0012\f\u0012\n \u0019*\u0004\u0018\u00010\u00130\u00130\u0018X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001bR\"\u0010\u001e\u001a\u0010\u0012\f\u0012\n \u0019*\u0004\u0018\u00010\u001f0\u001f0\u0018X\u0004¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u001bR\u000e\u0010!\u001a\u00020\"X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010#\u001a\u00020\"X\u0004¢\u0006\b\n\u0000\u001a\u0004\b$\u0010%R\"\u0010&\u001a\u0010\u0012\f\u0012\n \u0019*\u0004\u0018\u00010(0(0'X\u0004¢\u0006\b\n\u0000\u001a\u0004\b)\u0010*R\"\u0010+\u001a\u0010\u0012\f\u0012\n \u0019*\u0004\u0018\u00010,0,0\u0018X\u0004¢\u0006\b\n\u0000\u001a\u0004\b-\u0010\u001bR\"\u0010.\u001a\u0010\u0012\f\u0012\n \u0019*\u0004\u0018\u00010/0/0\u0018X\u0004¢\u0006\b\n\u0000\u001a\u0004\b0\u0010\u001bR\u0014\u00101\u001a\u000202X\u0004¢\u0006\b\n\u0000\u001a\u0004\b3\u00104R\u000e\u00105\u001a\u00020\u0013X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\"\u00106\u001a\u0010\u0012\f\u0012\n \u0019*\u0004\u0018\u00010\u00130\u00130\u0018X\u0004¢\u0006\b\n\u0000\u001a\u0004\b7\u0010\u001b¨\u0006k"}, d2 = {"Lcom/talabat/core/flutter/channels/impl/data/gem/GemChannelCallbackImpl;", "Lcom/talabat/core/flutter/channels/domain/gem/GemChannelCallback;", "Lcom/talabat/gem/integration/GemAccessor;", "Lcom/talabat/gem/ports/presentation/GemCounterViewPort;", "context", "Landroid/content/Context;", "talabatExperiment", "Lcom/talabat/core/experiment/domain/ITalabatExperiment;", "(Landroid/content/Context;Lcom/talabat/core/experiment/domain/ITalabatExperiment;)V", "bindCounterAndVisibility", "", "getBindCounterAndVisibility", "()Lkotlin/Unit;", "Lkotlin/Unit;", "bindCounterExpired", "getBindCounterExpired", "bindOffer", "getBindOffer", "canMakeRequestForGemHome", "", "canMakeRequestForGemOffersStatus", "checkFilledImagePath", "", "counter", "Lio/reactivex/subjects/BehaviorSubject;", "kotlin.jvm.PlatformType", "getCounter", "()Lio/reactivex/subjects/BehaviorSubject;", "counterExpired", "getCounterExpired", "counterSubscription", "Lio/reactivex/disposables/Disposable;", "getCounterSubscription", "disposable", "Lio/reactivex/disposables/CompositeDisposable;", "disposables", "getDisposables", "()Lio/reactivex/disposables/CompositeDisposable;", "errors", "Lio/reactivex/subjects/PublishSubject;", "", "getErrors", "()Lio/reactivex/subjects/PublishSubject;", "offer", "Lcom/talabat/gem/domain/entities/GemOffer;", "getOffer", "remainingSeconds", "", "getRemainingSeconds", "scheduler", "Lio/reactivex/Scheduler;", "getScheduler", "()Lio/reactivex/Scheduler;", "shouldUseFixedAmountText", "visibility", "getVisibility", "beforeFirstTier", "subTotalAmount", "", "baseTier", "Lcom/talabat/gem/domain/entities/GemTier;", "calculateProgress", "maxTier", "(Lcom/talabat/gem/domain/entities/GemTier;D)Ljava/lang/Double;", "generateGemDataMap", "", "", "savingAmountText", "nextDiscountAmountText", "originalSubtotal", "discountedSubtotal", "shouldAnimate", "imagePath", "buttonIsEnabled", "discountProgress", "hideProgressBar", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/Double;Ljava/lang/Boolean;)Ljava/util/Map;", "generateNextDiscountAmountText", "subTitleLineTwo", "Lcom/talabat/gem/domain/usecases/SubTotalLineTwo;", "generatePercentageSubTitle", "generatePercentageTitle", "subTotalIsZero", "currentTier", "generateSavingAmountText", "savingAmount", "Lcom/talabat/gem/domain/usecases/SaveUpToAmountText;", "generateSubtotals", "Lkotlin/Pair;", "getGemData", "getGemHomeData", "result", "Lio/flutter/plugin/common/MethodChannel$Result;", "arguments", "getGemOffersStatus", "getGemRemainingTimeData", "getIsGemEnabled", "getOrganicListingData", "loadGemOfferForHomeFromCache", "navigateToGemCollection", "activity", "Landroid/app/Activity;", "navigateToGemPopup", "requestGemOfferForHome", "setGemExpirationDialogShown", "syncOffers", "Companion", "com_talabat_core_flutter-channels-impl_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class GemChannelCallbackImpl implements GemChannelCallback, GemAccessor, GemCounterViewPort {
    @NotNull
    private static final String ADD_AMOUNT_PLACEHOLDER = "{addAmount}";
    @NotNull
    private static final String AMOUNT_PLACEHOLDER = "{saveAmount}";
    @NotNull
    private static final String CONTROL_VARIANT = "Control";
    @NotNull
    private static final String CURRENCY_PLACEHOLDER = "{currency}";
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    @NotNull
    private static final String PERCENTAGE_PLACEHOLDER = "{percentage}";
    private static final double TIER_FULL_PROGRESS = 1.0d;
    @NotNull
    private final Unit bindCounterAndVisibility;
    @NotNull
    private final Unit bindCounterExpired;
    @NotNull
    private final Unit bindOffer;
    /* access modifiers changed from: private */
    public boolean canMakeRequestForGemHome;
    /* access modifiers changed from: private */
    public boolean canMakeRequestForGemOffersStatus;
    @NotNull
    private final String checkFilledImagePath;
    /* access modifiers changed from: private */
    @NotNull
    public final Context context;
    @NotNull
    private final BehaviorSubject<String> counter;
    @NotNull
    private final BehaviorSubject<Boolean> counterExpired;
    @NotNull
    private final BehaviorSubject<Disposable> counterSubscription;
    @NotNull
    private final CompositeDisposable disposable;
    @NotNull
    private final CompositeDisposable disposables = new CompositeDisposable();
    @NotNull
    private final PublishSubject<Throwable> errors;
    @NotNull
    private final BehaviorSubject<GemOffer> offer;
    @NotNull
    private final BehaviorSubject<Long> remainingSeconds;
    @NotNull
    private final Scheduler scheduler;
    private boolean shouldUseFixedAmountText;
    @NotNull
    private final ITalabatExperiment talabatExperiment;
    @NotNull
    private final BehaviorSubject<Boolean> visibility;

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u0006\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nXT¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lcom/talabat/core/flutter/channels/impl/data/gem/GemChannelCallbackImpl$Companion;", "", "()V", "ADD_AMOUNT_PLACEHOLDER", "", "AMOUNT_PLACEHOLDER", "CONTROL_VARIANT", "CURRENCY_PLACEHOLDER", "PERCENTAGE_PLACEHOLDER", "TIER_FULL_PROGRESS", "", "com_talabat_core_flutter-channels-impl_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    @Inject
    public GemChannelCallbackImpl(@NotNull @ApplicationContext Context context2, @NotNull ITalabatExperiment iTalabatExperiment) {
        Intrinsics.checkNotNullParameter(context2, "context");
        Intrinsics.checkNotNullParameter(iTalabatExperiment, "talabatExperiment");
        this.context = context2;
        this.talabatExperiment = iTalabatExperiment;
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
        BehaviorSubject<Boolean> create6 = BehaviorSubject.create();
        Intrinsics.checkNotNullExpressionValue(create6, "create<Boolean>()");
        this.counterExpired = create6;
        BehaviorSubject<Long> create7 = BehaviorSubject.create();
        Intrinsics.checkNotNullExpressionValue(create7, "create<Long>()");
        this.remainingSeconds = create7;
        GemViewBusinessRulesKt.bindOfferAsObserver(this);
        Unit unit = Unit.INSTANCE;
        this.bindOffer = unit;
        GemCounterBusinessRulesKt.bindCounterExpired(this);
        this.bindCounterExpired = unit;
        GemCounterBusinessRulesKt.bindCounterAndVisibility$default(this, (Long) null, 1, (Object) null);
        this.bindCounterAndVisibility = unit;
        this.canMakeRequestForGemOffersStatus = true;
        this.canMakeRequestForGemHome = true;
        this.disposable = new CompositeDisposable();
        this.checkFilledImagePath = "packages/design_system/lib/assets/images/ds_check_circle_filled/ds_check_circle_filled.svg";
    }

    private final boolean beforeFirstTier(double d11, GemTier gemTier) {
        Double onTotalAmount = gemTier.getOnTotalAmount();
        return d11 < (onTotalAmount != null ? onTotalAmount.doubleValue() : 0.0d);
    }

    private final Double calculateProgress(GemTier gemTier, double d11) {
        Double d12;
        Double d13 = null;
        if (gemTier != null) {
            d12 = gemTier.getOnTotalAmount();
        } else {
            d12 = null;
        }
        Intrinsics.checkNotNull(d12);
        if (d11 > d12.doubleValue() && !BusinessRulesKt.isPercentage(BusinessRulesKt.getGemPercentageVariant())) {
            return Double.valueOf(1.0d);
        }
        if (BusinessRulesKt.isPercentage(BusinessRulesKt.getGemPercentageVariant())) {
            return Double.valueOf(RangesKt___RangesKt.coerceAtMost((d11 * ((double) FloatKt.orZero(gemTier.getDiscountPercentage()))) / DoubleKt.orZero(gemTier.getOnTotalAmount()), 1.0d));
        }
        if (gemTier != null) {
            d13 = gemTier.getOnTotalAmount();
        }
        Intrinsics.checkNotNull(d13);
        return Double.valueOf(d11 / d13.doubleValue());
    }

    private final Map<String, Object> generateGemDataMap(String str, String str2, String str3, String str4, Boolean bool, String str5, Boolean bool2, Double d11, Boolean bool3) {
        return MapsKt__MapsKt.mapOf(TuplesKt.to("savingAmountText", str), TuplesKt.to("nextDiscountAmountNext", str2), TuplesKt.to("originalSubtotal", str3), TuplesKt.to("discountedSubtotal", str4), TuplesKt.to("shouldAnimate", bool), TuplesKt.to("imagePath", str5), TuplesKt.to("buttonIsEnabled", bool2), TuplesKt.to("discountProgress", d11), TuplesKt.to("hideProgressBar", bool3));
    }

    private final String generateNextDiscountAmountText(double d11, SubTotalLineTwo subTotalLineTwo) {
        boolean z11;
        if (d11 == 0.0d) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (z11) {
            return DynamicLocalizationKt.toLocalizedString$default(R.string.Let_s_start_adding_items_to_basket, (String) null, 1, (Object) null);
        }
        if (subTotalLineTwo.getMaximumTierReached()) {
            return "";
        }
        return StringsKt__StringsJVMKt.replace$default(StringsKt__StringsJVMKt.replace$default(StringsKt__StringsJVMKt.replace$default(DynamicLocalizationKt.toLocalizedString$default(R.string.gem_add_more, (String) null, 1, (Object) null), ADD_AMOUNT_PLACEHOLDER, subTotalLineTwo.getAddAmount(), false, 4, (Object) null), CURRENCY_PLACEHOLDER, subTotalLineTwo.getCurrency(), false, 4, (Object) null), AMOUNT_PLACEHOLDER, subTotalLineTwo.getSaveAmount(), false, 4, (Object) null);
    }

    private final String generatePercentageSubTitle(double d11, SubTotalLineTwo subTotalLineTwo) {
        boolean z11;
        String str;
        if (d11 == 0.0d) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (z11) {
            return DynamicLocalizationKt.toLocalizedString$default(R.string.start_saving_adding_items, (String) null, 1, (Object) null);
        }
        if (subTotalLineTwo.getMaximumTierReached()) {
            return "";
        }
        if (BusinessRulesKt.isPercentageWithoutProgressBarVariantA(BusinessRulesKt.getGemPercentageVariant())) {
            return StringsKt__StringsJVMKt.replace$default(StringsKt__StringsJVMKt.replace$default(DynamicLocalizationKt.toLocalizedString$default(R.string.gem_swimlane_title, (String) null, 1, (Object) null), CURRENCY_PLACEHOLDER, subTotalLineTwo.getCurrency(), false, 4, (Object) null), AMOUNT_PLACEHOLDER, subTotalLineTwo.getSaveAmount(), false, 4, (Object) null);
        }
        String localizedString$default = DynamicLocalizationKt.toLocalizedString$default(R.string.save_pct_all_order, (String) null, 1, (Object) null);
        String discountPercentage = subTotalLineTwo.getDiscountPercentage();
        if (discountPercentage == null) {
            str = "";
        } else {
            str = discountPercentage;
        }
        return StringsKt__StringsJVMKt.replace$default(localizedString$default, PERCENTAGE_PLACEHOLDER, str, false, 4, (Object) null);
    }

    private final String generatePercentageTitle(boolean z11, SubTotalLineTwo subTotalLineTwo, GemTier gemTier) {
        Double d11;
        String str;
        String str2;
        String str3 = null;
        if (z11) {
            String localizedString$default = DynamicLocalizationKt.toLocalizedString$default(R.string.get_pct_all_order, (String) null, 1, (Object) null);
            String discountPercentage = subTotalLineTwo.getDiscountPercentage();
            if (discountPercentage == null) {
                str2 = "";
            } else {
                str2 = discountPercentage;
            }
            return StringsKt__StringsJVMKt.replace$default(localizedString$default, PERCENTAGE_PLACEHOLDER, str2, false, 4, (Object) null);
        } else if (subTotalLineTwo.getMaximumTierReached()) {
            return StringsKt__StringsJVMKt.replace$default(StringsKt__StringsJVMKt.replace$default(DynamicLocalizationKt.toLocalizedString$default(R.string.gem_awesome_saved, (String) null, 1, (Object) null), AMOUNT_PLACEHOLDER, subTotalLineTwo.getSaveAmount(), false, 4, (Object) null), CURRENCY_PLACEHOLDER, subTotalLineTwo.getCurrency(), false, 4, (Object) null);
        } else {
            if (BusinessRulesKt.isPercentageWithoutProgressBarVariantA(BusinessRulesKt.getGemPercentageVariant())) {
                String localizedString$default2 = DynamicLocalizationKt.toLocalizedString$default(R.string.get_pct_all_order, (String) null, 1, (Object) null);
                String discountPercentage2 = subTotalLineTwo.getDiscountPercentage();
                if (discountPercentage2 == null) {
                    str = "";
                } else {
                    str = discountPercentage2;
                }
                return StringsKt__StringsJVMKt.replace$default(localizedString$default2, PERCENTAGE_PLACEHOLDER, str, false, 4, (Object) null);
            }
            String localizedString$default3 = DynamicLocalizationKt.toLocalizedString$default(R.string.add_more_save_up_to, (String) null, 1, (Object) null);
            if (gemTier != null) {
                d11 = Double.valueOf(BusinessRulesKt.savedAmount(gemTier));
            } else {
                d11 = null;
            }
            String replace$default = StringsKt__StringsJVMKt.replace$default(localizedString$default3, AMOUNT_PLACEHOLDER, String.valueOf(d11), false, 4, (Object) null);
            if (gemTier != null) {
                str3 = gemTier.getCurrency();
            }
            return StringsKt__StringsJVMKt.replace$default(replace$default, CURRENCY_PLACEHOLDER, String.valueOf(str3), false, 4, (Object) null);
        }
    }

    private final String generateSavingAmountText(boolean z11, SaveUpToAmountText saveUpToAmountText, SubTotalLineTwo subTotalLineTwo, GemTier gemTier) {
        Double d11;
        String str;
        String str2 = null;
        if (z11) {
            String localizedString$default = DynamicLocalizationKt.toLocalizedString$default(R.string.gem_swimlane_title, (String) null, 1, (Object) null);
            if (saveUpToAmountText != null) {
                str = saveUpToAmountText.getSaveAmount();
            } else {
                str = null;
            }
            String replace$default = StringsKt__StringsJVMKt.replace$default(localizedString$default, AMOUNT_PLACEHOLDER, String.valueOf(str), false, 4, (Object) null);
            if (saveUpToAmountText != null) {
                str2 = saveUpToAmountText.getCurrency();
            }
            return StringsKt__StringsJVMKt.replace$default(replace$default, CURRENCY_PLACEHOLDER, String.valueOf(str2), false, 4, (Object) null);
        } else if (subTotalLineTwo.getMaximumTierReached()) {
            return StringsKt__StringsJVMKt.replace$default(StringsKt__StringsJVMKt.replace$default(DynamicLocalizationKt.toLocalizedString$default(R.string.gem_awesome_saved, (String) null, 1, (Object) null), AMOUNT_PLACEHOLDER, subTotalLineTwo.getSaveAmount(), false, 4, (Object) null), CURRENCY_PLACEHOLDER, subTotalLineTwo.getCurrency(), false, 4, (Object) null);
        } else {
            String localizedString$default2 = DynamicLocalizationKt.toLocalizedString$default(R.string.gem_awesome_saved, (String) null, 1, (Object) null);
            if (gemTier != null) {
                d11 = Double.valueOf(BusinessRulesKt.savedAmount(gemTier));
            } else {
                d11 = null;
            }
            String replace$default2 = StringsKt__StringsJVMKt.replace$default(localizedString$default2, AMOUNT_PLACEHOLDER, String.valueOf(d11), false, 4, (Object) null);
            if (gemTier != null) {
                str2 = gemTier.getCurrency();
            }
            return StringsKt__StringsJVMKt.replace$default(replace$default2, CURRENCY_PLACEHOLDER, String.valueOf(str2), false, 4, (Object) null);
        }
    }

    /* JADX WARNING: type inference failed for: r1v2, types: [java.lang.String] */
    /* JADX WARNING: type inference failed for: r1v4, types: [java.lang.String] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final kotlin.Pair<java.lang.String, java.lang.String> generateSubtotals(boolean r3, double r4, com.talabat.gem.domain.entities.GemTier r6) {
        /*
            r2 = this;
            r0 = 0
            int r0 = (r4 > r0 ? 1 : (r4 == r0 ? 0 : -1))
            if (r0 != 0) goto L_0x0008
            r0 = 1
            goto L_0x0009
        L_0x0008:
            r0 = 0
        L_0x0009:
            if (r0 != 0) goto L_0x0058
            java.lang.String r0 = com.talabat.gem.domain.usecases.BusinessRulesKt.getGemPercentageVariant()
            boolean r0 = com.talabat.gem.domain.usecases.BusinessRulesKt.isPercentage(r0)
            if (r0 != 0) goto L_0x0018
            if (r3 == 0) goto L_0x0018
            goto L_0x0058
        L_0x0018:
            buisnessmodels.Cart r3 = buisnessmodels.Cart.getInstance()
            java.lang.String r3 = r3.getCartSubTotalDisplayPrice()
            java.lang.String r0 = com.talabat.gem.domain.usecases.BusinessRulesKt.getGemPercentageVariant()
            boolean r0 = com.talabat.gem.domain.usecases.BusinessRulesKt.isPercentage(r0)
            r1 = 0
            if (r0 == 0) goto L_0x0042
            buisnessmodels.TalabatFormatter r0 = buisnessmodels.TalabatFormatter.getInstance()
            if (r6 == 0) goto L_0x0039
            float r4 = com.talabat.gem.domain.usecases.BusinessRulesKt.calculatePercentageTotal(r6, r4)
            java.lang.Float r1 = java.lang.Float.valueOf(r4)
        L_0x0039:
            float r4 = com.talabat.talabatcommon.extentions.FloatKt.orZero((java.lang.Float) r1)
            java.lang.String r1 = r0.getFormattedCurrency(r4)
            goto L_0x0052
        L_0x0042:
            if (r6 == 0) goto L_0x0052
            double r0 = com.talabat.gem.domain.usecases.BusinessRulesKt.savedAmount(r6)
            double r4 = r4 - r0
            float r4 = (float) r4
            buisnessmodels.TalabatFormatter r5 = buisnessmodels.TalabatFormatter.getInstance()
            java.lang.String r1 = r5.getFormattedCurrency(r4)
        L_0x0052:
            kotlin.Pair r4 = new kotlin.Pair
            r4.<init>(r3, r1)
            goto L_0x0067
        L_0x0058:
            kotlin.Pair r4 = new kotlin.Pair
            buisnessmodels.Cart r3 = buisnessmodels.Cart.getInstance()
            java.lang.String r3 = r3.getCartSubTotalDisplayPrice()
            java.lang.String r5 = ""
            r4.<init>(r5, r3)
        L_0x0067:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.talabat.core.flutter.channels.impl.data.gem.GemChannelCallbackImpl.generateSubtotals(boolean, double, com.talabat.gem.domain.entities.GemTier):kotlin.Pair");
    }

    private final void loadGemOfferForHomeFromCache(MethodChannel.Result result) {
        GemOffer gemOffer = (GemOffer) KotlinResultKt.toSingle$default(IntegrationKt.getDataSources().loadGemOffer(), (Function1) null, 1, (Object) null).blockingGet();
        result.success(MapsKt__MapsKt.mapOf(TuplesKt.to("remainingTimeInSeconds", BusinessRulesKt.calculateGemRemainingSeconds$default((Long) null, 1, (Object) null)), TuplesKt.to("titleMessage", gemOffer.getCollectionTitle()), TuplesKt.to("subtitleMessage", gemOffer.getBrandingMessage())));
    }

    private final void requestGemOfferForHome(MethodChannel.Result result) {
        this.canMakeRequestForGemHome = false;
        GemViewBusinessRulesKt.onRequestOffer(this, GemOfferRequester.RefreshFlutterHome.INSTANCE, new GemChannelCallbackImpl$requestGemOfferForHome$1(this, result));
    }

    /* access modifiers changed from: private */
    /* renamed from: syncOffers$lambda-7  reason: not valid java name */
    public static final void m9586syncOffers$lambda7(Throwable th2) {
        AnalyticsPort analytics = IntegrationKt.getAnalytics();
        String message = th2.getMessage();
        analytics.observeGemSyncOffers("Error while saving the offer: " + message);
    }

    @AutoDisposableDsl
    public void autoDispose(@NotNull Function0<? extends Disposable> function0) {
        GemCounterViewPort.DefaultImpls.autoDispose(this, function0);
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

    public /* synthetic */ Map getGemComponentState() {
        return b.a(this);
    }

    /* JADX WARNING: Removed duplicated region for block: B:64:0x01c1  */
    /* JADX WARNING: Removed duplicated region for block: B:69:0x01cf  */
    /* JADX WARNING: Removed duplicated region for block: B:72:0x01de  */
    /* JADX WARNING: Removed duplicated region for block: B:73:0x01e5  */
    /* JADX WARNING: Removed duplicated region for block: B:76:0x0203  */
    /* JADX WARNING: Removed duplicated region for block: B:77:0x020a  */
    /* JADX WARNING: Removed duplicated region for block: B:80:0x0212  */
    /* JADX WARNING: Removed duplicated region for block: B:81:0x0214  */
    @org.jetbrains.annotations.NotNull
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.util.Map<java.lang.String, java.lang.Object> getGemData() {
        /*
            r32 = this;
            r10 = r32
            com.talabat.gem.ports.data.DataSourcesPort r0 = com.talabat.gem.IntegrationKt.getDataSources()
            kotlin.jvm.functions.Function1 r0 = r0.loadGemOffer()
            r1 = 0
            r2 = 1
            io.reactivex.Single r0 = com.talabat.talabatcommon.extentions.KotlinResultKt.toSingle$default(r0, r1, r2, r1)
            java.lang.Object r0 = r0.blockingGet()
            com.talabat.gem.domain.entities.GemOffer r0 = (com.talabat.gem.domain.entities.GemOffer) r0
            buisnessmodels.Cart r3 = buisnessmodels.Cart.getInstance()
            float r3 = r3.getCartSubTotal()
            double r3 = (double) r3
            java.util.List r5 = r0.getTiers()
            r6 = 0
            if (r5 == 0) goto L_0x002e
            java.lang.Object r5 = r5.get(r6)
            com.talabat.gem.domain.entities.GemTier r5 = (com.talabat.gem.domain.entities.GemTier) r5
            if (r5 != 0) goto L_0x003e
        L_0x002e:
            com.talabat.gem.domain.entities.GemTier r5 = new com.talabat.gem.domain.entities.GemTier
            r12 = 0
            r13 = 0
            r14 = 0
            r15 = 0
            r16 = 0
            r17 = 31
            r18 = 0
            r11 = r5
            r11.<init>(r12, r13, r14, r15, r16, r17, r18)
        L_0x003e:
            java.lang.String r7 = com.talabat.gem.domain.usecases.BusinessRulesKt.getGemPercentageVariant()
            boolean r7 = com.talabat.gem.domain.usecases.BusinessRulesKt.isPercentage(r7)
            if (r7 == 0) goto L_0x0052
            boolean r5 = com.talabat.gem.domain.usecases.BusinessRulesKt.reachPercentage(r5, r3)
            if (r5 != 0) goto L_0x0050
            r5 = r2
            goto L_0x0056
        L_0x0050:
            r5 = r6
            goto L_0x0056
        L_0x0052:
            boolean r5 = r10.beforeFirstTier(r3, r5)
        L_0x0056:
            if (r5 == 0) goto L_0x0063
            java.lang.String r7 = com.talabat.gem.domain.usecases.BusinessRulesKt.getGemPercentageVariant()
            boolean r7 = com.talabat.gem.domain.usecases.BusinessRulesKt.isPercentage(r7)
            if (r7 != 0) goto L_0x0063
            goto L_0x007d
        L_0x0063:
            java.util.List r7 = r0.getTiers()
            if (r7 == 0) goto L_0x007d
            java.lang.String r8 = r32.getGemSelectedTierIndexText()
            java.lang.String r9 = "gemSelectedTierIndexText"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r8, r9)
            int r8 = java.lang.Integer.parseInt(r8)
            java.lang.Object r7 = r7.get(r8)
            com.talabat.gem.domain.entities.GemTier r7 = (com.talabat.gem.domain.entities.GemTier) r7
            goto L_0x007e
        L_0x007d:
            r7 = r1
        L_0x007e:
            java.util.List r8 = r0.getTiers()
            if (r8 == 0) goto L_0x008b
            java.lang.Object r8 = kotlin.collections.CollectionsKt___CollectionsKt.last(r8)
            com.talabat.gem.domain.entities.GemTier r8 = (com.talabat.gem.domain.entities.GemTier) r8
            goto L_0x008c
        L_0x008b:
            r8 = r1
        L_0x008c:
            kotlin.Triple r9 = new kotlin.Triple
            r11 = 0
            java.lang.Double r13 = java.lang.Double.valueOf(r11)
            java.util.List r14 = r0.getTiers()
            java.lang.String r15 = "null cannot be cast to non-null type kotlin.collections.List<com.talabat.gem.domain.entities.GemTier>{ com.talabat.gem.domain.entities.AliasesKt.GemTiers }"
            if (r14 == 0) goto L_0x0256
            java.lang.String r1 = ""
            r9.<init>(r1, r13, r14)
            com.talabat.gem.domain.entities.GemTier r9 = com.talabat.gem.domain.usecases.GemSubTotalBusinessRulesKt.nextGemTier(r3, r9)
            com.talabat.gem.domain.usecases.SubTotalLineTwo r13 = new com.talabat.gem.domain.usecases.SubTotalLineTwo
            java.lang.String r14 = r9.getCurrency()
            java.lang.String r18 = java.lang.String.valueOf(r14)
            java.lang.String r14 = com.talabat.gem.domain.usecases.GemSubTotalBusinessRulesKt.addAmount(r9, r3)
            java.lang.String r6 = "addAmount(nextTier, subTotalAmount)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r14, r6)
            java.text.DecimalFormat r6 = com.talabat.gem.domain.usecases.BusinessRulesKt.getDecimalFormat()
            double r11 = com.talabat.gem.domain.usecases.BusinessRulesKt.savedAmount(r9)
            java.lang.String r6 = r6.format(r11)
            java.lang.String r11 = "DecimalFormat.format(nextTier.savedAmount())"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r6, r11)
            java.util.List r11 = r0.getTiers()
            if (r11 == 0) goto L_0x0250
            boolean r21 = com.talabat.gem.domain.usecases.GemSubTotalBusinessRulesKt.isMaximumTierReached(r3, r11)
            java.text.DecimalFormat r11 = com.talabat.gem.domain.usecases.BusinessRulesKt.getDecimalFormat()
            java.lang.Float r9 = r9.getDiscountPercentage()
            float r9 = com.talabat.talabatcommon.extentions.FloatKt.orZero((java.lang.Float) r9)
            r12 = 100
            float r12 = (float) r12
            float r9 = r9 * r12
            java.lang.Float r9 = java.lang.Float.valueOf(r9)
            java.lang.String r22 = r11.format(r9)
            r17 = r13
            r19 = r14
            r20 = r6
            r17.<init>(r18, r19, r20, r21, r22)
            java.util.List r6 = r0.getTiers()
            if (r6 == 0) goto L_0x01a9
            java.lang.Iterable r6 = (java.lang.Iterable) r6
            java.util.Iterator r6 = r6.iterator()
            boolean r9 = r6.hasNext()
            if (r9 != 0) goto L_0x010a
            r18 = r3
            r9 = 0
            goto L_0x0152
        L_0x010a:
            java.lang.Object r9 = r6.next()
            boolean r11 = r6.hasNext()
            if (r11 != 0) goto L_0x0117
            r18 = r3
            goto L_0x0152
        L_0x0117:
            r11 = r9
            com.talabat.gem.domain.entities.GemTier r11 = (com.talabat.gem.domain.entities.GemTier) r11
            java.lang.Double r11 = r11.getOnTotalAmount()
            if (r11 == 0) goto L_0x0125
            double r14 = r11.doubleValue()
            goto L_0x0127
        L_0x0125:
            r14 = 0
        L_0x0127:
            java.lang.Object r11 = r6.next()
            r17 = r11
            com.talabat.gem.domain.entities.GemTier r17 = (com.talabat.gem.domain.entities.GemTier) r17
            java.lang.Double r17 = r17.getOnTotalAmount()
            if (r17 == 0) goto L_0x0140
            double r17 = r17.doubleValue()
            r30 = r3
            r2 = r17
            r18 = r30
            goto L_0x0144
        L_0x0140:
            r18 = r3
            r2 = 0
        L_0x0144:
            int r4 = java.lang.Double.compare(r14, r2)
            if (r4 >= 0) goto L_0x014c
            r14 = r2
            r9 = r11
        L_0x014c:
            boolean r2 = r6.hasNext()
            if (r2 != 0) goto L_0x01a4
        L_0x0152:
            com.talabat.gem.domain.entities.GemTier r9 = (com.talabat.gem.domain.entities.GemTier) r9
            if (r9 == 0) goto L_0x01ab
            com.talabat.gem.domain.usecases.SaveUpToAmountText r2 = new com.talabat.gem.domain.usecases.SaveUpToAmountText
            java.text.DecimalFormat r3 = com.talabat.gem.domain.usecases.BusinessRulesKt.getDecimalFormat()
            double r14 = com.talabat.gem.domain.usecases.BusinessRulesKt.savedAmount(r9)
            java.lang.String r3 = r3.format(r14)
            java.lang.String r4 = "DecimalFormat.format(it.savedAmount())"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r3, r4)
            java.lang.String r4 = r9.getCurrency()
            if (r4 != 0) goto L_0x0172
            r25 = r1
            goto L_0x0174
        L_0x0172:
            r25 = r4
        L_0x0174:
            java.text.DecimalFormat r1 = com.talabat.gem.domain.usecases.BusinessRulesKt.getDecimalFormat()
            java.lang.Float r4 = r9.getDiscountPercentage()
            float r4 = com.talabat.talabatcommon.extentions.FloatKt.orZero((java.lang.Float) r4)
            float r4 = r4 * r12
            java.lang.Float r4 = java.lang.Float.valueOf(r4)
            java.lang.String r1 = r1.format(r4)
            java.lang.String r4 = "DecimalFormat.format(it.…Zero().times(PERCENTAGE))"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r4)
            java.lang.String r27 = r0.getBrandingMessage()
            java.lang.String r28 = r0.getCollectionTitle()
            java.lang.String r29 = r0.getCollectionSubtitle()
            r23 = r2
            r24 = r3
            r26 = r1
            r23.<init>(r24, r25, r26, r27, r28, r29)
            goto L_0x01ac
        L_0x01a4:
            r3 = r18
            r2 = 1
            goto L_0x0127
        L_0x01a9:
            r18 = r3
        L_0x01ab:
            r2 = 0
        L_0x01ac:
            boolean r0 = r10.shouldUseFixedAmountText
            if (r0 == 0) goto L_0x01b7
            if (r2 == 0) goto L_0x01b7
            java.lang.String r0 = com.talabat.gem.domain.usecases.GemEntryBusinessRulesKt.getTitle(r2)
            goto L_0x01d3
        L_0x01b7:
            java.lang.String r0 = com.talabat.gem.domain.usecases.BusinessRulesKt.getGemPercentageVariant()
            boolean r0 = com.talabat.gem.domain.usecases.BusinessRulesKt.isPercentage(r0)
            if (r0 == 0) goto L_0x01cf
            r0 = 0
            int r2 = (r18 > r0 ? 1 : (r18 == r0 ? 0 : -1))
            if (r2 != 0) goto L_0x01c9
            r0 = 1
            goto L_0x01ca
        L_0x01c9:
            r0 = 0
        L_0x01ca:
            java.lang.String r0 = r10.generatePercentageTitle(r0, r13, r7)
            goto L_0x01d3
        L_0x01cf:
            java.lang.String r0 = r10.generateSavingAmountText(r5, r2, r13, r7)
        L_0x01d3:
            r1 = r0
            java.lang.String r0 = com.talabat.gem.domain.usecases.BusinessRulesKt.getGemPercentageVariant()
            boolean r0 = com.talabat.gem.domain.usecases.BusinessRulesKt.isPercentage(r0)
            if (r0 == 0) goto L_0x01e5
            r2 = r18
            java.lang.String r0 = r10.generatePercentageSubTitle(r2, r13)
            goto L_0x01eb
        L_0x01e5:
            r2 = r18
            java.lang.String r0 = r10.generateNextDiscountAmountText(r2, r13)
        L_0x01eb:
            r4 = r0
            kotlin.Pair r0 = r10.generateSubtotals(r5, r2, r7)
            java.lang.Object r5 = r0.component1()
            java.lang.String r5 = (java.lang.String) r5
            java.lang.Object r0 = r0.component2()
            r6 = r0
            java.lang.String r6 = (java.lang.String) r6
            boolean r0 = r13.getMaximumTierReached()
            if (r0 == 0) goto L_0x020a
            java.lang.String r0 = r10.checkFilledImagePath
            r16 = r0
            r11 = 0
            goto L_0x020e
        L_0x020a:
            r11 = 0
            r16 = 0
        L_0x020e:
            int r0 = (r2 > r11 ? 1 : (r2 == r11 ? 0 : -1))
            if (r0 != 0) goto L_0x0214
            r0 = 1
            goto L_0x0215
        L_0x0214:
            r0 = 0
        L_0x0215:
            r7 = 1
            r0 = r0 ^ r7
            java.lang.Double r8 = r10.calculateProgress(r8, r2)
            kotlin.Pair[] r7 = new kotlin.Pair[r7]
            java.lang.String r9 = "com.talabat.gem.domain.usecases.KEY_SUBTOTAL"
            java.lang.Double r2 = java.lang.Double.valueOf(r2)
            kotlin.Pair r2 = kotlin.TuplesKt.to(r9, r2)
            r3 = 0
            r7[r3] = r2
            java.lang.String r2 = "com.talabat.gem.domain.usecases.ACTION_UPDATE_SUBTOTAL"
            com.talabat.talabatcommon.extentions.BroadcastsKt.sendBroadcast(r2, r7)
            java.lang.Boolean r7 = java.lang.Boolean.TRUE
            java.lang.Boolean r9 = java.lang.Boolean.valueOf(r0)
            java.lang.String r0 = com.talabat.gem.domain.usecases.BusinessRulesKt.getGemPercentageVariant()
            boolean r0 = com.talabat.gem.domain.usecases.BusinessRulesKt.isPercentageWithoutProgressBarVariantA(r0)
            java.lang.Boolean r11 = java.lang.Boolean.valueOf(r0)
            r0 = r32
            r2 = r4
            r3 = r5
            r4 = r6
            r5 = r7
            r6 = r16
            r7 = r9
            r9 = r11
            java.util.Map r0 = r0.generateGemDataMap(r1, r2, r3, r4, r5, r6, r7, r8, r9)
            return r0
        L_0x0250:
            java.lang.NullPointerException r0 = new java.lang.NullPointerException
            r0.<init>(r15)
            throw r0
        L_0x0256:
            java.lang.NullPointerException r0 = new java.lang.NullPointerException
            r0.<init>(r15)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.talabat.core.flutter.channels.impl.data.gem.GemChannelCallbackImpl.getGemData():java.util.Map");
    }

    public void getGemHomeData(@NotNull MethodChannel.Result result, @Nullable Object obj) {
        boolean z11;
        Intrinsics.checkNotNullParameter(result, "result");
        Boolean bool = (Boolean) obj;
        if (bool != null) {
            z11 = bool.booleanValue();
        } else {
            z11 = false;
        }
        if (z11) {
            requestGemOfferForHome(result);
        } else if (!this.canMakeRequestForGemHome) {
            result.success((Object) null);
        } else if (isGemOffersActive()) {
            loadGemOfferForHomeFromCache(result);
        } else {
            requestGemOfferForHome(result);
        }
    }

    public void getGemOffersStatus(@NotNull MethodChannel.Result result) {
        Intrinsics.checkNotNullParameter(result, "result");
        if (isGemOffersActive()) {
            result.success(Boolean.TRUE);
        } else if (isGemOffersActive() || !this.canMakeRequestForGemOffersStatus) {
            result.success(Boolean.FALSE);
        } else {
            this.canMakeRequestForGemOffersStatus = false;
            CompositeDisposable compositeDisposable = this.disposable;
            Single<GemOffer> observeOn = GemOfferRequester.Refresh.INSTANCE.invoke().subscribeOn(Schedulers.io()).observeOn(Schedulers.io());
            Intrinsics.checkNotNullExpressionValue(observeOn, "Refresh()\n              …bserveOn(Schedulers.io())");
            compositeDisposable.add(SubscribersKt.subscribeBy(observeOn, (Function1<? super Throwable, Unit>) new GemChannelCallbackImpl$getGemOffersStatus$1(this, result), new GemChannelCallbackImpl$getGemOffersStatus$2(this, result)));
        }
    }

    public /* synthetic */ String getGemRemainingSecondsText() {
        return b.b(this);
    }

    @NotNull
    public Map<String, Long> getGemRemainingTimeData() {
        boolean z11;
        long j11;
        String gemRemainingSecondsText = getGemRemainingSecondsText();
        Intrinsics.checkNotNullExpressionValue(gemRemainingSecondsText, "gemRemainingSecondsText");
        String gemRemainingSecondsText2 = getGemRemainingSecondsText();
        Intrinsics.checkNotNullExpressionValue(gemRemainingSecondsText2, "gemRemainingSecondsText");
        if (gemRemainingSecondsText2.length() == 0) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (z11) {
            j11 = 0;
        } else {
            j11 = Long.parseLong(gemRemainingSecondsText);
        }
        return MapsKt__MapsJVMKt.mapOf(TuplesKt.to("remainingTimeInSeconds", Long.valueOf(j11)));
    }

    public /* synthetic */ String getGemSelectedRestaurantPositionText() {
        return b.c(this);
    }

    public /* synthetic */ String getGemSelectedTierIndexText() {
        return b.d(this);
    }

    public boolean getIsGemEnabled(@Nullable Object obj) {
        Boolean bool;
        Integer num = (Integer) obj;
        if (num != null) {
            BusinessRulesKt.selectIfGemRestaurantBranch(num.intValue());
            bool = b.k(num.intValue());
        } else {
            bool = Boolean.valueOf(isGemActive());
        }
        Intrinsics.checkNotNullExpressionValue(bool, "isGemEnabled");
        return bool.booleanValue();
    }

    @NotNull
    public BehaviorSubject<GemOffer> getOffer() {
        return this.offer;
    }

    /* JADX WARNING: Removed duplicated region for block: B:34:0x00c6  */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x0109  */
    @org.jetbrains.annotations.NotNull
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.util.Map<java.lang.String, java.lang.Object> getOrganicListingData() {
        /*
            r14 = this;
            com.talabat.gem.ports.data.DataSourcesPort r0 = com.talabat.gem.IntegrationKt.getDataSources()
            kotlin.jvm.functions.Function1 r0 = r0.loadGemOffer()
            r1 = 0
            r2 = 1
            io.reactivex.Single r0 = com.talabat.talabatcommon.extentions.KotlinResultKt.toSingle$default(r0, r1, r2, r1)
            java.lang.Object r0 = r0.blockingGet()
            com.talabat.gem.domain.entities.GemOffer r0 = (com.talabat.gem.domain.entities.GemOffer) r0
            java.util.List r3 = r0.getTiers()
            java.lang.String r4 = ""
            if (r3 == 0) goto L_0x00b5
            java.lang.Iterable r3 = (java.lang.Iterable) r3
            java.util.Iterator r3 = r3.iterator()
            boolean r5 = r3.hasNext()
            if (r5 != 0) goto L_0x002a
            r5 = r1
            goto L_0x0067
        L_0x002a:
            java.lang.Object r5 = r3.next()
            boolean r6 = r3.hasNext()
            if (r6 != 0) goto L_0x0035
            goto L_0x0067
        L_0x0035:
            r6 = r5
            com.talabat.gem.domain.entities.GemTier r6 = (com.talabat.gem.domain.entities.GemTier) r6
            java.lang.Double r6 = r6.getOnTotalAmount()
            r7 = 0
            if (r6 == 0) goto L_0x0045
            double r9 = r6.doubleValue()
            goto L_0x0046
        L_0x0045:
            r9 = r7
        L_0x0046:
            java.lang.Object r6 = r3.next()
            r11 = r6
            com.talabat.gem.domain.entities.GemTier r11 = (com.talabat.gem.domain.entities.GemTier) r11
            java.lang.Double r11 = r11.getOnTotalAmount()
            if (r11 == 0) goto L_0x0058
            double r11 = r11.doubleValue()
            goto L_0x0059
        L_0x0058:
            r11 = r7
        L_0x0059:
            int r13 = java.lang.Double.compare(r9, r11)
            if (r13 >= 0) goto L_0x0061
            r5 = r6
            r9 = r11
        L_0x0061:
            boolean r6 = r3.hasNext()
            if (r6 != 0) goto L_0x0046
        L_0x0067:
            com.talabat.gem.domain.entities.GemTier r5 = (com.talabat.gem.domain.entities.GemTier) r5
            if (r5 == 0) goto L_0x00b5
            com.talabat.gem.domain.usecases.SaveUpToAmountText r3 = new com.talabat.gem.domain.usecases.SaveUpToAmountText
            java.text.DecimalFormat r6 = com.talabat.gem.domain.usecases.BusinessRulesKt.getDecimalFormat()
            double r7 = com.talabat.gem.domain.usecases.BusinessRulesKt.savedAmount(r5)
            java.lang.String r7 = r6.format(r7)
            java.lang.String r6 = "DecimalFormat.format(it.savedAmount())"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r7, r6)
            java.lang.String r6 = r5.getCurrency()
            if (r6 != 0) goto L_0x0086
            r8 = r4
            goto L_0x0087
        L_0x0086:
            r8 = r6
        L_0x0087:
            java.text.DecimalFormat r6 = com.talabat.gem.domain.usecases.BusinessRulesKt.getDecimalFormat()
            java.lang.Float r5 = r5.getDiscountPercentage()
            float r5 = com.talabat.talabatcommon.extentions.FloatKt.orZero((java.lang.Float) r5)
            r9 = 100
            float r9 = (float) r9
            float r5 = r5 * r9
            java.lang.Float r5 = java.lang.Float.valueOf(r5)
            java.lang.String r9 = r6.format(r5)
            java.lang.String r5 = "DecimalFormat.format(it.…Zero().times(PERCENTAGE))"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r9, r5)
            java.lang.String r10 = r0.getBrandingMessage()
            java.lang.String r11 = r0.getCollectionTitle()
            java.lang.String r12 = r0.getCollectionSubtitle()
            r6 = r3
            r6.<init>(r7, r8, r9, r10, r11, r12)
            goto L_0x00b6
        L_0x00b5:
            r3 = r1
        L_0x00b6:
            if (r3 == 0) goto L_0x00c0
            java.lang.String r0 = com.talabat.gem.domain.usecases.GemEntryBusinessRulesKt.getOrganicListingMessage(r3)
            if (r0 != 0) goto L_0x00bf
            goto L_0x00c0
        L_0x00bf:
            r4 = r0
        L_0x00c0:
            boolean r0 = r14.isGemOffersActive()
            if (r0 == 0) goto L_0x0109
            com.talabat.gem.ports.data.DataSourcesPort r0 = com.talabat.gem.IntegrationKt.getDataSources()
            kotlin.jvm.functions.Function1 r0 = r0.loadGemOffer()
            com.talabat.core.flutter.channels.impl.data.gem.GemChannelCallbackImpl$getOrganicListingData$branchIds$1 r3 = new com.talabat.core.flutter.channels.impl.data.gem.GemChannelCallbackImpl$getOrganicListingData$branchIds$1
            r3.<init>(r1)
            kotlin.jvm.functions.Function1 r0 = com.talabat.talabatcommon.extentions.KotlinResultKt.mapNonNull(r0, r3)
            io.reactivex.Maybe r0 = com.talabat.talabatcommon.extentions.KotlinResultKt.toMaybe$default(r0, r1, r2, r1)
            java.lang.Object r0 = r0.blockingGet()
            java.lang.String r1 = "DataSources.loadGemOffer…           .blockingGet()"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r1)
            java.lang.Iterable r0 = (java.lang.Iterable) r0
            java.util.ArrayList r1 = new java.util.ArrayList
            r3 = 10
            int r3 = kotlin.collections.CollectionsKt__IterablesKt.collectionSizeOrDefault(r0, r3)
            r1.<init>(r3)
            java.util.Iterator r0 = r0.iterator()
        L_0x00f5:
            boolean r3 = r0.hasNext()
            if (r3 == 0) goto L_0x010d
            java.lang.Object r3 = r0.next()
            com.talabat.gem.domain.entities.GemRestaurant r3 = (com.talabat.gem.domain.entities.GemRestaurant) r3
            java.lang.Integer r3 = r3.getBranchId()
            r1.add(r3)
            goto L_0x00f5
        L_0x0109:
            java.util.List r1 = kotlin.collections.CollectionsKt__CollectionsKt.emptyList()
        L_0x010d:
            r0 = 2
            kotlin.Pair[] r0 = new kotlin.Pair[r0]
            java.lang.String r3 = "discountMessage"
            kotlin.Pair r3 = kotlin.TuplesKt.to(r3, r4)
            r4 = 0
            r0[r4] = r3
            java.lang.String r3 = "vendorIds"
            kotlin.Pair r1 = kotlin.TuplesKt.to(r3, r1)
            r0[r2] = r1
            java.util.Map r0 = kotlin.collections.MapsKt__MapsKt.mapOf(r0)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.talabat.core.flutter.channels.impl.data.gem.GemChannelCallbackImpl.getOrganicListingData():java.util.Map");
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
    public BehaviorSubject<Boolean> getVisibility() {
        return this.visibility;
    }

    public /* synthetic */ boolean isGemActive() {
        return b.e(this);
    }

    public /* synthetic */ boolean isGemOffersActive() {
        return b.f(this);
    }

    public void navigateToGemCollection(@NotNull Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        if (Intrinsics.areEqual((Object) this.talabatExperiment.getStringVariant(AdExExperimentsKeys.SHOW_FLUTTER_GEM_COLLECTION, "Control", TalabatExperimentDataSourceStrategy.FWF), (Object) "Control")) {
            Navigator.DefaultImpls.navigateTo$default(IntegrationKt.getNavigator(), activity, new GemCollectionScreen(new GemCollectionScreen.GemCollectionData(GemCollectionEntrypoint.FOOD_LIST)), (Function1) null, 4, (Object) null);
            return;
        }
        Navigator.DefaultImpls.navigateTo$default(IntegrationKt.getNavigator(), activity, new FlutterGemCollectionScreen(new FlutterGemCollectionScreen.FlutterGemCollectionData(GemCollectionEntrypoint.FOOD_LIST)), (Function1) null, 4, (Object) null);
    }

    public void navigateToGemPopup(@Nullable Object obj, @NotNull Activity activity) {
        Object obj2;
        boolean z11;
        Boolean fromFlutterHoF;
        Intrinsics.checkNotNullParameter(activity, "activity");
        Gson gson = GsonKt.getGson();
        String json$default = GsonKt.toJson$default(obj, (Gson) null, 1, (Object) null);
        Class cls = GemNavArguments.class;
        if (!(gson instanceof Gson)) {
            obj2 = gson.fromJson(json$default, cls);
        } else {
            obj2 = GsonInstrumentation.fromJson(gson, json$default, cls);
        }
        GemNavArguments gemNavArguments = (GemNavArguments) obj2;
        if (gemNavArguments == null || (fromFlutterHoF = gemNavArguments.getFromFlutterHoF()) == null) {
            z11 = false;
        } else {
            z11 = fromFlutterHoF.booleanValue();
        }
        Navigator.DefaultImpls.navigateTo$default(IntegrationKt.getNavigator(), activity, new GemOffersScreen(new GemOffersScreen.GemOffersData(z11)), (Function1) null, 4, (Object) null);
    }

    public void onCleared() {
        GemCounterViewPort.DefaultImpls.onCleared(this);
    }

    @AutoDisposableDsl
    public void onClearedImplementation() {
        GemCounterViewPort.DefaultImpls.onClearedImplementation(this);
    }

    public /* synthetic */ void onGemSessionChanged() {
        b.g(this);
    }

    public /* synthetic */ void resetGemFlow() {
        b.h(this);
    }

    public void setGemExpirationDialogShown() {
        IntegrationKt.getDataSources().setExpirationAlertShown(true);
    }

    public void syncOffers(@NotNull MethodChannel.Result result, @Nullable Object obj) {
        Object obj2;
        GemOffer gemOffer;
        boolean z11;
        Intrinsics.checkNotNullParameter(result, "result");
        if (obj == null) {
            IntegrationKt.getAnalytics().observeGemSyncOffers("Wrong arguments from flutter");
            result.error("1002", "Wrong arguments from flutter", (Object) null);
            return;
        }
        Gson gson = GsonKt.getGson();
        String json$default = GsonKt.toJson$default(obj, (Gson) null, 1, (Object) null);
        Class cls = GemOfferRawResponse.class;
        if (!(gson instanceof Gson)) {
            obj2 = gson.fromJson(json$default, cls);
        } else {
            obj2 = GsonInstrumentation.fromJson(gson, json$default, cls);
        }
        GemOfferResponse response = ((GemOfferRawResponse) obj2).getResponse();
        if (response != null && (gemOffer = GemMappersKt.toGemOffer(response)) != null && !BusinessRulesKt.isExpired$default(gemOffer, 0, 1, (Object) null)) {
            Collection restaurants = gemOffer.getRestaurants();
            if (restaurants == null || restaurants.isEmpty()) {
                z11 = true;
            } else {
                z11 = false;
            }
            if (!z11) {
                CompositeDisposable disposables2 = getDisposables();
                Single doOnError = KotlinResultKt.toSingle$default(IntegrationKt.getDataSources().saveGemOffer(gemOffer), (Function1) null, 1, (Object) null).subscribeOn(getScheduler()).observeOn(getScheduler()).doOnError(new a());
                Intrinsics.checkNotNullExpressionValue(doOnError, "DataSources.saveGemOffer…sage}\")\n                }");
                disposables2.add(SubscribersKt.subscribeBy(doOnError, (Function1<? super Throwable, Unit>) GemChannelCallbackImpl$syncOffers$2.INSTANCE, new GemChannelCallbackImpl$syncOffers$3(this)));
            }
        }
    }

    public /* synthetic */ GemAnalyticsAccessor withGemAnalytics() {
        return b.i(this);
    }

    @NotNull
    public PublishSubject<Throwable> getErrors() {
        return this.errors;
    }
}
