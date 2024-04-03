package com.talabat.feature.tmart.growth.domain.confirmation;

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
public final class TMartGrowthConfirmationImagesUseCase_Factory implements Factory<TMartGrowthConfirmationImagesUseCase> {
    private final Provider<ITMartGrowthFileManager> imageFileManagerProvider;
    private final Provider<ITMartGrowthRepository> repositoryProvider;

    public TMartGrowthConfirmationImagesUseCase_Factory(Provider<ITMartGrowthRepository> provider, Provider<ITMartGrowthFileManager> provider2) {
        this.repositoryProvider = provider;
        this.imageFileManagerProvider = provider2;
    }

    public static TMartGrowthConfirmationImagesUseCase_Factory create(Provider<ITMartGrowthRepository> provider, Provider<ITMartGrowthFileManager> provider2) {
        return new TMartGrowthConfirmationImagesUseCase_Factory(provider, provider2);
    }

    public static TMartGrowthConfirmationImagesUseCase newInstance(ITMartGrowthRepository iTMartGrowthRepository, ITMartGrowthFileManager iTMartGrowthFileManager) {
        return new TMartGrowthConfirmationImagesUseCase(iTMartGrowthRepository, iTMartGrowthFileManager);
    }

    public TMartGrowthConfirmationImagesUseCase get() {
        return newInstance(this.repositoryProvider.get(), this.imageFileManagerProvider.get());
    }
}
