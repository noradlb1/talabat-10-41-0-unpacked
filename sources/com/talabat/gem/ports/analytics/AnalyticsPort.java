package com.talabat.gem.ports.analytics;

import com.talabat.feature.pickup.data.events.ShopListUpdatedEvent;
import com.talabat.gem.IntegrationKt;
import com.talabat.gem.adapters.analytics.GemFloatingShownEvent;
import com.talabat.gem.adapters.analytics.GemFlutterHomeEvent;
import com.talabat.gem.adapters.analytics.GemLightboxShownEvent;
import com.talabat.gem.adapters.analytics.GemSyncOffersEvent;
import com.talabat.gem.domain.entities.GemRestaurant;
import datamodels.ImpressionProperties;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\r\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010$\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J<\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00052\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0005H\u0016Jq\u0010\f\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00052\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u000e2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u000e2\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0005H\u0016¢\u0006\u0002\u0010\u0012J\b\u0010\u0013\u001a\u00020\u0003H\u0016J\u001c\u0010\u0014\u001a\u00020\u00032\b\u0010\u0015\u001a\u0004\u0018\u00010\u00052\b\u0010\u0016\u001a\u0004\u0018\u00010\u0005H\u0016J\b\u0010\u0017\u001a\u00020\u0003H\u0016J\b\u0010\u0018\u001a\u00020\u0003H\u0016J\b\u0010\u0019\u001a\u00020\u0003H\u0016J*\u0010\u001a\u001a\u00020\u00032\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u001d0\u001c2\b\u0010\u001e\u001a\u0004\u0018\u00010\u00052\b\u0010\u001f\u001a\u0004\u0018\u00010\u0005H\u0016J\b\u0010 \u001a\u00020\u0003H\u0016J\b\u0010!\u001a\u00020\u0003H\u0016J\b\u0010\"\u001a\u00020\u0003H\u0016J\b\u0010#\u001a\u00020\u0003H\u0016J\b\u0010$\u001a\u00020\u0003H\u0016J\u001c\u0010%\u001a\u00020\u00032\u0006\u0010&\u001a\u00020'2\n\b\u0002\u0010(\u001a\u0004\u0018\u00010\u0005H\u0016JF\u0010)\u001a\u00020\u00032\n\b\u0002\u0010*\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00052\u0018\b\u0002\u0010+\u001a\u0012\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010,2\n\b\u0002\u0010-\u001a\u0004\u0018\u00010\u0005H\u0016¨\u0006."}, d2 = {"Lcom/talabat/gem/ports/analytics/AnalyticsPort;", "", "observeGemSyncOffers", "", "errorMessage", "", "onGemApiCallRequest", "apiRequestUrl", "status", "offerId", "reservationCode", "source", "onGemApiCallResponse", "offerCount", "", "tierCount", "responseCode", "message", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;)V", "onGemCheckoutLoaded", "onGemCollectionRestaurantLoaded", "swimlaneTitle", "shopListTrigger", "onGemExpired", "onGemFloatingViewShown", "onGemHomeSwimlaneShown", "onGemJokerImpressionTriggered", "scrollingList", "", "Ldatamodels/ImpressionProperties;", "screenName", "screenType", "onGemOfferDetailsShown", "onGemOfferRejected", "onGemOrderComplete", "onGemRestaurantLoaded", "onGemTierReached", "onShopClicked", "gemRestaurant", "Lcom/talabat/gem/domain/entities/GemRestaurant;", "channel", "trackGemFlutterHomeData", "info", "gemHomeData", "", "noDataReason", "com_talabat_Components_gem-core_gem-core"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface AnalyticsPort {

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    public static final class DefaultImpls {
        public static void observeGemSyncOffers(@NotNull AnalyticsPort analyticsPort, @NotNull String str) {
            Intrinsics.checkNotNullParameter(str, "errorMessage");
            IntegrationKt.getLogger().logMessage("AnalyticsPort", GemSyncOffersEvent.EVENT_NAME);
        }

        public static void onGemApiCallRequest(@NotNull AnalyticsPort analyticsPort, @NotNull String str, @NotNull String str2, @Nullable String str3, @Nullable String str4, @Nullable String str5) {
            Intrinsics.checkNotNullParameter(str, "apiRequestUrl");
            Intrinsics.checkNotNullParameter(str2, "status");
            IntegrationKt.getLogger().logMessage("AnalyticsPort", "gem_api_call request");
        }

        public static /* synthetic */ void onGemApiCallRequest$default(AnalyticsPort analyticsPort, String str, String str2, String str3, String str4, String str5, int i11, Object obj) {
            if (obj == null) {
                analyticsPort.onGemApiCallRequest(str, str2, (i11 & 4) != 0 ? null : str3, (i11 & 8) != 0 ? null : str4, (i11 & 16) != 0 ? null : str5);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: onGemApiCallRequest");
        }

        public static void onGemApiCallResponse(@NotNull AnalyticsPort analyticsPort, @NotNull String str, @NotNull String str2, @Nullable String str3, @Nullable String str4, @Nullable Integer num, @Nullable Integer num2, @Nullable Integer num3, @Nullable String str5, @Nullable String str6) {
            Intrinsics.checkNotNullParameter(str, "apiRequestUrl");
            Intrinsics.checkNotNullParameter(str2, "status");
            IntegrationKt.getLogger().logMessage("AnalyticsPort", "gem_api_call response");
        }

        public static /* synthetic */ void onGemApiCallResponse$default(AnalyticsPort analyticsPort, String str, String str2, String str3, String str4, Integer num, Integer num2, Integer num3, String str5, String str6, int i11, Object obj) {
            int i12 = i11;
            if (obj == null) {
                analyticsPort.onGemApiCallResponse(str, str2, (i12 & 4) != 0 ? null : str3, (i12 & 8) != 0 ? null : str4, (i12 & 16) != 0 ? null : num, (i12 & 32) != 0 ? null : num2, (i12 & 64) != 0 ? null : num3, (i12 & 128) != 0 ? null : str5, (i12 & 256) != 0 ? null : str6);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: onGemApiCallResponse");
        }

        public static void onGemCheckoutLoaded(@NotNull AnalyticsPort analyticsPort) {
            IntegrationKt.getLogger().logMessage("AnalyticsPort", "joker_checkout_loaded");
        }

        public static void onGemCollectionRestaurantLoaded(@NotNull AnalyticsPort analyticsPort, @Nullable String str, @Nullable String str2) {
            IntegrationKt.getLogger().logMessage("AnalyticsPort", ShopListUpdatedEvent.EVENT_NAME);
        }

        public static void onGemExpired(@NotNull AnalyticsPort analyticsPort) {
            IntegrationKt.getLogger().logMessage("AnalyticsPort", "joker_timeout");
        }

        public static void onGemFloatingViewShown(@NotNull AnalyticsPort analyticsPort) {
            IntegrationKt.getLogger().logMessage("AnalyticsPort", GemFloatingShownEvent.EVENT_NAME);
        }

        public static void onGemHomeSwimlaneShown(@NotNull AnalyticsPort analyticsPort) {
            IntegrationKt.getLogger().logMessage("AnalyticsPort", "onGemHomeSwimlaneShown()");
            IntegrationKt.getLogger().logMessage("AnalyticsPort", GemLightboxShownEvent.EVENT_NAME);
        }

        public static void onGemJokerImpressionTriggered(@NotNull AnalyticsPort analyticsPort, @NotNull List<ImpressionProperties> list, @Nullable String str, @Nullable String str2) {
            Intrinsics.checkNotNullParameter(list, "scrollingList");
            IntegrationKt.getLogger().logMessage("AnalyticsPort", "joker_lightbox_expanded");
        }

        public static void onGemOfferDetailsShown(@NotNull AnalyticsPort analyticsPort) {
            IntegrationKt.getLogger().logMessage("AnalyticsPort", "onGemOfferDetailsShown()");
            IntegrationKt.getLogger().logMessage("AnalyticsPort", GemLightboxShownEvent.EVENT_NAME);
        }

        public static void onGemOfferRejected(@NotNull AnalyticsPort analyticsPort) {
            IntegrationKt.getLogger().logMessage("AnalyticsPort", "joker_lightbox_rejected");
        }

        public static void onGemOrderComplete(@NotNull AnalyticsPort analyticsPort) {
            IntegrationKt.getLogger().logMessage("AnalyticsPort", "joker_order_complete");
        }

        public static void onGemRestaurantLoaded(@NotNull AnalyticsPort analyticsPort) {
            IntegrationKt.getLogger().logMessage("AnalyticsPort", "joker_shop_loaded");
        }

        public static void onGemTierReached(@NotNull AnalyticsPort analyticsPort) {
            IntegrationKt.getLogger().logMessage("AnalyticsPort", "joker_tier_reached");
        }

        public static void onShopClicked(@NotNull AnalyticsPort analyticsPort, @NotNull GemRestaurant gemRestaurant, @Nullable String str) {
            Intrinsics.checkNotNullParameter(gemRestaurant, "gemRestaurant");
            IntegrationKt.getLogger().logMessage("AnalyticsPort", "shop_clicked");
        }

        public static /* synthetic */ void onShopClicked$default(AnalyticsPort analyticsPort, GemRestaurant gemRestaurant, String str, int i11, Object obj) {
            if (obj == null) {
                if ((i11 & 2) != 0) {
                    str = null;
                }
                analyticsPort.onShopClicked(gemRestaurant, str);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: onShopClicked");
        }

        public static void trackGemFlutterHomeData(@NotNull AnalyticsPort analyticsPort, @Nullable String str, @Nullable String str2, @Nullable Map<String, ? extends Object> map, @Nullable String str3) {
            IntegrationKt.getLogger().logMessage("AnalyticsPort", GemFlutterHomeEvent.EVENT_NAME);
        }

        public static /* synthetic */ void trackGemFlutterHomeData$default(AnalyticsPort analyticsPort, String str, String str2, Map map, String str3, int i11, Object obj) {
            if (obj == null) {
                if ((i11 & 1) != 0) {
                    str = null;
                }
                if ((i11 & 2) != 0) {
                    str2 = null;
                }
                if ((i11 & 4) != 0) {
                    map = null;
                }
                if ((i11 & 8) != 0) {
                    str3 = null;
                }
                analyticsPort.trackGemFlutterHomeData(str, str2, map, str3);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: trackGemFlutterHomeData");
        }
    }

    void observeGemSyncOffers(@NotNull String str);

    void onGemApiCallRequest(@NotNull String str, @NotNull String str2, @Nullable String str3, @Nullable String str4, @Nullable String str5);

    void onGemApiCallResponse(@NotNull String str, @NotNull String str2, @Nullable String str3, @Nullable String str4, @Nullable Integer num, @Nullable Integer num2, @Nullable Integer num3, @Nullable String str5, @Nullable String str6);

    void onGemCheckoutLoaded();

    void onGemCollectionRestaurantLoaded(@Nullable String str, @Nullable String str2);

    void onGemExpired();

    void onGemFloatingViewShown();

    void onGemHomeSwimlaneShown();

    void onGemJokerImpressionTriggered(@NotNull List<ImpressionProperties> list, @Nullable String str, @Nullable String str2);

    void onGemOfferDetailsShown();

    void onGemOfferRejected();

    void onGemOrderComplete();

    void onGemRestaurantLoaded();

    void onGemTierReached();

    void onShopClicked(@NotNull GemRestaurant gemRestaurant, @Nullable String str);

    void trackGemFlutterHomeData(@Nullable String str, @Nullable String str2, @Nullable Map<String, ? extends Object> map, @Nullable String str3);
}
