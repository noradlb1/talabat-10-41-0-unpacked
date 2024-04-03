package com.talabat.adscreen;

import com.talabat.configuration.ConfigurationLocalRepository;
import dagger.MembersInjector;
import dagger.internal.DaggerGenerated;
import dagger.internal.InjectedFieldSignature;
import dagger.internal.QualifierMetadata;
import javax.inject.Provider;

@QualifierMetadata
@DaggerGenerated
public final class AdScreen_MembersInjector implements MembersInjector<AdScreen> {
    private final Provider<ConfigurationLocalRepository> configurationLocalRepositoryProvider;

    public AdScreen_MembersInjector(Provider<ConfigurationLocalRepository> provider) {
        this.configurationLocalRepositoryProvider = provider;
    }

    public static MembersInjector<AdScreen> create(Provider<ConfigurationLocalRepository> provider) {
        return new AdScreen_MembersInjector(provider);
    }

    @InjectedFieldSignature("com.talabat.adscreen.AdScreen.configurationLocalRepository")
    public static void injectConfigurationLocalRepository(AdScreen adScreen, ConfigurationLocalRepository configurationLocalRepository) {
        adScreen.f55363i = configurationLocalRepository;
    }

    public void injectMembers(AdScreen adScreen) {
        injectConfigurationLocalRepository(adScreen, this.configurationLocalRepositoryProvider.get());
    }
}
