package com.talabat.gem.domain.usecases;

import com.talabat.gem.IntegrationKt;
import com.talabat.gem.domain.entities.GemRestaurant;
import com.talabat.gem.ports.analytics.GemAnalyticsTriggersPort;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u001c\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a\b\u0010\u0002\u001a\u00020\u0003H\u0002\u001a\b\u0010\u0004\u001a\u00020\u0001H\u0002\u001a\f\u0010\u0005\u001a\u00020\u0006*\u00020\u0007H\u0007\u001a\f\u0010\b\u001a\u00020\u0006*\u00020\u0007H\u0007\u001a\f\u0010\t\u001a\u00020\u0006*\u00020\u0007H\u0007\u001a\f\u0010\n\u001a\u00020\u0006*\u00020\u0007H\u0007\"\u000e\u0010\u0000\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"TIMESTAMP_BUFFER_SECONDS", "", "isGemRestaurantSelected", "", "timestampWithBuffer", "bindLastTierReached", "", "Lcom/talabat/gem/ports/analytics/GemAnalyticsTriggersPort;", "bindOffer", "triggerOfferExpired", "triggerTierReached", "com_talabat_Components_gem-core_gem-core"}, k = 2, mv = {1, 6, 0}, xi = 48)
public final class GemAnalyticsTriggersBusinessRulesKt {
    private static final long TIMESTAMP_BUFFER_SECONDS = 20;

    @BusinessRules
    public static final void bindLastTierReached(@NotNull GemAnalyticsTriggersPort gemAnalyticsTriggersPort) {
        Intrinsics.checkNotNullParameter(gemAnalyticsTriggersPort, "<this>");
        gemAnalyticsTriggersPort.autoDispose(new GemAnalyticsTriggersBusinessRulesKt$bindLastTierReached$1(gemAnalyticsTriggersPort));
    }

    @BusinessRules
    public static final void bindOffer(@NotNull GemAnalyticsTriggersPort gemAnalyticsTriggersPort) {
        Intrinsics.checkNotNullParameter(gemAnalyticsTriggersPort, "<this>");
        gemAnalyticsTriggersPort.autoDispose(new GemAnalyticsTriggersBusinessRulesKt$bindOffer$1(gemAnalyticsTriggersPort));
    }

    /* access modifiers changed from: private */
    public static final boolean isGemRestaurantSelected() {
        GemRestaurant loadSelectedGemRestaurant = IntegrationKt.getDataSources().loadSelectedGemRestaurant();
        return loadSelectedGemRestaurant != null && !Intrinsics.areEqual((Object) loadSelectedGemRestaurant, (Object) BusinessRulesKt.getNullGemRestaurant());
    }

    /* access modifiers changed from: private */
    public static final long timestampWithBuffer() {
        return System.currentTimeMillis() + TimeUnit.SECONDS.toMillis(20);
    }

    @BusinessRules
    public static final void triggerOfferExpired(@NotNull GemAnalyticsTriggersPort gemAnalyticsTriggersPort) {
        Intrinsics.checkNotNullParameter(gemAnalyticsTriggersPort, "<this>");
        gemAnalyticsTriggersPort.autoDispose(new GemAnalyticsTriggersBusinessRulesKt$triggerOfferExpired$1(gemAnalyticsTriggersPort));
    }

    @BusinessRules
    public static final void triggerTierReached(@NotNull GemAnalyticsTriggersPort gemAnalyticsTriggersPort) {
        Intrinsics.checkNotNullParameter(gemAnalyticsTriggersPort, "<this>");
        gemAnalyticsTriggersPort.autoDispose(new GemAnalyticsTriggersBusinessRulesKt$triggerTierReached$1(gemAnalyticsTriggersPort));
    }
}
