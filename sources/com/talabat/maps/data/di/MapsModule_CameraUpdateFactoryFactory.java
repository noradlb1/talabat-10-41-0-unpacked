package com.talabat.maps.data.di;

import com.talabat.gms.maps.domain.GmsCameraUpdateFactory;
import com.talabat.hms.maps.domain.HmsCameraUpdateFactory;
import com.talabat.maps.domain.CameraUpdateFactory;
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
public final class MapsModule_CameraUpdateFactoryFactory implements Factory<CameraUpdateFactory> {
    private final Provider<GmsCameraUpdateFactory> gmsCameraUpdateFactoryProvider;
    private final Provider<HmsCameraUpdateFactory> hmsCameraUpdateFactoryProvider;
    private final Provider<MapType> mapTypeProvider;

    public MapsModule_CameraUpdateFactoryFactory(Provider<GmsCameraUpdateFactory> provider, Provider<HmsCameraUpdateFactory> provider2, Provider<MapType> provider3) {
        this.gmsCameraUpdateFactoryProvider = provider;
        this.hmsCameraUpdateFactoryProvider = provider2;
        this.mapTypeProvider = provider3;
    }

    public static CameraUpdateFactory cameraUpdateFactory(GmsCameraUpdateFactory gmsCameraUpdateFactory, HmsCameraUpdateFactory hmsCameraUpdateFactory, MapType mapType) {
        return (CameraUpdateFactory) Preconditions.checkNotNullFromProvides(MapsModule.INSTANCE.cameraUpdateFactory(gmsCameraUpdateFactory, hmsCameraUpdateFactory, mapType));
    }

    public static MapsModule_CameraUpdateFactoryFactory create(Provider<GmsCameraUpdateFactory> provider, Provider<HmsCameraUpdateFactory> provider2, Provider<MapType> provider3) {
        return new MapsModule_CameraUpdateFactoryFactory(provider, provider2, provider3);
    }

    public CameraUpdateFactory get() {
        return cameraUpdateFactory(this.gmsCameraUpdateFactoryProvider.get(), this.hmsCameraUpdateFactoryProvider.get(), this.mapTypeProvider.get());
    }
}
