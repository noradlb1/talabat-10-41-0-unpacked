package com.talabat.authentication.authenticate.domain.repository;

import com.talabat.authentication.authenticate.domain.repository.ExchangeOwinTokenToAAATokenUseCase;
import com.talabat.authentication.token.domain.repository.ClearOwinUseCase;
import com.talabat.authentication.token.domain.repository.TokenRepository;
import com.talabat.authentication.usecase.MigrationExchangeObservabilityUseCase;
import com.talabat.core.dispatcher.domain.CoroutineDispatchersFactory;
import com.talabat.core.featureflag.domain.ITalabatFeatureFlag;
import com.talabat.core.fwfprojectskeys.domain.projects.user.UserFeatureFlagsKeys;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
public final class ExchangeOwinTokenToAAATokenUseCase_Factory implements Factory<ExchangeOwinTokenToAAATokenUseCase> {
    private final Provider<AuthenticationRepository> authenticationRepositoryProvider;
    private final Provider<ClearOwinUseCase> clearOwinUseCaseProvider;
    private final Provider<CoroutineDispatchersFactory> dispatchersFactoryProvider;
    private final Provider<UserFeatureFlagsKeys> enableFeatureFlagProvider;
    private final Provider<ITalabatFeatureFlag> featureFlagProvider;
    private final Provider<ExchangeOwinTokenToAAATokenUseCase.IsGdmOwinAvailable> isGdmTokenAvailableProvider;
    private final Provider<MigrationExchangeObservabilityUseCase> migrationExchangeObservabilityUseCaseProvider;
    private final Provider<TokenRepository> tokenRepositoryProvider;

    public ExchangeOwinTokenToAAATokenUseCase_Factory(Provider<ClearOwinUseCase> provider, Provider<CoroutineDispatchersFactory> provider2, Provider<ITalabatFeatureFlag> provider3, Provider<AuthenticationRepository> provider4, Provider<MigrationExchangeObservabilityUseCase> provider5, Provider<UserFeatureFlagsKeys> provider6, Provider<TokenRepository> provider7, Provider<ExchangeOwinTokenToAAATokenUseCase.IsGdmOwinAvailable> provider8) {
        this.clearOwinUseCaseProvider = provider;
        this.dispatchersFactoryProvider = provider2;
        this.featureFlagProvider = provider3;
        this.authenticationRepositoryProvider = provider4;
        this.migrationExchangeObservabilityUseCaseProvider = provider5;
        this.enableFeatureFlagProvider = provider6;
        this.tokenRepositoryProvider = provider7;
        this.isGdmTokenAvailableProvider = provider8;
    }

    public static ExchangeOwinTokenToAAATokenUseCase_Factory create(Provider<ClearOwinUseCase> provider, Provider<CoroutineDispatchersFactory> provider2, Provider<ITalabatFeatureFlag> provider3, Provider<AuthenticationRepository> provider4, Provider<MigrationExchangeObservabilityUseCase> provider5, Provider<UserFeatureFlagsKeys> provider6, Provider<TokenRepository> provider7, Provider<ExchangeOwinTokenToAAATokenUseCase.IsGdmOwinAvailable> provider8) {
        return new ExchangeOwinTokenToAAATokenUseCase_Factory(provider, provider2, provider3, provider4, provider5, provider6, provider7, provider8);
    }

    public static ExchangeOwinTokenToAAATokenUseCase newInstance(ClearOwinUseCase clearOwinUseCase, CoroutineDispatchersFactory coroutineDispatchersFactory, ITalabatFeatureFlag iTalabatFeatureFlag, AuthenticationRepository authenticationRepository, MigrationExchangeObservabilityUseCase migrationExchangeObservabilityUseCase, UserFeatureFlagsKeys userFeatureFlagsKeys, TokenRepository tokenRepository, ExchangeOwinTokenToAAATokenUseCase.IsGdmOwinAvailable isGdmOwinAvailable) {
        return new ExchangeOwinTokenToAAATokenUseCase(clearOwinUseCase, coroutineDispatchersFactory, iTalabatFeatureFlag, authenticationRepository, migrationExchangeObservabilityUseCase, userFeatureFlagsKeys, tokenRepository, isGdmOwinAvailable);
    }

    public ExchangeOwinTokenToAAATokenUseCase get() {
        return newInstance(this.clearOwinUseCaseProvider.get(), this.dispatchersFactoryProvider.get(), this.featureFlagProvider.get(), this.authenticationRepositoryProvider.get(), this.migrationExchangeObservabilityUseCaseProvider.get(), this.enableFeatureFlagProvider.get(), this.tokenRepositoryProvider.get(), this.isGdmTokenAvailableProvider.get());
    }
}
