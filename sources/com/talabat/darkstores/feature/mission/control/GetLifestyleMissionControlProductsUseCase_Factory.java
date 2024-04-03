package com.talabat.darkstores.feature.mission.control;

import com.talabat.core.featureflag.domain.ITalabatFeatureFlag;
import com.talabat.darkstores.data.darkstores.DarkstoresRepo;
import com.talabat.darkstores.data.discovery.DiscoveryRepo;
import com.talabat.darkstores.data.mission.control.MissionControlProductRepository;
import com.talabat.darkstores.data.tracking.SearchTracker;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;

@ScopeMetadata("dagger.Reusable")
@DaggerGenerated
@QualifierMetadata
public final class GetLifestyleMissionControlProductsUseCase_Factory implements Factory<GetLifestyleMissionControlProductsUseCase> {
    private final Provider<DarkstoresRepo> darkstoresRepoProvider;
    private final Provider<DiscoveryRepo> discoveryRepoProvider;
    private final Provider<ITalabatFeatureFlag> featureFlagsProvider;
    private final Provider<MissionControlProductRepository> missionControlProductRepositoryProvider;
    private final Provider<SearchTracker> searchTrackerProvider;

    public GetLifestyleMissionControlProductsUseCase_Factory(Provider<DarkstoresRepo> provider, Provider<DiscoveryRepo> provider2, Provider<ITalabatFeatureFlag> provider3, Provider<MissionControlProductRepository> provider4, Provider<SearchTracker> provider5) {
        this.darkstoresRepoProvider = provider;
        this.discoveryRepoProvider = provider2;
        this.featureFlagsProvider = provider3;
        this.missionControlProductRepositoryProvider = provider4;
        this.searchTrackerProvider = provider5;
    }

    public static GetLifestyleMissionControlProductsUseCase_Factory create(Provider<DarkstoresRepo> provider, Provider<DiscoveryRepo> provider2, Provider<ITalabatFeatureFlag> provider3, Provider<MissionControlProductRepository> provider4, Provider<SearchTracker> provider5) {
        return new GetLifestyleMissionControlProductsUseCase_Factory(provider, provider2, provider3, provider4, provider5);
    }

    public static GetLifestyleMissionControlProductsUseCase newInstance(DarkstoresRepo darkstoresRepo, DiscoveryRepo discoveryRepo, ITalabatFeatureFlag iTalabatFeatureFlag, MissionControlProductRepository missionControlProductRepository, SearchTracker searchTracker) {
        return new GetLifestyleMissionControlProductsUseCase(darkstoresRepo, discoveryRepo, iTalabatFeatureFlag, missionControlProductRepository, searchTracker);
    }

    public GetLifestyleMissionControlProductsUseCase get() {
        return newInstance(this.darkstoresRepoProvider.get(), this.discoveryRepoProvider.get(), this.featureFlagsProvider.get(), this.missionControlProductRepositoryProvider.get(), this.searchTrackerProvider.get());
    }
}
