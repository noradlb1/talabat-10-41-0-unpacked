package com.talabat.maps.data.di;

import com.talabat.gms.maps.domain.GmsLatLngFactory;
import com.talabat.hms.maps.domain.HmsLatLngFactory;
import com.talabat.maps.domain.LatLngFactory;
import com.talabat.maps.domain.MapType;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;

@ScopeMetadata("dagger.Reusable")
@DaggerGenerated
@QualifierMetadata
public final class MapsModule_LatLngFactoryFactory implements Factory<LatLngFactory> {
    private final Provider<GmsLatLngFactory> gmsLatLngFactoryProvider;
    private final Provider<HmsLatLngFactory> hmsLatLngFactoryProvider;
    private final Provider<MapType> mapTypeProvider;

    public MapsModule_LatLngFactoryFactory(Provider<GmsLatLngFactory> provider, Provider<HmsLatLngFactory> provider2, Provider<MapType> provider3) {
        this.gmsLatLngFactoryProvider = provider;
        this.hmsLatLngFactoryProvider = provider2;
        this.mapTypeProvider = provider3;
    }

    public static MapsModule_LatLngFactoryFactory create(Provider<GmsLatLngFactory> provider, Provider<HmsLatLngFactory> provider2, Provider<MapType> provider3) {
        return new MapsModule_LatLngFactoryFactory(provider, provider2, provider3);
    }

    public static LatLngFactory latLngFactory(GmsLatLngFactory gmsLatLngFactory, HmsLatLngFactory hmsLatLngFactory, MapType mapType) {
        return (LatLngFactory) Preconditions.checkNotNullFromProvides(MapsModule.INSTANCE.latLngFactory(gmsLatLngFactory, hmsLatLngFactory, mapType));
    }

    public LatLngFactory get() {
        return latLngFactory(this.gmsLatLngFactoryProvider.get(), this.hmsLatLngFactoryProvider.get(), this.mapTypeProvider.get());
    }
}
