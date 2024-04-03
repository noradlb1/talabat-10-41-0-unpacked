package com.talabat.configuration.payment.mapper;

import com.talabat.configuration.location.LocationConfigurationRepository;
import com.talabat.core.featureflag.domain.ITalabatFeatureFlag;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;

@ScopeMetadata("dagger.Reusable")
@DaggerGenerated
@QualifierMetadata
public final class WalletConfigMapper_Factory implements Factory<WalletConfigMapper> {
    private final Provider<ITalabatFeatureFlag> featureFlagsProvider;
    private final Provider<LocationConfigurationRepository> locationConfigurationRepositoryProvider;
    private final Provider<TokenizedBankCardMapper> tokenizedBankCardMapperProvider;

    public WalletConfigMapper_Factory(Provider<ITalabatFeatureFlag> provider, Provider<LocationConfigurationRepository> provider2, Provider<TokenizedBankCardMapper> provider3) {
        this.featureFlagsProvider = provider;
        this.locationConfigurationRepositoryProvider = provider2;
        this.tokenizedBankCardMapperProvider = provider3;
    }

    public static WalletConfigMapper_Factory create(Provider<ITalabatFeatureFlag> provider, Provider<LocationConfigurationRepository> provider2, Provider<TokenizedBankCardMapper> provider3) {
        return new WalletConfigMapper_Factory(provider, provider2, provider3);
    }

    public static WalletConfigMapper newInstance(ITalabatFeatureFlag iTalabatFeatureFlag, LocationConfigurationRepository locationConfigurationRepository, TokenizedBankCardMapper tokenizedBankCardMapper) {
        return new WalletConfigMapper(iTalabatFeatureFlag, locationConfigurationRepository, tokenizedBankCardMapper);
    }

    public WalletConfigMapper get() {
        return newInstance(this.featureFlagsProvider.get(), this.locationConfigurationRepositoryProvider.get(), this.tokenizedBankCardMapperProvider.get());
    }
}
