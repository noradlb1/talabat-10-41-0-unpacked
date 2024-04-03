package com.talabat.core.observabilityNew.domain.performance;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lcom/talabat/core/observabilityNew/domain/performance/TracesCounter;", "", "()V", "BRAND_SCREEN", "", "HOME_SCREEN", "HOME_SCREEN_MAP", "OFFER_SCREEN", "RESTAURANTS", "com_talabat_core_observability_domain_domain"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class TracesCounter {
    @NotNull
    public static final String BRAND_SCREEN = "BandScreen";
    @NotNull
    public static final String HOME_SCREEN = "HomeScreenFlow";
    @NotNull
    public static final String HOME_SCREEN_MAP = "HomeScreenMap";
    @NotNull
    public static final TracesCounter INSTANCE = new TracesCounter();
    @NotNull
    public static final String OFFER_SCREEN = "OfferScreen";
    @NotNull
    public static final String RESTAURANTS = "Restaurants";

    private TracesCounter() {
    }
}
