package com.talabat.feature.tmart.growth.domain.claim;

import com.talabat.feature.tmart.growth.domain.ITMartGrowthRepository;
import com.talabat.feature.tmart.growth.domain.files.ITMartGrowthFileManager;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
public final class TMartGrowthClaimInfoUseCase_Factory implements Factory<TMartGrowthClaimInfoUseCase> {
    private final Provider<ITMartGrowthFileManager> imageFileManagerProvider;
    private final Provider<ITMartGrowthRepository> repositoryProvider;

    public TMartGrowthClaimInfoUseCase_Factory(Provider<ITMartGrowthFileManager> provider, Provider<ITMartGrowthRepository> provider2) {
        this.imageFileManagerProvider = provider;
        this.repositoryProvider = provider2;
    }

    public static TMartGrowthClaimInfoUseCase_Factory create(Provider<ITMartGrowthFileManager> provider, Provider<ITMartGrowthRepository> provider2) {
        return new TMartGrowthClaimInfoUseCase_Factory(provider, provider2);
    }

    public static TMartGrowthClaimInfoUseCase newInstance(ITMartGrowthFileManager iTMartGrowthFileManager, ITMartGrowthRepository iTMartGrowthRepository) {
        return new TMartGrowthClaimInfoUseCase(iTMartGrowthFileManager, iTMartGrowthRepository);
    }

    public TMartGrowthClaimInfoUseCase get() {
        return newInstance(this.imageFileManagerProvider.get(), this.repositoryProvider.get());
    }
}
