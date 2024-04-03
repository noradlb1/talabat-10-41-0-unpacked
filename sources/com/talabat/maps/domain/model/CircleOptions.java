package com.talabat.maps.domain.model;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\b\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0003H&J\u0010\u0010\u0004\u001a\u00020\u00002\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0006\u001a\u00020\u00002\u0006\u0010\u0006\u001a\u00020\u0007H&¨\u0006\b"}, d2 = {"Lcom/talabat/maps/domain/model/CircleOptions;", "", "center", "Lcom/talabat/maps/domain/model/LatLng;", "radius", "", "strokeColor", "", "com_talabat_core_maps_domain_domain"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface CircleOptions {
    @NotNull
    CircleOptions center(@NotNull LatLng latLng);

    @NotNull
    CircleOptions radius(double d11);

    @NotNull
    CircleOptions strokeColor(int i11);
}
