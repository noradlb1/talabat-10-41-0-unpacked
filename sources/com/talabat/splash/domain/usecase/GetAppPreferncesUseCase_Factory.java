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
public final class GetAppPreferncesUseCase_Factory implements Factory<GetAppPreferncesUseCase> {
    private final Provider<AppInfoRepository> appInfoRepositoryProvider;

    public GetAppPreferncesUseCase_Factory(Provider<AppInfoRepository> provider) {
        this.appInfoRepositoryProvider = provider;
    }

    public static GetAppPreferncesUseCase_Factory create(Provider<AppInfoRepository> provider) {
        return new GetAppPreferncesUseCase_Factory(provider);
    }

    public static GetAppPreferncesUseCase newInstance(AppInfoRepository appInfoRepository) {
        return new GetAppPreferncesUseCase(appInfoRepository);
    }

    public GetAppPreferncesUseCase get() {
        return newInstance(this.appInfoRepositoryProvider.get());
    }
}
