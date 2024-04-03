package com.talabat.core.tracking.domain;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0011\u0010\u0000\u001a\u00020\u0001¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"DEFAULT_ANALYTICS_TYPE", "Lcom/talabat/core/tracking/domain/AnalyticsType;", "getDEFAULT_ANALYTICS_TYPE", "()Lcom/talabat/core/tracking/domain/AnalyticsType;", "com_talabat_core_tracking_domain_domain"}, k = 2, mv = {1, 6, 0}, xi = 48)
public final class AnalyticsTypeKt {
    @NotNull
    private static final AnalyticsType DEFAULT_ANALYTICS_TYPE = AnalyticsType.GOOGLE;

    @NotNull
    public static final AnalyticsType getDEFAULT_ANALYTICS_TYPE() {
        return DEFAULT_ANALYTICS_TYPE;
    }
}
