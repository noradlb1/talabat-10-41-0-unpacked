package com.talabat.app.di;

import com.talabat.core.di.Api;
import com.talabat.feature.tokenization.domain.TokenizationFeatureApi;
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
public final class FeaturesModule_TokenizationFeatureApiFactory implements Factory<TokenizationFeatureApi> {
    private final Provider<Map<Class<?>, Api>> coreApisProvider;

    public FeaturesModule_TokenizationFeatureApiFactory(Provider<Map<Class<?>, Api>> provider) {
        this.coreApisProvider = provider;
    }

    public static FeaturesModule_TokenizationFeatureApiFactory create(Provider<Map<Class<?>, Api>> provider) {
        return new FeaturesModule_TokenizationFeatureApiFactory(provider);
    }

    public static TokenizationFeatureApi tokenizationFeatureApi(Map<Class<?>, Api> map) {
        return (TokenizationFeatureApi) Preconditions.checkNotNullFromProvides(FeaturesModule.INSTANCE.tokenizationFeatureApi(map));
    }

    public TokenizationFeatureApi get() {
        return tokenizationFeatureApi(this.coreApisProvider.get());
    }
}
