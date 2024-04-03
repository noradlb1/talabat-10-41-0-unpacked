package com.talabat;

import com.talabat.configuration.ConfigurationLocalRepository;
import dagger.MembersInjector;
import dagger.internal.DaggerGenerated;
import dagger.internal.InjectedFieldSignature;
import dagger.internal.QualifierMetadata;
import javax.inject.Provider;

@QualifierMetadata
@DaggerGenerated
public final class DeepLinkWebViewScreen_MembersInjector implements MembersInjector<DeepLinkWebViewScreen> {
    private final Provider<ConfigurationLocalRepository> configurationLocalRepositoryProvider;

    public DeepLinkWebViewScreen_MembersInjector(Provider<ConfigurationLocalRepository> provider) {
        this.configurationLocalRepositoryProvider = provider;
    }

    public static MembersInjector<DeepLinkWebViewScreen> create(Provider<ConfigurationLocalRepository> provider) {
        return new DeepLinkWebViewScreen_MembersInjector(provider);
    }

    @InjectedFieldSignature("com.talabat.DeepLinkWebViewScreen.configurationLocalRepository")
    public static void injectConfigurationLocalRepository(DeepLinkWebViewScreen deepLinkWebViewScreen, ConfigurationLocalRepository configurationLocalRepository) {
        deepLinkWebViewScreen.f54012i = configurationLocalRepository;
    }

    public void injectMembers(DeepLinkWebViewScreen deepLinkWebViewScreen) {
        injectConfigurationLocalRepository(deepLinkWebViewScreen, this.configurationLocalRepositoryProvider.get());
    }
}
