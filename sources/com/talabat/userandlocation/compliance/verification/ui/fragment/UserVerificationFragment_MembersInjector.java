package com.talabat.userandlocation.compliance.verification.ui.fragment;

import com.talabat.configuration.tcs.TermsAndConditionsConfigurationRepository;
import dagger.MembersInjector;
import dagger.internal.DaggerGenerated;
import dagger.internal.InjectedFieldSignature;
import dagger.internal.QualifierMetadata;
import javax.inject.Provider;

@QualifierMetadata
@DaggerGenerated
public final class UserVerificationFragment_MembersInjector implements MembersInjector<UserVerificationFragment> {
    private final Provider<TermsAndConditionsConfigurationRepository> termsAndConditionsConfigurationRepositoryProvider;

    public UserVerificationFragment_MembersInjector(Provider<TermsAndConditionsConfigurationRepository> provider) {
        this.termsAndConditionsConfigurationRepositoryProvider = provider;
    }

    public static MembersInjector<UserVerificationFragment> create(Provider<TermsAndConditionsConfigurationRepository> provider) {
        return new UserVerificationFragment_MembersInjector(provider);
    }

    @InjectedFieldSignature("com.talabat.userandlocation.compliance.verification.ui.fragment.UserVerificationFragment.termsAndConditionsConfigurationRepository")
    public static void injectTermsAndConditionsConfigurationRepository(UserVerificationFragment userVerificationFragment, TermsAndConditionsConfigurationRepository termsAndConditionsConfigurationRepository) {
        userVerificationFragment.termsAndConditionsConfigurationRepository = termsAndConditionsConfigurationRepository;
    }

    public void injectMembers(UserVerificationFragment userVerificationFragment) {
        injectTermsAndConditionsConfigurationRepository(userVerificationFragment, this.termsAndConditionsConfigurationRepositoryProvider.get());
    }
}
