package com.talabat.feature.pickup.data;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\"\u000e\u0010\u0000\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0005\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"PICKUP_API_COUNTRY_CODE_PATH", "", "PICKUP_API_URL", "PICKUP_API_VERSION", "", "PICKUP_API_VERSION_PATH", "PICKUP_RADIUS", "com_talabat_feature_pickup_data_data"}, k = 2, mv = {1, 6, 0}, xi = 48)
public final class PickupApiKt {
    @NotNull
    private static final String PICKUP_API_COUNTRY_CODE_PATH = "country_code";
    @NotNull
    public static final String PICKUP_API_URL = "/pickup/v{version}/{country_code}/vendors";
    public static final int PICKUP_API_VERSION = 1;
    @NotNull
    private static final String PICKUP_API_VERSION_PATH = "version";
    public static final int PICKUP_RADIUS = 10;
}
