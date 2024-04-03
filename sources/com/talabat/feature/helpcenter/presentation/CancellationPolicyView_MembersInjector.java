package com.talabat.feature.helpcenter.presentation;

import dagger.MembersInjector;
import dagger.internal.DaggerGenerated;
import dagger.internal.InjectedFieldSignature;
import dagger.internal.QualifierMetadata;
import javax.inject.Provider;

@QualifierMetadata
@DaggerGenerated
public final class CancellationPolicyView_MembersInjector implements MembersInjector<CancellationPolicyView> {
    private final Provider<CancellationPolicyViewModelFactory> cancellationPolicyViewModelFactoryProvider;

    public CancellationPolicyView_MembersInjector(Provider<CancellationPolicyViewModelFactory> provider) {
        this.cancellationPolicyViewModelFactoryProvider = provider;
    }

    public static MembersInjector<CancellationPolicyView> create(Provider<CancellationPolicyViewModelFactory> provider) {
        return new CancellationPolicyView_MembersInjector(provider);
    }

    @InjectedFieldSignature("com.talabat.feature.helpcenter.presentation.CancellationPolicyView.cancellationPolicyViewModelFactory")
    public static void injectCancellationPolicyViewModelFactory(CancellationPolicyView cancellationPolicyView, CancellationPolicyViewModelFactory cancellationPolicyViewModelFactory) {
        cancellationPolicyView.cancellationPolicyViewModelFactory = cancellationPolicyViewModelFactory;
    }

    public void injectMembers(CancellationPolicyView cancellationPolicyView) {
        injectCancellationPolicyViewModelFactory(cancellationPolicyView, this.cancellationPolicyViewModelFactoryProvider.get());
    }
}
