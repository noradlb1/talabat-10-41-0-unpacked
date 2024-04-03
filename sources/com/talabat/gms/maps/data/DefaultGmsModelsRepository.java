package com.talabat.gms.maps.data;

import com.talabat.gms.maps.data.model.GmsBitmapDescriptorFactory;
import com.talabat.gms.maps.data.model.GmsCameraPositionBuilder;
import com.talabat.gms.maps.data.model.GmsCircleOptionsWrapper;
import com.talabat.gms.maps.data.model.GmsLatLngBoundsBuilder;
import com.talabat.gms.maps.data.model.GmsMarkerOptionsWrapper;
import com.talabat.gms.maps.data.model.GmsPolygonOptionsWrapper;
import com.talabat.gms.maps.domain.GmsModelsRepository;
import com.talabat.maps.domain.model.CircleOptions;
import com.talabat.maps.domain.model.LatLngBounds;
import com.talabat.maps.domain.model.MarkerOptions;
import com.talabat.maps.domain.model.PolygonOptions;
import javax.inject.Inject;
import javax.inject.Provider;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001BU\b\u0007\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00060\u0003\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\b0\u0003\u0012\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\n0\u0003\u0012\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\f0\u0003\u0012\u0006\u0010\r\u001a\u00020\u000e¢\u0006\u0002\u0010\u000fJ\b\u0010\r\u001a\u00020\u000eH\u0016J\b\u0010\u0010\u001a\u00020\u0004H\u0016J\b\u0010\u0011\u001a\u00020\u0012H\u0016J\b\u0010\u0013\u001a\u00020\u0014H\u0016J\b\u0010\u0015\u001a\u00020\u0016H\u0016J\b\u0010\u0017\u001a\u00020\u0018H\u0016R\u000e\u0010\r\u001a\u00020\u000eX\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\b\u0012\u0004\u0012\u00020\n0\u0003X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00060\u0003X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\f0\u0003X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\b0\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0019"}, d2 = {"Lcom/talabat/gms/maps/data/DefaultGmsModelsRepository;", "Lcom/talabat/gms/maps/domain/GmsModelsRepository;", "cameraPositionBuilder", "Ljavax/inject/Provider;", "Lcom/talabat/gms/maps/data/model/GmsCameraPositionBuilder;", "latLngBoundsBuilder", "Lcom/talabat/gms/maps/data/model/GmsLatLngBoundsBuilder;", "polygonOptions", "Lcom/talabat/gms/maps/data/model/GmsPolygonOptionsWrapper;", "circleOptions", "Lcom/talabat/gms/maps/data/model/GmsCircleOptionsWrapper;", "markerOptions", "Lcom/talabat/gms/maps/data/model/GmsMarkerOptionsWrapper;", "bitmapDescriptorFactory", "Lcom/talabat/gms/maps/data/model/GmsBitmapDescriptorFactory;", "(Ljavax/inject/Provider;Ljavax/inject/Provider;Ljavax/inject/Provider;Ljavax/inject/Provider;Ljavax/inject/Provider;Lcom/talabat/gms/maps/data/model/GmsBitmapDescriptorFactory;)V", "newCameraPositionBuilder", "newCircleOptions", "Lcom/talabat/maps/domain/model/CircleOptions;", "newLatLngBoundsBuilder", "Lcom/talabat/maps/domain/model/LatLngBounds$Builder;", "newMarkerOptions", "Lcom/talabat/maps/domain/model/MarkerOptions;", "newPolygonOptions", "Lcom/talabat/maps/domain/model/PolygonOptions;", "com_talabat_core_gms_maps_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class DefaultGmsModelsRepository implements GmsModelsRepository {
    @NotNull
    private final GmsBitmapDescriptorFactory bitmapDescriptorFactory;
    @NotNull
    private final Provider<GmsCameraPositionBuilder> cameraPositionBuilder;
    @NotNull
    private final Provider<GmsCircleOptionsWrapper> circleOptions;
    @NotNull
    private final Provider<GmsLatLngBoundsBuilder> latLngBoundsBuilder;
    @NotNull
    private final Provider<GmsMarkerOptionsWrapper> markerOptions;
    @NotNull
    private final Provider<GmsPolygonOptionsWrapper> polygonOptions;

    @Inject
    public DefaultGmsModelsRepository(@NotNull Provider<GmsCameraPositionBuilder> provider, @NotNull Provider<GmsLatLngBoundsBuilder> provider2, @NotNull Provider<GmsPolygonOptionsWrapper> provider3, @NotNull Provider<GmsCircleOptionsWrapper> provider4, @NotNull Provider<GmsMarkerOptionsWrapper> provider5, @NotNull GmsBitmapDescriptorFactory gmsBitmapDescriptorFactory) {
        Intrinsics.checkNotNullParameter(provider, "cameraPositionBuilder");
        Intrinsics.checkNotNullParameter(provider2, "latLngBoundsBuilder");
        Intrinsics.checkNotNullParameter(provider3, "polygonOptions");
        Intrinsics.checkNotNullParameter(provider4, "circleOptions");
        Intrinsics.checkNotNullParameter(provider5, "markerOptions");
        Intrinsics.checkNotNullParameter(gmsBitmapDescriptorFactory, "bitmapDescriptorFactory");
        this.cameraPositionBuilder = provider;
        this.latLngBoundsBuilder = provider2;
        this.polygonOptions = provider3;
        this.circleOptions = provider4;
        this.markerOptions = provider5;
        this.bitmapDescriptorFactory = gmsBitmapDescriptorFactory;
    }

    @NotNull
    public CircleOptions newCircleOptions() {
        GmsCircleOptionsWrapper gmsCircleOptionsWrapper = this.circleOptions.get();
        Intrinsics.checkNotNullExpressionValue(gmsCircleOptionsWrapper, "circleOptions.get()");
        return gmsCircleOptionsWrapper;
    }

    @NotNull
    public LatLngBounds.Builder newLatLngBoundsBuilder() {
        GmsLatLngBoundsBuilder gmsLatLngBoundsBuilder = this.latLngBoundsBuilder.get();
        Intrinsics.checkNotNullExpressionValue(gmsLatLngBoundsBuilder, "latLngBoundsBuilder.get()");
        return gmsLatLngBoundsBuilder;
    }

    @NotNull
    public MarkerOptions newMarkerOptions() {
        GmsMarkerOptionsWrapper gmsMarkerOptionsWrapper = this.markerOptions.get();
        Intrinsics.checkNotNullExpressionValue(gmsMarkerOptionsWrapper, "markerOptions.get()");
        return gmsMarkerOptionsWrapper;
    }

    @NotNull
    public PolygonOptions newPolygonOptions() {
        GmsPolygonOptionsWrapper gmsPolygonOptionsWrapper = this.polygonOptions.get();
        Intrinsics.checkNotNullExpressionValue(gmsPolygonOptionsWrapper, "polygonOptions.get()");
        return gmsPolygonOptionsWrapper;
    }

    @NotNull
    public GmsBitmapDescriptorFactory bitmapDescriptorFactory() {
        return this.bitmapDescriptorFactory;
    }

    @NotNull
    public GmsCameraPositionBuilder newCameraPositionBuilder() {
        GmsCameraPositionBuilder gmsCameraPositionBuilder = this.cameraPositionBuilder.get();
        Intrinsics.checkNotNullExpressionValue(gmsCameraPositionBuilder, "cameraPositionBuilder.get()");
        return gmsCameraPositionBuilder;
    }
}
