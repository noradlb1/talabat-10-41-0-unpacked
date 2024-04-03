package com.talabat.splash.domain.usecase;

import com.talabat.splash.data.repositories.AppInfoRepository;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
public final class GetAppLanguageUseCase_Factory implements Factory<GetAppLanguageUseCase> {
    private final Provider<AppInfoRepository> appInfoRepositoryProvider;

    public GetAppLanguageUseCase_Factory(Provider<AppInfoRepository> provider) {
        this.appInfoRepositoryProvider = provider;
    }

    public static GetAppLanguageUseCase_Factory create(Provider<AppInfoRepository> provider) {
        return new GetAppLanguageUseCase_Factory(provider);
    }

    public static GetAppLanguageUseCase newInstance(AppInfoRepository appInfoRepository) {
        return new GetAppLanguageUseCase(appInfoRepository);
    }

    public GetAppLanguageUseCase get() {
        return newInstance(this.appInfoRepositoryProvider.get());
    }
}
