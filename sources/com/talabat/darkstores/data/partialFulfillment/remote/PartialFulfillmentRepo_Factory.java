package com.talabat.darkstores.data.partialFulfillment.remote;

import com.talabat.darkstores.data.ConfigurationParameters;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;

@ScopeMetadata("com.talabat.darkstores.di.LibScope")
@DaggerGenerated
@QualifierMetadata
public final class PartialFulfillmentRepo_Factory implements Factory<PartialFulfillmentRepo> {
    private final Provider<ConfigurationParameters> configurationParametersProvider;
    private final Provider<PartialFulfillmentApi> partialFulfillmentApiProvider;

    public PartialFulfillmentRepo_Factory(Provider<PartialFulfillmentApi> provider, Provider<ConfigurationParameters> provider2) {
        this.partialFulfillmentApiProvider = provider;
        this.configurationParametersProvider = provider2;
    }

    public static PartialFulfillmentRepo_Factory create(Provider<PartialFulfillmentApi> provider, Provider<ConfigurationParameters> provider2) {
        return new PartialFulfillmentRepo_Factory(provider, provider2);
    }

    public static PartialFulfillmentRepo newInstance(PartialFulfillmentApi partialFulfillmentApi, ConfigurationParameters configurationParameters) {
        return new PartialFulfillmentRepo(partialFulfillmentApi, configurationParameters);
    }

    public PartialFulfillmentRepo get() {
        return newInstance(this.partialFulfillmentApiProvider.get(), this.configurationParametersProvider.get());
    }
}
