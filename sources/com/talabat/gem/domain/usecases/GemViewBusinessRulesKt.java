package com.talabat.gem.domain.usecases;

import androidx.annotation.VisibleForTesting;
import buisnessmodels.Customer;
import com.talabat.core.featureflag.domain.flags.TalabatFeatureFlagConstants;
import com.talabat.gem.IntegrationKt;
import com.talabat.gem.domain.entities.GemOffer;
import com.talabat.gem.ports.analytics.AnalyticsPort;
import com.talabat.gem.ports.presentation.GemViewPort;
import com.talabat.helpers.GlobalDataModel;
import com.talabat.lib.Integration;
import com.talabat.talabatcommon.extentions.KotlinResultKt;
import io.reactivex.Single;
import java.util.Map;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.Result;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import wq.u;

@Metadata(d1 = {"\u0000F\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\b\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a\b\u0010\f\u001a\u00020\u0005H\u0002\u001aW\u0010\r\u001a\u001e\b\u0001\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00110\u00100\u000f\u0012\u0006\u0012\u0004\u0018\u00010\u00120\u000e2&\b\u0002\u0010\u0013\u001a \b\u0001\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00110\u00100\u000f\u0012\u0006\u0012\u0004\u0018\u00010\u0012\u0018\u00010\u000eH\u0001ø\u0001\u0000ø\u0001\u0000¢\u0006\u0002\u0010\u0014\u001a\u0006\u0010\u0015\u001a\u00020\u0005\u001a\b\u0010\u0016\u001a\u00020\u0005H\u0002\u001a/\u0010\u0017\u001a\u001e\b\u0001\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00110\u00100\u000f\u0012\u0006\u0012\u0004\u0018\u00010\u00120\u000eH\u0001ø\u0001\u0000ø\u0001\u0000¢\u0006\u0002\u0010\u0018\u001a/\u0010\u0019\u001a\u001e\b\u0001\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00110\u00100\u000f\u0012\u0006\u0012\u0004\u0018\u00010\u00120\u000eH\u0001ø\u0001\u0000ø\u0001\u0000¢\u0006\u0002\u0010\u0018\u001a,\u0010\u001a\u001a\u00020\u001b*\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001e2\u0016\b\u0002\u0010\u001f\u001a\u0010\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u001b\u0018\u00010\u000eH\u0007\u001a\f\u0010 \u001a\u00020\u001b*\u00020\u001cH\u0007\u001a,\u0010!\u001a\u00020\u001b*\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001e2\u0016\b\u0002\u0010\u001f\u001a\u0010\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u001b\u0018\u00010\u000eH\u0007\u001a \u0010\"\u001a\u00020\u001b*\u00020\u001c2\u0012\u0010\u001d\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00110$0#H\u0007\"\u000e\u0010\u0000\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0003\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"$\u0010\u0004\u001a\u00020\u00058\u0006@\u0006X\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\u0006\u0010\u0007\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000b\u0002\u0004\n\u0002\b\u0019¨\u0006%"}, d2 = {"FLUTTER_SHARED_PREFS_KEY_PREFIX", "", "FLUTTER_SHARED_PREFS_NAME", "POPUP_SHOWN_KEY", "stopGemFeature", "", "getStopGemFeature$annotations", "()V", "getStopGemFeature", "()Z", "setStopGemFeature", "(Z)V", "isLoggedIn", "loadOrRequestOffer", "Lkotlin/Function1;", "Lkotlin/coroutines/Continuation;", "Lkotlin/Result;", "Lcom/talabat/gem/domain/entities/GemOffer;", "", "refresh", "(Lkotlin/jvm/functions/Function1;)Lkotlin/jvm/functions/Function1;", "locationIsAvailable", "locationIsAvailableForFlutterHome", "refreshFromFlutterHomeOffer", "()Lkotlin/jvm/functions/Function1;", "refreshOffer", "bindOffer", "", "Lcom/talabat/gem/ports/presentation/GemViewPort;", "requester", "Lcom/talabat/gem/domain/usecases/GemOfferRequester;", "onOfferReceived", "bindOfferAsObserver", "onRequestOffer", "requestAndBindOffer", "Lkotlin/Function0;", "Lio/reactivex/Single;", "com_talabat_Components_gem-core_gem-core"}, k = 2, mv = {1, 6, 0}, xi = 48)
public final class GemViewBusinessRulesKt {
    @NotNull
    public static final String FLUTTER_SHARED_PREFS_KEY_PREFIX = "flutter.";
    @NotNull
    public static final String FLUTTER_SHARED_PREFS_NAME = "FlutterSharedPreferences";
    @NotNull
    public static final String POPUP_SHOWN_KEY = "gem.expiration.popup.shown";
    private static boolean stopGemFeature = IntegrationKt.getFeatureFlags().getFeatureFlag(TalabatFeatureFlagConstants.STOP_GEM_FEATURE, false);

    @BusinessRules
    @Deprecated(level = DeprecationLevel.WARNING, message = "use onRequestOffer() instead", replaceWith = @ReplaceWith(expression = "onRequestOffer(requester, onOfferReceived)", imports = {"com.talabat.gem.domain.usecases.onRequestOffer"}))
    public static final void bindOffer(@NotNull GemViewPort gemViewPort, @NotNull GemOfferRequester gemOfferRequester, @Nullable Function1<? super GemOffer, Unit> function1) {
        Intrinsics.checkNotNullParameter(gemViewPort, "<this>");
        Intrinsics.checkNotNullParameter(gemOfferRequester, "requester");
        gemViewPort.autoDispose(new GemViewBusinessRulesKt$bindOffer$1(gemOfferRequester, gemViewPort, function1));
    }

    public static /* synthetic */ void bindOffer$default(GemViewPort gemViewPort, GemOfferRequester gemOfferRequester, Function1 function1, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            function1 = null;
        }
        bindOffer(gemViewPort, gemOfferRequester, function1);
    }

    @BusinessRules
    public static final void bindOfferAsObserver(@NotNull GemViewPort gemViewPort) {
        Intrinsics.checkNotNullParameter(gemViewPort, "<this>");
        gemViewPort.autoDispose(new GemViewBusinessRulesKt$bindOfferAsObserver$1(gemViewPort));
    }

    public static final boolean getStopGemFeature() {
        return stopGemFeature;
    }

    @VisibleForTesting
    public static /* synthetic */ void getStopGemFeature$annotations() {
    }

    private static final boolean isLoggedIn() {
        boolean isLoggedIn = Customer.getInstance().isLoggedIn();
        if (!isLoggedIn) {
            AnalyticsPort.DefaultImpls.trackGemFlutterHomeData$default(IntegrationKt.getAnalytics(), (String) null, (String) null, (Map) null, "User is not logged in", 7, (Object) null);
        }
        return isLoggedIn;
    }

    @NotNull
    @BusinessRules
    public static final Function1<Continuation<? super Result<GemOffer>>, Object> loadOrRequestOffer(@Nullable Function1<? super Continuation<? super Result<GemOffer>>, ? extends Object> function1) {
        return KotlinResultKt.flatMapError(IntegrationKt.getDataSources().loadGemOffer(), new GemViewBusinessRulesKt$loadOrRequestOffer$1(function1, (Continuation<? super GemViewBusinessRulesKt$loadOrRequestOffer$1>) null));
    }

    public static /* synthetic */ Function1 loadOrRequestOffer$default(Function1 function1, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            function1 = null;
        }
        return loadOrRequestOffer(function1);
    }

    public static final boolean locationIsAvailable() {
        boolean z11;
        boolean z12;
        boolean z13;
        boolean z14;
        String latitude = GlobalDataModel.LATLONGFORAPI.getLatitude();
        if (latitude == null || latitude.length() == 0) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (z11) {
            return false;
        }
        String longitude = GlobalDataModel.LATLONGFORAPI.getLongitude();
        if (longitude == null || longitude.length() == 0) {
            z12 = true;
        } else {
            z12 = false;
        }
        if (z12) {
            return false;
        }
        String latitude2 = GlobalDataModel.LATLONGFORAPI.getLatitude();
        Intrinsics.checkNotNullExpressionValue(latitude2, "getLatitude()");
        if (Double.parseDouble(latitude2) == 0.0d) {
            z13 = true;
        } else {
            z13 = false;
        }
        if (z13) {
            return false;
        }
        String longitude2 = GlobalDataModel.LATLONGFORAPI.getLongitude();
        Intrinsics.checkNotNullExpressionValue(longitude2, "getLongitude()");
        if (Double.parseDouble(longitude2) == 0.0d) {
            z14 = true;
        } else {
            z14 = false;
        }
        if (!z14) {
            return true;
        }
        return false;
    }

    private static final boolean locationIsAvailableForFlutterHome() {
        boolean z11;
        boolean z12;
        boolean z13;
        boolean z14;
        String latitude = GlobalDataModel.LATLONGFORAPI.getLatitude();
        boolean z15 = false;
        if (latitude == null || latitude.length() == 0) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (!z11) {
            String longitude = GlobalDataModel.LATLONGFORAPI.getLongitude();
            if (longitude == null || longitude.length() == 0) {
                z12 = true;
            } else {
                z12 = false;
            }
            if (!z12) {
                String latitude2 = GlobalDataModel.LATLONGFORAPI.getLatitude();
                Intrinsics.checkNotNullExpressionValue(latitude2, "getLatitude()");
                if (Double.parseDouble(latitude2) == 0.0d) {
                    z13 = true;
                } else {
                    z13 = false;
                }
                if (!z13) {
                    String longitude2 = GlobalDataModel.LATLONGFORAPI.getLongitude();
                    Intrinsics.checkNotNullExpressionValue(longitude2, "getLongitude()");
                    if (Double.parseDouble(longitude2) == 0.0d) {
                        z14 = true;
                    } else {
                        z14 = false;
                    }
                    if (!z14) {
                        z15 = true;
                    }
                }
            }
        }
        if (!z15) {
            AnalyticsPort.DefaultImpls.trackGemFlutterHomeData$default(IntegrationKt.getAnalytics(), (String) null, (String) null, (Map) null, "Location is not available", 7, (Object) null);
        }
        return z15;
    }

    @BusinessRules
    public static final void onRequestOffer(@NotNull GemViewPort gemViewPort, @NotNull GemOfferRequester gemOfferRequester, @Nullable Function1<? super GemOffer, Unit> function1) {
        Intrinsics.checkNotNullParameter(gemViewPort, "<this>");
        Intrinsics.checkNotNullParameter(gemOfferRequester, "requester");
        bindOffer(gemViewPort, gemOfferRequester, function1);
    }

    public static /* synthetic */ void onRequestOffer$default(GemViewPort gemViewPort, GemOfferRequester gemOfferRequester, Function1 function1, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            function1 = null;
        }
        onRequestOffer(gemViewPort, gemOfferRequester, function1);
    }

    @NotNull
    @BusinessRules
    public static final Function1<Continuation<? super Result<GemOffer>>, Object> refreshFromFlutterHomeOffer() {
        if (!isLoggedIn() || !locationIsAvailableForFlutterHome()) {
            return IntegrationKt.getDataSources().saveGemOffer(BusinessRulesKt.getNullGemOffer());
        }
        Function1<Continuation<? super Result<? extends Object>>, Object> flatMap = KotlinResultKt.flatMap(IntegrationKt.getDataSources().requestGemOfferFromFlutterHome(), new GemViewBusinessRulesKt$refreshFromFlutterHomeOffer$1((Continuation<? super GemViewBusinessRulesKt$refreshFromFlutterHomeOffer$1>) null));
        IntegrationKt.getDataSources().updateExpiredOffer(BusinessRulesKt.getNullGemOffer());
        Integration.getAppContext().getSharedPreferences(FLUTTER_SHARED_PREFS_NAME, 0).edit().putBoolean("flutter.gem.expiration.popup.shown", false).apply();
        return KotlinResultKt.flatMapError(KotlinResultKt.doOnNext(KotlinResultKt.doOnNext(flatMap, new GemViewBusinessRulesKt$refreshFromFlutterHomeOffer$4((Continuation<? super GemViewBusinessRulesKt$refreshFromFlutterHomeOffer$4>) null)), new GemViewBusinessRulesKt$refreshFromFlutterHomeOffer$5((Continuation<? super GemViewBusinessRulesKt$refreshFromFlutterHomeOffer$5>) null)), new GemViewBusinessRulesKt$refreshFromFlutterHomeOffer$6((Continuation<? super GemViewBusinessRulesKt$refreshFromFlutterHomeOffer$6>) null));
    }

    @NotNull
    @BusinessRules
    public static final Function1<Continuation<? super Result<GemOffer>>, Object> refreshOffer() {
        if (!Customer.getInstance().isLoggedIn() || !locationIsAvailable() || stopGemFeature) {
            return IntegrationKt.getDataSources().saveGemOffer(BusinessRulesKt.getNullGemOffer());
        }
        Function1<Continuation<? super Result<? extends Object>>, Object> flatMap = KotlinResultKt.flatMap(IntegrationKt.getDataSources().requestGemOffer(), new GemViewBusinessRulesKt$refreshOffer$1((Continuation<? super GemViewBusinessRulesKt$refreshOffer$1>) null));
        IntegrationKt.getDataSources().updateExpiredOffer(BusinessRulesKt.getNullGemOffer());
        Integration.getAppContext().getSharedPreferences(FLUTTER_SHARED_PREFS_NAME, 0).edit().putBoolean("flutter.gem.expiration.popup.shown", false).apply();
        return KotlinResultKt.flatMapError(KotlinResultKt.doOnNext(KotlinResultKt.doOnNext(flatMap, new GemViewBusinessRulesKt$refreshOffer$4((Continuation<? super GemViewBusinessRulesKt$refreshOffer$4>) null)), new GemViewBusinessRulesKt$refreshOffer$5((Continuation<? super GemViewBusinessRulesKt$refreshOffer$5>) null)), new GemViewBusinessRulesKt$refreshOffer$6((Continuation<? super GemViewBusinessRulesKt$refreshOffer$6>) null));
    }

    @BusinessRules
    public static final void requestAndBindOffer(@NotNull GemViewPort gemViewPort, @NotNull Function0<? extends Single<GemOffer>> function0) {
        Intrinsics.checkNotNullParameter(gemViewPort, "<this>");
        Intrinsics.checkNotNullParameter(function0, "requester");
        ((Single) function0.invoke()).subscribeOn(gemViewPort.getScheduler()).observeOn(gemViewPort.getScheduler()).ignoreElement().doOnError(new u(gemViewPort.getErrors())).onErrorComplete().subscribe();
        bindOfferAsObserver(gemViewPort);
    }

    public static final void setStopGemFeature(boolean z11) {
        stopGemFeature = z11;
    }
}
