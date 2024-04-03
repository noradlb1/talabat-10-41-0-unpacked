package com.talabat.maps.domain;

import com.talabat.maps.domain.model.LatLng;
import com.talabat.maps.domain.model.LatLngBounds;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H&J\u0018\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u0003H&¨\u0006\u000b"}, d2 = {"Lcom/talabat/maps/domain/LatLngFactory;", "", "createLatLng", "Lcom/talabat/maps/domain/model/LatLng;", "lat", "", "lng", "createLatLngBounds", "Lcom/talabat/maps/domain/model/LatLngBounds;", "southwest", "northeast", "com_talabat_core_maps_domain_domain"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface LatLngFactory {
    @NotNull
    LatLng createLatLng(double d11, double d12);

    @NotNull
    LatLngBounds createLatLngBounds(@NotNull LatLng latLng, @NotNull LatLng latLng2);
}
