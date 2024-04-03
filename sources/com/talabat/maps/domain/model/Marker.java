package com.talabat.maps.domain.model;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\b\u001a\u00020\tH&R\u0018\u0010\u0002\u001a\u00020\u0003X¦\u000e¢\u0006\f\u001a\u0004\b\u0004\u0010\u0005\"\u0004\b\u0006\u0010\u0007¨\u0006\n"}, d2 = {"Lcom/talabat/maps/domain/model/Marker;", "", "position", "Lcom/talabat/maps/domain/model/LatLng;", "getPosition", "()Lcom/talabat/maps/domain/model/LatLng;", "setPosition", "(Lcom/talabat/maps/domain/model/LatLng;)V", "remove", "", "com_talabat_core_maps_domain_domain"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface Marker {
    @NotNull
    LatLng getPosition();

    void remove();

    void setPosition(@NotNull LatLng latLng);
}
