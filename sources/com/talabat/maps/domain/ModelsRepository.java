package com.talabat.maps.domain;

import com.talabat.maps.domain.model.BitmapDescriptorFactory;
import com.talabat.maps.domain.model.CameraPosition;
import com.talabat.maps.domain.model.CircleOptions;
import com.talabat.maps.domain.model.LatLngBounds;
import com.talabat.maps.domain.model.MarkerOptions;
import com.talabat.maps.domain.model.PolygonOptions;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0005H&J\b\u0010\u0006\u001a\u00020\u0007H&J\b\u0010\b\u001a\u00020\tH&J\b\u0010\n\u001a\u00020\u000bH&J\b\u0010\f\u001a\u00020\rH&¨\u0006\u000e"}, d2 = {"Lcom/talabat/maps/domain/ModelsRepository;", "", "bitmapDescriptorFactory", "Lcom/talabat/maps/domain/model/BitmapDescriptorFactory;", "newCameraPositionBuilder", "Lcom/talabat/maps/domain/model/CameraPosition$Builder;", "newCircleOptions", "Lcom/talabat/maps/domain/model/CircleOptions;", "newLatLngBoundsBuilder", "Lcom/talabat/maps/domain/model/LatLngBounds$Builder;", "newMarkerOptions", "Lcom/talabat/maps/domain/model/MarkerOptions;", "newPolygonOptions", "Lcom/talabat/maps/domain/model/PolygonOptions;", "com_talabat_core_maps_domain_domain"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface ModelsRepository {
    @NotNull
    BitmapDescriptorFactory bitmapDescriptorFactory();

    @NotNull
    CameraPosition.Builder newCameraPositionBuilder();

    @NotNull
    CircleOptions newCircleOptions();

    @NotNull
    LatLngBounds.Builder newLatLngBoundsBuilder();

    @NotNull
    MarkerOptions newMarkerOptions();

    @NotNull
    PolygonOptions newPolygonOptions();
}
