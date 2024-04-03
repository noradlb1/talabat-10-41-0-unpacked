package com.talabat.feature.darkstorescampaignmessage.data.di;

import com.talabat.authentication.aaa.secrets.SecretProvider;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;
import okhttp3.Interceptor;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata({"com.talabat.feature.darkstorescampaignmessage.data.di.CampaignMessage"})
public final class CampaignMessageNetworkModule_ProvideAuthInterceptorFactory implements Factory<Interceptor> {
    private final CampaignMessageNetworkModule module;
    private final Provider<SecretProvider> secretProvider;

    public CampaignMessageNetworkModule_ProvideAuthInterceptorFactory(CampaignMessageNetworkModule campaignMessageNetworkModule, Provider<SecretProvider> provider) {
        this.module = campaignMessageNetworkModule;
        this.secretProvider = provider;
    }

    public static CampaignMessageNetworkModule_ProvideAuthInterceptorFactory create(CampaignMessageNetworkModule campaignMessageNetworkModule, Provider<SecretProvider> provider) {
        return new CampaignMessageNetworkModule_ProvideAuthInterceptorFactory(campaignMessageNetworkModule, provider);
    }

    public static Interceptor provideAuthInterceptor(CampaignMessageNetworkModule campaignMessageNetworkModule, SecretProvider secretProvider2) {
        return (Interceptor) Preconditions.checkNotNullFromProvides(campaignMessageNetworkModule.provideAuthInterceptor(secretProvider2));
    }

    public Interceptor get() {
        return provideAuthInterceptor(this.module, this.secretProvider.get());
    }
}
