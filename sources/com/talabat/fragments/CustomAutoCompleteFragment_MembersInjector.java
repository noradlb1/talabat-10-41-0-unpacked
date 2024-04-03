package com.talabat.fragments;

import com.talabat.authentication.aaa.secrets.SecretProvider;
import dagger.MembersInjector;
import dagger.internal.DaggerGenerated;
import dagger.internal.InjectedFieldSignature;
import dagger.internal.QualifierMetadata;
import javax.inject.Provider;

@QualifierMetadata
@DaggerGenerated
public final class CustomAutoCompleteFragment_MembersInjector implements MembersInjector<CustomAutoCompleteFragment> {
    private final Provider<SecretProvider> secretProvider;

    public CustomAutoCompleteFragment_MembersInjector(Provider<SecretProvider> provider) {
        this.secretProvider = provider;
    }

    public static MembersInjector<CustomAutoCompleteFragment> create(Provider<SecretProvider> provider) {
        return new CustomAutoCompleteFragment_MembersInjector(provider);
    }

    @InjectedFieldSignature("com.talabat.fragments.CustomAutoCompleteFragment.secretProvider")
    public static void injectSecretProvider(CustomAutoCompleteFragment customAutoCompleteFragment, SecretProvider secretProvider2) {
        customAutoCompleteFragment.secretProvider = secretProvider2;
    }

    public void injectMembers(CustomAutoCompleteFragment customAutoCompleteFragment) {
        injectSecretProvider(customAutoCompleteFragment, this.secretProvider.get());
    }
}
