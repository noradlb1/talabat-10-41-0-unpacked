package com.talabat.gms.maps.data;

import com.talabat.gms.maps.data.model.GmsBitmapDescriptorFactory;
import com.talabat.gms.maps.data.model.GmsCameraPositionBuilder;
import com.talabat.gms.maps.data.model.GmsCircleOptionsWrapper;
import com.talabat.gms.maps.data.model.GmsLatLngBoundsBuilder;
import com.talabat.gms.maps.data.model.GmsMarkerOptionsWrapper;
import com.talabat.gms.maps.data.model.GmsPolygonOptionsWrapper;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
public final class DefaultGmsModelsRepository_Factory implements Factory<DefaultGmsModelsRepository> {
    private final Provider<GmsBitmapDescriptorFactory> bitmapDescriptorFactoryProvider;
    private final Provider<GmsCameraPositionBuilder> cameraPositionBuilderProvider;
    private final Provider<GmsCircleOptionsWrapper> circleOptionsProvider;
    private final Provider<GmsLatLngBoundsBuilder> latLngBoundsBuilderProvider;
    private final Provider<GmsMarkerOptionsWrapper> markerOptionsProvider;
    private final Provider<GmsPolygonOptionsWrapper> polygonOptionsProvider;

    public DefaultGmsModelsRepository_Factory(Provider<GmsCameraPositionBuilder> provider, Provider<GmsLatLngBoundsBuilder> provider2, Provider<GmsPolygonOptionsWrapper> provider3, Provider<GmsCircleOptionsWrapper> provider4, Provider<GmsMarkerOptionsWrapper> provider5, Provider<GmsBitmapDescriptorFactory> provider6) {
        this.cameraPositionBuilderProvider = provider;
        this.latLngBoundsBuilderProvider = provider2;
        this.polygonOptionsProvider = provider3;
        this.circleOptionsProvider = provider4;
        this.markerOptionsProvider = provider5;
        this.bitmapDescriptorFactoryProvider = provider6;
    }

    public static DefaultGmsModelsRepository_Factory create(Provider<GmsCameraPositionBuilder> provider, Provider<GmsLatLngBoundsBuilder> provider2, Provider<GmsPolygonOptionsWrapper> provider3, Provider<GmsCircleOptionsWrapper> provider4, Provider<GmsMarkerOptionsWrapper> provider5, Provider<GmsBitmapDescriptorFactory> provider6) {
        return new DefaultGmsModelsRepository_Factory(provider, provider2, provider3, provider4, provider5, provider6);
    }

    public static DefaultGmsModelsRepository newInstance(Provider<GmsCameraPositionBuilder> provider, Provider<GmsLatLngBoundsBuilder> provider2, Provider<GmsPolygonOptionsWrapper> provider3, Provider<GmsCircleOptionsWrapper> provider4, Provider<GmsMarkerOptionsWrapper> provider5, GmsBitmapDescriptorFactory gmsBitmapDescriptorFactory) {
        return new DefaultGmsModelsRepository(provider, provider2, provider3, provider4, provider5, gmsBitmapDescriptorFactory);
    }

    public DefaultGmsModelsRepository get() {
        return newInstance(this.cameraPositionBuilderProvider, this.latLngBoundsBuilderProvider, this.polygonOptionsProvider, this.circleOptionsProvider, this.markerOptionsProvider, this.bitmapDescriptorFactoryProvider.get());
    }
}
