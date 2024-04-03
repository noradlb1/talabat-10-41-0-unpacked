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
public final class SetAppConfigUseCase_Factory implements Factory<SetAppConfigUseCase> {
    private final Provider<AppInfoRepository> appInfoRepositoryProvider;

    public SetAppConfigUseCase_Factory(Provider<AppInfoRepository> provider) {
        this.appInfoRepositoryProvider = provider;
    }

    public static SetAppConfigUseCase_Factory create(Provider<AppInfoRepository> provider) {
        return new SetAppConfigUseCase_Factory(provider);
    }

    public static SetAppConfigUseCase newInstance(AppInfoRepository appInfoRepository) {
        return new SetAppConfigUseCase(appInfoRepository);
    }

    public SetAppConfigUseCase get() {
        return newInstance(this.appInfoRepositoryProvider.get());
    }
}
