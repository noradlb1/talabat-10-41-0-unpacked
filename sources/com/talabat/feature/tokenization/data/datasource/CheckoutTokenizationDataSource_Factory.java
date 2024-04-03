package com.talabat.feature.tokenization.data.datasource;

import android.content.Context;
import com.talabat.feature.tokenization.data.mapper.NonEnglishNumbersMapper;
import com.talabat.feature.tokenization.data.provider.CheckoutApiClientProvider;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;

@ScopeMetadata("dagger.Reusable")
@DaggerGenerated
@QualifierMetadata
public final class CheckoutTokenizationDataSource_Factory implements Factory<CheckoutTokenizationDataSource> {
    private final Provider<CheckoutApiClientProvider> checkoutApiClientProvider;
    private final Provider<Context> contextProvider;
    private final Provider<NonEnglishNumbersMapper> nonEnglishNumbersMapperProvider;

    public CheckoutTokenizationDataSource_Factory(Provider<CheckoutApiClientProvider> provider, Provider<NonEnglishNumbersMapper> provider2, Provider<Context> provider3) {
        this.checkoutApiClientProvider = provider;
        this.nonEnglishNumbersMapperProvider = provider2;
        this.contextProvider = provider3;
    }

    public static CheckoutTokenizationDataSource_Factory create(Provider<CheckoutApiClientProvider> provider, Provider<NonEnglishNumbersMapper> provider2, Provider<Context> provider3) {
        return new CheckoutTokenizationDataSource_Factory(provider, provider2, provider3);
    }

    public static CheckoutTokenizationDataSource newInstance(CheckoutApiClientProvider checkoutApiClientProvider2, NonEnglishNumbersMapper nonEnglishNumbersMapper, Context context) {
        return new CheckoutTokenizationDataSource(checkoutApiClientProvider2, nonEnglishNumbersMapper, context);
    }

    public CheckoutTokenizationDataSource get() {
        return newInstance(this.checkoutApiClientProvider.get(), this.nonEnglishNumbersMapperProvider.get(), this.contextProvider.get());
    }
}
