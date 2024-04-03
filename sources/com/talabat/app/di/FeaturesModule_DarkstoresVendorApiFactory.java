package com.talabat.app.di;

import com.talabat.core.di.Api;
import com.talabat.feature.darkstoresvendor.domain.DarkstoresVendorApi;
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
public final class FeaturesModule_DarkstoresVendorApiFactory implements Factory<DarkstoresVendorApi> {
    private final Provider<Map<Class<?>, Api>> coreApisProvider;

    public FeaturesModule_DarkstoresVendorApiFactory(Provider<Map<Class<?>, Api>> provider) {
        this.coreApisProvider = provider;
    }

    public static FeaturesModule_DarkstoresVendorApiFactory create(Provider<Map<Class<?>, Api>> provider) {
        return new FeaturesModule_DarkstoresVendorApiFactory(provider);
    }

    public static DarkstoresVendorApi darkstoresVendorApi(Map<Class<?>, Api> map) {
        return (DarkstoresVendorApi) Preconditions.checkNotNullFromProvides(FeaturesModule.INSTANCE.darkstoresVendorApi(map));
    }

    public DarkstoresVendorApi get() {
        return darkstoresVendorApi(this.coreApisProvider.get());
    }
}
