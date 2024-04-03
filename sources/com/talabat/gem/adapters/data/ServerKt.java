package com.talabat.gem.adapters.data;

import JsonModels.GemAcceptResponse;
import JsonModels.GemRejectResponse;
import JsonModels.Response.GEMResponse.GemOfferResponse;
import com.talabat.configuration.country.Country;
import com.talabat.core.network.endpoint.MonolithEndPointProvider;
import com.talabat.gem.IntegrationKt;
import com.talabat.gem.domain.entities.GemOffer;
import com.talabat.gem.domain.entities.GemRestaurant;
import com.talabat.gem.domain.usecases.BusinessRulesKt;
import com.talabat.helpers.GlobalDataModel;
import com.talabat.talabatcommon.extentions.Nullable;
import com.talabat.talabatcommon.extentions.RxKt;
import gateways.DataSourcesDelegateKt;
import io.reactivex.Single;
import java.util.Collection;
import kotlin.Metadata;
import kotlin.UninitializedPropertyAccessException;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference0Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.properties.Delegates;
import kotlin.properties.ReadOnlyProperty;
import kotlin.properties.ReadWriteProperty;
import kotlin.reflect.KProperty;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000H\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u0018\u0010.\u001a\u00020\u00012\u0006\u0010/\u001a\u00020\u00012\u0006\u00100\u001a\u00020\u0001H\u0002\u001a\b\u0010/\u001a\u00020\u0001H\u0002\u001a\b\u00101\u001a\u00020\u0001H\u0002\u001a\u0010\u00102\u001a\u00020\u00012\u0006\u0010/\u001a\u00020\u0001H\u0002\u001a\b\u00100\u001a\u00020\u0001H\u0002\u001a\f\u00103\u001a\u00020\u001e*\u00020\u001eH\u0002\u001a\f\u00104\u001a\u000205*\u000205H\u0002\u001a\f\u00106\u001a\u00020\u001e*\u000207H\u0002\u001a\f\u00106\u001a\u00020\"*\u000208H\u0002\u001a\f\u00109\u001a\u00020\u0014*\u00020\u0014H\u0002\u001a\f\u0010:\u001a\u000205*\u000205H\u0002\"\u000e\u0010\u0000\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0003\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0004\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0005\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0006\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0007\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\b\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\t\u001a\u00020\nXT¢\u0006\u0002\n\u0000\"\u000e\u0010\u000b\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\f\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u001a\u0010\r\u001a\u00020\u0001X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011\")\u0010\u0012\u001a\u0010\u0012\f\u0012\n \u0015*\u0004\u0018\u00010\u00140\u00140\u00138@X\u0002¢\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u0016\u0010\u0017\")\u0010\u001a\u001a\u0010\u0012\f\u0012\n \u0015*\u0004\u0018\u00010\u00140\u00140\u00138@X\u0002¢\u0006\f\n\u0004\b\u001c\u0010\u0019\u001a\u0004\b\u001b\u0010\u0017\")\u0010\u001d\u001a\u0010\u0012\f\u0012\n \u0015*\u0004\u0018\u00010\u001e0\u001e0\u00138@X\u0002¢\u0006\f\n\u0004\b \u0010\u0019\u001a\u0004\b\u001f\u0010\u0017\")\u0010!\u001a\u0010\u0012\f\u0012\n \u0015*\u0004\u0018\u00010\"0\"0\u00138@X\u0002¢\u0006\f\n\u0004\b$\u0010\u0019\u001a\u0004\b#\u0010\u0017\"\u001d\u0010%\u001a\u0004\u0018\u00010&8BX\u0002¢\u0006\f\n\u0004\b)\u0010*\u001a\u0004\b'\u0010(\"\u0014\u0010+\u001a\u00020\n8@X\u0004¢\u0006\u0006\u001a\u0004\b,\u0010-¨\u0006;"}, d2 = {"ACCEPT_GEM_URL", "", "API_OFFERS_BY_LOCATION_URL", "ERROR_STATUS", "KEY_SANDBOX_RESPONSE", "LOADING_STATUS", "PLACE_HOLDER_COUNTRY_SLUG", "PLACE_HOLDER_OFFER_ID", "PLACE_HOLDER_RESERVATION_CODE", "RED_DURATION_MINIMUM", "", "REJECT_GEM_URL", "SUCCESS_STATUS", "baseUrl", "getBaseUrl", "()Ljava/lang/String;", "setBaseUrl", "(Ljava/lang/String;)V", "newOffer", "Lio/reactivex/Single;", "Lcom/talabat/gem/domain/entities/GemOffer;", "kotlin.jvm.PlatformType", "getNewOffer", "()Lio/reactivex/Single;", "newOffer$delegate", "Lkotlin/properties/ReadOnlyProperty;", "newOfferRequestFromFlutterHome", "getNewOfferRequestFromFlutterHome", "newOfferRequestFromFlutterHome$delegate", "offerAcceptance", "LJsonModels/GemAcceptResponse;", "getOfferAcceptance", "offerAcceptance$delegate", "offerRejection", "LJsonModels/GemRejectResponse;", "getOfferRejection", "offerRejection$delegate", "sandboxResponse", "", "getSandboxResponse", "()Ljava/lang/Boolean;", "sandboxResponse$delegate", "Lkotlin/properties/ReadWriteProperty;", "selectedCountryId", "getSelectedCountryId", "()I", "acceptUrl", "offerId", "reservationCode", "offersByLocationUrl", "rejectUrl", "assertGemIsAccepted", "assertNonNullOfferId", "Lcom/talabat/gem/adapters/data/GemOfferRawResponse;", "assertNonNullResult", "Lcom/talabat/gem/adapters/data/GemAcceptRawResponse;", "Lcom/talabat/gem/adapters/data/GemRejectRawResponse;", "assertNotEmpty", "assertNotExpired", "com_talabat_Components_gem_gem"}, k = 2, mv = {1, 6, 0}, xi = 48)
public final class ServerKt {
    @NotNull
    public static final String ACCEPT_GEM_URL = "v1/restaurants/acceptGem/{countrySlug}/{offerId}/{reservationCode}";
    @NotNull
    public static final String API_OFFERS_BY_LOCATION_URL = "v1/restaurants/gemOffersByLocation";
    @NotNull
    private static final String ERROR_STATUS = "error";
    @NotNull
    public static final String KEY_SANDBOX_RESPONSE = "com.talabat.gem.adapters.data.KEY_SANDBOX_RESPONSE";
    @NotNull
    private static final String LOADING_STATUS = "loading";
    @NotNull
    private static final String PLACE_HOLDER_COUNTRY_SLUG = "{countrySlug}";
    @NotNull
    private static final String PLACE_HOLDER_OFFER_ID = "{offerId}";
    @NotNull
    private static final String PLACE_HOLDER_RESERVATION_CODE = "{reservationCode}";
    private static final int RED_DURATION_MINIMUM = 1000;
    @NotNull
    public static final String REJECT_GEM_URL = "v1/restaurants/rejectGem/{countrySlug}/{offerId}";
    @NotNull
    private static final String SUCCESS_STATUS = "success";

    /* renamed from: a  reason: collision with root package name */
    public static final /* synthetic */ KProperty<Object>[] f59872a;
    @NotNull
    private static String baseUrl = MonolithEndPointProvider.INSTANCE.getBaseUrl();
    @NotNull
    private static final ReadOnlyProperty newOffer$delegate;
    @NotNull
    private static final ReadOnlyProperty newOfferRequestFromFlutterHome$delegate;
    @NotNull
    private static final ReadOnlyProperty offerAcceptance$delegate;
    @NotNull
    private static final ReadOnlyProperty offerRejection$delegate;
    @NotNull
    private static final ReadWriteProperty sandboxResponse$delegate = DataSourcesDelegateKt.preferences$default(Delegates.INSTANCE, KEY_SANDBOX_RESPONSE, (Object) null, (Function1) null, 6, (Object) null);

    static {
        Class<ServerKt> cls = ServerKt.class;
        f59872a = new KProperty[]{Reflection.property0(new PropertyReference0Impl(cls, "sandboxResponse", "getSandboxResponse()Ljava/lang/Boolean;", 1)), Reflection.property0(new PropertyReference0Impl(cls, "newOffer", "getNewOffer()Lio/reactivex/Single;", 1)), Reflection.property0(new PropertyReference0Impl(cls, "newOfferRequestFromFlutterHome", "getNewOfferRequestFromFlutterHome()Lio/reactivex/Single;", 1)), Reflection.property0(new PropertyReference0Impl(cls, "offerAcceptance", "getOfferAcceptance()Lio/reactivex/Single;", 1)), Reflection.property0(new PropertyReference0Impl(cls, "offerRejection", "getOfferRejection()Lio/reactivex/Single;", 1))};
        Class<GemEndPoints> cls2 = GemEndPoints.class;
        newOffer$delegate = new ServerKt$special$$inlined$server$1(Reflection.getOrCreateKotlinClass(cls2), ServerKt$newOffer$2.INSTANCE);
        newOfferRequestFromFlutterHome$delegate = new ServerKt$special$$inlined$server$2(Reflection.getOrCreateKotlinClass(cls2), ServerKt$newOfferRequestFromFlutterHome$2.INSTANCE);
        offerAcceptance$delegate = new ServerKt$special$$inlined$server$3(Reflection.getOrCreateKotlinClass(cls2), ServerKt$offerAcceptance$2.INSTANCE);
        offerRejection$delegate = new ServerKt$special$$inlined$server$4(Reflection.getOrCreateKotlinClass(cls2), ServerKt$offerRejection$2.INSTANCE);
    }

    /* access modifiers changed from: private */
    public static final String acceptUrl(String str, String str2) {
        String str3 = baseUrl;
        String replace$default = StringsKt__StringsJVMKt.replace$default(StringsKt__StringsJVMKt.replace$default(StringsKt__StringsJVMKt.replace$default(ACCEPT_GEM_URL, PLACE_HOLDER_COUNTRY_SLUG, String.valueOf(GlobalDataModel.SelectedCountryId), false, 4, (Object) null), PLACE_HOLDER_OFFER_ID, str, false, 4, (Object) null), PLACE_HOLDER_RESERVATION_CODE, str2, false, 4, (Object) null);
        return str3 + replace$default;
    }

    /* access modifiers changed from: private */
    public static final GemAcceptResponse assertGemIsAccepted(GemAcceptResponse gemAcceptResponse) {
        if (!gemAcceptResponse.isGemAccepted) {
            gemAcceptResponse = null;
        }
        if (gemAcceptResponse != null) {
            return gemAcceptResponse;
        }
        throw GemOfferProcessingFailedException.INSTANCE;
    }

    /* access modifiers changed from: private */
    public static final GemOfferRawResponse assertNonNullOfferId(GemOfferRawResponse gemOfferRawResponse) {
        GemOfferResponse response = gemOfferRawResponse.getResponse();
        if ((response != null ? response.offerId : null) != null) {
            return gemOfferRawResponse;
        }
        throw NoGemOfferException.INSTANCE;
    }

    /* access modifiers changed from: private */
    public static final GemAcceptResponse assertNonNullResult(GemAcceptRawResponse gemAcceptRawResponse) {
        GemAcceptResponse result = gemAcceptRawResponse.getResult();
        if (result != null) {
            return result;
        }
        throw GemOfferProcessingFailedException.INSTANCE;
    }

    /* access modifiers changed from: private */
    public static final GemOffer assertNotEmpty(GemOffer gemOffer) {
        Collection restaurants = gemOffer.getRestaurants();
        if (!(restaurants == null || restaurants.isEmpty())) {
            return gemOffer;
        }
        throw NoGemOfferException.INSTANCE;
    }

    /* access modifiers changed from: private */
    public static final GemOfferRawResponse assertNotExpired(GemOfferRawResponse gemOfferRawResponse) {
        Float f11;
        GemOfferResponse response = gemOfferRawResponse.getResponse();
        if (response != null) {
            f11 = Float.valueOf(response.remDuration);
        } else {
            f11 = null;
        }
        if (f11 == null) {
            throw GemOfferExpiredException.INSTANCE;
        } else if (gemOfferRawResponse.getResponse().remDuration >= 1000.0f) {
            return gemOfferRawResponse;
        } else {
            throw GemOfferExpiredException.INSTANCE;
        }
    }

    @NotNull
    public static final String getBaseUrl() {
        return baseUrl;
    }

    @NotNull
    public static final Single<GemOffer> getNewOffer() {
        return (Single) newOffer$delegate.getValue(null, f59872a[1]);
    }

    @NotNull
    public static final Single<GemOffer> getNewOfferRequestFromFlutterHome() {
        return (Single) newOfferRequestFromFlutterHome$delegate.getValue(null, f59872a[2]);
    }

    @NotNull
    public static final Single<GemAcceptResponse> getOfferAcceptance() {
        return (Single) offerAcceptance$delegate.getValue(null, f59872a[3]);
    }

    @NotNull
    public static final Single<GemRejectResponse> getOfferRejection() {
        return (Single) offerRejection$delegate.getValue(null, f59872a[4]);
    }

    /* access modifiers changed from: private */
    public static final Boolean getSandboxResponse() {
        return (Boolean) sandboxResponse$delegate.getValue(null, f59872a[0]);
    }

    public static final int getSelectedCountryId() {
        Country country;
        try {
            com.talabat.configuration.location.Country selectedCountry = IntegrationKt.getLocationConfig().selectedCountry();
            if (selectedCountry == null || (country = selectedCountry.getCountry()) == null) {
                return GlobalDataModel.SelectedCountryId;
            }
            return country.getCountryId();
        } catch (UninitializedPropertyAccessException unused) {
            return GlobalDataModel.SelectedCountryId;
        }
    }

    /* access modifiers changed from: private */
    public static final String offerId() {
        GemOffer gemOffer;
        String id2;
        Nullable nullable = (Nullable) RxKt.invoke(CacheKt.getCachedOffer());
        if (nullable != null && (gemOffer = (GemOffer) nullable.getValue()) != null && (id2 = gemOffer.getId()) != null) {
            return id2;
        }
        throw NoCachedGemOfferIdException.INSTANCE;
    }

    /* access modifiers changed from: private */
    public static final String offersByLocationUrl() {
        String str = baseUrl;
        return str + API_OFFERS_BY_LOCATION_URL;
    }

    /* access modifiers changed from: private */
    public static final String rejectUrl(String str) {
        String str2 = baseUrl;
        String replace$default = StringsKt__StringsJVMKt.replace$default(StringsKt__StringsJVMKt.replace$default(REJECT_GEM_URL, PLACE_HOLDER_COUNTRY_SLUG, String.valueOf(GlobalDataModel.SelectedCountryId), false, 4, (Object) null), PLACE_HOLDER_OFFER_ID, str, false, 4, (Object) null);
        return str2 + replace$default;
    }

    /* access modifiers changed from: private */
    public static final String reservationCode() {
        GemRestaurant gemRestaurant = (GemRestaurant) RxKt.get(CacheKt.getSelectedGemRestaurant(), BusinessRulesKt.getNullGemRestaurant());
        if (!Intrinsics.areEqual((Object) gemRestaurant, (Object) BusinessRulesKt.getNullGemRestaurant())) {
            String reservationCode = gemRestaurant.getReservationCode();
            if (reservationCode != null) {
                return reservationCode;
            }
            throw NoCachedReservationCodeException.INSTANCE;
        }
        throw NoCachedGemRestaurantException.INSTANCE;
    }

    public static final void setBaseUrl(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        baseUrl = str;
    }

    /* access modifiers changed from: private */
    public static final GemRejectResponse assertNonNullResult(GemRejectRawResponse gemRejectRawResponse) {
        GemRejectResponse result = gemRejectRawResponse.getResult();
        if (result != null) {
            return result;
        }
        throw GemOfferProcessingFailedException.INSTANCE;
    }
}
