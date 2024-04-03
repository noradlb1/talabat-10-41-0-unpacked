package com.talabat.maps.data.di;

import com.talabat.gms.maps.domain.GmsMapsInitializer;
import com.talabat.hms.maps.domain.HmsMapsInitializer;
import com.talabat.maps.domain.MapType;
import com.talabat.maps.domain.MapsInitializer;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;

@ScopeMetadata("dagger.Reusable")
@DaggerGenerated
@QualifierMetadata
public final class MapsModule_MapsInitializerFactory implements Factory<MapsInitializer> {
    private final Provider<GmsMapsInitializer> gmsMapsInitializerProvider;
    private final Provider<HmsMapsInitializer> hmsMapsInitializerProvider;
    private final Provider<MapType> mapTypeProvider;

    public MapsModule_MapsInitializerFactory(Provider<GmsMapsInitializer> provider, Provider<HmsMapsInitializer> provider2, Provider<MapType> provider3) {
        this.gmsMapsInitializerProvider = provider;
        this.hmsMapsInitializerProvider = provider2;
        this.mapTypeProvider = provider3;
    }

    public static MapsModule_MapsInitializerFactory create(Provider<GmsMapsInitializer> provider, Provider<HmsMapsInitializer> provider2, Provider<MapType> provider3) {
        return new MapsModule_MapsInitializerFactory(provider, provider2, provider3);
    }

    public static MapsInitializer mapsInitializer(GmsMapsInitializer gmsMapsInitializer, HmsMapsInitializer hmsMapsInitializer, MapType mapType) {
        return (MapsInitializer) Preconditions.checkNotNullFromProvides(MapsModule.INSTANCE.mapsInitializer(gmsMapsInitializer, hmsMapsInitializer, mapType));
    }

    public MapsInitializer get() {
        return mapsInitializer(this.gmsMapsInitializerProvider.get(), this.hmsMapsInitializerProvider.get(), this.mapTypeProvider.get());
    }
}
