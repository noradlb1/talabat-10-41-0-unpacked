package com.talabat.app.di;

import com.talabat.core.di.Api;
import com.talabat.feature.walletcobrandedcc.domain.WalletCobrandedCcFeatureApi;
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
public final class FeaturesModule_WalletCobrandedCcFeatureApiFactory implements Factory<WalletCobrandedCcFeatureApi> {
    private final Provider<Map<Class<?>, Api>> coreApisProvider;

    public FeaturesModule_WalletCobrandedCcFeatureApiFactory(Provider<Map<Class<?>, Api>> provider) {
        this.coreApisProvider = provider;
    }

    public static FeaturesModule_WalletCobrandedCcFeatureApiFactory create(Provider<Map<Class<?>, Api>> provider) {
        return new FeaturesModule_WalletCobrandedCcFeatureApiFactory(provider);
    }

    public static WalletCobrandedCcFeatureApi walletCobrandedCcFeatureApi(Map<Class<?>, Api> map) {
        return (WalletCobrandedCcFeatureApi) Preconditions.checkNotNullFromProvides(FeaturesModule.INSTANCE.walletCobrandedCcFeatureApi(map));
    }

    public WalletCobrandedCcFeatureApi get() {
        return walletCobrandedCcFeatureApi(this.coreApisProvider.get());
    }
}
