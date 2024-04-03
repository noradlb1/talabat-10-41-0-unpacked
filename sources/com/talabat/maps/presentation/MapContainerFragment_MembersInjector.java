package com.talabat.maps.presentation;

import com.talabat.maps.domain.MapViewsRepository;
import dagger.MembersInjector;
import dagger.internal.DaggerGenerated;
import dagger.internal.InjectedFieldSignature;
import dagger.internal.QualifierMetadata;
import javax.inject.Provider;

@QualifierMetadata
@DaggerGenerated
public final class MapContainerFragment_MembersInjector implements MembersInjector<MapContainerFragment> {
    private final Provider<MapViewsRepository> mapViewsRepositoryProvider;

    public MapContainerFragment_MembersInjector(Provider<MapViewsRepository> provider) {
        this.mapViewsRepositoryProvider = provider;
    }

    public static MembersInjector<MapContainerFragment> create(Provider<MapViewsRepository> provider) {
        return new MapContainerFragment_MembersInjector(provider);
    }

    @InjectedFieldSignature("com.talabat.maps.presentation.MapContainerFragment.mapViewsRepository")
    public static void injectMapViewsRepository(MapContainerFragment mapContainerFragment, MapViewsRepository mapViewsRepository) {
        mapContainerFragment.mapViewsRepository = mapViewsRepository;
    }

    public void injectMembers(MapContainerFragment mapContainerFragment) {
        injectMapViewsRepository(mapContainerFragment, this.mapViewsRepositoryProvider.get());
    }
}
