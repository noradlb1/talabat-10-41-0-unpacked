package com.talabat.app.di;

import com.talabat.core.di.Api;
import com.talabat.feature.darkstores.domain.DarkstoresFeatureApi;
import com.talabat.feature.darkstorescart.data.di.DarkstoresCartApi;
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
public final class FeaturesModule_DarkstoresFeatureApiFactory implements Factory<DarkstoresFeatureApi> {
    private final Provider<Map<Class<?>, Api>> coreApisProvider;
    private final Provider<DarkstoresCartApi> darkstoresCartApiProvider;

    public FeaturesModule_DarkstoresFeatureApiFactory(Provider<Map<Class<?>, Api>> provider, Provider<DarkstoresCartApi> provider2) {
        this.coreApisProvider = provider;
        this.darkstoresCartApiProvider = provider2;
    }

    public static FeaturesModule_DarkstoresFeatureApiFactory create(Provider<Map<Class<?>, Api>> provider, Provider<DarkstoresCartApi> provider2) {
        return new FeaturesModule_DarkstoresFeatureApiFactory(provider, provider2);
    }

    public static DarkstoresFeatureApi darkstoresFeatureApi(Map<Class<?>, Api> map, DarkstoresCartApi darkstoresCartApi) {
        return (DarkstoresFeatureApi) Preconditions.checkNotNullFromProvides(FeaturesModule.INSTANCE.darkstoresFeatureApi(map, darkstoresCartApi));
    }

    public DarkstoresFeatureApi get() {
        return darkstoresFeatureApi(this.coreApisProvider.get(), this.darkstoresCartApiProvider.get());
    }
}
