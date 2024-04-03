package com.talabat.app.di;

import com.talabat.core.di.Api;
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
public final class FeaturesModule_DarkstoresCartApiFactory implements Factory<DarkstoresCartApi> {
    private final Provider<Map<Class<?>, Api>> coreApisProvider;

    public FeaturesModule_DarkstoresCartApiFactory(Provider<Map<Class<?>, Api>> provider) {
        this.coreApisProvider = provider;
    }

    public static FeaturesModule_DarkstoresCartApiFactory create(Provider<Map<Class<?>, Api>> provider) {
        return new FeaturesModule_DarkstoresCartApiFactory(provider);
    }

    public static DarkstoresCartApi darkstoresCartApi(Map<Class<?>, Api> map) {
        return (DarkstoresCartApi) Preconditions.checkNotNullFromProvides(FeaturesModule.INSTANCE.darkstoresCartApi(map));
    }

    public DarkstoresCartApi get() {
        return darkstoresCartApi(this.coreApisProvider.get());
    }
}
