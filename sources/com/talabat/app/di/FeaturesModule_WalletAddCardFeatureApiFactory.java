package com.talabat.app.di;

import com.talabat.core.di.Api;
import com.talabat.feature.tokenization.domain.TokenizationFeatureApi;
import com.talabat.feature.walletaddcard.domain.WalletAddCardFeatureApi;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import java.util.Map;
import javax.inject.Provider;

@ScopeMetadata("dagger.Reusable")
@DaggerGenerated
@QualifierMetadata({"com.talabat.app.di.CoreApis"})
public final class FeaturesModule_WalletAddCardFeatureApiFactory implements Factory<WalletAddCardFeatureApi> {
    private final Provider<Map<Class<?>, Api>> coreApisProvider;
    private final Provider<TokenizationFeatureApi> tokenizationFeatureApiProvider;

    public FeaturesModule_WalletAddCardFeatureApiFactory(Provider<Map<Class<?>, Api>> provider, Provider<TokenizationFeatureApi> provider2) {
        this.coreApisProvider = provider;
        this.tokenizationFeatureApiProvider = provider2;
    }

    public static FeaturesModule_WalletAddCardFeatureApiFactory create(Provider<Map<Class<?>, Api>> provider, Provider<TokenizationFeatureApi> provider2) {
        return new FeaturesModule_WalletAddCardFeatureApiFactory(provider, provider2);
    }

    public static WalletAddCardFeatureApi walletAddCardFeatureApi(Map<Class<?>, Api> map, TokenizationFeatureApi tokenizationFeatureApi) {
        return (WalletAddCardFeatureApi) Preconditions.checkNotNullFromProvides(FeaturesModule.INSTANCE.walletAddCardFeatureApi(map, tokenizationFeatureApi));
    }

    public WalletAddCardFeatureApi get() {
        return walletAddCardFeatureApi(this.coreApisProvider.get(), this.tokenizationFeatureApiProvider.get());
    }
}
