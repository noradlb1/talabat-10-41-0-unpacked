package com.talabat.gem.integration;

import com.talabat.gem.IntegrationKt;
import com.talabat.gem.adapters.data.CacheKt;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0003\u001a\u00020\u0004J\u0006\u0010\u0005\u001a\u00020\u0004J\u0010\u0010\u0006\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\b¨\u0006\t"}, d2 = {"Lcom/talabat/gem/integration/GemAnalyticsAccessor;", "", "()V", "onCheckoutLoaded", "", "onMenuLoaded", "onOrderComplete", "transactionId", "", "com_talabat_Components_gem_gem"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class GemAnalyticsAccessor {
    @NotNull
    public static final GemAnalyticsAccessor INSTANCE = new GemAnalyticsAccessor();

    private GemAnalyticsAccessor() {
    }

    public final void onCheckoutLoaded() {
        IntegrationKt.getAnalytics().onGemCheckoutLoaded();
    }

    public final void onMenuLoaded() {
        IntegrationKt.getAnalytics().onGemRestaurantLoaded();
    }

    public final void onOrderComplete(@Nullable String str) {
        CacheKt.setCheckoutTransactionId(str);
        IntegrationKt.getAnalytics().onGemOrderComplete();
    }
}
