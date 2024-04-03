package com.talabat.maps.data.di;

import com.talabat.gms.maps.domain.GmsModelsRepository;
import com.talabat.hms.maps.domain.HmsModelsRepository;
import com.talabat.maps.domain.MapType;
import com.talabat.maps.domain.ModelsRepository;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;

@ScopeMetadata("dagger.Reusable")
@DaggerGenerated
@QualifierMetadata
public final class MapsModule_ModelsRepositoryFactory implements Factory<ModelsRepository> {
    private final Provider<GmsModelsRepository> gmsModelsRepositoryProvider;
    private final Provider<HmsModelsRepository> hmsModelsRepositoryProvider;
    private final Provider<MapType> mapTypeProvider;

    public MapsModule_ModelsRepositoryFactory(Provider<GmsModelsRepository> provider, Provider<HmsModelsRepository> provider2, Provider<MapType> provider3) {
        this.gmsModelsRepositoryProvider = provider;
        this.hmsModelsRepositoryProvider = provider2;
        this.mapTypeProvider = provider3;
    }

    public static MapsModule_ModelsRepositoryFactory create(Provider<GmsModelsRepository> provider, Provider<HmsModelsRepository> provider2, Provider<MapType> provider3) {
        return new MapsModule_ModelsRepositoryFactory(provider, provider2, provider3);
    }

    public static ModelsRepository modelsRepository(GmsModelsRepository gmsModelsRepository, HmsModelsRepository hmsModelsRepository, MapType mapType) {
        return (ModelsRepository) Preconditions.checkNotNullFromProvides(MapsModule.INSTANCE.modelsRepository(gmsModelsRepository, hmsModelsRepository, mapType));
    }

    public ModelsRepository get() {
        return modelsRepository(this.gmsModelsRepositoryProvider.get(), this.hmsModelsRepositoryProvider.get(), this.mapTypeProvider.get());
    }
}
