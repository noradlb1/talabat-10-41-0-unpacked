package com.talabat;

import com.talabat.configuration.tcs.TermsAndConditionsConfigurationRepository;
import dagger.MembersInjector;
import dagger.internal.DaggerGenerated;
import dagger.internal.InjectedFieldSignature;
import dagger.internal.QualifierMetadata;
import javax.inject.Provider;

@QualifierMetadata
@DaggerGenerated
public final class AboutUsScreen_MembersInjector implements MembersInjector<AboutUsScreen> {
    private final Provider<TermsAndConditionsConfigurationRepository> termsAndConditionsConfigurationRepositoryProvider;

    public AboutUsScreen_MembersInjector(Provider<TermsAndConditionsConfigurationRepository> provider) {
        this.termsAndConditionsConfigurationRepositoryProvider = provider;
    }

    public static MembersInjector<AboutUsScreen> create(Provider<TermsAndConditionsConfigurationRepository> provider) {
        return new AboutUsScreen_MembersInjector(provider);
    }

    @InjectedFieldSignature("com.talabat.AboutUsScreen.termsAndConditionsConfigurationRepository")
    public static void injectTermsAndConditionsConfigurationRepository(AboutUsScreen aboutUsScreen, TermsAndConditionsConfigurationRepository termsAndConditionsConfigurationRepository) {
        aboutUsScreen.termsAndConditionsConfigurationRepository = termsAndConditionsConfigurationRepository;
    }

    public void injectMembers(AboutUsScreen aboutUsScreen) {
        injectTermsAndConditionsConfigurationRepository(aboutUsScreen, this.termsAndConditionsConfigurationRepositoryProvider.get());
    }
}
