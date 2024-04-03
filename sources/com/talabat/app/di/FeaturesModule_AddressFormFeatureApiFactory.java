package com.talabat.app.di;

import com.talabat.core.di.Api;
import com.talabat.feature.uladdressform.domain.AddressFormFeatureApi;
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
public final class FeaturesModule_AddressFormFeatureApiFactory implements Factory<AddressFormFeatureApi> {
    private final Provider<Map<Class<?>, Api>> coreApisProvider;

    public FeaturesModule_AddressFormFeatureApiFactory(Provider<Map<Class<?>, Api>> provider) {
        this.coreApisProvider = provider;
    }

    public static AddressFormFeatureApi addressFormFeatureApi(Map<Class<?>, Api> map) {
        return (AddressFormFeatureApi) Preconditions.checkNotNullFromProvides(FeaturesModule.INSTANCE.addressFormFeatureApi(map));
    }

    public static FeaturesModule_AddressFormFeatureApiFactory create(Provider<Map<Class<?>, Api>> provider) {
        return new FeaturesModule_AddressFormFeatureApiFactory(provider);
    }

    public AddressFormFeatureApi get() {
        return addressFormFeatureApi(this.coreApisProvider.get());
    }
}
