package com.talabat.domain.location;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0006\n\u0002\b\u0002\u001a\u0015\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002H\u0004¨\u0006\u0004"}, d2 = {"geo", "Lcom/talabat/domain/location/GeoCoordinate;", "", "longitude", "com_talabat_domain_location_location"}, k = 2, mv = {1, 6, 0}, xi = 48)
public final class GeoCoordinateKt {
    @NotNull
    public static final GeoCoordinate geo(double d11, double d12) {
        return new GeoCoordinate(d11, d12);
    }
}
