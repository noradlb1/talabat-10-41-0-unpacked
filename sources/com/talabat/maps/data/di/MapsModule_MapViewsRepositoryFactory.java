package com.talabat.maps.data.di;

import com.talabat.gms.maps.domain.GmsMapsViewsRepository;
import com.talabat.hms.maps.domain.HmsMapsViewsRepository;
import com.talabat.maps.domain.MapType;
import com.talabat.maps.domain.MapViewsRepository;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;

@ScopeMetadata("dagger.Reusable")
@DaggerGenerated
@QualifierMetadata
public final class MapsModule_MapViewsRepositoryFactory implements Factory<MapViewsRepository> {
    private final Provider<GmsMapsViewsRepository> gmsMapsViewsRepositoryProvider;
    private final Provider<HmsMapsViewsRepository> hmsMapsViewsRepositoryProvider;
    private final Provider<MapType> mapTypeProvider;

    public MapsModule_MapViewsRepositoryFactory(Provider<GmsMapsViewsRepository> provider, Provider<HmsMapsViewsRepository> provider2, Provider<MapType> provider3) {
        this.gmsMapsViewsRepositoryProvider = provider;
        this.hmsMapsViewsRepositoryProvider = provider2;
        this.mapTypeProvider = provider3;
    }

    public static MapsModule_MapViewsRepositoryFactory create(Provider<GmsMapsViewsRepository> provider, Provider<HmsMapsViewsRepository> provider2, Provider<MapType> provider3) {
        return new MapsModule_MapViewsRepositoryFactory(provider, provider2, provider3);
    }

    public static MapViewsRepository mapViewsRepository(GmsMapsViewsRepository gmsMapsViewsRepository, HmsMapsViewsRepository hmsMapsViewsRepository, MapType mapType) {
        return (MapViewsRepository) Preconditions.checkNotNullFromProvides(MapsModule.INSTANCE.mapViewsRepository(gmsMapsViewsRepository, hmsMapsViewsRepository, mapType));
    }

    public MapViewsRepository get() {
        return mapViewsRepository(this.gmsMapsViewsRepositoryProvider.get(), this.hmsMapsViewsRepositoryProvider.get(), this.mapTypeProvider.get());
    }
}
