package com.talabat.userandlocation.login.ui.fragment;

import com.talabat.authentication.token.domain.repository.TokenRepository;
import com.talabat.core.observabilityNew.domain.IObservabilityManager;
import dagger.MembersInjector;
import dagger.internal.DaggerGenerated;
import dagger.internal.InjectedFieldSignature;
import dagger.internal.QualifierMetadata;
import javax.inject.Provider;

@QualifierMetadata
@DaggerGenerated
public final class EnterEmailFragment_MembersInjector implements MembersInjector<EnterEmailFragment> {
    private final Provider<IObservabilityManager> observabilityManagerProvider;
    private final Provider<TokenRepository> tokenRepositoryProvider;

    public EnterEmailFragment_MembersInjector(Provider<IObservabilityManager> provider, Provider<TokenRepository> provider2) {
        this.observabilityManagerProvider = provider;
        this.tokenRepositoryProvider = provider2;
    }

    public static MembersInjector<EnterEmailFragment> create(Provider<IObservabilityManager> provider, Provider<TokenRepository> provider2) {
        return new EnterEmailFragment_MembersInjector(provider, provider2);
    }

    @InjectedFieldSignature("com.talabat.userandlocation.login.ui.fragment.EnterEmailFragment.observabilityManager")
    public static void injectObservabilityManager(EnterEmailFragment enterEmailFragment, IObservabilityManager iObservabilityManager) {
        enterEmailFragment.observabilityManager = iObservabilityManager;
    }

    @InjectedFieldSignature("com.talabat.userandlocation.login.ui.fragment.EnterEmailFragment.tokenRepository")
    public static void injectTokenRepository(EnterEmailFragment enterEmailFragment, TokenRepository tokenRepository) {
        enterEmailFragment.tokenRepository = tokenRepository;
    }

    public void injectMembers(EnterEmailFragment enterEmailFragment) {
        injectObservabilityManager(enterEmailFragment, this.observabilityManagerProvider.get());
        injectTokenRepository(enterEmailFragment, this.tokenRepositoryProvider.get());
    }
}
