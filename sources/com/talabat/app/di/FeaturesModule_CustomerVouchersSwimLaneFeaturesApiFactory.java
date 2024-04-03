package com.talabat.app.di;

import com.talabat.core.di.Api;
import com.talabat.features.swimlanevoucherslist.domain.di.CustomerVouchersSwimLaneFeaturesApi;
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
public final class FeaturesModule_CustomerVouchersSwimLaneFeaturesApiFactory implements Factory<CustomerVouchersSwimLaneFeaturesApi> {
    private final Provider<Map<Class<?>, Api>> coreApisProvider;

    public FeaturesModule_CustomerVouchersSwimLaneFeaturesApiFactory(Provider<Map<Class<?>, Api>> provider) {
        this.coreApisProvider = provider;
    }

    public static FeaturesModule_CustomerVouchersSwimLaneFeaturesApiFactory create(Provider<Map<Class<?>, Api>> provider) {
        return new FeaturesModule_CustomerVouchersSwimLaneFeaturesApiFactory(provider);
    }

    public static CustomerVouchersSwimLaneFeaturesApi customerVouchersSwimLaneFeaturesApi(Map<Class<?>, Api> map) {
        return (CustomerVouchersSwimLaneFeaturesApi) Preconditions.checkNotNullFromProvides(FeaturesModule.INSTANCE.customerVouchersSwimLaneFeaturesApi(map));
    }

    public CustomerVouchersSwimLaneFeaturesApi get() {
        return customerVouchersSwimLaneFeaturesApi(this.coreApisProvider.get());
    }
}
