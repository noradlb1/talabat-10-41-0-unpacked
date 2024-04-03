package com.talabat.customer.data;

import android.content.Context;
import buisnessmodels.Customer;
import com.talabat.customer.data.convert.TokenizedBankCardMapper;
import com.talabat.customer.data.convert.TokenizedCreditCardMapper;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
public final class LegacyCustomerRepository_Factory implements Factory<LegacyCustomerRepository> {
    private final Provider<Context> contextProvider;
    private final Provider<Customer> customerProvider;
    private final Provider<TokenizedBankCardMapper> tokenizedBankCardMapperProvider;
    private final Provider<TokenizedCreditCardMapper> tokenizedCreditCardMapperProvider;

    public LegacyCustomerRepository_Factory(Provider<Context> provider, Provider<TokenizedBankCardMapper> provider2, Provider<TokenizedCreditCardMapper> provider3, Provider<Customer> provider4) {
        this.contextProvider = provider;
        this.tokenizedBankCardMapperProvider = provider2;
        this.tokenizedCreditCardMapperProvider = provider3;
        this.customerProvider = provider4;
    }

    public static LegacyCustomerRepository_Factory create(Provider<Context> provider, Provider<TokenizedBankCardMapper> provider2, Provider<TokenizedCreditCardMapper> provider3, Provider<Customer> provider4) {
        return new LegacyCustomerRepository_Factory(provider, provider2, provider3, provider4);
    }

    public static LegacyCustomerRepository newInstance(Context context, TokenizedBankCardMapper tokenizedBankCardMapper, TokenizedCreditCardMapper tokenizedCreditCardMapper, Customer customer) {
        return new LegacyCustomerRepository(context, tokenizedBankCardMapper, tokenizedCreditCardMapper, customer);
    }

    public LegacyCustomerRepository get() {
        return newInstance(this.contextProvider.get(), this.tokenizedBankCardMapperProvider.get(), this.tokenizedCreditCardMapperProvider.get(), this.customerProvider.get());
    }
}
