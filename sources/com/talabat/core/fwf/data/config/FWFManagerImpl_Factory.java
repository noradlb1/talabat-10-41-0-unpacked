package com.talabat.core.fwf.data.config;

import android.content.Context;
import com.talabat.configuration.ConfigurationLocalRepository;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata({"com.talabat.core.gms.base.domain.IsGmsAvailable"})
public final class FWFManagerImpl_Factory implements Factory<FWFManagerImpl> {
    private final Provider<ConfigurationLocalRepository> configurationLocalRepositoryProvider;
    private final Provider<Context> contextProvider;
    private final Provider<Boolean> hasGoogleServicesProvider;

    public FWFManagerImpl_Factory(Provider<Context> provider, Provider<ConfigurationLocalRepository> provider2, Provider<Boolean> provider3) {
        this.contextProvider = provider;
        this.configurationLocalRepositoryProvider = provider2;
        this.hasGoogleServicesProvider = provider3;
    }

    public static FWFManagerImpl_Factory create(Provider<Context> provider, Provider<ConfigurationLocalRepository> provider2, Provider<Boolean> provider3) {
        return new FWFManagerImpl_Factory(provider, provider2, provider3);
    }

    public static FWFManagerImpl newInstance(Context context, ConfigurationLocalRepository configurationLocalRepository, boolean z11) {
        return new FWFManagerImpl(context, configurationLocalRepository, z11);
    }

    public FWFManagerImpl get() {
        return newInstance(this.contextProvider.get(), this.configurationLocalRepositoryProvider.get(), this.hasGoogleServicesProvider.get().booleanValue());
    }
}
