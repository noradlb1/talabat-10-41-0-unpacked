package com.talabat.gem.adapters.data;

import JsonModels.Response.GEMResponse.GemOfferResponse;
import com.talabat.gem.IntegrationKt;
import com.talabat.gem.adapters.data.GemEndPoints;
import com.talabat.gem.domain.entities.GemOffer;
import com.talabat.gem.domain.entities.GemRestaurant;
import com.talabat.gem.domain.entities.GemTier;
import com.talabat.gem.ports.analytics.AnalyticsPort;
import com.talabat.gem.ports.logging.LoggerPort;
import io.reactivex.Single;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import retrofit2.HttpException;

@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u0010\u0012\f\u0012\n \u0003*\u0004\u0018\u00010\u00020\u00020\u0001*\u00020\u0004H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "Lio/reactivex/Single;", "Lcom/talabat/gem/domain/entities/GemOffer;", "kotlin.jvm.PlatformType", "Lcom/talabat/gem/adapters/data/GemEndPoints;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class ServerKt$newOfferRequestFromFlutterHome$2 extends Lambda implements Function1<GemEndPoints, Single<GemOffer>> {
    public static final ServerKt$newOfferRequestFromFlutterHome$2 INSTANCE = new ServerKt$newOfferRequestFromFlutterHome$2();

    public ServerKt$newOfferRequestFromFlutterHome$2() {
        super(1);
    }

    /* access modifiers changed from: private */
    /* renamed from: invoke$lambda-0  reason: not valid java name */
    public static final GemOfferRawResponse m10515invoke$lambda0(GemOfferRawResponse gemOfferRawResponse) {
        Intrinsics.checkNotNullParameter(gemOfferRawResponse, "it");
        return ServerKt.assertNonNullOfferId(gemOfferRawResponse);
    }

    /* access modifiers changed from: private */
    /* renamed from: invoke$lambda-1  reason: not valid java name */
    public static final GemOfferRawResponse m10516invoke$lambda1(GemOfferRawResponse gemOfferRawResponse) {
        Intrinsics.checkNotNullParameter(gemOfferRawResponse, "it");
        return ServerKt.assertNotExpired(gemOfferRawResponse);
    }

    /* access modifiers changed from: private */
    /* renamed from: invoke$lambda-2  reason: not valid java name */
    public static final GemOfferResponse m10517invoke$lambda2(GemOfferRawResponse gemOfferRawResponse) {
        Intrinsics.checkNotNullParameter(gemOfferRawResponse, "it");
        return gemOfferRawResponse.getResponse();
    }

    /* access modifiers changed from: private */
    /* renamed from: invoke$lambda-3  reason: not valid java name */
    public static final GemOffer m10518invoke$lambda3(GemOfferResponse gemOfferResponse) {
        Intrinsics.checkNotNullParameter(gemOfferResponse, "it");
        return GemMappersKt.toGemOffer(gemOfferResponse);
    }

    /* access modifiers changed from: private */
    /* renamed from: invoke$lambda-4  reason: not valid java name */
    public static final GemOffer m10519invoke$lambda4(GemOffer gemOffer) {
        Intrinsics.checkNotNullParameter(gemOffer, "it");
        return ServerKt.assertNotEmpty(gemOffer);
    }

    /* access modifiers changed from: private */
    /* renamed from: invoke$lambda-5  reason: not valid java name */
    public static final void m10520invoke$lambda5(GemOffer gemOffer) {
        Integer num;
        AnalyticsPort analytics = IntegrationKt.getAnalytics();
        String id2 = gemOffer.getId();
        List<GemRestaurant> restaurants = gemOffer.getRestaurants();
        Integer num2 = null;
        if (restaurants != null) {
            num = Integer.valueOf(restaurants.size());
        } else {
            num = null;
        }
        List<GemTier> tiers = gemOffer.getTiers();
        if (tiers != null) {
            num2 = Integer.valueOf(tiers.size());
        }
        AnalyticsPort.DefaultImpls.onGemApiCallResponse$default(analytics, ServerKt.API_OFFERS_BY_LOCATION_URL, "success", id2, (String) null, num, num2, (Integer) null, (String) null, "flutter_home", 200, (Object) null);
    }

    /* access modifiers changed from: private */
    /* renamed from: invoke$lambda-6  reason: not valid java name */
    public static final void m10521invoke$lambda6(Throwable th2) {
        String str;
        int i11;
        AnalyticsPort analytics = IntegrationKt.getAnalytics();
        boolean z11 = th2 instanceof HttpException;
        if (z11) {
            str = "error";
        } else {
            str = "success";
        }
        if (z11) {
            i11 = ((HttpException) th2).code();
        } else {
            i11 = 0;
        }
        AnalyticsPort.DefaultImpls.onGemApiCallResponse$default(analytics, ServerKt.API_OFFERS_BY_LOCATION_URL, str, (String) null, (String) null, (Integer) null, (Integer) null, Integer.valueOf(i11), th2.getMessage(), "flutter_home", 60, (Object) null);
        LoggerPort logger = IntegrationKt.getLogger();
        Intrinsics.checkNotNullExpressionValue(th2, "it");
        logger.logError(th2);
    }

    @NotNull
    public final Single<GemOffer> invoke(@NotNull GemEndPoints gemEndPoints) {
        Intrinsics.checkNotNullParameter(gemEndPoints, "$this$server");
        AnalyticsPort.DefaultImpls.onGemApiCallRequest$default(IntegrationKt.getAnalytics(), ServerKt.API_OFFERS_BY_LOCATION_URL, "loading", (String) null, (String) null, "flutter_home", 12, (Object) null);
        return GemEndPoints.DefaultImpls.requestOffersByLocation$default(gemEndPoints, (String) null, (String) null, (GemOffersByLocationRequest) null, 7, (Object) null).map(new h()).map(new i()).map(new j()).map(new k()).map(new l()).doOnSuccess(new m()).doOnError(new n());
    }
}
