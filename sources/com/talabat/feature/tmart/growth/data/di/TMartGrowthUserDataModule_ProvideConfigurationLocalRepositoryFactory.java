package com.talabat.feature.tmart.growth.data.di;

import android.content.Context;
import com.talabat.configuration.ConfigurationLocalRepository;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
public final class TMartGrowthUserDataModule_ProvideConfigurationLocalRepositoryFactory implements Factory<ConfigurationLocalRepository> {
    private final Provider<Context> contextProvider;

    public TMartGrowthUserDataModule_ProvideConfigurationLocalRepositoryFactory(Provider<Context> provider) {
        this.contextProvider = provider;
    }

    public static TMartGrowthUserDataModule_ProvideConfigurationLocalRepositoryFactory create(Provider<Context> provider) {
        return new TMartGrowthUserDataModule_ProvideConfigurationLocalRepositoryFactory(provider);
    }

    public static ConfigurationLocalRepository provideConfigurationLocalRepository(Context context) {
        return (ConfigurationLocalRepository) Preconditions.checkNotNullFromProvides(TMartGrowthUserDataModule.INSTANCE.provideConfigurationLocalRepository(context));
    }

    public ConfigurationLocalRepository get() {
        return provideConfigurationLocalRepository(this.contextProvider.get());
    }
}
