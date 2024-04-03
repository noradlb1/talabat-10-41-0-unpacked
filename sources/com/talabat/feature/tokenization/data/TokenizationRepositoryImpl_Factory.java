package com.talabat.feature.tokenization.data;

import com.talabat.feature.tokenization.data.datasource.CheckoutTokenizationDataSource;
import com.talabat.feature.tokenization.data.datasource.RemoteTokenizationDataSource;
import com.talabat.feature.tokenization.data.mapper.TokenizationPublicKeyMapper;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
public final class TokenizationRepositoryImpl_Factory implements Factory<TokenizationRepositoryImpl> {
    private final Provider<CheckoutTokenizationDataSource> checkoutDataSourceProvider;
    private final Provider<TokenizationPublicKeyMapper> publicKeyMapperProvider;
    private final Provider<RemoteTokenizationDataSource> remoteDataSourceProvider;

    public TokenizationRepositoryImpl_Factory(Provider<RemoteTokenizationDataSource> provider, Provider<CheckoutTokenizationDataSource> provider2, Provider<TokenizationPublicKeyMapper> provider3) {
        this.remoteDataSourceProvider = provider;
        this.checkoutDataSourceProvider = provider2;
        this.publicKeyMapperProvider = provider3;
    }

    public static TokenizationRepositoryImpl_Factory create(Provider<RemoteTokenizationDataSource> provider, Provider<CheckoutTokenizationDataSource> provider2, Provider<TokenizationPublicKeyMapper> provider3) {
        return new TokenizationRepositoryImpl_Factory(provider, provider2, provider3);
    }

    public static TokenizationRepositoryImpl newInstance(RemoteTokenizationDataSource remoteTokenizationDataSource, CheckoutTokenizationDataSource checkoutTokenizationDataSource, TokenizationPublicKeyMapper tokenizationPublicKeyMapper) {
        return new TokenizationRepositoryImpl(remoteTokenizationDataSource, checkoutTokenizationDataSource, tokenizationPublicKeyMapper);
    }

    public TokenizationRepositoryImpl get() {
        return newInstance(this.remoteDataSourceProvider.get(), this.checkoutDataSourceProvider.get(), this.publicKeyMapperProvider.get());
    }
}
