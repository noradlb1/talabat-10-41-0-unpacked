package com.talabat.maps.domain.model;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0004H&J\u0012\u0010\u0006\u001a\u00020\u00002\b\u0010\u0007\u001a\u0004\u0018\u00010\bH&J\u0010\u0010\t\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\nH&J\u0010\u0010\u000b\u001a\u00020\u00002\u0006\u0010\u000b\u001a\u00020\u0004H&¨\u0006\f"}, d2 = {"Lcom/talabat/maps/domain/model/MarkerOptions;", "", "anchor", "var1", "", "var2", "icon", "bitmapDescriptor", "Lcom/talabat/maps/domain/model/BitmapDescriptor;", "position", "Lcom/talabat/maps/domain/model/LatLng;", "zIndex", "com_talabat_core_maps_domain_domain"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface MarkerOptions {
    @NotNull
    MarkerOptions anchor(float f11, float f12);

    @NotNull
    MarkerOptions icon(@Nullable BitmapDescriptor bitmapDescriptor);

    @NotNull
    MarkerOptions position(@NotNull LatLng latLng);

    @NotNull
    MarkerOptions zIndex(float f11);
}
