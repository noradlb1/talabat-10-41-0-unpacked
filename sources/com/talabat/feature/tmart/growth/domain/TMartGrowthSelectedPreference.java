package com.talabat.feature.tmart.growth.domain;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/talabat/feature/tmart/growth/domain/TMartGrowthSelectedPreference;", "", "trackingEventName", "", "(Ljava/lang/String;ILjava/lang/String;)V", "getTrackingEventName", "()Ljava/lang/String;", "SAVE_FOR_LATER", "SHOP_NOW", "com_talabat_feature_tmartGrowth_domain_domain"}, k = 1, mv = {1, 6, 0}, xi = 48)
public enum TMartGrowthSelectedPreference {
    SAVE_FOR_LATER("save for later"),
    SHOP_NOW("shop now");
    
    @NotNull
    private final String trackingEventName;

    private TMartGrowthSelectedPreference(String str) {
        this.trackingEventName = str;
    }

    @NotNull
    public final String getTrackingEventName() {
        return this.trackingEventName;
    }
}
