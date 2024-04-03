package com.integration.nfv.observability;

import com.talabat.core.di.ApiContainer;
import com.talabat.feature.foodcart2.data.datasources.FoodCartFlutterDataSourceImpl;
import com.talabat.observability.squads.nfv.NFVEventType;
import com.talabat.observability.squads.nfv.ObservableAttributesNames;
import com.talabat.observability.squads.nfv.ObservableNfvApiNames;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u001d\n\u0002\u0010\t\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\t\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u0006J\u0016\u0010\t\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bJ\u000e\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\u0004J&\u0010\r\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0004J\u0016\u0010\u0012\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u0010J\u000e\u0010\u0014\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\u0004J&\u0010\u0015\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0004J\u001e\u0010\u0016\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0004J\u001e\u0010\u0017\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\u00042\u0006\u0010\u0018\u001a\u00020\u00042\u0006\u0010\u0019\u001a\u00020\u0004J\u0016\u0010\u001a\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\u00042\u0006\u0010\u001b\u001a\u00020\u0004J\u001e\u0010\u001c\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\u00042\u0006\u0010\u0018\u001a\u00020\u00042\u0006\u0010\u0019\u001a\u00020\u0004J\u000e\u0010\u001d\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\u0004J'\u0010\u001e\u001a\u00020\n2\u0006\u0010\u001f\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u00042\n\b\u0002\u0010 \u001a\u0004\u0018\u00010\u0010¢\u0006\u0002\u0010!J\u001e\u0010\"\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u00042\u0006\u0010#\u001a\u00020\u0004J&\u0010$\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u00042\u0006\u0010#\u001a\u00020\u00042\u0006\u0010%\u001a\u00020\u0004J&\u0010&\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\u00042\u0006\u0010'\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0004J\u0006\u0010(\u001a\u00020\nJ\u001e\u0010)\u001a\u00020\n2\u0006\u0010\u0011\u001a\u00020\u00042\u0006\u0010#\u001a\u00020\u00042\u0006\u0010*\u001a\u00020\u0004J2\u0010+\u001a\u00020\n2\u0006\u0010,\u001a\u00020\u00042\u0006\u0010-\u001a\u00020.2\u0006\u0010/\u001a\u00020.2\b\u00100\u001a\u0004\u0018\u00010\u00042\b\u00101\u001a\u0004\u0018\u00010\u0004J\u0010\u00102\u001a\u00020\n2\b\u0010\u0011\u001a\u0004\u0018\u00010\u0004J \u00103\u001a\u00020\n2\b\b\u0002\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00042\u0006\u00104\u001a\u00020\u0004J \u00105\u001a\u00020\n2\b\b\u0002\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00042\u0006\u00104\u001a\u00020\u0004J&\u00106\u001a\u00020\n2\u0006\u00107\u001a\u00020\u00042\u0006\u00108\u001a\u00020\u00042\u0006\u00109\u001a\u00020:2\u0006\u0010;\u001a\u00020\u0010J \u0010<\u001a\u00020\n2\u0006\u00107\u001a\u00020\u00042\u0006\u0010=\u001a\u00020:2\b\b\u0002\u0010 \u001a\u00020\u0010J<\u0010>\u001a\u00020\n2\u0006\u0010?\u001a\u00020\u00042\u0006\u0010@\u001a\u00020\u00042\"\u0010A\u001a\u001e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040Bj\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004`CH\u0002J\u0016\u0010D\u001a\u00020\n2\u0006\u00107\u001a\u00020\u00042\u0006\u0010E\u001a\u00020\u0010R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X.¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX.¢\u0006\u0002\n\u0000¨\u0006F"}, d2 = {"Lcom/integration/nfv/observability/NfvObservabilityHandler;", "", "()V", "DELIVERY_FEE_MESSAGE_FOR_VENDOR", "", "apiContainer", "Lcom/talabat/core/di/ApiContainer;", "nfvObservability", "Lcom/integration/nfv/observability/NfvObservability;", "initialize", "", "onDarkstoresBannersEmpty", "vendorId", "onDarkstoresCartError", "cartId", "errorCode", "", "errorMessage", "onDarkstoresCategoriesMissing", "count", "onDarkstoresCategoriesNotLoaded", "onDarkstoresCheckoutFailure", "onDarkstoresDpsError", "onDarkstoresEmptyProductsList", "categoryName", "categoryId", "onDarkstoresEmptySearchResults", "query", "onDarkstoresEmptySubCategories", "onDarkstoresHeroBannersEmpty", "onDarkstoresImageLoadError", "imageUrl", "statusCode", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;)V", "onDarkstoresMigratedFalseDjiniValidation", "productId", "onDarkstoresOutOfStockError", "countryCode", "onDarkstoresVendorNotLoaded", "talabatCode", "onNegativeDeliveryFeeFromVendor", "onProductDetailsNotLoaded", "productSku", "onQCommerceImageResponseReceived", "url", "responseTime", "", "responseSize", "responseType", "responseCacheStatus", "onStaticLandingConfigurationFailed", "onTMartGrowthGetFailed", "voucherOptionId", "onTMartGrowthPostFailed", "onVerticalLoadedStatus", "message", "tile", "imageLoaded", "", "position", "onVerticalsFallback", "fallback", "sendEvent", "eventName", "eventType", "params", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "sendNumberOfVerticalsShown", "n", "com_talabat_NewArchi_TalabatIntegration_TalabatIntegration"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class NfvObservabilityHandler {
    @NotNull
    public static final String DELIVERY_FEE_MESSAGE_FOR_VENDOR = "Delivery fee is negative from Vendor.";
    @NotNull
    public static final NfvObservabilityHandler INSTANCE = new NfvObservabilityHandler();
    private static ApiContainer apiContainer;
    private static NfvObservability nfvObservability;

    private NfvObservabilityHandler() {
    }

    public static /* synthetic */ void onDarkstoresImageLoadError$default(NfvObservabilityHandler nfvObservabilityHandler, String str, String str2, Integer num, int i11, Object obj) {
        if ((i11 & 4) != 0) {
            num = null;
        }
        nfvObservabilityHandler.onDarkstoresImageLoadError(str, str2, num);
    }

    public static /* synthetic */ void onTMartGrowthGetFailed$default(NfvObservabilityHandler nfvObservabilityHandler, int i11, String str, String str2, int i12, Object obj) {
        if ((i12 & 1) != 0) {
            i11 = 400;
        }
        nfvObservabilityHandler.onTMartGrowthGetFailed(i11, str, str2);
    }

    public static /* synthetic */ void onTMartGrowthPostFailed$default(NfvObservabilityHandler nfvObservabilityHandler, int i11, String str, String str2, int i12, Object obj) {
        if ((i12 & 1) != 0) {
            i11 = 400;
        }
        nfvObservabilityHandler.onTMartGrowthPostFailed(i11, str, str2);
    }

    public static /* synthetic */ void onVerticalsFallback$default(NfvObservabilityHandler nfvObservabilityHandler, String str, boolean z11, int i11, int i12, Object obj) {
        if ((i12 & 4) != 0) {
            i11 = -1;
        }
        nfvObservabilityHandler.onVerticalsFallback(str, z11, i11);
    }

    private final void sendEvent(String str, String str2, HashMap<String, String> hashMap) {
        NfvObservability nfvObservability2 = nfvObservability;
        NfvObservability nfvObservability3 = null;
        if (nfvObservability2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("nfvObservability");
            nfvObservability2 = null;
        }
        if (nfvObservability2.isNfvObservabilityEnabled()) {
            NfvObservability nfvObservability4 = nfvObservability;
            if (nfvObservability4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("nfvObservability");
            } else {
                nfvObservability3 = nfvObservability4;
            }
            nfvObservability3.sendCustomObservabilityEvent(str, str2, hashMap);
        }
    }

    public final void initialize(@NotNull ApiContainer apiContainer2) {
        Intrinsics.checkNotNullParameter(apiContainer2, "apiContainer");
        apiContainer = apiContainer2;
        nfvObservability = new NfvObservabilityTracker(apiContainer2);
    }

    public final void onDarkstoresBannersEmpty(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "vendorId");
        NfvObservability nfvObservability2 = nfvObservability;
        NfvObservability nfvObservability3 = null;
        if (nfvObservability2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("nfvObservability");
            nfvObservability2 = null;
        }
        if (nfvObservability2.isNfvObservabilityEnabled()) {
            NfvObservability nfvObservability4 = nfvObservability;
            if (nfvObservability4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("nfvObservability");
                nfvObservability4 = null;
            }
            HashMap<String, String> baseNfvAttributes = nfvObservability4.getBaseNfvAttributes();
            baseNfvAttributes.put("vendorID", str);
            NfvObservability nfvObservability5 = nfvObservability;
            if (nfvObservability5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("nfvObservability");
            } else {
                nfvObservability3 = nfvObservability5;
            }
            nfvObservability3.sendCustomObservabilityEvent("BannersEmpty", NFVEventType.DarkstoreEvents.name(), baseNfvAttributes);
        }
    }

    public final void onDarkstoresCartError(@NotNull String str, @NotNull String str2, int i11, @NotNull String str3) {
        Intrinsics.checkNotNullParameter(str, FoodCartFlutterDataSourceImpl.cartIdKey);
        Intrinsics.checkNotNullParameter(str2, "vendorId");
        Intrinsics.checkNotNullParameter(str3, "errorMessage");
        NfvObservability nfvObservability2 = nfvObservability;
        NfvObservability nfvObservability3 = null;
        if (nfvObservability2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("nfvObservability");
            nfvObservability2 = null;
        }
        if (nfvObservability2.isNfvObservabilityEnabled()) {
            NfvObservability nfvObservability4 = nfvObservability;
            if (nfvObservability4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("nfvObservability");
                nfvObservability4 = null;
            }
            HashMap<String, String> baseNfvAttributes = nfvObservability4.getBaseNfvAttributes();
            baseNfvAttributes.put("cartID", str);
            baseNfvAttributes.put("vendorID", str2);
            baseNfvAttributes.put("api_response_code", String.valueOf(i11));
            baseNfvAttributes.put("api_response_message", str3);
            NfvObservability nfvObservability5 = nfvObservability;
            if (nfvObservability5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("nfvObservability");
            } else {
                nfvObservability3 = nfvObservability5;
            }
            nfvObservability3.sendCustomObservabilityEvent("CartError", NFVEventType.DarkstoreEvents.name(), baseNfvAttributes);
        }
    }

    public final void onDarkstoresCategoriesMissing(@NotNull String str, int i11) {
        Intrinsics.checkNotNullParameter(str, "vendorId");
        NfvObservability nfvObservability2 = nfvObservability;
        NfvObservability nfvObservability3 = null;
        if (nfvObservability2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("nfvObservability");
            nfvObservability2 = null;
        }
        if (nfvObservability2.isNfvObservabilityEnabled()) {
            NfvObservability nfvObservability4 = nfvObservability;
            if (nfvObservability4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("nfvObservability");
                nfvObservability4 = null;
            }
            HashMap<String, String> baseNfvAttributes = nfvObservability4.getBaseNfvAttributes();
            baseNfvAttributes.put("category_count", String.valueOf(i11));
            baseNfvAttributes.put("vendorID", str);
            NfvObservability nfvObservability5 = nfvObservability;
            if (nfvObservability5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("nfvObservability");
            } else {
                nfvObservability3 = nfvObservability5;
            }
            nfvObservability3.sendCustomObservabilityEvent("CategoriesMissing", NFVEventType.DarkstoreEvents.name(), baseNfvAttributes);
        }
    }

    public final void onDarkstoresCategoriesNotLoaded(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "vendorId");
        NfvObservability nfvObservability2 = nfvObservability;
        NfvObservability nfvObservability3 = null;
        if (nfvObservability2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("nfvObservability");
            nfvObservability2 = null;
        }
        if (nfvObservability2.isNfvObservabilityEnabled()) {
            NfvObservability nfvObservability4 = nfvObservability;
            if (nfvObservability4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("nfvObservability");
                nfvObservability4 = null;
            }
            HashMap<String, String> baseNfvAttributes = nfvObservability4.getBaseNfvAttributes();
            baseNfvAttributes.put("vendorID", str);
            NfvObservability nfvObservability5 = nfvObservability;
            if (nfvObservability5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("nfvObservability");
            } else {
                nfvObservability3 = nfvObservability5;
            }
            nfvObservability3.sendCustomObservabilityEvent("Categories tree not loaded", NFVEventType.DarkstoreEvents.name(), baseNfvAttributes);
        }
    }

    public final void onDarkstoresCheckoutFailure(@NotNull String str, @NotNull String str2, int i11, @NotNull String str3) {
        Intrinsics.checkNotNullParameter(str, FoodCartFlutterDataSourceImpl.cartIdKey);
        Intrinsics.checkNotNullParameter(str2, "vendorId");
        Intrinsics.checkNotNullParameter(str3, "errorMessage");
        NfvObservability nfvObservability2 = nfvObservability;
        NfvObservability nfvObservability3 = null;
        if (nfvObservability2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("nfvObservability");
            nfvObservability2 = null;
        }
        if (nfvObservability2.isNfvObservabilityEnabled()) {
            NfvObservability nfvObservability4 = nfvObservability;
            if (nfvObservability4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("nfvObservability");
                nfvObservability4 = null;
            }
            HashMap<String, String> baseNfvAttributes = nfvObservability4.getBaseNfvAttributes();
            baseNfvAttributes.put("api_response_code", String.valueOf(i11));
            baseNfvAttributes.put("api_response_message", str3);
            baseNfvAttributes.put("vendorID", str2);
            baseNfvAttributes.put("cartID", str);
            NfvObservability nfvObservability5 = nfvObservability;
            if (nfvObservability5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("nfvObservability");
            } else {
                nfvObservability3 = nfvObservability5;
            }
            nfvObservability3.sendCustomObservabilityEvent("CheckoutError", NFVEventType.DarkstoreEvents.name(), baseNfvAttributes);
        }
    }

    public final void onDarkstoresDpsError(@NotNull String str, int i11, @NotNull String str2) {
        Intrinsics.checkNotNullParameter(str, "vendorId");
        Intrinsics.checkNotNullParameter(str2, "errorMessage");
        NfvObservability nfvObservability2 = nfvObservability;
        NfvObservability nfvObservability3 = null;
        if (nfvObservability2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("nfvObservability");
            nfvObservability2 = null;
        }
        if (nfvObservability2.isNfvObservabilityEnabled()) {
            NfvObservability nfvObservability4 = nfvObservability;
            if (nfvObservability4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("nfvObservability");
                nfvObservability4 = null;
            }
            HashMap<String, String> baseNfvAttributes = nfvObservability4.getBaseNfvAttributes();
            baseNfvAttributes.put("vendorID", str);
            baseNfvAttributes.put("api_response_code", String.valueOf(i11));
            baseNfvAttributes.put("api_response_message", str2);
            NfvObservability nfvObservability5 = nfvObservability;
            if (nfvObservability5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("nfvObservability");
            } else {
                nfvObservability3 = nfvObservability5;
            }
            nfvObservability3.sendCustomObservabilityEvent("DpsError", NFVEventType.DarkstoreEvents.name(), baseNfvAttributes);
        }
    }

    public final void onDarkstoresEmptyProductsList(@NotNull String str, @NotNull String str2, @NotNull String str3) {
        Intrinsics.checkNotNullParameter(str, "vendorId");
        Intrinsics.checkNotNullParameter(str2, "categoryName");
        Intrinsics.checkNotNullParameter(str3, "categoryId");
        NfvObservability nfvObservability2 = nfvObservability;
        NfvObservability nfvObservability3 = null;
        if (nfvObservability2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("nfvObservability");
            nfvObservability2 = null;
        }
        if (nfvObservability2.isNfvObservabilityEnabled()) {
            NfvObservability nfvObservability4 = nfvObservability;
            if (nfvObservability4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("nfvObservability");
                nfvObservability4 = null;
            }
            HashMap<String, String> baseNfvAttributes = nfvObservability4.getBaseNfvAttributes();
            baseNfvAttributes.put("vendorID", str);
            baseNfvAttributes.put("category_name", str2);
            baseNfvAttributes.put("category_id", str3);
            NfvObservability nfvObservability5 = nfvObservability;
            if (nfvObservability5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("nfvObservability");
            } else {
                nfvObservability3 = nfvObservability5;
            }
            nfvObservability3.sendCustomObservabilityEvent("Empty product list", NFVEventType.DarkstoreEvents.name(), baseNfvAttributes);
        }
    }

    public final void onDarkstoresEmptySearchResults(@NotNull String str, @NotNull String str2) {
        Intrinsics.checkNotNullParameter(str, "vendorId");
        Intrinsics.checkNotNullParameter(str2, "query");
        NfvObservability nfvObservability2 = nfvObservability;
        NfvObservability nfvObservability3 = null;
        if (nfvObservability2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("nfvObservability");
            nfvObservability2 = null;
        }
        if (nfvObservability2.isNfvObservabilityEnabled()) {
            NfvObservability nfvObservability4 = nfvObservability;
            if (nfvObservability4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("nfvObservability");
                nfvObservability4 = null;
            }
            HashMap<String, String> baseNfvAttributes = nfvObservability4.getBaseNfvAttributes();
            baseNfvAttributes.put("vendorID", str);
            baseNfvAttributes.put("search_query", str2);
            NfvObservability nfvObservability5 = nfvObservability;
            if (nfvObservability5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("nfvObservability");
            } else {
                nfvObservability3 = nfvObservability5;
            }
            nfvObservability3.sendCustomObservabilityEvent("EmptySearchResults", NFVEventType.DarkstoreEvents.name(), baseNfvAttributes);
        }
    }

    public final void onDarkstoresEmptySubCategories(@NotNull String str, @NotNull String str2, @NotNull String str3) {
        Intrinsics.checkNotNullParameter(str, "vendorId");
        Intrinsics.checkNotNullParameter(str2, "categoryName");
        Intrinsics.checkNotNullParameter(str3, "categoryId");
        NfvObservability nfvObservability2 = nfvObservability;
        NfvObservability nfvObservability3 = null;
        if (nfvObservability2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("nfvObservability");
            nfvObservability2 = null;
        }
        if (nfvObservability2.isNfvObservabilityEnabled()) {
            NfvObservability nfvObservability4 = nfvObservability;
            if (nfvObservability4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("nfvObservability");
                nfvObservability4 = null;
            }
            HashMap<String, String> baseNfvAttributes = nfvObservability4.getBaseNfvAttributes();
            baseNfvAttributes.put("vendorID", str);
            baseNfvAttributes.put("category_name", str2);
            baseNfvAttributes.put("category_id", str3);
            NfvObservability nfvObservability5 = nfvObservability;
            if (nfvObservability5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("nfvObservability");
            } else {
                nfvObservability3 = nfvObservability5;
            }
            nfvObservability3.sendCustomObservabilityEvent("Empty Subcategories", NFVEventType.DarkstoreEvents.name(), baseNfvAttributes);
        }
    }

    public final void onDarkstoresHeroBannersEmpty(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "vendorId");
        NfvObservability nfvObservability2 = nfvObservability;
        NfvObservability nfvObservability3 = null;
        if (nfvObservability2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("nfvObservability");
            nfvObservability2 = null;
        }
        if (nfvObservability2.isNfvObservabilityEnabled()) {
            NfvObservability nfvObservability4 = nfvObservability;
            if (nfvObservability4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("nfvObservability");
                nfvObservability4 = null;
            }
            HashMap<String, String> baseNfvAttributes = nfvObservability4.getBaseNfvAttributes();
            baseNfvAttributes.put("vendorID", str);
            NfvObservability nfvObservability5 = nfvObservability;
            if (nfvObservability5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("nfvObservability");
            } else {
                nfvObservability3 = nfvObservability5;
            }
            nfvObservability3.sendCustomObservabilityEvent("HeroBannersEmpty", NFVEventType.DarkstoreEvents.name(), baseNfvAttributes);
        }
    }

    public final void onDarkstoresImageLoadError(@NotNull String str, @NotNull String str2, @Nullable Integer num) {
        Intrinsics.checkNotNullParameter(str, ObservableAttributesNames.IMAGE_URL_V2);
        Intrinsics.checkNotNullParameter(str2, "errorMessage");
        NfvObservability nfvObservability2 = nfvObservability;
        NfvObservability nfvObservability3 = null;
        if (nfvObservability2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("nfvObservability");
            nfvObservability2 = null;
        }
        if (nfvObservability2.isNfvObservabilityEnabled()) {
            NfvObservability nfvObservability4 = nfvObservability;
            if (nfvObservability4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("nfvObservability");
                nfvObservability4 = null;
            }
            HashMap<String, String> baseNfvAttributes = nfvObservability4.getBaseNfvAttributes();
            baseNfvAttributes.put("api_response_message", str2);
            baseNfvAttributes.put("image_url", str);
            if (num != null) {
                baseNfvAttributes.put("statusCode", String.valueOf(num.intValue()));
            }
            NfvObservability nfvObservability5 = nfvObservability;
            if (nfvObservability5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("nfvObservability");
            } else {
                nfvObservability3 = nfvObservability5;
            }
            nfvObservability3.sendCustomObservabilityEvent("ImageLoadError", NFVEventType.DarkstoreEvents.name(), baseNfvAttributes);
        }
    }

    public final void onDarkstoresMigratedFalseDjiniValidation(@NotNull String str, @NotNull String str2, @NotNull String str3) {
        Intrinsics.checkNotNullParameter(str, FoodCartFlutterDataSourceImpl.cartIdKey);
        Intrinsics.checkNotNullParameter(str2, "vendorId");
        Intrinsics.checkNotNullParameter(str3, "productId");
        NfvObservability nfvObservability2 = nfvObservability;
        NfvObservability nfvObservability3 = null;
        if (nfvObservability2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("nfvObservability");
            nfvObservability2 = null;
        }
        if (nfvObservability2.isNfvObservabilityEnabled()) {
            NfvObservability nfvObservability4 = nfvObservability;
            if (nfvObservability4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("nfvObservability");
                nfvObservability4 = null;
            }
            HashMap<String, String> baseNfvAttributes = nfvObservability4.getBaseNfvAttributes();
            baseNfvAttributes.put("productID", str3);
            baseNfvAttributes.put("vendorID", str2);
            baseNfvAttributes.put("cartID", str);
            NfvObservability nfvObservability5 = nfvObservability;
            if (nfvObservability5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("nfvObservability");
            } else {
                nfvObservability3 = nfvObservability5;
            }
            nfvObservability3.sendCustomObservabilityEvent("StockValidationMigratedVendors", NFVEventType.DarkstoreEvents.name(), baseNfvAttributes);
        }
    }

    public final void onDarkstoresOutOfStockError(@NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull String str4) {
        Intrinsics.checkNotNullParameter(str, "vendorId");
        Intrinsics.checkNotNullParameter(str2, FoodCartFlutterDataSourceImpl.cartIdKey);
        Intrinsics.checkNotNullParameter(str3, "productId");
        Intrinsics.checkNotNullParameter(str4, "countryCode");
        NfvObservability nfvObservability2 = nfvObservability;
        NfvObservability nfvObservability3 = null;
        if (nfvObservability2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("nfvObservability");
            nfvObservability2 = null;
        }
        if (nfvObservability2.isNfvObservabilityEnabled()) {
            NfvObservability nfvObservability4 = nfvObservability;
            if (nfvObservability4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("nfvObservability");
                nfvObservability4 = null;
            }
            HashMap<String, String> baseNfvAttributes = nfvObservability4.getBaseNfvAttributes();
            baseNfvAttributes.put("vendorID", str);
            baseNfvAttributes.put("cartID", str2);
            baseNfvAttributes.put("productID", str3);
            baseNfvAttributes.put("countryCode", str4);
            baseNfvAttributes.put("api_response_message", "Product is out of stock.");
            NfvObservability nfvObservability5 = nfvObservability;
            if (nfvObservability5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("nfvObservability");
            } else {
                nfvObservability3 = nfvObservability5;
            }
            nfvObservability3.sendCustomObservabilityEvent("OutOfStockError", NFVEventType.DarkstoreEvents.name(), baseNfvAttributes);
        }
    }

    public final void onDarkstoresVendorNotLoaded(@NotNull String str, @NotNull String str2, int i11, @NotNull String str3) {
        Intrinsics.checkNotNullParameter(str, "vendorId");
        Intrinsics.checkNotNullParameter(str2, "talabatCode");
        Intrinsics.checkNotNullParameter(str3, "errorMessage");
        NfvObservability nfvObservability2 = nfvObservability;
        NfvObservability nfvObservability3 = null;
        if (nfvObservability2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("nfvObservability");
            nfvObservability2 = null;
        }
        if (nfvObservability2.isNfvObservabilityEnabled()) {
            NfvObservability nfvObservability4 = nfvObservability;
            if (nfvObservability4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("nfvObservability");
                nfvObservability4 = null;
            }
            HashMap<String, String> baseNfvAttributes = nfvObservability4.getBaseNfvAttributes();
            baseNfvAttributes.put("talabatBranchCode", str2);
            baseNfvAttributes.put("vendorID", str);
            baseNfvAttributes.put("api_response_code", String.valueOf(i11));
            baseNfvAttributes.put("api_response_message", str3);
            NfvObservability nfvObservability5 = nfvObservability;
            if (nfvObservability5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("nfvObservability");
            } else {
                nfvObservability3 = nfvObservability5;
            }
            nfvObservability3.sendCustomObservabilityEvent("VendorNotLoaded", NFVEventType.DarkstoreEvents.name(), baseNfvAttributes);
        }
    }

    public final void onNegativeDeliveryFeeFromVendor() {
        NfvObservability nfvObservability2 = nfvObservability;
        if (nfvObservability2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("nfvObservability");
            nfvObservability2 = null;
        }
        HashMap<String, String> baseNfvAttributes = nfvObservability2.getBaseNfvAttributes();
        baseNfvAttributes.put("message", DELIVERY_FEE_MESSAGE_FOR_VENDOR);
        sendEvent("DeliveryFeeNegativeFromVendor", NFVEventType.DarkstoreEvents.name(), baseNfvAttributes);
    }

    public final void onProductDetailsNotLoaded(@NotNull String str, @NotNull String str2, @NotNull String str3) {
        Intrinsics.checkNotNullParameter(str, "errorMessage");
        Intrinsics.checkNotNullParameter(str2, "productId");
        Intrinsics.checkNotNullParameter(str3, "productSku");
        NfvObservability nfvObservability2 = nfvObservability;
        if (nfvObservability2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("nfvObservability");
            nfvObservability2 = null;
        }
        HashMap<String, String> baseNfvAttributes = nfvObservability2.getBaseNfvAttributes();
        baseNfvAttributes.put("api_response_message", str);
        baseNfvAttributes.put("productID", str2);
        baseNfvAttributes.put("productSku", str3);
        sendEvent(ObservableNfvApiNames.DARKSTORES_PRODUCT_DETAILS_NOT_LOADED, NFVEventType.DarkstoreEvents.name(), baseNfvAttributes);
    }

    public final void onQCommerceImageResponseReceived(@NotNull String str, long j11, long j12, @Nullable String str2, @Nullable String str3) {
        Intrinsics.checkNotNullParameter(str, "url");
        NfvObservability nfvObservability2 = nfvObservability;
        if (nfvObservability2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("nfvObservability");
            nfvObservability2 = null;
        }
        HashMap<String, String> baseNfvAttributes = nfvObservability2.getBaseNfvAttributes();
        baseNfvAttributes.put(ObservableAttributesNames.IMAGE_URL_V2, str);
        baseNfvAttributes.put(ObservableAttributesNames.IMAGE_SIZE, String.valueOf(j12));
        baseNfvAttributes.put("responseTime", String.valueOf(j11));
        if (str2 == null) {
            str2 = "";
        }
        baseNfvAttributes.put(ObservableAttributesNames.IMAGE_CONTENT_TYPE, str2);
        if (str3 == null) {
            str3 = "";
        }
        baseNfvAttributes.put(ObservableAttributesNames.RESPONSE_CACHE_STATUS, str3);
        sendEvent(ObservableNfvApiNames.QCOMMERCE_TIME_TO_LOAD_IMAGE, NFVEventType.MobilePerformanceQC.name(), baseNfvAttributes);
    }

    public final void onStaticLandingConfigurationFailed(@Nullable String str) {
        NfvObservability nfvObservability2 = nfvObservability;
        NfvObservability nfvObservability3 = null;
        if (nfvObservability2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("nfvObservability");
            nfvObservability2 = null;
        }
        if (nfvObservability2.isNfvObservabilityEnabled()) {
            NfvObservability nfvObservability4 = nfvObservability;
            if (nfvObservability4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("nfvObservability");
                nfvObservability4 = null;
            }
            HashMap<String, String> baseNfvAttributes = nfvObservability4.getBaseNfvAttributes();
            if (str != null) {
                baseNfvAttributes.put("message", str);
            }
            NfvObservability nfvObservability5 = nfvObservability;
            if (nfvObservability5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("nfvObservability");
            } else {
                nfvObservability3 = nfvObservability5;
            }
            nfvObservability3.sendCustomObservabilityEvent("StaticLandingParsingError", NFVEventType.DarkstoreEvents.name(), baseNfvAttributes);
        }
    }

    public final void onTMartGrowthGetFailed(int i11, @NotNull String str, @NotNull String str2) {
        Intrinsics.checkNotNullParameter(str, "errorMessage");
        Intrinsics.checkNotNullParameter(str2, "voucherOptionId");
        NfvObservability nfvObservability2 = nfvObservability;
        if (nfvObservability2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("nfvObservability");
            nfvObservability2 = null;
        }
        HashMap<String, String> baseNfvAttributes = nfvObservability2.getBaseNfvAttributes();
        baseNfvAttributes.put("api_response_code", String.valueOf(i11));
        baseNfvAttributes.put("api_response_message", str);
        baseNfvAttributes.put("voucher_option_id", str2);
        sendEvent("TMartGrowthGETFailed", NFVEventType.DarkstoreEvents.name(), baseNfvAttributes);
    }

    public final void onTMartGrowthPostFailed(int i11, @NotNull String str, @NotNull String str2) {
        Intrinsics.checkNotNullParameter(str, "errorMessage");
        Intrinsics.checkNotNullParameter(str2, "voucherOptionId");
        NfvObservability nfvObservability2 = nfvObservability;
        if (nfvObservability2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("nfvObservability");
            nfvObservability2 = null;
        }
        HashMap<String, String> baseNfvAttributes = nfvObservability2.getBaseNfvAttributes();
        baseNfvAttributes.put("api_response_code", String.valueOf(i11));
        baseNfvAttributes.put("api_response_message", str);
        baseNfvAttributes.put("voucher_option_id", str2);
        sendEvent("TMartGrowthPOSTFailed", NFVEventType.DarkstoreEvents.name(), baseNfvAttributes);
    }

    public final void onVerticalLoadedStatus(@NotNull String str, @NotNull String str2, boolean z11, int i11) {
        Intrinsics.checkNotNullParameter(str, "message");
        Intrinsics.checkNotNullParameter(str2, "tile");
        NfvObservability nfvObservability2 = nfvObservability;
        NfvObservability nfvObservability3 = null;
        if (nfvObservability2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("nfvObservability");
            nfvObservability2 = null;
        }
        if (nfvObservability2.isNfvObservabilityEnabled()) {
            NfvObservability nfvObservability4 = nfvObservability;
            if (nfvObservability4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("nfvObservability");
                nfvObservability4 = null;
            }
            HashMap<String, String> baseNfvAttributes = nfvObservability4.getBaseNfvAttributes();
            baseNfvAttributes.put("tile", str2);
            baseNfvAttributes.put("imageLoaded", String.valueOf(z11));
            baseNfvAttributes.put("position", String.valueOf(i11));
            baseNfvAttributes.put("message", str);
            NfvObservability nfvObservability5 = nfvObservability;
            if (nfvObservability5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("nfvObservability");
            } else {
                nfvObservability3 = nfvObservability5;
            }
            nfvObservability3.sendCustomObservabilityEvent("vertical_image_url", NFVEventType.AndroidNFVEvents.name(), baseNfvAttributes);
        }
    }

    public final void onVerticalsFallback(@NotNull String str, boolean z11, int i11) {
        Intrinsics.checkNotNullParameter(str, "message");
        NfvObservability nfvObservability2 = nfvObservability;
        NfvObservability nfvObservability3 = null;
        if (nfvObservability2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("nfvObservability");
            nfvObservability2 = null;
        }
        if (nfvObservability2.isNfvObservabilityEnabled()) {
            NfvObservability nfvObservability4 = nfvObservability;
            if (nfvObservability4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("nfvObservability");
                nfvObservability4 = null;
            }
            HashMap<String, String> baseNfvAttributes = nfvObservability4.getBaseNfvAttributes();
            baseNfvAttributes.put("fallbackState", String.valueOf(z11));
            baseNfvAttributes.put("statusCode", String.valueOf(i11));
            baseNfvAttributes.put("message", str);
            NfvObservability nfvObservability5 = nfvObservability;
            if (nfvObservability5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("nfvObservability");
            } else {
                nfvObservability3 = nfvObservability5;
            }
            nfvObservability3.sendCustomObservabilityEvent("verticals_launcher_fallback", NFVEventType.AndroidNFVEvents.name(), baseNfvAttributes);
        }
    }

    public final void sendNumberOfVerticalsShown(@NotNull String str, int i11) {
        Intrinsics.checkNotNullParameter(str, "message");
        NfvObservability nfvObservability2 = nfvObservability;
        NfvObservability nfvObservability3 = null;
        if (nfvObservability2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("nfvObservability");
            nfvObservability2 = null;
        }
        if (nfvObservability2.isNfvObservabilityEnabled()) {
            NfvObservability nfvObservability4 = nfvObservability;
            if (nfvObservability4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("nfvObservability");
                nfvObservability4 = null;
            }
            HashMap<String, String> baseNfvAttributes = nfvObservability4.getBaseNfvAttributes();
            baseNfvAttributes.put("numberOfTiles", String.valueOf(i11));
            baseNfvAttributes.put("message", str);
            NfvObservability nfvObservability5 = nfvObservability;
            if (nfvObservability5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("nfvObservability");
            } else {
                nfvObservability3 = nfvObservability5;
            }
            nfvObservability3.sendCustomObservabilityEvent("verticals_launcher", NFVEventType.AndroidNFVEvents.name(), baseNfvAttributes);
        }
    }

    public final void initialize(@NotNull ApiContainer apiContainer2, @NotNull NfvObservability nfvObservability2) {
        Intrinsics.checkNotNullParameter(apiContainer2, "apiContainer");
        Intrinsics.checkNotNullParameter(nfvObservability2, "nfvObservability");
        apiContainer = apiContainer2;
        nfvObservability = nfvObservability2;
    }
}
