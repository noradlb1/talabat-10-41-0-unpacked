package com.talabat.splash.domain.usecase;

import android.content.Context;
import buisnessmodels.Customer;
import com.talabat.authentication.authenticate.domain.repository.AuthenticationRepository;
import com.talabat.authentication.token.domain.repository.ClearOwinUseCase;
import com.talabat.authentication.token.domain.repository.TokenRepository;
import com.talabat.authentication.usecase.MigrationExchangeObservabilityUseCase;
import com.talabat.core.dispatcher.domain.CoroutineDispatchersFactory;
import com.talabat.core.featureflag.domain.ITalabatFeatureFlag;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
public final class GetAuthenticationTokenUseCase_Factory implements Factory<GetAuthenticationTokenUseCase> {
    private final Provider<AuthenticationRepository> authenticationRepositoryProvider;
    private final Provider<ClearOwinUseCase> clearOwinUseCaseProvider;
    private final Provider<Context> contextProvider;
    private final Provider<Customer> customerProvider;
    private final Provider<CoroutineDispatchersFactory> dispatchersFactoryProvider;
    private final Provider<ITalabatFeatureFlag> featureFlagProvider;
    private final Provider<MigrationExchangeObservabilityUseCase> migrationExchangeObservabilityUseCaseProvider;
    private final Provider<TokenRepository> tokenRepositoryProvider;

    public GetAuthenticationTokenUseCase_Factory(Provider<Context> provider, Provider<Customer> provider2, Provider<ClearOwinUseCase> provider3, Provider<CoroutineDispatchersFactory> provider4, Provider<ITalabatFeatureFlag> provider5, Provider<AuthenticationRepository> provider6, Provider<MigrationExchangeObservabilityUseCase> provider7, Provider<TokenRepository> provider8) {
        this.contextProvider = provider;
        this.customerProvider = provider2;
        this.clearOwinUseCaseProvider = provider3;
        this.dispatchersFactoryProvider = provider4;
        this.featureFlagProvider = provider5;
        this.authenticationRepositoryProvider = provider6;
        this.migrationExchangeObservabilityUseCaseProvider = provider7;
        this.tokenRepositoryProvider = provider8;
    }

    public static GetAuthenticationTokenUseCase_Factory create(Provider<Context> provider, Provider<Customer> provider2, Provider<ClearOwinUseCase> provider3, Provider<CoroutineDispatchersFactory> provider4, Provider<ITalabatFeatureFlag> provider5, Provider<AuthenticationRepository> provider6, Provider<MigrationExchangeObservabilityUseCase> provider7, Provider<TokenRepository> provider8) {
        return new GetAuthenticationTokenUseCase_Factory(provider, provider2, provider3, provider4, provider5, provider6, provider7, provider8);
    }

    public static GetAuthenticationTokenUseCase newInstance(Context context, Customer customer, ClearOwinUseCase clearOwinUseCase, CoroutineDispatchersFactory coroutineDispatchersFactory, ITalabatFeatureFlag iTalabatFeatureFlag, AuthenticationRepository authenticationRepository, MigrationExchangeObservabilityUseCase migrationExchangeObservabilityUseCase, TokenRepository tokenRepository) {
        return new GetAuthenticationTokenUseCase(context, customer, clearOwinUseCase, coroutineDispatchersFactory, iTalabatFeatureFlag, authenticationRepository, migrationExchangeObservabilityUseCase, tokenRepository);
    }

    public GetAuthenticationTokenUseCase get() {
        return newInstance(this.contextProvider.get(), this.customerProvider.get(), this.clearOwinUseCaseProvider.get(), this.dispatchersFactoryProvider.get(), this.featureFlagProvider.get(), this.authenticationRepositoryProvider.get(), this.migrationExchangeObservabilityUseCaseProvider.get(), this.tokenRepositoryProvider.get());
    }
}
