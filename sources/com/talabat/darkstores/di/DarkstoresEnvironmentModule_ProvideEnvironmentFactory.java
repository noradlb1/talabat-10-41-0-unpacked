package com.talabat.darkstores.di;

import com.talabat.darkstores.data.ConfigurationParameters;
import com.talabat.darkstores.data.Environment;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;

@ScopeMetadata("com.talabat.darkstores.di.LibScope")
@DaggerGenerated
@QualifierMetadata
public final class DarkstoresEnvironmentModule_ProvideEnvironmentFactory implements Factory<Environment> {
    private final Provider<ConfigurationParameters> configurationParametersProvider;

    public DarkstoresEnvironmentModule_ProvideEnvironmentFactory(Provider<ConfigurationParameters> provider) {
        this.configurationParametersProvider = provider;
    }

    public static DarkstoresEnvironmentModule_ProvideEnvironmentFactory create(Provider<ConfigurationParameters> provider) {
        return new DarkstoresEnvironmentModule_ProvideEnvironmentFactory(provider);
    }

    public static Environment provideEnvironment(ConfigurationParameters configurationParameters) {
        return (Environment) Preconditions.checkNotNullFromProvides(DarkstoresEnvironmentModule.INSTANCE.provideEnvironment(configurationParameters));
    }

    public Environment get() {
        return provideEnvironment(this.configurationParametersProvider.get());
    }
}
