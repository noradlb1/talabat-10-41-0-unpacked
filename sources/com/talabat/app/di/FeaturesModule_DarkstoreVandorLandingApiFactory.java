package com.talabat.app.di;

import com.talabat.core.di.Api;
import com.talabat.feature.darkstores.vendorlanding.domain.VendorLandingFeatureApi;
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
public final class FeaturesModule_DarkstoreVandorLandingApiFactory implements Factory<VendorLandingFeatureApi> {
    private final Provider<Map<Class<?>, Api>> coreApisProvider;

    public FeaturesModule_DarkstoreVandorLandingApiFactory(Provider<Map<Class<?>, Api>> provider) {
        this.coreApisProvider = provider;
    }

    public static FeaturesModule_DarkstoreVandorLandingApiFactory create(Provider<Map<Class<?>, Api>> provider) {
        return new FeaturesModule_DarkstoreVandorLandingApiFactory(provider);
    }

    public static VendorLandingFeatureApi darkstoreVandorLandingApi(Map<Class<?>, Api> map) {
        return (VendorLandingFeatureApi) Preconditions.checkNotNullFromProvides(FeaturesModule.INSTANCE.darkstoreVandorLandingApi(map));
    }

    public VendorLandingFeatureApi get() {
        return darkstoreVandorLandingApi(this.coreApisProvider.get());
    }
}
