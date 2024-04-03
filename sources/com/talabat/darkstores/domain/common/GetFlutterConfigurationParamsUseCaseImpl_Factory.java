package com.talabat.darkstores.domain.common;

import com.talabat.darkstores.data.ConfigurationParameters;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
public final class GetFlutterConfigurationParamsUseCaseImpl_Factory implements Factory<GetFlutterConfigurationParamsUseCaseImpl> {
    private final Provider<ConfigurationParameters> configurationParametersProvider;

    public GetFlutterConfigurationParamsUseCaseImpl_Factory(Provider<ConfigurationParameters> provider) {
        this.configurationParametersProvider = provider;
    }

    public static GetFlutterConfigurationParamsUseCaseImpl_Factory create(Provider<ConfigurationParameters> provider) {
        return new GetFlutterConfigurationParamsUseCaseImpl_Factory(provider);
    }

    public static GetFlutterConfigurationParamsUseCaseImpl newInstance(ConfigurationParameters configurationParameters) {
        return new GetFlutterConfigurationParamsUseCaseImpl(configurationParameters);
    }

    public GetFlutterConfigurationParamsUseCaseImpl get() {
        return newInstance(this.configurationParametersProvider.get());
    }
}
