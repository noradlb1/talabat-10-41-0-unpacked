package com.talabat.splash.domain.model;

import android.content.Context;
import buisnessmodels.Customer;
import buisnessmodels.mappers.TokenizedBankCardToOldTokenizedBankCardMapper;
import com.talabat.configuration.payment.PaymentConfigurationRepository;
import com.talabat.core.featureflag.domain.ITalabatFeatureFlag;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import io.reactivex.functions.Function;
import javax.inject.Provider;
import kotlin.Unit;

@ScopeMetadata("javax.inject.Singleton")
@DaggerGenerated
@QualifierMetadata
public final class AppInfoGlobalCustomerWrapper_Factory implements Factory<AppInfoGlobalCustomerWrapper> {
    private final Provider<Context> contextProvider;
    private final Provider<Customer> customerProvider;
    private final Provider<ITalabatFeatureFlag> featureFlagsProvider;
    private final Provider<PaymentConfigurationRepository> paymentConfigurationRepositoryProvider;
    private final Provider<Function<String, Unit>> setPilotUserProvider;
    private final Provider<TokenizedBankCardToOldTokenizedBankCardMapper> tokenizedBankCardToOldTokenizedBankCardMapperProvider;

    public AppInfoGlobalCustomerWrapper_Factory(Provider<Context> provider, Provider<Customer> provider2, Provider<Function<String, Unit>> provider3, Provider<PaymentConfigurationRepository> provider4, Provider<TokenizedBankCardToOldTokenizedBankCardMapper> provider5, Provider<ITalabatFeatureFlag> provider6) {
        this.contextProvider = provider;
        this.customerProvider = provider2;
        this.setPilotUserProvider = provider3;
        this.paymentConfigurationRepositoryProvider = provider4;
        this.tokenizedBankCardToOldTokenizedBankCardMapperProvider = provider5;
        this.featureFlagsProvider = provider6;
    }

    public static AppInfoGlobalCustomerWrapper_Factory create(Provider<Context> provider, Provider<Customer> provider2, Provider<Function<String, Unit>> provider3, Provider<PaymentConfigurationRepository> provider4, Provider<TokenizedBankCardToOldTokenizedBankCardMapper> provider5, Provider<ITalabatFeatureFlag> provider6) {
        return new AppInfoGlobalCustomerWrapper_Factory(provider, provider2, provider3, provider4, provider5, provider6);
    }

    public static AppInfoGlobalCustomerWrapper newInstance(Context context, Customer customer, Function<String, Unit> function, PaymentConfigurationRepository paymentConfigurationRepository, TokenizedBankCardToOldTokenizedBankCardMapper tokenizedBankCardToOldTokenizedBankCardMapper, ITalabatFeatureFlag iTalabatFeatureFlag) {
        return new AppInfoGlobalCustomerWrapper(context, customer, function, paymentConfigurationRepository, tokenizedBankCardToOldTokenizedBankCardMapper, iTalabatFeatureFlag);
    }

    public AppInfoGlobalCustomerWrapper get() {
        return newInstance(this.contextProvider.get(), this.customerProvider.get(), this.setPilotUserProvider.get(), this.paymentConfigurationRepositoryProvider.get(), this.tokenizedBankCardToOldTokenizedBankCardMapperProvider.get(), this.featureFlagsProvider.get());
    }
}
