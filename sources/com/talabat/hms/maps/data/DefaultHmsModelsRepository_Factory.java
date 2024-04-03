package com.talabat.hms.maps.data;

import com.talabat.hms.maps.data.model.HmsCameraPositionBuilder;
import com.talabat.hms.maps.data.model.HmsCircleOptionsWrapper;
import com.talabat.hms.maps.data.model.HmsLatLngBoundsBuilder;
import com.talabat.hms.maps.data.model.HmsMarkerOptionsWrapper;
import com.talabat.hms.maps.data.model.HmsPolygonOptionsWrapper;
import com.talabat.maps.domain.model.BitmapDescriptorFactory;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
public final class DefaultHmsModelsRepository_Factory implements Factory<DefaultHmsModelsRepository> {
    private final Provider<BitmapDescriptorFactory> bitmapDescriptorFactoryProvider;
    private final Provider<HmsCameraPositionBuilder> cameraPositionBuilderProvider;
    private final Provider<HmsCircleOptionsWrapper> circleOptionsProvider;
    private final Provider<HmsLatLngBoundsBuilder> latLngBoundsBuilderProvider;
    private final Provider<HmsMarkerOptionsWrapper> markerOptionsProvider;
    private final Provider<HmsPolygonOptionsWrapper> polygonOptionsProvider;

    public DefaultHmsModelsRepository_Factory(Provider<HmsCameraPositionBuilder> provider, Provider<HmsLatLngBoundsBuilder> provider2, Provider<HmsPolygonOptionsWrapper> provider3, Provider<HmsCircleOptionsWrapper> provider4, Provider<HmsMarkerOptionsWrapper> provider5, Provider<BitmapDescriptorFactory> provider6) {
        this.cameraPositionBuilderProvider = provider;
        this.latLngBoundsBuilderProvider = provider2;
        this.polygonOptionsProvider = provider3;
        this.circleOptionsProvider = provider4;
        this.markerOptionsProvider = provider5;
        this.bitmapDescriptorFactoryProvider = provider6;
    }

    public static DefaultHmsModelsRepository_Factory create(Provider<HmsCameraPositionBuilder> provider, Provider<HmsLatLngBoundsBuilder> provider2, Provider<HmsPolygonOptionsWrapper> provider3, Provider<HmsCircleOptionsWrapper> provider4, Provider<HmsMarkerOptionsWrapper> provider5, Provider<BitmapDescriptorFactory> provider6) {
        return new DefaultHmsModelsRepository_Factory(provider, provider2, provider3, provider4, provider5, provider6);
    }

    public static DefaultHmsModelsRepository newInstance(Provider<HmsCameraPositionBuilder> provider, Provider<HmsLatLngBoundsBuilder> provider2, Provider<HmsPolygonOptionsWrapper> provider3, Provider<HmsCircleOptionsWrapper> provider4, Provider<HmsMarkerOptionsWrapper> provider5, BitmapDescriptorFactory bitmapDescriptorFactory) {
        return new DefaultHmsModelsRepository(provider, provider2, provider3, provider4, provider5, bitmapDescriptorFactory);
    }

    public DefaultHmsModelsRepository get() {
        return newInstance(this.cameraPositionBuilderProvider, this.latLngBoundsBuilderProvider, this.polygonOptionsProvider, this.circleOptionsProvider, this.markerOptionsProvider, this.bitmapDescriptorFactoryProvider.get());
    }
}
