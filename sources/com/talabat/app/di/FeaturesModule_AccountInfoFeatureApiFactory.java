package com.talabat.app.di;

import com.talabat.core.di.Api;
import com.talabat.feature.ulaccountinfo.domain.AccountInfoFeatureApi;
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
public final class FeaturesModule_AccountInfoFeatureApiFactory implements Factory<AccountInfoFeatureApi> {
    private final Provider<Map<Class<?>, Api>> coreApisProvider;

    public FeaturesModule_AccountInfoFeatureApiFactory(Provider<Map<Class<?>, Api>> provider) {
        this.coreApisProvider = provider;
    }

    public static AccountInfoFeatureApi accountInfoFeatureApi(Map<Class<?>, Api> map) {
        return (AccountInfoFeatureApi) Preconditions.checkNotNullFromProvides(FeaturesModule.INSTANCE.accountInfoFeatureApi(map));
    }

    public static FeaturesModule_AccountInfoFeatureApiFactory create(Provider<Map<Class<?>, Api>> provider) {
        return new FeaturesModule_AccountInfoFeatureApiFactory(provider);
    }

    public AccountInfoFeatureApi get() {
        return accountInfoFeatureApi(this.coreApisProvider.get());
    }
}
