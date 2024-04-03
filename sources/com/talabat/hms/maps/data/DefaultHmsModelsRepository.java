package com.talabat.hms.maps.data;

import com.talabat.hms.maps.data.model.HmsCameraPositionBuilder;
import com.talabat.hms.maps.data.model.HmsCircleOptionsWrapper;
import com.talabat.hms.maps.data.model.HmsLatLngBoundsBuilder;
import com.talabat.hms.maps.data.model.HmsMarkerOptionsWrapper;
import com.talabat.hms.maps.data.model.HmsPolygonOptionsWrapper;
import com.talabat.hms.maps.domain.HmsModelsRepository;
import com.talabat.maps.domain.model.BitmapDescriptorFactory;
import com.talabat.maps.domain.model.CircleOptions;
import com.talabat.maps.domain.model.LatLngBounds;
import com.talabat.maps.domain.model.MarkerOptions;
import com.talabat.maps.domain.model.PolygonOptions;
import javax.inject.Inject;
import javax.inject.Provider;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001BU\b\u0007\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00060\u0003\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\b0\u0003\u0012\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\n0\u0003\u0012\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\f0\u0003\u0012\u0006\u0010\r\u001a\u00020\u000e¢\u0006\u0002\u0010\u000fJ\b\u0010\r\u001a\u00020\u000eH\u0016J\b\u0010\u0010\u001a\u00020\u0004H\u0016J\b\u0010\u0011\u001a\u00020\u0012H\u0016J\b\u0010\u0013\u001a\u00020\u0014H\u0016J\b\u0010\u0015\u001a\u00020\u0016H\u0016J\b\u0010\u0017\u001a\u00020\u0018H\u0016R\u000e\u0010\r\u001a\u00020\u000eX\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\b\u0012\u0004\u0012\u00020\n0\u0003X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00060\u0003X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\f0\u0003X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\b0\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0019"}, d2 = {"Lcom/talabat/hms/maps/data/DefaultHmsModelsRepository;", "Lcom/talabat/hms/maps/domain/HmsModelsRepository;", "cameraPositionBuilder", "Ljavax/inject/Provider;", "Lcom/talabat/hms/maps/data/model/HmsCameraPositionBuilder;", "latLngBoundsBuilder", "Lcom/talabat/hms/maps/data/model/HmsLatLngBoundsBuilder;", "polygonOptions", "Lcom/talabat/hms/maps/data/model/HmsPolygonOptionsWrapper;", "circleOptions", "Lcom/talabat/hms/maps/data/model/HmsCircleOptionsWrapper;", "markerOptions", "Lcom/talabat/hms/maps/data/model/HmsMarkerOptionsWrapper;", "bitmapDescriptorFactory", "Lcom/talabat/maps/domain/model/BitmapDescriptorFactory;", "(Ljavax/inject/Provider;Ljavax/inject/Provider;Ljavax/inject/Provider;Ljavax/inject/Provider;Ljavax/inject/Provider;Lcom/talabat/maps/domain/model/BitmapDescriptorFactory;)V", "newCameraPositionBuilder", "newCircleOptions", "Lcom/talabat/maps/domain/model/CircleOptions;", "newLatLngBoundsBuilder", "Lcom/talabat/maps/domain/model/LatLngBounds$Builder;", "newMarkerOptions", "Lcom/talabat/maps/domain/model/MarkerOptions;", "newPolygonOptions", "Lcom/talabat/maps/domain/model/PolygonOptions;", "com_talabat_core_hms_maps_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class DefaultHmsModelsRepository implements HmsModelsRepository {
    @NotNull
    private final BitmapDescriptorFactory bitmapDescriptorFactory;
    @NotNull
    private final Provider<HmsCameraPositionBuilder> cameraPositionBuilder;
    @NotNull
    private final Provider<HmsCircleOptionsWrapper> circleOptions;
    @NotNull
    private final Provider<HmsLatLngBoundsBuilder> latLngBoundsBuilder;
    @NotNull
    private final Provider<HmsMarkerOptionsWrapper> markerOptions;
    @NotNull
    private final Provider<HmsPolygonOptionsWrapper> polygonOptions;

    @Inject
    public DefaultHmsModelsRepository(@NotNull Provider<HmsCameraPositionBuilder> provider, @NotNull Provider<HmsLatLngBoundsBuilder> provider2, @NotNull Provider<HmsPolygonOptionsWrapper> provider3, @NotNull Provider<HmsCircleOptionsWrapper> provider4, @NotNull Provider<HmsMarkerOptionsWrapper> provider5, @NotNull BitmapDescriptorFactory bitmapDescriptorFactory2) {
        Intrinsics.checkNotNullParameter(provider, "cameraPositionBuilder");
        Intrinsics.checkNotNullParameter(provider2, "latLngBoundsBuilder");
        Intrinsics.checkNotNullParameter(provider3, "polygonOptions");
        Intrinsics.checkNotNullParameter(provider4, "circleOptions");
        Intrinsics.checkNotNullParameter(provider5, "markerOptions");
        Intrinsics.checkNotNullParameter(bitmapDescriptorFactory2, "bitmapDescriptorFactory");
        this.cameraPositionBuilder = provider;
        this.latLngBoundsBuilder = provider2;
        this.polygonOptions = provider3;
        this.circleOptions = provider4;
        this.markerOptions = provider5;
        this.bitmapDescriptorFactory = bitmapDescriptorFactory2;
    }

    @NotNull
    public BitmapDescriptorFactory bitmapDescriptorFactory() {
        return this.bitmapDescriptorFactory;
    }

    @NotNull
    public CircleOptions newCircleOptions() {
        HmsCircleOptionsWrapper hmsCircleOptionsWrapper = this.circleOptions.get();
        Intrinsics.checkNotNullExpressionValue(hmsCircleOptionsWrapper, "circleOptions.get()");
        return hmsCircleOptionsWrapper;
    }

    @NotNull
    public LatLngBounds.Builder newLatLngBoundsBuilder() {
        HmsLatLngBoundsBuilder hmsLatLngBoundsBuilder = this.latLngBoundsBuilder.get();
        Intrinsics.checkNotNullExpressionValue(hmsLatLngBoundsBuilder, "latLngBoundsBuilder.get()");
        return hmsLatLngBoundsBuilder;
    }

    @NotNull
    public MarkerOptions newMarkerOptions() {
        HmsMarkerOptionsWrapper hmsMarkerOptionsWrapper = this.markerOptions.get();
        Intrinsics.checkNotNullExpressionValue(hmsMarkerOptionsWrapper, "markerOptions.get()");
        return hmsMarkerOptionsWrapper;
    }

    @NotNull
    public PolygonOptions newPolygonOptions() {
        HmsPolygonOptionsWrapper hmsPolygonOptionsWrapper = this.polygonOptions.get();
        Intrinsics.checkNotNullExpressionValue(hmsPolygonOptionsWrapper, "polygonOptions.get()");
        return hmsPolygonOptionsWrapper;
    }

    @NotNull
    public HmsCameraPositionBuilder newCameraPositionBuilder() {
        HmsCameraPositionBuilder hmsCameraPositionBuilder = this.cameraPositionBuilder.get();
        Intrinsics.checkNotNullExpressionValue(hmsCameraPositionBuilder, "cameraPositionBuilder.get()");
        return hmsCameraPositionBuilder;
    }
}
