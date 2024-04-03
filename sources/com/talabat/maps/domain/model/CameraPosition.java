package com.talabat.maps.domain.model;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\bf\u0018\u00002\u00020\u0001:\u0001\u000eR\u0012\u0010\u0002\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u0012\u0010\u0006\u001a\u00020\u0007X¦\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\tR\u0012\u0010\n\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\u0005R\u0012\u0010\f\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\u0005¨\u0006\u000f"}, d2 = {"Lcom/talabat/maps/domain/model/CameraPosition;", "", "bearing", "", "getBearing", "()F", "target", "Lcom/talabat/maps/domain/model/LatLng;", "getTarget", "()Lcom/talabat/maps/domain/model/LatLng;", "tilt", "getTilt", "zoom", "getZoom", "Builder", "com_talabat_core_maps_domain_domain"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface CameraPosition {

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0004H&J\b\u0010\u0005\u001a\u00020\u0006H&J\u0010\u0010\u0007\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\bH&J\u0010\u0010\t\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0004H&J\u0010\u0010\n\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0004H&¨\u0006\u000b"}, d2 = {"Lcom/talabat/maps/domain/model/CameraPosition$Builder;", "", "bearing", "var1", "", "build", "Lcom/talabat/maps/domain/model/CameraPosition;", "target", "Lcom/talabat/maps/domain/model/LatLng;", "tilt", "zoom", "com_talabat_core_maps_domain_domain"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public interface Builder {
        @NotNull
        Builder bearing(float f11);

        @NotNull
        CameraPosition build();

        @NotNull
        Builder target(@NotNull LatLng latLng);

        @NotNull
        Builder tilt(float f11);

        @NotNull
        Builder zoom(float f11);
    }

    float getBearing();

    @NotNull
    LatLng getTarget();

    float getTilt();

    float getZoom();
}
