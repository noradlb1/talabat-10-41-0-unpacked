package com.talabat.gem;

import com.talabat.gem.domain.entities.GemRestaurant;
import com.talabat.gem.ports.analytics.AnalyticsPort;
import datamodels.ImpressionProperties;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"com/talabat/gem/IntegrationKt$Analytics$1", "Lcom/talabat/gem/ports/analytics/AnalyticsPort;", "com_talabat_Components_gem-core_gem-core"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class IntegrationKt$Analytics$1 implements AnalyticsPort {
    public void observeGemSyncOffers(@NotNull String str) {
        AnalyticsPort.DefaultImpls.observeGemSyncOffers(this, str);
    }

    public void onGemApiCallRequest(@NotNull String str, @NotNull String str2, @Nullable String str3, @Nullable String str4, @Nullable String str5) {
        AnalyticsPort.DefaultImpls.onGemApiCallRequest(this, str, str2, str3, str4, str5);
    }

    public void onGemApiCallResponse(@NotNull String str, @NotNull String str2, @Nullable String str3, @Nullable String str4, @Nullable Integer num, @Nullable Integer num2, @Nullable Integer num3, @Nullable String str5, @Nullable String str6) {
        AnalyticsPort.DefaultImpls.onGemApiCallResponse(this, str, str2, str3, str4, num, num2, num3, str5, str6);
    }

    public void onGemCheckoutLoaded() {
        AnalyticsPort.DefaultImpls.onGemCheckoutLoaded(this);
    }

    public void onGemCollectionRestaurantLoaded(@Nullable String str, @Nullable String str2) {
        AnalyticsPort.DefaultImpls.onGemCollectionRestaurantLoaded(this, str, str2);
    }

    public void onGemExpired() {
        AnalyticsPort.DefaultImpls.onGemExpired(this);
    }

    public void onGemFloatingViewShown() {
        AnalyticsPort.DefaultImpls.onGemFloatingViewShown(this);
    }

    public void onGemHomeSwimlaneShown() {
        AnalyticsPort.DefaultImpls.onGemHomeSwimlaneShown(this);
    }

    public void onGemJokerImpressionTriggered(@NotNull List<ImpressionProperties> list, @Nullable String str, @Nullable String str2) {
        AnalyticsPort.DefaultImpls.onGemJokerImpressionTriggered(this, list, str, str2);
    }

    public void onGemOfferDetailsShown() {
        AnalyticsPort.DefaultImpls.onGemOfferDetailsShown(this);
    }

    public void onGemOfferRejected() {
        AnalyticsPort.DefaultImpls.onGemOfferRejected(this);
    }

    public void onGemOrderComplete() {
        AnalyticsPort.DefaultImpls.onGemOrderComplete(this);
    }

    public void onGemRestaurantLoaded() {
        AnalyticsPort.DefaultImpls.onGemRestaurantLoaded(this);
    }

    public void onGemTierReached() {
        AnalyticsPort.DefaultImpls.onGemTierReached(this);
    }

    public void onShopClicked(@NotNull GemRestaurant gemRestaurant, @Nullable String str) {
        AnalyticsPort.DefaultImpls.onShopClicked(this, gemRestaurant, str);
    }

    public void trackGemFlutterHomeData(@Nullable String str, @Nullable String str2, @Nullable Map<String, ? extends Object> map, @Nullable String str3) {
        AnalyticsPort.DefaultImpls.trackGemFlutterHomeData(this, str, str2, map, str3);
    }
}
