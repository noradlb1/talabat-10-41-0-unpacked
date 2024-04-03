package com.talabat.app.di;

import com.talabat.core.di.Api;
import com.talabat.domain.address.di.AddressFeatureApi;
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
public final class FeaturesModule_AddressFeatureApiFactory implements Factory<AddressFeatureApi> {
    private final Provider<Map<Class<?>, Api>> coreApisProvider;

    public FeaturesModule_AddressFeatureApiFactory(Provider<Map<Class<?>, Api>> provider) {
        this.coreApisProvider = provider;
    }

    public static AddressFeatureApi addressFeatureApi(Map<Class<?>, Api> map) {
        return (AddressFeatureApi) Preconditions.checkNotNullFromProvides(FeaturesModule.INSTANCE.addressFeatureApi(map));
    }

    public static FeaturesModule_AddressFeatureApiFactory create(Provider<Map<Class<?>, Api>> provider) {
        return new FeaturesModule_AddressFeatureApiFactory(provider);
    }

    public AddressFeatureApi get() {
        return addressFeatureApi(this.coreApisProvider.get());
    }
}
