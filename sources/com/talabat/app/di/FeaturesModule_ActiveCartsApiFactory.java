package com.talabat.app.di;

import com.talabat.core.di.Api;
import com.talabat.feature.activecarts.domain.di.ActiveCartsApi;
import com.talabat.feature.darkstores.domain.DarkstoresFeatureApi;
import com.talabat.feature.darkstorescartlist.domain.di.DarkstoresCartListApi;
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
public final class FeaturesModule_ActiveCartsApiFactory implements Factory<ActiveCartsApi> {
    private final Provider<Map<Class<?>, Api>> coreApisProvider;
    private final Provider<DarkstoresCartListApi> darkstoresCartListApiProvider;
    private final Provider<DarkstoresFeatureApi> darkstoresFeatureApiProvider;

    public FeaturesModule_ActiveCartsApiFactory(Provider<Map<Class<?>, Api>> provider, Provider<DarkstoresCartListApi> provider2, Provider<DarkstoresFeatureApi> provider3) {
        this.coreApisProvider = provider;
        this.darkstoresCartListApiProvider = provider2;
        this.darkstoresFeatureApiProvider = provider3;
    }

    public static ActiveCartsApi activeCartsApi(Map<Class<?>, Api> map, DarkstoresCartListApi darkstoresCartListApi, DarkstoresFeatureApi darkstoresFeatureApi) {
        return (ActiveCartsApi) Preconditions.checkNotNullFromProvides(FeaturesModule.INSTANCE.activeCartsApi(map, darkstoresCartListApi, darkstoresFeatureApi));
    }

    public static FeaturesModule_ActiveCartsApiFactory create(Provider<Map<Class<?>, Api>> provider, Provider<DarkstoresCartListApi> provider2, Provider<DarkstoresFeatureApi> provider3) {
        return new FeaturesModule_ActiveCartsApiFactory(provider, provider2, provider3);
    }

    public ActiveCartsApi get() {
        return activeCartsApi(this.coreApisProvider.get(), this.darkstoresCartListApiProvider.get(), this.darkstoresFeatureApiProvider.get());
    }
}
