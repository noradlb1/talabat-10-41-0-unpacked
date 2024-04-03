package com.talabat.configuration.payment;

import buisnessmodels.mappers.OldTokenizedBankCardToTokenizedBankCardMapper;
import com.talabat.configuration.AppInfoContainer;
import com.talabat.core.featureflag.domain.ITalabatFeatureFlag;
import com.talabat.core.network.domain.endpoint.BaseUrlFactory;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
public final class LegacyPaymentConfigurationRepository_Factory implements Factory<LegacyPaymentConfigurationRepository> {
    private final Provider<AppInfoContainer> appInfoContainerProvider;
    private final Provider<BaseUrlFactory> baseUrlFactoryProvider;
    private final Provider<ITalabatFeatureFlag> featureFlagsProvider;
    private final Provider<OldTokenizedBankCardToTokenizedBankCardMapper> oldTokenizedBankCardToTokenizedBankCardMapperProvider;
    private final Provider<RealPaymentConfigurationRepository> realRepositoryProvider;

    public LegacyPaymentConfigurationRepository_Factory(Provider<RealPaymentConfigurationRepository> provider, Provider<AppInfoContainer> provider2, Provider<ITalabatFeatureFlag> provider3, Provider<BaseUrlFactory> provider4, Provider<OldTokenizedBankCardToTokenizedBankCardMapper> provider5) {
        this.realRepositoryProvider = provider;
        this.appInfoContainerProvider = provider2;
        this.featureFlagsProvider = provider3;
        this.baseUrlFactoryProvider = provider4;
        this.oldTokenizedBankCardToTokenizedBankCardMapperProvider = provider5;
    }

    public static LegacyPaymentConfigurationRepository_Factory create(Provider<RealPaymentConfigurationRepository> provider, Provider<AppInfoContainer> provider2, Provider<ITalabatFeatureFlag> provider3, Provider<BaseUrlFactory> provider4, Provider<OldTokenizedBankCardToTokenizedBankCardMapper> provider5) {
        return new LegacyPaymentConfigurationRepository_Factory(provider, provider2, provider3, provider4, provider5);
    }

    public static LegacyPaymentConfigurationRepository newInstance(RealPaymentConfigurationRepository realPaymentConfigurationRepository, AppInfoContainer appInfoContainer, ITalabatFeatureFlag iTalabatFeatureFlag, BaseUrlFactory baseUrlFactory, OldTokenizedBankCardToTokenizedBankCardMapper oldTokenizedBankCardToTokenizedBankCardMapper) {
        return new LegacyPaymentConfigurationRepository(realPaymentConfigurationRepository, appInfoContainer, iTalabatFeatureFlag, baseUrlFactory, oldTokenizedBankCardToTokenizedBankCardMapper);
    }

    public LegacyPaymentConfigurationRepository get() {
        return newInstance(this.realRepositoryProvider.get(), this.appInfoContainerProvider.get(), this.featureFlagsProvider.get(), this.baseUrlFactoryProvider.get(), this.oldTokenizedBankCardToTokenizedBankCardMapperProvider.get());
    }
}
